package com.amine.demowebapp1.service;

import com.amine.demowebapp1.controller.ContactController;
import com.amine.demowebapp1.model.Contact;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Slf4j//pour afficher les messages de log dans la console and generate a logger object by default
@Service//indique que cette classe est un service cad une classe qui contient la logique métier de l'application
public class ContactService {
    private int counter = 0;

    public ContactService() {
        System.out.println("Contact Service Bean initialized");
    }

    //cette méthode va enregistrer les détails du message envoyé par le client dans la base de données
    public boolean saveMessageDetails(Contact contact){
        boolean isSaved = true;//true si le message est enregistré avec succès et false sinon et on va le retourner à la fin de la méthode saveMessageDetails
        log.info(contact.toString());//pour afficher les détails du message envoyé par le client dans la console
        return isSaved;
    }
    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
