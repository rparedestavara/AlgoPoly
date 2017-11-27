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
	
	public Jugador() {
		this.dineroActual=100000;
		this.barriosComprados = 0;
		this.propiedades = new ArrayList<Propiedad>();
		color = Color.BLACK;
	}
	
	public double getDinero() {
		return this.dineroActual;
	}
	
	public void setColor(Color colorIn) {
		color = colorIn;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void modificarDinero(double d) {
		while (d + dineroActual < 0) {
			if(propiedades.size() == 0) {
				Tablero tablero = Tablero.getInstancia();
				Turno turno = tablero.getTurno();
				turno.removerJugador(this);
				break;
			}
			Propiedad propiedad = propiedades.get(0);
			propiedad.vender(this);
		}
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
		return ((carcel.turnosEnCarcel(this)>=1) && dineroActual >= 45000);
	}

	public void pagarFianzaDeCarcel() throws SaldoInsuficienteException {
		Carcel carcel = Carcel.getInstancia();
		if(this.puedePagarFianzaDeCarcel()) {
			this.modificarDinero(-45000);
			carcel.liberar(this);
		}
	}

	public int getCantidadDePropiedades() {
		int propiedades = 0;
		propiedades += this.barriosComprados;
		return propiedades;
	}
	
	public void agregarPropiedad(Propiedad propiedad) {
		this.propiedades.add(propiedad);
	}
	
	public void quitarPropiedad(Propiedad propiedad) {
		this.propiedades.remove(propiedad);
	}
	
	public void setDinero(int dineroJugador) {
		this.dineroActual = dineroJugador;
		
	}

	public void intercambiarPropiedad(Jugador propietario, Provincia provinciaPedida, Provincia provinciaOfrecida) {
		if(!this.propiedades.contains(provinciaOfrecida)) throw new NoEsDuenioDePropiedadException();
		provinciaPedida.cambiarPropietario(this); 
		provinciaOfrecida.cambiarPropietario(propietario);
	}
	
	public ArrayList<Propiedad> getPropiedades(){
		return propiedades;
	}
	
}