package Clases;

public class Direccion {
	private int posDirX;
	private int posDirY;
	private int[] direcciones = {1,0,-1,0};
	
	public Direccion() {
		posDirX = 0;
		posDirY = 1;
	}
	
	public int direccionActualX() {
		return direcciones[posDirX];
	}
	
	public int direccionActualY() {
		return direcciones[posDirY];
	}
	
	public void rotarDerecha() {
		if(posDirX == 3) posDirX = 0;
		else posDirX++;
		if(posDirY == 3) posDirY = 0;
		else posDirY++;
	}
}
