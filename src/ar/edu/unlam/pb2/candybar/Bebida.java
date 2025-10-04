package ar.edu.unlam.pb2.candybar;

public class Bebida extends Producto {
	
	private Contenedor contenedor;

	public Bebida(String nombre, double precioBase, Contenedor contenedor, int stock) {
		super(nombre, precioBase, stock);
		this.contenedor = contenedor;
	}

	@Override
	public double calcularPrecioFinal() {
		if (contenedor.name() == "BOTELLA") {
			return precioBase * 1.1;
		}
	
		return precioBase;
	}



}
