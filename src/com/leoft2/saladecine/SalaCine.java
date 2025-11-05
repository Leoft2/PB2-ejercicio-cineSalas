package com.leoft2.saladecine;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class SalaCine {
	private Asiento[][] butacas;
	private Pelicula pelicula;
	private Integer cantidadMaximaButacas = 0;
	Map<String, Asiento> butacasSala;

	public SalaCine(int fila, int columna) {
//		this.butacas = new Asiento[fila][columna];
//		butacasSala = new LinkedHashMap<String, Asiento>();
//
//		for (int i = 0; i < fila; i++) {
//			for (int j = 0; j < columna; j++) {
//				this.butacas[i][j] = new Asiento();
//			}
//		}
//		
//		 for (int i = 0; i < fila; i++) {
//	            char letraFila = (char) ('A' + i); // A, B, C...
//	            for (int j = 1; j <= columna; j++) {
//	                String codigo = letraFila + String.valueOf(j);
//	                butacasSala.put(codigo, new Asiento());
//	            }
//	        }
//
//		this.cantidadMaximaButacas = fila*columna;
		
		  butacas = new Asiento[fila][columna];
		    butacasSala = new LinkedHashMap<>();

		    for (int i = 0; i < fila; i++) {
		        char letraFila = (char) ('A' + i); // A, B, C...
		        for (int j = 0; j < columna; j++) {
		            String codigo = letraFila + String.valueOf(j + 1);

		            Asiento asiento = new Asiento(); 
		            butacas[i][j] = asiento;         
		            butacasSala.put(codigo, asiento); 
		        }
		    }

		    this.cantidadMaximaButacas = fila * columna;
		
		
		
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
		return pelicula;
	}


	public String getTitulo() {
		return pelicula.getTitulo();
	}

	public void mostrarButacasDetalle() {

		if (getPeliculaEnCartelera() == null) {
			System.out.println("❌ No hay película en cartelera. Primero seleccione una película.");
			return;
		}
		System.out.println("🎬 Película: " + getTitulo());
		System.out.println("📊 Ocupación: " + contarAsientosOcupados() + "/" + getTotalAsientos() + " asientos");
		System.out.print("   ");
		for (int j = 0; j < butacas[0].length; j++) {
			System.out.printf("%10d", j + 1);
		}
		System.out.println();

		for (int i = 0; i < butacas.length; i++) {
			System.out.printf("%2d ", i + 1);
			for (int j = 0; j < butacas[i].length; j++) {

				if (butacas[i][j].estaOcupado()) {
					System.out.printf("%10s", "[" + butacas[i][j].getNombreComprador() + "]");
				} else {
					System.out.printf("%10c", 'O');
				}

			}
			System.out.println();
		}
		System.out.println("O = Libre, Nombre del comprador = Ocupado\n");

	}

	public void cambiarPelicula(Pelicula nuevaPelicula) {
		if (this.pelicula != nuevaPelicula) {
			this.pelicula = nuevaPelicula;
		} else {
			this.pelicula = null;
		}

	}

	public boolean venderBoleto(int fila, int columna, int edad, String nombreComprador) {

		if (fila < 0 || columna < 0)
			return false;

		if (fila >= butacas.length || columna >= butacas[0].length) {
			return false;
		}

		if (butacas[fila][columna].estaOcupado())
			return false;

		if (this.pelicula.getEdadMinima() > edad)
			return false;
		

		if (nombreComprador == null || nombreComprador == "")
			return false;

		butacas[fila][columna].ocupar(nombreComprador);
		return true;
	}

	public boolean liberarAsiento(int fila, int columna) {
		if (fila < 0 || columna < 0)
			return false;

		if (fila < butacas.length && columna < butacas[0].length) {

			if (!butacas[fila][columna].estaOcupado()) {
				return false;
			}

			butacas[fila][columna].liberar();
			return true;
		}
		return false;
	}

	public void mostrarButacas() {

		System.out.println("\n=== ESTADO DE LA SALA ===");

		System.out.println("📊 Ocupación: " + contarAsientosOcupados() + "/" + getTotalAsientos() + " asientos");
		System.out.print("   ");
		for (int j = 0; j < butacas[0].length; j++) {
			System.out.printf("%3d", j + 1);
		}
		System.out.println();

		for (int i = 0; i < butacas.length; i++) {
			System.out.printf("%2d ", i + 1);
			for (int j = 0; j < butacas[i].length; j++) {
				char estado = butacas[i][j].estaOcupado() ? 'X' : 'O';
				System.out.printf("%3c", estado);
			}
			System.out.println();
		}
		System.out.println("O = Libre, X = Ocupado\n");

	}

	public void liberarTodaLaSala() {

		for (int i = 0; i < butacas.length; i++) {
			for (int j = 0; j < butacas[i].length; j++) {
				this.butacas[i][j].liberar();
			}
		}

	}

	public Map<String, Asiento> getSalaCineConMap() {
		return butacasSala;
	}

	public boolean venderBoletoMap(Character letraFila, Integer codigoColumna, Integer edad, String nombreComprador) {

		String codigoAsiento = letraFila + String.valueOf(codigoColumna);
		Asiento butaca = butacasSala.get(codigoAsiento);

		if (this.pelicula.getEdadMinima() > edad)
			return false;

		if (nombreComprador == null || nombreComprador == "")
			return false;

		if (butaca == null) {
			return false;
		}

		if (butaca.estaOcupado()) {
			return false;
		}

		butaca.ocupar(nombreComprador);
		System.out.println("Vendiendo: " + codigoAsiento + " → " + butaca);

		return true;
	}

	
	
	public Asiento getAsiento(String codigo) {
		System.out.println("Obteniendo: " + codigo + " → " + butacasSala.get(codigo));
	    return butacasSala.get(codigo);
	}
	
}
