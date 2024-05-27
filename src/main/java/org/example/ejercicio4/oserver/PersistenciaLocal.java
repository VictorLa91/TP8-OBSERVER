package org.example.ejercicio4.oserver;

import org.example.ejercicio4.model.Concurso;
import org.example.ejercicio4.model.LecturaDeConcursos;
import org.example.ejercicio4.model.Observer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class PersistenciaLocal implements Observer, LecturaDeConcursos {
    @Override
    public List<Concurso> todosLosConcursos() throws IOException {
        List<Concurso> concursos = new ArrayList<>();
        String path = "C:\\Users\\victo\\IdeaProjects\\TP-8\\inscripciones.txt";
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }

        while (scanner.hasNext()) {
            String fila = scanner.nextLine();
            StringTokenizer atributo = new StringTokenizer(fila, ",");
            while (atributo.hasMoreElements()) {
                int id = Integer.parseInt(atributo.nextToken().trim());
                String nombre = atributo.nextToken();
                LocalDate fechaInicioInscripcion = LocalDate.parse(atributo.nextToken().trim());
                LocalDate fechaFinInscriocion = LocalDate.parse(atributo.nextToken().trim());
                Concurso concurso = new Concurso(id, nombre, fechaInicioInscripcion, fechaFinInscriocion);
                concursos.add(concurso);
            }
        }
        return concursos;
    }

    @Override
    public void accionar(String inscirpcion) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("inscripciones.txt", true))) {
            writer.write(STR."\{inscirpcion}\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

