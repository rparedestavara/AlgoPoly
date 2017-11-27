package TestClases;

import org.junit.Assert;
import org.junit.Test;

import Clases.Dados;

public class DadosTest {

	@Test
	public void test01LanzarDadosGeneraUnResultadoDentroDelRangoDeseado() {
		Dados dados = Dados.getInstance();
		for(int i = 0; i < 20; i++){
			dados.lanzar();
			int resultadoDados = dados.getResultado();
			Assert.assertTrue(1 <= resultadoDados && resultadoDados <= 12);
		}
	}
	@Test
	public void testDadosSaleDobleDebeDeDarTrue() {
		Dados dados = Dados.getInstance();
		int[] vec= new int[2];
		vec[1]=5;
		vec[0]=5;
		dados.setResultados(vec);
		Assert.assertTrue(dados.salioDobles());
	}

}
