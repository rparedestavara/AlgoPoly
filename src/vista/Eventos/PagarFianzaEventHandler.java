package vista.Eventos;

import Clases.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.Region;

public class PagarFianzaEventHandler implements EventHandler<ActionEvent> {
	private Jugador jugador;
	Button pagar;
	private Button lanzarDados;
	

	public PagarFianzaEventHandler(Jugador jugador, Button pagarFianza, Button boton) {
		this.jugador = jugador;
		this.pagar = pagarFianza;
		this.lanzarDados = boton;
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
			pagar.setDisable(true);
			lanzarDados.setDisable(false);
	
		}
		
	}
}
