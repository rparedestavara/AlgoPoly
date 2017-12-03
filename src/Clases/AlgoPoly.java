package Clases;

import java.util.ArrayList;
import java.util.List;

public class AlgoPoly {
	private List<Jugador> jugadores;
	private Turno turno;
	private Jugador ganador;
	private static final Tablero tablero = Tablero.getInstancia(); 
	private static AlgoPoly INSTANCIA;
	
	private AlgoPoly() {
		ganador = null;
	}
	
	public void mandarALaCarcel(Jugador jugador) {
		tablero.moverALaCarcel(jugador);
	}
	
	public void agregarTurno(Turno turnoIn) {
		turno = turnoIn;
	}
	
	public Turno getTurno() {
		return turno;
	}
	
	public boolean puedeHacerAcciones(Jugador jugador) {
		Carcel carcel = Carcel.getInstancia();
		return (!carcel.enCarcel(jugador));

	}

	public static AlgoPoly getInstancia() {
		if(INSTANCIA == null)
			INSTANCIA = new AlgoPoly();
		return INSTANCIA;
	}
	
	public void removerJugador(Jugador jugador) {
		jugadores.remove(jugador);
		if(jugadores.size() == 1) {
			this.ganador = jugadores.get(0);
			}
		}
	
	public void agregarJugadores(ArrayList<Jugador> jugadores) {
		this.jugadores = jugadores;
	}
		
	public boolean hayGanador() {
		return ganador != null;
	}
}
