package TestClases;



import java.util.ArrayList;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

import Clases.Jugador;
import Clases.RetrocesoDinamico;
import Clases.Tablero;

public class RetrocesoDinamicoTest {

	@Test
	public void test01RetrocesoDinamicoConRango2a6YSinPropiedadesRetrocedeCorrectamente() {
		Jugador jugador = new Jugador();
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		Tablero tablero = new Tablero(jugadores);
		jugador.setTablero(tablero);
		RetrocesoDinamico retrocesoDinamico = new RetrocesoDinamico();
		int propiedades = jugador.getCantidadDePropiedades();
		Random dados = new Random();
		int resultadoDados = 2 + dados.nextInt(5);
		jugador.setResultadoDados(resultadoDados);
		tablero.mover(jugador, resultadoDados);
		int posicionFinal = tablero.getPosicion(jugador);
		retrocesoDinamico.entrar(jugador);
		Assert.assertEquals((resultadoDados - propiedades), posicionFinal);
	}
	
	/*@Test
	public void test02RetrocesoDinamicoConRango2a6ConPropiedadesRetrocedeCorrectamente() {
		Jugador jugador = new Jugador();
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		Tablero tablero = new Tablero(jugadores);
		jugador.setTablero(tablero);
		jugador.agregarPropiedad();
		RetrocesoDinamico retrocesoDinamico = new RetrocesoDinamico();
		int posicionInicial = tablero.getPosicion(jugador);
		jugador.setResultadoDados(4);
		tablero.mover(jugador, 4);
		retrocesoDinamico.entrar(jugador);
		int posicionFinal = tablero.getPosicion(jugador);
		Assert.assertEquals(posicionInicial + jugador.getCantidadDePropiedades(), posicionFinal);
	}
	*/
	@Test
	public void test03RetrocesoDinamicoConRango7a10RetrocedeBien(){
		Jugador jugador = new Jugador();
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		Tablero tablero = new Tablero(jugadores);
		jugador.setTablero(tablero);
		RetrocesoDinamico retrocesoDinamico = new RetrocesoDinamico();
		int posicionInicial = tablero.getPosicion(jugador);
		jugador.setResultadoDados(9);
		tablero.mover(jugador, 9);
		retrocesoDinamico.entrar(jugador);
		int posicionFinal = tablero.getPosicion(jugador);
		int auxDeComparacion = jugador.getDinero() % jugador.getResultadoDados();
		Assert.assertEquals(auxDeComparacion, posicionFinal - posicionInicial);
	}
	
	@Test
	public void test04RetrocesoDinamicoCon11o12RetrocedeBien(){
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador1);
		jugadores.add(jugador2);
		Tablero tablero = new Tablero(jugadores);
		jugador1.setTablero(tablero);
		jugador2.setTablero(tablero);
		RetrocesoDinamico retrocesoDinamico = new RetrocesoDinamico();
		int posicionInicial1 = tablero.getPosicion(jugador1);
		int posicionInicial2 = tablero.getPosicion(jugador2);
		jugador1.setResultadoDados(12);
		jugador2.setResultadoDados(11);
		tablero.mover(jugador1, 12);
		tablero.mover(jugador2, 11);
		retrocesoDinamico.entrar(jugador1);
		retrocesoDinamico.entrar(jugador2);
		int posicionFinal01 = tablero.getPosicion(jugador1);
		int posicionFinal02 = tablero.getPosicion(jugador2);
		Assert.assertEquals(posicionInicial1 + 2, posicionFinal01);
		Assert.assertEquals(posicionInicial2 + 2, posicionFinal02);
	}

}
