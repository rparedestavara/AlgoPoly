package TestConsignasPrimeraEntrega;

import org.junit.Assert;
import org.junit.Test;

import Clases.Carcel;
import Clases.Casilla;
import Clases.Jugador;
import Clases.Quini6;
import Clases.Tablero;
import excepciones.NoPuedeJugarException;


public class PrimeraEntregaIntegrationTest {

	@Test
	public void Test01Quini6AgregaDineroLaPrimeraVezQueElJugadorGana() {
		Jugador jugador=new Jugador();
		Casilla quini6= new Quini6();
		quini6.entrar(jugador);
		Assert.assertEquals(150000, jugador.getDinero());
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
	public void Test04SiJugadorCaeEnUnaCarcelNoPuedeRealizarAcciones() {
		Jugador jugador = new Jugador();
		Carcel carcel = Carcel.getInstancia();
		Tablero tablero = Tablero.getInstancia();
		carcel.entrar(jugador);
		try {
			tablero.mover(jugador, 1);
			Assert.fail("Jugador esta en carcel, no se puede mover");
		}catch (NoPuedeJugarException e) {}
	}
}
