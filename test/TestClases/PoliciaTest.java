package TestClases;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import Clases.Carcel;
import Clases.Jugador;
import Clases.Policia;
import Clases.Tablero;

public class PoliciaTest {

	@Test
	public void Test01SiJugadorCaeEnPolicialNoPuedeRealizarAcciones() {
		Jugador jugador = new Jugador();
		Policia policia = Policia.getInstancia();
		policia.entrar(jugador);
		Assert.assertFalse(jugador.puedeHacerAcciones());
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