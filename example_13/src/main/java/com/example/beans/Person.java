package com.example.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
//@Component: Cette annotation indique à Spring que la classe annotée est un composant géré par le conteneur Spring. En d'autres termes, c'est un objet que Spring va instancier, gérer et mettre à disposition pour l'injection de dépendances.
//
//value="personBean": Cette partie de l'annotation permet de donner un nom spécifique au composant. Dans cet exemple, le nom attribué au composant est "personBean". Cela signifie que lorsque vous voudrez injecter cet objet dans d'autres parties de votre application, vous utiliserez ce nom pour référencer le composant.
@Component(value="personBean")
public class Person {

    private String name="Lucy";
    private final Vehicle vehicle;

    @Autowired
    public Person(Vehicle vehicle){
        this.vehicle = vehicle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

}
