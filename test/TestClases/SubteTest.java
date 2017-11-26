package TestClases;

import org.junit.Assert;
import org.junit.Test;

import Clases.Dados;
import Clases.Jugador;
import Clases.Provincia;
import Clases.SantaFe;
import Clases.Servicio;
import Clases.Subte;
import Clases.Trenes;

public class SubteTest {
	private static final double DELTA = 1e-15;
	@Test
	public void tes1CuandoUnjugadorEntraEnSubtePoseidaPorOtroJugadorSuDineroDisminuye600MultiplicadoDados() {
		Jugador inquilino = new Jugador();
		Jugador propietario = new Jugador();
		Trenes trenes = new Trenes();
		Subte subte = new Subte();
		Dados dados = Dados.getInstance();
		subte.agregarPropietario(propietario);
		subte.agregarOpuesto(trenes);
		int[] resultados={3,3};
		dados.setResultados(resultados);
		double dineroAntesDeEntrar = inquilino.getDinero();
		subte.entrar(inquilino);
		Assert.assertEquals(600 * 6, dineroAntesDeEntrar - inquilino.getDinero(),DELTA);
	}
	@Test
	public void testCasillaVendida() {
		Jugador jugador= new Jugador();
		Servicio subte = new Subte();
		subte.agregarPropietario(jugador);
		double dineroAntesDeVenderProiedad=jugador.getDinero();
		subte.vender(jugador);
		Assert.assertEquals(40000*0.85, jugador.getDinero()-dineroAntesDeVenderProiedad,DELTA);
	}
	
	@Test
	public void testAlVenderServicioUnJugadroEsteDejaDeSerPropietario() {
		Jugador jugador= new Jugador();
		Servicio subte = new Subte();
		subte.agregarPropietario(jugador);
		subte.vender(jugador);
		Assert.assertEquals(false,subte.esPropietario(jugador));
	}

}
