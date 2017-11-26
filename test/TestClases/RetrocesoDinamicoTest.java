package TestClases;



import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import Clases.Dados;
import Clases.Jugador;
import Clases.RetrocesoDinamico;
import Clases.Tablero;

public class RetrocesoDinamicoTest {

	@Test
	public void test01RetrocesoDinamicoConRango2a6YSinPropiedadesRetrocedeCorrectamente() {
		Jugador jugador = new Jugador();
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		Tablero tablero = Tablero.getInstancia();
		jugadores.add(jugador);
		tablero.agregarJugadores(jugadores);
		RetrocesoDinamico retroceso = new RetrocesoDinamico();
		Dados dados=Dados.getInstance();
		int[] resultados={1,2};
		dados.setResultados(resultados);
		tablero.mover(jugador, dados.getResultado());
		retroceso.entrar(jugador);
		Assert.assertEquals(0,tablero.getPosicion(jugador));
	}
	
	@Test
	public void test02RetrocesoDinamicoConRango2a6ConPropiedadesRetrocedeCorrectamente() {
		Jugador jugador = new Jugador();
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		Tablero tablero = Tablero.getInstancia();
		jugadores.add(jugador);
		tablero.agregarJugadores(jugadores);
		RetrocesoDinamico retroceso = new RetrocesoDinamico();
		jugador.agregarPropiedad();
		jugador.agregarPropiedad();
		Dados dados=Dados.getInstance();
		int[] resultados={1,2};
		dados.setResultados(resultados);
		tablero.mover(jugador, dados.getResultado());
		retroceso.entrar(jugador);
		Assert.assertEquals(3-1,tablero.getPosicion(jugador));
	}


	
	@Test
	public void test03RetrocesoDinamicoConRango7a10RetrocedeBien(){
		Jugador jugador = new Jugador();
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		Tablero tablero = Tablero.getInstancia();
		jugadores.add(jugador);
		tablero.agregarJugadores(jugadores);
		RetrocesoDinamico retroceso = new RetrocesoDinamico();
		jugador.agregarPropiedad();
		jugador.agregarPropiedad();
		Dados dados=Dados.getInstance();
		int[] resultados={4,5};
		dados.setResultados(resultados);
		tablero.mover(jugador, dados.getResultado());
		retroceso.entrar(jugador);
		Assert.assertEquals(9-10000%9,tablero.getPosicion(jugador));
	}
	
	@Test
	public void test04RetrocesoDinamicoCon11o12RetrocedeBien(){
		Jugador jugador = new Jugador();
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		Tablero tablero = Tablero.getInstancia();
		jugadores.add(jugador);
		tablero.agregarJugadores(jugadores);
		RetrocesoDinamico retroceso = new RetrocesoDinamico();
		jugador.agregarPropiedad();
		jugador.agregarPropiedad();
		Dados dados=Dados.getInstance();
		int[] resultados={5,6};
		dados.setResultados(resultados);
		tablero.mover(jugador, dados.getResultado());
		retroceso.entrar(jugador);
		Assert.assertEquals(11-9,tablero.getPosicion(jugador));
	}

}
