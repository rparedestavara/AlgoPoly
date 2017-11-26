package TestConsignas;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import Clases.Jugador;
import Clases.Tablero;

public class OtrosIntegrationTest {
	private static final double DELTA = 1e-15;
	@Test
	public void test01AlRealizarUnaJugadaEnElTableroCon10ElJugadorEntraEnImpuestoAlLujo() {
		Jugador jugador = new Jugador();
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		Tablero tablero = Tablero.getInstancia();
		tablero.agregarJugadores(jugadores);
		double dineroInicialJugador = jugador.getDinero();
		tablero.jugada(jugador, 10);
		Assert.assertEquals(dineroInicialJugador * 0.9, jugador.getDinero(), 5);
	}

}
