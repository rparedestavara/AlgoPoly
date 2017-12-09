package TestClases;


import org.junit.Assert;
import org.junit.Test;

import Clases.CordobaNorte;
import Clases.CordobaSur;
import Clases.Jugador;
import Clases.ProvinciaDividida;

public class CordobaSurTest {
	private static final double DELTA = 1e-15;
	@Test
	public void test1VerQueJugadorQueEntraEnCordobaSurSeLeDisminuyeDineroPorNoSerPropietario() {
		Jugador jugador= new Jugador();
		ProvinciaDividida cordobaNorte=new CordobaNorte();
		ProvinciaDividida cordobaSur=new CordobaSur();
		cordobaNorte.agregarOpuesto(cordobaSur);
		cordobaSur.agregarOpuesto(cordobaNorte);
		cordobaNorte.comprar(jugador);
		cordobaSur.comprar(jugador);
		cordobaNorte.construirCasa();
		cordobaSur.construirCasa();
		Jugador jugador2= new Jugador();
		double dineroAntesDeEntrarAPropiedad=jugador2.getDinero();
		cordobaSur.entrar(jugador2);
		Assert.assertEquals(1500,dineroAntesDeEntrarAPropiedad-jugador2.getDinero(),DELTA);
	}
	@Test
	public void testCasillaVendida() {
		Jugador jugador= new Jugador();
		ProvinciaDividida cordobaSur = new CordobaSur();
		cordobaSur.comprar(jugador);
		cordobaSur.construirCasa();
		cordobaSur.construirCasa();
		double dineroAntesDeVenderProiedad=jugador.getDinero();
		cordobaSur.provinciaVendida(jugador);
		Assert.assertEquals(18000*0.85, jugador.getDinero()-dineroAntesDeVenderProiedad,DELTA);
	}
	@Test
	public void testAlvenderLaProvinciaLaCantidadDeCasasQuedaEn0() {
		Jugador jugador= new Jugador();
		ProvinciaDividida cordobaSur = new CordobaSur();
		cordobaSur.comprar(jugador);
		cordobaSur.construirCasa();
		cordobaSur.construirCasa();
		cordobaSur.provinciaVendida(jugador);
		Assert.assertEquals(0,cordobaSur.cantCasasConstruidas());
	}
	@Test
	public void testAlVenderProvinciaUnJugadroEsteDejaDeSerPropietario() {
		Jugador jugador= new Jugador();
		ProvinciaDividida cordobaSur = new CordobaSur();
		cordobaSur.comprar(jugador);
		cordobaSur.provinciaVendida(jugador);
		Assert.assertEquals(false,cordobaSur.esPropietario(jugador));
	}
}
