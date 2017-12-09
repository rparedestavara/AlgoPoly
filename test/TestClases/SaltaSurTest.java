package TestClases;

import org.junit.Assert;
import org.junit.Test;

import Clases.Jugador;
import Clases.ProvinciaDividida;
import Clases.SaltaNorte;
import Clases.SaltaSur;

public class SaltaSurTest {
	private static final double DELTA = 1e-15;
	@Test
	public void test1VerQueJugadorQueEntraEnBSurSeLeDisminuyeDineroPorNoSerPropietario() {
		Jugador jugador= new Jugador();
		ProvinciaDividida SaltaNorte=new SaltaNorte();
		ProvinciaDividida SaltaSur=new SaltaSur();
		SaltaNorte.agregarOpuesto(SaltaSur);
		SaltaSur.agregarOpuesto(SaltaNorte);
		SaltaNorte.comprar(jugador);
		SaltaSur.comprar(jugador);
		SaltaNorte.construirCasa();
		SaltaSur.construirCasa();
		Jugador jugador2= new Jugador();
		double dineroAntesDeEntrarAPropiedad=jugador2.getDinero();
		SaltaSur.entrar(jugador2);
		Assert.assertEquals(3250,dineroAntesDeEntrarAPropiedad-jugador2.getDinero(),DELTA);
	}
	public void testCasillaVendida() {
		Jugador jugador= new Jugador();
		ProvinciaDividida SaltaSur = new SaltaSur();
		SaltaSur.comprar(jugador);
		SaltaSur.construirCasa();
		SaltaSur.construirCasa();
		double dineroAntesDeVenderProiedad=jugador.getDinero();
		SaltaSur.provinciaVendida(jugador);
		Assert.assertEquals(18000*0.85, jugador.getDinero()-dineroAntesDeVenderProiedad,DELTA);
	}
	@Test
	public void testAlvenderLaProvinciaLaCantidadDeCasasQuedaEn0() {
		Jugador jugador= new Jugador();
		ProvinciaDividida SaltaSur = new SaltaSur();
		SaltaSur.comprar(jugador);
		SaltaSur.construirCasa();
		SaltaSur.construirCasa();
		SaltaSur.provinciaVendida(jugador);
		Assert.assertEquals(0,SaltaSur.cantCasasConstruidas());
	}
	@Test
	public void testAlVenderProvinciaUnJugadroEsteDejaDeSerPropietario() {
		Jugador jugador= new Jugador();
		ProvinciaDividida SaltaSur = new SaltaSur();
		SaltaSur.comprar(jugador);
		SaltaSur.provinciaVendida(jugador);
		Assert.assertEquals(false,SaltaSur.esPropietario(jugador));
	}
}
