package quemado;

import java.util.Objects;

public class Jugador {
	private Integer numeroDeCamiseta;
	private Equipo equipoEnElQueJuega;
	private boolean estadoQuemado = false;
	
	public void establecerEquipo(Equipo equipo) {
		this.equipoEnElQueJuega = equipo;
	}
	
	public void establecerNumeroDeCamiseta(Integer numeroDeCamiseta) {
		this.numeroDeCamiseta = numeroDeCamiseta;
	}

	public Equipo equipoEnElQueJuega() {
		return equipoEnElQueJuega;
	}
	
	public int numeroDeCamiseta() {
		return numeroDeCamiseta;
	}

	public void quemarse() {
		estadoQuemado = true;
	}

	public boolean estadoQuemado() {
		return estadoQuemado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(equipoEnElQueJuega, numeroDeCamiseta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jugador other = (Jugador) obj;
		return Objects.equals(equipoEnElQueJuega, other.equipoEnElQueJuega) && Objects.equals(numeroDeCamiseta, other.numeroDeCamiseta);
	}
}
