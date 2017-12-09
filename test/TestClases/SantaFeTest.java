package TestClases;


import org.junit.Assert;
import org.junit.Test;

import Clases.Jugador;
import Clases.Provincia;
import Clases.SantaFe;

public class SantaFeTest {
	private static final double DELTA = 1e-15;	
	@Test
	public void testJugadorCompraProvinciaSeLeReduceCorrectamente() {
		Provincia santaFe = new SantaFe();
		Jugador jugador= new Jugador();
		double precioAntesDeLaCompra = jugador.getDinero();
		santaFe.comprar(jugador);
		Assert.assertEquals(15000,precioAntesDeLaCompra-jugador.getDinero(),DELTA);
	}
	@Test
	public void testConstruyeCasaAumenteCorrectamentElNumeroDeCasasQuePosee() {
		Provincia santaFe = new SantaFe();
		Jugador jugador= new Jugador();
		santaFe.comprar(jugador);
		santaFe.construirCasa();
		Assert.assertEquals(1,santaFe.cantCasasConstruidas());
	}
	
	@Test
	public void testSeQuiereCostruirMasDeDosCasasYNoSePuede() {
		Provincia santaFe = new SantaFe();
		Jugador jugador= new Jugador();
		santaFe.comprar(jugador);
		santaFe.construirCasa();
		santaFe.construirCasa();
		Assert.assertEquals(1,santaFe.cantCasasConstruidas());
	}
	public void testCasillaVendida() {
		Jugador jugador= new Jugador();
		Provincia santaFe = new SantaFe();
		santaFe.comprar(jugador);
		santaFe.construirCasa();
		santaFe.construirCasa();
		double dineroAntesDeVenderProiedad=jugador.getDinero();
		santaFe.provinciaVendida(jugador);
		Assert.assertEquals(18000*0.85, jugador.getDinero()-dineroAntesDeVenderProiedad,DELTA);
	}
	@Test
	public void testAlvenderLaProvinciaLaCantidadDeCasasQuedaEn0() {
		Jugador jugador= new Jugador();
		Provincia santaFe = new SantaFe();
		santaFe.comprar(jugador);
		santaFe.construirCasa();
		santaFe.construirCasa();
		santaFe.provinciaVendida(jugador);
		Assert.assertEquals(0,santaFe.cantCasasConstruidas());
	}
	@Test
	public void testAlVenderProvinciaUnJugadroEsteDejaDeSerPropietario() {
		Jugador jugador= new Jugador();
		Provincia santaFe = new SantaFe();
		santaFe.comprar(jugador);
		santaFe.provinciaVendida(jugador);
		Assert.assertEquals(false,santaFe.esPropietario(jugador));
	}
}
