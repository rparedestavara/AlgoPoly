package vista.Eventos;

import Clases.Jugador;
import Clases.Provincia;
import Clases.ProvinciaDividida;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class BotonEdificarIndividualHandler implements EventHandler<ActionEvent>{
	VBox vBox;
	Provincia provincia;
	Jugador jugador;
	Button boton;
	Text mensajeEdificar;
	
	public BotonEdificarIndividualHandler(VBox vBoxIn, Button botonIn, Provincia provinciaIn, 
			Jugador jugadorIn, Text mensajeEdificarIn) {
		vBox = vBoxIn;
		provincia = provinciaIn;
		jugador = jugadorIn;
		boton = botonIn;
		mensajeEdificar = mensajeEdificarIn;
	}
	
	private void agregarBotonesHoteles() {
		Button botonHotelPropio = new Button();
		Button botonHotelOpuesto = new Button();
		botonHotelPropio.setText("hotel en " + provincia.getNombre());
		botonHotelOpuesto.setText("hotel en " + ((ProvinciaDividida)provincia).getNombreOpuesta());
		vBox.getChildren().add(botonHotelPropio);
		vBox.getChildren().add(botonHotelOpuesto);
		BotonEdificarIndividualHandler botonHotelPropioHandler = new BotonEdificarIndividualHandler(vBox, botonHotelPropio, 
				provincia, jugador, mensajeEdificar);
		BotonEdificarIndividualHandler botonOpuestoHandler = new BotonEdificarIndividualHandler(vBox, botonHotelOpuesto, 
				provincia, jugador, mensajeEdificar);
		botonHotelPropio.setOnAction(botonHotelPropioHandler);
		botonHotelOpuesto.setOnAction(botonOpuestoHandler);
	}

	@Override
	public void handle(ActionEvent event) {
		if(provincia.sePuedeConstruirUnaCasa()) {
			provincia.construirCasa();
			if(provincia.sePuedeConstruirUnHotel()) {
				vBox.getChildren().remove(boton);
				agregarBotonesHoteles();
			}
			else if(!provincia.sePuedeConstruirUnaCasa()) {
				vBox.getChildren().remove(boton);
			}
		}
		else if(provincia.sePuedeConstruirUnHotel()) {
			provincia.construirHotel();
			vBox.getChildren().remove(boton);
		}
		if(!jugador.puedeEdificar()) {
			vBox.getChildren().remove(mensajeEdificar);
		}
	}
	
}
