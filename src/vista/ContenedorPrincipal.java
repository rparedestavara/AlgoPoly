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

public class ContenedorPrincipal extends BorderPane{
		VistaTablero vistaTablero; 
		Canvas canvasCentral;
		 
	public ContenedorPrincipal() {
		this.setBotones();
		this.setEscenaCentral();
}

	private void setEscenaCentral() {
		canvasCentral = new Canvas(600, 500);
		vistaTablero = new VistaTablero(canvasCentral);
		vistaTablero.actualizarTablero();
		
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
		Button botonTirarDados = new Button("Tirar dados");
		Button botonVenderPropiedad = new Button("Vender propiedad");
		Button botonComprarPropiedad = new Button("Comprar propiedad");
		
		VBox contenedorVertical = new VBox(botonTirarDados,botonVenderPropiedad, botonComprarPropiedad);
		contenedorVertical.setSpacing(20);
		contenedorVertical.setPadding(new Insets(15));
		
		
		this.setRight(contenedorVertical);
		
	}
}
