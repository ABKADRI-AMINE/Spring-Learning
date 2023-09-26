package com.amine.demowebapp1.controller;

import com.amine.demowebapp1.model.Contact;
import com.amine.demowebapp1.service.ContactService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.ModelAndView;


import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Slf4j//pour afficher les messages de log dans la console and generate a logger object by default
@Controller
//@RequestScope//pour que l'objet contactService soit créé à chaque fois qu'une requête http est envoyée par le client et détruit à la fin du traitement de la requête http
//@SessionScope//pour que l'objet contactService soit créé une seule fois à chaque session et détruit à la fin de la session cad à la fermeture du navigateur
@ApplicationScope//pour que l'objet contactService soit créé une seule fois à chaque démarrage de l'application et détruit à l'arrêt de l'application
public class ContactController {
    private final ContactService contactService;
    @Autowired//pour injecter l'objet contactService dans le constructeur de la classe ContactController
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }
    @RequestMapping("/contact")
    public String displayHomePage(Model model) {
        model.addAttribute("contact", new Contact());//on ajoute un objet de type Contact à l'objet model pour pouvoir l'utiliser dans la page contact.html pour pouvoir appliquer la validation des données saisies par le client
        return "contact.html";
    }
//        @RequestMapping(value = "/saveMsg",method = POST)
//    //@RequestParam("name") String name : name est le nom du paramètre qui va être envoyé par la requête http et String name est le nom de la variable qui va contenir la valeur du paramètre name
//        //@RequestParam est utilisé pour récupérer les paramètres envoyés par la requête http
//        public ModelAndView saveMessage(@RequestParam String name, @RequestParam String mobileNum,
//                                    @RequestParam String email, @RequestParam String subject, @RequestParam String message) {
//        log.info("Name : " + name);
//        log.info("Mobile Number : " + mobileNum);
//        log.info("Email Address : " + email);
//        log.info("Subject : " + subject);
//        log.info("Message : " + message);
//        return new ModelAndView("redirect:/contact");//redirect:/contact pour rediriger vers la page contact.html
//    }

    @RequestMapping(value = "/saveMsg",method = POST)
    //@Valid @ModelAttribute("contact") bash ndero lvalidation 3la les données saisies par le client
    public String saveMessage(@Valid @ModelAttribute("contact") Contact contact, Errors errors)//Contact contact : contact est le nom de la variable qui va contenir les valeurs des paramètres envoyés par la requête http et Contact est le nom de la classe qui contient les attributs qui vont contenir les valeurs des paramètres envoyés par la requête http
    {
        //ici on va vérifier si la validation des données saisies par le client a échoué ou pas
        if (errors.hasErrors()) {
            log.error("Contact from validation failed due to : " + errors.toString());//on affiche les erreurs de validation dans la console
            return ("contact.html");
        }
contactService.saveMessageDetails(contact);//on appelle la méthode saveMessageDetails de l'objet contactService pour enregistrer les détails du message envoyé par le client dans la base de données
        contactService.setCounter(contactService.getCounter()+1);//on incrémente le compteur de messages envoyés par le client
        log.info("Number of times the contact form is submitted : " + contactService.getCounter());
        return "redirect:/contact";
    }
}
