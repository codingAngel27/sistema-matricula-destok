package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ArregloAlumnos;
import controlador.ArregloCurso;
import controlador.ArregloMatriculas;
import entidad.Alumno;
import entidad.Curso;
import entidad.Matricula;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;

public class frmAlumnosCursos extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnBorrar;
	private JTextArea txtS;
	private JScrollPane scrollPane;
	private JComboBox comboCodigo;
	private JTextField txtCodigo;
	private JButton btnConsultar;

	ArregloAlumnos arregloA = new ArregloAlumnos(); 
	ArregloMatriculas matriculaA = new ArregloMatriculas();
	ArregloCurso cursoA = new ArregloCurso();
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmAlumnosCursos frame = new frmAlumnosCursos();
					frame.setVisible(true);
					 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmAlumnosCursos() { 
		setTitle("CONSULTA");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 735, 589);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnBorrar = new JButton("LIMPIAR");
		btnBorrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				borrar();
				
			}
		});
		btnBorrar.setBounds(574, 97, 89, 23);
		contentPane.add(btnBorrar);
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 148, 688, 391);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setEditable(false);
		scrollPane.setViewportView(txtS);
		
		comboCodigo = new JComboBox();
		comboCodigo.addActionListener(this);
		comboCodigo.setBounds(22, 98, 141, 23);
		contentPane.add(comboCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(196, 98, 190, 22);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		btnConsultar = new JButton("CONSULTAR");
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(423, 97, 107, 23);
		contentPane.add(btnConsultar);
		
		lblNewLabel = new JLabel("CONSULTA DE ALUMNOS MATRICULADOS");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(255, 255, 0));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 26, 719, 50);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(frmAlumnosCursos.class.getResource("/img/fondo-azul-degradado.jpg")));
		lblNewLabel_1.setBounds(0, 1, 719, 549);
		contentPane.add(lblNewLabel_1);
		
		populateCombo();
	}
	
	public void borrar() {
		txtS.setText("");
	}
	
	public void populateCombo() {
		
		for (Alumno a : arregloA.getAlumnos()) {
			//System.out.println(a.getCodAlumno());
			comboCodigo.addItem(a.getCodAlumno());
		}
		
			
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(e);
		}
		if (e.getSource() == comboCodigo) {
			actionPerformedComboCodigo(e);
		}
	}
	protected void actionPerformedComboCodigo(ActionEvent e) {
		int codigoAlumno;
		codigoAlumno = Integer.parseInt(comboCodigo.getSelectedItem().toString());
		Alumno a;
		a = arregloA.buscar(codigoAlumno);
		
		txtCodigo.setText(a.getNombres()+" "+  a.getApellidos());
	}
	protected void actionPerformedBtnConsultar(ActionEvent e) {
		int codigoAlumno =  Integer.parseInt(comboCodigo.getSelectedItem().toString());
		Alumno a = arregloA.buscar(codigoAlumno);
		ArrayList<Matricula> am = matriculaA.buscarMatriculaXAlumno(a.codAlumno);
		//System.out.println(am.size());
		StringBuilder sb = new StringBuilder();
		sb.append("================================================== "+ "\n");
		sb.append(" Nombres                 : " + a.getNombres()+ "\n");
		sb.append(" Apellidos               : " + a.getApellidos()+ "\n");
		sb.append(" DNI                     : " + a.getDni()+ "\n");
		sb.append(" Edad                    : " + a.getEdad()+ "\n");
		sb.append(" Celular                 : " + a.getCelular()+ "\n");
		//sb.append("Estado del Alumno	    : " + a.getNombreEstado() + "\n");
		
		for (int i = 0; i < am.size(); i++) {
			Curso c = cursoA.buscar(am.get(i).getCodCurso());
			sb.append("================================================== "+ "\n");		
			sb.append(" Codigo Curso		: " + c.getCodCurso() + "\n");
			sb.append(" Asignatura		: " + c.getAsignatura() + "\n");
			sb.append(" Codigo Curso		: " + c.getNombreCiclo() + "\n");
			sb.append(" Codigo Curso		: " + c.getCreditos() + "\n");
			sb.append(" Codigo Curso		: " + c.getHoras() + "\n");
			sb.append("================================================== "+ "\n");
			sb.append(""+ "\n");
			
		}
		
		txtS.setText(sb.toString());

		
	}
	void imprimir(String s) {
		txtS.append(s + "\n");
	}
	
}
