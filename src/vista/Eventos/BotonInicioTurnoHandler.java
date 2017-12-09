package vista.Eventos;


import java.util.ArrayList;

import Clases.AlgoPoly;
import Clases.Jugador;
import Clases.Propiedad;
import Clases.Turno;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import vista.VistaTablero;

public class BotonInicioTurnoHandler implements EventHandler<ActionEvent>{ 
	/*Muestra las propiedades a vender y muestra un boton lanzar dados.
	 * Cuando lo presionan termina de vender y pasa a lanzar los dados
	 */
	
	
	private VBox vBox;
	private VistaTablero vistaTablero;

	public BotonInicioTurnoHandler(VBox vBoxIn, VistaTablero vistaTableroIn) {
		vBox = vBoxIn;
		vistaTablero = vistaTableroIn;
	}
	
	private void agregarBotonesVentaPropiedades(VBox vBox, Jugador jugador, ArrayList<Propiedad> propiedades,Turno turno) {
		Text mensajePropiedades = new Text();
		if(propiedades.size() > 0) {
			mensajePropiedades.setText("Vender propiedades:");
			vBox.getChildren().add(mensajePropiedades);
		}
		for(Propiedad propiedad : propiedades) {
			Button botonPropiedad = new Button();
			botonPropiedad.setText(propiedad.getNombre());
			BotonPropiedadVentaHandler botonPropiedadHandler = new BotonPropiedadVentaHandler(vBox, botonPropiedad,propiedad,jugador, mensajePropiedades,turno,vistaTablero);
			botonPropiedad.setOnAction(botonPropiedadHandler);
			vBox.getChildren().add(botonPropiedad);
		}
	}
	
	@Override
	public void handle(ActionEvent event) {
		vBox.getChildren().clear();
		Turno turno = AlgoPoly.getInstancia().getTurno();
		Jugador jugador = turno.aQuienLeToca();
		Text nombreJugador = new Text();
		nombreJugador.setFill(jugador.getColor());
		nombreJugador.setText("Turno del jugador: " + jugador.getNombre());
		
		
		Canvas canvas=new Canvas();
		canvas.getGraphicsContext2D().fillOval(2+ 50 + 3, 2 + 53, 14, 14);
		canvas.getGraphicsContext2D().setFill(jugador.getColor());
		
		
		Text dineroJugador = new Text("Dinero: " + Double.toString(jugador.getDinero()));
		vBox.getChildren().add(nombreJugador);
		vBox.getChildren().add(dineroJugador);
				
		Button botonLanzarDados = new Button();
		botonLanzarDados.setText("lanzar Dados");
		vBox.getChildren().add(botonLanzarDados);
		BotonLanzarDadosHandler botonLanzarDadosHandler = new BotonLanzarDadosHandler(vBox, vistaTablero);
		botonLanzarDados.setOnAction(botonLanzarDadosHandler);
		
		if(jugador.puedeEdificar()) {
			Button botonEdificar = new Button();
			botonEdificar.setText("Edificar");
			BotonEdificarHandler botonEdificarHandler = new BotonEdificarHandler(vBox, jugador, vistaTablero);
			botonEdificar.setOnAction(botonEdificarHandler);
			vBox.getChildren().add(botonEdificar);
		}
		ArrayList<Propiedad> propiedades = jugador.getPropiedades();
		agregarBotonesVentaPropiedades(vBox, jugador, propiedades,turno);
		vistaTablero.actualizar();
	}

}
