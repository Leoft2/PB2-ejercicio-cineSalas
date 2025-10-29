package ar.edu.unlam.pb2.candybar;

public class Combo extends Producto {

	private Snack snack;
	private Bebida bebida;
	private double descuento;

	public Combo(String nombre, Snack snack, Bebida bebida, double descuento, int stock) {
		super(nombre, stock);
		this.snack = snack;
		this.bebida= bebida;
		this.descuento = descuento;
		
	}

	@Override
	public double calcularPrecioFinal() {
		
		double sumaComponentes = snack.getPrecioBase() + bebida.getPrecioBase();
		return sumaComponentes - (sumaComponentes*descuento);
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
