package Clases;

import Clases.Casilla;

public class Provincia extends Casilla {
	private Jugador propietario;
	
	public Provincia() {
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
