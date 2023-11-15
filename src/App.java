import com.salesianos.Huertito.Huertito;
import com.salesianos.Thread.Cliente;
import com.salesianos.Thread.Granjero;

public class App {

    public static void main(String[] args) {
        Huertito huertito = new Huertito();

        Granjero granjero1 = new Granjero("Paco", 5, huertito, 1);
        Cliente cliente1 = new Cliente("Faustino", 5, huertito, 6);
        granjero1.start();
        cliente1.start();
    }
}