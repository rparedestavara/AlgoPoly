package TestConsignas;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import Clases.Dados;
import Clases.Jugador;
import Clases.Turno;

public class TerceraEntregaIntegrationTest {

	@Test
	public void test01CuandoUnJugadorLanzaDoblesTurnoIndicaQueJuegaDevuelta() {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Jugador jugador3 = new Jugador();
		List<Jugador> jugadores = Arrays.asList(jugador1,jugador2,jugador3);
		Turno turno = new Turno(jugadores);
		Dados dados = Dados.getInstance();
		int[] resultados={3,3};
		dados.setResultados(resultados);
		Jugador jugadorActual = turno.aQuienLeToca();
		Assert.assertEquals(jugadorActual, turno.proximoTurno());
	}
	
	@Test
	public void test02CuandoUnJugadorLanzaDoblesDosVecesSeguidasTurnoIndicaQueJuegaElProximoJugador() {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Jugador jugador3 = new Jugador();
		List<Jugador> jugadores = Arrays.asList(jugador1,jugador2,jugador3);
		Turno turno = new Turno(jugadores);
		Dados dados = Dados.getInstance();
		int[] resultados={3,3};
		dados.setResultados(resultados);
		Jugador jugadorActual = turno.aQuienLeToca();
		turno.proximoTurno();
		Assert.assertNotEquals(jugadorActual, turno.proximoTurno());
	}

}
