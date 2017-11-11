package TestClases;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import Clases.AvanceDinamico;
import Clases.Jugador;
import Clases.Tablero;

public class AvanceDinamicoTest {

	@Test
	public void test01EntrarEnAvanceDinamicoCon4AvanzaLaCantidadCorrecta() {
		Jugador jugador = new Jugador();
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		Tablero tablero = new Tablero(jugadores);
		AvanceDinamico avanceDinamico = new AvanceDinamico();
		jugador.setResultadoDados(4);
		jugador.setTablero(tablero);
		avanceDinamico.entrar(jugador);
		Assert.assertEquals(2, tablero.getPosicion(jugador));
	}

	@Test
	public void test02EntrarEnAvanceDinamicoCon8AvanzaLaCantidadCorrecta() {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador1);
		jugadores.add(jugador2);
		Tablero tablero = new Tablero(jugadores);
		AvanceDinamico avanceDinamico = new AvanceDinamico();
		int resultadoDados = 8;
		jugador1.setResultadoDados(resultadoDados);
		jugador1.setTablero(tablero);
		avanceDinamico.entrar(jugador1);
		tablero.mover(jugador2, jugador1.getDinero() * resultadoDados);
		Assert.assertEquals(tablero.getPosicion(jugador1), tablero.getPosicion(jugador2));
	}	
	
	
}
