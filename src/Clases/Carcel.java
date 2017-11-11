package Clases;

import java.util.HashSet;

public class Carcel extends Casilla{
	HashSet<Jugador> jugadores ;
	
	public Carcel() {
		this.jugadores = new HashSet<>();
	}
	
	public void entrar(Jugador jugador) {
		this.jugadores.add(jugador);
		
	}

	public boolean estaEnCarcel(Jugador jugador) {
		return jugadores.contains(jugador);
	}
}
