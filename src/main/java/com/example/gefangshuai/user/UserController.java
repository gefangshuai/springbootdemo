package com.example.gefangshuai.user;

import com.example.gefangshuai.core.AppSettingsController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by gefangshuai on 2015/11/3.
 */
@Controller
@RequestMapping("/users")
public class UserController extends AppSettingsController {


    @Resource
    private UserService userService;

    @Resource
    private UserDao userDao;

    @RequestMapping
    public String index() {
        return "users";
    }

    @ResponseBody
    @RequestMapping("list/{cache}")
    @RequiresPermissions({"users"})
    public List<CustomUser> listCacheUsers(@PathVariable("cache") String cache) {
        if ("cache".equals(cache)) {
            return userService.getCacheUsers();
        } else if ("update".equals(cache)) {
            return userService.getNoCacheUsers();
        } else {
            return userService.getUsers();
        }
    }

    /**
     * GET /create  --> Create a new user and save it in the database.
     */
    @RequestMapping("/create")
    @ResponseBody
    public String create(String email, String name) {
        CustomUser user = null;
        try {
            user = new CustomUser(email, name);
            userDao.save(user);
        } catch (Exception ex) {
            return "Error creating the user: " + ex.toString();
        }
        return "User successfully created! (id = " + user.getId() + ")";
    }

    /**
     * GET /delete  --> Delete the user having the passed id.
     */
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(long id) {
        try {
            CustomUser user = new CustomUser(id);
            userDao.delete(user);
        } catch (Exception ex) {
            return "Error deleting the user:" + ex.toString();
        }
        return "User successfully deleted!";
    }

    /**
     * GET /get-by-email  --> Return the id for the user having the passed
     * email.
     */
    @RequestMapping("/get-by-email")
    @ResponseBody
    public String getByEmail(String email) {
        String userId;
        try {
            CustomUser user = userDao.findByEmail(email);
            userId = String.valueOf(user.getId());
        } catch (Exception ex) {
            return "User not found";
        }
        return "The user id is: " + userId;
    }

    /**
     * GET /update  --> Update the email and the name for the user in the
     * database having the passed id.
     */
    @RequestMapping("/update")
    @ResponseBody
    public String updateUser(long id, String email, String name) {
        try {
            CustomUser user = userDao.findOne(id);
            user.setEmail(email);
            user.setName(name);
            userDao.save(user);
        } catch (Exception ex) {
            return "Error updating the user: " + ex.toString();
        }
        return "User successfully updated!";
    }
}
