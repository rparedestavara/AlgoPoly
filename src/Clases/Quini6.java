package Clases;


public class Quini6 extends Casilla {
	
	
	public void entrar(Jugador jugador) {
		int dineroJugador = jugador.getDinero();
		int cantidadDeVecesGanado = jugador.getCantidadVecesQueGanoQuini6();
		dineroJugador = this.calcularDinero(dineroJugador, cantidadDeVecesGanado);
		jugador.setDinero(dineroJugador);
		jugador.ganoQuini6();
		
	}

	private int calcularDinero(int dineroJugador, int cantidadDeVecesQueGanoQuini6) {
		int premioQuini6 = 0; 
		if (cantidadDeVecesQueGanoQuini6 < 2)
			 premioQuini6 = (50000 -(20000*cantidadDeVecesQueGanoQuini6));
		return dineroJugador + premioQuini6;
	}
}