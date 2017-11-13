package TestClases;

import org.junit.Assert;
import org.junit.Test;


import java.util.ArrayList;
import java.util.Random;

import Clases.AvanceDinamico;
import Clases.Jugador;
import Clases.Tablero;

public class AvanceDinamicoTest {

	@Test
	public void test01EntrarEnAvanceDinamicoConRango2a6AvanzaLaCantidadCorrecta() {
		Jugador jugador = new Jugador();
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		Tablero tablero = new Tablero(jugadores);
		AvanceDinamico avanceDinamico = new AvanceDinamico();
		
		int posicionInicial = tablero.getPosicion(jugador);
		Random dados = new Random();
		int resultadoDados = 2 + dados.nextInt(5); //genera un numero aleatorio entre 1 y 6 simulando los dados
		jugador.setResultadoDados(resultadoDados);
		avanceDinamico.entrar(jugador);
		int posicionFinal = tablero.getPosicion(jugador);
		
		Assert.assertEquals((resultadoDados-2),(posicionFinal - posicionInicial));
	}

	@Test
	public void test02EntrarEnAvanceDinamicoConRango7a10AvanzaLaCantidadCorrecta() {
		Jugador jugador1 = new Jugador();
		
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador1);
		
		Tablero tablero = new Tablero(jugadores);
		AvanceDinamico avanceDinamico = new AvanceDinamico();
		int posicionInicial = tablero.getPosicion(jugador1);
		Random dados = new Random();
		int resultadoDados = 7 + dados.nextInt(4);  //numero aleatorio entre 7 y 10
		jugador1.setResultadoDados(resultadoDados);
		avanceDinamico.entrar(jugador1);
		int posicionFinal = tablero.getPosicion(jugador1);
		Assert.assertEquals((jugador1.getDinero() % resultadoDados), (posicionFinal - posicionInicial));
	}
	
	@Test
	public void test03EntrarEnAvanceDinamicoCon11o12AvanzaLaCantidadCorrecta() {
		Jugador jugador = new Jugador();
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		Tablero tablero = new Tablero(jugadores);
		AvanceDinamico avanceDinamico = new AvanceDinamico();
		jugador.agregarPropiedad();
		int posicionInicial = tablero.getPosicion(jugador);
		Random dados = new Random();
		int resultadoDados = 11 + dados.nextInt(2);
		jugador.setResultadoDados(resultadoDados);
		avanceDinamico.entrar(jugador);
		int posicionFinal = tablero.getPosicion(jugador);
		Assert.assertEquals((resultadoDados-jugador.getCantidadDePropiedades()), posicionFinal-posicionInicial);
	}
	
	
}
