package com.leoft2.saladecine;

public class PeliculaComedia extends Pelicula {

	public PeliculaComedia(String titulo, int duracion, int edadMinima) {
		super(titulo, duracion, edadMinima);
	}

	@Override
	public String mostrarSinopsis() {
		String sinopsis = "Sinopsis de pelicula de comedia"+ '\n';
		sinopsis += "Titulo: " + super.getTitulo() + '\n';
		sinopsis += "Duración en minutos: " + super.getDuracion() + '\n';
		sinopsis += "Edad Minima: " + super.getEdadMinima()  + '\n';
		sinopsis += "Las películas de comedia buscan provocar risa y entretenimiento a través de situaciones divertidas, enredos inesperados y personajes extravagantes.";
		return sinopsis;

	}

}
