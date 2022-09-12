package com.cn.maintenancedecisionservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;


/**
 * @author lexu
 */
@Configuration
public class LoginConfig implements WebMvcConfigurer {
    @Resource
    private LoginInterceptor interceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor).addPathPatterns("/**")
                .excludePathPatterns("/dist/**")
                .excludePathPatterns("/plugins/**")
                .excludePathPatterns("/common/register")
                .excludePathPatterns("/common/login")
                .excludePathPatterns("/common/forget")
                .excludePathPatterns("/common/reset")
        ;
    }
}
