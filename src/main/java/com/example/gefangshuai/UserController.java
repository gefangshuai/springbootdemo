package com.example.gefangshuai;

import com.example.gefangshuai.core.AppSettings;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by gefangshuai on 2015/11/3.
 */
@Controller
public class UserController {


    Logger logger = LogManager.getLogger(User.class);

    @Autowired
    private UserDao userDao;

    @RequestMapping("/users")
    public String list(Model model) {
        List<User> users = userDao.findAll();
        model.addAttribute("users", users);
        return "users";
    }

    @RequestMapping("/users/get")
    @ResponseBody
    public String getaaa() {
        return "ddddd";
    }

    @RequestMapping("/users/getb")
    @ResponseBody
    public String getBB() {
        return "abababa";
    }

    /**
     * GET /create  --> Create a new user and save it in the database.
     */
    @RequestMapping("/create")
    @ResponseBody
    public String create(String email, String name) {
        User user = null;
        try {
            user = new User(email, name);
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
            User user = new User(id);
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
            User user = userDao.findByEmail(email);
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
            User user = userDao.findOne(id);
            user.setEmail(email);
            user.setName(name);
            userDao.save(user);
        } catch (Exception ex) {
            return "Error updating the user: " + ex.toString();
        }
        return "User successfully updated!";
    }
}
