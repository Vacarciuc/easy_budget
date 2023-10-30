package com.example.test.security;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Sesiune {
    private Map<String, String> sesiuniUtilizatori = new HashMap<>();

    public String incepeSesiune(String numeUtilizator) {
        // Generăm un token unic pentru sesiune
        String tokenSesiune = UUID.randomUUID().toString();

        // Salvăm tokenul sesiunii în map, asociat cu numele de utilizator
        sesiuniUtilizatori.put(numeUtilizator, tokenSesiune);

        return tokenSesiune;
    }

    public boolean verificaSesiune(String numeUtilizator, String tokenSesiune) {
        // Verificăm dacă tokenul sesiunii corelate cu numele de utilizator există în map
        String tokenStocat = sesiuniUtilizatori.get(numeUtilizator);

        return tokenStocat != null && tokenStocat.equals(tokenSesiune);
    }

    public void terminaSesiune(String numeUtilizator) {
        // Ștergem sesiunea utilizatorului din map la încheierea sesiunii
        sesiuniUtilizatori.remove(numeUtilizator);
    }

//    public static void main(String[] args) {
//        Sesiune sesiuneManager = new Sesiune();
//        String numeUtilizator = "utilizator1";
//
//        // Începem sesiunea pentru utilizator
//        String tokenSesiune = sesiuneManager.incepeSesiune(numeUtilizator);
//
//        // Verificăm sesiunea
//        if (sesiuneManager.verificaSesiune(numeUtilizator, tokenSesiune)) {
//            System.out.println("Sesiune validă. Utilizatorul " + numeUtilizator + " este autentificat.");
//        } else {
//            System.out.println("Autentificare eșuată. Sesiune invalidă.");
//        }
//
//        // Terminăm sesiunea
//        sesiuneManager.terminaSesiune(numeUtilizator);
//    }
}


