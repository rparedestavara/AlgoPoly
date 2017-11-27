package Clases;

import javafx.scene.paint.Color;

public abstract class Casilla {
	protected Color color;
	String nombre;
	
	public Casilla(){
		color = Color.WHITE;
	}

	public Color getColor() {
		return color;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void entrar(Jugador jugador) {}
	
}
