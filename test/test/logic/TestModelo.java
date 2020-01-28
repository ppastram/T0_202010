package test.logic;

import static org.junit.Assert.*;
import model.logic.Modelo;

import org.junit.Before;
import org.junit.Test;

public class TestModelo {
	
	private Modelo modelo;
	private static int CAPACIDAD=100;
	
	@Before
	public void setUp1() {
		modelo= new Modelo(CAPACIDAD);
	}

	public void setUp2() {
		for(int i =0; i< CAPACIDAD;i++){
			modelo.agregar(""+i);
		}
	}

	@Test
	public void testModelo() {
		assertTrue(modelo!=null);
		assertEquals(0, modelo.darTamano());  // Modelo con 0 elementos presentes.
	}

	@Test
	public void testDarTamano() {
		// TODO
		setUp1();
		
		assertTrue(modelo!=null);
		assertEquals(0, modelo.darTamano());  // Modelo con 00 elementos presentes.
		
		modelo.agregar('q');
		modelo.agregar(39987387);
		modelo.agregar(33.22);

		
		assertEquals(3, modelo.darTamano());  // Modelo con 3 elementos presentes.

	}

	@Test
	public void testAgregar() {
		// TODO Completar la prueba
		
		modelo.agregar("qwerty");	
		modelo.agregar(2);	
		modelo.agregar(false);
		
		assertEquals(modelo.datos.darElemento(0), "qwerty" );
		assertEquals(modelo.datos.darElemento(1), 2 );
		assertEquals(modelo.datos.darElemento(2), false );
		
	}

	@Test
	public void testBuscar() {
		setUp2();
		// TODO Completar la prueba
		
		assertEquals("3", modelo.buscar("3") );  // Sí existe
		
		assertEquals("99", modelo.buscar("99") );  // Sí existe
		
		assertEquals(null, modelo.buscar("-1") );  // No existe

		assertEquals(null, modelo.buscar("101") );  // No existe


	}

	@Test
	public void testEliminar() {
		setUp2();
		// TODO Completar la prueba
		
		modelo.eliminar("77");
		
		assertEquals(99, modelo.darTamano() );  // El tamaño decreció
		assertEquals(null, modelo.buscar("77") );  // No existe
		assertEquals("78", modelo.datos.darElemento(77) );  // Quedó compacta


		
	}

}
