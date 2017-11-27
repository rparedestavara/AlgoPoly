package Clases;

public class Policia extends Casilla{
	private static Policia INSTANCIA;
	
	private Policia() {
		nombre = "Policia";
	}
	
	public static Policia getInstancia() {
		if (INSTANCIA == null) {
			INSTANCIA = new Policia();
		}
		return INSTANCIA;
	}
	
	public void entrar(Jugador jugador) {
		Tablero tablero = Tablero.getInstancia();
		tablero.mandarALaCarcel(jugador);
		
	}
}
