package Clases;

public abstract class Propiedad extends Casilla{
	String nombre;
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
			this.propietario.agregarPropiedad(this);
		}
		else this.entroUnDesconocido(jugador);
	}
	
	public void entroUnDesconocido(Jugador jugadorDesconocido) {
		if(!esPropietario(jugadorDesconocido) ) {
			this.cobrar(jugadorDesconocido);
		}
	}
	public void vender(Jugador jugador) {
		this.cambiarPropietario(null);
		this.pagar(jugador);
	}
	
	protected void cambiarPropietario(Jugador jugador) {
		this.propietario = jugador;
		
	}
	protected void pagar(Jugador jugador) {
		jugador.modificarDinero(this.precioPropiedad*0.85);
	}
	
	public String getNombre() {
		return nombre;
	}
}
