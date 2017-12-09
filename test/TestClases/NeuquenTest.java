package TestClases;

import org.junit.Assert;

import org.junit.Test;

import Clases.Jugador;
import Clases.Neuquen;
import Clases.Provincia;

public class NeuquenTest {
	private static final double DELTA = 1e-15;	
	@Test
	public void testJugadorCompraProvinciaSeLeReduceCorrectamente() {
		Provincia neuquen = new Neuquen();
		Jugador jugador= new Jugador();
		double precioAntesDeLaCompra = jugador.getDinero();
		neuquen.comprar(jugador);
		Assert.assertEquals(17000,precioAntesDeLaCompra-jugador.getDinero(),DELTA);
	}

	@Test
	public void testConstruyeCasaAumenteCorrectamentElNumeroDeCasasQuePosee() {
		Provincia neuquen = new Neuquen();
		Jugador jugador= new Jugador();
		neuquen.comprar(jugador);
		neuquen.construirCasa();
		Assert.assertEquals(1,neuquen.cantCasasConstruidas());
	}
	
	@Test
	public void testSeQuiereCostruirMasDeDosCasasYNoSePuede() {
		Provincia neuquen = new Neuquen();
		Jugador jugador= new Jugador();
		neuquen.comprar(jugador);
		neuquen.construirCasa();
		neuquen.construirCasa();
		Assert.assertEquals(1,neuquen.cantCasasConstruidas());
	}

}
