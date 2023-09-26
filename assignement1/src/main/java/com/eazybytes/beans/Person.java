package com.eazybytes.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component//@Component est une annotation qui permet à Spring de détecter automatiquement nos beans personnalisés.ainsi insantcier et injecter les dependences
public class Person {
    private String name="AMINE";
    private final Vehicle vehicle;
    @Autowired//Autowiring feature of spring framework enables you to inject the object dependency implicitly
    //here we are injecting the vehicle object into the person object
    public Person (Vehicle vehicle){
        System.out.println("A person has been created by Spring");
        this.vehicle = vehicle;
    }
    public String getName(){
        return name;
    }
    public String setName(String name){
        return this.name = name;
    }
    public Vehicle getVehicle(){
        return vehicle;
    }
}
