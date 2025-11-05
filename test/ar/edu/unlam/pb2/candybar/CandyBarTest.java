package ar.edu.unlam.pb2.candybar;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import ar.edu.unlam.pb2.candybar.excepciones.ProductoDuplicadoException;
import ar.edu.unlam.pb2.candybar.excepciones.ProductoNoEncontradoException;

public class CandyBarTest {

    private CandyBar candyBar;
    private Snack palomitas, nachos, caramelos;
    private Bebida refresco;
    private Set<Producto> listaProductosHashSet;
    private Set<Producto> listaProductosTreeSetOrdenadosPorStock;
	private Set<Bebida> listaProductosBebidaTreeSetOrdenadosPorPrecioBase;
	private Set<Snack> listaProductosSnackTreeSetOrdenadosPorNombre;

    // Se ejecuta antes de cada test para inicializar el objeto CandyBar
    @Before
    public void setUp() {
        candyBar = new CandyBar(5); // Capacidad para 5 productos
        palomitas = new Snack("Palomitas", 5.0, Tamano.MEDIANO, 10);
        refresco = new Bebida("Refresco", 3.0, Contenedor.VASO, 15);
        nachos = new Snack("Nachos", 10.0, Tamano.GRANDE, 5);
        caramelos = new Snack("Caramelos", 2.0, Tamano.PEQUENO, 5);
        
        listaProductosHashSet = new HashSet<Producto>();
        listaProductosTreeSetOrdenadosPorStock = new TreeSet<Producto>();
    	listaProductosBebidaTreeSetOrdenadosPorPrecioBase = new TreeSet<Bebida>(new PrecioBaseComparator());
    	listaProductosSnackTreeSetOrdenadosPorNombre = new TreeSet<Snack>(new NombreComparator()); 
    }

    @Test
    public void testAgregarProducto() {
        assertTrue(candyBar.agregarProducto(palomitas));
        assertEquals(1, contarProductosEnInventario());

        assertTrue(candyBar.agregarProducto(refresco));
        assertEquals(2, contarProductosEnInventario());

    }

    @Test
    public void testEliminarProductoExistente() {
        candyBar.agregarProducto(palomitas);
        candyBar.agregarProducto(refresco);

        boolean eliminado = candyBar.eliminarProducto("Palomitas");
        assertTrue(eliminado);
        assertEquals(1, contarProductosEnInventario());
        assertNull(candyBar.obtenerInventario()[0]);
    }

    @Test
    public void testEliminarProductoNoExistente() {
        candyBar.agregarProducto(palomitas);

        boolean eliminado = candyBar.eliminarProducto("Chocolate");
        assertFalse(eliminado);
        assertEquals(1, contarProductosEnInventario());
    }

    @Test
    public void testInventarioLleno() {
        // Llenar el inventario hasta su capacidad
        for (int i = 0; i < 5; i++) {
            candyBar.agregarProducto(new Snack("Snack " + i, 1.0, Tamano.MEDIANO, 5));
        }

        // Intentar agregar un sexto producto
        boolean agregado = candyBar.agregarProducto(new Snack("Snack Extra", 1.0, Tamano.MEDIANO, 3));
        assertFalse(agregado);
        assertEquals(5, contarProductosEnInventario());
    }
    
    
    // TESTING CON COLLECCION LIST  
    
    
    @Test
    public void testAgregarProductosConList() {
    	
    	 assertTrue(candyBar.agregarProductoList(palomitas));
         assertEquals(1, candyBar.contarProductosEnInventarioList());
    	 
         assertTrue(candyBar.agregarProductoList(refresco));
         assertEquals(2, candyBar.contarProductosEnInventarioList());
    	
    }
    
    @Test 
    public void testAgregarProductosRepetidosConList() {
    	
         assertTrue(candyBar.agregarProductoList(palomitas));
         assertEquals(1, candyBar.contarProductosEnInventarioList());
         assertTrue(candyBar.agregarProductoList(palomitas));
         assertEquals(2, candyBar.contarProductosEnInventarioList());
    	
    }
    
    
    
    @Test
    public void testEliminarProductoExistenteConList() {
    	candyBar.agregarProductoList(palomitas);
    	candyBar.agregarProductoList(refresco);
    	assertEquals(2, candyBar.contarProductosEnInventarioList());
    	
        boolean eliminado = candyBar.eliminarProductoList("Palomitas");
        assertTrue(eliminado);
        assertEquals(1, candyBar.contarProductosEnInventarioList());
        
        
        
    }
    
    
    @Test
    public void testEliminarProductoNoExistenteConList() {
    	List<Producto> listaProductos;
    	listaProductos = candyBar.obtenerInventarioList();
    	listaProductos.add(palomitas);
    	
        boolean eliminado = candyBar.eliminarProductoList("Chocolate");
        assertFalse(eliminado);
        assertEquals(1, candyBar.contarProductosEnInventarioList());
    }
    
    
    @Test 
    public void testInventarioLlenoConList() {
    	
    	// Llenar el inventario hasta su capacidad
    	
         assertTrue(candyBar.agregarProductoList(palomitas));
         assertTrue(candyBar.agregarProductoList(refresco));
         assertTrue(candyBar.agregarProductoList(palomitas));
         assertTrue(candyBar.agregarProductoList(refresco));
         assertTrue(candyBar.agregarProductoList(palomitas));
         
         assertEquals(5, candyBar.contarProductosEnInventarioList());
         
         // Intentar agregar un sexto producto
         assertFalse(candyBar.agregarProductoList(refresco));
         
         assertEquals(5, candyBar.contarProductosEnInventarioList());
    	
    	
    }
    
    // TESTING CON COLECCION SET
    
    
    @Test
    public void testQue3ProductosSeOrdenenPorCantidadDeStockEnOrdenNaturalConSet() {
    	
    	// Se pide que el orden Natural de los productos sea por cantidad de stock. No se permiten duplicados.
    	
    	// Eligo la lista de TreeSet que quiero usar para ordenar
    	candyBar.elegirListaSet(listaProductosTreeSetOrdenadosPorStock);
    	
    	//Agrego los productos
    	candyBar.agregarProductoSet(palomitas);
    	candyBar.agregarProductoSet(refresco);
    	candyBar.agregarProductoSet(nachos);
    	
//       primero --> nachos = new Snack("Nachos", 10.0, Tamano.GRANDE, 5);
//    	 segundo --> palomitas = new Snack("Palomitas", 5.0, Tamano.MEDIANO, 10);
//       tercero --> refresco = new Bebida("Refresco", 3.0, Contenedor.VASO, 15);
    	
    	//verifica el orden
        assertEquals(nachos, candyBar.obtenerProductoEnInventarioSet(0));
        assertEquals(palomitas, candyBar.obtenerProductoEnInventarioSet(1));
        assertEquals(refresco, candyBar.obtenerProductoEnInventarioSet(2));
        
    	
    }
    
    @Test
    public void testQueProductosQueTengaLaMismaCantidadDeStockPuedanEntrarALaListaYSeanOrdenadosPorCantidadDeStock() {
    	
    	// Que si no se ordena por cantidad de Stock, se ordene por nombre del producto
    	
    	// Eligo la lista de TreeSet que quiero usar para ordenar
    	candyBar.elegirListaSet(listaProductosTreeSetOrdenadosPorStock);
    	
    	//Agrego los productos y verifico que se agregen
    	  assertTrue(candyBar.agregarProductoSet(nachos));
          assertEquals(1, candyBar.contarProductosEnInventarioSet());
          
          candyBar.agregarProductoSet(refresco);
          assertEquals(2, candyBar.contarProductosEnInventarioSet());
          
          assertTrue(candyBar.agregarProductoSet(caramelos));
          assertEquals(3, candyBar.contarProductosEnInventarioSet());
    	
    	
//		 primero por nombre y stock --> caramelos = new Snack("Caramelos", 2.0, Tamano.PEQUENO, 5);
//       segundo por nombre y stock --> nachos = new Snack("Nachos", 10.0, Tamano.GRANDE, 5);
//       tercero por stock --> refresco = new Bebida("Refresco", 3.0, Contenedor.VASO, 15);
    	
    	//verifica el orden
        assertEquals(caramelos, candyBar.obtenerProductoEnInventarioSet(0));
        assertEquals(nachos, candyBar.obtenerProductoEnInventarioSet(1));
        assertEquals(refresco, candyBar.obtenerProductoEnInventarioSet(2));
        
    }
    
    
    
    
    @Test
    public void testQueSeDevuelvaListadoDe3ProductosBebidaOrdenadosPorPrecioBaseDeMenorAMayorConSet() {
    	
    	//Se pide devolver un listado de productos de tipo Bebida ordenados por precioBase de menor a Mayor.
    	
    	//Creo productos tipo Bebida con distintos valores para que luego ordene
    	Bebida soda = new Bebida("Soda",20.0,Contenedor.VASO,4);
    	Bebida sprite = new Bebida("Sprite",30.0,Contenedor.BOTELLA,2);
    	Bebida cocacola = new Bebida("Coca cola",60.0,Contenedor.BOTELLA,10);
    	
    	// Eligo la lista de TreeSet que quiero usar para ordenar
    	candyBar.elegirListaSet(listaProductosBebidaTreeSetOrdenadosPorPrecioBase);
    	
    	//Agrego los productos
    	candyBar.agregarProductoSet(sprite);
    	candyBar.agregarProductoSet(cocacola);
    	candyBar.agregarProductoSet(soda);
    	
    	//verifica el orden
    	assertEquals(soda,candyBar.obtenerProductoEnInventarioSet(0));
    	assertEquals(sprite,candyBar.obtenerProductoEnInventarioSet(1));
    	assertEquals(cocacola,candyBar.obtenerProductoEnInventarioSet(2));
    	
    	
    }
    
    @Test 
    public void testQueSeDevuelvaListadoDe3ProductosSnackOrdenadosPorNombreConSet() {
    	
    	//Se pide devolver un listado de productos de tipo Snack ordenados por Nombre.
    	
    	//Creo productos tipo Snack con distintos valores para que luego ordene alfabeticamente de la a-z
    	
    	Snack beldent = new Snack("Beldent chicle", 5.0, Tamano.PEQUENO, 30);
    	Snack nachosQueso = new Snack("Nachos con queso", 50.0, Tamano.GRANDE, 7);
    	Snack vizzio = new Snack("Vizzio chocolate", 20.0, Tamano.MEDIANO, 10);
    	
    	
    	// Eligo la lista de TreeSet que quiero usar para ordenar
    	candyBar.elegirListaSet(listaProductosSnackTreeSetOrdenadosPorNombre);
    
    	//Agrego los productos
    	candyBar.agregarProductoSet(nachosQueso);
    	candyBar.agregarProductoSet(vizzio);
    	candyBar.agregarProductoSet(beldent);
    	
    	//verifica el orden
       	assertEquals(beldent,candyBar.obtenerProductoEnInventarioSet(0));
    	assertEquals(nachosQueso,candyBar.obtenerProductoEnInventarioSet(1));
    	assertEquals(vizzio,candyBar.obtenerProductoEnInventarioSet(2));
    	
    	
    }
    
    
    // TESTING CON EXCEPCIONES
    
    // PRIMER TEST PARA COLECCION SET
    @Test (expected = ProductoDuplicadoException.class)
    public void testQueAlQuererAgregarUnProductoQueEstaDuplicadoNoPermitaAgregarlaAlListadoConSet() {
    	
    	//Realizar el manejo de excepcion: ProductoDuplicadoException, (chequeen que el add devuelve true false....)
    	
    	// Eligo la lista de set que quiero usar
    	candyBar.elegirListaSet(listaProductosHashSet);
    	
    	//Agrego dos productos diferentes
         assertTrue(candyBar.agregarProductoSet(palomitas));
         assertEquals(1, candyBar.contarProductosEnInventarioSet());
         assertTrue(candyBar.agregarProductoSet(refresco));
         assertEquals(2, candyBar.contarProductosEnInventarioSet());
         
         //Agrego 1 producto que ya fue agregado a la lista y que se considera duplicado
         candyBar.agregarProductoSet(palomitas);
         assertEquals(2, candyBar.contarProductosEnInventarioSet());
    	
    }
    
    @Test
    public void testQueAlQuererEncontrarUnProductoQueExistaEnElInventarioMeDevuelvaTrue() {
    	
    	// Eligo la lista de set que quiero usar
    	candyBar.elegirListaSet(listaProductosHashSet);
    	
    	//Agrego productos
        assertTrue(candyBar.agregarProductoSet(refresco));
        assertTrue(candyBar.agregarProductoSet(caramelos));
        assertTrue(candyBar.agregarProductoSet(palomitas));
    	
    	//Busco un producto que exista en el inventario de Candy bar  
        assertTrue(candyBar.buscarProductoSet(palomitas));
    }
    
    
    @Test (expected = ProductoNoEncontradoException.class)
    public void testQueAlQuererEncontrarUnProductoQueNoExisteEnElInventarioLanzeExcepcionYConSet() {
    	
    	//Realizar el manejo de excepcion: ProductoNoEncontradoException, (chequeen que el add devuelve true false....)
    	
    	// Eligo la lista de set que quiero usar
    	candyBar.elegirListaSet(listaProductosHashSet);
    	
    	//Agrego productos
        assertTrue(candyBar.agregarProductoSet(refresco));
        assertTrue(candyBar.agregarProductoSet(caramelos));
        assertTrue(candyBar.agregarProductoSet(palomitas));
    	
    	//Busco un producto que exista en el inventario de Candy bar  
        assertTrue(candyBar.buscarProductoSet(palomitas));
        
        //Busco un producto que no exista en el inventario de Candy bar y lanze excepcion
        candyBar.buscarProductoSet(nachos);
    }
    
    
    
    
    
    
    
	private int contarProductosEnInventario() {
        int count = 0;
        for (Producto p : candyBar.obtenerInventario()) {
            if (p != null) {
                count++;
            }
        }
        
        
        
        return count;
    }
    
	
	
	
    
    
}
