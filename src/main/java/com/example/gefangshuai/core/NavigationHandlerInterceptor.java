package com.example.gefangshuai.core;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by gefangshuai on 2015/11/3.
 */

public class NavigationHandlerInterceptor extends HandlerInterceptorAdapter{
    @Resource
    private AppSettings appSettings;

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        modelAndView.getModelMap().addAttribute("appSettings", appSettings);
        super.postHandle(request, response, handler, modelAndView);
    }
}
