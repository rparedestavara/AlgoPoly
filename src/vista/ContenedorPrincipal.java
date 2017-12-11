package vista;

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
import vista.Eventos.BotonInicioTurnoHandler;

public class ContenedorPrincipal extends BorderPane{
		
		BarraDeMenu menuBar;
		VistaTablero vistaTablero; 
		Canvas canvasCentral;
		 
	public ContenedorPrincipal() {
		this.setEscenaCentral();
		this.setBotonesDerecha();
		this.setMenu();
	}

	private void setMenu() {
		this.menuBar = new BarraDeMenu();
		this.setTop(menuBar);
	}

	private void setEscenaCentral() {
		canvasCentral = new Canvas(1000, 1000);
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

	private void setBotonesDerecha() {
		Button botonInicio = new Button();
		botonInicio.setText("Iniciar Juego");
		VBox contenedorBotones = new VBox(botonInicio);
		contenedorBotones.setSpacing(20);
		contenedorBotones.setPadding(new Insets(15));
		contenedorBotones.setMinWidth(220);
		
		VBox contenedorMensajes = new VBox();
		contenedorMensajes.setSpacing(20);
		contenedorMensajes.setPadding(new Insets(15));
		contenedorMensajes.setMinWidth(220);
		BotonInicioTurnoHandler botonInicioTurnoHandler = new BotonInicioTurnoHandler(contenedorBotones, contenedorMensajes, vistaTablero);
		botonInicio.setOnAction(botonInicioTurnoHandler);
		
		this.setRight(contenedorBotones);
		this.setLeft(contenedorMensajes);
	}

}
