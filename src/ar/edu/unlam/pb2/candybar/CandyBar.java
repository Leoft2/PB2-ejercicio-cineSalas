package ar.edu.unlam.pb2.candybar;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CandyBar {

	Producto productos [];
	List<Producto> listaProductos = new ArrayList<Producto>();
	
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

	public boolean agregarProductoList(Producto producto) {
		listaProductos.add(producto);
		return true;
	}

	public List<Producto> obtenerInventarioList() {
		return listaProductos;
	}

	public int contarProductosEnInventarioList() {
		return listaProductos.size();
	}

	public boolean eliminarProductoList(String nombreProducto) {
		Iterator<Producto> itr = listaProductos.iterator();
		while (itr.hasNext()) {
			Producto p = itr.next();
			if(p.getNombre() == nombreProducto) {
				itr.remove();
				return true;
			}
			
		}
		return false;
		
		
	}
		
	
		
		
	}





