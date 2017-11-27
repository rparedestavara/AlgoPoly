package TestClases;

import org.junit.Assert;
import org.junit.Test;

import Clases.Aysa;
import Clases.Dados;
import Clases.Edesur;
import Clases.Jugador;
import Clases.Servicio;

public class EdesurTest {
	private static final double DELTA = 1e-15;
	@Test
	public void tes16CuandoUnjugadorEntraEnEdesurPoseidaPorOtroJugadorSuDineroDisminuye500MultiplicadoDados() {
		Jugador inquilino = new Jugador();
		Jugador propietario = new Jugador();
		Edesur edesur = new Edesur();
		Aysa aysa = new Aysa();
		Dados dados = Dados.getInstance();
		edesur.agregarPropietario(propietario);
		edesur.agregarOpuesto(aysa);
		int[] resultados={4,5};
		dados.setResultados(resultados);
		double dineroAntesDeEntrar = inquilino.getDinero();
		edesur.entrar(inquilino);
		Assert.assertEquals(500 * 9, dineroAntesDeEntrar - inquilino.getDinero(),DELTA);
	}
	
	@Test
	public void testCasillaVendida() {
		Jugador jugador= new Jugador();
		Servicio edesur = new Edesur();
		edesur.agregarPropietario(jugador);
		double dineroAntesDeVenderProiedad=jugador.getDinero();
		edesur.vender();
		Assert.assertEquals(35000*0.85, jugador.getDinero()-dineroAntesDeVenderProiedad,DELTA);
	}
	
	@Test
	public void testAlVenderServicioUnJugadroEsteDejaDeSerPropietario() {
		Jugador jugador= new Jugador();
		Servicio edesur = new Edesur();
		edesur.agregarPropietario(jugador);
		edesur.vender();
		Assert.assertEquals(false,edesur.esPropietario(jugador));
	}
}
