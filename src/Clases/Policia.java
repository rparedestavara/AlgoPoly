package Clases;

public class Policia extends Casilla{

	public void entrar(Jugador jugador) {
		Tablero tablero = Tablero.getInstancia();
		tablero.mandarALaCarcel(jugador);
		
	}
}
