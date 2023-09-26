package com.example.beans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;


@Component
public class Vehicle {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //PostConstruct and PreDestroy annotations are used on methods as a callback notification to signal that the bean is ready to use and to release resources respectively.
    //PostConstruct qui demande à spring d'exécuter cette méthode après avoir fini de créer le bean
    @PostConstruct
    public void initialize() {
        this.name = "Honda";
    }
//spring will make sure to call this method before destroying the context + kaysed ga3 les ressources
    @PreDestroy
    public void destroy() {
        System.out.println(
                "Destroying Vehicle Bean hh");
    }

    public void printHello(){
        System.out.println(
            "Printing Hello from Component Vehicle Bean");
    }
}
