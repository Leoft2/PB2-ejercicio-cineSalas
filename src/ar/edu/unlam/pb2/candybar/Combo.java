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

	
	
}
