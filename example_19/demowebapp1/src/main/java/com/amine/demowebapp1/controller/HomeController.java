package com.amine.demowebapp1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller//indique que cette classe est un contrôleur
public class HomeController {
    //soit drti http://localhost:8080/home soit http://localhost:8080/ atkhdm
    @RequestMapping(value = {"","/","home"})//@RequestMapping("/home") est un mapping de la requête http://localhost:8080/home cad que si on tape cette url dans le navigateur on va afficher la page home.html
    public String displayHomePage(Model model) {
        model.addAttribute("username", "Mr.ABKADRI AMINE");//on ajoute un attribut username à l'objet model qui est un objet de type Model et qui va être envoyé à la vue home.html  Et on lui affecte la valeur HABKADRI AMINE
        return "home.html";
    }
}
