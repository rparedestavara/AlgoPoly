package TestConsignasPrimeraEntrega;



import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

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
import excepciones.SaldoInsuficienteException;


public class PrimeraEntregaIntegrationTest {

	@Test
	public void Test01Quini6AgregaDineroLaPrimeraVezQueElJugadorGana() {
		Jugador jugador=new Jugador();
		Casilla quini6= new Quini6();
		int dineroSinGanarQuini6 = jugador.getDinero();
		quini6.entrar(jugador);
		Assert.assertEquals(dineroSinGanarQuini6 + 50000, jugador.getDinero());
	}
	
	@Test
	public void Test02Quini6AgregaDineroLaSegundaVezQueElJugadorGana() {
		Jugador jugador=new Jugador();
		Casilla quini6= new Quini6();
		quini6.entrar(jugador);
		int dineroGanandoUnaVez = jugador.getDinero();
		quini6.entrar(jugador);
		Assert.assertEquals(30000, jugador.getDinero()-dineroGanandoUnaVez);
	}
	
	@Test
	public void Test03Quini6NoAgregaDineroAJugadorDesdeLaTerceraVezQueGana() {
		Jugador jugador=new Jugador();
		Casilla quini6= new Quini6();
		quini6.entrar(jugador);
		quini6.entrar(jugador);
		int dineroGanandoDosVeces = jugador.getDinero();
		quini6.entrar(jugador);
		Assert.assertEquals(dineroGanandoDosVeces, jugador.getDinero());
		quini6.entrar(jugador);
		Assert.assertEquals(dineroGanandoDosVeces, jugador.getDinero());
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
		carcel.aumentarTurno(jugador);
		carcel.aumentarTurno(jugador);
		jugador.pagarFianzaDeCarcel();
		Assert.assertTrue(jugador.puedeHacerAcciones());
	}
	
	@Test
	public void Test06JugadorNoPuedePagarFianzaEntoncesNoSePuedeMover(){
		Jugador jugador = new Jugador();
		Carcel carcel = Carcel.getInstancia();
		jugador.pagar(100000);
		carcel.entrar(jugador);
		carcel.aumentarTurno(jugador);
		carcel.aumentarTurno(jugador);
		carcel.aumentarTurno(jugador);
		try {
			jugador.pagarFianzaDeCarcel();
			Assert.fail("Jugador si puede pagar");
		}catch (SaldoInsuficienteException e) {}
		finally {
			Assert.assertFalse(jugador.puedeHacerAcciones());
		}
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
		int resultado=4;
		dados.setResultadoDados(resultado);
		jugador.setResultadoDados(dados.getResultado());
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
		int resultado=7;
		dados.setResultadoDados(resultado);
		jugador.setResultadoDados(dados.getResultado());
		avanceDinamico.entrar(jugador);
		Assert.assertEquals(100000%7,jugador.getDinero()%jugador.getResultadoDados()-posInicialJugador);
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
		int resultado=11;
		jugador.agregarPropiedad();
		jugador.agregarPropiedad();
		dados.setResultadoDados(resultado);
		jugador.setResultadoDados(dados.getResultado());
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
		dados.setResultadoDados(3);
		jugador.setResultadoDados(dados.getResultado());
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
		dados.setResultadoDados(9);
		jugador.setResultadoDados(dados.getResultado());
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
		dados.setResultadoDados(11);
		jugador.setResultadoDados(dados.getResultado());
		tablero.mover(jugador, dados.getResultado());
		retroceso.entrar(jugador);
		Assert.assertEquals(11-9,tablero.getPosicion(jugador));
	}
}
