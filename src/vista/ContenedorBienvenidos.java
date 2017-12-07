package vista;

import Clases.Tablero;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import vista.Eventos.BotonEntrarEventHandler;

public class ContenedorBienvenidos  extends VBox {
	
	 Stage stage;   
	public ContenedorBienvenidos(Stage stage, ContenedorPrincipal proximaEscena, Tablero tablero) {

	        super();

	        this.stage = stage;
	        
	        this.setAlignment(Pos.TOP_RIGHT);
	        this.setSpacing(10);
	        this.setPadding(new Insets(100));
	        Image imagen = new Image("file:src/vista/monopoly.png");
	        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.ROUND, BackgroundRepeat.ROUND, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
	        this.setBackground(new Background(imagenDeFondo));
	        

	        DropShadow ds = new DropShadow();
	        ds.setOffsetY(3.0f);
	        ds.setColor(Color.color(0.4f, 0.4f, 0.4f));
	        
	        
	        Label etiquetaJugador1 = new Label();
	        etiquetaJugador1.setText("Nombre Jugador1:");
	        etiquetaJugador1.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
	        etiquetaJugador1.setTextFill(Color.RED);
	        etiquetaJugador1.setEffect(ds);
	        TextField nombre1 = new TextField();
	        nombre1.setMaxWidth(150);
	        
	        Label etiquetaJugador2 = new Label();
	        etiquetaJugador2.setText("Nombre Jugador2:");
	        etiquetaJugador2.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
	        etiquetaJugador2.setTextFill(Color.RED);
	        etiquetaJugador2.setEffect(ds);
	        TextField nombre2 = new TextField();
	        nombre2.setMaxWidth(150);
	        
	        Label etiquetaJugador3 = new Label();
	        etiquetaJugador3.setText("Nombre Jugador3:");
	        etiquetaJugador3.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
	        etiquetaJugador3.setTextFill(Color.RED);
	        etiquetaJugador3.setEffect(ds);
	        TextField nombre3 = new TextField();
	        nombre3.setMaxWidth(150);
	        
	        
	        Button botonEntrar = new Button();
	        botonEntrar.setText("Entrar");
	        BotonEntrarEventHandler botonEntrarHandler = new BotonEntrarEventHandler(stage, proximaEscena,nombre1,nombre2,nombre3,tablero);
	        botonEntrar.setOnAction(botonEntrarHandler);
	        this.getChildren().addAll(etiquetaJugador1, nombre1, etiquetaJugador2, nombre2, etiquetaJugador3, nombre3,botonEntrar);
	       
	         
	    }	
	 

	
}
