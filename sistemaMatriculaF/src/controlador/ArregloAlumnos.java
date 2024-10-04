package controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import entidad.Alumno;

public class ArregloAlumnos {
	
	private ArrayList<Alumno>alum;
	
	public ArregloAlumnos() {
		alum = new ArrayList<Alumno>();
		cargarAlumno();
	}
	
	public void adicionar(Alumno al) {
		alum.add(al);
	}
	
	public ArrayList<Alumno> getAlumnos(){
        return alum;
    }
	public int tamanio() {
		return alum.size();
	}
	public Alumno obtener(int i) {
		return alum.get(i);
	}
	public Alumno buscar(int codAlumno) {
		Alumno al;
		for(int i = 0; i < tamanio(); i++) {
			al = obtener(i);
			if(al.getCodAlumno()== codAlumno)
				return al;
		}
		return null;
	}
	public Alumno buscarDni(String dni) {
		for(int i = 0; i<tamanio(); i++) {
			if(obtener(i).getDni().equals(dni))
				return obtener(i);
		}
		return null;
	}
	public void eliminar(Alumno al) {
		alum.remove(al); 
	}
	public int codigoCorrelativo() {
		if(tamanio()==0)
			return 202310001;
		else 
			return obtener(tamanio()-1).getCodAlumno()+1;
	}
	public void guardarAlumno() {
		try {
			PrintWriter pw;
			Alumno al;
			String linea;
			
			pw=new PrintWriter(new File("alumnos.txt"));
		
			for(int i= 0 ; i< alum.size(); i++) {
				al= obtener(i);
				
				linea = al.getCodAlumno()+";"+
				        al.getNombres()+";"+
						al.getApellidos()+";"+
				        al.getDni()+";"+
						al.getEdad()+";"+
				        al.getCelular()+";"+
						al.getEstado()+";";
		
				pw.println(linea);
			}
		
			pw.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void cargarAlumno() {
		try {
			
			BufferedReader br;
			String linea,nomb,ape,dni;
			int codAl,edad,estado,celular;
			String [] sep;
			
			
			br = new BufferedReader(new FileReader("alumnos.txt"));
			
		
			while ((linea = br.readLine())!=null) {
				
				sep = linea.split(";");
				
				codAl = Integer.parseInt(sep[0]);
				nomb = sep[1];
				ape = sep[2];
				dni = sep[3];
				edad = Integer.parseInt(sep[4]);
				celular = Integer.parseInt(sep[5]);
				estado = Integer.parseInt(sep[6]);
		
				alum.add(new Alumno(codAl,nomb,ape,dni,edad,celular,estado));
					
			}
			
			br.close();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public static String getNombres(String codigoSeleccionado) {
		 ArregloAlumnos arregloPacientes = new ArregloAlumnos();
		    Alumno paciente = arregloPacientes.buscar(Integer.parseInt(codigoSeleccionado));
		    
		    if (paciente != null) {
		        return paciente.getNombres();
		    } else {
		        return "Alumno no encontrado";
		    }
	}
	
	public static String getApellidos(String codigoSeleccionado) {
		 ArregloAlumnos arregloPacientes = new ArregloAlumnos();
		    Alumno paciente = arregloPacientes.buscar(Integer.parseInt(codigoSeleccionado));
		    
		    if (paciente != null) {
		        return paciente.getApellidos();
		    } else {
		        return "Alumno no encontrado";
		    }
	}

	public void setEstado(int i) {
		// TODO Auto-generated method stub
		
	}
	

	
}
