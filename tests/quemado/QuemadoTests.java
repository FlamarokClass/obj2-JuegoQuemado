package quemado;

import static org.junit.Assert.*;

import org.junit.Test;

public class QuemadoTests {
	
	@Test(expected = RuntimeException.class)
	public void queNoSePuedeEnfrentarElMismoEquipo() {
		Equipo equipo1 = new Equipo("Barracas");

		Quemado juegoQuemado = new Quemado(equipo1, equipo1);
	}
	
	@Test(expected = RuntimeException.class)
	public void queNoSePuedenEnfrentarEquiposConDiferenteCantidadDeJugadores() {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Jugador jugador3 = new Jugador();
		Jugador jugador4 = new Jugador();
		Jugador jugador5 = new Jugador();

		Equipo equipo1 = new Equipo("Barracas");
		Equipo equipo2 = new Equipo("Talleres");
		
		equipo1.inscribirJugador(jugador1, 10);
		equipo1.inscribirJugador(jugador2, 5);
		equipo1.inscribirJugador(jugador3, 7);
		
		equipo2.inscribirJugador(jugador4, 5);
		equipo2.inscribirJugador(jugador5, 15);
		
		Quemado juegoQuemado = new Quemado(equipo1, equipo2);
	}
	
	@Test(expected = RuntimeException.class)
	public void queLosEquiposNoPuedenEstarVacios() {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Equipo equipo1 = new Equipo("Barracas");
		Equipo equipo2 = new Equipo("Talleres");
		
		equipo1.inscribirJugador(jugador1, 10);
		equipo1.inscribirJugador(jugador2, 5);
		
		Quemado juegoQuemado = new Quemado(equipo1, equipo2);
	}
	 
	
	@Test
	public void queSePuedeQuemarUnJugador() {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Equipo equipo1 = new Equipo("Barracas");
		Equipo equipo2 = new Equipo("Talleres");
		
		equipo1.inscribirJugador(jugador1, 5);
		equipo2.inscribirJugador(jugador2, 7);
		
		Quemado juegoQuemado = new Quemado(equipo1, equipo2);
		
	
		juegoQuemado.quemar(jugador1);
		boolean valorEsperado = true;
		boolean valorObtenido = jugador1.estadoQuemado();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queMientrasNoEstenQuemadosTodosLosJugadoresDeUnEquipoElJuegoSigueEnCurso() {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Jugador jugador3 = new Jugador();
		Jugador jugador4 = new Jugador();
		Jugador jugador5 = new Jugador();
		Jugador jugador6 = new Jugador();

		Equipo equipo1 = new Equipo("Barracas");
		Equipo equipo2 = new Equipo("Talleres");
		
		equipo1.inscribirJugador(jugador1, 3);
		equipo1.inscribirJugador(jugador2, 4);
		equipo1.inscribirJugador(jugador3, 10);
		
		equipo2.inscribirJugador(jugador4, 1);
		equipo2.inscribirJugador(jugador5, 10);
		equipo2.inscribirJugador(jugador6, 9);
		
		Quemado juegoQuemado = new Quemado(equipo1, equipo2);

		//Se queman 2 de los 3 jugadores del equipo 2
		juegoQuemado.quemar(jugador4);
		juegoQuemado.quemar(jugador5);
		
		boolean valorEsperado = true;
		boolean valorObtenido = juegoQuemado.enCurso();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	
	@Test
	public void queAlQuemarATodosLosJugadoresDeUnEquipoElJuegoSeTermina() {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Jugador jugador3 = new Jugador();
		Jugador jugador4 = new Jugador();
		Jugador jugador5 = new Jugador();
		Jugador jugador6 = new Jugador();

		Equipo equipo1 = new Equipo("Barracas");
		Equipo equipo2 = new Equipo("Talleres");
		
		equipo1.inscribirJugador(jugador1, 3);
		equipo1.inscribirJugador(jugador2, 4);
		equipo1.inscribirJugador(jugador3, 10);
		
		equipo2.inscribirJugador(jugador4, 1);
		equipo2.inscribirJugador(jugador5, 10);
		equipo2.inscribirJugador(jugador6, 9);
		
		Quemado juegoQuemado = new Quemado(equipo1, equipo2);

		//Se queman 3 de los 3 jugadores del equipo 2
		juegoQuemado.quemar(jugador4);
		juegoQuemado.quemar(jugador5);
		juegoQuemado.quemar(jugador6);
		
		boolean valorEsperado = false;
		boolean valorObtenido = juegoQuemado.enCurso();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	
	@Test(expected = RuntimeException.class)
	public void queAlFinalizarElJuegoNoSePuedeQuemarNingunOtroJugador() {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Jugador jugador3 = new Jugador();
		Jugador jugador4 = new Jugador();
		Jugador jugador5 = new Jugador();
		Jugador jugador6 = new Jugador();

		Equipo equipo1 = new Equipo("Barracas");
		Equipo equipo2 = new Equipo("Talleres");
		
		equipo1.inscribirJugador(jugador1, 3);
		equipo1.inscribirJugador(jugador2, 4);
		equipo1.inscribirJugador(jugador3, 10);
		
		equipo2.inscribirJugador(jugador4, 1);
		equipo2.inscribirJugador(jugador5, 10);
		equipo2.inscribirJugador(jugador6, 9);
		
		Quemado juegoQuemado = new Quemado(equipo1, equipo2);

		//Se queman 3 de los 3 jugadores del equipo 2
		juegoQuemado.quemar(jugador4);
		juegoQuemado.quemar(jugador5);
		juegoQuemado.quemar(jugador6);
		
		juegoQuemado.quemar(jugador1);
	}
	
	
	@Test(expected = RuntimeException.class)
	public void queMientrasNoHayaFinalizadoElJuegoNoSePuedeObtenerUnGanador() {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Jugador jugador3 = new Jugador();
		Jugador jugador4 = new Jugador();
		Jugador jugador5 = new Jugador();
		Jugador jugador6 = new Jugador();

		Equipo equipo1 = new Equipo("Barracas");
		Equipo equipo2 = new Equipo("Talleres");
		
		equipo1.inscribirJugador(jugador1, 3);
		equipo1.inscribirJugador(jugador2, 4);
		equipo1.inscribirJugador(jugador3, 10);
		
		equipo2.inscribirJugador(jugador4, 1);
		equipo2.inscribirJugador(jugador5, 10);
		equipo2.inscribirJugador(jugador6, 9);
		
		Quemado juegoQuemado = new Quemado(equipo1, equipo2);

		//Se queman 2 de los 3 jugadores del equipo 2
		juegoQuemado.quemar(jugador4);
		juegoQuemado.quemar(jugador5);

		juegoQuemado.equipoGanador();
	}

	
	@Test
	public void queSiFinalizoElJuegoSePuedeObtenerElEquipoGanador() {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Jugador jugador3 = new Jugador();
		Jugador jugador4 = new Jugador();
		Jugador jugador5 = new Jugador();
		Jugador jugador6 = new Jugador();

		Equipo equipo1 = new Equipo("Barracas");
		Equipo equipo2 = new Equipo("Talleres");
		
		equipo1.inscribirJugador(jugador1, 3);
		equipo1.inscribirJugador(jugador2, 4);
		equipo1.inscribirJugador(jugador3, 10);
		
		equipo2.inscribirJugador(jugador4, 1);
		equipo2.inscribirJugador(jugador5, 10);
		equipo2.inscribirJugador(jugador6, 9);
		
		Quemado juegoQuemado = new Quemado(equipo1, equipo2);

		//Se queman 3 de los 3 jugadores del equipo 1
		juegoQuemado.quemar(jugador1);
		juegoQuemado.quemar(jugador2);
		juegoQuemado.quemar(jugador3);
		
		Equipo valorEsperado = equipo2;
		Equipo valorObtenido = juegoQuemado.equipoGanador();
		
		assertEquals(valorEsperado, valorObtenido);
	}
}
