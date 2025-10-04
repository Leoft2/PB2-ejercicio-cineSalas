package ar.edu.unlam.pb2.candybar;

public class CandyBar {

	Producto productos [];
	
	public CandyBar(int capacidad) {
		productos = new Producto [5];
	}

	public boolean agregarProducto(Producto producto) {
		
		for (int i = 0; i < productos.length; i++) {
			if (productos[i]==null) {
				productos[i] = producto;
				return true;
			}			
		}
		return false;
		
	}

	public Producto[] obtenerInventario() {
		 return productos;
		}

	public boolean eliminarProducto(String nombreProducto) {
		
		for (int i = 0; i < productos.length; i++) {
			if (productos[i]!=null) {
				if (productos[i].getNombre() == nombreProducto) {
					productos[i] = null;
					return true;
				}	
			}	
		}
		return false;
		
		
	}
		
		
		
		
	}





