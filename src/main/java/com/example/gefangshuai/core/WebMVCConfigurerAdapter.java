package com.example.gefangshuai.core;

import com.example.gefangshuai.core.shiro.CustomFormAuthenticationFilter;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.Properties;

/**
 * 定义了mvc适配器
 * Created by gefangshuai on 2015/11/3.
 */
@Configuration
public class WebMVCConfigurerAdapter extends WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter {

    @Bean
    public NavigationHandlerInterceptor getNavigationHandlerInterceptor(){
        return new NavigationHandlerInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getNavigationHandlerInterceptor())
                .addPathPatterns("/**");
    }

    /**
     * 定义mvc错误及页面映射
     * @return
     */
    @Bean(name = "errorMapping")
    public SimpleMappingExceptionResolver simpleMappingExceptionResolver() {
        SimpleMappingExceptionResolver exceptionResolver = new SimpleMappingExceptionResolver();
        exceptionResolver.setDefaultErrorView("/error/500");
        exceptionResolver.setDefaultStatusCode(500);

        // 设置异常映射
        Properties properties = new Properties();
        properties.setProperty("org.apache.shiro.authz.UnauthorizedException", "/error/403");
        properties.setProperty("org.apache.shiro.authz.UnauthenticatedException", "/error/401");
        exceptionResolver.setExceptionMappings(properties);
        return exceptionResolver;
    }

}
