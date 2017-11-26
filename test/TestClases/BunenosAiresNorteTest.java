package TestClases;

import  org.junit.Assert;

import org.junit.Test;

import Clases.BSNorte;
import Clases.BSSur;
import Clases.Jugador;
import Clases.Provincia;
import Clases.ProvinciaDividida;

public class BunenosAiresNorteTest {
	private static final double DELTA = 1e-15;
	@Test
	public void test1JugadorAlAdquirirBuenosAiresNorteSuDineroSeReduce25000() {
		Jugador jugador= new Jugador();
		Provincia bNorte=new BSNorte();
		double dineroAntesDeAdquirirTerreno=jugador.getDinero();
		bNorte.agregarPropietario(jugador);
		Assert.assertEquals(25000,dineroAntesDeAdquirirTerreno-jugador.getDinero(), DELTA);
	}
	
	@Test
	public void test2JugadorCaeEnBuenosAiresYConstruyeUnaCasaSuDineroSeReduceEn5500() {
		Jugador jugador= new Jugador();
		Provincia bNorte=new BSNorte();
		double dineroAntesDeAdquirirTerreno=jugador.getDinero();
		bNorte.agregarPropietario(jugador);
		bNorte.construirCasa();
		Assert.assertEquals(5500+25000,dineroAntesDeAdquirirTerreno-jugador.getDinero(), DELTA);
	}
	
	@Test
	public void test3AlConstruirUnaCasaVerQueAumenteLaCantidadDeCasasEnELTerreno() {
		Jugador jugador= new Jugador();
		Provincia bNorte=new BSNorte();
		bNorte.agregarPropietario(jugador);
		bNorte.construirCasa();
		Assert.assertEquals(1,bNorte.cantCasasConstruidas());
	}
	
	@Test
	public void test4JugadorAlCaerEnUnaProvinciaConPropietarioYConUnaCasaConstruidaSuDineroSeReduceEns3500() {
		Jugador jugador= new Jugador();
		ProvinciaDividida bNorte=new BSNorte();
		ProvinciaDividida bSur=new BSSur();
		bNorte.agregarOpuesto(bSur);
		bSur.agregarOpuesto(bNorte);
		bNorte.agregarPropietario(jugador);
		bSur.agregarPropietario(jugador);
		bNorte.construirCasa();
		bSur.construirCasa();
		Jugador jugador2= new Jugador();
		double dineroAntesDeEntrarAPropiedad=jugador2.getDinero();
		bNorte.entrar(jugador2);
		Assert.assertEquals(3500,dineroAntesDeEntrarAPropiedad-jugador2.getDinero(), DELTA);
	}
	
	@Test
	public void test5JugadorAlCaerEnUnaProvinciaConPropietarioYCon2CasasY1CasaConstruidaSuDineroSeReduceEns4000(){
		Jugador jugador= new Jugador();
		ProvinciaDividida bNorte=new BSNorte();
		ProvinciaDividida bSur=new BSSur();
		bNorte.agregarOpuesto(bSur);
		bSur.agregarOpuesto(bNorte);
		bNorte.agregarPropietario(jugador);
		bSur.agregarPropietario(jugador);
		bNorte.construirCasa();
		bNorte.construirCasa();
		bSur.construirCasa();
		Jugador jugador2= new Jugador();
		double dineroAntesDeEntrarAPropiedad=jugador2.getDinero();
		bNorte.entrar(jugador2);
		Assert.assertEquals(4000,dineroAntesDeEntrarAPropiedad-jugador2.getDinero(), DELTA);
	}
	
	@Test
	public void test6JugadorConstruyeHotelTeniendoCasasEnProvinciasOpuestas() {
		Jugador jugador= new Jugador();
		ProvinciaDividida bNorte=new BSNorte();
		ProvinciaDividida bSur=new BSSur();
		bNorte.agregarOpuesto(bSur);
		bSur.agregarOpuesto(bNorte);
		bNorte.agregarPropietario(jugador);
		bSur.agregarPropietario(jugador);
		bNorte.construirCasa();
		bNorte.construirCasa();
		bSur.construirCasa();
		bSur.construirCasa();
		bNorte.construirHotel();
		Assert.assertEquals(1, bNorte.cantHoteles());
	}
	
	@Test
	public void test7VerQueJugadorAlConstruirUnHotelSuDineroSeRedujo() {
		Jugador jugador= new Jugador();
		ProvinciaDividida bNorte=new BSNorte();
		ProvinciaDividida bSur=new BSSur();
		bNorte.agregarOpuesto(bSur);
		bSur.agregarOpuesto(bNorte);
		bNorte.agregarPropietario(jugador);
		bSur.agregarPropietario(jugador);
		bNorte.construirCasa();
		bNorte.construirCasa();
		bSur.construirCasa();
		bSur.construirCasa();
		double dineroAntesDeQuererCostruirHotel=jugador.getDinero();
		bNorte.construirHotel();
		Assert.assertEquals(9000,dineroAntesDeQuererCostruirHotel-jugador.getDinero(), DELTA);
	}
	
	@Test
	public void test8VerQueAlConstruirUnHotelLasCasasEnLaProvinciaContruidaDesaparecieron() {
		Jugador jugador= new Jugador();
		ProvinciaDividida bNorte=new BSNorte();
		ProvinciaDividida bSur=new BSSur();
		bNorte.agregarOpuesto(bSur);
		bSur.agregarOpuesto(bNorte);
		bNorte.agregarPropietario(jugador);
		bSur.agregarPropietario(jugador);
		bNorte.construirCasa();
		bNorte.construirCasa();
		bSur.construirCasa();
		bSur.construirCasa();
		bNorte.construirHotel();
		Assert.assertEquals(0,bNorte.cantCasasConstruidas());
	}
	
	@Test
	public void test9JugadorQuiereConstruirHotelYNoPuedePorNoTenerCasaAlMaximo() {
		Jugador jugador= new Jugador();
		ProvinciaDividida bNorte=new BSNorte();
		ProvinciaDividida bSur=new BSSur();
		bNorte.agregarOpuesto(bSur);
		bSur.agregarOpuesto(bNorte);
		bNorte.agregarPropietario(jugador);
		bSur.agregarPropietario(jugador);
		bNorte.construirCasa();
		bNorte.construirCasa();
		bSur.construirCasa();
		bNorte.construirHotel();
		Assert.assertTrue(!bNorte.SePuedeConstruisHoteles());
	}
	
	@Test
	public void test10ugadorQuiereConstruirHotelYNoPuedePorNoTenerCasaAlMaximoVerQueSuDineroNoSeDecremento() {
		Jugador jugador= new Jugador();
		ProvinciaDividida bNorte=new BSNorte();
		ProvinciaDividida bSur=new BSSur();
		bNorte.agregarOpuesto(bSur);
		bSur.agregarOpuesto(bNorte);
		bNorte.agregarPropietario(jugador);
		bSur.agregarPropietario(jugador);
		bNorte.construirCasa();
		bNorte.construirCasa();
		bSur.construirCasa();
		double dineroAntesDeQuererCostruir=jugador.getDinero();
		bNorte.construirHotel();
		Assert.assertEquals(dineroAntesDeQuererCostruir,jugador.getDinero(), DELTA);
	}

	@Test 
	public void test11VerQueJugadorAlCaerEnUnaProvinciConHotelSuDineroDisminuye6000() {
		Jugador jugador= new Jugador();
		ProvinciaDividida bNorte=new BSNorte();
		ProvinciaDividida bSur=new BSSur();
		bNorte.agregarOpuesto(bSur);
		bSur.agregarOpuesto(bNorte);
		bNorte.agregarPropietario(jugador);
		bSur.agregarPropietario(jugador);
		bNorte.construirCasa();
		bNorte.construirCasa();
		bSur.construirCasa();
		bSur.construirCasa();
		bNorte.construirHotel();
		Jugador jugador2= new Jugador();
		double dineroAntesDeEntrar=jugador2.getDinero();
		bNorte.entrar(jugador2);
		Assert.assertEquals(6000,dineroAntesDeEntrar-jugador2.getDinero(), DELTA);
	}
	@Test
	public void testCasillaVendida() {
		Jugador jugador= new Jugador();
		ProvinciaDividida bNorte = new BSNorte();
		bNorte.agregarPropietario(jugador);
		bNorte.construirCasa();
		bNorte.construirCasa();
		double dineroAntesDeVenderProiedad=jugador.getDinero();
		bNorte.provinciaVendida(jugador);
		Assert.assertEquals(25000*0.85, jugador.getDinero()-dineroAntesDeVenderProiedad,DELTA);
	}
	@Test
	public void testAlvenderLaProvinciaLaCantidadDeCasasQuedaEn0() {
		Jugador jugador= new Jugador();
		ProvinciaDividida bNorte = new BSNorte();
		bNorte.agregarPropietario(jugador);
		bNorte.construirCasa();
		bNorte.construirCasa();
		bNorte.provinciaVendida(jugador);
		Assert.assertEquals(0,bNorte.cantCasasConstruidas());
	}
	@Test
	public void testAlVenderProvinciaUnJugadroEsteDejaDeSerPropietario() {
		Jugador jugador= new Jugador();
		ProvinciaDividida bNorte = new BSNorte();
		bNorte.agregarPropietario(jugador);
		bNorte.provinciaVendida(jugador);
		Assert.assertEquals(false,bNorte.esPropietario(jugador));
	}
}
