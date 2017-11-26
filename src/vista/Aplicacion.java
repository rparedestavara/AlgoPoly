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
		
		
		ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal();
		Scene escenaPrincipal = new Scene(contenedorPrincipal, 400, 500);
		
		stage.setScene(escenaPrincipal);
	
		stage.setFullScreen(true);
		stage.show();
		
	}

}
