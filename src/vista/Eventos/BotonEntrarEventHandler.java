package vista.Eventos;

import java.util.ArrayList;

import Clases.AlgoPoly;
import Clases.Jugador;
import Clases.Tablero;
import Clases.Turno;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import vista.ContenedorPrincipal;

public class BotonEntrarEventHandler implements EventHandler<ActionEvent> {
	 	Stage stage;
		private TextField nomJugador1;
		private TextField nomJugador2;
		private TextField nomJugador3;
		Tablero tablero ;
	    
	public BotonEntrarEventHandler(Stage stage2, TextField nombre1, TextField nombre2,TextField nombre3, Tablero tablero) {
		this.stage = stage2;
        this.nomJugador1 = nombre1;
        this.nomJugador2 = nombre2;
        this.nomJugador3 = nombre3;
        this.tablero = Tablero.getInstancia();

	}
	
	private void inicializarJugadoresYTurno() {
		Jugador jugador1 = new Jugador();
		jugador1.setNombre(this.nomJugador1.getText());
		Jugador jugador2 = new Jugador();
		jugador2.setNombre(this.nomJugador2.getText());
		Jugador jugador3 = new Jugador();
		jugador3.setNombre(this.nomJugador3.getText());
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador1);
		jugadores.add(jugador2);
		jugadores.add(jugador3);
		tablero.agregarJugadores(jugadores);
		Turno turno = new Turno(jugadores);
		AlgoPoly.getInstancia().agregarTurno(turno);
		AlgoPoly.getInstancia().agregarJugadores(jugadores);
	}
	
	@Override
	public void handle(ActionEvent arg0) {
		if (!this.esValido(nomJugador1) || !this.esValido(nomJugador2) || !this.esValido(nomJugador3)) {
			Alert alerta=new Alert(AlertType.INFORMATION);
			alerta.setTitle("Error: Llenado incorrecto de Datos");
			alerta.setHeaderText("Los Nombres tienen que contener al menos un caracter.");
			alerta.show();
			return;
		}
		inicializarJugadoresYTurno();
		ContenedorPrincipal proximaEscena = new ContenedorPrincipal(this.stage);
		Scene escenaPrincipal = new Scene(proximaEscena, 400, 500);
	    stage.setScene(escenaPrincipal);
		stage.setFullScreenExitHint("Bienvenidos Al juego");
		stage.setFullScreen(true);    
	}
	
	public boolean esValido(TextField nombre) {
	
		return (nombre.getText().length()>0);
	}



}
