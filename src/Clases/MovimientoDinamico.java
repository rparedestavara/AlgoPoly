package Clases;

public interface MovimientoDinamico{
	public static final int PRIMER_RANGO_ENTRAR_HASTA = 6;
	public static final int CANTIDAD_DE_ESPACIOS_REDUCIR = 2;
	public static final int SEGUNDO_RANGO_ENTRAR_HASTA = 10;
	public static final int TERCER_RANGO_ENTRAR_HASTA = 12;
	
	public void movimientoMenosCantidadDeEspaciosAReducir(Jugador jugador);
		 
	
	public void movimientoCantidadDeDineroModuloDados(Jugador jugador);
		 
	
	public void movimientoMenosCantidadDePropiedades(Jugador jugador);
	
	public void primerDespliegue(int resultadoObtenido,Jugador jugador ) ;
	
	public void segundoDespliegue(int resultadoObtenido,Jugador jugador) ;
	
	public void tercerDespliegue(int resultadoObtenido,Jugador jugador);
}
