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
		this.setBotones();
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

	private void setBotones() {
		Button botonInicio = new Button();
		botonInicio.setText("Iniciar Juego");
		VBox contenedorVertical = new VBox(botonInicio);
		contenedorVertical.setSpacing(20);
		contenedorVertical.setPadding(new Insets(15));
		BotonInicioTurnoHandler botonInicioTurnoHandler = new BotonInicioTurnoHandler(contenedorVertical, vistaTablero);
		botonInicio.setOnAction(botonInicioTurnoHandler);
		
		this.setRight(contenedorVertical);
		
	}
}
