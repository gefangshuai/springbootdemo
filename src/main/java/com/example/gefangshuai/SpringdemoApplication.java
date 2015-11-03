package com.example.gefangshuai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@SpringBootApplication
@EnableConfigurationProperties
@Controller
public class SpringdemoApplication {

    @Resource
    private AppSettings appSettings;

    @RequestMapping("/")
    public String greeting(Model model) {
        model.addAttribute("appSettings", appSettings);
        return "index";
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringdemoApplication.class, args);
    }
}
