package com.salesianos.Thread;

import com.salesianos.Huertito.Huertito;
import com.salesianos.utils.Utils;

public class Granjero extends Thread {

    private String nombre;
    private Huertito huertito;
    private int tiempoCrecimiento;
    private int verdurasProducidas = 0;
    private int totalDeVegetales;

    public Granjero(String nombre, int totalDeVegetales, Huertito huertito, int tiempoCrecimiento) {
        this.nombre = nombre;
        this.totalDeVegetales = totalDeVegetales;
        this.huertito = huertito;
        this.tiempoCrecimiento = tiempoCrecimiento;
    }

    public void run() {
        try {
            while (verdurasProducidas < totalDeVegetales) {
                Thread.sleep(tiempoCrecimiento * 1000);
                this.huertito.plantar(Utils.obtenerVegetalAleatorio(), this.nombre);
                this.huertito.mostrarInventario();
                verdurasProducidas++;
            }
        } catch (InterruptedException excep) {
            System.err.println("No estoy produciendo...");
        }
    }
}
