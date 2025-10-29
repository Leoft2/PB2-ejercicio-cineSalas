package ar.edu.unlam.pb2.candybar;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;


public class CandyBar {

	private Producto productos [];
	private List<Producto> listaProductosArrayList = new ArrayList<Producto>();
	private Set<Producto> listaSeleccionadaSet;
	
	
	private static final Integer CANTIDAD_MAXIMA_PRODUCTOS = 5;
	
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
		if(listaProductosArrayList.size() < CANTIDAD_MAXIMA_PRODUCTOS) {
			return listaProductosArrayList.add(producto);
			
		}
		return false;
	}

	public List<Producto> obtenerInventarioList() {
		return listaProductosArrayList;
	}

	public int contarProductosEnInventarioList() {
		return listaProductosArrayList.size();
	}

	public boolean eliminarProductoList(String nombreProducto) {
		Iterator<Producto> itr = listaProductosArrayList.iterator();
		while (itr.hasNext()) {
			Producto p = itr.next();
			if(p.getNombre() == nombreProducto) {
				itr.remove();
				return true;
			}
		
		}
		return false;
		
		
	}

	public boolean agregarProductoSet(Producto producto) {
		
		if(listaSeleccionadaSet.size() < CANTIDAD_MAXIMA_PRODUCTOS) {
			return listaSeleccionadaSet.add(producto);
		}
		return false;
		
		
		
		
	}

	public int contarProductosEnInventarioSet() {
		return listaSeleccionadaSet.size();
		
	}

	public Producto obtenerProductoEnInventarioSet(int posicion) {
		
		List<Producto> listaProductosConvertido = new ArrayList<>(listaSeleccionadaSet);		
		return listaProductosConvertido.get(posicion);
	
		
	}

	public void elegirListaSet(Set listaAElegirSet) {

		this.listaSeleccionadaSet = listaAElegirSet;
		
	}



		
	
		
		
	}





