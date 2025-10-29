package ar.edu.unlam.pb2.candybar;

public class Snack extends Producto {

	private Tamano tamano;
	
	
	public Snack(String nombre, double precioBase, Tamano tamano, int stock) {
		super(nombre, precioBase, stock);
		this.tamano = tamano;
	}

	//calcularPrecioFinal SNACKS
	@Override
	public double calcularPrecioFinal() {
		
		if (tamano == Tamano.GRANDE) {
			return precioBase * 1.2;
		}
		if (tamano == Tamano.PEQUENO) {
			return precioBase * 0.85;
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
