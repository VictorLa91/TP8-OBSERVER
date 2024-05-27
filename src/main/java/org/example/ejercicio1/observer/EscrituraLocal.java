package org.example.ejercicio1.observer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EscrituraLocal implements Observer{
    @Override
    public void actualizar(String info) {
            LocalDateTime fechaActual = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String fechaFormateada = fechaActual.format(formatter);
            String registro = String.format("%s - Temperatura: %s\n", fechaFormateada, info);

            try (BufferedWriter writer = new BufferedWriter(new FileWriter("lecturas_temperatura.txt", true))) {
                writer.write(registro);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

