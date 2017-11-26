package Clases;

import java.util.ArrayList;

import excepciones.NoEsDuenioDePropiedadException;
import excepciones.SaldoInsuficienteException;

public class Jugador {

	private double dineroActual;
	private int barriosComprados;
	private ArrayList<Propiedad> propiedades;
	
	public Jugador() {
		this.dineroActual=100000;
		this.barriosComprados = 0;
		this.propiedades = new ArrayList<Propiedad>();
	}
	
	public double getDinero() {
		return this.dineroActual;
	}
	
	public void modificarDinero(double d) {
		dineroActual += d;
	}
	
	public boolean puedeHacerAcciones() {
		Carcel carcel = Carcel.getInstancia();
		return (!carcel.enCarcel(this));

	}
	
	public void agregarPropiedad() {
		this.barriosComprados++;
	}
	
	public void aumentarTurnosEnCarcel() {
		Carcel carcel = Carcel.getInstancia();
		carcel.aumentarTurno(this);
	}

	public boolean puedePagarFianzaDeCarcel() {
		Carcel carcel = Carcel.getInstancia();
		return ((carcel.turnosEnCarcel(this)>=1));
	}

	public void pagarFianzaDeCarcel() throws SaldoInsuficienteException {
		Carcel carcel = Carcel.getInstancia();
		if(this.puedePagarFianzaDeCarcel()) {
			this.pagar(45000);
			carcel.liberar(this);
		}
	}

	public void pagar(int monto) throws SaldoInsuficienteException {
		if (monto > dineroActual) throw new SaldoInsuficienteException();
		this.dineroActual-=monto;
		
	}

	public int getCantidadDePropiedades() {
		int propiedades = 0;
		propiedades += this.barriosComprados;
		return propiedades;
	}
	
	public void agregarPropiedad(Propiedad propiedad) {
		this.propiedades.add(propiedad);
	}
	public void setDinero(int dineroJugador) {
		this.dineroActual = dineroJugador;
		
	}

	public void intercambiarPropiedad(Jugador propietario, Provincia provinciaPedida, Provincia provinciaOfrecida) {
		if(!this.propiedades.contains(provinciaOfrecida)) throw new NoEsDuenioDePropiedadException();
		provinciaPedida.cambiarPropietario(this); 
		provinciaOfrecida.cambiarPropietario(propietario);
		
	}
	
}