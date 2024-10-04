package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controlador.ArregloAlumnos;
import controlador.ArregloCurso;
import controlador.ArregloMatriculas;
import entidad.Alumno;
import entidad.Curso;
import entidad.Matricula;

public class FrmReportAlumn extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblTitle;
	private JComboBox cboReporte;
	private JButton btnBorrar;
	private JLabel lblNewLabel;
	private JTextArea txtA;
	private JScrollPane scrollPane;

	// inicializar arreglos

	ArregloAlumnos aL = new ArregloAlumnos();
	ArregloMatriculas aM = new ArregloMatriculas();
	ArregloCurso aC = new ArregloCurso();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmReportAlumn frame = new FrmReportAlumn();
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
	public FrmReportAlumn() {
		setTitle("REPORTES");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 707, 574);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 64, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);


		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblTitle = new JLabel("GENERAR REPORTES");
		lblTitle.setOpaque(true);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(new Color(0, 0, 0));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitle.setBackground(new Color(255, 255, 0));
		lblTitle.setBounds(0, 22, 691, 44);
		contentPane.add(lblTitle);

		cboReporte = new JComboBox();
		cboReporte.addActionListener(this);
		cboReporte.setBackground(new Color(255, 255, 255));
		cboReporte.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cboReporte.setModel(new DefaultComboBoxModel(
				new String[] { "Matricula Pendiente", "Matricula Vigente", "Matriculados por curso" }));
		cboReporte.setBounds(32, 115, 304, 27);
		contentPane.add(cboReporte);

		btnBorrar = new JButton("BORRAR");
		btnBorrar.addActionListener(this);
		btnBorrar.setIcon(new ImageIcon(FrmReportAlumn.class.getResource("/img/eliminar.png")));
		btnBorrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBorrar.setBounds(502, 113, 150, 32);
		contentPane.add(btnBorrar);

		lblNewLabel = new JLabel("Reportar");
		lblNewLabel.setIcon(new ImageIcon(FrmReportAlumn.class.getResource("/img/reporte.png")));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(342, 106, 137, 44);
		contentPane.add(lblNewLabel);

		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 178, 671, 346);
		contentPane.add(scrollPane);

		txtA = new JTextArea();
		scrollPane.setViewportView(txtA);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cboReporte) {
			actionPerformedCboReporte(e);
		}
		if (e.getSource() == btnBorrar) {
			actionPerformedBtnBorrar(e);
		}
	}

	protected void actionPerformedBtnBorrar(ActionEvent e) {
		txtA.setText("");
	}

	protected void actionPerformedCboReporte(ActionEvent e) {
		int lista = leerLista();
		switch (lista) {
		case 0:
			pendiente();
			break;
		case 1:
			vigente();
			break;
		default:
			matriculaCurso();
			break;
		}

	}

//MATRICULADO POR CURSO
	private void matriculaCurso() {
	    Matricula m;
	    Alumno a;
	    Curso c;
	    txtA.setText("");
	    
	    for (int i = 0; i < aM.tamanio(); i++) {
	        m = aM.obtener(i);
	        a = aL.buscar(m.getCodAlumno());
	        c = aC.buscar(m.getCodCurso());
	        
	        if (a == null) {
	            imprimir("Número de matrícula : " + m.getNumMatricula());
	            imprimir("Estudiante no encontrado.");
	            imprimir("Curso : " + c.getAsignatura());
	            imprimir("");
	            imprimir("-------------------------------------------------------------------------");
	        } else {
	            imprimir("Número de matrícula : " + m.getNumMatricula());
	            imprimir("Nombres : " + a.getNombres());
	            imprimir("Apellidos : " + a.getApellidos());
	            imprimir("Curso : " + c.getAsignatura());
	          
	            imprimir("-------------------------------------------------------------------------");
	        }
	    }
	}


	// MATRICULADA VIGENTE
	private void vigente() {
	    txtA.setText("");
	    boolean encont = false; 
	    
	    for (int i = 0; i < aL.tamanio(); i++) {
	        if (aL.obtener(i).getEstado() == 1) {
	            imprimir(" C\u00D3DIGO    : " + aL.obtener(i).getCodAlumno());
	            imprimir(" NOMBRES   : " + aL.obtener(i).getNombres());
	            imprimir(" APELLIDOS : " + aL.obtener(i).getApellidos());
	            imprimir(" DNI       : " + aL.obtener(i).getDni());
	            imprimir(" EDAD      : " + aL.obtener(i).getEdad());
	            imprimir(" CELULAR   : " + aL.obtener(i).getCelular());
	            imprimir(" ESTADO    : " + aL.obtener(i).getNombreEstado());
	            imprimir("-------------------------------------------------------------------------");
	            encont = true; // Se encontró al menos un alumno matriculado
	        }
	    }
	    
	    if (!encont) {
	        imprimir("No se encontraron alumnos matriculados.");
	    }
	}

	
	


	// MATRICULADA PENDIENTE
	private void pendiente() {
		Alumno ar;
		txtA.setText("");
		
		for (int i = 0; i < aL.tamanio(); i++) {
			ar = aL.obtener(i);
			if(ar !=null) {
			if (ar.getEstado() == 0) {
				imprimir("Codigo de Alumno : " + ar.getCodAlumno());
				imprimir("Nombres : " + ar.getNombres());
				imprimir("Apellidos : " + ar.getApellidos());
				imprimir("Dni : " + ar.getDni());
				imprimir("Edad : " + ar.getEdad());
				imprimir("Celular : " + ar.getCelular());
				imprimir("Estado : " + ar.getNombreEstado());
				
				imprimir("-------------------------------------------------------------------------");
			}
		}}

	}

	private int leerLista() {

		return cboReporte.getSelectedIndex();
	}

	void imprimir(String s) {
		txtA.append(s + "\n");
	}
}