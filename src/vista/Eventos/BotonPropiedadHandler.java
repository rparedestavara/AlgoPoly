package vista.Eventos;

import Clases.Jugador;
import Clases.Propiedad;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import vista.VistaTablero;

public class BotonPropiedadHandler implements EventHandler<ActionEvent>{
	VBox vBox;
	Propiedad propiedad;
	Jugador jugador;
	Button boton;
	Text mensajePropiedades;
	
	public BotonPropiedadHandler(VBox vBoxIn, Button botonIn, Propiedad propiedadIn, 
			Jugador jugadorIn, Text mensajePropiedadesIn) {
		vBox = vBoxIn;
		propiedad = propiedadIn;
		jugador = jugadorIn;
		boton = botonIn;
		mensajePropiedades = mensajePropiedadesIn;
	}

	@Override
	public void handle(ActionEvent event) {
		vBox.getChildren().remove(boton);
		propiedad.vender();
		int cantidadesPropiedades = jugador.getPropiedades().size();
		if(cantidadesPropiedades == 0) {
			vBox.getChildren().remove(mensajePropiedades);
		}
	}
	

}
