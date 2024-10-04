package controlador;
import java.io.*;
import java.util.ArrayList;

import entidad.Alumno;
import entidad.Matricula;
public class ArregloMatriculas {
	private ArrayList<Matricula> matriculas;
	
	public ArregloMatriculas() {
		matriculas = new ArrayList <Matricula> ();
		cargarMatriculas();
	}
	public void adicionar(Matricula x) {
		matriculas.add(x);
	}
	public int tamanio() {
		return matriculas.size();
	}
	public Matricula obtener(int i) {
		return matriculas.get(i);
	}
	public Matricula buscar(int codigoMatricula) {
		for (int i=0; i<tamanio(); i++)
			if (obtener(i).getNumMatricula() == codigoMatricula)
				return obtener(i);
		return null;
	}
	public void eliminar(Matricula x) {
		matriculas.remove(x);
	}
	public void guardarMatricula() {
		try {
			PrintWriter pw;
			Matricula matri;
			String linea;
			
			pw=new PrintWriter(new File("matriculados.txt"));
		
			for(int i= 0 ; i<tamanio(); i++) {
				matri= obtener(i);
				
				linea = matri.getNumMatricula()+";"+
				        matri.getCodAlumno()+";"+
						matri.getCodCurso()+";"+
				        matri.getFecha()+";"+
						matri.getHora()+";";	
		
				pw.println(linea);
			}
		
			pw.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public Matricula buscarPorAlumnoYCurso(int codAlumno, int codCurso) {
	    for (int i = 0; i < tamanio(); i++) {
	        if (obtener(i).getCodAlumno() == codAlumno && obtener(i).getCodCurso() == codCurso) {
	            return obtener(i);
	        }
	    }
	    return null;
	}
	
	
	public void cargarMatriculas() {
	    try {
	    	BufferedReader br;
	    	String linea, fecha, hora;
	    	String[] s;
	    	int numMatricula, codAlumno, codCurso, estado;
	    	br = new BufferedReader(new FileReader("matriculados.txt"));
	    while((linea = br.readLine()) !=null) {
	    	s=linea.split(";");
	    	numMatricula= Integer.parseInt(s[0].trim());
	    	codAlumno = Integer.parseInt(s[1].trim());
	    	codCurso = Integer.parseInt(s[2].trim());
	    	fecha=s[3].trim();
	    	hora = s[4].trim();
	    	
	    	adicionar(new Matricula(numMatricula, codAlumno, codCurso, fecha, hora));
	    }
	    br.close();
     }
	    catch (Exception e) {	
	    }
	 }
	//  Operaciones públicas complementarias
	public int generarCodigo() {
		if(tamanio() == 0) {
			return 10001;
		}else {
			return obtener(tamanio()-1).getNumMatricula()+1;
		}
	}
	// METODO que busque NUMERO MATRICULA
		public Matricula buscarNumMatricula(int numeroMatricula) {
			for(int i = 0; i < tamanio(); i++) {
				if(obtener(i).getNumMatricula() == numeroMatricula)
					return obtener(i);
			}
			return null;
		}
		
		//M�todo buscar por c�digo
		/*	public Matricula buscarApellido (String ) {
				for(int i = 0; i < tamanio(); i++) {
					if(obtener(i).getApellidos().equals(apellido))
						return obtener(i);
				}
				return null;
			}*/
	
	public boolean procedeCodigoAlumno(int codigoAlumno) {
		for (int i=tamanio()-1; i>=0; i--)
			if (obtener(i).getCodAlumno() == codigoAlumno)
				if (obtener(i).getEstado() == 0)
					return false;
				else
					return true;
		return true;
	}
	public boolean procedeCodigoCurso(int codigoCurso) {
		for (int i=tamanio()-1; i>=0; i--)
			if (obtener(i).getCodCurso() == codigoCurso)
				if (obtener(i).getEstado() == 0)
					return false;
				else
					return true;
		return true;
	}
	//Se grega metodo para buscar matriculas por codigo de Alumno.
		public ArrayList<Matricula> buscarMatriculaXAlumno(int codigoAlumno) {
			ArrayList<Matricula> matriculasb = new ArrayList <Matricula> ();
			for (int i=0; i<tamanio(); i++) {
				if (obtener(i).getCodAlumno() == codigoAlumno)
				{
					matriculasb.add(obtener(i));
				}
			}		
			if(matriculasb.size()==0) {
				return null;
			}else {
				return matriculasb;	
			}
		}
		public ArrayList<Matricula> getMatriculas() {
	        return matriculas;
		}
		public boolean verificarCursoConAlumnos(int codCurso) {
		    for (int i = 0; i < tamanio(); i++) {
		        if (obtener(i).getCodCurso() == codCurso) {
		            return true;
		        }
		    }
		    return false;
		}
		
	
}