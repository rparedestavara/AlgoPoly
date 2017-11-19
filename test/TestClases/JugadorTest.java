package TestClases;

import org.junit.Assert;
import org.junit.Test;

import Clases.Jugador;
import excepciones.SaldoInsuficienteException;

class JugadorTest {

	@Test(expected = SaldoInsuficienteException.class)
	public void pagarLanzaUnaExcepcionCuandoElMontoEsMayorAlDineroDelJugador(){
		Jugador jugador = new Jugador();
		jugador.pagar(1000000);
	}

}
