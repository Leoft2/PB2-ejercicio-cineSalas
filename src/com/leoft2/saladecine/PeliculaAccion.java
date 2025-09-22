package com.leoft2.saladecine;

public class PeliculaAccion extends Pelicula {

	public PeliculaAccion(String titulo, int duracion, int edadMinima) {
		super(titulo, duracion, edadMinima);
		
	}


	@Override
	public String mostrarSinopsis() {
		String sinopsis = "Sinopsis de la pelicula de accion:"+ '\n';
		sinopsis += "Titulo: " + super.getTitulo() + '\n';
		sinopsis += "Duración en minutos: " + super.getDuracion() + '\n';
		sinopsis += "Edad Minima: " + super.getEdadMinima()  + '\n';
		sinopsis += "Las peliculas de accion se caracterizan por tener un alto grado de violancia, explosivos impresionantes y heroes que salvan al mundo.";
		return sinopsis;
		
	}

}
