package TestClases;


import org.junit.Assert;
import org.junit.Test;

import Clases.CordobaNorte;
import Clases.CordobaSur;
import Clases.Jugador;
import Clases.Provincia;

public class CordobaSurTest {

	@Test
	public void test1VerQueJugadorQueEntraEnCordobaSurSeLeDisminuyeDineroPorNoSerPropietario() {
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
		cordobaSur.entrar(jugador2);
		Assert.assertEquals(3000,dineroAntesDeEntrarAPropiedad-jugador2.getDinero());
	}
	
	@Test
	public void test2JugadorAlCaerEnUnaProvinciaConPropietarioYCon2CasasY1CasaConstruidaSuDineroNoSeReducePorCaerEnProvinciaConUnaCasilla(){
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
		cordobaSur.entrar(jugador2);
		Assert.assertEquals(0,dineroAntesDeEntrarAPropiedad-jugador2.getDinero());
	}

}
