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
		this.primerDespliegue( resultadoDados, jugador);
		this.segundoDespliegue( resultadoDados,  jugador);
		this.tercerDespliegue( resultadoDados,  jugador) ;
	}

	@Override
	public void primerDespliegue(int resultadoObtenido, Jugador jugador) {
		if(resultadoObtenido <= PRIMER_RANGO_ENTRAR_HASTA) 
			this.movimientoMenosCantidadDeEspaciosAReducir(jugador);
	}

	@Override
	public void segundoDespliegue(int resultadoObtenido, Jugador jugador) {
		 if(resultadoObtenido <= SEGUNDO_RANGO_ENTRAR_HASTA && resultadoObtenido > PRIMER_RANGO_ENTRAR_HASTA)
				this.movimientoCantidadDeDineroModuloDados(jugador);
		 }

	@Override
	public void tercerDespliegue(int resultadoObtenido, Jugador jugador) {
		 if (resultadoObtenido <= TERCER_RANGO_ENTRAR_HASTA && resultadoObtenido >SEGUNDO_RANGO_ENTRAR_HASTA) 
				this.movimientoMenosCantidadDePropiedades(jugador);			
			
	}

}
