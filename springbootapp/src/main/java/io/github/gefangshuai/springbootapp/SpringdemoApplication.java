package io.github.gefangshuai.springbootapp;

import io.github.gefangshuai.springbootapp.core.AppApplicationContext;
import io.github.gefangshuai.springbootapp.core.AppSettings;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;


@SpringBootApplication
@EnableConfigurationProperties({AppSettings.class})
@Controller
public class SpringdemoApplication extends SpringBootServletInitializer {

    @Resource
    private AppSettings appSettings;

    @ModelAttribute
    public void setAppSettings(Model model) {
        model.addAttribute("appSettings", appSettings);
    }

    @RequestMapping("/")
    public String greeting(Model model) {
        return "index";
    }

    @RequestMapping(value = "/login")
    public String login() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            return "redirect:/";
        } else {
            return "login";
        }
    }

    @RequestMapping("logout")
    public String logout() {
        SecurityUtils.getSubject().logout();
        return "redirect:/login";
    }


    @RequestMapping("/404")
    public String error404() {
        return "error/404";
    }

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(SpringdemoApplication.class, args);
        AppApplicationContext.getInstance().setApplicationContext(ctx);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(applicationClass);
    }

    private static Class<SpringdemoApplication> applicationClass = SpringdemoApplication.class;
}
