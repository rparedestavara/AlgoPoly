package TestClases;


import  org.junit.Assert;

import org.junit.Test;


import Clases.Jugador;
import Clases.Quini6;


public class Quini6Test {

	
	@Test
	public void Quini6ModificaElDineroDeJugador(){
		Quini6 quini = new Quini6();
		Jugador jugador = new Jugador();
		int dineroJugadorSinGanar = jugador.getDinero();
		quini.entrar(jugador);
		Assert.assertNotEquals(dineroJugadorSinGanar,jugador.getDinero());
	}

	
}
