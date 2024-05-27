package org.example.ejercicio4.model;

import java.time.LocalDate;
import java.util.List;

public class Inscripcion extends Observable {
    LocalDate fechaInicionInscripcion;
    LocalDate fechaFinInscripcion;
    private List<Participante> listaParticipantes;

    public Inscripcion(List<Observer> observadores) {
        super(observadores);
    }


    public void guardar(Participante participante) {
        var datos = STR."\{participante.apellido()}, \{participante.nombre()}, \{participante.telefono()}, \{participante.email()}";
        notificar(datos);
        listaParticipantes.add(participante);
    }
}
