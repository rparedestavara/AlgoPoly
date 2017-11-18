package Clases;

import Clases.Casilla;

public class Provincia extends Casilla {
	protected int precioDeTerreno;
	protected int precioAlquiler;
	protected int precioDeConstruccionDeCasas;
	protected int precioDeConstruccionDeHotel;
	protected Jugador propietario;
	protected int cantCasas;
	protected Jugador residente;
	protected int costoDeEntradaPorUnaCasa;
	protected int costoDeEntradaPorDosYUnaCasa;
	protected Provincia provinciaOpuesta;
	protected int cantHoteles;
	protected int costoPorHotel;
	
	public Provincia() {
		this.propietario = null;
		this.costoDeEntradaPorUnaCasa=3000;
		this.costoDeEntradaPorDosYUnaCasa=3500;
		this.cantHoteles=0;
		this.cantCasas=0;
	}

	public boolean poseeUnaCasaEnAmbasProvincias() {
		return this.cantCasas==1 && this.provinciaOpuesta.cantCasas==1;
	}

	public boolean EsPropietario(Jugador jugadorDesconocido) {
		return (jugadorDesconocido==this.propietario);
	}

	public boolean propietarioPoseeCasasEnAmbasProvincias() {
		return (this.cantCasas>0 && this.provinciaOpuesta.EsPropietario(this.propietario) &&this.provinciaOpuesta.cantCasasConstruidas()>0);
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
	
}
