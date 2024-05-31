package quemado;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class EquipoTests {
	
	@Test
	public void queAlCrearseNoTieneJugadores() {
		Equipo equipoRojo = new Equipo("Talleres");

		int valorEsperado = 0;
		int valorObtenido = equipoRojo.cantidadDeJugadores();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queSePuedenInscribirJugadores() {
		Equipo equipoRojo = new Equipo("Talleres");
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		
		equipoRojo.inscribirJugador(jugador1, 3);
		equipoRojo.inscribirJugador(jugador2, 4);
		int valorEsperado = 2;
		int valorObtenido = equipoRojo.cantidadDeJugadores();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	
	@Test
	public void queSePuedenInscribirDosJugadoresConElMismoNumeroDeCamisetaEnDosEquiposDiferentes() {
		Equipo equipoRojo = new Equipo("Talleres");
		Equipo equipoAzul = new Equipo("Barracas");
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		
		equipoRojo.inscribirJugador(jugador1, 10);
		equipoAzul.inscribirJugador(jugador2, 10);
		
		int valorEsperadoEquipoRojo = 1;
		int valorObtenidoEquipoRojo = equipoRojo.cantidadDeJugadores();
		assertEquals(valorEsperadoEquipoRojo, valorObtenidoEquipoRojo);
		
		int valorEsperadoEquipoAzul = 1;
		int valorObtenidoEquipoAzul = equipoRojo.cantidadDeJugadores();
		assertEquals(valorEsperadoEquipoAzul, valorObtenidoEquipoAzul);
	}
	
	
	@Test(expected = RuntimeException.class)
	public void queNoSePuedenInscribirDosJugadoresConElMismoNumeroDeCamisetaEnElMismoEquipo() {
		Equipo equipoRojo = new Equipo("Talleres");
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		
		equipoRojo.inscribirJugador(jugador1, 10);
		equipoRojo.inscribirJugador(jugador2, 10);
	}
	
	
	@Test(expected = RuntimeException.class)
	public void queNoSePuedeInscribirElMismoJugadorEnMasDeUnEquipoALaVez() {
		Equipo equipoRojo = new Equipo("Talleres");
		Equipo equipoAzul = new Equipo("Barracas");
		Jugador jugador1 = new Jugador();
		
		equipoRojo.inscribirJugador(jugador1, 10);
		equipoAzul.inscribirJugador(jugador1, 10);
	}
	
	
	@Test
	public void queSePuedeObtenerLaCantidadDeJugadoresQuemadosPorEquipo() {
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

		juegoQuemado.quemar(jugador1);
		juegoQuemado.quemar(jugador2);
		
		int valorEsperadoEquipo1 = 2;
		int valorObtenidoEquipo1 = equipo1.cantidadDeJugadoresQuemados();
		assertEquals(valorEsperadoEquipo1, valorObtenidoEquipo1);
		
		int valorEsperadoEquipo2 = 0;
		int valorObtenidoEquipo2 = equipo2.cantidadDeJugadoresQuemados();
		assertEquals(valorEsperadoEquipo2, valorObtenidoEquipo2);
	}

	@Test
	public void queSePuedenObtenerLosJugadoresQueAunNoHanSidoQuemados() {
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

		
		juegoQuemado.quemar(jugador1);
		juegoQuemado.quemar(jugador2);
		
		ArrayList<Jugador> listaJugadoresNoQuemadosDelEquipo1Esperada = new ArrayList<>();
		listaJugadoresNoQuemadosDelEquipo1Esperada.add(jugador3);
		ArrayList<Jugador> listaJugadoresNoQuemadosDelEquipo1Obtenida = equipo1.jugadoresAunNoQuemados();
				
		
		assertEquals(listaJugadoresNoQuemadosDelEquipo1Esperada, listaJugadoresNoQuemadosDelEquipo1Obtenida);
	}
}
