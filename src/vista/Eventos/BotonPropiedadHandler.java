package vista.Eventos;

import Clases.Jugador;
import Clases.Propiedad;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class BotonPropiedadHandler implements EventHandler<ActionEvent>{
	VBox vBox;
	Propiedad propiedad;
	Jugador jugador;
	Button boton;
	
	public BotonPropiedadHandler(VBox vBoxIn, Button botonIn, Propiedad propiedadIn, Jugador jugadorIn) {
		vBox = vBoxIn;
		propiedad = propiedadIn;
		jugador = jugadorIn;
		boton = botonIn;
	}

	@Override
	public void handle(ActionEvent event) {
		vBox.getChildren().remove(boton);
		propiedad.vender(jugador);
	}
	

}
