package TestClases;

import org.junit.Assert;

import org.junit.Test;

import Clases.BSNorte;
import Clases.BSSur;
import Clases.Jugador;
import Clases.Provincia;
import Clases.ProvinciaDividida;

public class BuenosAiresSurTest {
	private static final double DELTA = 1e-15;
	@Test
	public void test0JugadorAlAdquirirBuenosAiresSuruDineroSeReduce20000() {
		Jugador jugador= new Jugador();
		Provincia bSur=new BSSur();
		double dineroAntesDeAdquirirTerreno=jugador.getDinero();
		bSur.agregarPropietario(jugador);
		Assert.assertEquals(20000,dineroAntesDeAdquirirTerreno-jugador.getDinero(),DELTA);
	}

	@Test
	public void test1VerQueJugadorQueEntraEnBSurSeLeDisminuyeDineroPorNoSerPropietario() {
		Jugador jugador= new Jugador();
		ProvinciaDividida bNorte = new BSNorte();
		ProvinciaDividida bSur = new BSSur();
		bNorte.agregarOpuesto(bSur);
		bSur.agregarOpuesto(bNorte);
		bNorte.agregarPropietario(jugador);
		bSur.agregarPropietario(jugador);
		bNorte.construirCasa();
		bSur.construirCasa();
		Jugador jugador2= new Jugador();
		double dineroAntesDeEntrarAPropiedad=jugador2.getDinero();
		bSur.entrar(jugador2);
		Assert.assertEquals(3000,dineroAntesDeEntrarAPropiedad-jugador2.getDinero(),DELTA);
	}
	@Test
	public void testCasillaVendida() {
		Jugador jugador= new Jugador();
		ProvinciaDividida bSur = new BSSur();
		bSur.agregarPropietario(jugador);
		bSur.construirCasa();
		bSur.construirCasa();
		double dineroAntesDeVenderProiedad=jugador.getDinero();
		bSur.provinciaVendida(jugador);
		Assert.assertEquals(20000*0.85, jugador.getDinero()-dineroAntesDeVenderProiedad,DELTA);
	}
	@Test
	public void testAlvenderLaProvinciaLaCantidadDeCasasQuedaEn0() {
		Jugador jugador= new Jugador();
		ProvinciaDividida bSur = new BSSur();
		bSur.agregarPropietario(jugador);
		bSur.construirCasa();
		bSur.construirCasa();
		bSur.provinciaVendida(jugador);
		Assert.assertEquals(0,bSur.cantCasasConstruidas());
	}
	@Test
	public void testAlVenderProvinciaUnJugadroEsteDejaDeSerPropietario() {
		Jugador jugador= new Jugador();
		ProvinciaDividida bSur = new BSSur();
		bSur.agregarPropietario(jugador);
		bSur.provinciaVendida(jugador);
		Assert.assertEquals(false,bSur.esPropietario(jugador));
	}
}
