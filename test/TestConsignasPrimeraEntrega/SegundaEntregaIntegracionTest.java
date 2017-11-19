package TestConsignasPrimeraEntrega;

import org.junit.Assert;
import org.junit.Test;

import Clases.BSNorte;
import Clases.BSSur;
import Clases.CordobaNorte;
import Clases.CordobaSur;
import Clases.Jugador;
import Clases.Provincia;
import Clases.SaltaNorte;
import Clases.SaltaSur;

public class SegundaEntregaIntegracionTest {

	@Test
	public void test1JugadorAlAdquirirBuenosAiresNorteSuDineroSeReduce25000() {
		Jugador jugador= new Jugador();
		Provincia bNorte=new BSNorte();
		int dineroAntesDeAdquirirTerreno=jugador.getDinero();
		bNorte.agregarPropietario(jugador);
		Assert.assertEquals(25000,dineroAntesDeAdquirirTerreno-jugador.getDinero());
	}
	@Test
	public void test1JugadorAlAdquirirBuenosAiresSuruDineroSeReduce20000() {
		Jugador jugador= new Jugador();
		Provincia bSur=new BSSur();
		int dineroAntesDeAdquirirTerreno=jugador.getDinero();
		bSur.agregarPropietario(jugador);
		Assert.assertEquals(20000,dineroAntesDeAdquirirTerreno-jugador.getDinero());
	}
	@Test
	public void test1JugadorAlAdquirirSaltaSurSuDineroSeReduce23000() {
		Jugador jugador= new Jugador();
		Provincia saltaSur=new SaltaSur();
		int dineroAntesDeAdquirirTerreno=jugador.getDinero();
		saltaSur.agregarPropietario(jugador);
		Assert.assertEquals(23000,dineroAntesDeAdquirirTerreno-jugador.getDinero());
	}
	@Test
	public void test1JugadorAlAdquirirSaltaNorteSuDineroSeReduce23000() {
		Jugador jugador= new Jugador();
		Provincia saltaNorte=new SaltaNorte();
		int dineroAntesDeAdquirirTerreno=jugador.getDinero();
		saltaNorte.agregarPropietario(jugador);
		Assert.assertEquals(23000,dineroAntesDeAdquirirTerreno-jugador.getDinero());
	}
	@Test
	public void test1JugadorAlAdquirirCordobaNorteDineroSeReduce20000() {
		Jugador jugador= new Jugador();
		Provincia cordobaNorte=new CordobaNorte();
		int dineroAntesDeAdquirirTerreno=jugador.getDinero();
		cordobaNorte.agregarPropietario(jugador);
		Assert.assertEquals(20000,dineroAntesDeAdquirirTerreno-jugador.getDinero());
	}
	@Test
	public void test1JugadorAlAdquirirCordobaSurDineroSeReduce18000() {
		Jugador jugador= new Jugador();
		Provincia cordobaSur=new CordobaSur();
		int dineroAntesDeAdquirirTerreno=jugador.getDinero();
		cordobaSur.agregarPropietario(jugador);
		Assert.assertEquals(18000,dineroAntesDeAdquirirTerreno-jugador.getDinero());
	}
	@Test
	public void test2JugadorAlCaerEnBuenosConPropietarioYConUnaCasaConstruidaSuDineroSeReduceEns3500() {
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
		Assert.assertEquals(3500,dineroAntesDeEntrarAPropiedad-jugador2.getDinero());
	}
	@Test
	public void test2JugadorAlCaerEnSaltaConPropietarioYConUnaCasaConstruidaSuDineroSeReduceEns3250() {
		Jugador jugador= new Jugador();
		Provincia saltaNorte=new SaltaNorte();
		Provincia saltaSur=new SaltaSur();
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
	public void test2JugadorAlCaerEnCordobaConPropietarioYConUnaCasaConstruidaSuDineroSeReduceEns1800() {
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
		Assert.assertEquals(1800,dineroAntesDeEntrarAPropiedad-jugador2.getDinero());
	}
	@Test
	public void test3JugadorAlCaerEnBuenAiresConPropietarioYCon2CasasY1CasaConstruidaSuDineroSeReduceEns4000(){
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
		Assert.assertEquals(4000,dineroAntesDeEntrarAPropiedad-jugador2.getDinero());
	}
	@Test
	public void test3JugadorAlCaerEnSaltaConPropietarioYCon2CasasY1CasaConstruidaSuDineroSeReduceEns3850(){
		Jugador jugador= new Jugador();
		Provincia saltaNorte=new SaltaNorte();
		Provincia saltaSur=new SaltaSur();
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
	public void test3JugadorAlCaerEnCordobaConPropietarioYCon2CasasY1CasaConstruidaSuDineroSeReduceEns2900(){
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
		Assert.assertEquals(2900,dineroAntesDeEntrarAPropiedad-jugador2.getDinero());
	}
	@Test
	public void test4JugadorConstruyeHotelTeniendoCasasEnProvinciasOpuestasBueAires() {
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
	public void test4JugadorConstruyeHotelTeniendoCasasEnProvinciasOpuestasSALTA() {
		Jugador jugador= new Jugador();
		Provincia saltaNorte=new SaltaNorte();
		Provincia saltaSur=new SaltaSur();
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
	public void test4JugadorConstruyeHotelTeniendoCasasEnProvinciasOpuestascORDOBA() {
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
	public void test6JugadorQuiereConstruirHotelYNoPuedePorNoTenerCasaAlMaximoEnBueAires() {
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
	public void test6JugadorQuiereConstruirHotelYNoPuedePorNoTenerCasaAlMaximoEnSalta() {
		Jugador jugador= new Jugador();
		Provincia saltaNorte=new SaltaNorte();
		Provincia saltaSur=new SaltaSur();
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
	public void test6JugadorQuiereConstruirHotelYNoPuedePorNoTenerCasaAlMaximoEnCordoba() {
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
	public void test7VerQueJugadorAlCaerEnBuenosAiresConHotelSuDineroDisminuye5000() {
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
	@Test 
	public void test7VerQueJugadorAlCaerEnUnaSaltaConHotelSuDineroDisminuye5500() {
		Jugador jugador= new Jugador();
		Provincia saltaNorte=new SaltaNorte();
		Provincia saltaSur=new SaltaSur();
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
	@Test 
	public void test7VerQueJugadorAlCaerEnCordobaConHotelSuDineroDisminuye3500() {
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
		Assert.assertEquals(3500,dineroAntesDeEntrar-jugador2.getDinero());
	}

}
