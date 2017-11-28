package vista.Eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonEntrarEventHandler implements EventHandler<ActionEvent> {
	 Stage stage;
	    Scene proximaEscena;

	    public BotonEntrarEventHandler(Stage stage, Scene proximaEscena) {
	        this.stage = stage;
	        this.proximaEscena = proximaEscena;
	    }
	@Override
	public void handle(ActionEvent arg0) {
		stage.setScene(proximaEscena);
        stage.setFullScreenExitHint("Bienvenidos Al juego");
        stage.setFullScreen(true);
	}

}
