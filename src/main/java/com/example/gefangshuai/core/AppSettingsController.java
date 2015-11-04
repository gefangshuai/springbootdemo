package com.example.gefangshuai.core;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.annotation.Resource;

/**
 * Created by gefangshuai on 2015/11/4.
 */
@Controller
public class AppSettingsController {
    @Resource
    private AppSettings appSettings;

    @ModelAttribute
    public void sendAppSettings(Model model){
        model.addAttribute("appSettings", appSettings);
    }
}
