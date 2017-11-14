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
	public void Test02JugadorNoPuedePagarFianzaSiNoAPasadoMasDeDosTurnoEnLaCarcel() {
		Jugador jugador = new Jugador();
		Carcel carcel = Carcel.getInstancia();
		carcel.entrar(jugador);
		jugador.aumentarTurnosEnCarcel();
		Assert.assertEquals(false, jugador.puedePagarFianzaDeCarcel());
	}
	
	@Test 
	public void Test03JugadorPuedePagarFianzaDespuesDeDosTurno() {
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
	public void Test05JugadorAlPagarFianzaNoLopuedeHacerPorFaltaDeFondosYNoSePuedeMover() {
		Jugador jugador = new Jugador();
		Carcel carcel = Carcel.getInstancia();
		carcel.entrar(jugador);
		jugador.aumentarTurnosEnCarcel();
		jugador.aumentarTurnosEnCarcel();
		jugador.pagar(80000);
		jugador.pagarFianzaDeCarcel();
		Assert.assertFalse(jugador.puedeHacerAcciones());
	}
	
	@Test 
	public void Test06JugardorNoSePuedeMoverAunEnElTerceTurnoEnLaCarcel() {
		Jugador jugador = new Jugador();
		Carcel carcel = Carcel.getInstancia();
		carcel.entrar(jugador);
		jugador.aumentarTurnosEnCarcel();
		jugador.aumentarTurnosEnCarcel();
		jugador.aumentarTurnosEnCarcel();
		Assert.assertFalse( jugador.puedeHacerAcciones());
	}
	
	@Test
	public void Test07JugadorDespuesDelCuartoTurnoPuedeMoverse() {
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


