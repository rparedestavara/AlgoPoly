package Clases;

import java.util.ArrayList;
import java.util.HashMap;

import Clases.Carcel;
import Clases.AvanceDinamico;
import Clases.Aysa;
import Clases.BSNorte;
import Clases.BSSur;
import Clases.Casilla;
import Clases.CordobaNorte;
import Clases.Edesur;
import Clases.ImpuestoAlLujo;
import Clases.Jugador;
import Clases.Neuquen;
import Clases.Quini6;
import Clases.RetrocesoDinamico;
import Clases.Salida;
import Clases.SaltaNorte;
import Clases.SaltaSur;
import Clases.SantaFe;
import Clases.Trenes;
import Clases.Tucuman;
import excepciones.NoPuedeJugarException;

public class Tablero {
	private static Tablero INSTANCIA;
	private HashMap<Jugador,Integer> posicionesJugadores;
	private ArrayList<Casilla> casillasTablero;
	private static final int CANTIDAD_CASILLAS = 20;
	private static final int POSICION_CARCEL = 5;
	public Turno turno;
	
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
		inicializarCasillasTablero();
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
	
	public void jugada(Jugador jugador, int pasos) {
		mover(jugador, pasos);
		int nuevaPosicion = getPosicion(jugador);
		casillasTablero.get(nuevaPosicion).entrar(jugador);

	}

	
	public void mover(Jugador jugador, double d) throws RuntimeException {
		if(!jugador.puedeHacerAcciones()) throw new NoPuedeJugarException(); 
		int nuevaPosicion = posicionesJugadores.get(jugador); 
		nuevaPosicion += d;
		nuevaPosicion = this.ajustarPosicionAlRangoDelTablero(nuevaPosicion);
		posicionesJugadores.put(jugador, nuevaPosicion);
	}

	
	public void mandarALaCarcel(Jugador jugador) {
		posicionesJugadores.put(jugador, POSICION_CARCEL);
		Carcel carcel = Carcel.getInstancia();
		carcel.entrar(jugador);
	}
	
	public void inicializarCasillasTablero(){
		casillasTablero = new ArrayList<Casilla>(20);
		casillasTablero.add(new Salida());
		casillasTablero.add(new Quini6());
		casillasTablero.add(new BSSur());
		casillasTablero.add(new Edesur());
		casillasTablero.add(new BSNorte());
		casillasTablero.add(Carcel.getInstancia());
		casillasTablero.add(new CordobaSur());
		casillasTablero.add(new AvanceDinamico());
		casillasTablero.add(new Subte());
		casillasTablero.add(new CordobaNorte());
		casillasTablero.add(new ImpuestoAlLujo());
		casillasTablero.add(new SantaFe());
		casillasTablero.add(new Aysa());
		casillasTablero.add(new SaltaNorte());
		casillasTablero.add(new SaltaSur());
		casillasTablero.add(Policia.getInstancia());
		casillasTablero.add(new Trenes());
		casillasTablero.add(new Neuquen());
		casillasTablero.add(new RetrocesoDinamico());
		casillasTablero.add(new Tucuman());
	}
	public void agregarTurno(Turno turnoIn) {
		turno = turnoIn;
	}
	
	public Turno getTurno() {
		return turno;
	}

}
