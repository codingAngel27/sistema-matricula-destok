package entidad;

public class Alumno {
	//ATRIBUTOS PRIVADOS
	public int codAlumno;
	public String nombres;
	public String apellidos;
	public String dni;
	public int edad;
	public int celular;
	public int estado;
	
	//CONSTRUCTORES
	
	public Alumno() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Alumno(int codAlumno, String nombres, String apellidos, String dni, int edad, int celular, int estado) {
		super();
		this.codAlumno = codAlumno;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.dni = dni;
		this.edad = edad;
		this.celular = celular;
		this.estado = estado;
	}
	//MÉTODOS DE ACCESO GET/SET

	public int getCodAlumno() {
		return codAlumno;
	}
	public void setCodAlumno(int codAlumno) {
		this.codAlumno = codAlumno;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public int getCelular() {
		return celular;
	}
	public void setCelular(int celular) {
		this.celular = celular;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
		
	
	//OPERACIONES PÚBLICAS
	
	public String getNombreEstado() {
		switch (estado) {
		case 0: {
			return "Registrado";
		}
		case 1: {
			return "Matriculado";
		}
		case 2: {
			return "Retirado";
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + estado);
		}
	}
}
