package com.leoft2.saladecine;

public class PeliculaDrama extends Pelicula {

	public PeliculaDrama(String titulo, int duracion, int edadMinima) {
		super(titulo, duracion, edadMinima);
	}

	@Override
	public String mostrarSinopsis() {
		String sinopsis = "Sinopsis de pelicula de drama"+ '\n';
		sinopsis += "Titulo: " + super.getTitulo() + '\n';
		sinopsis += "Duración en minutos: " + super.getDuracion() + '\n';
		sinopsis += "Edad Minima: " + super.getEdadMinima()  + '\n';
		sinopsis += "Las peliculas de drama se centran en las emociones humanas más profundas. Este género muestra conflictos personales, familiares o sociales que ponen a prueba la fortaleza de los personajes";
		return sinopsis;
	}

}
