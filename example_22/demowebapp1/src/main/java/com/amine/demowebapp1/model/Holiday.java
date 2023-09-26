package com.amine.demowebapp1.model;

import lombok.Data;

@Data//lombok.Data est une annotation qui permet de générer automatiquement les méthodes getters et setters, la méthode toString(), la méthode equals() et la méthode hashCode()


public class Holiday {

    private final String day;
    private final String reason;
    private final Type type;

    public enum Type {//enum est un type de données qui permet de définir un ensemble de constantes nommées
        FESTIVAL, FEDERAL
    }


}
