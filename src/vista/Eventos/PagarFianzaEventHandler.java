package vista.Eventos;

import Clases.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class PagarFianzaEventHandler implements EventHandler<ActionEvent> {
	private Jugador jugador;
	Button pagar;
	private Button lanzarDados;
	private VBox mensajes;
	

	public PagarFianzaEventHandler(Jugador jugador, Button pagarFianza, Button boton, VBox mensajes) {
		this.jugador = jugador;
		this.pagar = pagarFianza;
		this.lanzarDados = boton;
		this.mensajes = mensajes;
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
			this.mensajes.getChildren().clear();
			Text dineroJugador = new Text("Dinero: " + Double.toString(jugador.getDinero()));
			dineroJugador.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
			Text nombreJugador = new Text();
			nombreJugador.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
			nombreJugador.setFill(jugador.getColor());
			nombreJugador.setText("Turno del jugador: " + jugador.getNombre());		
			mensajes.getChildren().addAll(nombreJugador, dineroJugador);
								
		}
		}
		
}

