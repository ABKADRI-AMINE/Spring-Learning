// Importing necessary classes and packages
package com.example.main;

import com.example.beans.Vehicle;
import com.example.config.ProjectConfig;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Random;
import java.util.function.Supplier;

// Main class definition
public class Example7 {

    public static void main(String[] args) {

        // Creating a Spring application context based on configuration
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Creating a new Vehicle instance named "Volkswagen"
        Vehicle volkswagen = new Vehicle();
        volkswagen.setName("Volkswagen");

        // Creating a Supplier functional interface for Volkswagen
        Supplier<Vehicle> volkswagenSupplier = () -> volkswagen;

        // Creating a Supplier functional interface for Audi
        Supplier<Vehicle> audiSupplier = () -> {
            Vehicle audi = new Vehicle();
            audi.setName("Audi");
            return audi;
        };

        // Creating a random number generator
        Random random = new Random();
        int randomNumber = random.nextInt(10);
        System.out.println("randomNumber = " + randomNumber);

        // Conditionally registering a bean based on the random number
        if ((randomNumber % 2) == 0) {
            context.registerBean("volkswagen",
                    Vehicle.class, volkswagenSupplier);
        } else {
            context.registerBean("audi",
                    Vehicle.class, audiSupplier);
        }

        // Initializing variables to hold Vehicle instances
        Vehicle volksVehicle = null;
        Vehicle audiVehicle = null;

        // Attempting to retrieve the Volkswagen bean from the Spring context
        try {
            volksVehicle = context.getBean("volkswagen", Vehicle.class);
        } catch (NoSuchBeanDefinitionException noSuchBeanDefinitionException) {
            System.out.println("Error while creating Volkswagen vehicle");
        }

        // Attempting to retrieve the Audi bean from the Spring context
        try {
            audiVehicle = context.getBean("audi", Vehicle.class);
        } catch (NoSuchBeanDefinitionException noSuchBeanDefinitionException) {
            System.out.println("Error while creating Audi vehicle");
        }

        // Printing the name of the retrieved vehicle from the context
        if (null != volksVehicle) {
            System.out.println("Programming Vehicle name from Spring Context is: " + volksVehicle.getName());
        } else {
            System.out.println("Programming Vehicle name from Spring Context is: " + audiVehicle.getName());
        }
    }
}
