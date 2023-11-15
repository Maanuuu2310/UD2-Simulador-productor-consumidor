package utils;

public class Utils {
	
	private final static int VALOR_MINIMO_POR_DEFECTO = 0;
	private final static int VALOR_MAXIMO_POR_DEFECTO = 5;
	
	private final static String[] NOMBRES_VEGETALES = {
	        "Lettuce",
			"Cabbage",
			"Onion",
         	"Spinach",
         	"Potato",
         	"Celery",
         	"Asparagus",
         	"Radish",
         	"Broccoli",
         	"Artichoke",
         	"Tomato",
         	"Cucumber",
         	"Eggplant",
         	"Carrot",
         	"Green bean"
	}; 
       
	public static int obtenerNumeroAleatorio() {
		return (int) (Math.random() * (VALOR_MAXIMO_POR_DEFECTO - VALOR_MINIMO_POR_DEFECTO)) + VALOR_MINIMO_POR_DEFECTO;
	}
	
	public static int obtenerNumeroAleatorio(int valorMaximo) {
		return (int) (Math.random() * (Math.abs(valorMaximo) - VALOR_MINIMO_POR_DEFECTO)) + VALOR_MINIMO_POR_DEFECTO;
	}

	public static int obtenerNumeroAleatorio(int valorMinimo, int valorMaximo) {
		if (valorMinimo > valorMaximo) {
			int memoria = valorMaximo;
			valorMaximo = valorMinimo;
			valorMinimo = memoria;
		}
		return (int) (Math.random() * (Math.abs(valorMaximo) - Math.abs(valorMinimo))) + Math.abs(valorMinimo);
	}

	public static String obtenerVegetalAleatorio() {
		int posicionAleatoria = obtenerNumeroAleatorio(NOMBRES_VEGETALES.length - 1);
		return NOMBRES_VEGETALES[posicionAleatoria];
	}
	
}
