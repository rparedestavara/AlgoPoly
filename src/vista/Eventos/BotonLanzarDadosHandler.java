package vista.Eventos;

import java.util.ArrayList;

import Clases.AlgoPoly;
import Clases.Dados;
import Clases.Jugador;
import Clases.Propiedad;
import Clases.Tablero;
import Clases.Turno;
import excepciones.NoPuedeJugarException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import vista.VistaTablero;

public class BotonLanzarDadosHandler implements EventHandler<ActionEvent> {
	VBox vBox;
	private VistaTablero vistaTablero;

	public BotonLanzarDadosHandler(VBox vBoxIn, VistaTablero vistaTableroIn) {
		vBox = vBoxIn;
		vistaTablero = vistaTableroIn;
	}
	
	@Override
	public void handle(ActionEvent event) { 
		Tablero tablero = Tablero.getInstancia();
		Dados dados = Dados.getInstance();
		Turno turno = AlgoPoly.getInstancia().getTurno();
		TextField infoDados=new TextField();
		Jugador jugador = turno.aQuienLeToca();
		Text nombreJugador=new Text();
		nombreJugador.setText("Turno del jugador: " + jugador.getNombre());
		vBox.getChildren().add(nombreJugador);
		dados.lanzar();
		infoDados.setText("El resultado de los dados es "+ dados.getResultado());
		Button pagarFianza = null;
		try {
			tablero.jugada(turno.aQuienLeToca() , dados.getResultado());
			
		}catch(NoPuedeJugarException e) {
				pagarFianza = this.crearBotonFianza(jugador);
												
		}

		turno.proximoTurno();
		Button botonFinTurno = new Button();
		botonFinTurno.setText("Finalizar Turno");
		vBox.getChildren().clear();
		if (pagarFianza != null) vBox.getChildren().add(pagarFianza);
		vBox.getChildren().add(nombreJugador);
		vBox.getChildren().add(botonFinTurno);
		vBox.getChildren().add(infoDados);
		TextField infoCasilla=new TextField();
		infoCasilla.setText(" Usted Cayo En " + tablero.getCasillasTablero().get(tablero.getPosicion(jugador)).getNombre());
		vBox.getChildren().add(infoCasilla);
		BotonInicioTurnoHandler botonFinVentaHandler = new BotonInicioTurnoHandler(vBox, vistaTablero);
		botonFinTurno.setOnAction(botonFinVentaHandler);
		TextField casas = new TextField();
		casas.setEditable(false);
		casas.setText("Cantidad de casas: "+jugador.getCantidadDePropiedades());
		this.mostrarPropiedadesVendidas(turno);
		vistaTablero.actualizar();
	}

	private void mostrarPropiedadesVendidas(Turno turno) {
		ArrayList<Propiedad> vendidas = turno.propiedadesVendidas();
		if(vendidas.size()>0) {
		Text text=new Text();
		text.setText("Usted Vendio: ");
		for(int i=0;i<vendidas.size();++i) {
			Button PropiedadVendida = new Button();
			Button casa = new Button();
			Button hoteles= new Button();
			PropiedadVendida.setText("Se Vendio la propieda: "+ vendidas.get(i).getNombre());
			vBox.getChildren().add(PropiedadVendida);
			}
		turno.borrarPropiedades();
		}
	}

	private Button crearBotonFianza(Jugador jugador) {
		Button pagarFianza = new Button("PAGAR FIANZA!");
		PagarFianzaEventHandler pagarFianzaEventHandler = new PagarFianzaEventHandler(jugador);
		pagarFianza.setOnAction(pagarFianzaEventHandler);
		return pagarFianza;
	}
}
