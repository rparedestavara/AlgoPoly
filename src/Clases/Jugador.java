package Clases;

public class Jugador {

	private int dineroActual;
	private int cantidadDeVecesQueGanoQuini6;
	private int resultadoDados;
	private Tablero tablero;
	private Carcel carcel;
	private int barriosComprados;
	
	public Jugador() {
		this.dineroActual=100000;
		this.barriosComprados = 0;
		this.cantidadDeVecesQueGanoQuini6 = 0;
		this.tablero = null;
		this.carcel = null;
	}
	
	public int getDinero() {
		return this.dineroActual;
	}
	
	public void modificarDinero(int monto) {
		if (cantidadDeVecesQueGanoQuini6 < 2) {
			this.dineroActual += (monto-(20000*cantidadDeVecesQueGanoQuini6));
		}
	}
			
	public int getCantidadVecesQueGanoQuini6() {
		return this.cantidadDeVecesQueGanoQuini6;
	}
	public void ganoQuini6() {
		this.cantidadDeVecesQueGanoQuini6++;
	}
	
	public void informarQueEstaEn(Carcel carcel) {
		this.carcel=carcel;
	}
	
	public boolean puedeHacerAcciones() {
		return (carcel.estaEnCarcel(this));

	}
	public int getResultadoDados() {
		return resultadoDados;
	}
	public Tablero getTablero() {
		return tablero;
	}
	
	public void setResultadoDados(int resultadoDadosIn) {
		resultadoDados = resultadoDadosIn;
	}
	
	public void setTablero(Tablero tableroIn) {
		tablero = tableroIn;
	}

	
	public void agregarPropiedad() {
		this.barriosComprados++;
	}
	
	public void aumentarTurnosEnCarcel() {
		this.carcel.aumentarTurno(this);
	}

	public boolean puedePagarFianzaDeCarcel() {
		return ((this.dineroActual>45000)&&(this.carcel.turnosEnCarcel(this)>1));
	}

	public void pagarFianzaDeCarcel() {
		if(this.puedePagarFianzaDeCarcel()) {
		this.dineroActual-=45000;
		this.carcel.liberar(this);
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
	
}