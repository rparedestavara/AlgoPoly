package Clases;

public abstract class MovimientoDinamico{
	public static final int PRIMER_RANGO_ENTRAR_HASTA = 6;
	public static final int CANTIDAD_DE_ESPACIOS_REDUCIR = 2;
	public static final int SEGUNDO_RANGO_ENTRAR_HASTA = 10;
	public static final int TERCER_RANGO_ENTRAR_HASTA = 12;
	
	protected void movimientoMenosCantidadDeEspaciosAReducir(Jugador jugador, int direccion){
		int movimiento = (jugador.getResultadoDados() - CANTIDAD_DE_ESPACIOS_REDUCIR);
		Tablero tablero = Tablero.getInstancia(); 
		tablero.mover(jugador, movimiento * direccion);
	}
		 
	
	protected void movimientoCantidadDeDineroModuloDados(Jugador jugador, int direccion) {
		 int movimiento = (jugador.getDinero() % jugador.getResultadoDados());
		 Tablero tablero = Tablero.getInstancia(); 
			tablero.mover(jugador, movimiento * direccion);
	}
		 
	
	protected void movimientoMenosCantidadDePropiedades(Jugador jugador, int direccion) {
		int movimiento = (jugador.getResultadoDados()-jugador.getCantidadDePropiedades());
		Tablero tablero = Tablero.getInstancia(); 
		tablero.mover(jugador, movimiento * direccion);
	}
	
	public void entrar(Jugador jugador) {
		int resultadoDados = jugador.getResultadoDados();
		this.primerDespliegue( resultadoDados, jugador);
		this.segundoDespliegue( resultadoDados,  jugador);
		this.tercerDespliegue( resultadoDados,  jugador) ;
	}
	
	protected abstract void primerDespliegue(int resultadoObtenido,Jugador jugador ) ;
	
	protected abstract void segundoDespliegue(int resultadoObtenido,Jugador jugador) ;
	
	protected abstract void tercerDespliegue(int resultadoObtenido,Jugador jugador);
}
