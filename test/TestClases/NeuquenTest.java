package TestClases;

import org.junit.Assert;

import org.junit.Test;

import Clases.Jugador;
import Clases.Neuquen;
import Clases.Provincia;

public class NeuquenTest {
	
	@Test
	public void testJugadorCompraProvinciaSeLeReduceCorrectamente() {
		Provincia neuquen = new Neuquen();
		Jugador jugador= new Jugador();
		int precioAntesDeLaCompra = jugador.getDinero();
		neuquen.agregarPropietario(jugador);
		Assert.assertEquals(17000,precioAntesDeLaCompra-jugador.getDinero());
	}

	@Test
	public void testConstruyeCasaAumenteCorrectamentElNumeroDeCasasQuePosee() {
		Provincia neuquen = new Neuquen();
		Jugador jugador= new Jugador();
		neuquen.agregarPropietario(jugador);
		neuquen.construirCasa();
		Assert.assertEquals(1,neuquen.cantCasasConstruidas());
	}
	
	@Test
	public void testSeQuiereCostruirMasDeDosCasasYNoSePuede() {
		Provincia neuquen = new Neuquen();
		Jugador jugador= new Jugador();
		neuquen.agregarPropietario(jugador);
		neuquen.construirCasa();
		neuquen.construirCasa();
		Assert.assertEquals(1,neuquen.cantCasasConstruidas());
	}

}
