package TestConsignasPrimeraEntrega;

import org.junit.Assert;
import org.junit.Test;

import Clases.Casilla;
import Clases.Jugador;
import Clases.Quini6;

public class PrimeraEntregaIntegrationTest {

	@Test
	public void Test01Quini6AgregaDineroPorPrimeraVezAJugador() {
		Jugador jugador = new Jugador();
		Casilla quini6 = new Quini6();
		int capitalSinQuini6 = jugador.getDinero();
		quini6.entrar(jugador);
		Assert.assertEquals(capitalSinQuini6 + 50000, jugador.getDinero());
	}
	
	@Test
	public void Test02Quini6AgregaTreintaMilSiGanaPorSegunda() {
		Jugador jugador = new Jugador();
		Casilla quini6 = new Quini6();
		quini6.entrar(jugador);
		int dineroGanandoUnaVez = jugador.getDinero();
		quini6.entrar(jugador);
		Assert.assertEquals(30000 + dineroGanandoUnaVez, jugador.getDinero());
	}
	
	@Test
	public void Test03Quini6NoDaDineroAJugadorSiYaCayoMasDeDosVeces() {
		Jugador jugador = new Jugador();
		Casilla quini6 = new Quini6();
		quini6.entrar(jugador);
		quini6.entrar(jugador);
		int dineroGanandoDosVeces = jugador.getDinero();
		quini6.entrar(jugador);
		int dineroGanandoPorTresVeces = jugador.getDinero();
		Assert.assertEquals(dineroGanandoDosVeces, dineroGanandoPorTresVeces);
	}

}
