package vista.Eventos;

import Clases.Jugador;
import Clases.Propiedad;
import Clases.Tablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import vista.VistaTablero;

public class BotonComprarPropiedadHandler implements EventHandler<ActionEvent>{
	VBox vBoxBotones;
	VBox vBoxMensajes;
	Jugador jugador;
	Button boton;
	VistaTablero vistaTablero;
	
	public BotonComprarPropiedadHandler(VBox vBoxB, VBox vBoxM, Jugador jugadorIn, Button botonIn, VistaTablero vistaTableroIn) {
		vBoxBotones = vBoxB;
		vBoxMensajes = vBoxM;
		jugador = jugadorIn;
		vistaTablero = vistaTableroIn;
		boton = botonIn;
	}
	
	private void mostrarMensajeCompraEnVBox(VBox vBox, Propiedad propiedad, Jugador jugador) {
		Text mensajeVenta = new Text("Usted compro " + propiedad.getNombre());
		Text mensajeEfectivo = new Text("Su efectivo ahora es $" + jugador.getDinero());
		vBox.getChildren().add(mensajeVenta);
		vBox.getChildren().add(mensajeEfectivo);
	}
	
	@Override
	public void handle(ActionEvent event) {
		Tablero tablero = Tablero.getInstancia();
		Propiedad propiedad = (Propiedad)tablero.getCasillasTablero().get(tablero.getPosicion(jugador));
		propiedad.comprar(jugador);
		vBoxBotones.getChildren().remove(boton);
		mostrarMensajeCompraEnVBox(vBoxMensajes, propiedad, jugador);
		vistaTablero.actualizar();
	}

}
