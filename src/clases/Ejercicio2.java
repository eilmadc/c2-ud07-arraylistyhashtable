/**
 * C2-UD07- Ejercicio2
 */
package clases;

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

	// --------- Variables ------------
	Scanner sc = new Scanner(System.in);
	Utils utils = new utils.Utils();
	ColorConsole cc = new utils.ColorConsole();

	// Array carrito de la compra con los precios de los productos
	double[] arrayPrecios = null;
	ArrayList<Double> carritoCompra = new ArrayList<Double>();

	// --------- Methods------------

	// Metodo que inicia el ejercicio2
	public void iniciaEjercicio2() {
		utils.mostrarTitulo("C2 * 07");
		utils.mostrarPrograma(" Ejercicio 1 ");

		// Rellenamos array de precios, pidiendo al usuario
		// el numero de productos que hay en el supermercado(con precio)
		// Genero los precios aleatoriamente y lo meto en un array.
		// He supuesto ya que no lo pedía explicitamente que no hace falta guardar mas
		// dato que el propio precio.
		arrayPrecios = rellenaPrecios(utils.pideInt("Numero de productos en el super", TITULO), // Pedimos número de
																								// productos del super
				arrayPrecios);

		llenaCarrito(utils.pideInt("Numero de productos en tu carro de la compra", TITULO), // Preguntamos el numero de
																							// productos en el super
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
	private void llenaCarrito (double numCarrito, double[] arrayPrecios2) {
		
		//Obtengo de array de precios el
		//numCarrito, que es el la cantidas de numeros aleatorios
		//para introducir en la lista
		for (int a=0; a<numCarrito; a++) {
			
			//Calculo un numero random para la posicion que se corresponde a i, 
			//para añadirlo al ArrayList del carrito
			int posX = (int)(Math.random() * (arrayPrecios2.length-1));
			System.out.println("Position X : " + posX);
		// Llena el carrito con precios(j) de productos(i)
				//for (int i = 0; i < arrayPrecios2.length; i++) {
					//Al recorrer el array de precios si i es igual a ala posicion
					//entonces incluyo el precio en el array
					//if(i == posX) {
			System.out.println((arrayPrecios2[posX]));
					carritoCompra.add(arrayPrecios2[posX]);
					//}
				
			}
		// llama a metodo para imprimir notas medias
		imprimeCarrito(carritoCompra);
	}

	// Imprime Precios del carrito - Recorrer ArrayList con Iterator
	private void imprimeCarrito(ArrayList<Double> carritoCompra2) {

		utils.imprime("CARRITO COMPRA: Precios");
		Iterator<Double> it = carritoCompra2.iterator();

		int i=0;
		// Imprime valores de notas medias y alumnos
		while (it.hasNext()) {

			// El valor del numero de alunmo lo obtiene mediante la obtencion del index de
			// cada elemento.
			Double element = it.next();
			System.out.print("Producto : " + (i+1) + " --- Precio : ");
			cc.imprimeColor(cc.ANSI_BMAGENTA, utils.dosPos(element));
			i++;
		}
		System.out.println("ArrayList" + carritoCompra2);
	}

}
