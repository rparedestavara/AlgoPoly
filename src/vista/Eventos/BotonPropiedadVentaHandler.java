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
	VBox vBoxBotones;
	VBox vBoxMensajes;
	Propiedad propiedad;
	Jugador jugador;
	Button boton;
	Text mensajePropiedades;
	Turno turno;
	VistaTablero vistaTablero;
	
	public BotonPropiedadVentaHandler(VBox vBoxB, VBox vBoxM, Button botonIn, Propiedad propiedadIn, 
			Jugador jugadorIn, Text mensajePropiedadesIn,Turno turno, VistaTablero vistaTableroIn) {
		vBoxBotones = vBoxB;
		vBoxMensajes = vBoxM;
		propiedad = propiedadIn;
		jugador = jugadorIn;
		boton = botonIn;
		mensajePropiedades = mensajePropiedadesIn;
		this.turno=turno;
		vistaTablero = vistaTableroIn;
	}
	
	private void mostrarMensajeVentaEnVBox(VBox vBox, Propiedad propiedad, Jugador jugador) {
		Text mensajeVenta = new Text("Usted vendio " + propiedad.getNombre());
		Text mensajeEfectivo = new Text("Su efectivo ahora es $" + jugador.getDinero());
		vBox.getChildren().add(mensajeVenta);
		vBox.getChildren().add(mensajeEfectivo);
	}

	@Override
	public void handle(ActionEvent event) {
		vBoxBotones.getChildren().remove(boton);
		turno.agregarPropiedadVendidaDeJugador(propiedad);
		propiedad.vender();
		int cantidadesPropiedades = jugador.getPropiedades().size();
		if(cantidadesPropiedades == 0) {
			vBoxBotones.getChildren().remove(mensajePropiedades);
		}
		mostrarMensajeVentaEnVBox(vBoxMensajes, propiedad, jugador);
		vistaTablero.actualizar();
	}
	

}
