package Clases;

import java.util.ArrayList;

import excepciones.NoEsDuenioDePropiedadException;
import excepciones.SaldoInsuficienteException;
import javafx.scene.paint.Color;

public class Jugador {

	private double dineroActual;
	private int barriosComprados;
	private ArrayList<Propiedad> propiedades;
	private Color color;
	private String nombre;
	private Estado estado;
	private static final double COSTO_FIANZA = 45000;
	
	public Jugador() {
		this.dineroActual = 100000;
		this.barriosComprados = 0;
		this.propiedades = new ArrayList<Propiedad>();
		color = Color.BLACK;
		this.estado = Estado.EN_JUEGO;
	}
	
	public double getDinero() {
		return this.dineroActual;
	}
	
	public boolean puedePagarMonto(double precio) {
		return precio <= dineroActual;
	}
	
	public void setColor(Color colorIn) {
		color = colorIn;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void modificarDinero(double dinero) {
		while (dinero + dineroActual < 0) {
			if(propiedades.size() == 0) {
				AlgoPoly.getInstancia().removerJugador(this);
				break;
			}
			Propiedad propiedad = propiedades.get(0);
			propiedad.vender();
		}
		dineroActual += dinero;
	}
	
	
	
	public boolean puedeEdificar() {
		for(Propiedad propiedad : propiedades) {
			if(propiedad.jugadorPuedeComprarCasa(dineroActual)) {
				return true;
			}
			if(propiedad.jugadorPuedeComprarHotel(dineroActual)) {
				return true;
			}
		}
		return false;
	}

	public void agregarPropiedad() {
		this.barriosComprados++;
	}
	
	

	public boolean puedePagarFianzaDeCarcel() {
		Carcel carcel = Carcel.getInstancia();
		return ((carcel.turnosEnCarcel(this) >= 1) && (dineroActual >= COSTO_FIANZA));
	}

	public void pagarFianzaDeCarcel() throws SaldoInsuficienteException {
		Carcel carcel = Carcel.getInstancia();
		if(this.puedePagarFianzaDeCarcel()) {
			this.modificarDinero(-45000);
			carcel.liberar(this);
		}
	}

	public int getCantidadDePropiedades() {
		return this.barriosComprados;
	}
	
	public void agregarPropiedad(Propiedad propiedad) {
		this.propiedades.add(propiedad);
		barriosComprados++;
	}
	
	public void quitarPropiedad(Propiedad propiedad) {
		this.propiedades.remove(propiedad);
		barriosComprados++;
	}
	

	public void intercambiarPropiedad(Jugador propietario, Provincia provinciaPedida, Provincia provinciaOfrecida) {
		if(!this.propiedades.contains(provinciaOfrecida)) throw new NoEsDuenioDePropiedadException();
		provinciaPedida.cambiarPropietario(this); 
		provinciaOfrecida.cambiarPropietario(propietario);
	}
	
	public ArrayList<Propiedad> getPropiedades(){
		return propiedades;
	}
	
	public void perdio() {
		this.estado = Estado.PERDEDOR;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public double getCostoFianza() {
		return COSTO_FIANZA;
	}

	public Estado getEstado() {
		return this.estado;
	}
	
	
}