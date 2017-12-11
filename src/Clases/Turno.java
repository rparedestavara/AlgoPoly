package Clases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Turno {
	private List<Jugador> jugadores;
	int posicionJugadorActual;
	boolean jugoDosVeces;
	boolean hayGanador;
	private ArrayList<Propiedad> propiedadesVendidas;
	
	
	public Turno(List<Jugador> jugadoresIn) {
		jugadores = jugadoresIn;
		Collections.shuffle(jugadores);
		posicionJugadorActual = 0;
		jugoDosVeces = false;
		hayGanador = false;
		this.propiedadesVendidas=new ArrayList<Propiedad>();
	}
	
	public Jugador aQuienLeToca() {
		
		return jugadores.get(posicionJugadorActual);
		
	}
	
	public boolean juegaElMismoJugador() {
		Dados dados = Dados.getInstance();
		return dados.salioDobles() && !jugoDosVeces;
	}
	
	private void avanzarTurno() {
		posicionJugadorActual++;
		if(posicionJugadorActual >= jugadores.size()) {
			posicionJugadorActual = 0;
		}
	}
	

	public Jugador proximoTurno() {
		if(juegaElMismoJugador()) {
			jugoDosVeces = true;
		}
		else{
			avanzarTurno();
			jugoDosVeces = false;
		}
		return jugadores.get(posicionJugadorActual);
	}
	
	
	
	public boolean estaJugando(Jugador jugador) {
		return jugadores.contains(jugador);
	}

	public void agregarPropiedadVendidaDeJugador(Propiedad propiedad) {
		this.propiedadesVendidas.add(propiedad);
	}
	
	public ArrayList<Propiedad> propiedadesVendidas() {
		ArrayList<Propiedad> propiedades=this.propiedadesVendidas;
		return propiedades ;
	}

	public void borrarPropiedades() {
		this.propiedadesVendidas.clear();
	}
}
