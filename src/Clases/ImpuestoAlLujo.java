package Clases;

public class ImpuestoAlLujo extends Casilla {
	private double valorImpuesto;

	public ImpuestoAlLujo() {
		this.valorImpuesto = 0.1;
	}
	
	@Override
	public void entrar(Jugador jugador) {
		double dinero = jugador.getDinero();
		jugador.modificarDinero((int) (-dinero*valorImpuesto));
	}
}
