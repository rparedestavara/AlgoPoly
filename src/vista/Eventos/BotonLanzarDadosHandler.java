package vista.Eventos;


import Clases.AlgoPoly;
import Clases.Carcel;
import Clases.Dados;
import Clases.Jugador;
import Clases.Tablero;
import Clases.Turno;
import excepciones.NoPuedeJugarException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import vista.VistaTablero;

public class BotonLanzarDadosHandler implements EventHandler<ActionEvent> {
	VBox vBox;
	private VistaTablero vistaTablero;

	public BotonLanzarDadosHandler(VBox vBoxIn, VistaTablero vistaTableroIn) {
		vBox = vBoxIn;
		vistaTablero = vistaTableroIn;
	}
	
	@Override
	public void handle(ActionEvent event) { 
		Tablero tablero = Tablero.getInstancia();
		Dados dados = Dados.getInstance();
		Turno turno = AlgoPoly.getInstancia().getTurno();
		Text infoDados=new Text();
		Jugador jugador = turno.aQuienLeToca();
		Text nombreJugador=new Text();
		nombreJugador.setFill(jugador.getColor());
		nombreJugador.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
		nombreJugador.setText("Turno del jugador: " + jugador.getNombre());
		vBox.getChildren().add(nombreJugador);
		dados.lanzar();
		infoDados.setText("El resultado de los dados es "+ dados.getResultado());
		infoDados.autosize();
		Button pagarFianza = null;
		try {
			tablero.jugada(turno.aQuienLeToca() , dados.getResultado());
			
		}catch(NoPuedeJugarException e) {
				pagarFianza = this.crearBotonFianza(jugador);
				Carcel.getInstancia().aumentarTurno(jugador);								
		}

		turno.proximoTurno();
		Button botonFinTurno = new Button();
		botonFinTurno.setText("Finalizar Turno");
		vBox.getChildren().clear();
		if (pagarFianza != null && jugador.puedePagarFianzaDeCarcel()) vBox.getChildren().add(pagarFianza);
		vBox.getChildren().add(nombreJugador);
		vBox.getChildren().add(botonFinTurno);
		vBox.getChildren().add(infoDados);
		Text infoCasilla = new Text();
		infoCasilla.setText(" Usted Cayo En " + tablero.getCasillasTablero().get(tablero.getPosicion(jugador)).getNombre());
		infoCasilla.autosize();
		vBox.getChildren().add(infoCasilla);
		BotonInicioTurnoHandler botonFinVentaHandler = new BotonInicioTurnoHandler(vBox, vistaTablero);
		botonFinTurno.setOnAction(botonFinVentaHandler);
		Text casas = new Text();
		casas.setText("Cantidad de propiedades: " + jugador.getCantidadDePropiedades());
		casas.autosize();
		vBox.getChildren().add(casas);
		vistaTablero.actualizar();
	}

	private Button crearBotonFianza(Jugador jugador) {
		Button pagarFianza = new Button("PAGAR FIANZA!");
		PagarFianzaEventHandler pagarFianzaEventHandler = new PagarFianzaEventHandler(jugador);
		pagarFianza.setOnAction(pagarFianzaEventHandler);
		return pagarFianza;
	}
}
