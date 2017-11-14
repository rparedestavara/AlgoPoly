package Clases;

public class Dados {
	public static Dados INSTANCE = new Dados();
	private int resultado;
	
	private Dados() {
		resultado = 0;
	}
	
	public static Dados getInstance() {
		return INSTANCE;
	}
}
