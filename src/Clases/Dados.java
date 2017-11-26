package Clases;

import java.util.Random;

public class Dados {
	private static Dados INSTANCE = new Dados();
	int resultadoDado1;
	int resultadoDado2;
	
	private Dados() {}
	
	public static Dados getInstance() {
		return INSTANCE;
	}
	
	public void lanzar(){
		Random rand = new Random();
		resultadoDado1 = rand.nextInt(6) + 1;
		resultadoDado2 = rand.nextInt(6) + 1;
	}
	
	public void setResultados(int[] resultado){
		resultadoDado1 = resultado[0];
		resultadoDado2 = resultado[1];
	}
	
	
	public int getResultado() {
		return resultadoDado1 + resultadoDado2;
	}
	
	public boolean salioDobles(){
		return resultadoDado1 == resultadoDado2;
	}

}
