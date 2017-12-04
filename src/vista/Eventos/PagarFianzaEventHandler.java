package vista.Eventos;

import Clases.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Region;

public class PagarFianzaEventHandler implements EventHandler<ActionEvent> {
	private Jugador jugador;

	public PagarFianzaEventHandler(Jugador jugador) {
		this.jugador = jugador;
	}

	@Override
	public void handle(ActionEvent event) {
		if(jugador.puedePagarFianzaDeCarcel()) {
			this.jugador.pagarFianzaDeCarcel();
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Fianza pagada exitosamente!");
			alert.setContentText("Usted ha pagado la fianza con exito, se le desconto 45000");
			alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);			
			alert.show();
		}else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("¡Usted no esta en condiciones de pagar la fianza!");
			alert.setContentText("Usted no puede pagar la fianza porque no paso mas de un turno o porque no tiene la plata suficiente");
			alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
			alert.show();
		}
		
	}
}
