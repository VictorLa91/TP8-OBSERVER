package org.example.ejercicio4.oserver;

import org.example.ejercicio4.model.Concurso;
import org.example.ejercicio4.model.LecturaDeConcursos;
import org.example.ejercicio4.model.Observer;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PersistenciaEnBase implements Observer, LecturaDeConcursos {
    private final static String conexion = "jdbc:mysql://localhost:3306/concursos";
    private final static String usuario = "victor";
    private final static String clave = "nUojg8-u.uc8/a.1";

    public List<Concurso> todosLosConcursos() throws IOException {
        List<Concurso> lista = new ArrayList<>();
        String consultaConcursos = "SELECT id, nombre, fechaInicioInscripcion, fechaFinInscripcion FROM concursos"; // Ejemplo de consulta SELECT

        try (Connection myConexion = DriverManager.getConnection(conexion, usuario, clave);
             PreparedStatement statementConsulta = myConexion.prepareStatement(consultaConcursos)) {

            ResultSet resultados = statementConsulta.executeQuery();
            while (resultados.next()) {
                int id = resultados.getInt(1);
                String nombre = resultados.getString(2);
                LocalDate fechaInicioInscripcion = resultados.getDate(3).toLocalDate();
                LocalDate fechaFinInscripcion = resultados.getDate(4).toLocalDate();
                Concurso concurso = new Concurso(id, nombre, fechaInicioInscripcion, fechaFinInscripcion);
                lista.add(concurso);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }


    @Override
    public void accionar(String inscripcion) {
        String insertarPedido = "INSERT INTO inscripciones (datos) VALUES (?)";
        try (Connection myConexion = DriverManager.getConnection(conexion, usuario, clave);
             PreparedStatement statementInsertar = myConexion.prepareStatement(insertarPedido)) {
            statementInsertar.setString(1, inscripcion);
            statementInsertar.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
