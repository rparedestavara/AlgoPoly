package TestClases;

import org.junit.Assert;
import org.junit.Test;

import Clases.Aysa;
import Clases.Dados;
import Clases.Edesur;
import Clases.Jugador;
import Clases.Servicio;

public class AysaTest {
	private static final double DELTA = 1e-15;
	@Test
	public void tes16CuandoUnjugadorEntraEnEdesurPoseidaPorOtroJugadorSuDineroDisminuye300MultiplicadoDados() {
		Jugador inquilino = new Jugador();
		Jugador propietario = new Jugador();
		Edesur edesur = new Edesur();
		Aysa aysa = new Aysa();
		Dados dados = Dados.getInstance();
		aysa.agregarPropietario(propietario);
		aysa.agregarOpuesto(edesur);
		int[] resultados={5,6};
		dados.setResultados(resultados);
		double dineroAntesDeEntrar = inquilino.getDinero();
		aysa.entrar(inquilino);
		Assert.assertEquals(300 * 11, dineroAntesDeEntrar - inquilino.getDinero(),DELTA);
	}
	@Test
	public void testCasillaVendida() {
		Jugador jugador= new Jugador();
		Servicio aysa = new Aysa();
		aysa.agregarPropietario(jugador);
		double dineroAntesDeVenderProiedad=jugador.getDinero();
		aysa.vender(jugador);
		Assert.assertEquals(30000*0.85, jugador.getDinero()-dineroAntesDeVenderProiedad,DELTA);
	}
	
	@Test
	public void testAlVenderServicioUnJugadroEsteDejaDeSerPropietario() {
		Jugador jugador= new Jugador();
		Servicio aysa = new Aysa();
		aysa.agregarPropietario(jugador);
		aysa.vender(jugador);
		Assert.assertEquals(false,aysa.esPropietario(jugador));
	}
}
