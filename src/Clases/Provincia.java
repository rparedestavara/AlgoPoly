package Clases;

public abstract class Provincia extends Propiedad {
	protected Provincia provinciaOpuesta;
	protected int precioAlquilerConHotel;
	protected int precioAlquilerSinEdificaciones;
	protected int precioAlquilerConUnaCasa;
	protected int precioAlquilerConDosCasas;
	protected int precioDeConstruccionDeCasas;
	protected int precioDeConstruccionDeHotel;
	protected int cantCasas;
	protected int cantHoteles;
	
	public Provincia() {
		this.cantHoteles=0;
		this.cantCasas=0;
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
	
	protected void cobrar(Jugador residente) {
		int precioAlquiler = cuantoCobrar();
		residente.modificarDinero(-precioAlquiler);
	}
	
	public boolean poseeUnaCasaEnNorteYDosEnSur() {
		return this.cantCasas==2 && this.provinciaOpuesta.cantCasas==1;
	}
	
}
