package TestClases;


import org.junit.Assert;
import org.junit.Test;

import Clases.Jugador;
import Clases.Provincia;
import Clases.SantaFe;

public class SantaFeTest {
	
	@Test
	public void testJugadorCompraProvinciaSeLeReduceCorrectamente() {
		Provincia santaFe = new SantaFe();
		Jugador jugador= new Jugador();
		int precioAntesDeLaCompra = jugador.getDinero();
		santaFe.agregarPropietario(jugador);
		Assert.assertEquals(15000,precioAntesDeLaCompra-jugador.getDinero());
	}
	@Test
	public void testConstruyeCasaAumenteCorrectamentElNumeroDeCasasQuePosee() {
		Provincia santaFe = new SantaFe();
		Jugador jugador= new Jugador();
		santaFe.agregarPropietario(jugador);
		santaFe.construirCasa();
		Assert.assertEquals(1,santaFe.cantCasasConstruidas());
	}
	
	@Test
	public void testSeQuiereCostruirMasDeDosCasasYNoSePuede() {
		Provincia santaFe = new SantaFe();
		Jugador jugador= new Jugador();
		santaFe.agregarPropietario(jugador);
		santaFe.construirCasa();
		santaFe.construirCasa();
		Assert.assertEquals(1,santaFe.cantCasasConstruidas());
	}
}
