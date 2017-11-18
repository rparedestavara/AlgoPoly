package TestClases;

import org.junit.Assert;
import org.junit.Test;

import Clases.CordobaNorte;
import Clases.CordobaSur;
import Clases.Jugador;
import Clases.Provincia;

public class CordobaNorteTets {

	@Test
	public void test1JugadorAlAdquirirCordobaNorteDineroSeReduce25000() {
		Jugador jugador= new Jugador();
		Provincia cordobaNorte=new CordobaNorte();
		int dineroAntesDeAdquirirTerreno=jugador.getDinero();
		cordobaNorte.agregarPropietario(jugador);
		Assert.assertEquals(20000,dineroAntesDeAdquirirTerreno-jugador.getDinero());
	}
	
	@Test
	public void test2JugadorCaeEnCordobaNorteYConstruyeUnaCasaSuDineroSeReduceEn5000() {
		Jugador jugador= new Jugador();
		Provincia cordobaNorte=new CordobaNorte();
		int dineroAntesDeAdquirirTerreno=jugador.getDinero();
		cordobaNorte.agregarPropietario(jugador);
		cordobaNorte.construirCasa();
		Assert.assertEquals(2200+20000,dineroAntesDeAdquirirTerreno-jugador.getDinero());
	}
	
	@Test
	public void test3AlConstruirUnaCasaVerQueAumenteLaCantidadDeCasasEnELTerreno() {
		Jugador jugador= new Jugador();
		Provincia cordobaNorte=new CordobaNorte();
		cordobaNorte.agregarPropietario(jugador);
		cordobaNorte.construirCasa();
		Assert.assertEquals(1,cordobaNorte.cantCasasConstruidas());
	}
	
	@Test
	public void test4JugadorAlCaerEnUnaProvinciaConPropietarioYConUnaCasaConstruidaSuDineroSeReduceEns3000() {
		Jugador jugador= new Jugador();
		Provincia cordobaNorte=new CordobaNorte();
		Provincia cordobaSur=new CordobaSur();
		cordobaNorte.agregarOpuesto(cordobaSur);
		cordobaSur.agregarOpuesto(cordobaNorte);
		cordobaNorte.agregarPropietario(jugador);
		cordobaSur.agregarPropietario(jugador);
		cordobaNorte.construirCasa();
		cordobaSur.construirCasa();
		Jugador jugador2= new Jugador();
		int dineroAntesDeEntrarAPropiedad=jugador2.getDinero();
		cordobaNorte.entrar(jugador2);
		Assert.assertEquals(3000,dineroAntesDeEntrarAPropiedad-jugador2.getDinero());
	}
	
	@Test
	public void test5JugadorAlCaerEnUnaProvinciaConPropietarioYCon2CasasY1CasaConstruidaSuDineroSeReduceEns3500(){
		Jugador jugador= new Jugador();
		Provincia cordobaNorte=new CordobaNorte();
		Provincia cordobaSur=new CordobaSur();
		cordobaNorte.agregarOpuesto(cordobaSur);
		cordobaSur.agregarOpuesto(cordobaNorte);
		cordobaNorte.agregarPropietario(jugador);
		cordobaSur.agregarPropietario(jugador);
		cordobaNorte.construirCasa();
		cordobaNorte.construirCasa();
		cordobaSur.construirCasa();
		Jugador jugador2= new Jugador();
		int dineroAntesDeEntrarAPropiedad=jugador2.getDinero();
		cordobaNorte.entrar(jugador2);
		Assert.assertEquals(3500,dineroAntesDeEntrarAPropiedad-jugador2.getDinero());
	}
	
	@Test
	public void test6JugadorConstruyeHotelTeniendoCasasEnProvinciasOpuestas() {
		Jugador jugador= new Jugador();
		Provincia cordobaNorte=new CordobaNorte();
		Provincia cordobaSur=new CordobaSur();
		cordobaNorte.agregarOpuesto(cordobaSur);
		cordobaSur.agregarOpuesto(cordobaNorte);
		cordobaNorte.agregarPropietario(jugador);
		cordobaSur.agregarPropietario(jugador);
		cordobaNorte.construirCasa();
		cordobaNorte.construirCasa();
		cordobaSur.construirCasa();
		cordobaSur.construirCasa();
		cordobaNorte.construirHotel();
		Assert.assertEquals(1, cordobaNorte.cantHoteles());
	}
	
	@Test
	public void test7VerQueJugadorAlConstruirUnHotelSuDineroSeRedujo() {
		Jugador jugador= new Jugador();
		Provincia cordobaNorte=new CordobaNorte();
		Provincia cordobaSur=new CordobaSur();
		cordobaNorte.agregarOpuesto(cordobaSur);
		cordobaSur.agregarOpuesto(cordobaNorte);
		cordobaNorte.agregarPropietario(jugador);
		cordobaSur.agregarPropietario(jugador);
		cordobaNorte.construirCasa();
		cordobaNorte.construirCasa();
		cordobaSur.construirCasa();
		cordobaSur.construirCasa();
		int dineroAntesDeQuererCostruirHotel=jugador.getDinero();
		cordobaNorte.construirHotel();
		Assert.assertEquals(3500,dineroAntesDeQuererCostruirHotel-jugador.getDinero());
	}
	
	@Test
	public void test8VerQueAlConstruirUnHotelLasCasasEnLaProvinciaContruidaDesaparecieron() {
		Jugador jugador= new Jugador();
		Provincia cordobaNorte=new CordobaNorte();
		Provincia cordobaSur=new CordobaSur();
		cordobaNorte.agregarOpuesto(cordobaSur);
		cordobaSur.agregarOpuesto(cordobaNorte);
		cordobaNorte.agregarPropietario(jugador);
		cordobaSur.agregarPropietario(jugador);
		cordobaNorte.construirCasa();
		cordobaNorte.construirCasa();
		cordobaSur.construirCasa();
		cordobaSur.construirCasa();
		cordobaNorte.construirHotel();
		Assert.assertEquals(0,cordobaNorte.cantCasasConstruidas());
	}
	
	@Test
	public void test9JugadorQuiereConstruirHotelYNoPuedePorNoTenerCasaAlMaximo() {
		Jugador jugador= new Jugador();
		Provincia cordobaNorte=new CordobaNorte();
		Provincia cordobaSur=new CordobaSur();
		cordobaNorte.agregarOpuesto(cordobaSur);
		cordobaSur.agregarOpuesto(cordobaNorte);
		cordobaNorte.agregarPropietario(jugador);
		cordobaSur.agregarPropietario(jugador);
		cordobaNorte.construirCasa();
		cordobaNorte.construirCasa();
		cordobaSur.construirCasa();
		cordobaNorte.construirHotel();
		Assert.assertTrue(!cordobaNorte.SePuedeConstruisHoteles());
	}
	
	@Test
	public void test10ugadorQuiereConstruirHotelYNoPuedePorNoTenerCasaAlMaximoVerQueSuDineroNoSeDecremento() {
		Jugador jugador= new Jugador();
		Provincia cordobaNorte=new CordobaNorte();
		Provincia cordobaSur=new CordobaSur();
		cordobaNorte.agregarOpuesto(cordobaSur);
		cordobaSur.agregarOpuesto(cordobaNorte);
		cordobaNorte.agregarPropietario(jugador);
		cordobaSur.agregarPropietario(jugador);
		cordobaNorte.construirCasa();
		cordobaNorte.construirCasa();
		cordobaSur.construirCasa();
		int dineroAntesDeQuererCostruir=jugador.getDinero();
		cordobaNorte.construirHotel();
		Assert.assertEquals(dineroAntesDeQuererCostruir,jugador.getDinero());
	}

	@Test 
	public void test11VerQueJugadorAlCaerEnUnaProvinciConHotelSuDineroDisminuye5000() {
		Jugador jugador= new Jugador();
		Provincia cordobaNorte=new CordobaNorte();
		Provincia cordobaSur=new CordobaSur();
		cordobaNorte.agregarOpuesto(cordobaSur);
		cordobaSur.agregarOpuesto(cordobaNorte);
		cordobaNorte.agregarPropietario(jugador);
		cordobaSur.agregarPropietario(jugador);
		cordobaNorte.construirCasa();
		cordobaNorte.construirCasa();
		cordobaSur.construirCasa();
		cordobaSur.construirCasa();
		cordobaNorte.construirHotel();
		Jugador jugador2= new Jugador();
		int dineroAntesDeEntrar=jugador2.getDinero();
		cordobaNorte.entrar(jugador2);
		Assert.assertEquals(5000,dineroAntesDeEntrar-jugador2.getDinero());
	}

}
