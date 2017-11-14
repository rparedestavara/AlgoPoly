package Clases;

import java.util.HashMap;

public class Carcel extends Casilla{
	private static Carcel INSTANCE;
	HashMap<Jugador,Integer> jugadores ;
	
	private Carcel() {
		this.jugadores = new HashMap<>();
	}
	
	public static Carcel getInstancia() {
		if (INSTANCE == null)
			INSTANCE = new Carcel();
		return INSTANCE;
	}
	
	public void entrar(Jugador jugador) {
		jugador.informarQueEstaEn(this);
		this.jugadores.put(jugador,0);
	}

	public boolean estaEnCarcel(Jugador jugador) {
		return (jugadores.get(jugador)==null);
	}
	
	public boolean enCarcel(Jugador jugador) {
		return jugadores.containsKey(jugador);
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
