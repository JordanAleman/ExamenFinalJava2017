package control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import modelo.Libro;
import modelo.dao.Examen;
public class Main {
	public static void main(String[] args) {
		// COMENTARIO DE EXAMEN:
		// SE HAN DEJADO LAS LLAMADAS A LOS TRES EJERCICIOS, PUEDES  USARLAS, SI QUIERES.
		
		Examen examen = new Examen();
	     // HashMap<Integer, ArrayList<Libro>> l = examen.getLibrosTemas();
	   int[][] mat = examen.ejercicio1(9, 6, 10, 20);
	   
	   for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				if (j == mat[i].length - 1) {
					System.out.print(mat[i][j] + "\n");	
				} else {
					System.out.print(mat[i][j] + " ");
				}		
				
			}
	   }
	   System.out.println("\nEjercicio 2: Muestra los movimientos de las cuentas: -----------------------------------------------------------\n");
	   System.out.println("Evaluación de ficheros \n");
	   examen.validarFicheroCuentas("ficheros/cuentas.txt", "&");
	   examen.validarFicheroMovimientos("ficheros/movimientos.txt", "&");
	   
	   System.out.println("\nRealización de ejercicio\n");
	   examen.muestraCuentas("ficheros/cuentas.txt", "&");
	   System.out.println("----------------------------------------------------------------------------------------------------------------");


		//examen.ejercicio2("ficheros/movimientos.txt");
		HashMap<Integer, ArrayList<Libro>> librosTemas = examen.getLibrosPorTemas();
		
		Set<Integer> clavesMapa = librosTemas.keySet();
		
		for (Integer claves: clavesMapa) {
			System.out.println("\nLibros del tema: " + claves);
			for (int i = 0; i < librosTemas.get(claves).size(); i++) {
				System.out.println("Id: [" + librosTemas.get(claves).get(i).getId() + "] Tema: [" + librosTemas.get(claves).get(i).getTema()
						+ "] Título: [" + librosTemas.get(claves).get(i).getTitulo() + "]");
			}
		}
		System.out.println("FIN");
	}
}