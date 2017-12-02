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
import javafx.scene.text.Text;
import vista.VistaTablero;
import vista.Eventos.BotonLanzarDadosHandler;

public class BotonInicioTurnoHandler implements EventHandler<ActionEvent>{ 
	//Muestra las propiedades a vender y muestra un boton lanzar dados, cuando lo precionan termina de vender y pasa a lanzar los dados
	private VBox vBox;
	private VistaTablero vistaTablero;

	public BotonInicioTurnoHandler(VBox vBoxIn, VistaTablero vistaTableroIn) {
		vBox = vBoxIn;
		vistaTablero = vistaTableroIn;
	}
	
	@Override
	public void handle(ActionEvent event) { //Falta que de la opcion de construir casas
		vBox.getChildren().clear();
		Tablero tablero = Tablero.getInstancia();
		
		Turno turno = tablero.getTurno();
		Jugador jugador = turno.aQuienLeToca();
		Text nombreJugador=new Text();
		nombreJugador.setText("Turno del jugador: " + jugador.getNombre());
		vBox.getChildren().add(nombreJugador);
		
		Button botonLanzarDados = new Button();
		botonLanzarDados.setText("lanzar Dados");
		vBox.getChildren().add(botonLanzarDados);
		BotonLanzarDadosHandler botonLanzarDadosHandler = new BotonLanzarDadosHandler(vBox, vistaTablero);
		botonLanzarDados.setOnAction(botonLanzarDadosHandler);
		ArrayList<Propiedad> propiedades = jugador.getPropiedades();
		Text mensajePropiedades = new Text();
		if(propiedades.size() > 0) {
			mensajePropiedades.setText("Vender propiedades:");
			vBox.getChildren().add(mensajePropiedades);
		}
		for(Propiedad propiedad : propiedades) {
			Button botonPropiedad = new Button();
			botonPropiedad.setText(propiedad.getNombre());
			BotonPropiedadHandler botonPropiedadHandler = new BotonPropiedadHandler(vBox, botonPropiedad, 
					propiedad,jugador, mensajePropiedades);
			botonPropiedad.setOnAction(botonPropiedadHandler);
			vBox.getChildren().add(botonPropiedad);
		}
		vistaTablero.actualizar();
	}

}
