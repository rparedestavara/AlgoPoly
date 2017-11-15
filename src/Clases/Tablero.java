package Clases;

import java.util.ArrayList;
import java.util.HashMap;

import Clases.Carcel;
import excepciones.NoPuedeJugarException;

public class Tablero {
	private static Tablero INSTANCIA;
	private HashMap<Jugador,Integer> posicionesJugadores;
	private static final int CANTIDAD_CASILLAS = 20;
	private static final int POSICION_CARCEL = 5;
	
	private int ajustarPosicionAlRangoDelTablero(int posicion) {
		while(posicion > (CANTIDAD_CASILLAS - 1)) { 
			posicion -= CANTIDAD_CASILLAS;
		}
		while(posicion < 0) {
			posicion += CANTIDAD_CASILLAS;
		}
		return posicion;
	}
	
	
	private Tablero() {
		posicionesJugadores = new HashMap<Jugador,Integer>();
		
	}

	public static Tablero getInstancia() {
		if (INSTANCIA == null)
			INSTANCIA = new Tablero();
		return INSTANCIA;
	}
		
	public void agregarJugadores(ArrayList<Jugador> jugadores) {
		for(Jugador jugador : jugadores)
			posicionesJugadores.put(jugador, 0);
		
		
	}

	public int getPosicion(Jugador jugador1) {
		return posicionesJugadores.get(jugador1);
	}

	
	public void mover(Jugador jugador, int pasos) throws RuntimeException {
		if(!jugador.puedeHacerAcciones()) throw new NoPuedeJugarException(); 
		int nuevaPosicion = posicionesJugadores.get(jugador); 
		nuevaPosicion += pasos;
		nuevaPosicion = this.ajustarPosicionAlRangoDelTablero(nuevaPosicion);
		posicionesJugadores.put(jugador, nuevaPosicion);
	}

	
	public void mandarALaCarcel(Jugador jugador) {
		posicionesJugadores.put(jugador, POSICION_CARCEL);
		Carcel carcel = Carcel.getInstancia();
		carcel.entrar(jugador);
	}
	
	

}
