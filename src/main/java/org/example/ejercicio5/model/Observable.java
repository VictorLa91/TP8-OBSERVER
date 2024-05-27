package org.example.ejercicio5.model;

import java.util.List;

public class Observable {
    private List<Observer> observadores;

    public Observable(List<Observer> observadores) {
        this.observadores = observadores;
    }

    public void notificar(Double montoFacturado) {
        this.observadores.stream().forEach((o) -> o.accionar(montoFacturado));
    }
}

