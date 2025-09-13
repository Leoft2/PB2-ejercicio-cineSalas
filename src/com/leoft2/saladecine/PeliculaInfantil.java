package com.leoft2.saladecine;

public class PeliculaInfantil extends Pelicula {

	public PeliculaInfantil(String titulo, int duracion, int edadMinima) {
		super(titulo, duracion, edadMinima);
	}

	@Override
	public String mostrarSinopsis() {
		String sinopsis = "Sinopsis de pelicula de accion"+ '\n';
		sinopsis += "Titulo: " + super.getTitulo() + '\n';
		sinopsis += "Duración en minutos: " + super.getDuracion() + '\n';
		sinopsis += "Edad Minima: " + super.getEdadMinima()  + '\n';
		sinopsis += "Las películas infantiles están pensadas para los más pequeños, con tramas simples, personajes entrañables y valores positivos como la amistad, la solidaridad o la importancia de la imaginación.";
		return sinopsis;
	}

}
