package TestClases;

import  org.junit.Assert;

import org.junit.Test;

import Clases.Barrio;
import Clases.Carcel;
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
	
	@Test
	public void Test3Quini6NoDaDineroAJugadorSiYaCayoMasDeDosVeces() {
		Jugador jugador=new Jugador();
		Quini6 quini6= new Quini6();
		quini6.entrar(jugador);
		quini6.entrar(jugador);
		int dineroGanandoUnaVez = jugador.getDinero();
		quini6.entrar(jugador);
		Assert.assertEquals(0, jugador.getDinero()-dineroGanandoUnaVez);
	}
	
	@Test
	public void  Test4VerQueJugadorQueCaeEnUnBarrioSeAduexaDeEste() {
		Jugador jugador = new Jugador("Aaron");
		Barrio unBarrio= new Barrio();
		unBarrio.agregarNuevoDuexo(jugador);
		Assert.assertEquals("Aaron",jugador.getNombre());
	}
	
	@Test
	public void Test5SiJugadorCaeEnUnaCarcelNoPuedeRealizarAcciones() {
		Jugador jugador = new Jugador("Aaron");
		Carcel carcel=new Carcel();
		carcel.encarcelarA(jugador);
		jugador.informarQueEstaEn(carcel);
		Assert.assertEquals(false, !jugador.puedeHacerAcciones());
	}

}
