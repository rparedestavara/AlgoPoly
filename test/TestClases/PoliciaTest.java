package TestClases;


import org.junit.Assert;
import org.junit.Test;

import Clases.AlgoPoly;
import Clases.Carcel;
import Clases.Jugador;
import Clases.Policia;

public class PoliciaTest {

	@Test
	public void Test01SiJugadorCaeEnPolicialNoPuedeRealizarAcciones() {
		Jugador jugador = new Jugador();
		Policia policia = Policia.getInstancia();
		policia.entrar(jugador);
		Assert.assertFalse(AlgoPoly.getInstancia().puedeHacerAcciones(jugador));
	}
	
	@Test
	public void Test02SiJugadorCaeEnPolicialPasaAEstarEnLaCarcel() {
		Jugador jugador = new Jugador();
		Policia policia = Policia.getInstancia();
		policia.entrar(jugador);
		Carcel carcel = Carcel.getInstancia();
		Assert.assertTrue(carcel.enCarcel(jugador));
	}
}