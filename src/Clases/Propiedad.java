package Clases;

public abstract class Propiedad extends Casilla{
	protected int precioPropiedad;
	protected Jugador propietario;
	
	public Propiedad(){
		propietario = null;
	}
	
	public void agregarPropietario(Jugador jugador) {
		this.entrar(jugador);
	}
	
	public boolean esPropietario(Jugador jugadorDesconocido) {
		return (jugadorDesconocido==this.propietario);
	}
	
	protected abstract void cobrar(Jugador residente);
	
	public void entrar(Jugador jugador) {
		if(this.propietario==null) {
			this.propietario = jugador;
			this.propietario.modificarDinero(-this.precioPropiedad);
		}
		else this.entroUnDesconocido(jugador);
	}
	
	public void entroUnDesconocido(Jugador jugadorDesconocido) {
		if(!esPropietario(jugadorDesconocido) ) {
			this.cobrar(jugadorDesconocido);
		}
	}
}
