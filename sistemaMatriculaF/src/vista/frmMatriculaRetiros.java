package vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import controlador.ArregloAlumnos;
import controlador.ArregloCurso;
import controlador.ArregloMatriculas;
import controlador.ArregloRetiro;
import entidad.Alumno;
import entidad.Matricula;
import entidad.Retiro;

public class frmMatriculaRetiros extends JFrame implements ActionListener, AncestorListener {

	private JPanel contentPane;
	private JComboBox<Integer> comboMatriRetiros;
	private JTextField textField;
	private JButton btnConsultar;
	private JScrollPane scrollPane;
	private JButton btnBorrar;

	ArregloAlumnos arregloB = new ArregloAlumnos();
	ArregloMatriculas matriculaB = new ArregloMatriculas();
	ArregloCurso cursoB = new ArregloCurso();
	ArregloRetiro retiroB = new ArregloRetiro();
	private JTextArea txtCodigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmMatriculaRetiros frame = new frmMatriculaRetiros();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmMatriculaRetiros() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 755, 549);
		contentPane = new JPanel();
		contentPane.addAncestorListener(this);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		comboMatriRetiros = new JComboBox<Integer>();
		comboMatriRetiros.addActionListener(this);
		comboMatriRetiros.setBounds(75, 31, 104, 22);
		contentPane.add(comboMatriRetiros);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(225, 32, 124, 20);
		contentPane.add(textField);

		btnConsultar = new JButton("CONSULTAR");
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(491, 31, 116, 23);
		contentPane.add(btnConsultar);

		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(28, 96, 701, 302);
		contentPane.add(scrollPane);

		txtCodigo = new JTextArea();
		scrollPane.setViewportView(txtCodigo);

		btnBorrar = new JButton("BORRAR");
		btnBorrar.setBounds(547, 426, 93, 23);
		contentPane.add(btnBorrar);

		populateCombo();
	}

	public void populateCombo() {

		for (Matricula a : matriculaB.getMatriculas()) {
			// System.out.println(a.getCodAlumno());
			comboMatriRetiros.addItem(a.getNumMatricula());
		}

	}

	public void borrar() {
		txtCodigo.setText("");
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(e);
		}
		if (e.getSource() == comboMatriRetiros) {
			actionPerformedComboMatriRetiros(e);
		}
	}

	protected void actionPerformedComboMatriRetiros(ActionEvent e) {

		 Integer codigoMatricula = (Integer) comboMatriRetiros.getSelectedItem();
	        if (codigoMatricula != null) {
	            // Buscar el alumno por el código de matrícula
	            Alumno a = arregloB.buscar(codigoMatricula);
	            
	            
	            if (a != null) {
	                txtCodigo.setText(a.getApellidos());
	                txtCodigo.setText(a.getNombres());
	                txtCodigo.setText(a.getDni());
	                txtCodigo.setText(a.getNombreEstado());
	                
	            } else {
	                txtCodigo.setText("Alumno no encontrado");
	                
	            }
	        }
	    }
	protected void actionPerformedBtnConsultar(ActionEvent e) {

	}

	public void ancestorAdded(AncestorEvent event) {
		if (event.getSource() == contentPane) {
			ancestorAddedContentPane(event);
		}
	}

	public void ancestorMoved(AncestorEvent event) {
	}

	public void ancestorRemoved(AncestorEvent event) {
	}

	protected void ancestorAddedContentPane(AncestorEvent event) {
		borrar();
	}
}