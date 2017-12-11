package vista.Eventos;


import java.util.ArrayList;

import Clases.AlgoPoly;
import Clases.Carcel;
import Clases.Jugador;
import Clases.Propiedad;
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

public class BotonInicioTurnoHandler implements EventHandler<ActionEvent>{ 
	/*Muestra las propiedades a vender y muestra un boton lanzar dados.
	 * Cuando lo presionan termina de vender y pasa a lanzar los dados
	 */
	
	private VBox vBoxBotones;
	private VBox vBoxMensajes;
	private VistaTablero vistaTablero;

	public BotonInicioTurnoHandler(VBox vBoxIn, VBox contenedorMensajes, VistaTablero vistaTableroIn) {
		vBoxBotones = vBoxIn;
		vBoxMensajes = contenedorMensajes;
		vistaTablero = vistaTableroIn;
	}
	
	private void agregarBotonesVentaPropiedades(VBox vBoxBotones, VBox vBoxMensajes, Jugador jugador, ArrayList<Propiedad> propiedades,Turno turno) {
		Text mensajePropiedades = new Text();
		if(propiedades.size() > 0) {
			mensajePropiedades.setText("Vender propiedades:");
			vBoxBotones.getChildren().add(mensajePropiedades);
		}
		for(Propiedad propiedad : propiedades) {
			Button botonPropiedad = new Button();
			botonPropiedad.setText(propiedad.getNombre() + " (+$" + propiedad.getPrecioVenta() + ")");
			BotonPropiedadVentaHandler botonPropiedadHandler = new BotonPropiedadVentaHandler(vBoxBotones, vBoxMensajes, botonPropiedad,propiedad,jugador, mensajePropiedades,turno,vistaTablero);
			botonPropiedad.setOnAction(botonPropiedadHandler);
			vBoxBotones.getChildren().add(botonPropiedad);
		}
	}
	
	@Override
	public void handle(ActionEvent event) {
		vBoxBotones.getChildren().clear();
		vBoxMensajes.getChildren().clear();
		Turno turno = AlgoPoly.getInstancia().getTurno();
		Jugador jugador = turno.aQuienLeToca();
		
		Text nombreJugador = new Text();
		nombreJugador.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
		nombreJugador.setFill(jugador.getColor());
		nombreJugador.setText("Turno del jugador: " + jugador.getNombre());		
		
		Button botonLanzarDados = new Button();
		botonLanzarDados.setText("lanzar Dados");
		vBoxBotones.getChildren().add(botonLanzarDados);
		BotonLanzarDadosHandler botonLanzarDadosHandler = new BotonLanzarDadosHandler(vBoxBotones, vBoxMensajes, vistaTablero);
		botonLanzarDados.setOnAction(botonLanzarDadosHandler);
		
		if(Carcel.getInstancia().enCarcel(jugador)) {
			Button pagarFianza = this.crearBotonFianza(jugador, botonLanzarDados);
			vBoxBotones.getChildren().add(pagarFianza);
			
			if (!jugador.puedePagarFianzaDeCarcel()) {
				pagarFianza.setDisable(true);
				Button botonFinTurno = new Button();
				botonFinTurno.setText("Finalizar Turno");
				BotonInicioTurnoHandler botonFinVentaHandler = new BotonInicioTurnoHandler(vBoxBotones, vBoxMensajes, vistaTablero);
				botonFinTurno.setOnAction(botonFinVentaHandler);
				vBoxBotones.getChildren().add(botonFinTurno);
				turno.proximoTurno();
			}
			
			Text info = new Text("Usted esta en la carcel");
			info.setFont(Font.font("Tahoma", FontWeight.BOLD, FontPosture.REGULAR, 13));
			this.vBoxMensajes.getChildren().add(info);
			
			Carcel.getInstancia().aumentarTurno(jugador);
			botonLanzarDados.setDisable(true);

		}

		Text dineroJugador = new Text("Dinero: " + Double.toString(jugador.getDinero()));
		vBoxMensajes.getChildren().add(nombreJugador);
		vBoxMensajes.getChildren().add(dineroJugador);
				
		
		
		if(jugador.puedeEdificar()) {
			Button botonEdificar = new Button();
			botonEdificar.setText("Edificar");
			BotonEdificarHandler botonEdificarHandler = new BotonEdificarHandler(vBoxBotones, vBoxMensajes, jugador, vistaTablero);
			botonEdificar.setOnAction(botonEdificarHandler);
			vBoxBotones.getChildren().add(botonEdificar);
		}
		
		ArrayList<Propiedad> propiedades = jugador.getPropiedades();
		agregarBotonesVentaPropiedades(vBoxBotones, vBoxMensajes, jugador, propiedades,turno);
		vistaTablero.actualizar();
	}
	


	private Button crearBotonFianza(Jugador jugador, Button boton) {
		Button pagarFianza = new Button("PAGAR FIANZA!" + " (-$" + jugador.getCostoFianza() + ")");
		PagarFianzaEventHandler pagarFianzaEventHandler = new PagarFianzaEventHandler(jugador,pagarFianza, boton);
		pagarFianza.setOnAction(pagarFianzaEventHandler);
		return pagarFianza;
	}

}
