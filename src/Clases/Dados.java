package Clases;

public class Dados {
	private static Dados INSTANCE = new Dados();
	int resultadoDados;
	
	private Dados() {}
	
	public static Dados getInstance() {
		return INSTANCE;
	}
	
	public void setResultadoDados(int resultado){
		resultadoDados = resultado;
	}
	
}
