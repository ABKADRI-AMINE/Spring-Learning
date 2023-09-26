package com.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
//le role du aop est de faire des choses avant et apres l'execution d'une methode car il nous facilite la vie car on peut faire des choses avant et apres l'execution d'une methode sans modifier le code de la methode mais en utilisant le aop
/*
Spring @Configuration annotation is part of the spring core framework.
Spring Configuration annotation indicates that the class has @Bean definition
methods. So Spring container can process the class and generate Spring Beans
to be used in the application.

To tell Spring it needs to search for classes annotated
with stereotype annotations, we use the @ComponentScan annotation over the
configuration class.
* */
//this annotation is used to tell Spring that this class contains the bean definitions
@Configuration
//this annotation is used to tell Spring to scan the packages for the components
@ComponentScan(basePackages = {"com.example.implementation",
            "com.example.services", "com.example.aspects"})
//this annotation is used to enable the Spring AOP support in the application and it is used to tell Spring to use the AspectJ framework to implement the AOP and create the proxies
@EnableAspectJAutoProxy
public class ProjectConfig {

}
