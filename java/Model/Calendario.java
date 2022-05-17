package Model;

public class Calendario {

	private int numeroJornada;
	private String equipoLocal;
	private String equipoVisitante;
	private String fecha;
	private String hora;
	public int getNumeroJornada() {
		return numeroJornada;
	}
	public void setNumeroJornada(int numeroJornada) {
		this.numeroJornada = numeroJornada;
	}
	public String getEquipoLocal() {
		return equipoLocal;
	}
	public void setEquipoLocal(String equipoLocal) {
		this.equipoLocal = equipoLocal;
	}
	public String getEquipoVisitante() {
		return equipoVisitante;
	}
	public void setEquipoVisitante(String equipoVisitante) {
		this.equipoVisitante = equipoVisitante;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	@Override
	public String toString() {
		return "Calendario [numeroJornada=" + numeroJornada + ", equipoLocal=" + equipoLocal + ", equipoVisitante="
				+ equipoVisitante + ", fecha=" + fecha + ", hora=" + hora + "]";
	}
	
	
}
