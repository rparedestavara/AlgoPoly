package Clases;

public class Barrio {

	private Jugador jugador;

	public void caeEste(Jugador jugador) {
		this.jugador=jugador;
	}
	public void agregarNuevoDueño(Jugador jugador) {
		this.jugador=jugador;
	}
	public Jugador mostrarDueño() {
		return this.jugador;
	}

}
