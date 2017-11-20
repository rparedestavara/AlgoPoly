package TestClases;


import org.junit.Assert;
import org.junit.Test;

import Clases.CordobaNorte;
import Clases.CordobaSur;
import Clases.Jugador;
import Clases.ProvinciaDividida;

public class CordobaSurTest {

	@Test
	public void test1VerQueJugadorQueEntraEnCordobaSurSeLeDisminuyeDineroPorNoSerPropietario() {
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
		cordobaSur.entrar(jugador2);
		Assert.assertEquals(1500,dineroAntesDeEntrarAPropiedad-jugador2.getDinero());
	}
}
