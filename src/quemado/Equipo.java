package quemado;
import java.util.ArrayList;
import java.util.Objects;

public class Equipo {
	private String nombre;
	private ArrayList<Jugador> jugadoresDelEquipo = new ArrayList<>();
	
	public Equipo(String nombre) {
		this.nombre = nombre;
	}
 
	
	public void inscribirJugador(Jugador jugadorAInscribir, Integer numeroDeCamiseta) {
		boolean numeroDeCamisetaOcupado = false;
		
		for(Jugador jugador :jugadoresDelEquipo) {
			if (jugador.numeroDeCamiseta() == numeroDeCamiseta) {
				numeroDeCamisetaOcupado = true;
			}
		}
		
		if (numeroDeCamisetaOcupado == true) {
			throw new RuntimeException("Numero de camiseta ocupado.");
		} else if (jugadorAInscribir.equipoEnElQueJuega() != null) {
			throw new RuntimeException("El jugador ya tiene equipo.");
		} else {
			jugadoresDelEquipo.add(jugadorAInscribir);
			jugadorAInscribir.establecerEquipo(this);
			jugadorAInscribir.establecerNumeroDeCamiseta(numeroDeCamiseta);
		}
	}

	
	public int cantidadDeJugadores() {
		return jugadoresDelEquipo.size();
	}
	
	
	public ArrayList<Jugador> jugadoresDelEquipo() {
		return jugadoresDelEquipo;
	}
	
	
	public int cantidadDeJugadoresQuemados() {
		int cantidadDeJugadoresQuemados = 0;
		
		for(Jugador jugador :jugadoresDelEquipo) {
			if (jugador.estadoQuemado() == true) {
				cantidadDeJugadoresQuemados += 1;
			}
		}
	
		return cantidadDeJugadoresQuemados;
	}
	
	
	public ArrayList<Jugador> jugadoresAunNoQuemados() {
		ArrayList<Jugador> jugadoresQuemados = new ArrayList<>();
		
		for(Jugador jugador :jugadoresDelEquipo) {
			if (!jugador.estadoQuemado()) {
				jugadoresQuemados.add(jugador);
			}
		}
		
		return jugadoresQuemados;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipo other = (Equipo) obj;
		return Objects.equals(nombre, other.nombre);
	}






	
}
