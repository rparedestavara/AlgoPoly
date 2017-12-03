package Clases;

import java.util.HashMap;

public class Carcel extends Casilla{
	private static Carcel INSTANCE;
	HashMap<Jugador,Integer> jugadores ;
	
	private Carcel() {
		this.jugadores = new HashMap<>();
		nombre = "Carcel";
	}
	
	public static Carcel getInstancia() {
		if (INSTANCE == null)
			INSTANCE = new Carcel();
		return INSTANCE;
	}
	
	public void entrar(Jugador jugador) {
		this.jugadores.put(jugador,0);
	}

	public boolean enCarcel(Jugador jugador) {
		return jugadores.containsKey(jugador);
	}

	public void liberar(Jugador jugador) {
		this.jugadores.remove(jugador);
	}

	public void aumentarTurno(Jugador jugador) {
		if((this.enCarcel(jugador)) && (this.jugadores.get(jugador) < 3)) {
			this.jugadores.put(jugador,this.jugadores.get(jugador)+1);}
		else {
			this.jugadores.remove(jugador);
		}
	}

	public int turnosEnCarcel(Jugador jugador) {
		return this.jugadores.get(jugador);
	}
	
	
}
