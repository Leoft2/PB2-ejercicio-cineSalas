package ar.edu.unlam.pb2.candybar.excepciones;

public class ProductoNoEncontradoException extends RuntimeException {
	public ProductoNoEncontradoException(String mensaje) {
		super(mensaje);
	}
}
