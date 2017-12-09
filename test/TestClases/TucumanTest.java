package TestClases;

import org.junit.Assert;
import org.junit.Test;

import Clases.Jugador;
import Clases.Provincia;
import Clases.Tucuman;

public class TucumanTest {
	private static final double DELTA = 1e-15;
	@Test
	public void testJugadorCompraProvinciaSeLeReduceCorrectamente() {
		Provincia tucuman = new Tucuman();
		Jugador jugador= new Jugador();
		double precioAntesDeLaCompra = jugador.getDinero();
		tucuman.comprar(jugador);
		Assert.assertEquals(25000,precioAntesDeLaCompra-jugador.getDinero(),DELTA);
	}

	@Test
	public void testConstruyeCasaAumenteCorrectamentElNumeroDeCasasQuePosee() {
		Provincia tucuman = new Tucuman();
		Jugador jugador= new Jugador();
		tucuman.comprar(jugador);
		tucuman.construirCasa();
		Assert.assertEquals(1,tucuman.cantCasasConstruidas());
	}
	
	@Test
	public void testSeQuiereCostruirMasDeDosCasasYNoSePuede() {
		Provincia tucuman = new Tucuman();
		Jugador jugador= new Jugador();
		tucuman.comprar(jugador);
		tucuman.construirCasa();
		tucuman.construirCasa();
		Assert.assertEquals(1,tucuman.cantCasasConstruidas());
	}
}
