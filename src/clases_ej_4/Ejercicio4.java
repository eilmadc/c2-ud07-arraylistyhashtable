/*
 * C2-UD07-Ejercicio4
 */

package clases_ej_4;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Scanner;
import utils.ColorConsole;
import utils.Utils;

public class Ejercicio4 {
	// -------------- Constants ------------------
	final static String TITULO = "C02-UD07-Ejercicio3";
	final static double IVA_4 = 0.04;
	final static double IVA_21 = 0.21;
	// -------------- Variables ------------------
	Scanner sc = new Scanner(System.in);
	Utils utils = new utils.Utils();
	ColorConsole cc = new utils.ColorConsole();

	// Array carrito de la compra con los precios de los productos
	double[] arrayPrecios = null;
	ArrayList<Producto> carritoCompra = new ArrayList<Producto>(); // Array List con los productos del carrito de la
																	// compra // compra
	Hashtable<String, Producto> dic = new Hashtable<String, Producto>(); // map con los Productos en stock

	// --------- Methods------------
	// Metodo que inicia el ejercicio 4
	public void iniciaEjercicio4() {
		utils.mostrarPrograma(cc.ANSI_FBMAGENTA + " Ejercicio 4 " + cc.ANSI_RESET);
		// instancia a metodo que pide los datos al usuario y
		// los almacena Hastable de Productos
		generaArticulos();
		// generar los precios

		imprimeMenuPrincipal();// Imprime menu principal
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

	// Imprimir Menu PRINCIPAL ejercicio 4
	public void imprimeMenuPrincipal() {
		// Muestra el menu mediante poantalla y dialog
		utils.mostrarTitulo(cc.ANSI_FBLUE + "" + "MENU" + cc.ANSI_RESET);
		String mensaje = " Opcion 1: GESTION VENTAS" + "\n Opcion 2: GESTION STOCK";
		System.out.println(mensaje);
		int opcion;
		// Pide mensaje hasta que se introduzca una opcion correcta.(Entre 1 y 3)
		do {
			// Pide numero de opcion de MENU mediante dialog
			opcion = utils.pideInt(mensaje, "MENU");
			System.out.println(opcion);
		} while (opcion > 3);
		verificaMenuPrincipal(opcion);
	}

	// Imprimir Menu STOCK
	public void imprimeMenuStock() {
		// Muestra el menu mediante poantalla y dialog
		utils.mostrarTitulo(cc.ANSI_FBLUE + "" + "MENU" + cc.ANSI_RESET);
		String mensaje = " Opcion 1: Introducir nuevo Articulo" + "\n Opcion 2: Introducir nuevo Stock"
				+ "\n Opcion 3: Imprimir Articulos" + "\n Opcion 4: Imprimir Detalles Articulo"
				+ "\n Volver a menu Principal - Cancelar";
		System.out.println(mensaje);
		int opcion;
		// Pide mensaje hasta que se introduzca una opcion correcta.(Entre 1 y 3)
		do {
			// Pide numero de opcion de MENU mediante dialog
			opcion = utils.pideInt(mensaje, "MENU STOCK");
			System.out.println(opcion);
		} while (opcion > 4);
		verificaOpcionStock(opcion);
	}

	// Verifica Opcion del menu de STOCK
	public void verificaOpcionStock(int opcion) {
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
			case 4:
				String articulo1 = utils.pideString("NOMBRE ARTICULO: ", "OPCION 4");
				if (dic.containsKey(articulo1)) {
					imprimeArticulo(articulo1);
				} else {
					utils.mostrarMensajeDialog("El articulo no existe", "OPCION 2");
				}
				break;
			default:
				break;
			}

			respuesta = utils.pideString("¿Deseas continuar?(si,no);", TITULO);
			System.out.println(respuesta);

			if (respuesta.equals("si")) {
				imprimeMenuStock();
			} else {
				imprimeMenuPrincipal();
			}

		} while (respuesta == "si");

	}

	// Verifica Opcion del menu PRINCIPAL
	public void verificaMenuPrincipal(int opcion) {
		String respuesta = "si";
		do {
			switch (opcion) {
			case 1:
				// número de productos del super, pidiendo el numero al usuario
				arrayPrecios = rellenaPrecios(utils.pideInt("Numero de productos en el super", TITULO), 
						arrayPrecios);
				// Llenamos el carrito de la compra
				llenaCarrito(utils.pideInt("Numero de productos carro de la compra", TITULO), // Preguntamos el numero
																								// de
						utils.pideInt("Cantidad pagada por cliente ", TITULO), // productos en la libreria
						arrayPrecios);
				break;
			case 2:
				imprimeMenuStock();
				break;
			default:
				break;
			}

			respuesta = utils.pideString("¿Deseas continuar?(si,no);", TITULO);
			System.out.println(respuesta);

			if (respuesta.equals("si")) {
				imprimeMenuPrincipal();
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

	// Imprime Precios del carrito - Recorrer ArrayList con Iterator
	public void imprimeCarrito(ArrayList<Producto> carritoCompra2, double dinero, double suma, int numCarrito) {
		utils.mostrarPrograma("CARRITO COMPRA: Precios");
		System.out.println("--- PRODUCTO --- PRECIO BRUTO --- IVA --- PRECIO IVA---");
		System.out.println("_________________________________________________________\n");
		Iterator<Producto> it = carritoCompra2.iterator();
		double sumaIVA = 0.00;

		int i = 0;
		// Imprime valores de notas medias y alumnos
		while (it.hasNext()) {

			// El valor del numero de alunmo lo obtiene mediante la obtencion del index de
			// cada elemento.
			Producto element = it.next();
			sumaIVA = sumaIVA + element.precioTotal;
			System.out.print("|______" + (i + 1) + "______|____");
			cc.imprimeColorSin(cc.ANSI_BGREEN, utils.dosPos(element.precioBruto));
			System.out.print("____|_____" + (element.IVA) * 100 + "% _____|___");
			cc.imprimeColorSin(cc.ANSI_BGREEN,
					utils.dosPos(element.precioBruto + element.precioBruto * element.IVA) + "___|");
			System.out.println("\n");
			i++;
		}
		System.out.println("--------------------------------------------");
		cc.imprimeColor(cc.ANSI_YELLOW, "PRECIO TOTAL BRUTO: " + utils.dosPos(suma));
		cc.imprimeColor(cc.ANSI_YELLOW, "PRECIO TOTAL IVA: " + utils.dosPos(sumaIVA));
		cc.imprimeColor(cc.ANSI_YELLOW, "CANTIDAD ABONADA :" + utils.dosPos(dinero));
		cc.imprimeColor(cc.ANSI_YELLOW, "CAMBIO A DEVOLVER: " + utils.dosPos((dinero - sumaIVA)));
		System.out.println("--------------------------------------------");

	}

	// Método para rellenar el array de precios del supermercado
	public double[] rellenaPrecios(int num, double arrayPrecios[]) {
		// Muestra descripcion de Precios
		utils.imprime("PRODUCTOS: precios");
		double precio = 0;
		// double arrayPrecios
		arrayPrecios = new double[num];
		// Rellena aleatoriamente los precios en el array de precios.
		for (int i = 0; i < num; i++) {
			precio = Math.random() * 500 + 1;
			// Asignamos precios a las celdas del array
			arrayPrecios[i] = precio; // precio es random calculado mas arriba.
			// Imprimir precios
			System.out.println("Producto : " + (1 + i) + " --- Precio : " + utils.dosPos(precio));
		}
		return arrayPrecios;
	}

	// llena Carrito con precios
	public void llenaCarrito(int numCarrito, double dinero, double arrayPrecios2[]) {
		// suma de productos en carrito
		double suma = 0;
		// Obtengo de array de precios el
		// numCarrito, que es el la cantidas de numeros aleatorios
		// para introducir en la lista
		for (int a = 0; a < numCarrito; a++) {

			// random que se corresponde al iva, entre 0 y 1
			int iva = (int) Math.round(Math.random());

			System.out.println(arrayPrecios2);
			// Calculo un numero random para la posicion que se corresponde a i,
			// para añadirlo al ArrayList del carrito
			int posX = (int) (Math.random() * (arrayPrecios2.length - 1));

			/*
			 * PRUEBAS SALIDA System.out.println("IVA : " + iva);
			 * System.out.println("Position X : " + posX);
			 * System.out.println((arrayPrecios2[posX]));
			 */

			// Llena el carrito con el producto de la posicion posX del array de precios
			// precio - IVA aplicado(0(21) o 1(4) - Precio+iva
			carritoCompra.add(new Producto((double) posX, arrayPrecios2[posX], (iva == 0) ? IVA_21 : IVA_4));
			suma = suma + arrayPrecios2[posX];
		}
		// llama a metodo para imprimir notas medias
		imprimeCarrito(carritoCompra, dinero, suma, numCarrito);
		System.out.println("\n");
	}

}
