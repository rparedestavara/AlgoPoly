package TestClases;

import org.junit.Assert;
import org.junit.Test;

import Clases.Aysa;
import Clases.Dados;
import Clases.Edesur;
import Clases.Jugador;

public class EdesurTest {

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
		int dineroAntesDeEntrar = inquilino.getDinero();
		edesur.entrar(inquilino);
		Assert.assertEquals(500 * 9, dineroAntesDeEntrar - inquilino.getDinero());
	}

}
