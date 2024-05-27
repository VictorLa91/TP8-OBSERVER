package org.example.ejercicio1;

import org.example.ejercicio1.observer.Observer;

import java.util.List;

public class Medidor extends Observable{
    private ClimaOnline clima;

    public Medidor(ClimaOnline clima, List<Observer> observadores) {
        super(observadores);
        this.clima = clima;
    }

    public String leerTemperatura() {
        notificar(clima.temperatura());
        return clima.temperatura();
    }

}



