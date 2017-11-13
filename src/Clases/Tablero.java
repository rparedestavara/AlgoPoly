package Clases;

import java.util.ArrayList;
import java.util.HashMap;

public class Tablero {
	private HashMap<Jugador,Integer> posicionesJugadores;
	private static final int CANTIDAD_CASILLAS = 20;

	private int ajustarPosicionAlRangoDelTablero(int posicion) {
		while(posicion > (CANTIDAD_CASILLAS - 1)) { 
			posicion -= CANTIDAD_CASILLAS;
		}
		while(posicion < 0) {
			posicion += CANTIDAD_CASILLAS;
		}
		return posicion;
	}
	
	public Tablero(ArrayList<Jugador> jugadores) {
		posicionesJugadores = new HashMap<Jugador,Integer>();
		for(Jugador jugador : jugadores){
			posicionesJugadores.put(jugador, 0);
		}
	}

	public int getPosicion(Jugador jugador1) {
		return posicionesJugadores.get(jugador1);
	}

	public void mover(Jugador jugador, int pasos) {
		int nuevaPosicion = posicionesJugadores.get(jugador); 
		nuevaPosicion += pasos;
		nuevaPosicion = this.ajustarPosicionAlRangoDelTablero(nuevaPosicion);
		posicionesJugadores.put(jugador, nuevaPosicion);
	}
	

}
