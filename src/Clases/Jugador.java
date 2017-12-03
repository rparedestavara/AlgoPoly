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
				Turno turno = AlgoPoly.getInstancia().getTurno();
				turno.removerJugador(this);
				break;
			}
			Propiedad propiedad = propiedades.get(0);
			propiedad.vender();
		}
		dineroActual += d;
	}
	
	public boolean puedeHacerAcciones() {
		Carcel carcel = Carcel.getInstancia();
		return (!carcel.enCarcel(this));

	}
	
	public boolean puedeEdificar() {
		for(Propiedad propiedad : propiedades) {
			if(propiedad.sePuedeConstruirUnHotel()) return true;
			if(propiedad.sePuedeConstruirUnaCasa()) return true;
		}
		return false;
	}
	
	public void agregarPropiedad() {
		this.barriosComprados++;
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
	
	public boolean perdio(double dineroAPagar) {
		return (this.propiedades.size()==0 && this.dineroActual<dineroAPagar );
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
	
}