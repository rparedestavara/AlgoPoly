package vista.Eventos;

import Clases.Jugador;
import Clases.Propiedad;
import Clases.Tablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import vista.VistaTablero;

public class BotonComprarPropiedadHandler implements EventHandler<ActionEvent>{
	VBox vBox;
	Jugador jugador;
	Button boton;
	VistaTablero vistaTablero;
	
	public BotonComprarPropiedadHandler(VBox vBoxIn, Jugador jugadorIn, Button botonIn, VistaTablero vistaTableroIn) {
		vBox = vBoxIn;
		jugador = jugadorIn;
		vistaTablero = vistaTableroIn;
		boton = botonIn;
	}
	
	@Override
	public void handle(ActionEvent event) {
		Tablero tablero = Tablero.getInstancia();
		Propiedad propiedad = (Propiedad)tablero.getCasillasTablero().get(tablero.getPosicion(jugador));
		propiedad.comprar(jugador);
		vBox.getChildren().remove(boton);
		vistaTablero.actualizar();
	}

}
