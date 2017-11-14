package Clases;

import java.util.HashMap;

public class Quini6 extends Casilla {
	private HashMap<Jugador, Integer> vecesGanadasRegistro;
	private static final int PREMIO_PRIMERA_VEZ = 50000;
	private static final int PREMIO_SEGUNDA_VEZ = 30000;
	
	public Quini6() {
		vecesGanadasRegistro = new HashMap<Jugador,Integer>();
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
	
	public void entrar(Jugador jugador) {
		int vecesGanadasJugador = this.cuantasVecesGano(jugador);
		if(vecesGanadasJugador == 0) {
			jugador.modificarDinero(PREMIO_PRIMERA_VEZ);
		}
		if(vecesGanadasJugador == 1) {
			jugador.modificarDinero(PREMIO_SEGUNDA_VEZ);
		}
		this.registrarGanador(jugador);
	}
}