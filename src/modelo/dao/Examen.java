package modelo.dao;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import modelo.Libro;

public class Examen {
	// COMENTARIOS DE EXAMEN
	
	// EJERCICIO 1 : Matriz de enteros aleatorios
	public int[][] ejercicio1 (int nFilas, int nColumnas, int inferior, int superior){
		int[][] matrizRandom = new int[nFilas][nColumnas];
		Random rnd = new Random();
		
		for (int i = 0; i < matrizRandom.length; i++) {
			for (int j = 0; j < matrizRandom[i].length; j++) {
				matrizRandom[i][j] = inferior + rnd.nextInt(superior + 1 - inferior) ;
			}
		}
		return matrizRandom;
	}
	

	// completar el codigo EJERCICIO 1 AQUI.
	
	// EJERCICIO 2 : Ficheros y colecciones
	
	// completar el codigo DEL EJERCICIO 2 AQUI.

	
	// EJERCICIO 3 : BASES DE DATOS
	private Connection conexion() {

		 String USUARIO = "root";
		 String PASS = "elrincon";
		 String URL_BD = "jdbc:mysql://localhost:3306/examenfinal";
		try {
			return DriverManager.getConnection(URL_BD, USUARIO, PASS);
		} catch (Exception e) {
			e.printStackTrace();
			if (e instanceof ClassNotFoundException) {
				System.err.println("VERIFIQUE Si EL DRIVER DE LA BD ESTA EN  CLASSPATH");
			} else {
				System.err.println("ESTA ARRANCANDO MYSQL ?, lAS CREDENCIALES ESTÁN BIEN ?");
			}
			System.exit(0);
			// el programa termina y devuelve el control al S.O.
			return null;
		}
	}
	// EJERCICIO 3 : BASES DE DATOS y colecciones
	
		// completar el codigo DEL EJERCICIO 3 AQUI. Necesitas el metodo conexion anterior..
}