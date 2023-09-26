package com.amine.demowebapp1.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration//indique que cette classe est une classe de configuration de Spring son role est de configurer Spring pour qu'il puisse fonctionner correctement
public class WebConfig implements WebMvcConfigurer {//WebMvcConfigurer est une interface qui permet de configurer Spring MVC pour qu'il puisse fonctionner correctement
    @Override
    //cette méthode permet de configurer les vues cad les pages html
    public void addViewControllers(org.springframework.web.servlet.config.annotation.ViewControllerRegistry registry) {
        registry.addViewController("/courses").setViewName("courses.html");//hadi kandero feha gher les pages li ghaykono static all the time
        registry.addViewController("/about").setViewName("about.html");
    }
}
