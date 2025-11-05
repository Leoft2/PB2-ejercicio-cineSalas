package ar.edu.unlam.pb2.candybar.excepciones;

public class ProductoDuplicadoException extends RuntimeException {
	public ProductoDuplicadoException(String mensaje) {
		super(mensaje);
	}
}
