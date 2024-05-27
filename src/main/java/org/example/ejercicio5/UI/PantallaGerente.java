package org.example.ejercicio5.UI;

import org.example.ejercicio5.model.Observer;

import javax.swing.*;
import java.awt.*;

public class PantallaGerente extends JFrame implements Observer {
    private JLabel lblMontoFacturado;

    public PantallaGerente() {
        setTitle("Pantalla Gerente");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 200);
        lblMontoFacturado = new JLabel("Monto Facturado: $0.00");
        lblMontoFacturado.setFont(new Font("Arial", Font.BOLD, 16));
        add(lblMontoFacturado, BorderLayout.CENTER);
        setVisible(true);
    }

    @Override
    public void accionar(double montoFacturado) {
        lblMontoFacturado.setText("Monto Facturado: $" + String.format("%.2f", montoFacturado));
        if (montoFacturado > 300000) {
            lblMontoFacturado.setForeground(Color.RED);
        } else {
            lblMontoFacturado.setForeground(Color.BLACK);
        }
    }
}
