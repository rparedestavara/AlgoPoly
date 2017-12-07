package vista;

import Clases.Tablero;
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
		
		
		Tablero tablero = Tablero.getInstancia();
		ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal();
		ContenedorBienvenidos contenedorBienvenidos = new ContenedorBienvenidos(stage, contenedorPrincipal,tablero);
		Scene escenaBienvenidos = new Scene(contenedorBienvenidos, 500, 500);
		 
		stage.setScene(escenaBienvenidos);
	    stage.setFullScreen(true);
        stage.show();
	
	}

}
