package ar.edu.unlam.pb2.candybar;

public class Bebida extends Producto {
	
	private Contenedor contenedor;

	public Bebida(String nombre, double precioBase, Contenedor contenedor, int stock) {
		super(nombre, precioBase, stock);
		this.contenedor = contenedor;
	}

	@Override
	public double calcularPrecioFinal() {
		if (contenedor == Contenedor.BOTELLA) {
			return precioBase * 1.1;
		}
	
		return precioBase;
	}

	@Override
	public int compareTo(Producto o) {
		
	int comparacionStock = this.stock.compareTo(o.getStock());
		
		if(comparacionStock > 0) {
			return 1;			
		} else  if (comparacionStock < 0) {
			return -1;
		}
		
		int comparacionNombre = this.nombre.compareTo(o.getNombre());
		
		if (comparacionNombre > 0) {
			return 1;
		} else if (comparacionNombre < 0) {
			return -1;
		}
		
		return this.precioBase.compareTo(o.getPrecioBase());
		
		//return Integer.compare(this.stock, o.stock);
	}



}
