package TestClases;

import org.junit.Assert;
import org.junit.Test;

import Clases.Dados;
import Clases.Jugador;
import Clases.Subte;
import Clases.Trenes;

public class TrenesTest {

	@Test
	public void tes1CuandoUnjugadorEntraEnTrenesPoseidaPorOtroJugadorSuDineroDisminuye450MultiplicadoDados() {
		Jugador inquilino = new Jugador();
		Jugador propietario = new Jugador();
		Trenes trenes = new Trenes();
		Subte subte = new Subte();
		Dados dados = Dados.getInstance();
		trenes.agregarPropietario(propietario);
		trenes.agregarOpuesto(subte);
		int[] resultados={1,1};
		dados.setResultados(resultados);
		int dineroAntesDeEntrar = inquilino.getDinero();
		trenes.entrar(inquilino);
		Assert.assertEquals(450 * 2, dineroAntesDeEntrar - inquilino.getDinero());
	}

}
