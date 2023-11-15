import com.salesianos.Huertito.Huertito;
import com.salesianos.Thread.Cliente;
import com.salesianos.Thread.Granjero;


public class App {
    public static void main(String[] args) {

        Huertito myHuertito = new Huertito();

        Granjero granjero1 = new Granjero("Paco", 5, myHuertito, 3);
        Granjero granjero2 = new Granjero("ramon", 5, myHuertito, 3);
        
        Cliente cliente1 = new Cliente("faustino", 5, myHuertito, 3);
        Cliente cliente2 = new Cliente("Mr.Gentleman", 10, myHuertito, 3);
        Cliente cliente3 = new Cliente("Loquendo", 5, myHuertito, 3);

        granjero1.start();
        granjero2.start();

        cliente1.start();
        cliente2.start();
        cliente3.start();

    }
}