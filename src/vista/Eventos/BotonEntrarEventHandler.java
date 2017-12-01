package vista.Eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BotonEntrarEventHandler implements EventHandler<ActionEvent> {
	 	Stage stage;
	    Scene proximaEscena;
		private TextField nomJugador1;
		private TextField nomJugador2;
		private TextField nomJugador3;

	    
	public BotonEntrarEventHandler(Stage stage2, Scene proximaEscena2, TextField nombre1, TextField nombre2,TextField nombre3) {
		this.stage = stage2;
        this.proximaEscena = proximaEscena2;
        this.nomJugador1=nombre1;
        this.nomJugador2=nombre2;
        this.nomJugador3=nombre3;
		}
	@Override
	public void handle(ActionEvent arg0) {
		if (!this.esValido(nomJugador1) || !this.esValido(nomJugador2) || !this.esValido(nomJugador3)) {
			Alert alerta=new Alert(AlertType.INFORMATION);
			alerta.setTitle("Error: Llenado incorrecto de Datos");
			alerta.setHeaderText("Los Nombres tienen que contener al menos un caracter.");
			alerta.show();
			TextField error=new TextField();
			error.setText("error completar datos");
			return;
		}
		System.out.println(nomJugador3.getText());
	    stage.setScene(proximaEscena);
		stage.setFullScreenExitHint("Bienvenidos Al juego");
		stage.setFullScreen(true);    

	}
	
	public boolean esValido(TextField nombre) {
	
		return (nombre.getText().length()>0);
	}



}
