/**
 * C2-UD07- Ejercicio1
 */
package clases;

import java.util.ArrayList;
import java.util.Scanner;
import utils.Utils;

/**
 * @author elena-01 Calcular nota media alumnos
 */
public class Ejercicio1 {

	// Constantes
	final static String TITULO = "C02-UD07-Ejercicio7";

	// Variables
	Scanner sc = new Scanner(System.in);
	Utils utils = new utils.Utils();
	int numeroAlumnos;
	int numeroNotas;

	// Crear array alumnos-notas
	double[][] arrayNotas = null;

	// calculaNotaMedia
	public void iniciaEjercicio1() {

		utils.mostrarTitulo("C2 * 07");
		utils.mostrarPrograma(" Ejercicio 1 ");
		
		// Rellenamos array de notas-alumnos
		arrayNotas = rellenaArray(utils.pideInt("Numero de alumnos", TITULO), // Pedimos numero de Alumnos
				utils.pideInt("Numero de notas", TITULO));// Pedimos numero de Notas

		calculaNotaMedia(arrayNotas);
		

	}

	// Rellenar array notas
	public double[][] rellenaArray(int alumnos, int notas) {

		// Crear array alumnos-notas
		double[][] aNotas = null;

		for (int i = 0; i < alumnos; i++) {
			for (int j = 0; j < notas; j++) {
				aNotas[i][j] = Math.random() * 11 + 1;
				System.out.println(arrayNotas[i][j]);
			}
		}
		return aNotas;
	}

	// Calcular Nota media
	private void calculaNotaMedia(double[][] arrayNotas2) {
		// TODO: Calcula Nota media de todas las notas (j) para cada alumno (i)

		
		
	}

	// Almacenar en Array de datos alumno-notamedia


}
}
