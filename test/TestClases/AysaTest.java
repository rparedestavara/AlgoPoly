package TestClases;

import org.junit.Assert;
import org.junit.Test;

import Clases.Aysa;
import Clases.Dados;
import Clases.Edesur;
import Clases.Jugador;

public class AysaTest {

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
		int dineroAntesDeEntrar = inquilino.getDinero();
		aysa.entrar(inquilino);
		Assert.assertEquals(300 * 11, dineroAntesDeEntrar - inquilino.getDinero());
	}

}
