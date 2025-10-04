package ar.edu.unlam.pb2.candybar;

public abstract class Producto {

	protected String nombre;
	protected double precioBase;
	protected int stock;
	
	
	public Producto(String nombre,double precioBase, int stock) {
		this.nombre = nombre;
		this.precioBase = precioBase;
		this.stock = stock;
		
	}
	
	public Producto(String nombre, int stock) {
		this.nombre = nombre;
		this.stock = stock;
	}

	public double getPrecioBase() {
		return precioBase;
	}

	public String getNombre() {
		return nombre;
	}
	
	
	public abstract double calcularPrecioFinal();
	
		
	

}
