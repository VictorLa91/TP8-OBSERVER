package org.example.ejercicio1.observer;

public class ImpresionEnPantalla implements Observer{
    @Override
    public void actualizar(String temperatura) {
        temperatura = temperatura.replace(",", ".");
        double temp = Double.parseDouble(temperatura.split(" ")[0]);
        if (temp < 12) {
            System.out.println("Hace frio, se encenderá la caldera");
        } else if (temp > 17) {
            System.out.println("Hace calor, se encenderá el aire acondicionado");
        }
    }
    }
