package TestClases;

import  org.junit.Assert;

import org.junit.Test;

import Clases.BSNorte;
import Clases.BSSur;
import Clases.Jugador;
import Clases.Provincia;

public class BunenosAiresTest {

	@Test
	public void test1JugadorAlAdquirirBuenosAiresNorteSuDineroSeReduce25000() {
		Jugador jugador= new Jugador();
		Provincia bNorte=new BSNorte();
		int dineroAntesDeAdquirirTerreno=jugador.getDinero();
		bNorte.agregarPropietario(jugador);
		Assert.assertEquals(25000,dineroAntesDeAdquirirTerreno-jugador.getDinero());
	}
	
	@Test
	public void test2JugadorCaeEnBuenosAiresYConstruyeUnaCasaSuDineroSeReduceEn5000() {
		Jugador jugador= new Jugador();
		Provincia bNorte=new BSNorte();
		int dineroAntesDeAdquirirTerreno=jugador.getDinero();
		bNorte.agregarPropietario(jugador);
		bNorte.construirCasa();
		Assert.assertEquals(5500+25000,dineroAntesDeAdquirirTerreno-jugador.getDinero());
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
	public void test4JugadorAlCaerEnUnaProvinciaConPropietarioYConUnaCasaConstruidaSuDineroSeReduceEns3000() {
		Jugador jugador= new Jugador();
		Provincia bNorte=new BSNorte();
		Provincia bSur=new BSSur();
		bNorte.agregarOpuesto(bSur);
		bSur.agregarOpuesto(bNorte);
		bNorte.agregarPropietario(jugador);
		bSur.agregarPropietario(jugador);
		bNorte.construirCasa();
		bSur.construirCasa();
		Jugador jugador2= new Jugador();
		int dineroAntesDeEntrarAPropiedad=jugador2.getDinero();
		bNorte.entrar(jugador2);
		Assert.assertEquals(3000,dineroAntesDeEntrarAPropiedad-jugador2.getDinero());
	}
	
	@Test
	public void test5JugadorAlCaerEnUnaProvinciaConPropietarioYCon2CasasY1CasaConstruidaSuDineroSeReduceEns3500(){
		Jugador jugador= new Jugador();
		Provincia bNorte=new BSNorte();
		Provincia bSur=new BSSur();
		bNorte.agregarOpuesto(bSur);
		bSur.agregarOpuesto(bNorte);
		bNorte.agregarPropietario(jugador);
		bSur.agregarPropietario(jugador);
		bNorte.construirCasa();
		bNorte.construirCasa();
		bSur.construirCasa();
		Jugador jugador2= new Jugador();
		int dineroAntesDeEntrarAPropiedad=jugador2.getDinero();
		bNorte.entrar(jugador2);
		Assert.assertEquals(3500,dineroAntesDeEntrarAPropiedad-jugador2.getDinero());
	}
	
	@Test
	public void test6JugadorConstruyeHotelTeniendoCasasEnProvinciasOpuestas() {
		Jugador jugador= new Jugador();
		Provincia bNorte=new BSNorte();
		Provincia bSur=new BSSur();
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
		Provincia bNorte=new BSNorte();
		Provincia bSur=new BSSur();
		bNorte.agregarOpuesto(bSur);
		bSur.agregarOpuesto(bNorte);
		bNorte.agregarPropietario(jugador);
		bSur.agregarPropietario(jugador);
		bNorte.construirCasa();
		bNorte.construirCasa();
		bSur.construirCasa();
		bSur.construirCasa();
		int dineroAntesDeQuererCostruirHotel=jugador.getDinero();
		bNorte.construirHotel();
		Assert.assertEquals(9000,dineroAntesDeQuererCostruirHotel-jugador.getDinero());
	}
	
	@Test
	public void test8VerQueAlConstruirUnHotelLasCasasEnLaProvinciaContruidaDesaparecieron() {
		Jugador jugador= new Jugador();
		Provincia bNorte=new BSNorte();
		Provincia bSur=new BSSur();
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
		Provincia bNorte=new BSNorte();
		Provincia bSur=new BSSur();
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
		Provincia bNorte=new BSNorte();
		Provincia bSur=new BSSur();
		bNorte.agregarOpuesto(bSur);
		bSur.agregarOpuesto(bNorte);
		bNorte.agregarPropietario(jugador);
		bSur.agregarPropietario(jugador);
		bNorte.construirCasa();
		bNorte.construirCasa();
		bSur.construirCasa();
		int dineroAntesDeQuererCostruir=jugador.getDinero();
		bNorte.construirHotel();
		Assert.assertEquals(dineroAntesDeQuererCostruir,jugador.getDinero());
	}

	@Test 
	public void test11VerQueJugadorAlCaerEnUnaProvinciConHotelSuDineroDisminuye5000() {
		Jugador jugador= new Jugador();
		Provincia bNorte=new BSNorte();
		Provincia bSur=new BSSur();
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
		int dineroAntesDeEntrar=jugador2.getDinero();
		bNorte.entrar(jugador2);
		Assert.assertEquals(5000,dineroAntesDeEntrar-jugador2.getDinero());
	}
}
