package Clases;

import Clases.Casilla;

public class Barrio extends Casilla {
	private String propietario;
	
	public Barrio() {
		this.propietario = null;
	}
	
@Override
	public void entrar(Jugador jugador) {
		this.propietario = jugador.getNombre();
	
	}

	public String getPropietario(){
		return this.propietario;
	}

}
