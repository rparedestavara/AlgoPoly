package TestClases;

import org.junit.Assert;
import org.junit.Test;

import Clases.BSNorte;
import Clases.BSSur;
import Clases.Jugador;
import Clases.Provincia;

public class BuenosAiresSurTest {
	@Test
	public void test0JugadorAlAdquirirBuenosAiresSuruDineroSeReduce25000() {
		Jugador jugador= new Jugador();
		Provincia bSur=new BSSur();
		int dineroAntesDeAdquirirTerreno=jugador.getDinero();
		bSur.agregarPropietario(jugador);
		Assert.assertEquals(23000,dineroAntesDeAdquirirTerreno-jugador.getDinero());
	}

	@Test
	public void test1VerQueJugadorQueEntraEnBSurSeLeDisminuyeDineroPorNoSerPropietario() {
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
		bSur.entrar(jugador2);
		Assert.assertEquals(3000,dineroAntesDeEntrarAPropiedad-jugador2.getDinero());
	}
	
	@Test
	public void test2JugadorAlCaerEnUnaProvinciaConPropietarioYCon2CasasY1CasaConstruidaSuDineroNoSeReducePorCaerEnProvinciaConUnaCasilla(){
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
		bSur.entrar(jugador2);
		Assert.assertEquals(0,dineroAntesDeEntrarAPropiedad-jugador2.getDinero());
	}

}
