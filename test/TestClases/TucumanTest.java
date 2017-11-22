package TestClases;

import org.junit.Assert;
import org.junit.Test;

import Clases.Jugador;
import Clases.Provincia;
import Clases.Tucuman;

public class TucumanTest {
	
	@Test
	public void testJugadorCompraProvinciaSeLeReduceCorrectamente() {
		Provincia tucuman = new Tucuman();
		Jugador jugador= new Jugador();
		int precioAntesDeLaCompra = jugador.getDinero();
		tucuman.agregarPropietario(jugador);
		Assert.assertEquals(25000,precioAntesDeLaCompra-jugador.getDinero());
	}

	@Test
	public void testConstruyeCasaAumenteCorrectamentElNumeroDeCasasQuePosee() {
		Provincia tucuman = new Tucuman();
		Jugador jugador= new Jugador();
		tucuman.agregarPropietario(jugador);
		tucuman.construirCasa();
		Assert.assertEquals(1,tucuman.cantCasasConstruidas());
	}
	
	@Test
	public void testSeQuiereCostruirMasDeDosCasasYNoSePuede() {
		Provincia tucuman = new Tucuman();
		Jugador jugador= new Jugador();
		tucuman.agregarPropietario(jugador);
		tucuman.construirCasa();
		tucuman.construirCasa();
		Assert.assertEquals(1,tucuman.cantCasasConstruidas());
	}
}
