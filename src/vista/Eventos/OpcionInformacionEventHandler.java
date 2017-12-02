package vista.Eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class OpcionInformacionEventHandler implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);

		alert.setTitle("Informacion del juego AlgoPoly");
		alert.setHeaderText("Tipo de informacion a mostrar");
		alert.setContentText("aca va la informacion del juego");
		alert.show();
	}
}
