package org.example.ejercicio4.model;

import org.example.ejercicio4.UI.RadioCompetition;
import org.example.ejercicio4.oserver.Mail;
import org.example.ejercicio4.oserver.PersistenciaEnBase;
import org.example.ejercicio4.oserver.PersistenciaLocal;

import javax.swing.*;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new Main().start();
                } catch (Exception e) {
// log exception...
                    System.out.println(e);
                }
            }
        });
    }

    private void start() {
        var lecturaYescrituraEnBase = new PersistenciaEnBase();
        var comunicacionViaMail = new Mail();
        var escrituraLocal = new PersistenciaLocal();
        new RadioCompetition(lecturaYescrituraEnBase, List.of(comunicacionViaMail, escrituraLocal, lecturaYescrituraEnBase));
    }
}
