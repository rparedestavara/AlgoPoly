package TestClases;

import  org.junit.Assert;

import org.junit.Test;

import Clases.Jugador;
import Clases.Quini6;


public class TestQuini6 {

	@Test
	public void Test1Quini6AgregaDinneroPorPrimeraVezAJugador() {
		Jugador jugador=new Jugador();
		Quini6 quini6= new Quini6();
		quini6.entrar(jugador);
		Assert.assertEquals(150000, jugador.getDinero());
	}
	
	@Test
	public void Test2Quini6AgregaDinneroPorSedundaVezAJugador() {
		Jugador jugador=new Jugador();
		Quini6 quini6= new Quini6();
		quini6.entrar(jugador);
		int dineroGanandoUnaVez = jugador.getDinero();
		quini6.entrar(jugador);
		Assert.assertEquals(30000, jugador.getDinero()-dineroGanandoUnaVez);
	}

}
