package vista.Eventos;

import java.util.ArrayList;

import Clases.Jugador;
import Clases.Propiedad;
import Clases.Tablero;
import Clases.Turno;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import vista.Eventos.BotonLanzarDadosHandler;

public class BotonInicioTurnoHandler implements EventHandler<ActionEvent>{ 
	//Muestra las propiedades a vender y muestra un boton lanzar dados, cuando lo precionan termina de vender y pasa a lanzar los dados
	VBox vBox;

	public BotonInicioTurnoHandler(VBox vBoxIn) {
		vBox = vBoxIn;
	}
	
	@Override
	public void handle(ActionEvent event) { //Falta que de la opcion de construir casas
		vBox.getChildren().clear();
		Button botonLanzarDados = new Button();
		botonLanzarDados.setText("lanzar Dados");
		vBox.getChildren().add(botonLanzarDados);
		BotonLanzarDadosHandler botonLanzarDadosHandler = new BotonLanzarDadosHandler(vBox);
		botonLanzarDados.setOnAction(botonLanzarDadosHandler);
		Tablero tablero = Tablero.getInstancia();
		Turno turno = tablero.getTurno();
		Jugador jugador = turno.aQuienLeToca();
		ArrayList<Propiedad> propiedades = jugador.getPropiedades();
		for(Propiedad propiedad : propiedades) {
			Button botonPropiedad = new Button();
			botonPropiedad.setText(propiedad.getNombre());
			BotonPropiedadHandler botonPropiedadHandler = new BotonPropiedadHandler(vBox, botonPropiedad, propiedad,jugador);
			botonPropiedad.setOnAction(botonPropiedadHandler);
			vBox.getChildren().add(botonPropiedad);
		}
	}

}
