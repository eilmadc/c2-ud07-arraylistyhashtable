/**
 * C2-UD07- Ejercicio2
 */
package clases;

import java.util.ArrayList;
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

	// --------- Variables ------------
	Scanner sc = new Scanner(System.in);
	Utils utils = new utils.Utils();
	ColorConsole cc = new utils.ColorConsole();

	// Array carrito de la compra con los precios de los productos
	double[] arrayPrecios = null;
	ArrayList<Double> carritoCompra = new ArrayList<Double>();

	// --------- Constructors ------------

	//// --------- Getters + Setters------------

	// --------- Methods------------
	
	//Metodo que inicia el ejercicio2
	public void iniciaEjercicio2() {
		utils.mostrarTitulo("C2 * 07");
		utils.mostrarPrograma(" Ejercicio 1 ");

		// Rellenamos array de precios, pidiendo al usuario
		// el numero de productos que hay en el super(con precio)
		// Genero los precios aleatoriamente y lo meto en un array.
		//He supuesto ya que no lo pedía explicitamente que no hace falta guardar mas
		//dato que el propio precio.
		arrayPrecios = rellenaPrecios(utils.pideInt("Numero de productos en el super", TITULO), // Pedimos número de
																								// productos del super
				arrayPrecios);

		// Calcula Notas medias y las imprime en pantalla
		// calculaNotaMedia(carritoCompra);

	}

	//Método para rellenar el array de precios
	public double[] rellenaPrecios(int num, double arrayPrecios[]) {
		
		// Muestra descripcion de Precios
		utils.imprime("Precios por producto");
		double precio = 0;
		//double arrayPrecios
		arrayPrecios = new double[num];

		// Rellena aleatoriamente los precios en el array de precios.
		for (int i = 0; i < num; i++) {
			try {
				precio = Math.random() * 500+1;
			} catch (Exception e) {
				System.out.println("Error de valor en precio");
			}
			
			//Asignamos precios a las celdas del array
			arrayPrecios[i] = precio; //precio es random calculado mas arriba.
			System.out.println(arrayPrecios[i]);
			//Imprimir precios
			System.out.println("Producto : " + (1 + i) + " --- Precio : " + utils.dosPos(precio));
		}
		return arrayPrecios;
	}

}
