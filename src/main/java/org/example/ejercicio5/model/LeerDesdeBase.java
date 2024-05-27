package org.example.ejercicio5.model;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LeerDesdeBase implements LecturaDeItems {
    private final static String conexion = "jdbc:mysql://localhost:3306/restaurant";
    private final static String usuario = "victor";
    private final static String clave = "nUojg8-u.uc8/a.1";

    @Override
    public List<Plato> platosDisponibles() throws IOException {
        List<Plato> lista = new ArrayList<>();
        String consultaPlatos = "SELECT  nombre, precio FROM platos"; // Ejemplo de consulta SELECT

        try (Connection myConexion = DriverManager.getConnection(conexion, usuario, clave);
             PreparedStatement statementConsulta = myConexion.prepareStatement(consultaPlatos)) {

            ResultSet resultados = statementConsulta.executeQuery();
            while (resultados.next()) {
                int precio = resultados.getInt(2);
                String nombre = resultados.getString(1);
                Plato plato = new Plato(nombre, precio);
                lista.add(plato);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    @Override
    public List<Bebida> bebidasDisponibles() throws IOException {
        List<Bebida> lista = new ArrayList<>();
        String consultaBebidas = "SELECT  nombre, precio FROM bebidas"; // Ejemplo de consulta SELECT

        try (Connection myConexion = DriverManager.getConnection(conexion, usuario, clave);
             PreparedStatement statementConsulta = myConexion.prepareStatement(consultaBebidas)) {

            ResultSet resultados = statementConsulta.executeQuery();
            while (resultados.next()) {
                int precio = resultados.getInt(2);
                String nombre = resultados.getString(1);
                Bebida bebida = new Bebida(nombre, precio);
                lista.add(bebida);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}