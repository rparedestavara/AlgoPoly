package TestClases;

import org.junit.Assert;
import org.junit.Test;

import Clases.Jugador;
import Clases.ProvinciaDividida;
import Clases.SaltaNorte;
import Clases.SaltaSur;

public class SaltaSurTest {

	@Test
	public void test1VerQueJugadorQueEntraEnBSurSeLeDisminuyeDineroPorNoSerPropietario() {
		Jugador jugador= new Jugador();
		ProvinciaDividida SaltaNorte=new SaltaNorte();
		ProvinciaDividida SaltaSur=new SaltaSur();
		SaltaNorte.agregarOpuesto(SaltaSur);
		SaltaSur.agregarOpuesto(SaltaNorte);
		SaltaNorte.agregarPropietario(jugador);
		SaltaSur.agregarPropietario(jugador);
		SaltaNorte.construirCasa();
		SaltaSur.construirCasa();
		Jugador jugador2= new Jugador();
		int dineroAntesDeEntrarAPropiedad=jugador2.getDinero();
		SaltaSur.entrar(jugador2);
		Assert.assertEquals(3250,dineroAntesDeEntrarAPropiedad-jugador2.getDinero());
	}
}
