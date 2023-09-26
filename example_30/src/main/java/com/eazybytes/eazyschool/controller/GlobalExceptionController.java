package com.eazybytes.eazyschool.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/*
@ControllerAdvice is a specialization of the @Component annotation which allows to handle
exceptions across the whole application in one global handling component. It can be viewed
as an interceptor of exceptions thrown by methods annotated with @RequestMapping and similar.
* */
@Slf4j
@ControllerAdvice//cette annotation permet de gérer les exceptions globalement dans l'application web (toutes les exceptions)
//@ControllerAdvice vs @ControllerAdvice la différence est que @ControllerAdvice est une classe qui permet de gérer les exceptions globalement dans l'application web (toutes les exceptions) tandis que @Controller permet de gérer les exceptions au niveau d'un controller
public class GlobalExceptionController {

    /*
    @ExceptionHandler will register the given method for a given
    exception type, so that ControllerAdvice can invoke this method
    logic if a given exception type is thrown inside the web application.
    * */
    @ExceptionHandler(Exception.class)//cette annotation permet de gérer les exceptions de type Exception
    public ModelAndView exceptionHandler(Exception exception){
        ModelAndView errorPage = new ModelAndView();
        errorPage.setViewName("error");
        errorPage.addObject("errormsg", exception.getMessage());// on ajoute un attribut errormsg à la page error.html
        return errorPage;
    }

}
