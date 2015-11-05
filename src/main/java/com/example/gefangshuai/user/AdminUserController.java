package com.example.gefangshuai.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by gefangshuai on 2015/11/4.
 */
@RestController
@RequestMapping("/admin/users")
public class AdminUserController {
    @Resource
    private UserService userService;

    @RequestMapping
    public List<CustomUser> listUsers() {
        return userService.getUsers();
    }
}
