package Clases;

public class BSNorte extends Provincia {

public BSNorte(){
	this.precioDeTerreno=25000;
	this.precioAlquiler=2500;
	this.precioDeConstruccionDeCasas=5500;
	this.precioDeConstruccionDeHotel=9000;
	this.costoPorHotel=5000;
}

public void entrar(Jugador jugador) {
	if(this.propietario==null) {
		this.propietario = jugador;
		this.propietario.modificarDinero(-this.precioDeTerreno);
	}
	else this.entroUnDesconocido(jugador);
}

public void entroUnDesconocido(Jugador jugadorDesconocido) {
	if(!EsPropietario(jugadorDesconocido) ) {
		this.residente=jugadorDesconocido;
		this.cobrar(this.residente);
	}
}

public void cobrar(Jugador residente2) {
	if(poseeUnaCasaEnAmbasProvincias()) this.residente.modificarDinero(-this.costoDeEntradaPorUnaCasa);
	if(poseeUnaCasaEnNorteYDosEnSur())this.residente.modificarDinero(-this.costoDeEntradaPorDosYUnaCasa);
	if(poseeUnHotel())this.residente.modificarDinero(-this.costoPorHotel);
}

public boolean poseeUnaCasaEnNorteYDosEnSur() {
	return this.cantCasas==2 && this.provinciaOpuesta.cantCasas==1;
}

}
