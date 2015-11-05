package com.example.gefangshuai.core.shiro;

/**
 * Created by gefangshuai on 2015/11/5.
 */
public class ShiroUser {
    private boolean isLogin= false;
    private Object user;
    private String principal;

    public ShiroUser(boolean isLogin, String principal, Object user) {
        this.isLogin = isLogin;
        this.principal = principal;
        this.user = user;
    }

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }

    public Object getUser() {
        return user;
    }

    public void setUser(Object user) {
        this.user = user;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }
}
