package vista;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class ContenedorDeBotonesJuego extends BorderPane  {
	
	public ContenedorDeBotonesJuego() {
	
		this.setBotonera();
	}

	private void setBotonera() {
		Button botonTirarDados = new Button("Tirar dados");
		
		VBox contenedorVertical = new VBox(botonTirarDados);
		contenedorVertical.setSpacing(10);
		contenedorVertical.setPadding(new Insets(15));
		this.setRight(contenedorVertical);
	}
}
