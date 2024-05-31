package quemado;

import static org.junit.Assert.*;

import org.junit.Test;

public class JugadorTests {
	
	@Test
	public void queSeEstableceSuEquipoAlInscribirloEnUno() {
		Equipo equipoRojo = new Equipo("Talleres");
		Jugador jugador1 = new Jugador();
		
		equipoRojo.inscribirJugador(jugador1, 3);
		Equipo valorEsperado = equipoRojo;
		Equipo valorObtenido = jugador1.equipoEnElQueJuega();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queAlCrearseSuEstadoDeQumadoEsFalso() {
		Jugador jugador1 = new Jugador();

		boolean valorEsperado = false;
		boolean valorObtenido = jugador1.estadoQuemado();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queAlQuemarseCambiaSuEstadoAQuemado() {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();

		Equipo equipo1 = new Equipo("Barracas");
		Equipo equipo2 = new Equipo("Talleres");
		
		equipo1.inscribirJugador(jugador1, 3);
		equipo2.inscribirJugador(jugador2, 1);
		
		Quemado juegoQuemado = new Quemado(equipo1, equipo2);
		

		
		juegoQuemado.quemar(jugador1);
		boolean valorEsperado = true;
		boolean valorObtenido = jugador1.estadoQuemado();
		
		assertEquals(valorEsperado, valorObtenido);
	}
}
