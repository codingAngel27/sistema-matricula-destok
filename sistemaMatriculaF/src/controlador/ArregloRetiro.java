package controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import entidad.Matricula;
import entidad.Retiro;

public class ArregloRetiro {
	//atribuRetirovado
	private ArrayList<Retiro> arRetiro;
	//contructor
	public ArregloRetiro() {
		//
		arRetiro = new ArrayList<Retiro>();
		cargarRetiro();
	}
	//Metodo adicionar
	public void adicionar(Retiro a) {
		arRetiro.add(a);	
	}
	//Metodo Tamanio
	public int tamanio() {
		return arRetiro.size();
	}
	//metodo obtener
	public Retiro obtener(int pos) {
		return arRetiro.get(pos);
	}
	//metodo eliminar
	public void elminar(Retiro a) {
		arRetiro.remove(a);
	}
	//metodos adicionales
	
	public int generarCodigo() {
		if(tamanio()==0) {
			return 200001;
		} else {
			return obtener(tamanio()-1).getNumMatricula()+1;
		}
	}
	public void guardarRetiro() {
		try {
			PrintWriter pw;
			Retiro re;
			String linea;
			
			pw=new PrintWriter(new File("retiros"));
		
			for(int i= 0 ; i<tamanio(); i++) {
				re= obtener(i);
				
				linea = re.getNumRetiro()+";"+
				        re.getNumMatricula()+";"+
						re.getFecha()+";"+
				        re.getHora()+";";
				pw.println(linea);
			}
		
			pw.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	/*public Matricula buscarPorAlumnoYCurso(int codAlumno, int codCurso) {
	    for (int i = 0; i < tamanio(); i++) {
	        if (obtener(i).getCodAlumno() == codAlumno && obtener(i).getCodCurso() == codCurso) {
	            return obtener(i);
	        }
	    }
	    return null;
	}*/
	
	
	public void cargarRetiro() {
	    try {
	    	BufferedReader br;
	    	String linea, fecha, hora;
	    	String[] s;
	    	int numMatricula, numRetiro;
	    	br = new BufferedReader(new FileReader("retiros.txt"));
	    while((linea = br.readLine()) !=null) {
	    	s=linea.split(";");
	    	numRetiro= Integer.parseInt(s[0].trim());
	    	numMatricula = Integer.parseInt(s[1].trim());
	    	fecha=  s[2].trim();
	    	hora=s[3].trim();
	    	
	    	adicionar(new Retiro());
	    }
	    br.close();
     }
	    catch (Exception e) {	
	    }
	 }
}
