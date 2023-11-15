package com.salesianos.Thread;

import com.salesianos.Huertito.Huertito;

public class Cliente extends Thread {

    private String nombre;
    private Huertito huertito;
    private int tiempoConsumo;
    private int maximoDeVegetales;

    public Cliente(String nombre, int maximoDeVegetales, Huertito huertito, int tiempoConsumo) {
        this.nombre = nombre;
        this.maximoDeVegetales = maximoDeVegetales;
        this.huertito = huertito;
        this.tiempoConsumo = tiempoConsumo;
        this.setPriority(1);
    }

    public void run() {
        int vegetalesConsumidos = 0;
        while (this.maximoDeVegetales > vegetalesConsumidos) {
            try {
                Thread.sleep(tiempoConsumo * 1000);
                String vegetalObtenido = this.huertito.recoger(this.nombre);
                System.out.println(this.nombre + " ha consumido " + vegetalObtenido);
                this.huertito.mostrarInventario();
            } catch (InterruptedException excep) {
                System.err.println(excep);
            }
            vegetalesConsumidos++;
        }
    }
}
