package com.eazybytes.config;

import com.eazybytes.beans.Vehicle;
import com.eazybytes.beans.VehicleServices;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
/*
Spring @Configuration annotation is part of the spring core framework.
Spring Configuration annotation indicates that the class has @Bean definition
methods. So Spring container can process the class and generate Spring Beans
to be used in the application.

To tell Spring it needs to search for classes annotated
with stereotype annotations, we use the @ComponentScan annotation over the
configuration class.
* */
@Configuration
@ComponentScan(basePackages = "com.eazybytes.beans")
public class ProjectConfig {
    /*
   @Bean annotation, which lets Spring know that it needs to call
   this method when it initializes its context and adds the returned
   value to the context.
   * */
    @Bean
    Vehicle vehicle() {
        Vehicle vehicle = new Vehicle();
        vehicle.setName("Jeep");
        return vehicle;
    }
    @Bean
    VehicleServices vehicleServices(){
        return new VehicleServices();
    }
}
