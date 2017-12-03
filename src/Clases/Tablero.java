package Clases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

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
import javafx.scene.paint.Color;

public class Tablero {
	private static Tablero INSTANCIA;
	private HashMap<Jugador,Integer> posicionesJugadores;
	private ArrayList<Casilla> casillasTablero;
	private ArrayList<int[]> posicionesVista;
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
		posicionesVista = posicionesCasillasVista();
	}

	public static Tablero getInstancia() {
		if (INSTANCIA == null)
			INSTANCIA = new Tablero();
		return INSTANCIA;
	}
		
	public void agregarJugadores(ArrayList<Jugador> jugadores) {
		Color[] colores = {Color.BLUE, Color.SALMON, Color.WHEAT};
		for(int i = 0; i < jugadores.size(); i++) {
			Jugador jugador = jugadores.get(i);
			posicionesJugadores.put(jugador, 0);
			jugador.setColor(colores[i]);
		}
	}

	public int getPosicion(Jugador jugador1) {
		return posicionesJugadores.get(jugador1);
	}
	
	public Set<Jugador> getJugadores() {
		return posicionesJugadores.keySet();
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
		ProvinciaDividida bsSur = new BSSur();
		casillasTablero.add(bsSur);
		Servicio edesur = new Edesur();
		casillasTablero.add(edesur);
		ProvinciaDividida bsNorte = new BSNorte();
		casillasTablero.add(bsNorte);
		casillasTablero.add(Carcel.getInstancia());
		ProvinciaDividida cordobaSur = new CordobaSur();
		casillasTablero.add(cordobaSur);
		casillasTablero.add(new AvanceDinamico());
		Servicio subte = new Subte();
		casillasTablero.add(subte);
		ProvinciaDividida cordobaNorte = new CordobaNorte();
		casillasTablero.add(cordobaNorte);
		casillasTablero.add(new ImpuestoAlLujo());
		casillasTablero.add(new SantaFe());
		Servicio aysa = new Aysa();
		casillasTablero.add(aysa);
		ProvinciaDividida saltaNorte = new SaltaNorte();
		casillasTablero.add(saltaNorte);
		ProvinciaDividida saltaSur = new SaltaSur();
		casillasTablero.add(saltaSur);
		casillasTablero.add(Policia.getInstancia());
		Servicio trenes = new Trenes();
		casillasTablero.add(trenes);
		casillasTablero.add(new Neuquen());
		casillasTablero.add(new RetrocesoDinamico());
		casillasTablero.add(new Tucuman());
		Servicio.AgregarOpuestos(subte, trenes);
		Servicio.AgregarOpuestos(edesur, aysa);
		ProvinciaDividida.AgregarOpuestos(bsNorte, bsSur);
		ProvinciaDividida.AgregarOpuestos(cordobaNorte, cordobaSur);
		ProvinciaDividida.AgregarOpuestos(saltaNorte, saltaSur);
	}
	
	public void agregarTurno(Turno turnoIn) {
		turno = turnoIn;
	}
	
	public Turno getTurno() {
		return turno;
	}
	
	public ArrayList<int[]> posicionesCasillasVista() { //public?
		ArrayList<int[]> posiciones = new ArrayList<int[]>();
		Direccion direccion = new Direccion();
		int dirX = direccion.direccionActualX();
		int dirY = direccion.direccionActualY();
		int paso = 120;
		int[] acumuladorPosiciones = {0,600};
		for(int i = 0; i < CANTIDAD_CASILLAS; i++ ) {
			if(i % 5 == 0 && i > 0) {
				direccion.rotarDerecha();
				dirX = direccion.direccionActualX();
				dirY = direccion.direccionActualY();
			}
			acumuladorPosiciones[0] += paso * dirX;
			acumuladorPosiciones[1] += paso * dirY;
			posiciones.add(acumuladorPosiciones.clone());
		}
		return posiciones;
	}
	
	public ArrayList<Casilla> getCasillasTablero() {
		return casillasTablero;
	}
	
	public ArrayList<int[]> getPosicionesVista() {
		return posicionesVista;
	}
	
	
	
	
	
	
	
	
	
	

}
