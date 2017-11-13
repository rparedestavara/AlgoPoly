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
		Policia policia = new Policia();
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		Tablero tablero = new Tablero(jugadores);
		policia.entrar(jugador);
		Assert.assertFalse(jugador.puedeHacerAcciones());
	}
	
	@Test
	public void Test02SiJugadorCaeEnPolicialPasaAEstarEnLaCarcel() {
		Jugador jugador = new Jugador();
		Policia policia = new Policia();
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		Tablero tablero = new Tablero(jugadores);
		policia.entrar(jugador);
		Carcel carcel = tablero.getCarcel();
		Assert.assertTrue(carcel.enCarcel(jugador));
	}
}
