package com.radebit.intbarsys.intercepter;

import com.radebit.intbarsys.controller.annotation.AdminToken;
import com.radebit.intbarsys.service.AdminService;
import com.radebit.intbarsys.utils.ConstantKit;
import com.radebit.intbarsys.utils.TokenError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @Author Rade
 * @Date 2019-10-29 12:08
 * 说明：管理员登录拦截器
 */
@Slf4j
public class AdminAuthInterceptor implements HandlerInterceptor {

    @Autowired
    private AdminService adminService;

    //存放鉴权信息的Header名称，默认是Authorization
    private String httpHeaderName = "Authorization";

    //鉴权失败后返回的错误信息，默认为401 unauthorized
    private String unauthorizedErrorMessage = "401 Authorization";

    //鉴权失败后返回的HTTP错误码，默认为401
    private int unauthorizedErrorCode = HttpServletResponse.SC_UNAUTHORIZED;

    /**
     * 存放登录用户模型Key的Request Key
     */
    public static final String REQUEST_CURRENT_KEY = "REQUEST_CURRENT_KEY";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        // 如果打上了AdminToken注解则需要验证token
        if (method.getAnnotation(AdminToken.class) != null || handlerMethod.getBeanType().getAnnotation(AdminToken.class) != null) {

            String adminToken = request.getParameter(httpHeaderName);
            log.info("管理员请求token - {} ", adminToken);
            //判断Token是否为空
            if (adminToken == null) {
                TokenError.printError(response, 450, "Token isEmpty!");
                return false;
            }
            //连接Redis取出username
            Jedis jedis = new Jedis("127.0.0.1", 6379);
            String username = jedis.get(adminToken);
            log.info("管理员用户 - {}", username);
            //判断用户是否为空
            if (username == null || username.isEmpty()) {
                TokenError.printError(response, 450, "Token invalid!");
                return false;
            }
            //判断是否为管理员用户
            if (adminService.findAdminByUsername(username) == null) {
                TokenError.printError(response, 451, "Not administrator user!");
                return false;
            }
            if (!username.trim().equals("")) {
                Long tokeBirthTime = Long.valueOf(jedis.get(adminToken + username));
                log.info("adminToken创建时间 - {}", tokeBirthTime);
                Long diff = System.currentTimeMillis() - tokeBirthTime;
                log.info("adminToken存在 - {} ms", diff);
                //重新设置Redis中的token过期时间
                if (diff > ConstantKit.TOKEN_RESET_TIME) {
                    jedis.expire(username, ConstantKit.TOKEN_EXPIRE_TIME);
                    jedis.expire(adminToken, ConstantKit.TOKEN_EXPIRE_TIME);
                    log.info("重置过期时间成功!");
                    Long newBirthTime = System.currentTimeMillis();
                    jedis.set(adminToken + username, newBirthTime.toString());
                }
                //用完关闭
                jedis.close();
                request.setAttribute(REQUEST_CURRENT_KEY, username);
                return true;
            } else {
                TokenError.printError(response, 450, "Token invalid!");
                return false;
            }

        }

        request.setAttribute(REQUEST_CURRENT_KEY, null);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView
            modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception
            ex) throws Exception {

    }
}
