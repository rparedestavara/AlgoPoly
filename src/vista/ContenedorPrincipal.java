package vista;

import Clases.AlgoPoly;
import Clases.Jugador;
import Clases.Turno;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import vista.Eventos.BotonLanzarDadosHandler;

public class ContenedorPrincipal extends BorderPane{
		
		BarraDeMenu menuBar;
		VistaTablero vistaTablero; 
		Canvas canvasCentral;
		 
	public ContenedorPrincipal(Stage stage) {
		this.setEscenaCentral();
		this.setBotonesDerecha();
		this.setMenu(stage);
	}

	private void setMenu(Stage stage) {
		this.menuBar = new BarraDeMenu(stage);
		this.setTop(menuBar);
	}

	private void setEscenaCentral() {
		canvasCentral = new Canvas(900, 900);
		vistaTablero = new VistaTablero(canvasCentral);
		vistaTablero.actualizar();
		
		VBox contenedorCentral = new VBox(canvasCentral);
        contenedorCentral.setAlignment(Pos.CENTER);
        contenedorCentral.setSpacing(20);
        contenedorCentral.setPadding(new Insets(25));
        Image imagen = new Image("file:src/vista/fondoverde.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        contenedorCentral.setBackground(new Background(imagenDeFondo));
        this.setCenter(contenedorCentral);

	}
	
	private VBox crearVBox() {
		VBox vBox = new VBox();
		vBox.setSpacing(20);
		vBox.setPadding(new Insets(15));
		vBox.setMinWidth(220);
		return vBox;
	}

	private void setBotonesDerecha() {
		VBox vBoxBotones = crearVBox();
		VBox vBoxMensajes = crearVBox();

		this.setRight(vBoxBotones);
		this.setLeft(vBoxMensajes);
		
		Turno turno = AlgoPoly.getInstancia().getTurno();
		Jugador jugador = turno.aQuienLeToca();
		Text nombreJugador = new Text();
		nombreJugador.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
		nombreJugador.setFill(jugador.getColor());
		nombreJugador.setText("Turno del jugador: " + jugador.getNombre());		
		
		Text dineroJugador = new Text("Dinero: $" + Double.toString(jugador.getDinero()));
		vBoxMensajes.getChildren().add(nombreJugador);
		vBoxMensajes.getChildren().add(dineroJugador);
				
		Button botonLanzarDados = new Button();
		botonLanzarDados.setText("lanzar Dados");
		vBoxBotones.getChildren().add(botonLanzarDados);
		BotonLanzarDadosHandler botonLanzarDadosHandler = new BotonLanzarDadosHandler(vBoxBotones, vBoxMensajes, vistaTablero);
		botonLanzarDados.setOnAction(botonLanzarDadosHandler);
	}

}
