package Clases;

public class RetrocesoDinamico extends MovimientoDinamico {
	 private static final int RETROCEDE = -1;
		
	public void retrocesoMenosCantidadDeEspaciosAReducir(Jugador jugador) {
		super.movimientoMenosCantidadDeEspaciosAReducir(jugador, RETROCEDE);
	}
		
	public void retrocesoCantidadDeDineroModuloDados(Jugador jugador) {
		super.movimientoCantidadDeDineroModuloDados(jugador, RETROCEDE);
	}
		
	public void retrocesoMenosCantidadDePropiedades(Jugador jugador) {
		super.movimientoMenosCantidadDePropiedades(jugador, RETROCEDE);
	}
	
	@Override
	public void primerDespliegue(int resultadoObtenido,Jugador jugador ) {
		if(resultadoObtenido <= PRIMER_RANGO_ENTRAR_HASTA) 
			this.retrocesoMenosCantidadDePropiedades(jugador);
	}
	
	@Override
	public void segundoDespliegue(int resultadoObtenido,Jugador jugador) {
		if(resultadoObtenido <= SEGUNDO_RANGO_ENTRAR_HASTA && resultadoObtenido > PRIMER_RANGO_ENTRAR_HASTA)
			this.retrocesoCantidadDeDineroModuloDados(jugador);
	}
	
	@Override
	public void tercerDespliegue(int resultadoObtenido,Jugador jugador) {
		if (resultadoObtenido <= TERCER_RANGO_ENTRAR_HASTA && resultadoObtenido >SEGUNDO_RANGO_ENTRAR_HASTA) 
			this.retrocesoMenosCantidadDeEspaciosAReducir(jugador);			
	}
}
