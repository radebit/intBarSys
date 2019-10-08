package com.radebit.intbarsys.controller;

import cn.hutool.core.lang.Assert;
import com.alibaba.fastjson.JSON;
import com.radebit.intbarsys.domain.JsonData;
import com.radebit.intbarsys.model.po.Admin;
import com.radebit.intbarsys.model.vo.AdminVO;
import com.radebit.intbarsys.service.AdminService;
import com.radebit.intbarsys.utils.IPUtils;
import com.radebit.intbarsys.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @Author Rade
 * @Date 2019-09-30 23:19
 * 说明：
 */
@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("adminLogin")
    public JsonData adminLogin(@RequestParam String username,
                               @RequestParam String password,
                               HttpServletRequest request){
        Assert.notBlank(username);
        Assert.notBlank(password);
        boolean isCheck = adminService.checkPassword(username, password);
        if (isCheck){
            Admin admin = adminService.findAdminByUsername(username);
            String token = JwtUtils.geneAdminJWT(admin);
            admin.setLastLoginTime(new Timestamp(new Date().getTime()));
            admin.setLastLoginIp(IPUtils.getIpAddr(request));
            adminService.update(admin);
            AdminVO adminVO = PoToVo(admin, token);
            return JsonData.buildSuccess(JSON.toJSON(adminVO),0,"登录成功！");
        }else {
            return JsonData.buildError("账号或密码错误！",-1);
        }

    }

    @PostMapping("addAdmin")
    public String adminLogin(@RequestBody Admin admin){

        return null;

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
