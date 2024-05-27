package org.example.ejercicio5.model;

import java.io.IOException;
import java.util.List;

public interface LecturaDeItems {
    public List<Plato> platosDisponibles() throws IOException;

    public List<Bebida> bebidasDisponibles() throws IOException;
}
