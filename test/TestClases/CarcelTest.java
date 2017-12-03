package TestClases;


import org.junit.Assert;
import org.junit.Test;

import Clases.AlgoPoly;
import Clases.Carcel;
import Clases.Jugador;

public class CarcelTest {
	
	@Test
	public void Test01SiJugadorCaeEnUnaCarcelNoPuedeRealizarAcciones() {
		Jugador jugador = new Jugador();
		Carcel carcel = Carcel.getInstancia();
		carcel.entrar(jugador);
		Assert.assertFalse(AlgoPoly.getInstancia().puedeHacerAcciones(jugador));
	}
	
	@Test
	public void Test02JugadorNoPuedePagarFianzaSiNoPasoMasDeUnTurnoEnLaCarcel() {
		Jugador jugador = new Jugador();
		Carcel carcel = Carcel.getInstancia();
		carcel.entrar(jugador);
		Assert.assertEquals(false, jugador.puedePagarFianzaDeCarcel());
	}
	
	@Test 
	public void Test03JugadorPuedePagarFianzaDespuesDeUnTurnoEnCarcel() {
		Jugador jugador = new Jugador();
		Carcel carcel = Carcel.getInstancia();
		carcel.entrar(jugador);
		carcel.aumentarTurno(jugador);
		carcel.aumentarTurno(jugador);
		Assert.assertTrue(jugador.puedePagarFianzaDeCarcel());
	}
	
	@Test
	public void Test04JugardorAlPagarFianzaPuedeVolverAJugarAutomaticamente() {
		Jugador jugador = new Jugador();
		Carcel carcel = Carcel.getInstancia();
		carcel.entrar(jugador);
		carcel.aumentarTurno(jugador);
		carcel.aumentarTurno(jugador);
		jugador.pagarFianzaDeCarcel();
		Assert.assertTrue(AlgoPoly.getInstancia().puedeHacerAcciones(jugador));
	}
	
	
	@Test 
	public void Test05JugadorNoSePuedeMoverAunEnElTercerTurnoEnLaCarcel() {
		Jugador jugador = new Jugador();
		Carcel carcel = Carcel.getInstancia();
		carcel.entrar(jugador);
		carcel.aumentarTurno(jugador);
		carcel.aumentarTurno(jugador);
		carcel.aumentarTurno(jugador);
		Assert.assertFalse( AlgoPoly.getInstancia().puedeHacerAcciones(jugador));
	}
	
	@Test
	public void Test06JugadorDespuesDelCuartoTurnoPuedeMoverse() {
		Jugador jugador = new Jugador();
		Carcel carcel = Carcel.getInstancia();
		carcel.entrar(jugador);
		carcel.aumentarTurno(jugador);
		carcel.aumentarTurno(jugador);
		carcel.aumentarTurno(jugador);
		carcel.aumentarTurno(jugador);
		Assert.assertTrue( AlgoPoly.getInstancia().puedeHacerAcciones(jugador));
	}

}


