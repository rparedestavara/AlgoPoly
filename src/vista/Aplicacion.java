package vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Aplicacion extends Application {

	  public static void main(String[] args) {
	        launch(args);
	    }
	
	@Override
	public void start(final Stage stage) throws Exception {

		stage.setTitle("AlgoPoly");
		
		ContenedorDeBotonesJuego contenedorBotonesJuego = new ContenedorDeBotonesJuego();
		Scene escena = new Scene(contenedorBotonesJuego, 400, 500);
		
		stage.setScene(escena);
		stage.setFullScreen(true);
		stage.show();
		
	}

}
