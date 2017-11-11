package Clases;

import Clases.Casilla;

public class Barrio extends Casilla {
	private Jugador propietario;
	
	public Barrio() {
		this.propietario = null;
	}
	
@Override
	public void entrar(Jugador jugador) {
		this.propietario = jugador;
	}

	public Jugador getPropietario(){
		return this.propietario;
	}

}
