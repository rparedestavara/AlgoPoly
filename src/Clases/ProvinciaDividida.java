package Clases;

public abstract class ProvinciaDividida extends Provincia {
	protected ProvinciaDividida otraMitad;
	protected int precioAlquilerConHotel;
	protected int precioAlquilerConDosCasas;
	protected int cantHoteles;

	public boolean poseeUnHotel() {
		return this.cantHoteles==1;
	}
	
	public static void AgregarOpuestos(ProvinciaDividida provincia1,ProvinciaDividida provincia2) {
		provincia1.agregarOpuesto(provincia2);
		provincia2.agregarOpuesto(provincia1);
	}
	
	public void agregarOpuesto(ProvinciaDividida provincia) {
		this.otraMitad = provincia;
	}
	
	public boolean sePuedeConstruirUnaCasa() {
		return (this.cantCasasConstruidas() < 2 && this.otraMitad.getPropietario() == this.propietario);
	}
	

	public void construirCasa() {
		if(sePuedeConstruirUnaCasa()) {
			this.cantCasas++;
			this.propietario.modificarDinero(-this.precioDeConstruccionDeCasas);
		}
	}
	
	public void construirHotel() {
		if(this.sePuedeConstruirUnHotel())
		{
			this.cantHoteles++;
			this.propietario.modificarDinero(-this.precioDeConstruccionDeHotel);
			this.cantCasas=0;
		}
	}

	public int cantHoteles() {
		return this.cantHoteles;
	}
	
	@Override
	public void vender() {
		super.vender();
		this.destruirConstrucciones();
	}

	public boolean sePuedeConstruirUnHotel() {
		return (this.cantCasas==2 && (this.otraMitad.cantCasas==2 || this.otraMitad.cantHoteles == 1) && this.otraMitad.getPropietario() == this.propietario);
	}
	
	public boolean jugadorPuedeComprarHotel(double dinero) {
		return dinero >= precioDeConstruccionDeHotel && sePuedeConstruirUnHotel();
	}
	
	@Override
	protected int cuantoCobrar() {
		if(cantHoteles == 1) return precioAlquilerConHotel;
		if(cantCasas == 2) return precioAlquilerConDosCasas;
		return super.cuantoCobrar();
		
	}

	private void destruirConstrucciones() {
		this.cantHoteles=0;
	}
	
	public ProvinciaDividida getOpuesta() {
		return otraMitad;
	}
}

