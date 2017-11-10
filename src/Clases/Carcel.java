package Clases;

import java.util.ArrayList;

public class Carcel {
	ArrayList<Jugador> jugadores ;
	
	public Carcel() {
		this.jugadores =new ArrayList<>();
	}
	
	public void encarcelarA(Jugador jugador) {
		this.jugadores.add(jugador);
	}

	public Jugador buscar(String nomJugador) {//me busca unjugador en carcel
		Jugador jugadorEncontrado= null;
		for(int i=0;i<this.jugadores.size();i++) {
			if(this.jugadores.get(i).getNombre()==nomJugador) {
					jugadorEncontrado=this.jugadores.get(i);
				}	
		}
		return jugadorEncontrado;
	}
}
