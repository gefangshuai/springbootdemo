package com.example.gefangshuai;

import com.example.gefangshuai.core.AppSettings;
import com.example.gefangshuai.core.AppSettingsController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@SpringBootApplication
@EnableConfigurationProperties({AppSettings.class})
@Controller
public class SpringdemoApplication extends AppSettingsController{

    @RequestMapping("/")
    public String greeting(Model model) {
        return "index";
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringdemoApplication.class, args);
    }
}
