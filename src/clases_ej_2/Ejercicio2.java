/**
 * C2-UD07- Ejercicio2
 */
package clases_ej_2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import utils.ColorConsole;
import utils.Utils;

/**
 * @author elena-01
 *
 */
public class Ejercicio2 {
	// -------------- Constants ------------------
	final static String TITULO = "C02-UD07-Ejercicio2";
	final static double IVA_4 = 0.04;
	final static double IVA_21 = 0.21;

	// --------- Variables ------------
	Scanner sc = new Scanner(System.in);
	Utils utils = new utils.Utils();
	ColorConsole cc = new utils.ColorConsole();

	// Array carrito de la compra con los precios de los productos
	double[] arrayPrecios = null;
	ArrayList<Producto> carritoCompra = new ArrayList<Producto>();

	// --------- Methods------------
	// Metodo que inicia el ejercicio2
	public void iniciaEjercicio2() {
		utils.mostrarTitulo("C2 * 07");
		utils.mostrarPrograma(" Ejercicio 2 ");
		// Rellenamos array de precios, pidiendo al usuario
		// el numero de productos que hay en el supermercado(con precio)
		// Genero los precios aleatoriamente y lo meto en un array.
		// He supuesto ya que no lo pedía explicitamente que no hace falta guardar mas
		// dato que el propio precio.
		arrayPrecios = rellenaPrecios(utils.pideInt("Numero de productos en el super", TITULO), // Pedimos número de //
																								// productos del super
				arrayPrecios);
		llenaCarrito(utils.pideInt("Numero de productos carro de la compra", TITULO), // Preguntamos el numero de
				utils.pideInt("Cantidad pagada por cliente ", TITULO), // productos en el super
				arrayPrecios);
		// Calcula Notas medias y las imprime en pantalla
		// calculaNotaMedia(carritoCompra);
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
	private void llenaCarrito(int numCarrito, double dinero, double[] arrayPrecios2) {
		// suma de productos en carrito
		double suma = 0;
		// Obtengo de array de precios el
		// numCarrito, que es el la cantidas de numeros aleatorios
		// para introducir en la lista
		for (int a = 0; a < numCarrito; a++) {
			// random que se corresponde al iva, entre 0 y 1
			int iva = (int) Math.round(Math.random());
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

	// Imprime Precios del carrito - Recorrer ArrayList con Iterator
	private void imprimeCarrito(ArrayList<Producto> carritoCompra2, double dinero, double suma, int numCarrito) {

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

}
