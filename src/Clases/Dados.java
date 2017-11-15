package Clases;

public class Dados {
	private static Dados INSTANCE = new Dados();
	int resultadoDados;
	
	private Dados() {}
	
	public static Dados getInstance() {
		return INSTANCE;
	}
	
	public void setResultado(int resultado){
		resultadoDados = resultado;
	}
	public int getResultado() {
		return this.resultadoDados;
	}
	
}
