package vista.Eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class OpcionAcercaDeEventHandler implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent event) {
		Alert alerta = new Alert(AlertType.INFORMATION);
		alerta.setTitle("Acerca de...");
		alerta.setHeaderText("Trabajo Practico N°2 de Algoritmos y Programacion III - FIUBA");
		alerta.setContentText("INTEGRANTES:\n"
				+ "KOMARNICKI, Ignacio \n"
				+ "PAREDES TAVARA, Roger Aldair \n"
				+ "SANJINES, Aaron");
		alerta.show();
	}
}
