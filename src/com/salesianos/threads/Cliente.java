package Thread;

import com.salesianos.huertito;

public class Cliente extends Thread {

    private String nombre;
    private Huerto huerto;
    private int tiempoConsumo;
    private int maximoDeVegetales;

    public Cliente(String nombre, int maximoDeVegetales, Huerto huerto, int tiempoConsumo) {
        this.nombre = nombre;
        this.maximoDeVegetales = maximoDeVegetales;
        this.huerto = huerto;
        this.tiempoConsumo = tiempoConsumo;
    }

    public void run() {
        int vegetalesConsumidos = 0;
        while (this.maximoDeVegetales > vegetalesConsumidos) {
            try {
                Thread.sleep(tiempoConsumo * 1000);
                String vegetalObtenido = this.huerto.recoger(this.nombre);
                System.out.println(this.nombre + " ha comprado " + vegetalObtenido);
                this.huerto.mostrarInventario();
            } catch (InterruptedException excep) {
                System.err.println(excep);
            }
            vegetalesConsumidos++;
        }
    }

}
