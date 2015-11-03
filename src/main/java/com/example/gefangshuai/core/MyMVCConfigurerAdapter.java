package com.example.gefangshuai.core;

import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

/**
 * Created by gefangshuai on 2015/11/3.
 */
@Configuration
public class MyMVCConfigurerAdapter extends WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter{
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new NavigationHandlerInterceptor())
                .addPathPatterns("/**");
    }
}
