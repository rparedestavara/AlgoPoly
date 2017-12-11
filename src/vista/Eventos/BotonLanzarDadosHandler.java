package vista.Eventos;


import java.util.List;

import Clases.AlgoPoly;
import Clases.Dados;
import Clases.Jugador;
import Clases.Propiedad;
import Clases.Tablero;
import Clases.Turno;
import excepciones.JugadorPuedeComprarException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import vista.VistaTablero;

public class BotonLanzarDadosHandler implements EventHandler<ActionEvent> {
	private VBox vBoxBotones;
	private VBox vBoxMensajes;
	private VistaTablero vistaTablero;

	public BotonLanzarDadosHandler(VBox vBoxIn, VBox contenedorMensajes, VistaTablero vistaTableroIn) {
		vBoxBotones = vBoxIn;
		vBoxMensajes = contenedorMensajes;
		vistaTablero = vistaTableroIn;
	}
	
	private void mostrarMensajes() {
		AlgoPoly algoPoly = AlgoPoly.getInstancia();
		List<String> mensajes = algoPoly.getMensajes();
		for(String mensaje : mensajes) {
			Text mensajeText = new Text(mensaje);
			vBoxMensajes.getChildren().add(mensajeText);
		}
		algoPoly.borrarMensajes();
	}
	
	private void mensajeDobleTurno() {
		Turno turno = AlgoPoly.getInstancia().getTurno();
		if(turno.juegaElMismoJugador()) {
			Text mensaje = new Text("Salieron dobles, el jugador tiene otro turno");
			vBoxMensajes.getChildren().add(mensaje);
		}
	}
	
	@Override
	public void handle(ActionEvent event) {
		vBoxBotones.getChildren().clear();
		vBoxMensajes.getChildren().clear();
		Tablero tablero = Tablero.getInstancia();
		Dados dados = Dados.getInstance();
		Turno turno = AlgoPoly.getInstancia().getTurno();
		Text infoDados=new Text();
		Jugador jugador = turno.aQuienLeToca();
		Text nombreJugador=new Text();
		nombreJugador.setFill(jugador.getColor());
		nombreJugador.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
		nombreJugador.setText("Turno del jugador: " + jugador.getNombre());
		vBoxMensajes.getChildren().add(nombreJugador);
		Text dineroJugador = new Text("Dinero: " + jugador.getDinero());
		vBoxMensajes.getChildren().add(dineroJugador);
		dados.lanzar();
		infoDados.setText("El resultado de los dados es "+ dados.getResultado());
		infoDados.autosize();
		
		try {
			tablero.jugada(turno.aQuienLeToca() , dados.getResultado());
		
		} catch(JugadorPuedeComprarException e) {
			Button botonComprarPropiedad = new Button();
			Propiedad propiedad = (Propiedad) tablero.getCasillasTablero().get(tablero.getPosicion(jugador));
			botonComprarPropiedad.setText("Comprar " + propiedad.getNombre() + " (-$" + propiedad.getPrecio() + ")");
			BotonComprarPropiedadHandler botonComprarPropiedadHandler = new BotonComprarPropiedadHandler(vBoxBotones, vBoxMensajes, jugador, botonComprarPropiedad, vistaTablero);
			botonComprarPropiedad.setOnAction(botonComprarPropiedadHandler);
			vBoxBotones.getChildren().add(botonComprarPropiedad);
		}
		turno.proximoTurno();
		Button botonFinTurno = new Button();
		botonFinTurno.setText("Finalizar Turno");
		vBoxBotones.getChildren().add(botonFinTurno);
		vBoxMensajes.getChildren().add(infoDados);
		mensajeDobleTurno();
		mostrarMensajes();
		BotonInicioTurnoHandler botonFinVentaHandler = new BotonInicioTurnoHandler(vBoxBotones, vBoxMensajes, vistaTablero);
		botonFinTurno.setOnAction(botonFinVentaHandler);
		vistaTablero.actualizar();
	}

	
	
}
