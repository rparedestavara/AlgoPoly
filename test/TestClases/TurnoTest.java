package TestClases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import Clases.Dados;
import Clases.Jugador;
import Clases.Turno;

public class TurnoTest {

	@Test
	public void test01ProximoTurnoDevuelveLosTurnosCorrespondientes() {
		Dados dados = Dados.getInstance();
		int[] resultados={2,3};
		dados.setResultados(resultados);
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Jugador jugador3 = new Jugador();
		List<Jugador> jugadores = Arrays.asList(jugador1,jugador2,jugador3);
		Turno turno = new Turno(jugadores);
		ArrayList<Jugador> jugadoresEnTurno = new ArrayList<Jugador>();
		jugadoresEnTurno.add(turno.proximoTurno());
		jugadoresEnTurno.add(turno.proximoTurno());
		jugadoresEnTurno.add(turno.proximoTurno());
		Assert.assertEquals(jugadoresEnTurno.get(0), turno.proximoTurno());
		Assert.assertEquals(jugadoresEnTurno.get(1), turno.proximoTurno());
		Assert.assertEquals(jugadoresEnTurno.get(2), turno.proximoTurno());
		Assert.assertEquals(jugadoresEnTurno.get(0), turno.proximoTurno());
	}

}
