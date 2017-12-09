package TestClases;

import static org.junit.Assert.*;

import org.junit.Test;

import Clases.BSNorte;
import Clases.BSSur;
import Clases.Jugador;
import Clases.ProvinciaDividida;

public class JugadorTest {

	@Test
	public void test01JugadorPuedeConstruirSiCompraLasDosMitadesDeLaProvincia() {
		Jugador jugador = new Jugador();
		ProvinciaDividida mitad1 = new BSNorte();
		ProvinciaDividida mitad2 = new BSSur();
		mitad1.agregarOpuesto(mitad2);
		mitad1.comprar(jugador);
		mitad2.comprar(jugador);
		assertTrue(jugador.puedeEdificar());
	}
	
	@Test
	public void test02JugadorNoPuedeConstruirSiNoTieneLasDosMitadesDeLaProvincia(){
		Jugador jugador = new Jugador();
		ProvinciaDividida mitad1 = new BSNorte();
		ProvinciaDividida mitad2 = new BSSur();
		mitad1.agregarOpuesto(mitad2);
		mitad1.comprar(jugador);
		assertFalse(jugador.puedeEdificar());
	}

}
