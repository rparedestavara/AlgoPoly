package TestClases;


import org.junit.Assert;
import org.junit.Test;

import Clases.Barrio;
import Clases.Jugador;

public class BarrioTest {

	@Test
	public void Test01VerQueJugadorQueCompraEnUnBarrioEsPropietario() {
		Jugador jugador = new Jugador();
		Barrio unBarrio= new Barrio();
		unBarrio.entrar(jugador);
		Assert.assertEquals(jugador ,unBarrio.getPropietario());
	}
}	
	
