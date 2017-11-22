package TestConsignas;


import org.junit.Assert;
import org.junit.Test;

import Clases.Aysa;
import Clases.BSNorte;
import Clases.BSSur;
import Clases.Casilla;
import Clases.CordobaNorte;
import Clases.CordobaSur;
import Clases.Dados;
import Clases.Edesur;
import Clases.ImpuestoAlLujo;
import Clases.Jugador;
import Clases.Provincia;
import Clases.ProvinciaDividida;
import Clases.SaltaNorte;
import Clases.SaltaSur;
import Clases.SantaFe;
import Clases.Subte;
import Clases.Trenes;

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
		ProvinciaDividida bNorte=new BSNorte();
		ProvinciaDividida bSur=new BSSur();
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
	public void test2JugadorAlCaerEnCordobaConPropietarioYConUnaCasaConstruidaSuDineroSeReduceEns1800() {
		Jugador jugador= new Jugador();
		ProvinciaDividida cordobaNorte=new CordobaNorte();
		ProvinciaDividida cordobaSur=new CordobaSur();
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
		int dineroAntesDeEntrarAPropiedad=jugador2.getDinero();
		bNorte.entrar(jugador2);
		Assert.assertEquals(4000,dineroAntesDeEntrarAPropiedad-jugador2.getDinero());
	}
	@Test
	public void test3JugadorAlCaerEnSaltaConPropietarioYCon2CasasY1CasaConstruidaSuDineroSeReduceEns3850(){
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
	public void test3JugadorAlCaerEnCordobaConPropietarioYCon2CasasY1CasaConstruidaSuDineroSeReduceEns2900(){
		Jugador jugador= new Jugador();
		ProvinciaDividida cordobaNorte=new CordobaNorte();
		ProvinciaDividida cordobaSur=new CordobaSur();
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
	public void test4JugadorConstruyeHotelTeniendoCasasEnProvinciasOpuestasSALTA() {
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
	public void test4JugadorConstruyeHotelTeniendoCasasEnProvinciasOpuestascORDOBA() {
		Jugador jugador= new Jugador();
		ProvinciaDividida cordobaNorte=new CordobaNorte();
		ProvinciaDividida cordobaSur=new CordobaSur();
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
	public void test6JugadorQuiereConstruirHotelYNoPuedePorNoTenerCasaAlMaximoEnSalta() {
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
	public void test6JugadorQuiereConstruirHotelYNoPuedePorNoTenerCasaAlMaximoEnCordoba() {
		Jugador jugador= new Jugador();
		ProvinciaDividida cordobaNorte=new CordobaNorte();
		ProvinciaDividida cordobaSur=new CordobaSur();
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
		ProvinciaDividida bNorte = new BSNorte();
		ProvinciaDividida bSur = new BSSur();
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
	@Test 
	public void test7VerQueJugadorAlCaerEnCordobaConHotelSuDineroDisminuye3500() {
		Jugador jugador= new Jugador();
		ProvinciaDividida cordobaNorte=new CordobaNorte();
		ProvinciaDividida cordobaSur=new CordobaSur();
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

	@Test
	public void tes11CuandoUnjugadorEntraEnTrenesPoseidaPorOtroJugadorSuDineroDisminuye450MultiplicadoDados() {
		Jugador inquilino = new Jugador();
		Jugador propietario = new Jugador();
		Trenes trenes = new Trenes();
		Subte subte = new Subte();
		Dados dados = Dados.getInstance();
		trenes.agregarPropietario(propietario);
		trenes.agregarOpuesto(subte);
		dados.setResultado(8);
		int dineroAntesDeEntrar = inquilino.getDinero();
		trenes.entrar(inquilino);
		Assert.assertEquals(450 * 8, dineroAntesDeEntrar - inquilino.getDinero());
	}
	
	@Test
	public void test12CuandoUnjugadorEntraEnTrenesPoseidaPorOtroJugadorQueTieneASubteSuDineroDisminuye800MultiplicadoDados() {
		Jugador inquilino = new Jugador();
		Jugador propietario = new Jugador();
		Trenes trenes = new Trenes();
		Subte subte = new Subte();
		Dados dados = Dados.getInstance();
		trenes.agregarPropietario(propietario);
		subte.agregarPropietario(propietario);
		trenes.agregarOpuesto(subte);
		dados.setResultado(5);
		int dineroAntesDeEntrar = inquilino.getDinero();
		trenes.entrar(inquilino);
		Assert.assertEquals(800 * 5, dineroAntesDeEntrar - inquilino.getDinero());
	}
	
	@Test
	public void tes16CuandoUnjugadorEntraEnEdesurPoseidaPorOtroJugadorSuDineroDisminuye500MultiplicadoDados() {
		Jugador inquilino = new Jugador();
		Jugador propietario = new Jugador();
		Edesur edesur = new Edesur();
		Aysa aysa = new Aysa();
		Dados dados = Dados.getInstance();
		edesur.agregarPropietario(propietario);
		edesur.agregarOpuesto(aysa);
		dados.setResultado(3);
		int dineroAntesDeEntrar = inquilino.getDinero();
		edesur.entrar(inquilino);
		Assert.assertEquals(500 * 3, dineroAntesDeEntrar - inquilino.getDinero());
	}
	
	@Test
	public void test17CuandoUnjugadorEntraEnEdesurPoseidaPorOtroJugadorQueTieneAAyssaSuDineroDisminuye1000MultiplicadoDados() {
		Jugador inquilino = new Jugador();
		Jugador propietario = new Jugador();
		Edesur edesur = new Edesur();
		Aysa aysa = new Aysa();
		Dados dados = Dados.getInstance();
		edesur.agregarPropietario(propietario);
		aysa.agregarPropietario(propietario);
		edesur.agregarOpuesto(aysa);
		dados.setResultado(12);
		int dineroAntesDeEntrar = inquilino.getDinero();
		edesur.entrar(inquilino);
		Assert.assertEquals(1000 * 12, dineroAntesDeEntrar - inquilino.getDinero());
	}
	
	@Test
	public void test18JugadorNoPuedeConstruirHotelSinTenerCubiertoDeCasas(){
		Jugador propietario = new Jugador();
		ProvinciaDividida buenosAiresNorte = new BSNorte();
		ProvinciaDividida buenosAiresSur = new BSSur();
		buenosAiresNorte.agregarOpuesto(buenosAiresSur);
		buenosAiresSur.agregarOpuesto(buenosAiresNorte);
		buenosAiresNorte.entrar(propietario);
		buenosAiresNorte.construirCasa();
		int dineroSinConstruirHotel = propietario.getDinero();
		buenosAiresNorte.construirHotel();
		int dineroConstruyendoHotel = propietario.getDinero();
		Assert.assertEquals(dineroSinConstruirHotel, dineroConstruyendoHotel);
	}
	
	@Test
	public void test19JugadorDebePagarElAlquilerDeBsAs(){
		Jugador jugadorEnBsAs = new Jugador();
		Jugador propietario = new Jugador();
		ProvinciaDividida buenosAiresNorte = new BSNorte();
		ProvinciaDividida buenosAiresSur = new BSSur();
		int plataJugadorEnBsAs = jugadorEnBsAs.getDinero();
		buenosAiresNorte.entrar(propietario);
		buenosAiresSur.entrar(propietario);
		buenosAiresNorte.construirCasa();
		buenosAiresSur.construirCasa();
		int plataPropietario = propietario.getDinero();
		buenosAiresNorte.entrar(jugadorEnBsAs);
		buenosAiresSur.entrar(jugadorEnBsAs);
		Assert.assertEquals(plataJugadorEnBsAs - 6500, jugadorEnBsAs.getDinero());
		Assert.assertEquals(plataPropietario + 6500, propietario.getDinero());
	}
	
	@Test
	public void test20JugadorDebePagarElAlquilerDeSalta() {
		Jugador jugadorSalta= new Jugador();
		Jugador propietario = new Jugador();
		ProvinciaDividida saltaNorte = new SaltaNorte();
		ProvinciaDividida saltaSur = new SaltaSur();
		int plataJugadorSalta = jugadorSalta.getDinero();
		saltaNorte.entrar(propietario);
		saltaNorte.construirCasa();
		saltaSur.entrar(propietario);
		saltaSur.construirCasa();
		int plataPropietario = propietario.getDinero();
		saltaNorte.entrar(jugadorSalta);
		saltaSur.entrar(jugadorSalta);
		Assert.assertEquals(plataJugadorSalta - 6500, jugadorSalta.getDinero());
		Assert.assertEquals(plataPropietario + 6500, propietario.getDinero());
	}
	
	@Test
	public void test21JugadorDebePagarElAlquilerDeCordoba(){
		Jugador jugadorEnCordoba = new Jugador();
		Jugador propietario = new Jugador();
		ProvinciaDividida cordobaNorte = new CordobaNorte();
		ProvinciaDividida cordobaSur = new CordobaSur();
		int plataJugadorEnCordoba = jugadorEnCordoba.getDinero();
		cordobaNorte.entrar(propietario);
		cordobaNorte.construirCasa();
		cordobaSur.entrar(propietario);
		cordobaSur.construirCasa();
		int plataPropietario = propietario.getDinero();
		cordobaNorte.entrar(jugadorEnCordoba);
		cordobaSur.entrar(jugadorEnCordoba);
		Assert.assertEquals(plataJugadorEnCordoba - 3300, jugadorEnCordoba.getDinero());
		Assert.assertEquals(plataPropietario + 3300, propietario.getDinero());
	}
	
	@Test
	public void test22ConstruirEnSantaFeCuestaCuatroMil(){
		Jugador propietario = new Jugador();
		Provincia santaFe = new SantaFe();
		int plataPropietarioSinConstruir = propietario.getDinero();
		santaFe.entrar(propietario);
		santaFe.construirCasa();
		Assert.assertEquals(plataPropietarioSinConstruir - 4000, propietario.getDinero());
	}
	
	@Test
	public void test23IntercambioDePropietarioHaceQueCobreUnNuevoMonto(){
		Jugador propietario1 = new Jugador();
		Jugador propietario2 = new Jugador();
		Jugador visitante = new Jugador();
		Provincia bsAsNorte = new BSNorte();
		bsAsNorte.entrar(propietario1);
		Provincia santaFe = new SantaFe();
		santaFe.entrar(propietario2);
		int plataPropietario2 = propietario2.getDinero();
		propietario1.intercambiarPropiedad(propietario2,santaFe, bsAsNorte);
		bsAsNorte.entrar(visitante);
		Assert.assertEquals(plataPropietario2 + 2500, propietario2.getDinero());
	}
	
	@Test
	public void test24ImpuestoAlLujoReduceElCapitalDelJugadorUnDiezPorciento(){
		Jugador jugador = new Jugador();
		Casilla impuesto = new ImpuestoAlLujo();
		int plataJugadorSinEntrar = jugador.getDinero();
		impuesto.entrar(jugador);
		Assert.assertEquals(plataJugadorSinEntrar - (plataJugadorSinEntrar* 0.1), jugador.getDinero(),5);
	}
}
