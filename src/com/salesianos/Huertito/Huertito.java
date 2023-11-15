package com.salesianos.Huertito;

import java.util.ArrayList;
import java.util.Iterator;

public class Huertito {

    private int maximoDeVegetales = 10;
    private ArrayList<String> huerto = new ArrayList<>();

    public Huertito(int maximoDeVegetales) {
        this.maximoDeVegetales = maximoDeVegetales <= 0 ? 10 : maximoDeVegetales;
    }

    public Huertito() {

    }

    synchronized public void plantar(String vegetal, String nombreGranjero) {
        try {
            while (huerto.size() >= maximoDeVegetales) {
                wait();
            }

            huerto.add(vegetal);
            System.out.println(nombreGranjero + " ha plantado una " + vegetal);
            notify();

        } catch (InterruptedException excep) {
            System.err.println(excep);
        }
    }

    synchronized public void mostrarInventario() {
        if (huerto.size() != 0) {
            Iterator<String> inventario = huerto.iterator();
            System.out.println("En el huerto hay un total de " + huerto.size() + " verduras plantadas.");

            while (inventario.hasNext()) {
                System.out.println(" - " + inventario.next());
                if (!inventario.hasNext()) {
                    System.out.println(" ");
                }
            }

        } else {
            System.out.println("No hay verduras en el huerto todavía.\n");
        }
    }

    synchronized public String recoger(String nombreCliente) {
        try {

            while (huerto.size() == 0) {
                wait();
            }
            notify();

            return huerto.remove(0);

        } catch (InterruptedException excep) {
            System.err.println(excep);
            return null;
        }
    }

}
