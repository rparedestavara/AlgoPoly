package Clases;

public class Barrio {

	private Jugador jugador;

	public void caeEste(Jugador jugador) {
		this.jugador=jugador;
	}
	public void agregarNuevoDuexo(Jugador jugador) {
		this.jugador=jugador;
	}
	public Jugador mostrarDuexo() {
		return this.jugador;
	}

}
