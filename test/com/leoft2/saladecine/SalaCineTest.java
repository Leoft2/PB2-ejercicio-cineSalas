package com.leoft2.saladecine;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SalaCineTest {

	Pelicula peliculas[] = new Pelicula[4];
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
		
		//Podria hacer un test de agregar peliculas? como se verificaria?
	}

	@Test
	void crearSalaOk() {

		PeliculaAccion pelicomparacion = new PeliculaAccion("Piratas del Caribe 1", 200, 14);// (peli1= 0x1235)

		sala1.cambiarPelicula(peliculas[0]);
		assertEquals(2, sala1.getButacas().length);
		assertEquals(3, sala1.getButacas()[0].length);

		assertEquals(pelicomparacion, sala1.getPeliculaActual());

	}

	@Test
	void venderBoletoExitoso() {
		sala1.cambiarPelicula(peliculas[0]);
		boolean venta1 = sala1.venderBoleto(0, 1, 14, "Julian Morga");
		boolean venta2 = sala1.venderBoleto(0, 2, 16, "Julian Morga");
		assertTrue(venta1);
		assertTrue(venta2);
	}

	@Test
	void venderBoletoNoExitosoPorqueSeIntentaVenderYaVendido() {

		sala1.cambiarPelicula(peliculas[0]);
		boolean venta1 = sala1.venderBoleto(0, 1, 18, "Julian Morga");
		boolean venta2 = sala1.venderBoleto(0, 1, 18, "Julian Morga");
		assertTrue(venta1);
		assertFalse(venta2);
	}

	@Test
	void venderBoletoNoExitosoPorqueEdadMinimaNoCumplida() {

		sala1.cambiarPelicula(peliculas[0]);
		boolean venta1 = sala1.venderBoleto(0, 1, 12, "Julian Morga");
		boolean venta3 = sala1.venderBoleto(0, 1, -5, "Julian Morga");

		assertFalse(venta1);
		assertFalse(venta3);
	}

	@Test
	void obtenerTotalAscientosTest() {
		SalaCine sala1 = new SalaCine(2, 3);
		assertEquals(6, sala1.getTotalAsientos());

	}

	@Test
	void contarAsientosOcupadosTest() {
		sala1.cambiarPelicula(peliculas[0]);
		sala1.venderBoleto(0, 1, 18, "Julian Morga");
		sala1.venderBoleto(0, 2, 18, "Julian Morga");
		sala1.venderBoleto(1, 2, 18, "Julian Morga");

		assertEquals(3, sala1.contarAsientosOcupados());
	}

	@Test
	void liberarAsientoVendido() {
		sala1.cambiarPelicula(peliculas[0]);
		sala1.venderBoleto(0, 1, 18, "Julian Morga");
		sala1.venderBoleto(0, 2, 18, "Julian Morga");
		sala1.venderBoleto(1, 2, 18, "Julian Morga");

		assertEquals(3, sala1.contarAsientosOcupados());
		assertTrue(sala1.liberarAsiento(0, 1));
		assertEquals(2, sala1.contarAsientosOcupados());
		sala1.venderBoleto(0, 1, 18, "Julian Morga");
		assertEquals(3, sala1.contarAsientosOcupados());
	}

	@Test
	void liberarAsientoVendidoFueraDeRangoTest() {
		sala1.cambiarPelicula(peliculas[0]);
		sala1.venderBoleto(0, 1, 18, "Julian Morga");
		sala1.venderBoleto(0, 2, 18, "Julian Morga");
		sala1.venderBoleto(1, 2, 18, "Julian Morga");

		assertEquals(3, sala1.contarAsientosOcupados());
		assertFalse(sala1.liberarAsiento(5, 10));
		assertFalse(sala1.liberarAsiento(-1, -1));
		assertEquals(3, sala1.contarAsientosOcupados());
	}

//	@Test
//	void mostrarEstadoButacasDeLaSalaDeCine () {
//		sala1.cambiarPelicula(peliculas[0]);
//		sala1.venderBoleto(0, 1, 18, "Julian Morga");
//		boolean verificacion = sala1.mostrarButacasDetalle();
//		assertTrue(verificacion);
//		
//		
//	}

	@Test
	void liberarTodosLosAsientosVendidos() {
		sala1.cambiarPelicula(peliculas[0]);
		sala1.venderBoleto(0, 0, 18, "Julian");
		sala1.venderBoleto(0, 1, 18, "Leonel");
		sala1.venderBoleto(0, 2, 18, "Pablo");
		sala1.venderBoleto(1, 0, 18, "pedro");
		sala1.venderBoleto(1, 1, 18, "lucas");
		sala1.venderBoleto(1, 2, 18, "hernan");

		assertEquals(6, sala1.contarAsientosOcupados());

		assertTrue(sala1.liberarAsiento(0, 0));
		assertTrue(sala1.liberarAsiento(0, 1));
		assertTrue(sala1.liberarAsiento(0, 2));
		assertTrue(sala1.liberarAsiento(1, 0));
		assertTrue(sala1.liberarAsiento(1, 1));
		assertTrue(sala1.liberarAsiento(1, 2));

		assertEquals(0, sala1.contarAsientosOcupados());

	}

}
