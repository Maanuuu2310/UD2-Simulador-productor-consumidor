package Thread;

import com.salesianos.huertito;
import com.salesianos.utils;

public class Granjero extends Thread {

    private String nombre;
    private Huerto huerto;
    private int tiempoCrecimiento;
    private int vegetalesProducidos = 0;
    private int totalDeVegetales;

    public Granjero(String nombre, int totalDeVegetales, Huerto huerto, int tiempoCrecimiento) {
        this.nombre = nombre;
        this.totalDeVegetales = totalDeVegetales;
        this.huerto = huerto;
        this.tiempoCrecimiento = tiempoCrecimiento;
    }

    public void run() {
        try {

            while (vegetalesProducidos < totalDeVegetales) {
                Thread.sleep(tiempoCrecimiento * 1000);
                this.huerto.plantar(Utilidades.getVegetalAleatorio(), this.nombre);
                this.huerto.mostrarInventario();
                vegetalesProducidos++;
            }

        } catch (InterruptedException excep) {
            System.err.println("¡No estoy produciendo!");
        }
    }
}
