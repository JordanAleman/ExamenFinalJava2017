package modelo;

import java.time.LocalDate;

public class Libro {
	private int id;
	private int tema;
	private int editorial;
	private String titulo;
	private int autor;
	private char disponible;
	private String isbn;
	private float precio;
	private String portada;
	private LocalDate fecha;
	// COMENTARIO DE EXAMEN. 
	// CREAR getter/setters y constructor vacio.
	
	
	
	public Libro() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Libro(int id, int tema, int editorial, String titulo, int autor, char disponible, String isbn, float precio,
			String portada, LocalDate fecha) {
		super();
		this.id = id;
		this.tema = tema;
		this.editorial = editorial;
		this.titulo = titulo;
		this.autor = autor;
		this.disponible = disponible;
		this.isbn = isbn;
		this.precio = precio;
		this.portada = portada;
		this.fecha = fecha;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTema() {
		return tema;
	}
	public void setTema(int tema) {
		this.tema = tema;
	}
	public int getEditorial() {
		return editorial;
	}
	public void setEditorial(int editorial) {
		this.editorial = editorial;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getAutor() {
		return autor;
	}
	public void setAutor(int autor) {
		this.autor = autor;
	}
	public char getDisponible() {
		return disponible;
	}
	public void setDisponible(char disponible) {
		this.disponible = disponible;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public String getPortada() {
		return portada;
	}
	public void setPortada(String portada) {
		this.portada = portada;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	

}
