package com.eazybytes.eazyschool.model;

import lombok.Data;

import java.time.LocalDateTime;
//cette classe est une classe de base pour les autres classes car elle contient les attributs communs à toutes les classes car je vais utiliser cette class dans tous les autres classes
@Data
public class BaseEntity {

    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;
}
