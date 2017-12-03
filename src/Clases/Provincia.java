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
	
	public boolean sePuedeConstruirUnaCasa() {
		return this.cantCasasConstruidas()<1;
	}
	
	public void construirHotel() {}
	
	public void construirCasa() {
		if(sePuedeConstruirUnaCasa()) {
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
	
	@Override
	public void vender() {
		super.vender();
		this.destruirConstrucciones();
	}

	public void provinciaVendida(Jugador jugador) {
		if(this.esPropietario(jugador)) this.vender();
	}

	protected void pagar(Jugador jugador) {
		jugador.modificarDinero(this.precioPropiedad*0.85);
		this.destruirConstrucciones();
	}

	private void destruirConstrucciones() {
		this.cantCasas = 0;
	}
	
	

	
}
