package Clases;

import java.util.ArrayList;
import java.util.List;

public class AlgoPoly {
	private List<Jugador> jugadores;
	private ArrayList<String> mensajes;
	private Turno turno;
	private Jugador ganador;
	private static final Tablero tablero = Tablero.getInstancia(); 
	private static AlgoPoly INSTANCIA;
	
	private AlgoPoly() {
		mensajes = new ArrayList<String>();
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
		this.turno.removerJugador(jugador);
		jugador.perdio();
		if(jugadores.size() == 1) {
			this.ganador = jugadores.get(0);
			}
		}
	
	public void agregarJugadores(ArrayList<Jugador> jugadores) {
		this.jugadores = jugadores;
	}
	
	public List<String> getMensajes() {
		return mensajes;
	}
	
	public void borrarMensajes() {
		mensajes.clear();
	}
	
	public void agregarMensaje(String mensaje) {
		mensajes.add(mensaje);
	}
		
	public boolean hayGanador() {
		return ganador != null;
	}
}
