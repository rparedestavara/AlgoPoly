package Clases;

public abstract class Servicio extends Propiedad{
	protected Servicio servicioOpuesto;
	protected int multiplicadorConUnaSola;
	protected int multiplicadorConAmbas;
	
	public Servicio(){
		servicioOpuesto = null;
	}
	
	public void agregarOpuesto(Servicio servicio) {
		this.servicioOpuesto = servicio;
	}
	
	private int cuantoMultiplicar() {
		if(servicioOpuesto.esPropietario(propietario)) return multiplicadorConAmbas;
		return multiplicadorConUnaSola;
	}
	
	protected void cobrar(Jugador residente) {
		int multiplicador = cuantoMultiplicar();
		Dados dados = Dados.getInstance();
		int precioCobrar = multiplicador * dados.getResultado();
		residente.modificarDinero(-precioCobrar);
	}
}
