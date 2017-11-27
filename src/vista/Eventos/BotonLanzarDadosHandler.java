package vista.Eventos;

import Clases.Dados;
import Clases.Tablero;
import Clases.Turno;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class BotonLanzarDadosHandler implements EventHandler<ActionEvent> {
	VBox vBox;

	public BotonLanzarDadosHandler(VBox vBoxIn) {
		vBox = vBoxIn;
	}
	
	@Override
	public void handle(ActionEvent event) { //tendria que ver lo de la carcel
		Tablero tablero = Tablero.getInstancia();
		Dados dados = Dados.getInstance();
		Turno turno = tablero.getTurno();
		dados.lanzar();
		tablero.jugada(turno.aQuienLeToca() , dados.getResultado());
		turno.proximoTurno();
		
		
		Button botonFinVenta = new Button();
		botonFinVenta.setText("terminar de vender");
		vBox.getChildren().clear();
		vBox.getChildren().add(botonFinVenta);
		BotonInicioTurnoHandler botonFinVentaHandler = new BotonInicioTurnoHandler(vBox);
		botonFinVenta.setOnAction(botonFinVentaHandler);
	}
}
