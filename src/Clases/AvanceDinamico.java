package Clases;

public class AvanceDinamico implements MovimientoDinamico {
	
	public void movimientoMenosCantidadDeEspaciosAReducir(Jugador jugador) {
		int movimiento = (jugador.getResultadoDados() - CANTIDAD_DE_ESPACIOS_REDUCIR);
		Tablero tablero = Tablero.getInstancia(); 
		tablero.mover(jugador, movimiento);
	}
	
	public void movimientoCantidadDeDineroModuloDados(Jugador jugador) {
		 int movimiento = (jugador.getDinero() % jugador.getResultadoDados());
		 Tablero tablero = Tablero.getInstancia(); 
			tablero.mover(jugador, movimiento);
	}
	
	public void movimientoMenosCantidadDePropiedades(Jugador jugador) {
		int movimiento = (jugador.getResultadoDados()-jugador.getCantidadDePropiedades());
		Tablero tablero = Tablero.getInstancia(); 
		tablero.mover(jugador, movimiento);
	}
	
	public void entrar(Jugador jugador) {
		int resultadoDados = jugador.getResultadoDados();
		
		if(resultadoDados <= PRIMER_RANGO_ENTRAR_HASTA) {
			this.movimientoMenosCantidadDeEspaciosAReducir(jugador);
			
		}
		else if(resultadoDados <= SEGUNDO_RANGO_ENTRAR_HASTA){
			this.movimientoCantidadDeDineroModuloDados(jugador);
			
		}
		else if (resultadoDados <= TERCER_RANGO_ENTRAR_HASTA) {
			this.movimientoMenosCantidadDePropiedades(jugador);			
		}
	}

}
