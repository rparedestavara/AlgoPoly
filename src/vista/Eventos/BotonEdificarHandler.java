package vista.Eventos;

import java.util.ArrayList;

import Clases.Jugador;
import Clases.Propiedad;
import Clases.Provincia;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import vista.VistaTablero;

public class BotonEdificarHandler implements EventHandler<ActionEvent>{
	VBox vBoxBotones;
	VBox vBoxMensajes;
	Jugador jugador;
	VistaTablero vistaTablero;
	
	public BotonEdificarHandler(VBox vBoxBotonesIn, VBox vBoxMensajesIn, Jugador jugadorIn, VistaTablero vistaTableroIn) {
		vBoxBotones = vBoxBotonesIn;
		vBoxMensajes = vBoxMensajesIn;
		jugador = jugadorIn;
		vistaTablero = vistaTableroIn;
	}

	@Override
	public void handle(ActionEvent event) {
		vBoxBotones.getChildren().clear();
		ArrayList<Propiedad> propiedades = jugador.getPropiedades();
		
		Button botonLanzarDados = new Button();
		botonLanzarDados.setText("lanzar Dados");
		vBoxBotones.getChildren().add(botonLanzarDados);
		BotonLanzarDadosHandler botonLanzarDadosHandler = new BotonLanzarDadosHandler(vBoxBotones, vBoxMensajes, vistaTablero);
		botonLanzarDados.setOnAction(botonLanzarDadosHandler);
		
		if(jugador.puedeEdificar()) {
			Text mensajeEdificacion = new Text();
			mensajeEdificacion.setText("Edificar: ");
			vBoxBotones.getChildren().add(mensajeEdificacion);
			for(Propiedad propiedad : propiedades) {
				Button botonEdificarIndividual = new Button();
				if(propiedad.jugadorPuedeComprarCasa(jugador.getDinero())) {
					botonEdificarIndividual.setText("Casa en " + propiedad.getNombre() + " (-$" + ((Provincia) propiedad).getCostoCasa() + ")");
				}
				else if(propiedad.jugadorPuedeComprarHotel(jugador.getDinero())) {
					botonEdificarIndividual.setText("hotel en " + propiedad.getNombre() + " (-$" + ((Provincia) propiedad).getCostoHotel() + ")");
				}
				else {
					continue;
				}
				BotonEdificarIndividualHandler botonEdificarIndividualHandler = new BotonEdificarIndividualHandler(vBoxBotones, vBoxMensajes, 
						botonEdificarIndividual, (Provincia)propiedad, jugador, mensajeEdificacion, vistaTablero);
				botonEdificarIndividual.setOnAction(botonEdificarIndividualHandler);
				vBoxBotones.getChildren().add(botonEdificarIndividual);
			}
		}
	}
}
