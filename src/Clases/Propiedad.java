package Clases;

import excepciones.JugadorPuedeComprarException;
import javafx.scene.paint.Color;

public abstract class Propiedad extends Casilla {
	protected int precioPropiedad;
	protected Jugador propietario;
	
	public Propiedad(){
		propietario = null;
	}
	
	public void comprar(Jugador jugador) {
		this.propietario = jugador;
		this.propietario.modificarDinero(-this.precioPropiedad);
		this.propietario.agregarPropiedad(this);
		color = jugador.getColor();
	}
	
	public boolean sePuedeConstruirUnaCasa() {
		return false;
	}
	
	public boolean sePuedeConstruirUnHotel() {
		return false;
	}
	
	public boolean esPropietario(Jugador jugadorDesconocido) {
		return (jugadorDesconocido==this.propietario);
	}
	
	protected abstract void cobrar(Jugador residente);
	
	public boolean jugadorPuedeComprarCasa(double dinero) {
		return false;
	}
	
	public boolean jugadorPuedeComprarHotel(double dinero) {
		return false;
	}
	
	protected Propiedad getOpuesta() {
		return null;
	}
	
	public void entrar(Jugador jugador) {
		if(propietario == null) {
			if(jugador.puedePagarMonto(precioPropiedad)) {
				throw new JugadorPuedeComprarException();
			}
		}
		else if(propietario != jugador) {
			cobrar(jugador);
		}
	}
	
	public void vender() {
		this.propietario.quitarPropiedad(this);
		this.pagar(this.propietario);
		this.propietario = null;
		color = Color.WHITE;
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
