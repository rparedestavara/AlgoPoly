package TestClases;


import org.junit.Assert;
import org.junit.Test;

import Clases.Provincia;
import Clases.BSNorte;
import Clases.Jugador;

public class BarrioTest {

	@Test
	public void Test01VerQueJugadorQueCompraEnUnBarrioEsPropietario() {
		Jugador jugador = new Jugador();
		Provincia unBarrio= new BSNorte();
		unBarrio.comprar(jugador);
		Assert.assertEquals(jugador ,unBarrio.getPropietario());
	}
}	
	
