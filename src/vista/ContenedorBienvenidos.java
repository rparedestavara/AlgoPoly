package vista;

import Clases.Tablero;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
	        
	        this.setAlignment(Pos.TOP_CENTER);
	        this.setSpacing(20);
	        this.setPadding(new Insets(25));
	        Image imagen = new Image("file:src/vista/monopoly.png");
	        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.ROUND, BackgroundRepeat.ROUND, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
	        this.setBackground(new Background(imagenDeFondo));
	        
	        
	       

	        Label etiqueta = new Label();
	        etiqueta.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));

//	        etiqueta.setText("Bienvenidos a la Aplicacion AlgoPoly complete los datos y Presione Entrar para comenzar");
//	        etiqueta.setTextFill(Color.web("#66A7C5"));

	        
	        Button botonJugador1=new Button();
	        botonJugador1.setText("Nombre Jugador1:");
	        botonJugador1.setAlignment(Pos.CENTER);
	        TextField nombre1=new TextField();
	        
	        nombre1.setMaxWidth(150);
	        nombre1.setAlignment(Pos.CENTER_RIGHT);
	        
	        Button botonJugador2=new Button();
	        botonJugador2.setText("Nombre Jugador2:");
	        botonJugador2.setAlignment(Pos.CENTER);
	        TextField nombre2=new TextField();
	        nombre2.setMaxWidth(150);
	        nombre2.setAlignment(Pos.CENTER_RIGHT);
	        
	        Button botonJugador3=new Button();
	        botonJugador3.setText("Nombre Jugador3:");
	        botonJugador3.setAlignment(Pos.CENTER);
	        TextField nombre3=new TextField();
	        nombre3.setMaxWidth(150);
	        nombre3.setAlignment(Pos.CENTER_RIGHT);
	        
	        Button botonEntrar = new Button();
	        botonEntrar.setText("Entrar");
	        BotonEntrarEventHandler botonEntrarHandler = new BotonEntrarEventHandler(stage, proximaEscena,nombre1,nombre2,nombre3,tablero);
	        botonEntrar.setOnAction(botonEntrarHandler);
	        this.getChildren().addAll(etiqueta, botonJugador1,nombre1,botonJugador2,nombre2,botonJugador3,nombre3,botonEntrar);
	       
	         
	    }	
	 

	
}
