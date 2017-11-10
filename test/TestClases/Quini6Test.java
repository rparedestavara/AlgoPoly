package TestClases;

import  org.junit.Assert;

import org.junit.Test;

import Clases.Barrio;
import Clases.Carcel;
import Clases.Jugador;
import Clases.Quini6;


public class Quini6Test {

	@Test
	public void Test1Quini6AgregaDineroPorPrimeraVezAJugador() {
		Jugador jugador=new Jugador();
		Quini6 quini6= new Quini6();
		quini6.entrar(jugador);
		Assert.assertEquals(150000, jugador.getDinero());
	}
	
	@Test
	public void Test2Quini6AgregaDineroPorSegundaVezAJugador() {
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
		int dineroGanandoDosVeces = jugador.getDinero();
		quini6.entrar(jugador);
		int dineroGanandoPorTerceraVez = jugador.getDinero();
		Assert.assertEquals(dineroGanandoDosVeces, dineroGanandoPorTerceraVez);
	}
	
	@Test
	public void Test4VerQueJugadorQueCaeEnUnBarrioSeAduexaDeEste() {
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
