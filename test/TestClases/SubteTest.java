package TestClases;

import org.junit.Assert;
import org.junit.Test;

import Clases.Dados;
import Clases.Jugador;
import Clases.Subte;
import Clases.Trenes;

public class SubteTest {

	@Test
	public void tes1CuandoUnjugadorEntraEnSubtePoseidaPorOtroJugadorSuDineroDisminuye600MultiplicadoDados() {
		Jugador inquilino = new Jugador();
		Jugador propietario = new Jugador();
		Trenes trenes = new Trenes();
		Subte subte = new Subte();
		Dados dados = Dados.getInstance();
		subte.agregarPropietario(propietario);
		subte.agregarOpuesto(trenes);
		dados.setResultado(6);
		int dineroAntesDeEntrar = inquilino.getDinero();
		subte.entrar(inquilino);
		Assert.assertEquals(600 * 6, dineroAntesDeEntrar - inquilino.getDinero());
	}

}
