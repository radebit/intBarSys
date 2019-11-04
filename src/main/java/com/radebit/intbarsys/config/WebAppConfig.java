package com.radebit.intbarsys.config;

import com.radebit.intbarsys.intercepter.AdminAuthInterceptor;
import com.radebit.intbarsys.intercepter.AuthorizationInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author Rade
 * @Date 2019-10-29 10:50
 * 说明：
 */
@Configuration
public class WebAppConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthorizationInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(new AdminAuthInterceptor()).addPathPatterns("/**");
    }
}
