package Clases;

public class Jugador {

	private int dineroActual;
	private int cantVecesQueGanoQuini6;
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
		this.dineroActual += monto;
	}
	public int getCantVecesQueGanoQuini6() {
		return this.cantVecesQueGanoQuini6;
	}
	public void GanoQuini6() {
		this.cantVecesQueGanoQuini6+=1;
	}
	public String getNombre(){
		return this.nombre;
	}
	public void informarQueEstaEn(Carcel carcel) {
		this.carcel=carcel;
	}
	public boolean puedeHacerAcciones() {
		return (carcel.buscar(this.nombre) != null);//me indica que si jugator esta encarcel esa igualdad me tiene que dal truey si no esta debe de dar false
	}


}
