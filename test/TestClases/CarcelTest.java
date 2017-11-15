package TestClases;


import org.junit.Assert;
import org.junit.Test;

import Clases.Carcel;
import Clases.Jugador;

public class CarcelTest {
	
	@Test
	public void Test01SiJugadorCaeEnUnaCarcelNoPuedeRealizarAcciones() {
		Jugador jugador = new Jugador();
		Carcel carcel = Carcel.getInstancia();
		carcel.entrar(jugador);
		Assert.assertFalse(jugador.puedeHacerAcciones());
	}
	
	@Test
	public void Test02JugadorNoPuedePagarFianzaSiNoPasoMasDeDosTurnoEnLaCarcel() {
		Jugador jugador = new Jugador();
		Carcel carcel = Carcel.getInstancia();
		carcel.entrar(jugador);
		jugador.aumentarTurnosEnCarcel();
		Assert.assertEquals(false, jugador.puedePagarFianzaDeCarcel());
	}
	
	@Test 
	public void Test03JugadorPuedePagarFianzaDespuesDeDosTurnos() {
		Jugador jugador = new Jugador();
		Carcel carcel = Carcel.getInstancia();
		carcel.entrar(jugador);
		jugador.aumentarTurnosEnCarcel();
		jugador.aumentarTurnosEnCarcel();
		Assert.assertTrue(jugador.puedePagarFianzaDeCarcel());
	}
	
	@Test
	public void Test04JugardorAlPagarFianzaPuedeVolverAJugarAutomaticamente() {
		Jugador jugador = new Jugador();
		Carcel carcel = Carcel.getInstancia();
		carcel.entrar(jugador);
		jugador.aumentarTurnosEnCarcel();
		jugador.aumentarTurnosEnCarcel();
		jugador.pagarFianzaDeCarcel();
		Assert.assertTrue(jugador.puedeHacerAcciones());
	}
	
	
	@Test 
	public void Test05JugadorNoSePuedeMoverAunEnElTercerTurnoEnLaCarcel() {
		Jugador jugador = new Jugador();
		Carcel carcel = Carcel.getInstancia();
		carcel.entrar(jugador);
		jugador.aumentarTurnosEnCarcel();
		jugador.aumentarTurnosEnCarcel();
		jugador.aumentarTurnosEnCarcel();
		Assert.assertFalse( jugador.puedeHacerAcciones());
	}
	
	@Test
	public void Test06JugadorDespuesDelCuartoTurnoPuedeMoverse() {
		Jugador jugador = new Jugador();
		Carcel carcel = Carcel.getInstancia();
		carcel.entrar(jugador);
		jugador.aumentarTurnosEnCarcel();
		jugador.aumentarTurnosEnCarcel();
		jugador.aumentarTurnosEnCarcel();
		jugador.aumentarTurnosEnCarcel();
		jugador.pagarFianzaDeCarcel();
		Assert.assertTrue( jugador.puedeHacerAcciones());
	}

}


