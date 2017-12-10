package TestClases;

import org.junit.Assert;
import org.junit.Test;

import Clases.Jugador;
import Clases.Provincia;
import Clases.ProvinciaDividida;
import Clases.SaltaNorte;
import Clases.SaltaSur;

public class SaltaNorteTest {
	private static final double DELTA = 1e-15;
	@Test
	public void test1JugadorAlAdquirirSaltaNorteSuDineroSeReduce23000() {
		Jugador jugador= new Jugador();
		Provincia saltaNorte=new SaltaNorte();
		double dineroAntesDeAdquirirTerreno=jugador.getDinero();
		saltaNorte.comprar(jugador);
		Assert.assertEquals(23000,dineroAntesDeAdquirirTerreno-jugador.getDinero(), DELTA);
	}
	
	@Test
	public void test2JugadorCaeEnSaltaYConstruyeUnaCasaSuDineroSeReduceEn4500() {
		Jugador jugador= new Jugador();
		ProvinciaDividida saltaNorte=new SaltaNorte();
		ProvinciaDividida saltaSur=new SaltaSur();
		saltaNorte.agregarOpuesto(saltaSur);
		saltaSur.agregarOpuesto(saltaNorte);
		saltaSur.comprar(jugador);
		double dineroAntesDeAdquirirTerreno=jugador.getDinero();
		saltaNorte.comprar(jugador);
		saltaNorte.construirCasa();
		Assert.assertEquals(4500+23000,dineroAntesDeAdquirirTerreno-jugador.getDinero(), DELTA);
	}
	
	@Test
	public void test3AlConstruirUnaCasaVerQueAumenteLaCantidadDeCasasEnELTerreno() {
		Jugador jugador= new Jugador();
		ProvinciaDividida saltaNorte=new SaltaNorte();
		ProvinciaDividida saltaSur=new SaltaSur();
		saltaNorte.agregarOpuesto(saltaSur);
		saltaSur.agregarOpuesto(saltaNorte);
		saltaNorte.comprar(jugador);
		saltaSur.comprar(jugador);
		saltaNorte.construirCasa();
		Assert.assertEquals(1,saltaNorte.cantCasasConstruidas());
	}
	
	@Test
	public void test4JugadorAlCaerEnUnaProvinciaConPropietarioYConUnaCasaConstruidaSuDineroSeReduceEns3250() {
		Jugador jugador= new Jugador();
		ProvinciaDividida saltaNorte=new SaltaNorte();
		ProvinciaDividida saltaSur=new SaltaSur();
		saltaNorte.agregarOpuesto(saltaSur);
		saltaSur.agregarOpuesto(saltaNorte);
		saltaNorte.comprar(jugador);
		saltaSur.comprar(jugador);
		saltaNorte.construirCasa();
		saltaSur.construirCasa();
		Jugador jugador2= new Jugador();
		double dineroAntesDeEntrarAPropiedad=jugador2.getDinero();
		saltaNorte.entrar(jugador2);
		Assert.assertEquals(3250,dineroAntesDeEntrarAPropiedad-jugador2.getDinero(), DELTA);
	}
	
	@Test
	public void test5JugadorAlCaerEnUnaProvinciaConPropietarioYCon2CasasY1CasaConstruidaSuDineroSeReduceEn3850(){
		Jugador jugador= new Jugador();
		ProvinciaDividida saltaNorte=new SaltaNorte();
		ProvinciaDividida saltaSur=new SaltaSur();
		saltaNorte.agregarOpuesto(saltaSur);
		saltaSur.agregarOpuesto(saltaNorte);
		saltaNorte.comprar(jugador);
		saltaSur.comprar(jugador);
		saltaNorte.construirCasa();
		saltaNorte.construirCasa();
		saltaSur.construirCasa();
		Jugador jugador2= new Jugador();
		double dineroAntesDeEntrarAPropiedad=jugador2.getDinero();
		saltaNorte.entrar(jugador2);
		Assert.assertEquals(3850,dineroAntesDeEntrarAPropiedad-jugador2.getDinero(), DELTA);
	}
	
	@Test
	public void test6JugadorConstruyeHotelTeniendoCasasEnProvinciasOpuestas() {
		Jugador jugador= new Jugador();
		ProvinciaDividida saltaNorte=new SaltaNorte();
		ProvinciaDividida saltaSur=new SaltaSur();
		saltaNorte.agregarOpuesto(saltaSur);
		saltaSur.agregarOpuesto(saltaNorte);
		saltaNorte.comprar(jugador);
		saltaSur.comprar(jugador);
		saltaNorte.construirCasa();
		saltaNorte.construirCasa();
		saltaSur.construirCasa();
		saltaSur.construirCasa();
		saltaNorte.construirHotel();
		Assert.assertEquals(1, saltaNorte.cantHoteles());
	}
	
	@Test
	public void test7VerQueJugadorAlConstruirUnHotelSuDineroSeRedujo() {
		Jugador jugador= new Jugador();
		ProvinciaDividida saltaNorte=new SaltaNorte();
		ProvinciaDividida saltaSur=new SaltaSur();
		saltaNorte.agregarOpuesto(saltaSur);
		saltaSur.agregarOpuesto(saltaNorte);
		saltaNorte.comprar(jugador);
		saltaSur.comprar(jugador);
		saltaNorte.construirCasa();
		saltaNorte.construirCasa();
		saltaSur.construirCasa();
		saltaSur.construirCasa();
		double dineroAntesDeQuererCostruirHotel=jugador.getDinero();
		saltaNorte.construirHotel();
		Assert.assertEquals(7500,dineroAntesDeQuererCostruirHotel-jugador.getDinero(), DELTA);
	}
	
	@Test
	public void test8VerQueAlConstruirUnHotelLasCasasEnLaProvinciaContruidaDesaparecieron() {
		Jugador jugador= new Jugador();
		ProvinciaDividida saltaNorte=new SaltaNorte();
		ProvinciaDividida saltaSur=new SaltaSur();
		saltaNorte.agregarOpuesto(saltaSur);
		saltaSur.agregarOpuesto(saltaNorte);
		saltaNorte.comprar(jugador);
		saltaSur.comprar(jugador);
		saltaNorte.construirCasa();
		saltaNorte.construirCasa();
		saltaSur.construirCasa();
		saltaSur.construirCasa();
		saltaNorte.construirHotel();
		Assert.assertEquals(0,saltaNorte.cantCasasConstruidas());
	}
	
	@Test
	public void test9JugadorQuiereConstruirHotelYNoPuedePorNoTenerCasaAlMaximo() {
		Jugador jugador= new Jugador();
		ProvinciaDividida saltaNorte=new SaltaNorte();
		ProvinciaDividida saltaSur=new SaltaSur();
		saltaNorte.agregarOpuesto(saltaSur);
		saltaSur.agregarOpuesto(saltaNorte);
		saltaNorte.comprar(jugador);
		saltaSur.comprar(jugador);
		saltaNorte.construirCasa();
		saltaNorte.construirCasa();
		saltaSur.construirCasa();
		saltaNorte.construirHotel();
		Assert.assertTrue(!saltaNorte.sePuedeConstruirUnHotel());
	}
	
	@Test
	public void test10ugadorQuiereConstruirHotelYNoPuedePorNoTenerCasaAlMaximoVerQueSuDineroNoSeDecremento() {
		Jugador jugador= new Jugador();
		ProvinciaDividida saltaNorte=new SaltaNorte();
		ProvinciaDividida saltaSur=new SaltaSur();
		saltaNorte.agregarOpuesto(saltaSur);
		saltaSur.agregarOpuesto(saltaNorte);
		saltaNorte.comprar(jugador);
		saltaSur.comprar(jugador);
		saltaNorte.construirCasa();
		saltaNorte.construirCasa();
		saltaSur.construirCasa();
		double dineroAntesDeQuererCostruir=jugador.getDinero();
		saltaNorte.construirHotel();
		Assert.assertEquals(dineroAntesDeQuererCostruir,jugador.getDinero(), DELTA);
	}

	@Test 
	public void test11VerQueJugadorAlCaerEnUnaProvinciConHotelSuDineroDisminuye5500() {
		Jugador jugador= new Jugador();
		ProvinciaDividida saltaNorte=new SaltaNorte();
		ProvinciaDividida saltaSur=new SaltaSur();
		saltaNorte.agregarOpuesto(saltaSur);
		saltaSur.agregarOpuesto(saltaNorte);
		saltaNorte.comprar(jugador);
		saltaSur.comprar(jugador);
		saltaNorte.construirCasa();
		saltaNorte.construirCasa();
		saltaSur.construirCasa();
		saltaSur.construirCasa();
		saltaNorte.construirHotel();
		Jugador jugador2= new Jugador();
		double dineroAntesDeEntrar=jugador2.getDinero();
		saltaNorte.entrar(jugador2);
		Assert.assertEquals(5500,dineroAntesDeEntrar-jugador2.getDinero(), DELTA);
	}
	@Test
	public void testCasillaVendida() {
		Jugador jugador= new Jugador();
		ProvinciaDividida saltaNorte = new SaltaNorte();
		saltaNorte.comprar(jugador);
		double dineroAntesDeVenderProiedad=jugador.getDinero();
		saltaNorte.provinciaVendida(jugador);
		Assert.assertEquals(23000*0.85, jugador.getDinero()-dineroAntesDeVenderProiedad,DELTA);
	}
	@Test
	public void testAlvenderLaProvinciaLaCantidadDeCasasQuedaEn0() {
		Jugador jugador= new Jugador();
		ProvinciaDividida saltaNorte=new SaltaNorte();
		ProvinciaDividida saltaSur=new SaltaSur();
		saltaNorte.agregarOpuesto(saltaSur);
		saltaSur.agregarOpuesto(saltaNorte);
		saltaNorte.comprar(jugador);
		saltaSur.comprar(jugador);
		saltaNorte.construirCasa();
		saltaNorte.construirCasa();
		saltaNorte.provinciaVendida(jugador);
		Assert.assertEquals(0,saltaNorte.cantCasasConstruidas());
	}
	@Test
	public void testAlVenderProvinciaUnJugadroEsteDejaDeSerPropietario() {
		Jugador jugador= new Jugador();
		ProvinciaDividida saltaNorte = new SaltaNorte();
		saltaNorte.comprar(jugador);
		saltaNorte.provinciaVendida(jugador);
		Assert.assertEquals(false,saltaNorte.esPropietario(jugador));
	}
}
