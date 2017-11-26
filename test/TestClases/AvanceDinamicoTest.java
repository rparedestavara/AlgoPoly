package TestClases;

import org.junit.Assert;
import org.junit.Test;


import java.util.ArrayList;

import Clases.AvanceDinamico;
import Clases.Dados;
import Clases.Jugador;
import Clases.Tablero;

public class AvanceDinamicoTest {
	private static final double DELTA = 1e-15;
	@Test
	public void test01EntrarEnAvanceDinamicoConRango2a6AvanzaLaCantidadCorrecta() {
		Jugador jugador= new Jugador();
		Tablero tablero=Tablero.getInstancia();
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		tablero.agregarJugadores(jugadores);
		AvanceDinamico avanceDinamico = new AvanceDinamico();
		Dados dados=Dados.getInstance();
		int posInicialJugador=tablero.getPosicion(jugador);
		int[] resultados={2,2};
		dados.setResultados(resultados);
		avanceDinamico.entrar(jugador);
		Assert.assertEquals(dados.getResultado()-2,(tablero.getPosicion(jugador)-posInicialJugador));
	}

	@Test
	public void test02EntrarEnAvanceDinamicoConRango7a10AvanzaLaCantidadCorrecta() {
		Jugador jugador= new Jugador();
		Tablero tablero=Tablero.getInstancia();
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		tablero.agregarJugadores(jugadores);
		AvanceDinamico avanceDinamico = new AvanceDinamico();
		Dados dados=Dados.getInstance();
		int posInicialJugador=tablero.getPosicion(jugador);
		int[] resultados={3,4};
		dados.setResultados(resultados);
		avanceDinamico.entrar(jugador);
		Assert.assertEquals(100000%7,jugador.getDinero()%dados.getResultado()-posInicialJugador,DELTA);
	}
	
	@Test
	public void test03EntrarEnAvanceDinamicoCon11o12AvanzaLaCantidadCorrecta() {
		Jugador jugador= new Jugador();
		Tablero tablero=Tablero.getInstancia();
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		tablero.agregarJugadores(jugadores);
		AvanceDinamico avanceDinamico = new AvanceDinamico();
		Dados dados=Dados.getInstance();
		int posInicialJugador=tablero.getPosicion(jugador);
		jugador.agregarPropiedad();
		jugador.agregarPropiedad();
		int[] resultados={5,6};
		dados.setResultados(resultados);
		avanceDinamico.entrar(jugador);
		int resultadoFinal=tablero.getPosicion(jugador)-posInicialJugador;
		Assert.assertEquals(11-2,resultadoFinal);
	}
	
	
}