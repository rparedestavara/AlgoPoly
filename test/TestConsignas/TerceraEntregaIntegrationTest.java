package TestConsignas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import Clases.AlgoPoly;
import Clases.BSSur;
import Clases.Dados;
import Clases.Jugador;
import Clases.Tablero;
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
		Assert.assertNotSame(jugadorActual, turno.proximoTurno());
	}
	
	@Test
	public void test06CuandoUnjugadorNoTienePlataPeroTienePropiedadesLasVendeHastaQuePuedaPagar() {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Jugador jugador3 = new Jugador();
		Tablero tablero = Tablero.getInstancia();
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador1);
		jugadores.add(jugador2);
		jugadores.add(jugador3);
		AlgoPoly.getInstancia().agregarJugadores(jugadores);
		tablero.agregarJugadores(jugadores);
		Turno turno = new Turno(jugadores);
		AlgoPoly.getInstancia().agregarTurno(turno);
		
		double dineroInicial = jugador1.getDinero();
		jugador1.modificarDinero(-dineroInicial);
		jugador1.modificarDinero(20000);
		BSSur bs = new BSSur();
		bs.entrar(jugador1);
		jugador1.modificarDinero(-20000);
		Assert.assertFalse(turno.estaJugando(jugador1));
	}
	
	@Test
	public void test07CuandoQuedaUnSoloJugadorEseJugadorGana() {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Jugador jugador3 = new Jugador();
		Tablero tablero = Tablero.getInstancia();
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador1);
		jugadores.add(jugador2);
		jugadores.add(jugador3);
		tablero.agregarJugadores(jugadores);
		Turno turno = new Turno(jugadores);
		AlgoPoly.getInstancia().agregarTurno(turno);
		
		double dineroInicial = jugador1.getDinero();
		jugador1.modificarDinero(-dineroInicial -1);
		jugador2.modificarDinero(-dineroInicial -1);
		Assert.assertNotNull(AlgoPoly.getInstancia().hayGanador());
	}
	
}
