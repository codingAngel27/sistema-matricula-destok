package entidad;

public class Curso implements Comparable<Curso>{
	// ATRIBUTOS PRIVADOS
	public int codCurso;
	public String asignatura;
	public int ciclo;
	public int creditos;
	public int horas;

	
	
	// MÉTODOS DE ACCESO GET/SET

	public Curso() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Curso(int codCurso, String asignatura, int ciclo, int creditos, int horas) {
		super();
		this.codCurso = codCurso;
		this.asignatura = asignatura;
		this.ciclo = ciclo;
		this.creditos = creditos;
		this.horas = horas;
	}

	public int getCodCurso() {
		return codCurso;
	}

	public void setCodCurso(int codCurso) {
		this.codCurso = codCurso;
	}

	public String getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}

	public int getCiclo() {
		return ciclo;
	}

	public void setCiclo(int ciclo) {
		this.ciclo = ciclo;
	}

	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	@Override
	public int compareTo(Curso o) {
		return String.valueOf(codCurso).compareTo(String.valueOf(o.codCurso));
	}

	// OPERACIONES PÚBLICAS
	public String getNombreCiclo() {
		switch (ciclo) {
		case 0: {
			return "Seleccione Ciclo...";	
		}
		case 1:{
			return "Primero";
		}
		case 2:{
			return "Segundo";
		}
		case 3:{
			return "Tercero";
		}
		case 4:{
			return "Cuarto";
		}
		case 5:{
			return "Quinto";
		}
		case 6: {
			return "Sexto";	
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + ciclo);
		}
		
		
	}
}
