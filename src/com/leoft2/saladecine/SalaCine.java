package com.leoft2.saladecine;

import java.util.Iterator;

public class SalaCine {
	private Asiento[][] butacas;
	private Pelicula pelicula;

	public SalaCine(int fila, int columna) {
		this.butacas = new Asiento[fila][columna];

		for (int i = 0; i < fila; i++) {
			for (int j = 0; j < columna; j++) {
				this.butacas[i][j] = new Asiento();
			}
		}
	}

	public Asiento[][] getButacas() {
		return butacas;
	}

	public int contarAsientosOcupados() {
		int contador = 0;
		for (int i = 0; i < butacas.length; i++) {
			for (int j = 0; j < butacas[i].length; j++) {
				if (this.butacas[i][j].estaOcupado())
					contador++;

			}
		}
		return contador;
	}

	public int getTotalAsientos() {
		return butacas.length * butacas[0].length;
	}

	public Pelicula getPeliculaEnCartelera() {
		return pelicula; // atributo pelicula es para la pelicula que dan en la sala o solo lo q aparece
							// en cartelera
	}

	public Pelicula getPeliculaActual() {
		return pelicula;
	}

	public String getTitulo() {
		return pelicula.getTitulo();
	}

	public boolean mostrarButacasDetalle() {

		String mensaje = "";

		for (int i = 0; i < butacas.length; i++) {
			for (int j = 0; j < butacas[i].length; j++) {

				if (this.butacas[i][j].estaOcupado()) {
					mensaje += "[" + this.butacas[i][j].getNombreComprador() + "] ";
				} else {
					mensaje += "[vacio]";
				}
			}
			mensaje += "\n";
		}

		System.out.println(mensaje);
		return true;

	}

	public void cambiarPelicula(Pelicula nuevaPelicula) {
		this.pelicula = nuevaPelicula;
	}

	public boolean venderBoleto(int fila, int columna, int edad, String nombreComprador) {

		if (butacas[fila][columna].estaOcupado())
			return false;

		if (this.pelicula.getEdadMinima() > edad)
			return false;

		if (nombreComprador == null)
			return false;

		butacas[fila][columna].ocupar(nombreComprador);
		return true;
	}

	public boolean liberarAsiento(int fila, int columna) {
		if (fila < 0 || columna < 0)
			return false;

		if (fila <= butacas.length && columna <= butacas[0].length) {
			butacas[fila][columna].liberar();
			return true;
		}
		return false;
	}

	public void mostrarButacas() {
		String mensaje = "";

		for (int i = 0; i < butacas.length; i++) {
			for (int j = 0; j < butacas[i].length; j++) {

				if (this.butacas[i][j].estaOcupado()) {
					mensaje += "[ocupado]";
				} else {
					mensaje += "[vacio]";
				}
			}
			mensaje += "\n";
		}

		System.out.println(mensaje);

	}

	public boolean liberarTodaLaSala() {
		for (int i = 0; i < butacas.length; i++) {
			for (int j = 0; j < butacas[i].length; j++) {
				this.butacas[i][j].liberar();
			}
		}
		return true;
	}

}
