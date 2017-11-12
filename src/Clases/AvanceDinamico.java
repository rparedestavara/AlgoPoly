package Clases;

public class AvanceDinamico {
	private static final int PRIMER_RANGO_ENTRAR_HASTA = 6;
	private static final int CANTIDAD_DE_ESPACIOS_REDUCIR = 2;
	private static final int SEGUNDO_RANGO_ENTRAR_HASTA = 10;
	private static final int TERCER_RANGO_ENTRAR_HASTA = 12;

	public void entrar(Jugador jugador) {
		int resultadoDados = jugador.getResultadoDados();
		Tablero tablero = jugador.getTablero();
		if(resultadoDados <= PRIMER_RANGO_ENTRAR_HASTA) {
			int cantidadMover = resultadoDados - CANTIDAD_DE_ESPACIOS_REDUCIR;
			tablero.mover(jugador, cantidadMover);
		}
		else if(resultadoDados <= SEGUNDO_RANGO_ENTRAR_HASTA){
			int cantidadMover = jugador.getDinero() % resultadoDados;
			tablero.mover(jugador, cantidadMover);
		}
	}

}
