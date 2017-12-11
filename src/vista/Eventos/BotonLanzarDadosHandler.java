package vista.Eventos;


import Clases.AlgoPoly;
import Clases.Carcel;
import Clases.Dados;
import Clases.Jugador;
import Clases.Propiedad;
import Clases.Tablero;
import Clases.Turno;
import excepciones.NoPuedeJugarException;
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
		dados.lanzar();
		infoDados.setText("El resultado de los dados es "+ dados.getResultado());
		infoDados.autosize();
		Button pagarFianza = null;
		try {
			tablero.jugada(turno.aQuienLeToca() , dados.getResultado());
			
		}catch(NoPuedeJugarException e) {
				pagarFianza = this.crearBotonFianza(jugador);
				Carcel.getInstancia().aumentarTurno(jugador);								
		}catch(JugadorPuedeComprarException e) {
			Button botonComprarPropiedad = new Button();
			Propiedad propiedad = (Propiedad) tablero.getCasillasTablero().get(tablero.getPosicion(jugador));
			botonComprarPropiedad.setText("Comprar " + propiedad.getNombre() + " (-$" + propiedad.getPrecio() + ")");
			BotonComprarPropiedadHandler botonComprarPropiedadHandler = new BotonComprarPropiedadHandler(vBoxBotones, jugador, botonComprarPropiedad, vistaTablero);
			botonComprarPropiedad.setOnAction(botonComprarPropiedadHandler);
			vBoxBotones.getChildren().add(botonComprarPropiedad);
		}
		turno.proximoTurno();
		Button botonFinTurno = new Button();
		botonFinTurno.setText("Finalizar Turno");
		if (pagarFianza != null && jugador.puedePagarFianzaDeCarcel()) vBoxBotones.getChildren().add(pagarFianza);
		vBoxBotones.getChildren().add(botonFinTurno);
		vBoxMensajes.getChildren().add(infoDados);
		Text infoCasilla = new Text();
		infoCasilla.setText(" Usted Cayo En " + tablero.getCasillasTablero().get(tablero.getPosicion(jugador)).getNombre());
		infoCasilla.autosize();
		vBoxMensajes.getChildren().add(infoCasilla);
		BotonInicioTurnoHandler botonFinVentaHandler = new BotonInicioTurnoHandler(vBoxBotones, vBoxMensajes, vistaTablero);
		botonFinTurno.setOnAction(botonFinVentaHandler);
		Text casas = new Text();
		casas.setText("Cantidad de propiedades: " + jugador.getCantidadDePropiedades());
		casas.autosize();
		vBoxMensajes.getChildren().add(casas);
		vistaTablero.actualizar();
	}

	private Button crearBotonFianza(Jugador jugador) {
		Button pagarFianza = new Button("PAGAR FIANZA!" + " (-$" + jugador.getCostoFianza() + ")");
		PagarFianzaEventHandler pagarFianzaEventHandler = new PagarFianzaEventHandler(jugador,pagarFianza);
		pagarFianza.setOnAction(pagarFianzaEventHandler);
		return pagarFianza;
	}
}
