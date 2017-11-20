package TestClases;

import org.junit.Assert;
import org.junit.Test;

import Clases.Jugador;
import Clases.Provincia;
import Clases.ProvinciaDividida;
import Clases.SaltaNorte;
import Clases.SaltaSur;

public class SaltaNorteTest {
	@Test
	public void test1JugadorAlAdquirirSaltaNorteSuDineroSeReduce23000() {
		Jugador jugador= new Jugador();
		Provincia saltaNorte=new SaltaNorte();
		int dineroAntesDeAdquirirTerreno=jugador.getDinero();
		saltaNorte.agregarPropietario(jugador);
		Assert.assertEquals(23000,dineroAntesDeAdquirirTerreno-jugador.getDinero());
	}
	
	@Test
	public void test2JugadorCaeEnSaltaYConstruyeUnaCasaSuDineroSeReduceEn4500() {
		Jugador jugador= new Jugador();
		Provincia saltaNorte=new SaltaNorte();
		int dineroAntesDeAdquirirTerreno=jugador.getDinero();
		saltaNorte.agregarPropietario(jugador);
		saltaNorte.construirCasa();
		Assert.assertEquals(4500+23000,dineroAntesDeAdquirirTerreno-jugador.getDinero());
	}
	
	@Test
	public void test3AlConstruirUnaCasaVerQueAumenteLaCantidadDeCasasEnELTerreno() {
		Jugador jugador= new Jugador();
		Provincia saltaNorte=new SaltaNorte();
		saltaNorte.agregarPropietario(jugador);
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
		saltaNorte.agregarPropietario(jugador);
		saltaSur.agregarPropietario(jugador);
		saltaNorte.construirCasa();
		saltaSur.construirCasa();
		Jugador jugador2= new Jugador();
		int dineroAntesDeEntrarAPropiedad=jugador2.getDinero();
		saltaNorte.entrar(jugador2);
		Assert.assertEquals(3250,dineroAntesDeEntrarAPropiedad-jugador2.getDinero());
	}
	
	@Test
	public void test5JugadorAlCaerEnUnaProvinciaConPropietarioYCon2CasasY1CasaConstruidaSuDineroSeReduceEn3850(){
		Jugador jugador= new Jugador();
		ProvinciaDividida saltaNorte=new SaltaNorte();
		ProvinciaDividida saltaSur=new SaltaSur();
		saltaNorte.agregarOpuesto(saltaSur);
		saltaSur.agregarOpuesto(saltaNorte);
		saltaNorte.agregarPropietario(jugador);
		saltaSur.agregarPropietario(jugador);
		saltaNorte.construirCasa();
		saltaNorte.construirCasa();
		saltaSur.construirCasa();
		Jugador jugador2= new Jugador();
		int dineroAntesDeEntrarAPropiedad=jugador2.getDinero();
		saltaNorte.entrar(jugador2);
		Assert.assertEquals(3850,dineroAntesDeEntrarAPropiedad-jugador2.getDinero());
	}
	
	@Test
	public void test6JugadorConstruyeHotelTeniendoCasasEnProvinciasOpuestas() {
		Jugador jugador= new Jugador();
		ProvinciaDividida saltaNorte=new SaltaNorte();
		ProvinciaDividida saltaSur=new SaltaSur();
		saltaNorte.agregarOpuesto(saltaSur);
		saltaSur.agregarOpuesto(saltaNorte);
		saltaNorte.agregarPropietario(jugador);
		saltaSur.agregarPropietario(jugador);
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
		saltaNorte.agregarPropietario(jugador);
		saltaSur.agregarPropietario(jugador);
		saltaNorte.construirCasa();
		saltaNorte.construirCasa();
		saltaSur.construirCasa();
		saltaSur.construirCasa();
		int dineroAntesDeQuererCostruirHotel=jugador.getDinero();
		saltaNorte.construirHotel();
		Assert.assertEquals(7500,dineroAntesDeQuererCostruirHotel-jugador.getDinero());
	}
	
	@Test
	public void test8VerQueAlConstruirUnHotelLasCasasEnLaProvinciaContruidaDesaparecieron() {
		Jugador jugador= new Jugador();
		ProvinciaDividida saltaNorte=new SaltaNorte();
		ProvinciaDividida saltaSur=new SaltaSur();
		saltaNorte.agregarOpuesto(saltaSur);
		saltaSur.agregarOpuesto(saltaNorte);
		saltaNorte.agregarPropietario(jugador);
		saltaSur.agregarPropietario(jugador);
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
		saltaNorte.agregarPropietario(jugador);
		saltaSur.agregarPropietario(jugador);
		saltaNorte.construirCasa();
		saltaNorte.construirCasa();
		saltaSur.construirCasa();
		saltaNorte.construirHotel();
		Assert.assertTrue(!saltaNorte.SePuedeConstruisHoteles());
	}
	
	@Test
	public void test10ugadorQuiereConstruirHotelYNoPuedePorNoTenerCasaAlMaximoVerQueSuDineroNoSeDecremento() {
		Jugador jugador= new Jugador();
		ProvinciaDividida saltaNorte=new SaltaNorte();
		ProvinciaDividida saltaSur=new SaltaSur();
		saltaNorte.agregarOpuesto(saltaSur);
		saltaSur.agregarOpuesto(saltaNorte);
		saltaNorte.agregarPropietario(jugador);
		saltaSur.agregarPropietario(jugador);
		saltaNorte.construirCasa();
		saltaNorte.construirCasa();
		saltaSur.construirCasa();
		int dineroAntesDeQuererCostruir=jugador.getDinero();
		saltaNorte.construirHotel();
		Assert.assertEquals(dineroAntesDeQuererCostruir,jugador.getDinero());
	}

	@Test 
	public void test11VerQueJugadorAlCaerEnUnaProvinciConHotelSuDineroDisminuye5500() {
		Jugador jugador= new Jugador();
		ProvinciaDividida saltaNorte=new SaltaNorte();
		ProvinciaDividida saltaSur=new SaltaSur();
		saltaNorte.agregarOpuesto(saltaSur);
		saltaSur.agregarOpuesto(saltaNorte);
		saltaNorte.agregarPropietario(jugador);
		saltaSur.agregarPropietario(jugador);
		saltaNorte.construirCasa();
		saltaNorte.construirCasa();
		saltaSur.construirCasa();
		saltaSur.construirCasa();
		saltaNorte.construirHotel();
		Jugador jugador2= new Jugador();
		int dineroAntesDeEntrar=jugador2.getDinero();
		saltaNorte.entrar(jugador2);
		Assert.assertEquals(5500,dineroAntesDeEntrar-jugador2.getDinero());
	}
}
