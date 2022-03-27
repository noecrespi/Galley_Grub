package edu.poniperro.items;

import java.util.HashMap;

public class RetailPrice {
    //Atributos
    private static HashMap<String, Double> precio = new HashMap<String, Double>();
    
    //Metodo
    public static void init_prices() {
        precio.put("cheese", 0.25);
        precio.put("sauce", 0.50);
        precio.put("medium", 0.25);
        precio.put("large", 0.50);
    }

    public static void display() {
        /* .entrySet() : coge el string y lo convierte en un set, es decir en una lista*/
        precio.entrySet().stream().forEach(extra -> {
           System.out.println("\t"+ extra);
        });
    }
}
