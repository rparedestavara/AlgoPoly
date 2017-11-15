package TestConsignasPrimeraEntrega;



import org.junit.Assert;
import org.junit.Test;

import Clases.Carcel;
import Clases.Casilla;
import Clases.Jugador;
import Clases.Policia;
import Clases.Quini6;
import Clases.Tablero;
import excepciones.NoPuedeJugarException;
import excepciones.SaldoInsuficienteException;


public class PrimeraEntregaIntegrationTest {

	@Test
	public void Test01Quini6AgregaDineroLaPrimeraVezQueElJugadorGana() {
		Jugador jugador=new Jugador();
		Casilla quini6= new Quini6();
		int dineroSinGanarQuini6 = jugador.getDinero();
		quini6.entrar(jugador);
		Assert.assertEquals(dineroSinGanarQuini6 + 50000, jugador.getDinero());
	}
	
	@Test
	public void Test02Quini6AgregaDineroLaSegundaVezQueElJugadorGana() {
		Jugador jugador=new Jugador();
		Casilla quini6= new Quini6();
		quini6.entrar(jugador);
		int dineroGanandoUnaVez = jugador.getDinero();
		quini6.entrar(jugador);
		Assert.assertEquals(30000, jugador.getDinero()-dineroGanandoUnaVez);
	}
	
	@Test
	public void Test03Quini6NoAgregaDineroAJugadorDesdeLaTerceraVezQueGana() {
		Jugador jugador=new Jugador();
		Casilla quini6= new Quini6();
		quini6.entrar(jugador);
		quini6.entrar(jugador);
		int dineroGanandoDosVeces = jugador.getDinero();
		quini6.entrar(jugador);
		Assert.assertEquals(dineroGanandoDosVeces, jugador.getDinero());
		quini6.entrar(jugador);
		Assert.assertEquals(dineroGanandoDosVeces, jugador.getDinero());
	}
	
	
	@Test
	public void Test04SiJugadorCaeEnUnaCarcelNoPuedeMoverse() {
		Jugador jugador = new Jugador();
		Carcel carcel = Carcel.getInstancia();
		Tablero tablero = Tablero.getInstancia();
		carcel.entrar(jugador);
		try {
			tablero.mover(jugador, 1);
			Assert.fail("Jugador esta en carcel, no se puede mover");
		}catch (NoPuedeJugarException e) {}
	}
	
	@Test
	public void Test05JugadorPagaFianzaYLuegoSePuedeMover(){
		Jugador jugador = new Jugador();
		Carcel carcel = Carcel.getInstancia();
		carcel.entrar(jugador);
		carcel.aumentarTurno(jugador);
		carcel.aumentarTurno(jugador);
		carcel.aumentarTurno(jugador);
		jugador.pagarFianzaDeCarcel();
		Assert.assertTrue(jugador.puedeHacerAcciones());
	}
	
	@Test
	public void Test06JugadorNoPuedePagarFianzaEntoncesNoSePuedeMover(){
		Jugador jugador = new Jugador();
		Carcel carcel = Carcel.getInstancia();
		jugador.pagar(100000);
		carcel.entrar(jugador);
		carcel.aumentarTurno(jugador);
		carcel.aumentarTurno(jugador);
		carcel.aumentarTurno(jugador);
		try {
			jugador.pagarFianzaDeCarcel();
			Assert.fail("Jugador si puede pagar");
		}catch (SaldoInsuficienteException e) {}
		finally {
			Assert.assertFalse(jugador.puedeHacerAcciones());
		}
	}
	@Test
	public void Test07JugadorCaeEnPoliciaVaALaCarcelYNoPuedeMoverse(){
		Jugador jugador = new Jugador();
		Policia policia = Policia.getInstancia();
		policia.entrar(jugador);
		Carcel carcel = Carcel.getInstancia();
		Assert.assertTrue(carcel.enCarcel(jugador));
		try {
			Tablero.getInstancia().mover(jugador, 5);
			Assert.fail("El jugador se puede mover");
		}catch (NoPuedeJugarException e) {}
	}
}
