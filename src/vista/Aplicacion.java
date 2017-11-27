package vista;

import java.util.ArrayList;

import Clases.Jugador;
import Clases.Tablero;
import Clases.Turno;
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
		
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Jugador jugador3 = new Jugador();
		Tablero tablero = Tablero.getInstancia();
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador1);
		jugadores.add(jugador2);
		jugadores.add(jugador3);
		tablero.agregarJugadores(jugadores);
		Turno turno = new Turno(jugadores);
		tablero.agregarTurno(turno);
		
		
		ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal();
		Scene escenaPrincipal = new Scene(contenedorPrincipal, 400, 500);
		
		stage.setScene(escenaPrincipal);
	
		stage.setFullScreen(true);
		stage.show();
		
	}

}
