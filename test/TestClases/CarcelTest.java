package TestClases;

import org.junit.Assert;
import org.junit.Test;

import Clases.Carcel;
import Clases.Jugador;

public class CarcelTest {

	@Test
	public void Test01SiJugadorCaeEnUnaCarcelNoPuedeRealizarAcciones() {
		Jugador jugador = new Jugador("Jugador1");
		Carcel carcel=new Carcel();
		carcel.entrar(jugador);
		jugador.informarQueEstaEn(carcel);
		Assert.assertEquals(false, !jugador.puedeHacerAcciones());
	}
}


