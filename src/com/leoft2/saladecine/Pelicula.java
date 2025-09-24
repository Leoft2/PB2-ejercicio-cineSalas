package com.leoft2.saladecine;

import java.util.Objects;

public abstract class Pelicula {
	protected String titulo;
	protected int duracion; 
	protected int edadMinima;
	 
	public Pelicula(String titulo, int duracion, int edadMinima) {
		super();
		this.titulo = titulo;
		this.duracion = duracion;
		this.edadMinima = edadMinima;
	}
	
	public abstract String mostrarSinopsis();

	public String getTitulo() {
		return titulo;
	}

	public int getDuracion() {
		return duracion;
	}

	public int getEdadMinima() {
		return edadMinima;
	}
	
	
	@Override
	public boolean equals(Object obj) { 
		Pelicula other = (Pelicula) obj;
		return duracion == other.duracion && edadMinima == other.edadMinima && Objects.equals(titulo, other.titulo);
	}
	
	
	
}
