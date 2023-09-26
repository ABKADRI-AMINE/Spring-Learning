package com.amine.demowebapp1.controller;

import com.amine.demowebapp1.model.Holiday;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
    public class HolidaysController {

        @GetMapping("/holidays")//cette méthode est invoquée lorsqu'une requête GET est envoyée à l'URL /holidays
        public String displayHolidays(Model model) {
            List<Holiday> holidays = Arrays.asList(//Arrays.asList() est une méthode statique de la classe Arrays qui permet de créer une liste à partir d'un tableau
                    new Holiday(" Jan 1 ","New Year's Day", Holiday.Type.FESTIVAL),
                    new Holiday(" Oct 31 ","Halloween", Holiday.Type.FESTIVAL),
                    new Holiday(" Nov 24 ","Thanksgiving Day", Holiday.Type.FESTIVAL),
                    new Holiday(" Dec 25 ","Christmas", Holiday.Type.FESTIVAL),
                    new Holiday(" Jan 17 ","Martin Luther King Jr. Day", Holiday.Type.FEDERAL),
                    new Holiday(" July 4 ","Independence Day", Holiday.Type.FEDERAL),
                    new Holiday(" Sep 5 ","Labor Day", Holiday.Type.FEDERAL),
                    new Holiday(" Nov 11 ","Veterans Day", Holiday.Type.FEDERAL)
            );
            // Récupération de toutes les constantes de l'énumération Holiday.Type dans un tableau
            Holiday.Type[] types = Holiday.Type.values();

// Parcours de chaque type d'Holiday.Type
            for (Holiday.Type type : types) {
                // Filtrage des vacances par type à l'aide de streams et collecte dans une liste
                // holidays est une liste de vacances (assumons qu'elle est déjà définie)
                List<Holiday> filteredHolidays = holidays.stream()
                        .filter(holiday -> holiday.getType().equals(type))
                        .collect(Collectors.toList());

                // Ajout de la liste de vacances filtrées à l'objet Model
                // type.toString() renvoie le nom du type d'Holiday.Type en tant que chaîne
                // model est l'objet Model passé en argument à la méthode du contrôleur
                model.addAttribute(type.toString(), filteredHolidays);
            }

// Retourne le nom de la vue (template) à afficher
// Dans ce cas, "holidays.html" est retourné pour indiquer quelle page HTML doit être rendue
            return "holidays.html";
        }
    }


