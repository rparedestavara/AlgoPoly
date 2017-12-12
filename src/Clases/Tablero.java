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
		inicializarCasillasTablero();
	}

	public static Tablero getInstancia() {
		if (INSTANCIA == null)
			INSTANCIA = new Tablero();
		return INSTANCIA;
	}
		
	public void agregarJugadores(ArrayList<Jugador> jugadores) {
		Color[] colores = {Color.BLUE, Color.DARKSALMON, Color.RED};
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
		AlgoPoly algoPoly = AlgoPoly.getInstancia();
		mover(jugador, pasos);
		int nuevaPosicion = getPosicion(jugador);
		Casilla casillaActual = casillasTablero.get(nuevaPosicion);
		algoPoly.agregarMensaje("Usted cayo en " + casillaActual.getNombre());
		casillaActual.entrar(jugador);
	}

	
	public void mover(Jugador jugador, double pasos) throws RuntimeException {
		if(!AlgoPoly.getInstancia().puedeHacerAcciones(jugador)) throw new NoPuedeJugarException(); 
		int nuevaPosicion = posicionesJugadores.get(jugador); 
		nuevaPosicion += pasos;
		nuevaPosicion = this.ajustarPosicionAlRangoDelTablero(nuevaPosicion);
		posicionesJugadores.put(jugador, nuevaPosicion);
	}

	
	public void moverALaCarcel(Jugador jugador) {
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
	
	public ArrayList<Casilla> getCasillasTablero() {
		return casillasTablero;
	}	

}
