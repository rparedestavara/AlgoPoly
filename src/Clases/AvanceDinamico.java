package Clases;

public class AvanceDinamico extends MovimientoDinamico {
	private static final int AVANZA = 1;
	
	public AvanceDinamico() {
		nombre = "Avance";
	}
	
	public void avanceMenosCantidadDeEspaciosAReducir(Jugador jugador) {
		super.movimientoMenosCantidadDeEspaciosAReducir(jugador, AVANZA);
	}
	
	public void avanceCantidadDeDineroModuloDados(Jugador jugador) {
		super.movimientoCantidadDeDineroModuloDados(jugador, AVANZA);
	}
	
	public void avanceMenosCantidadDePropiedades(Jugador jugador) {
		super.movimientoMenosCantidadDePropiedades(jugador, AVANZA);
	}

	@Override
	public void primerDespliegue(int resultadoObtenido, Jugador jugador) {
		if(resultadoObtenido <= PRIMER_RANGO_ENTRAR_HASTA) 
			this.avanceMenosCantidadDeEspaciosAReducir(jugador);
	}

	@Override
	public void segundoDespliegue(int resultadoObtenido, Jugador jugador) {
		 if(resultadoObtenido <= SEGUNDO_RANGO_ENTRAR_HASTA && resultadoObtenido > PRIMER_RANGO_ENTRAR_HASTA)
			this.avanceCantidadDeDineroModuloDados(jugador);
		 }

	@Override
	public void tercerDespliegue(int resultadoObtenido, Jugador jugador) {
		 if (resultadoObtenido <= TERCER_RANGO_ENTRAR_HASTA && resultadoObtenido >SEGUNDO_RANGO_ENTRAR_HASTA) 
			this.avanceMenosCantidadDePropiedades(jugador);			
			
	}

}
