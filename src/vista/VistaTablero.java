package vista;

import Clases.Tablero;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class VistaTablero {
    Image imagenTablero;
//	private Tablero tablero;
	Canvas canvas;
	
	public VistaTablero(Canvas canvas) {
//		this.tablero = Tablero.getInstancia();
		this.canvas = canvas;
		imagenTablero = new Image("file:src/vista/tablero.png");
	}
	
	public void actualizarTablero() {
		
		canvas.getGraphicsContext2D().drawImage(imagenTablero, 0, 0);
		canvas.getGraphicsContext2D().setFill(Color.RED);
		canvas.getGraphicsContext2D().fillOval(500, 250, 10, 10);
}

}