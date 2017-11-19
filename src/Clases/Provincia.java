package Clases;

import Clases.Casilla;

public abstract class Provincia extends Casilla {
	protected int precioAlquilerConHotel;
	protected int precioAlquilerSinEdificaciones;
	protected int precioAlquilerConUnaCasa;
	protected int precioAlquilerConDosCasas;
	protected int precioDeTerreno;
	protected int precioDeConstruccionDeCasas;
	protected int precioDeConstruccionDeHotel;
	protected Provincia provinciaOpuesta;
	protected Jugador propietario;
	protected int cantCasas;
	protected int cantHoteles;
	
	public Provincia() {
		this.propietario = null;
		this.cantHoteles=0;
		this.cantCasas=0;
	}

	public boolean EsPropietario(Jugador jugadorDesconocido) {
		return (jugadorDesconocido==this.propietario);
	}

	public Jugador getPropietario(){
		return this.propietario;
	}
	
	public void construirCasa() {
		this.cantCasas++;
		this.propietario.modificarDinero(-this.precioDeConstruccionDeCasas);
	}
	
	public int costePorConstruccionDeCasa() {
		return this.precioDeConstruccionDeCasas;
	}

	public void agregarPropietario(Jugador jugador) {
		this.entrar(jugador);
	}

	public int cantCasasConstruidas() {
		return this.cantCasas;
	}

	public boolean poseeUnHotel() {
		return this.cantHoteles==1;
	}
	
	public void agregarOpuesto(Provincia provincia) {
		this.provinciaOpuesta=provincia;
	}

	
	public void construirHotel() {
		if(this.SePuedeConstruisHoteles())
		{
			this.cantHoteles++;
			this.propietario.modificarDinero(-this.precioDeConstruccionDeHotel);
			this.cantCasas=0;
		}
	}

	public int cantHoteles() {
		return this.cantHoteles;
	}

	public boolean SePuedeConstruisHoteles() {
		return this.cantCasas==2 && this.provinciaOpuesta.cantCasas==2;
	}
	
	private int cuantoCobrar() {
		if(cantHoteles == 1) return precioAlquilerConHotel;
		if(cantCasas == 1) return precioAlquilerConUnaCasa;
		if(cantCasas == 2) return precioAlquilerConDosCasas;
		return precioAlquilerSinEdificaciones;
	}
	
	private void cobrar(Jugador residente) {
		int precioAlquiler = cuantoCobrar();
		residente.modificarDinero(-precioAlquiler);
	}
	public void entrar(Jugador jugador) {
		if(this.propietario==null) {
			this.propietario = jugador;
			this.propietario.modificarDinero(-this.precioDeTerreno);
		}
		else this.entroUnDesconocido(jugador);
	}

	public void entroUnDesconocido(Jugador jugadorDesconocido) {
		if(!EsPropietario(jugadorDesconocido) ) {
			this.cobrar(jugadorDesconocido);
		}
	}
	public boolean poseeUnaCasaEnNorteYDosEnSur() {
		return this.cantCasas==2 && this.provinciaOpuesta.cantCasas==1;
	}
	
}
