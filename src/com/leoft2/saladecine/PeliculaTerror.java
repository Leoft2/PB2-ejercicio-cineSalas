package com.leoft2.saladecine;

public class PeliculaTerror extends Pelicula {

	public PeliculaTerror(String titulo, int duracion, int edadMinima) {
		super(titulo, duracion, edadMinima);
	}

	@Override
	public String mostrarSinopsis() {
		String sinopsis = "Sinopsis de pelicula de terror"+ '\n';
		sinopsis += "Titulo: " + super.getTitulo() + '\n';
		sinopsis += "Duración en minutos: " + super.getDuracion() + '\n';
		sinopsis += "Edad Minima: " + super.getEdadMinima()  + '\n';
		sinopsis += "Las peliculas de terror buscan generar miedo, tensión y suspenso en el espectador. Se caracteriza por atmósferas inquietantes, sucesos sobrenaturales o situaciones extremas.";
		return sinopsis;
	}

}
