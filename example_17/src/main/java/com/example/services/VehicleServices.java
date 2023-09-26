package com.example.services;

import com.example.interfaces.LogAspect;
import com.example.interfaces.Speakers;
import com.example.interfaces.Tyres;
import com.example.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;
//The @Component annotation is used to mark a java class as a bean so the component-scanning mechanism of spring can pick it up and pull it into the application context.
@Component
public class VehicleServices {

    private Logger logger = Logger.getLogger(VehicleServices.class.getName());
//The @Autowired annotation can be used to autowire bean on the setter method just like the constructor.
    @Autowired
    private Speakers speakers;
    private Tyres tyres;
//@logAspect annotation is used to tell Spring that this method is an advice and it is used to tell Spring that this advice should be executed only for the methods which are annotated with the annotation LogAspect
    @LogAspect
    public String playMusic(boolean vehicleStarted, Song song){
        /*Instant start = Instant.now();
        logger.info("method execution start");*/
        /*String music = null;
        if(vehicleStarted){
            music = speakers.makeSound(song);
        }else{
            logger.log(Level.SEVERE,"Vehicle not started to perform the" +
                    " operation");
        }*/
        /*logger.info("method execution end");
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        logger.info("Time took to execute the method : "+timeElapsed);*/
        return speakers.makeSound(song);
    }

    public String moveVehicle(boolean vehicleStarted){
        /*Instant start = Instant.now();
        logger.info("method execution start");*/
       /* String status = null;
        if(vehicleStarted){
            status = tyres.rotate();
        }else{
            logger.log(Level.SEVERE,"Vehicle not started to perform the" +
                    " operation");
        }*/
        /*logger.info("method execution end");
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        logger.info("Time took to execute the method : "+timeElapsed);*/
        return tyres.rotate();
    }

    public String applyBrake(boolean vehicleStarted){
        /*Instant start = Instant.now();
        logger.info("method execution start");*/
        /*String status = null;
        if(vehicleStarted){
            status = tyres.stop();
        }else{
            logger.log(Level.SEVERE,"Vehicle not started to perform the" +
                    " operation");
        }*/
        /*logger.info("method execution end");
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        logger.info("Time took to execute the method : "+timeElapsed);*/
        return tyres.stop();
    }

    public Speakers getSpeakers() {
        return speakers;
    }

    public void setSpeakers(Speakers speakers) {
        this.speakers = speakers;
    }

    public Tyres getTyres() {
        return tyres;
    }
//The @Autowired annotation can be used to autowire bean on the setter method just like the constructor. The annotation can be used as follows:
    @Autowired
    public void setTyres(Tyres tyres) {
        this.tyres = tyres;
    }
}
