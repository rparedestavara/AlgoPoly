package vista;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import Clases.Casilla;
import Clases.Jugador;
import Clases.Tablero;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class VistaTablero {
	private Tablero tablero;
	Canvas canvas;
	private static final int CANTIDAD_CASILLAS = 20;
	
	public VistaTablero(Canvas canvas) {
		this.tablero = Tablero.getInstancia();
		this.canvas = canvas;
	}
	
	private void dibujarJugador(int pos,int x,int y) {
		int posIndividual = -15;
		Set<Jugador> jugadores = tablero.getJugadores();
		for(Jugador jugador : jugadores) {
			if(tablero.getPosicion(jugador) == pos) {
				canvas.getGraphicsContext2D().setFill(Color.BLACK);
				canvas.getGraphicsContext2D().fillOval(x + 50 + posIndividual, y + 53, 14, 14);
				canvas.getGraphicsContext2D().setFill(jugador.getColor());
				canvas.getGraphicsContext2D().fillOval(x + 52 + posIndividual, y + 55, 10, 10);
				posIndividual += 15;
			}
		}
	}
	
	public void actualizarTablero() {
		int posX;
		int posY;
		Casilla casilla;
		ArrayList<int[]> posicionesVista = tablero.getPosicionesVista();
		ArrayList<Casilla> casillasTablero = tablero.getCasillasTablero();
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		for(int i = 0; i < CANTIDAD_CASILLAS; i++ ) {
			posX = posicionesVista.get(i)[0];
			posY = posicionesVista.get(i)[1];
			casilla = casillasTablero.get(i);
			gc.setFill(Color.BLACK);
			gc.fillRect(posX, posY, 120, 120);
			gc.setFill(casilla.getColor());
			gc.fillRect(posX, posY, 118, 118);
			gc.setFont(Font.getDefault());
			gc.setFill(Color.BLACK);
			gc.fillText(casilla.getNombre(), posX + 40, posY + 40);
			dibujarJugador(i, posX, posY);
		}
}

}