package entidad;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Retiro {
	private int numRetiro;
	private int numMatricula;
	private String fecha;
	private String hora;
	
	public Retiro() {
		
	}

	public Retiro(int numRetiro, int numMatricula, String fecha, String hora) {
		super();
		this.numRetiro = numRetiro;
		this.numMatricula = numMatricula;
		this.fecha = fecha;
		this.hora = hora;
	}
	public Retiro(int numRetiro, String fecha, String hora) {
		super();
		this.numRetiro = numRetiro;
		this.fecha = fecha;
		this.hora = hora;
	}
	public int getNumRetiro() {
		return numRetiro;
	}

	public void setNumRetiro(int numRetiro) {
		this.numRetiro = numRetiro;
	}

	public int getNumMatricula() {
		return numMatricula;
	}

	public void setNumMatricula(int numMatricula) {
		this.numMatricula = numMatricula;
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
	

}
