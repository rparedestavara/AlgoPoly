package Clases;

import java.util.HashMap;

public class Carcel extends Casilla{
	HashMap<Jugador,Integer> jugadores ;
	
	public Carcel() {
		this.jugadores = new HashMap<>();
	}
	
	public void entrar(Jugador jugador) {
		this.jugadores.put(jugador,0);
	}

	public boolean estaEnCarcel(Jugador jugador) {
		return (jugadores.get(jugador)==null);
	}

	public void liberar(Jugador jugador) {
		this.jugadores.remove(jugador);
	}

	public void aumentarTurno(Jugador jugador) {
		this.jugadores.put(jugador,this.jugadores.get(jugador)+1);
		if(this.jugadores.get(jugador)>3) this.liberar(jugador);
	}

	public int turnosEnCarcel(Jugador jugador) {
		return this.jugadores.get(jugador);
	}
	
	
}
