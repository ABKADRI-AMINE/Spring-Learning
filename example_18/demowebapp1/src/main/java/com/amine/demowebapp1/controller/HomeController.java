package com.amine.demowebapp1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller//indique que cette classe est un contrôleur
public class HomeController {
    @RequestMapping("/home")//@RequestMapping("/home") est un mapping de la requête http://localhost:8080/home cad que si on tape cette url dans le navigateur on va afficher la page home.html
    public String displayHomePage() {
        return "home.html";
    }
}
