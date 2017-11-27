package Clases;

import javafx.scene.paint.Color;

public abstract class Propiedad extends Casilla{
	protected int precioPropiedad;
	protected Jugador propietario;
	
	public Propiedad(){
		propietario = null;
	}
	
	public void agregarPropietario(Jugador jugador) {
		this.entrar(jugador);
		color = jugador.getColor();
	}
	
	public boolean esPropietario(Jugador jugadorDesconocido) {
		return (jugadorDesconocido==this.propietario);
	}
	
	protected abstract void cobrar(Jugador residente);
	
	public void entrar(Jugador jugador) {
		if(this.propietario==null) {
			this.propietario = jugador;
			this.propietario.modificarDinero(-this.precioPropiedad);
			this.propietario.agregarPropiedad(this);
			color = jugador.getColor();
		}
		else this.entroUnDesconocido(jugador);
	}
	
	public void entroUnDesconocido(Jugador jugadorDesconocido) {
		if(!esPropietario(jugadorDesconocido) ) {
			this.cobrar(jugadorDesconocido);
		}
	}
	public void vender(Jugador jugador) {
		this.propietario = null;
		color = Color.WHITE;
		jugador.quitarPropiedad(this);
		this.pagar(jugador);
	}
	
	protected void cambiarPropietario(Jugador jugador) {
		this.propietario = jugador;
		color = jugador.getColor();
		
	}
	protected void pagar(Jugador jugador) {
		jugador.modificarDinero(this.precioPropiedad*0.85);
	}
	
	public String getNombre() {
		return nombre;
	}
}
