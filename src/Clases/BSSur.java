package Clases;

public class BSSur extends Provincia {

public BSSur(){
	this.precioDeTerreno=23000;
	this.precioAlquiler=2000;
	this.precioDeConstruccionDeCasas=3250;
	this.precioDeConstruccionDeHotel=5500;
	this.cantCasas=0;
	}
public void entrar(Jugador jugador) {
	if(this.propietario==null) {
		this.propietario = jugador;
		this.propietario.modificarDinero(-this.precioDeTerreno);
	}
	else this.entroUnDesconocido(jugador);
}

public void entroUnDesconocido(Jugador jugadorDesconocido) {
	if(!EsPropietario(jugadorDesconocido) && propietarioPoseeCasasEnAmbasProvincias()) {
		this.residente=jugadorDesconocido;
		this.cobrar(this.residente);
	}
}
public void cobrar(Jugador residente2) {
	if(poseeUnaCasaEnAmbasProvincias()) this.residente.modificarDinero(-this.costoDeEntradaPorUnaCasa);
	if(poseeUnHotel())this.residente.modificarDinero(-this.costoPorHotel);
}

}
