package Clases;

import java.util.ArrayList;
import java.util.HashMap;

import Clases.Carcel;

public class Tablero {
	private HashMap<Jugador,Integer> posicionesJugadores;
	private static final int CANTIDAD_CASILLAS = 20;
	private static final int POSICION_CARCEL = 5;
	private Carcel carcel;

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
			jugador.setTablero(this);
			posicionesJugadores.put(jugador, 0);
		}
		carcel = new Carcel();
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

	public void mandarALaCarcel(Jugador jugador) {
		posicionesJugadores.put(jugador, POSICION_CARCEL);
		carcel.entrar(jugador);
	}
	
	public Carcel getCarcel() {
		return carcel;
	}

}
