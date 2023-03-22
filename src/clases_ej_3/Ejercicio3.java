/**
 * C2-UD07- Ejercicio3
 */
package clases_ej_3;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

import utils.ColorConsole;
import utils.Utils;

/**
 * @author elena-01
 *
 */
public class Ejercicio3 {

	// -------------- Constants ------------------
	final static String TITULO = "C02-UD07-Ejercicio3";

	// --------- Variables ------------
	Scanner sc = new Scanner(System.in);
	Utils utils = new utils.Utils();
	ColorConsole cc = new utils.ColorConsole();

	Hashtable<String, Producto> dic = new Hashtable<String, Producto>();

	// --------- Constructors ------------

	//// --------- Getters + Setters------------

	// --------- Methods------------
	// Metodo que inicia el ejercicio 3
	public void iniciaEjercicio3() {
		utils.mostrarTitulo("C2 * 07");
		utils.mostrarPrograma(cc.ANSI_FBMAGENTA + " Ejercicio 3 " + cc.ANSI_RESET);

		// instancia a metodo que pide los datos al usuario y
		// los almacena Hastable de Productos
		generaArticulos();
		imprimeMenu();

	}

	// genera 10 Articulos
	public void generaArticulos() {
		// Libros mas populares en los ultimos 50 años
		dic.put("La Biblia", new Producto(30, 20));
		dic.put("Citas del Presidente Mao Tse-Tung", new Producto(25, 2));
		dic.put("Harry Potter", new Producto(12, 10));
		dic.put("El Señor de los Anillos", new Producto(20, 50));
		dic.put("El Alquimista", new Producto(42, 22));
		dic.put("El Codigo da Vinci", new Producto(13, 0));
		dic.put("Crepúsculo", new Producto(22, 1));
		dic.put("Lo que el viento se llevó", new Producto(45, 1));
		dic.put("Piense y hágase rico", new Producto(10, 60));
		dic.put("El diario de Ana Frank", new Producto(10, 8));

	}

	// Imprimir Menu
	private void imprimeMenu() {

		// Muestra el menu mediante poantalla y dialog
		utils.mostrarTitulo(cc.ANSI_FBLUE + "" + "MENU" + cc.ANSI_RESET);
		String mensaje = " Opcion 1: Introducir nuevo Articulo:" + "\n Opcion 2: Introducir nuevo Stock:"
				+ "\n Opcion 3: Imprimir Articulos:";
		System.out.println(mensaje);

		int opcion;

		// Pide mensaje hasta que se introduzca una opcion correcta.(Entre 1 y 3)
		do {

			// Pide numero de opcion de MENU mediante dialog
			opcion = utils.pideInt(mensaje, "MENU");
			System.out.println(opcion);

		} while (opcion > 3);

		verificaOpcion(opcion);

	}

	// Verifica Opcion del menu
	private void verificaOpcion(int opcion) {

		String respuesta = "si";
		do {

			switch (opcion) {
			case 1:
				int num = utils.pideInt("¿Cuantos articulos quieres introducir?", "OPCION 1");
				introduceArticulos(num);
				break;
			case 2:
				String articulo = utils.pideString("NOMBRE ARTICULO: ", "OPCION 2");
				if (dic.containsKey(articulo)) {
					int stock = utils.pideInt("Introduce CANTIDAD para artículo : ", "OPCION 2");
					dic.get(articulo).setStock(stock);
				} else {
					utils.mostrarMensajeDialog("El articulo no existe", "OPCION 2");
				}
				break;
			case 3:
				imprimeArticulos();
				break;
			default:
				break;
			}

			respuesta = utils.pideString("¿Deseas continuar?(si,no);", TITULO);
			System.out.println(respuesta);
			
			if (respuesta.equals( "si" )) {
				imprimeMenu();
			}
			
		} while (respuesta == "si");

	}

	// Pide los datos de ARTICULO, PRECIO y CANTIDAD al usuario
	// Los introduce en un hashtable de String y la clase Prodcuto
	public void introduceArticulos(int numero) {
		utils.mostrarTitulo(cc.ANSI_FBLUE + "" + "Articulos en Stock" + cc.ANSI_RESET);
		for (int i = 0; i < numero; i++) {
			dic.put(utils.pideString("NUEVO ARTICULO: " + (i + 1), TITULO),
					new Producto(utils.pideDouble("Introduce PRECIO para nuevo artículo : " + (i + 1), TITULO),
							utils.pideInt("Introduce CANTIDAD para nuevo artículo : " + (i + 1), TITULO)));

		}
	}

	// Metodo para imprimir todos los articulos
	public void imprimeArticulos() {

		utils.mostrarTitulo(cc.ANSI_FBLUE + "" + "Articulos en Stock" + cc.ANSI_RESET);
		Enumeration<String> keys = dic.keys();

		while (keys.hasMoreElements()) {
			String keysElements = keys.nextElement();
			System.out.println("ARTICULOS: " + cc.ANSI_FCYAN + "" + keysElements + cc.ANSI_RESET);
			System.out.println("" + "PRECIO sin IVA: " + dic.get(keysElements).getPrecioBruto());
			System.out.println("" + "STOCK: " + dic.get(keysElements).getStock());
			System.out.println("----------------------------");
		}
		dic.values();
	}

	// Metodo para imprimir todos los articulos
	public void imprimeArticulo(String articulo) {
		System.out.println("ARTICULO: " + cc.ANSI_FCYAN + "" + articulo + cc.ANSI_RESET);
		System.out.println("" + "PRECIO sin IVA: " + dic.get(articulo).getPrecioBruto());
		System.out.println("" + "STOCK: " + dic.get(articulo).getStock());
		System.out.println("----------------------------");
	}
}
