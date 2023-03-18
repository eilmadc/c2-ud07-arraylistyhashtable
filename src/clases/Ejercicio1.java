/**
 * C2-UD07- Ejercicio1
 */
package clases;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Scanner;

import utils.ColorConsole;
import utils.Utils;

/**
 * @author elena-01 Calcular nota media alumnos
 */
public class Ejercicio1 {

	// -------------- Constantes ------------------
	final static String TITULO = "C02-UD07-Ejercicio1";

	// --------- Variables------------
	Scanner sc = new Scanner(System.in);
	Utils utils = new utils.Utils();
	ColorConsole cc = new utils.ColorConsole();

	int numeroAlumnos;
	int numeroNotas;

	double[][] arrayNotas = null;// array alumnos-notas
	Hashtable<String, Double> notasMedias = new Hashtable<String,Double>();// Hashtable notas medias por alumno

	// --------METODOS----------------
	// ------------- Metodo que controla el flujo del ejercicio --------------
	public void iniciaEjercicio1() {

		utils.mostrarTitulo("C2 * 07");
		utils.mostrarPrograma(" Ejercicio 1 ");

		// Rellenamos array de notas-alumnos
		arrayNotas = rellenaArray(
				utils.pideInt("Numero de alumnos", TITULO), // Pedimos número de Alumnos
				utils.pideInt("Numero de notas", TITULO), // Pedimos número de Notas
				arrayNotas);

		// Calcula Notas medias y las imprime en pantalla
		calculaNotaMedia(arrayNotas);

	}

	// ----------- Rellenar array notas----------------------
	public double[][] rellenaArray(int alumnos, int notas, double arrayNotas[][]) {

		// Crear array alumnos-notas
		arrayNotas = new double[alumnos][notas];

		// Muestra descripcion de notas
		utils.imprime("Notas por alumno");
		double num = 0;

		// cumplimenta Notas y alumnos de forma aleatoria
		for (int i = 0; i < alumnos; i++) {
			for (int j = 0; j < notas; j++) {
				try {
					num = Math.random() * 10+1;//TODO: Chequear porque falla a veces
				} catch (Exception e) {
					System.out.println("Error de valor");
				}
				arrayNotas[i][j] = num; // Asigna valores de notas random

						// Imprime valores de notas y alumnos
						System.out.println("Alumno : " + (1 + i) + " --- Nota : " + utils.dosPos(num));
			}
		}
		return arrayNotas;
	}

	// -------------Método para calcular Nota media y almacenarlo en ArrayList
	// -------------------------
	private void calculaNotaMedia(double[][] arrayNotas2) {

		// Calcula Nota media de todas las notas (j) para cada alumno (i)
		for (int i = 0; i < arrayNotas2.length; i++) {
			double notaMedia = 0;
			double notas = 0;
			for (int j = 0; j < arrayNotas2[0].length; j++) {
				notas = notas + arrayNotas[i][j];// Calculamos el valor del dividendo(notas) para obtener la media
			}
			// Obtenemos la media
			notaMedia = notas / arrayNotas[i].length;
			
			//llenar ArrayList con nota media alumno
			notasMedias.put(String.valueOf(i+1),notaMedia);
		}
		// llama a metodo para imprimir notas medias
		imprimeNotasMedias(notasMedias);
	}

	// Imprime Notas Medias - Recorrer ArrayList con Iterator
	private void imprimeNotasMedias(Hashtable<String,Double> notasMedias2) {

		utils.imprime("Notas medias por alumno");
		Enumeration<String> enum1 = notasMedias2.keys();

		// Imprime valores de notas medias y alumnos
		while (enum1.hasMoreElements()) {

			// El valor del numero de alunmo lo obtiene mediante la obtencion del index de
			// cada elemento.
			String element = enum1.nextElement();
			System.out.print("Alumno : " + element + " --- Nota Media : ");
			cc.imprimeColor(cc.ANSI_BMAGENTA, utils.dosPos(notasMedias2.get(element)));
		}
		System.out.println("\nHashtable: " + notasMedias);
	}

}
