package vista.Eventos;

import Clases.Dados;
import Clases.Jugador;
import Clases.Tablero;
import Clases.Turno;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
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
		Tablero tablero = Tablero.getInstancia();
		Dados dados = Dados.getInstance();
		Turno turno = tablero.getTurno();
		Jugador jugador = turno.aQuienLeToca();
		Text nombreJugador=new Text();
		nombreJugador.setText("Turno del jugador: " + jugador.getNombre());
		vBox.getChildren().add(nombreJugador);
		dados.lanzar();
		tablero.jugada(turno.aQuienLeToca() , dados.getResultado());
		turno.proximoTurno();

		Button botonFinTurno = new Button();
		botonFinTurno.setText("Finalizar Turno");
		vBox.getChildren().clear();
		vBox.getChildren().add(nombreJugador);
		vBox.getChildren().add(botonFinTurno);
		BotonInicioTurnoHandler botonFinVentaHandler = new BotonInicioTurnoHandler(vBox, vistaTablero);
		botonFinTurno.setOnAction(botonFinVentaHandler);
		vistaTablero.actualizar();
	}
}
