package controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

import entidad.Alumno;
import entidad.Curso;

public class ArregloCurso {
	
	private ArrayList<Curso>cur;

	public ArregloCurso() {
		cur = new ArrayList<Curso>();
		
		cargarCurso();
		
	}

	public void adicionar(Curso c) {
		cur.add(c);
	}
	public int tamanio() {
		return cur.size();
	}
	public Curso obtener(int i) {
		return cur.get(i);
	}
	public Curso buscar(int codCurso) {
		Curso c;
		for(int i = 0; i < tamanio(); i++) {
			c = obtener(i);
			if(c.getCodCurso()== codCurso)
				return c;
		}
		return null;
	}
	public void eliminar(Curso c) {
		cur.remove(c);
	}
	
	public void ordenar() {
		 Collections.sort(cur);
	}
	public void guardarCurso() {
		try {
			PrintWriter pw;
			Curso c;
			String linea;
			
			pw=new PrintWriter(new File("cursos.txt"));
		
			for(int i= 0 ; i< cur.size(); i++) {
				c= obtener(i);
				
				linea = c.getCodCurso()+";"+
				        c.getAsignatura()+";"+
						c.getCiclo()+";"+
				        c.getCreditos()+";"+
						c.getHoras()+";";
				        
		
				pw.println(linea);
			}
		
			pw.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void cargarCurso() {
		try {
			
			BufferedReader br;
			String linea,asig;
			int codCur,ciclo,creditos,hora;
			String [] sep;
			
			
			br = new BufferedReader(new FileReader("cursos.txt"));
			
		
			while ((linea = br.readLine())!=null) {
				
				sep = linea.split(";");
				
				codCur = Integer.parseInt(sep[0]);
				asig = sep[1];
				ciclo = Integer.parseInt(sep[2]);
				creditos = Integer.parseInt(sep[3]);
				hora= Integer.parseInt(sep[4]);
		
				cur.add(new Curso(codCur,asig,ciclo,creditos,hora));
					
			}
			
			br.close();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	public static String getAsignatura(String codigoSeleccionado) {
		 ArregloCurso arregloPacientes = new ArregloCurso();
		    Curso paciente = arregloPacientes.buscar(Integer.parseInt(codigoSeleccionado));
		    
		    if (paciente != null) {
		        return paciente.getAsignatura();
		    } else {
		        return "Asignatura no encontrado";
		    }
	}
}