package com.radebit.intbarsys.controller;

import cn.hutool.core.lang.Assert;
import cn.hutool.crypto.SecureUtil;
import com.alibaba.fastjson.JSON;
import com.radebit.intbarsys.domain.JsonData;
import com.radebit.intbarsys.model.po.Admin;
import com.radebit.intbarsys.model.vo.AdminVO;
import com.radebit.intbarsys.service.AdminService;
import com.radebit.intbarsys.utils.ConstantKit;
import com.radebit.intbarsys.utils.IPUtils;
import com.radebit.intbarsys.utils.Md5TokenGenerator;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @Author Rade
 * @Date 2019-09-30 23:19
 * 说明：管理员模块
 */
@Api(value = "管理员后台模块")
@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    Md5TokenGenerator tokenGenerator;

    /**
     * 管理员登录
     * @param username
     * @param password
     * @param request
     * @return
     */
    @PostMapping("adminLogin")
    public JsonData adminLogin(@RequestParam(value = "username",required = true) String username,
                               @RequestParam(value = "password",required = true) String password,
                               HttpServletRequest request){
        Assert.notBlank(username);
        Assert.notBlank(password);
        boolean isCheck = adminService.checkPassword(username, password);
        if (isCheck){
            Admin admin = adminService.findAdminByUsername(username);
            //Token登录鉴权
            Jedis jedis = new Jedis("127.0.0.1", 6379);
            String token = tokenGenerator.generate(username, password);
            jedis.set(username, token);
            //设置key生存时间，当key过期时，它会被自动删除，时间是秒
            jedis.expire(username, ConstantKit.TOKEN_EXPIRE_TIME);
            jedis.set(token, username);
            jedis.expire(token, ConstantKit.TOKEN_EXPIRE_TIME);
            Long currentTime = System.currentTimeMillis();
            jedis.set(token + username, currentTime.toString());

            //用完关闭
            jedis.close();

            admin.setLastLoginTime(new Timestamp(new Date().getTime()));
            admin.setLastLoginIp(IPUtils.getIpAddr(request));
            adminService.update(admin);
            AdminVO adminVO = PoToVo(admin, token);
            return JsonData.buildSuccess(JSON.toJSON(adminVO),0,"登录成功！");
        }else {
            return JsonData.buildError("账号或密码错误！",-1);
        }

    }

    /**
     * 新增管理员
     * @param username
     * @param password
     * @param request
     * @return
     */
    @PostMapping("addAdmin")
    public JsonData addAdmin(@RequestParam(value = "username",required = true) String username,
                               @RequestParam(value = "password",required = true) String password,
                               HttpServletRequest request){
        Assert.notBlank(username);
        Assert.notBlank(password);
        if (adminService.findAdminByUsername(username)!=null){
            return JsonData.buildError("管理员已存在！",301);
        }
        Admin admin = new Admin();
        admin.setUsername(username);
        admin.setPassword(SecureUtil.md5(password));
        admin.setLastLoginTime(new Timestamp(new Date().getTime()));
        admin.setLastLoginIp(IPUtils.getIpAddr(request));
        Integer state = adminService.save(admin);
        if (state == 1){
            return JsonData.buildSuccess(admin,"创建管理员成功！");
        }
        return JsonData.buildError("创建失败！",300);

    }

    /**
     * 删除管理员
     * @param id
     * @return
     */
    @DeleteMapping("delAdmin")
    public JsonData deleteAdmin(@RequestParam(value = "id",required = true) int id){
        Assert.notNull(id);
        if (id == 1){
            return JsonData.buildError("请勿删除超级管理员！",500);
        }
        if (adminService.delete(id)==1){
            return JsonData.buildSuccess(null,"删除成功！");
        }
        return JsonData.buildError("删除失败！",300);
    }

    /**
     * 更新管理员信息
     * @param oldUsername
     * @param oldPassword
     * @param newUsername
     * @param newPassword
     * @return
     */
    @PutMapping("updateAdmin")
    public JsonData updateAdmin(@RequestParam(value = "oldUsername",required = true) String oldUsername,
                                @RequestParam(value = "oldPassword",required = true) String oldPassword,
                                @RequestParam(value = "newUsername",required = true) String newUsername,
                                @RequestParam(value = "newPassword",required = true) String newPassword){
        Assert.notBlank(oldUsername);
        Assert.notBlank(oldPassword);
        Assert.notBlank(newUsername);
        Assert.notBlank(newPassword);

        Admin admin = adminService.findAdminByUsername(oldUsername);

        if (admin==null){
            return JsonData.buildError("管理员不存在！",301);
        }
        if (!SecureUtil.md5(oldPassword).equals(adminService.findPasswordByUsername(oldUsername))){
            return JsonData.buildError("原始密码不匹配",302);
        }

        admin.setUsername(newUsername);
        admin.setPassword(SecureUtil.md5(newPassword));

        Integer state = adminService.update(admin);
        if (state == 1){
            return JsonData.buildSuccess(admin,"编辑成功！");
        }
        return JsonData.buildError("编辑失败！",300);

    }

    /**
     * PoToVo
     * @param admin
     * @param token
     * @return
     */
    public AdminVO PoToVo(Admin admin,String token){
        AdminVO adminVO = new AdminVO();
        adminVO.setId(admin.getId());
        adminVO.setUsername(admin.getUsername());
        adminVO.setPassword(admin.getPassword());
        adminVO.setLastLoginTime(String.valueOf(admin.getLastLoginTime()));
        adminVO.setLastLoginIp(admin.getLastLoginIp());
        adminVO.setToken(token);
        adminVO.setAdditional(null);
        return adminVO;

    }
}
