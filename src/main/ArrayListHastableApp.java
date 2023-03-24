package main;

/**
 * c2-UD07
 */

import java.util.Scanner;

import clases_ej_1.Ejercicio1;
import clases_ej_2.Ejercicio2;
import clases_ej_3.Ejercicio3;
import clases_ej_4.Ejercicio4;
import utils.ColorConsole;
import utils.Utils;

/**
 * @author elena-01
 *
 */
public class ArrayListHastableApp {

	// --------- Variables ------------

	public Scanner sc = new Scanner(System.in);
	public static Utils utils = new utils.Utils();
	public ColorConsole cc = new utils.ColorConsole();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO: hacer Switch case control Ejercicio 1 a 4
		imprimeMenuPrincipal();
	}

	// Imprimir Menu
	static public void imprimeMenuPrincipal() {

		// Muestra el menu mediante poantalla y dialog
		utils.mostrarTitulo("MENU");
		String mensaje = " Opcion 1: EJERCICIO 1" + "\n Opcion 2: EJERCICIO 2" + "\nOpcion 3: EJERCICIO 3"
				+ "\n Opcion 4: EJERCICIO 4";
		System.out.println(mensaje);

		int opcion;

		// Pide mensaje hasta que se introduzca una opcion correcta.(Entre 1 y 3)
		do {

			// Pide numero de opcion de MENU mediante dialog
			opcion = utils.pideInt(mensaje, "MENU");
			System.out.println(opcion);

		} while (opcion > 4);

		verificaOpcionPrincipal(opcion);

	}

	// Verifica Opcion del menu
	static public void verificaOpcionPrincipal(int opcion) {

		String respuesta = "si";
		do {

			switch (opcion) {
			case 1:
				// Ejercicio1
				Ejercicio1 ejercicio1 = new Ejercicio1();
				ejercicio1.iniciaEjercicio1();
				break;
			case 2:
				// Ejercicio2
				Ejercicio2 ejercicio2 = new Ejercicio2();
				ejercicio2.iniciaEjercicio2();
				break;
			case 3:
				// Ejercicio3
				Ejercicio3 ejercicio3 = new Ejercicio3();
				ejercicio3.iniciaEjercicio3();

				break;
			case 4:
				// Ejercicio4
				Ejercicio4 ejercicio4 = new Ejercicio4();
				ejercicio4.iniciaEjercicio4();
				break;
			default:
				break;
			}

			respuesta = utils.pideString("¿Deseas continuar?(si,no);", "MENU PRINCIPAL UD07");
			System.out.println(respuesta);

			if (respuesta.equals("si")) {
				imprimeMenuPrincipal();
			}

		} while (respuesta == "si");

	}
}
