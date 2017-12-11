package Clases;

import java.util.HashMap;

public class Quini6 extends Casilla {
	private HashMap<Jugador, Integer> vecesGanadasRegistro;
	private static final int PREMIO_PRIMERA_VEZ = 50000;
	private static final int PREMIO_SEGUNDA_VEZ = 30000;
	
	public Quini6() {
		vecesGanadasRegistro = new HashMap<Jugador,Integer>();
		this.nombre = "Quini6";
	}
	
	public void registrarGanador(Jugador jugador) {
		if(! vecesGanadasRegistro.containsKey(jugador)) {
			vecesGanadasRegistro.put(jugador, 1);
		}
		else {
			int vecesGanadasJugadorActual = vecesGanadasRegistro.get(jugador);
			vecesGanadasRegistro.put(jugador, vecesGanadasJugadorActual + 1);
		}
	}
		
	public int cuantasVecesGano(Jugador jugador){
		if(! vecesGanadasRegistro.containsKey(jugador)) {
			return 0;
		}
		return vecesGanadasRegistro.get(jugador);
	}
	
	public void agregarMensajes(double dinero, Jugador jugador) {
		AlgoPoly algoPoly = AlgoPoly.getInstancia();
		algoPoly.agregarMensaje("Gano" + dinero);
		algoPoly.agregarMensaje("Su efectivo paso a ser $" + jugador.getDinero());
	}
	
	public void entrar(Jugador jugador) {
		int vecesGanadasJugador = this.cuantasVecesGano(jugador);
		if(vecesGanadasJugador == 0) {
			jugador.modificarDinero(PREMIO_PRIMERA_VEZ);
			agregarMensajes(PREMIO_PRIMERA_VEZ, jugador);
		}
		if(vecesGanadasJugador == 1) {
			jugador.modificarDinero(PREMIO_SEGUNDA_VEZ);
			agregarMensajes(PREMIO_SEGUNDA_VEZ, jugador);
		}
		this.registrarGanador(jugador);
	}
}