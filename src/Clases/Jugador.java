package Clases;

public class Jugador {

	private int dineroActual;
	private int cantVecesQueGanoQuini6;
	
	public Jugador() {
		this.dineroActual=100000;
	}
	public int getDinero() {
		return this.dineroActual;
	}
	public void modificarDinero(int monto) {
		this.dineroActual += monto;
	}
	public int getCantVecesQueGanoQuini6() {
		return this.cantVecesQueGanoQuini6;
	}
	public void GanoQuini6() {
		this.cantVecesQueGanoQuini6+=1;
	}

}
