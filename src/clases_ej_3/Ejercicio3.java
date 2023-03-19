/**
 * C2-UD07- Ejercicio3
 */
package clases_ej_3;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

import utils.ColorConsole;
import utils.Utils;
import clases_ej_2.Producto;

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
		utils.mostrarPrograma(" Ejercicio 3 ");

		// instancia a metodo que pide los datos al usuario y
		// los almacena Hastable de Productos
		introduceArticulos();
		imprimeArticulos();
	}

	//Pide los datos de ARTICULO, PRECIO y CANTIDAD al usuario
	//Los introduce en un hashtable de String y la clase Prodcuto
	public void introduceArticulos() {

		for (int i = 0; i < 3; i++) {
			dic.put(utils.pideString("NUEVO ARTICULO: "+(i+1), TITULO),
					new Producto(utils.pideDouble("Introduce PRECIO para nuevo artículo : " + (i+1), TITULO),
							utils.pideInt("Introduce CANTIDAD para nuevo artículo : " + (i+1), TITULO)));

		}
	}
	
	//Metodo para imprimir todos los articulos
	public void imprimeArticulos() {
		Enumeration <String> keys = dic.keys();
		
		while (keys.hasMoreElements()){
			System.out.print("" + "ARTICULOS: " + keys.nextElement());
		}
		
		Enumeration <Producto> enum2 = dic.elements();
		while (enum2.hasMoreElements()){
			Producto element = enum2.nextElement();
			System.out.println("" + "PRECIO sin IVA: " +element.getPrecioBruto());
			System.out.println("" + "STOCK: " +element.getStock());
		}
		
		dic.values();
	}
}
