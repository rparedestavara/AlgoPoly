package Clases;

public class AlgoPoly {
	private Turno turno;
	private static final Tablero tablero = Tablero.getInstancia(); 
	private static AlgoPoly INSTANCIA;
	
	private AlgoPoly() {}
	
	public void mandarALaCarcel(Jugador jugador) {
		tablero.moverALaCarcel(jugador);
	}
	
	public void agregarTurno(Turno turnoIn) {
		turno = turnoIn;
	}
	
	public Turno getTurno() {
		return turno;
	}
	
	public boolean perdioJugador(Jugador jugador) {
		return ((jugador.getDinero() < 0) && (jugador.getCantidadDePropiedades()==0));
		
	}

	public static AlgoPoly getInstancia() {
		if(INSTANCIA == null)
			INSTANCIA = new AlgoPoly();
		return INSTANCIA;
	}
}
