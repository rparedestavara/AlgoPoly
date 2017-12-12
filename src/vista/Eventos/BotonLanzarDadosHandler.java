package vista.Eventos;


import java.util.List;

import Clases.AlgoPoly;
import Clases.Dados;
import Clases.Estado;
import Clases.Jugador;
import Clases.Propiedad;
import Clases.Tablero;
import Clases.Turno;
import excepciones.JugadorPuedeComprarException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
		nombreJugador.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
		nombreJugador.setText("Turno del jugador: " + jugador.getNombre());
		vBoxMensajes.getChildren().add(nombreJugador);
		Text dineroJugador = new Text("Dinero: " + jugador.getDinero());
		dineroJugador.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
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
		Jugador jugadorSiguiente = turno.proximoTurno();
		this.estadoDeJuego(jugador, jugadorSiguiente);
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

	private void estadoDeJuego(Jugador jugador, Jugador jugadorSiguiente) {
		if (jugador.getEstado() == Estado.PERDEDOR){
			Alert alerta = new Alert(AlertType.INFORMATION);
			alerta.setTitle("PERDISTE");
			alerta.setHeaderText("Mejor suerte la proxima!");
			alerta.setContentText("Te quedaste sin plata y sin propiedades");
			alerta.show();
		}
		if (AlgoPoly.getInstancia().hayGanador()) {
			Alert alerta = new Alert(AlertType.INFORMATION);
			alerta.setTitle("GANASTE");
			alerta.setHeaderText("Felicitaciones " + jugadorSiguiente.getNombre() + "!!");
			alerta.setContentText("Sos el ganador de AlgoPoly. Esperamos que vuelvas pronto \n"
					+ "ATTE: Grupo T13");
			alerta.show();
		}
	}

	
	
}
