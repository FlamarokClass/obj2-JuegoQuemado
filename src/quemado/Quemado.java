package quemado;

public class Quemado {
	private Equipo equipo1;
	private Equipo equipo2;
	private boolean enCurso = true;

	public Quemado(Equipo equipo1, Equipo equipo2) {
		if (equipo1 == equipo2) {
			throw new RuntimeException("No se puede enfrentar el mismo equipo.");
		} else if (equipo1.cantidadDeJugadores() != equipo2.cantidadDeJugadores()) {
			throw new RuntimeException("Equipos con cantidad desigual de jugadores.");
		} else if (equipo1.cantidadDeJugadores() == 0) {
			throw new RuntimeException("Los equipos deben tener al menos un jugador.");
		}
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
	}
	
	public boolean enCurso() {
		return enCurso;
	}

	public void quemar(Jugador jugador) {
		boolean todosLosJugadoresDelEquipoFueronQuemados = true;
		

		if (enCurso) {
			jugador.quemarse();
		} else {
			throw new RuntimeException("No se pueden quemar jugadores, el juego ya ha finalizado.");
		}
	

		for(Jugador jugadorDelEquipo :jugador.equipoEnElQueJuega().jugadoresDelEquipo()) {
			if (!jugadorDelEquipo.estadoQuemado()) {
				todosLosJugadoresDelEquipoFueronQuemados = false;
			}
		}
		
	
		if (todosLosJugadoresDelEquipoFueronQuemados) {
			enCurso = false;
		}
	}
	

	public Equipo equipoGanador() {
		Equipo equipoGanador = equipo1;
		
		if (!enCurso) {
			for(Jugador jugador :equipo2.jugadoresDelEquipo()) {
				if (jugador.estadoQuemado() == false) {
					equipoGanador = equipo2;
				}
			}
		} else {
			throw new RuntimeException("Todavía no hay un ganador, el juego sigue en curso.");
		}
		
		return equipoGanador;
	}
}
