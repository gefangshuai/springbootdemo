package com.example.gefangshuai;

import com.example.gefangshuai.core.AppSettings;
import com.example.gefangshuai.core.AppSettingsController;
import org.apache.shiro.SecurityUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@SpringBootApplication
@EnableConfigurationProperties({AppSettings.class})
@Controller
public class SpringdemoApplication extends SpringBootServletInitializer {

    @RequestMapping("/")
    public String greeting(Model model) {
        return "index";
    }

    @RequestMapping(value = "/login")
    public String login(){
        return "login";
    }

    @RequestMapping("logout")
    public String logout(){
        SecurityUtils.getSubject().logout();
        return "redirect:/login";
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringdemoApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(applicationClass);
    }

    private static Class<SpringdemoApplication> applicationClass = SpringdemoApplication.class;
}
