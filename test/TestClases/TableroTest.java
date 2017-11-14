package TestClases;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import Clases.Jugador;
import Clases.Tablero;

public class TableroTest {

	@Test
	public void test01AlCrearTableroCon3JugadoresEstosEmpiezanEnLaPosicion0() {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Jugador jugador3 = new Jugador();
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador1);
		jugadores.add(jugador2);
		jugadores.add(jugador3);
		Tablero tablero = Tablero.getInstancia();
		tablero.agregarJugadores(jugadores);
		Assert.assertEquals(0, tablero.getPosicion(jugador1));
		Assert.assertEquals(0, tablero.getPosicion(jugador2));
		Assert.assertEquals(0, tablero.getPosicion(jugador3));
	}
	
	@Test
	public void test02UnJugadorEnSalidaTerminaEnLaPosicionCorrectaAlAvanzar7Lugares(){
		Jugador jugador = new Jugador();
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		Tablero tablero = Tablero.getInstancia();
		tablero.agregarJugadores(jugadores);
		tablero.mover(jugador,7);
		Assert.assertEquals(7, tablero.getPosicion(jugador));
	}
	
	@Test
	public void test03UnJugadorEnSalidaTerminaEnLaPosicionCorrectaAlRetroceder3Lugares(){
		Jugador jugador = new Jugador();
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		Tablero tablero = Tablero.getInstancia();
		tablero.agregarJugadores(jugadores);
		tablero.mover(jugador,-3);
		Assert.assertEquals(17, tablero.getPosicion(jugador));
	}
	
	@Test
	public void test04UnJugadorEnSalidaTerminaEnLaPosicionCorrectaAlAvanzar70Lugares(){
		Jugador jugador = new Jugador();
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		Tablero tablero = Tablero.getInstancia();
		tablero.agregarJugadores(jugadores);
		tablero.mover(jugador,70);
		Assert.assertEquals(10, tablero.getPosicion(jugador));
	}

	@Test
	public void test05UnJugadorEnSalidaTerminaEnLaPosicionCorrectaAlAvanzar25LugaresYRetroceder43(){
		Jugador jugador = new Jugador();
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		Tablero tablero = Tablero.getInstancia();
		tablero.agregarJugadores(jugadores);
		tablero.mover(jugador,25);
		tablero.mover(jugador,-43);
		Assert.assertEquals(2, tablero.getPosicion(jugador));
	}
}
