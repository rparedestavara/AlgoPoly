package Clases;

public class Jugador {

	private int dineroActual;
	private int resultadoDados;
	private int barriosComprados;
	
	public Jugador() {
		this.dineroActual=100000;
		this.barriosComprados = 0;
	}
	
	public int getDinero() {
		return this.dineroActual;
	}
	
	public void modificarDinero(int dinero) {
		dineroActual += dinero;
	}
	
	public boolean puedeHacerAcciones() {
		Carcel carcel = Carcel.getInstancia();
		return (carcel.estaEnCarcel(this));

	}
	public int getResultadoDados() {
		return resultadoDados;
	}
	
	public void setResultadoDados(int resultadoDadosIn) {
		resultadoDados = resultadoDadosIn;
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
		return ((this.dineroActual>45000)&&(carcel.turnosEnCarcel(this)>1));
	}

	public void pagarFianzaDeCarcel() {
		Carcel carcel = Carcel.getInstancia();
		if(this.puedePagarFianzaDeCarcel()) {
			this.pagar(45000);
			carcel.liberar(this);
		}
	}

	public void pagar(int monto) {
		this.dineroActual-=monto;
	}

	public int getCantidadDePropiedades() {
		int propiedades = 0;
		propiedades += this.barriosComprados;
		return propiedades;
	}

	public void setDinero(int dineroJugador) {
		this.dineroActual = dineroJugador;
		
	}
	
}