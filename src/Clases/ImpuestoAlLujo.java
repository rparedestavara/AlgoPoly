package Clases;

public class ImpuestoAlLujo extends Casilla {
	private double valorImpuesto;

	public ImpuestoAlLujo() {
		this.valorImpuesto = 0.1;
		nombre = "Imp. Lujo";
	}
	
	public void agregarMensajes(double dinero, Jugador jugador) {
		AlgoPoly algoPoly = AlgoPoly.getInstancia();
		algoPoly.agregarMensaje("Se le cobro un impuesto de $ " + dinero);
		algoPoly.agregarMensaje("Su efectivo pasa a ser $ " + jugador.getDinero());
	}
	
	@Override
	public void entrar(Jugador jugador) {
		double dinero = jugador.getDinero();
		jugador.modificarDinero(-dinero*valorImpuesto);
		agregarMensajes(dinero*valorImpuesto, jugador);
	}
}
