package io.github.gefangshuai.springbootapp.core.shiro;

import io.github.gefangshuai.springbootapp.core.AppApplicationContext;
import io.github.gefangshuai.springbootapp.user.CustomUser;
import io.github.gefangshuai.springbootapp.user.UserService;
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