package Clases;

public class Policia extends Casilla{

	public void entrar(Jugador jugador) {
		Tablero tablero = jugador.getTablero();
		tablero.mandarALaCarcel(jugador);
	}
}
