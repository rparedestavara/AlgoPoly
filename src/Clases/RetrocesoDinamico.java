package Clases;

public class RetrocesoDinamico implements MovimientoDinamico {
		
	public void movimientoMenosCantidadDeEspaciosAReducir(Jugador jugador) {
		 int movimiento = (jugador.getResultadoDados() - CANTIDAD_DE_ESPACIOS_REDUCIR);
		 jugador.getTablero().mover(jugador, (-movimiento));
	}
	
	public void movimientoCantidadDeDineroModuloDados(Jugador jugador) {
		 int movimiento = (jugador.getDinero() % jugador.getResultadoDados());
		 jugador.getTablero().mover(jugador, (-movimiento));
	}
	
	public void movimientoMenosCantidadDePropiedades(Jugador jugador) {
		int movimiento = (jugador.getResultadoDados()-jugador.getCantidadDePropiedades());
		jugador.getTablero().mover(jugador, (-movimiento));
	}
	
	public void entrar(Jugador jugador) {
		int resultadoDados = jugador.getResultadoDados();
		if (resultadoDados <= PRIMER_RANGO_ENTRAR_HASTA) {
			this.movimientoMenosCantidadDePropiedades(jugador);
			
		}else if (resultadoDados <= SEGUNDO_RANGO_ENTRAR_HASTA) {
			this.movimientoCantidadDeDineroModuloDados(jugador);
			
		}else if (resultadoDados <= TERCER_RANGO_ENTRAR_HASTA) {
			this.movimientoMenosCantidadDeEspaciosAReducir(jugador);
		}
		
			
	}
}
