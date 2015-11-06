package io.github.gefangshuai.springbootapp.core;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by gefangshuai on 2015/11/3.
 */
@ConfigurationProperties(prefix = "app", locations = "classpath:app.properties")
public class AppSettings {
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
