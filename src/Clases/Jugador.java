package Clases;

public class Jugador {

	private int dineroActual;
	private int cantidadDeVecesQueGanoQuini6;
	private String nombre;
	private Carcel carcel;
	
	public Jugador() {
		this.dineroActual=100000;
		
	}
	public Jugador(String nombre) {
		this();//Llama a mi constructor sin parametros Jugador()
		this.nombre=nombre;
	}
	
	public int getDinero() {
		return this.dineroActual;
	}
	
	public void modificarDinero(int monto) {
		if (cantidadDeVecesQueGanoQuini6 < 2) {
			this.dineroActual += (monto-(20000*cantidadDeVecesQueGanoQuini6));
		}
	}
			
	public int getCantidadVecesQueGanoQuini6() {
		return this.cantidadDeVecesQueGanoQuini6;
	}
	public void ganoQuini6() {
		this.cantidadDeVecesQueGanoQuini6++;
	}
	public String getNombre(){
		return this.nombre;
	}
	public void informarQueEstaEn(Carcel carcel) {
		this.carcel=carcel;
	}
	public boolean puedeHacerAcciones() {
		return (carcel.buscar(this.nombre) != null);

	}

}