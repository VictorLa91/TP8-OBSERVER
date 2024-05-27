package org.example.ejercicio1;

import org.example.ejercicio1.observer.Observer;

import java.util.List;

public class Observable {
    private List<Observer> observadores;

    public Observable(List<Observer> observadores) {
        this.observadores = observadores;
    }

    public void notificar(String info) {
        this.observadores.stream().forEach((o) -> o.actualizar(info));
    }
}

