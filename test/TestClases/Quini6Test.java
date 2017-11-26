package TestClases;

import  org.junit.Assert;
import org.junit.Test;

import Clases.Jugador;
import Clases.Quini6;
import Clases.Casilla;


public class Quini6Test {
	private static final double DELTA = 1e-15;
	@Test
	public void Test1Quini6AgregaDineroLaPrimeraVezQueElJugadorGana() {
		Jugador jugador=new Jugador();
		Casilla quini6= new Quini6();
		quini6.entrar(jugador);
		Assert.assertEquals(150000, jugador.getDinero(),DELTA);
	}
	
	@Test
	public void Test2Quini6AgregaDineroLaSegundaVezQueElJugadorGana() {
		Jugador jugador=new Jugador();
		Casilla quini6= new Quini6();
		quini6.entrar(jugador);
		double dineroGanandoUnaVez = jugador.getDinero();
		quini6.entrar(jugador);
		Assert.assertEquals(30000, jugador.getDinero()-dineroGanandoUnaVez,DELTA);
	}
	
	@Test
	public void Test3Quini6NoAgregaDineroAJugadorDesdeLaTerceraVezQueGana() {
		Jugador jugador=new Jugador();
		Casilla quini6= new Quini6();
		quini6.entrar(jugador);
		quini6.entrar(jugador);
		double dineroGanandoDosVeces = jugador.getDinero();
		quini6.entrar(jugador);
		Assert.assertEquals(dineroGanandoDosVeces, jugador.getDinero(),DELTA);
		quini6.entrar(jugador);
		Assert.assertEquals(dineroGanandoDosVeces, jugador.getDinero(),DELTA);
	}
}