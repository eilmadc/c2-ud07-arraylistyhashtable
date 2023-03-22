package clases_ej_4;

import java.util.Hashtable;
import java.util.Scanner;

import clases_ej_3.Producto;
import utils.ColorConsole;
import utils.Utils;

public class Ejercicio4 {

	// TODO Auto-generated method stub

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
	// Metodo que inicia el ejercicio 4
	public void iniciaEjercicio4() {
		utils.mostrarTitulo("C2 * 07");
		utils.mostrarPrograma(cc.ANSI_FBMAGENTA + " Ejercicio 4 " + cc.ANSI_RESET);

		// instancia a metodo que pide los datos al usuario y
		// los almacena Hastable de Productos


	}

}
