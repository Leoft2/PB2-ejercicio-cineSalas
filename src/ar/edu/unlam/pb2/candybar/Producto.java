package ar.edu.unlam.pb2.candybar;

import java.util.Objects;

public abstract class Producto implements Comparable<Producto> {

	protected String nombre;
	protected Double precioBase;
	protected Integer stock;
	
	
	public Producto(String nombre,double precioBase, int stock) {
		this.nombre = nombre;
		this.precioBase = precioBase;
		this.stock = stock;
		
	}
	
	public Producto(String nombre, int stock) {
		this.nombre = nombre;
		this.stock = stock;
	}

	public Double getPrecioBase() {
		return precioBase;
	}

	public String getNombre() {
		return nombre;
	}
	
	public Integer getStock() {
		return stock;
	}
	
	public abstract double calcularPrecioFinal();

	@Override
	public int hashCode() {
		return Objects.hash(nombre, precioBase, stock);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(nombre, other.nombre) && Objects.equals(precioBase, other.precioBase)
				&& Objects.equals(stock, other.stock);
	}
	
	public int compareTo(Producto o) {
		
		int comparacionStock = this.stock.compareTo(o.getStock());
		
		if(comparacionStock > 0) {
			return 1;			
		} else  if (comparacionStock < 0) {
			return -1;
		}
		
		return this.nombre.compareTo(o.getNombre());
		
		//return Integer.compare(this.stock, o.stock);
	}
	
	

}
