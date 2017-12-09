package TestClases;

import org.junit.Assert;
import org.junit.Test;

import Clases.Dados;
import Clases.Jugador;
import Clases.Servicio;
import Clases.Subte;
import Clases.Trenes;

public class TrenesTest {
	private static final double DELTA = 1e-15;
	@Test
	public void tes1CuandoUnjugadorEntraEnTrenesPoseidaPorOtroJugadorSuDineroDisminuye450MultiplicadoDados() {
		Jugador inquilino = new Jugador();
		Jugador propietario = new Jugador();
		Trenes trenes = new Trenes();
		Subte subte = new Subte();
		Dados dados = Dados.getInstance();
		trenes.comprar(propietario);
		trenes.agregarOpuesto(subte);
		int[] resultados={1,1};
		dados.setResultados(resultados);
		double dineroAntesDeEntrar = inquilino.getDinero();
		trenes.entrar(inquilino);
		Assert.assertEquals(450 * 2, dineroAntesDeEntrar - inquilino.getDinero(),DELTA);
	}
	@Test
	public void testCasillaVendida() {
		Jugador jugador= new Jugador();
		Servicio trenes = new Trenes();
		trenes.comprar(jugador);
		double dineroAntesDeVenderProiedad=jugador.getDinero();
		trenes.vender();
		Assert.assertEquals(38000*0.85, jugador.getDinero()-dineroAntesDeVenderProiedad,DELTA);
	}
	
	@Test
	public void testAlVenderServicioUnJugadroEsteDejaDeSerPropietario() {
		Jugador jugador= new Jugador();
		Servicio trenes = new Trenes();
		trenes.comprar(jugador);
		trenes.vender();
		Assert.assertEquals(false,trenes.esPropietario(jugador));
	}

}
