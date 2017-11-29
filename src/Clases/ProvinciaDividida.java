package Clases;

public abstract class ProvinciaDividida extends Provincia {
	protected Provincia otraMitad;
	protected int precioAlquilerConHotel;
	protected int precioAlquilerConDosCasas;
	protected int cantHoteles;

	public boolean poseeUnHotel() {
		return this.cantHoteles==1;
	}
	
	public void agregarOpuesto(Provincia provincia) {
		this.otraMitad = provincia;
	}
	
	public void construirCasa() {
		this.cantCasas++;
		this.propietario.modificarDinero(-this.precioDeConstruccionDeCasas);
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
	
	@Override
	public void vender() {
		super.vender();
		this.destruirConstrucciones();
	}

	public boolean SePuedeConstruisHoteles() {
		return (this.cantCasas==2 && this.otraMitad.cantCasas==2);
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
	


}

