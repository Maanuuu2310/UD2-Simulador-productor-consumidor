package com.salesianos.huertito;

import java.util.ArrayList;
import java.util.Iterator;

public class huertito {

    private int maximoDeVegetales = 10;
    private ArrayList<String> huertito = new ArrayList<>();

    public huertito(int maximoDeVegetales) {
        this.maximoDeVegetales = maximoDeVegetales <= 0 ? 10 : maximoDeVegetales;
    }

    public huertito() {

    }

    synchronized public void plantar(String vegetal, String nombreGranjero) {
        try {
            while (huertito.size() >= maximoDeVegetales) {
                wait();
            }

            huertito.add(vegetal);
            System.out.println(nombreGranjero + " ha plantado un(a) " + vegetal);
            notify();

        } catch (InterruptedException excep) {
            System.err.println(excep);
        }
    }

    synchronized public void mostrarInventario() {
        if (huertito.size() != 0) {
            Iterator<String> inventario = huertito.iterator();
            System.out.println("En el huertito hay un total de " + huertito.size() + " verduras plantadas.");

            while (inventario.hasNext()) {
                System.out.println(" - " + inventario.next());
                if (!inventario.hasNext()) {
                    System.out.println(" ");
                }
            }

        } else {
            System.out.println("No hay verduras en el huertito todavía.\n");
        }
    }

    synchronized public String recoger(String nombreCliente) {
        try {

            while (huertito.size() == 0) {
                wait();
            }
            notify();

            return huertito.remove(0);

        } catch (InterruptedException excep) {
            System.err.println(excep);
            return null;
        }
    }

}
