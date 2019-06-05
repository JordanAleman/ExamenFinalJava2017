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
import java.sql.SQLException;
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
	
	// completar el codigo EJERCICIO 1 AQUI.
	
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
	

	
// EJERCICIO 2 : Ficheros y colecciones ------------------------------------------------------------------------------
	
	
	// Validaciones --------------------------------------------------------------------------------------------------
	
	public void validarFicheroCuentas(String rutaFichero, String delimitador){
		try {
			BufferedReader fichero = new BufferedReader(new FileReader(rutaFichero));
			String registro;
			int linea = 1;
			int error = 0;
			
			while((registro = fichero.readLine()) != null){
				// Romper la cadena registro
				String[] campos = registro.split(delimitador);
				
				try {
					if ((Integer.parseInt(campos[0]) / Integer.parseInt(campos[0])) != 1) {
						System.out.println("Hay un error en el valor entero en la línea " + linea);
						error++;
					}
					
					if ((Float.parseFloat(campos[1]) / Float.parseFloat(campos[1])) != 1) {
						System.out.println("Hay un error en el valor float en la línea " + linea);
						error++;
					}
				} catch (NumberFormatException e) {
					System.out.println("Hay un error en la línea " + linea);
					error++;
				}
			}

			if (error == 0) {
				System.out.println("El fichero 'cuentas' está validado y es correcto");
			}
			fichero.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado.");
		} catch (IOException e) {
			System.out.println("IO Excepcion");
		}
	}
	
	public void validarFicheroMovimientos(String rutaFichero, String delimitador){
		try {
			BufferedReader fichero = new BufferedReader(new FileReader(rutaFichero));
			String registro;
			int linea = 1;
			int error = 0;
			
			while((registro = fichero.readLine()) != null){
				// Romper la cadena registro
				String[] campos = registro.split(delimitador);
				
				try {
					if (campos[0].length() != 10) {
						System.out.println("La fecha es incorrecta en la linea " + linea);
						error++;
					} 
					
					if ((Integer.parseInt(campos[1]) / Integer.parseInt(campos[1])) != 1) {
						System.out.println("Hay un error en el valor entero en la línea " + linea);
						error++;
					}
					
					if ((Float.parseFloat(campos[2]) / Float.parseFloat(campos[2])) != 1) {
						System.out.println("Hay un error en el valor float en la línea " + linea);
						error++;
					}
					
				} catch (NumberFormatException e) {
					System.out.println("Hay un error en la línea " + linea);
					error++;
				}
			}

			if (error == 0) {
				System.out.println("El fichero 'movimientos' está validado y es correcto");
			}
			fichero.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado.");
		} catch (IOException e) {
			System.out.println("IO Excepcion");
		}
	}
	
	
	// completar el codigo DEL EJERCICIO 2 AQUI. ---------------------------------------------------------------------
	
	public ArrayList<String[]> listadoMovimientos(String rutaFichero, String delimitador){
		try {
			BufferedReader fichero = new BufferedReader(new FileReader(rutaFichero));
			String registro;
			ArrayList<String[]> movimientos = new ArrayList<String[]>();

			
			while((registro = fichero.readLine()) != null){
				// Romper la cadena registro
				String[] campos = registro.split(delimitador);
				movimientos.add(campos);
				
			}

			fichero.close();
			return movimientos;
			
		} catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado.");
		} catch (IOException e) {
			System.out.println("IO Excepcion");
		}
		return null;
	}
	
	public void muestraCuentas(String rutaFichero, String delimitador) {
		try {
				BufferedReader fichero = new BufferedReader(new FileReader(rutaFichero));
				String registro;
				ArrayList<String[]> movimientos = listadoMovimientos("ficheros/movimientos.txt", "&");
				float sumatorio;
				
				while((registro = fichero.readLine()) != null){
					// Romper la cadena registro
					String[] campos = registro.split(delimitador);
					sumatorio = Float.parseFloat(campos[1]);
					
					System.out.println("Cuenta: \t" + campos[0] + "\nSaldo Inicial: \t" + campos[1]);
					
					for (int i = 0; i < movimientos.size(); i++) {
						if (campos[0].equals(movimientos.get(i)[1])) {
							System.out.println("\t\t" + movimientos.get(i)[2]);
							sumatorio += Float.parseFloat(movimientos.get(i)[2]);
						}
					}
					
					System.out.println("Saldo Final: \t" + sumatorio + "\n");

				}

				fichero.close();
				
			} catch (FileNotFoundException e) {
				System.out.println("Fichero no encontrado.");
			} catch (IOException e) {
				System.out.println("IO Excepcion");
			}
	}
	

	
	// EJERCICIO 3 : BASES DE DATOS

	
	
	
	private Connection conexion() {

		 String USUARIO = "Jordan";
		 String PASS = "Jordan";
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
	
	public HashMap <Integer, ArrayList<Libro>> getLibrosPorTemas (){
		Connection con = conexion();
		HashMap <Integer, ArrayList<Libro>> librosPorTemas = new HashMap <Integer, ArrayList<Libro>>();
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			
			stmt = con.prepareStatement("select * from libros;");
			rs = stmt.executeQuery();

			while (rs.next()) { // devuelve una linea de la consulta, es decir, una fila de la tabla
				Libro libro = new Libro(rs.getInt("id"), rs.getInt("tema"), rs.getInt("editorial"), rs.getString("titulo"), rs.getInt("autor"), 
						rs.getString("disponible").charAt(0), rs.getString("isbn"), rs.getFloat("precio"), rs.getString("portada"), LocalDate.parse(rs.getString("fechapublicacion")));
	
				if (!librosPorTemas.containsKey(libro.getTema())) {
					ArrayList<Libro> listaLibro = new ArrayList<Libro>();
					listaLibro.add(libro);
					librosPorTemas.put(libro.getTema(), listaLibro);
				} else {
					librosPorTemas.get(libro.getTema()).add(libro);
				}
			}

			rs.close();
			stmt.close();
			con.close();
			
		} catch (SQLException e) {
			System.out.println("Te quedas con las ganas");
		} catch (NullPointerException e) {
			System.out.println("Va a ser que no");
		}
		
		return librosPorTemas;
		
		
		
	}
}



























