package org.example.ejercicio5.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Pedido {
    private ArrayList<Plato> listadoPlatos;
    private ArrayList<Bebida> listadoBebidas;
    private boolean confirmado;
    private double precioP;
    private double precioB;
    private int id;
    private int total;
    //private PersistirDatos interfaz;


    public Pedido() {
    }

    public Pedido(int id) {
        this.listadoPlatos = new ArrayList<Plato>();
        this.listadoBebidas = new ArrayList<Bebida>();
        this.id = id;
        this.precioP = 0L;
        this.precioB = 0L;
        this.total = 0;

    }

    public void asignarPlato(Plato plato) {
        this.listadoPlatos.add(plato);
    }

    public void asignarBebida(Bebida bebida) {
        this.listadoBebidas.add(bebida);
    }

    //Cada vez que se confirma el pedido se clacula el costo total y se persiste en disco
    public void confirmarPedido() {
        this.confirmado = true;
        for (Plato item : listadoPlatos) {
            this.precioP += item.precio();
            this.total += (int) item.precio();
        }
        for (Bebida item : listadoBebidas) {
            this.precioB += item.precio();
            this.total += (int) item.precio();
        }
        String data = LocalDateTime.now().toString() + "||" + this.total + "\n";


    }

    public double aplicarDescuentoBebidas(double descuento) {
        this.precioB = this.precioB - this.precioB * descuento;
        return precioB;
    }

    public double aplicarDescuentoPlatos(double descuento) {
        this.precioP = this.precioP - this.precioP * descuento;
        return precioP;
    }

    public double aplicarDescuentoSobreTotal(double descuento) {
        double total = (this.precioP + this.precioB) - (this.precioP + this.precioB) * descuento;
        return total;
    }

    public double cuantoSalenLasBebidas() {
        double copiaValor = this.precioB;
        return copiaValor;
    }

    public double cuantoSalenLosPlatos() {
        double copiaValor = this.precioP;
        return copiaValor;

    }
}