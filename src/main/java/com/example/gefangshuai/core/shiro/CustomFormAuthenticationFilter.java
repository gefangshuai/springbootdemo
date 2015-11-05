package com.example.gefangshuai.core.shiro;

import com.example.gefangshuai.core.AppApplicationContext;
import com.example.gefangshuai.user.CustomUser;
import com.example.gefangshuai.user.UserService;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CustomFormAuthenticationFilter extends FormAuthenticationFilter {

    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
        UserService userService = AppApplicationContext.getInstance().getApplicationContext().getBean(UserService.class);
        CustomUser user = userService.findByName((String) subject.getPrincipal());
        ShiroUser shiroUser = new ShiroUser(true, user.getName(), user);
        shiroUser.setRoles(new String[]{user.getRole()});
        subject.getSession().setAttribute("shiroUser", shiroUser);
        return super.onLoginSuccess(token, subject, request, response);
    }
}