package Clases;

public abstract class Provincia extends Propiedad {
	
	protected int precioAlquilerSinEdificaciones;
	protected int precioAlquilerConUnaCasa;
	protected int precioDeConstruccionDeCasas;
	protected int precioDeConstruccionDeHotel;
	protected int cantCasas;
	
	
	public Provincia() {
		
		this.cantCasas=0;
	}

	public Jugador getPropietario(){
		return this.propietario;
	}
	
	public void construirCasa() {
		if(this.cantCasasConstruidas()<1) {
		this.cantCasas++;
		this.propietario.modificarDinero(-this.precioDeConstruccionDeCasas);}
	}
	
	public int costePorConstruccionDeCasa() {
		return this.precioDeConstruccionDeCasas;
	}

	public int cantCasasConstruidas() {
		return this.cantCasas;
	}

		
	protected int cuantoCobrar() {
		if(cantCasas == 1) return precioAlquilerConUnaCasa;
		return precioAlquilerSinEdificaciones;
		
	}
	
	protected void cobrar(Jugador residente) {
		int precioAlquiler = cuantoCobrar();
		residente.modificarDinero(-precioAlquiler);
		this.propietario.modificarDinero(precioAlquiler);
	}

	public void provinciaVendida(Jugador jugador) {
		if(this.esPropietario(jugador)) this.vender(jugador);
	}

	public void vender(Jugador jugador) {
		this.cambiarPropietario(null);
		this.pagar(jugador);
	}

	protected void pagar(Jugador jugador) {
		jugador.modificarDinero(this.precioPropiedad*0.85);
		this.destruirConstrucciones();
	}

	protected void destruirConstrucciones() {
		this.cantCasas=0;
	}
	
	

	
}
