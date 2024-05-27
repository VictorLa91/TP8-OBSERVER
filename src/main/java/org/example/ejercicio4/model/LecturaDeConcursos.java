package org.example.ejercicio4.model;

import java.io.IOException;
import java.util.List;

public interface LecturaDeConcursos {
    public List<Concurso> todosLosConcursos() throws IOException;

}
