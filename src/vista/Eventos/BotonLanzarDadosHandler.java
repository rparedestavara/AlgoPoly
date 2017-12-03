package vista.Eventos;

import Clases.AlgoPoly;
import Clases.Dados;
import Clases.Jugador;
import Clases.Tablero;
import Clases.Turno;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
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
	public void handle(ActionEvent event) { //tendria que ver lo de la carcel
		Dados dados = Dados.getInstance();
		dados.lanzar();
		if (dados.salioDobles()) {
			Alert alerta=new Alert(AlertType.INFORMATION);
			alerta.setTitle(" Salieron Dados dobles ");
			alerta.setHeaderText("Tiene Que Volver A lanzar:Salio doble "+" "+(dados.getResultado()/2));
			alerta.show();
			return;
		}
		else {
		Tablero tablero = Tablero.getInstancia();
		Turno turno = AlgoPoly.getInstancia().getTurno();
		TextField infoDados=new TextField();
		infoDados.setEditable(false);
		Jugador jugador = turno.aQuienLeToca();
		Text nombreJugador=new Text();
		nombreJugador.setText("Turno del jugador: " + jugador.getNombre());
		vBox.getChildren().add(nombreJugador);
		infoDados.setText("Los dados salieron" +" "+ dados.getResultado());
		tablero.jugada(turno.aQuienLeToca() , dados.getResultado());
		turno.proximoTurno();
		Button botonFinTurno = new Button();
		botonFinTurno.setText("Finalizar Turno");
		vBox.getChildren().clear();
		vBox.getChildren().add(nombreJugador);
		vBox.getChildren().add(botonFinTurno);
		vBox.getChildren().add(infoDados);
		TextField infoCasilla=new TextField();
		infoCasilla.setText(" Usted Cayo En " + tablero.getCasillasTablero().get(tablero.getPosicion(jugador)).getNombre());
		infoCasilla.setEditable(false);
		vBox.getChildren().add(infoCasilla);
		BotonInicioTurnoHandler botonFinVentaHandler = new BotonInicioTurnoHandler(vBox, vistaTablero);
		botonFinTurno.setOnAction(botonFinVentaHandler);
		vistaTablero.actualizar();
		}
	}
}
