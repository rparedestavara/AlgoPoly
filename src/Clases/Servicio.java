package Clases;

public abstract class Servicio extends Propiedad{
	protected Servicio servicioOpuesto;
	protected int multiplicadorConUnaSola;
	protected int multiplicadorConAmbas;
	
	public Servicio(){
		servicioOpuesto = null;
	}
	
	public static void AgregarOpuestos(Servicio servicio1, Servicio servicio2) {
		servicio1.agregarOpuesto(servicio2);
		servicio2.agregarOpuesto(servicio1);
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
		propietario.modificarDinero(precioCobrar);
		guardarMensaje(residente, propietario, precioCobrar);
	}
}
