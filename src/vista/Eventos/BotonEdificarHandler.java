package vista.Eventos;

import java.util.ArrayList;

import Clases.AlgoPoly;
import Clases.Jugador;
import Clases.Propiedad;
import Clases.Provincia;
import Clases.Turno;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import vista.VistaTablero;

public class BotonEdificarHandler implements EventHandler<ActionEvent>{
	VBox vBox;
	Jugador jugador;
	VistaTablero vistaTablero;
	
	public BotonEdificarHandler(VBox vBoxIn, Jugador jugadorIn, VistaTablero vistaTableroIn) {
		vBox = vBoxIn;
		jugador = jugadorIn;
		vistaTablero = vistaTableroIn;
	}

	@Override
	public void handle(ActionEvent event) {
		vBox.getChildren().clear();
		ArrayList<Propiedad> propiedades = jugador.getPropiedades();
		
		Turno turno = AlgoPoly.getInstancia().getTurno();
		Jugador jugador = turno.aQuienLeToca();
		Text nombreJugador=new Text();
		nombreJugador.setFill(jugador.getColor());
		nombreJugador.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
		nombreJugador.setText("Turno del jugador: " + jugador.getNombre());
		vBox.getChildren().add(nombreJugador);
		
		Button botonLanzarDados = new Button();
		botonLanzarDados.setText("lanzar Dados");
		vBox.getChildren().add(botonLanzarDados);
		BotonLanzarDadosHandler botonLanzarDadosHandler = new BotonLanzarDadosHandler(vBox, vistaTablero);
		botonLanzarDados.setOnAction(botonLanzarDadosHandler);
		
		Text mensajeEdificacion = new Text(); //men prop?
		mensajeEdificacion.setText("Edificar: ");
		vBox.getChildren().add(mensajeEdificacion);
		
		for(Propiedad propiedad : propiedades) {
			Button botonEdificarIndividual = new Button();
			if(propiedad.sePuedeConstruirUnaCasa()) {
				botonEdificarIndividual.setText("Casa en " + propiedad.getNombre());
			}
			else if(propiedad.sePuedeConstruirUnHotel()) {
				botonEdificarIndividual.setText("hotel en " + propiedad.getNombre());
			}
			else {
				continue;
			}
			BotonEdificarIndividualHandler botonEdificarIndividualHandler = new BotonEdificarIndividualHandler(vBox, botonEdificarIndividual, 
					(Provincia)propiedad, jugador, mensajeEdificacion, vistaTablero);
			botonEdificarIndividual.setOnAction(botonEdificarIndividualHandler);
			vBox.getChildren().add(botonEdificarIndividual);
		}
	}
}
