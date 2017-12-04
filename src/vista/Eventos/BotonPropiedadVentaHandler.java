package vista.Eventos;

import Clases.Jugador;
import Clases.Propiedad;
import Clases.Turno;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import vista.VistaTablero;

public class BotonPropiedadVentaHandler implements EventHandler<ActionEvent>{
	VBox vBox;
	Propiedad propiedad;
	Jugador jugador;
	Button boton;
	Text mensajePropiedades;
	Turno turno;
	VistaTablero vistaTablero;
	
	public BotonPropiedadVentaHandler(VBox vBoxIn, Button botonIn, Propiedad propiedadIn, 
			Jugador jugadorIn, Text mensajePropiedadesIn,Turno turno, VistaTablero vistaTableroIn) {
		vBox = vBoxIn;
		propiedad = propiedadIn;
		jugador = jugadorIn;
		boton = botonIn;
		mensajePropiedades = mensajePropiedadesIn;
		this.turno=turno;
		vistaTablero = vistaTableroIn;
	}

	@Override
	public void handle(ActionEvent event) {
		vBox.getChildren().remove(boton);
		turno.agregarPropiedadVendidaDeJugador(propiedad);
		propiedad.vender();
		int cantidadesPropiedades = jugador.getPropiedades().size();
		if(cantidadesPropiedades == 0) {
			vBox.getChildren().remove(mensajePropiedades);
		}
		vistaTablero.actualizar();
	}
	

}
