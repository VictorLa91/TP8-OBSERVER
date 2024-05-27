package org.example.ejercicio5.model;

import org.example.ejercicio5.UI.Menu;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        var leerItems = new LeerDesdeBase();
        var menu = new Menu(leerItems);
    }
}
