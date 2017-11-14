package TestConsignasPrimeraEntrega;

import org.junit.Assert;
import org.junit.Test;

import Clases.Casilla;
import Clases.Jugador;
import Clases.Quini6;

public class PrimeraEntregaIntegrationTest {

	@Test
	public void Test1Quini6AgregaDineroLaPrimeraVezQueElJugadorGana() {
		Jugador jugador=new Jugador();
		Casilla quini6= new Quini6();
		quini6.entrar(jugador);
		Assert.assertEquals(150000, jugador.getDinero());
	}
	
	@Test
	public void Test2Quini6AgregaDineroLaSegundaVezQueElJugadorGana() {
		Jugador jugador=new Jugador();
		Casilla quini6= new Quini6();
		quini6.entrar(jugador);
		int dineroGanandoUnaVez = jugador.getDinero();
		quini6.entrar(jugador);
		Assert.assertEquals(30000, jugador.getDinero()-dineroGanandoUnaVez);
	}
	
	@Test
	public void Test3Quini6NoAgregaDineroAJugadorDesdeLaTerceraVezQueGana() {
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
}
