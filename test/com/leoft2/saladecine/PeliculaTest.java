package com.leoft2.saladecine;

import static org.junit.Assert.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PeliculaTest {

	Pelicula peliculas[] = new Pelicula[15];
	SalaCine sala1;

	@BeforeEach // o @Before en junit4
	void metodoQueSeEjecutaAntesDeTodo() {

		// Películas de Acción
		peliculas[0] = new PeliculaAccion("Piratas del Caribe 1", 200, 14);
		peliculas[1] = new PeliculaAccion("Misión Imposible", 150, 13);
		peliculas[2] = new PeliculaAccion("John Wick 4", 169, 16);
		peliculas[3] = new PeliculaAccion("Top Gun: Maverick", 130, 13);
		
		// Películas de Comedia
		peliculas[4] = new PeliculaComedia("Shrek", 90, 0);
		peliculas[5] = new PeliculaComedia("La Máscara", 120, 7);

		// Películas de Drama
		peliculas[6] = new PeliculaDrama("Forrest Gump", 142, 13);
		peliculas[7] = new PeliculaDrama("El Padrino", 175, 16);

		// Películas de Terror
		peliculas[8] = new PeliculaTerror("El Conjuro", 112, 16);
		peliculas[9] = new PeliculaTerror("Scream", 111, 18);

		// Película Infantil
		peliculas[10] = new PeliculaInfantil("Frozen", 102, 0);

		sala1 = new SalaCine(2, 3);
		
		
	}
	
	
	@Test
	void QueUnaPeliculaDeComediaMuestreSuPropiaSinopsis() {
		String sinopsisEsperada = "Sinopsis de pelicula de comedia"+ '\n';
		sinopsisEsperada += "Titulo: " + "Escuela de rock" + '\n';
		sinopsisEsperada += "Duración en minutos: " + 109 + '\n';
		sinopsisEsperada += "Edad Minima: " + 13 + '\n';
		sinopsisEsperada += "Las películas de comedia buscan provocar risa y entretenimiento a través de situaciones divertidas, enredos inesperados y personajes extravagantes.";
		
		peliculas[11] = new PeliculaComedia("Escuela de rock", 109, 13);
		Pelicula pelicula = peliculas[11];
		
		String sinopsisPeliculaComedia = pelicula.mostrarSinopsis();
		
		assertEquals(sinopsisEsperada, sinopsisPeliculaComedia);		
		
	}
	
	@Test
	void QueUnaPeliculaDeAccionMuestreSuPropiaSinopsis() {
		// peliculas[0] = new PeliculaAccion("Piratas del Caribe 1", 200, 14);
		
		
		String sinopsisEsperada = "Sinopsis de la pelicula de accion:"+ '\n';
		sinopsisEsperada += "Titulo: " + "Piratas del Caribe 1" + '\n';
		sinopsisEsperada += "Duración en minutos: " + 200 + '\n';
		sinopsisEsperada += "Edad Minima: " + 14  + '\n';
		sinopsisEsperada += "Las peliculas de accion se caracterizan por tener un alto grado de violancia, explosivos impresionantes y heroes que salvan al mundo.";
		
		Pelicula pelicula = peliculas[0];
		
		String sinopsisPeliculaAccion = pelicula.mostrarSinopsis();
		
		assertEquals(sinopsisEsperada, sinopsisPeliculaAccion);		
		
	}
	
	@Test
	void QueUnaPeliculaDeDramaMuestreSuPropiaSinopsis() {
		// peliculas[6] = new PeliculaDrama("Forrest Gump", 142, 13);
		Pelicula pelicula = peliculas[6];
		
		String sinopsisEsperada = "Sinopsis de pelicula de drama"+ '\n';
		sinopsisEsperada += "Titulo: " + pelicula.getTitulo() + '\n';
		sinopsisEsperada += "Duración en minutos: " + pelicula.getDuracion() + '\n';
		sinopsisEsperada += "Edad Minima: " + pelicula.getEdadMinima()  + '\n';
		sinopsisEsperada += "Las peliculas de drama se centran en las emociones humanas más profundas. Este género muestra conflictos personales, familiares o sociales que ponen a prueba la fortaleza de los personajes";
		
		String sinopsisPeliculaDrama = pelicula.mostrarSinopsis();
		
		assertEquals(sinopsisEsperada, sinopsisPeliculaDrama);		
		
	}
	
	@Test
	void QueExistanLasSinopsisParaCadaTipoDePelicula() {
		
//		peliculas[0] = new PeliculaAccion("Piratas del Caribe 1", 200, 14);
//		peliculas[6] = new PeliculaDrama("Forrest Gump", 142, 13);
//		peliculas[8] = new PeliculaTerror("El Conjuro", 112, 16);
//		peliculas[10] = new PeliculaInfantil("Frozen", 102, 0);
		
		String sinopsisPeliculaAccion = peliculas[0].mostrarSinopsis();
		String sinopsisPeliculaDrama = peliculas[6].mostrarSinopsis();
		String sinopsisPeliculaTerror = peliculas[8].mostrarSinopsis();
		String sinopsisPeliculaInfantil = peliculas[10].mostrarSinopsis();
		
		assertNotNull(sinopsisPeliculaAccion);
		assertNotNull(sinopsisPeliculaDrama);
		assertNotNull(sinopsisPeliculaTerror);
		assertNotNull(sinopsisPeliculaInfantil);
		
		
	}
	
	

}
