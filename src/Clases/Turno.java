package Clases;

import java.util.Collections;
import java.util.List;

public class Turno {
	private List<Jugador> jugadores;
	int posicionJugadorActual;
	boolean jugoDosVeces;
	
	
	public Turno(List<Jugador> jugadoresIn) {
		jugadores = jugadoresIn;
		Collections.shuffle(jugadores);
		posicionJugadorActual = 0;
		jugoDosVeces = false;
	}
	
	public Jugador aQuienLeToca() {
		return jugadores.get(posicionJugadorActual);
	}
	
	private boolean juegaElMismoJugador() {
		Dados dados = Dados.getInstance();
		return dados.salioDobles() && !jugoDosVeces;
	}
	
	private void avanzarTurno() {
		posicionJugadorActual++;
		if(posicionJugadorActual >= jugadores.size()) {
			posicionJugadorActual = 0;
		}
	}
	
	public Jugador proximoTurno() {
		if(juegaElMismoJugador()) {
			jugoDosVeces = true;
		}
		else{
			avanzarTurno();
			jugoDosVeces = false;
		}
		return jugadores.get(posicionJugadorActual);
	}
	
}
