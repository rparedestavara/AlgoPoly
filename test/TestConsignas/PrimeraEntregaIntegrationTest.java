package TestConsignas;



import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import Clases.AlgoPoly;
import Clases.AvanceDinamico;
import Clases.Carcel;
import Clases.Casilla;
import Clases.Dados;
import Clases.Jugador;
import Clases.Policia;
import Clases.Quini6;
import Clases.RetrocesoDinamico;
import Clases.Tablero;
import excepciones.NoPuedeJugarException;


public class PrimeraEntregaIntegrationTest {
	private static final double DELTA = 1e-15;
	
	@Test
	public void Test01Quini6AgregaDineroLaPrimeraVezQueElJugadorGana() {
		Jugador jugador=new Jugador();
		Casilla quini6= new Quini6();
		double dineroSinGanarQuini6 = jugador.getDinero();
		quini6.entrar(jugador);
		Assert.assertEquals(dineroSinGanarQuini6 + 50000, jugador.getDinero(),DELTA);
	}
	
	@Test
	public void Test02Quini6AgregaDineroLaSegundaVezQueElJugadorGana() {
		Jugador jugador=new Jugador();
		Casilla quini6= new Quini6();
		quini6.entrar(jugador);
		double dineroGanandoUnaVez = jugador.getDinero();
		quini6.entrar(jugador);
		Assert.assertEquals(30000, jugador.getDinero()-dineroGanandoUnaVez,DELTA);
	}
	
	@Test
	public void Test03Quini6NoAgregaDineroAJugadorDesdeLaTerceraVezQueGana() {
		Jugador jugador=new Jugador();
		Casilla quini6= new Quini6();
		quini6.entrar(jugador);
		quini6.entrar(jugador);
		double dineroGanandoDosVeces = jugador.getDinero();
		quini6.entrar(jugador);
		Assert.assertEquals(dineroGanandoDosVeces, jugador.getDinero(),DELTA);
		quini6.entrar(jugador);
		Assert.assertEquals(dineroGanandoDosVeces, jugador.getDinero(),DELTA);
	}
	
	
	@Test
	public void Test04SiJugadorCaeEnUnaCarcelNoPuedeMoverse() {
		Jugador jugador = new Jugador();
		Carcel carcel = Carcel.getInstancia();
		Tablero tablero = Tablero.getInstancia();
		carcel.entrar(jugador);
		try {
			tablero.mover(jugador, 1);
			Assert.fail("Jugador esta en carcel, no se puede mover");
		}catch (NoPuedeJugarException e) {}
	}
	
	@Test
	public void Test05JugadorPagaFianzaYLuegoSePuedeMover(){
		Jugador jugador = new Jugador();
		Carcel carcel = Carcel.getInstancia();
		carcel.entrar(jugador);
		carcel.aumentarTurno(jugador);
		jugador.pagarFianzaDeCarcel();
		Assert.assertTrue(AlgoPoly.getInstancia().puedeHacerAcciones(jugador));
	}
	
	@Test
	public void Test06JugadorNoPuedePagarFianzaEntoncesNoSePuedeMover(){
		Jugador jugador = new Jugador();
		Carcel carcel = Carcel.getInstancia();
		jugador.modificarDinero(-100000);
		carcel.entrar(jugador);
		carcel.aumentarTurno(jugador);
		carcel.aumentarTurno(jugador);
		carcel.aumentarTurno(jugador);
		Assert.assertFalse(AlgoPoly.getInstancia().puedeHacerAcciones(jugador));
	}
	@Test
	public void Test07JugadorCaeEnPoliciaVaALaCarcelYNoPuedeMoverse(){
		Jugador jugador = new Jugador();
		Policia policia = Policia.getInstancia();
		policia.entrar(jugador);
		Carcel carcel = Carcel.getInstancia();
		Assert.assertTrue(carcel.enCarcel(jugador));
		try {
			Tablero.getInstancia().mover(jugador, 5);
			Assert.fail("El jugador se puede mover");
		}catch (NoPuedeJugarException e) {}
	}
	@Test 
	public void Test08jugadorSaca4YCaeEnAvanceDinamicoAvanceCorrectamente() {
		Jugador jugador= new Jugador();
		Tablero tablero=Tablero.getInstancia();
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		tablero.agregarJugadores(jugadores);
		AvanceDinamico avanceDinamico = new AvanceDinamico();
		Dados dados=Dados.getInstance();
		int posInicialJugador=tablero.getPosicion(jugador);
		int[] resultados={2,2};
		dados.setResultados(resultados);
		avanceDinamico.entrar(jugador);
		Assert.assertEquals(dados.getResultado()-2,(tablero.getPosicion(jugador)-posInicialJugador));
	}
	
	@Test
	public void Test09jugadorSaca7YCaeEnAvanceDinamicoAvanceCorrectamente() {
		Jugador jugador= new Jugador();
		Tablero tablero=Tablero.getInstancia();
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		tablero.agregarJugadores(jugadores);
		AvanceDinamico avanceDinamico = new AvanceDinamico();
		Dados dados=Dados.getInstance();
		int posInicialJugador=tablero.getPosicion(jugador);
		int[] resultados={4,3};
		dados.setResultados(resultados);
		avanceDinamico.entrar(jugador);
		Assert.assertEquals(100000%7,jugador.getDinero()%dados.getResultado()-posInicialJugador,DELTA);
	}
	
	@Test
	public void Test10jugadorSaca11YCaeEnAvanceDinamicoAvanceElNumeroSacadoMenosLaCantidadDeSusPropiedades() {
		Jugador jugador= new Jugador();
		Tablero tablero=Tablero.getInstancia();
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador);
		tablero.agregarJugadores(jugadores);
		AvanceDinamico avanceDinamico = new AvanceDinamico();
		Dados dados=Dados.getInstance();
		int posInicialJugador=tablero.getPosicion(jugador);
		jugador.agregarPropiedad();
		jugador.agregarPropiedad();
		int[] resultados={5,6};
		dados.setResultados(resultados);
		avanceDinamico.entrar(jugador);
		int resultadoFinal=tablero.getPosicion(jugador)-posInicialJugador;
		Assert.assertEquals(11-2,resultadoFinal);
	}
	
	@Test
	public void Test11jugadorSaca3YCaeEnRetrocesoDinamicoRetrocedaCorrectamente() {
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
	public void Test12jugadorSaca9YCaeEnRetrocesoDinamicoRetrocedeCorrectamente() {
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
	public void Test13jugadorSaca11YCaeEnRetrocesoDinamicoRetrocedeCorrectamente() {
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
