package Clases;

public class Quini6 extends Casilla {
	
	public void entrar(Jugador jugador) {
		jugador.modificarDinero(50000);
		jugador.ganoQuini6();
	}
}