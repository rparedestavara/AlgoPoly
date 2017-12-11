package vista.Eventos;

import Clases.Jugador;
import Clases.Propiedad;
import Clases.Provincia;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import vista.VistaTablero;

public class BotonEdificarIndividualHandler extends BotonEdificarHandler{
	Provincia provincia;
	
	public BotonEdificarIndividualHandler(VBox vBoxB, VBox vBoxM, Button botonIn, Provincia provinciaIn, 
			Jugador jugadorIn, Text mensajeEdificarIn, VistaTablero vistaTableroIn) {
		super(vBoxB, vBoxM, jugadorIn, vistaTableroIn);
		provincia = provinciaIn;
	}
	
	private void mostrarMensajeEdificacionEnVBox(VBox vBox, Propiedad provincia, String edificacion, Jugador jugador) {
		Text mensajeVenta = new Text("Usted compro una " + edificacion + " en " + provincia.getNombre());
		Text mensajeEfectivo = new Text("Su efectivo ahora es $" + jugador.getDinero());
		vBox.getChildren().add(mensajeVenta);
		vBox.getChildren().add(mensajeEfectivo);
	}

	@Override
	public void handle(ActionEvent event) {
		if(provincia.sePuedeConstruirUnaCasa()) {
			provincia.construirCasa();
			mostrarMensajeEdificacionEnVBox(vBoxMensajes, provincia, "casa", jugador);
		}
		else if(provincia.sePuedeConstruirUnHotel()) {
			provincia.construirHotel();
			mostrarMensajeEdificacionEnVBox(vBoxMensajes, provincia, "hotel", jugador);
		}
		super.handle(event);
		vistaTablero.actualizar();
	}
	
}
