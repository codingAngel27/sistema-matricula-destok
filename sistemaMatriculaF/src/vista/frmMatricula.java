package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

import alertas.Alertas;
import login.FrmLogin;

import javax.swing.JScrollPane;
import java.awt.TextField;
import javax.swing.DropMode;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import java.awt.ComponentOrientation;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import java.awt.Canvas;
import java.awt.Label;
import javax.swing.ImageIcon;
//import com.toedter.calendar.JDateChooser;

import controlador.ArregloAlumnos;
import controlador.ArregloCurso;
import controlador.ArregloMatriculas;
import entidad.Alumno;
import entidad.Curso;
import entidad.Matricula;
import libreria.Fecha;

import javax.swing.JRadioButton;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.UIManager;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.ButtonGroup;

public class frmMatricula extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField campoMatricula;
	private JButton btnSalir;
	private JButton btnMatricular;
	private JButton btnEliminar;
	private JButton btnModificar;
	private JTextField txtCodigoAlumno;
	private JTextField textField;
	private JButton btnConsultar;
	private JComboBox cbCodigoAlumno;
	private JButton btnAceptar;
	private JButton btnCancelar;
	public static JTextField txtCodigoCurso;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	private JTable tblMatriculas;
	private JScrollPane scrollPane;

	ArregloMatriculas arMatricula = new ArregloMatriculas();

	ArregloCurso arCurso = new ArregloCurso();
	ArregloAlumnos arAl = new ArregloAlumnos();
    Alumno a = new Alumno();
    Matricula claseM = new Matricula();
	DefaultTableModel model = new DefaultTableModel();

	Date fecha = new Date();

	SimpleDateFormat sdfFecha = new SimpleDateFormat("dd/MM/yyyy");
	SimpleDateFormat sdfHora = new SimpleDateFormat("hh:mm:ss");

	private JTextField txtCodigoAlum = new JTextField();
	public static JTextField txtCodCurso;
	private JLabel lblNewLabel_3;
	private JRadioButton rdCodigo;
	private JLabel lblNewLabel_4;
	private JButton btnBuscar;
	private JButton btnGuardar;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JRadioButton rdMatricula;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmMatricula frame = new frmMatricula();
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
	public frmMatricula() {

		setTitle("MATRICULA");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1009, 881);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.controlShadow);
		panel.setBounds(0, 0, 993, 842);
		contentPane.add(panel);
		panel.setLayout(null);

		btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
				btnAceptar.setEnabled(false);
				btnCancelar.setEnabled(false);
				cbCodigoAlumno.setEnabled(false);
				btnGuardar.setEnabled(false);
				btnMatricular.setEnabled(true);
				btnModificar.setEnabled(true);
				btnEliminar.setEnabled(false);
			}
		});

		btnBuscar = new JButton("BUSCAR");
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBuscar.setIcon(new ImageIcon(frmMatricula.class.getResource("/img/buscarMatricula.png")));
		btnBuscar.addActionListener(this);

		btnGuardar = new JButton("GUARDAR");
		btnGuardar.setEnabled(false);
		btnGuardar.addActionListener(this);

		lblNewLabel_6 = new JLabel("ASIGNATURA");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setForeground(Color.YELLOW);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_6.setBounds(478, 209, 249, 30);
		panel.add(lblNewLabel_6);

		lblNewLabel_5 = new JLabel("NOMBRES Y APELLIDOS");
		lblNewLabel_5.setForeground(Color.YELLOW);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_5.setBounds(501, 101, 230, 30);
		panel.add(lblNewLabel_5);
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnGuardar.setBounds(813, 162, 150, 29);
		panel.add(btnGuardar);
		btnBuscar.setBounds(229, 212, 170, 29);
		panel.add(btnBuscar);

		lblNewLabel_4 = new JLabel("MATRICULA ALUMNOS");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 30));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(-39, 2, 993, 40);
		panel.add(lblNewLabel_4);
		btnCancelar.setEnabled(false);
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCancelar.setBounds(813, 209, 150, 32);
		panel.add(btnCancelar);

		btnAceptar = new JButton("ACEPTAR");
		btnAceptar.addActionListener(this);

		btnAceptar.setEnabled(false);
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAceptar.setBounds(813, 113, 150, 32);
		panel.add(btnAceptar);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "CONSULTAS",
				TitledBorder.LEFT, TitledBorder.BELOW_TOP, null, new Color(0, 0, 0)));
		panel_1.setBackground(new Color(255, 215, 0));
		panel_1.setBounds(0, 387, 993, 109);
		panel.add(panel_1);

		rdCodigo = new JRadioButton("CÓDIGO ALUMNO");
		rdCodigo.setOpaque(false);
		rdCodigo.setForeground(Color.BLACK);
		rdCodigo.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdCodigo.setBounds(18, 47, 167, 32);
		panel_1.add(rdCodigo);

		rdMatricula = new JRadioButton("Nº. MATRICULA");
		rdMatricula.setBounds(215, 47, 157, 32);
		panel_1.add(rdMatricula);
		rdMatricula.setOpaque(false);
		rdMatricula.setForeground(Color.BLACK);
		rdMatricula.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonGroup.add(rdCodigo);
        buttonGroup.add(rdMatricula);
		

		textField = new JTextField();
		textField.setBounds(411, 49, 249, 32);
		panel_1.add(textField);
		textField.setColumns(10);

		btnConsultar = new JButton("CONSULTAR");
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(689, 43, 249, 40);
		panel_1.add(btnConsultar);
		btnConsultar.setIcon(new ImageIcon(frmMatricula.class.getResource("/img/consultaIcono.png")));
		btnConsultar.setPreferredSize(new Dimension(30, 30));
		btnConsultar.setIconTextGap(10);
		btnConsultar.setHorizontalAlignment(SwingConstants.LEFT);
		btnConsultar.setForeground(Color.BLUE);
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnConsultar.setBorderPainted(false);
		btnConsultar.setBackground(new Color(255, 250, 250));
		btnConsultar.setAlignmentY(0.0f);
		btnConsultar.setAlignmentX(1.0f);

		txtCodigoCurso = new JTextField();
		txtCodigoCurso.addActionListener(this);
		txtCodigoCurso.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtCodigoCurso.setEditable(false);
		txtCodigoCurso.setBounds(446, 250, 334, 32);
		panel.add(txtCodigoCurso);
		txtCodigoCurso.setColumns(10);

		txtCodigoAlumno = new JTextField();
		txtCodigoAlumno.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtCodigoAlumno.addActionListener(this);
		txtCodigoAlumno.setEditable(false);
		txtCodigoAlumno.setBounds(446, 157, 334, 32);
		panel.add(txtCodigoAlumno);
		txtCodigoAlumno.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("CODIGO CURSO");
		lblNewLabel_2.setForeground(new Color(255, 255, 0));
		lblNewLabel_2.setBounds(30, 211, 170, 30);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_1 = new JLabel("CODIGO ALUMNO");
		lblNewLabel_1.setForeground(Color.YELLOW);
		lblNewLabel_1.setBounds(30, 101, 170, 30);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));

		campoMatricula = new JTextField();
		campoMatricula.setFont(new Font("Tahoma", Font.BOLD, 12));
		campoMatricula.setEditable(false);
		campoMatricula.setBounds(783, 43, 200, 30);
		panel.add(campoMatricula);
		campoMatricula.setColumns(10);

		JLabel lblNewLabel = new JLabel("Nº. MATRICULA");
		lblNewLabel.setForeground(Color.CYAN);
		lblNewLabel.setBounds(801, 11, 162, 30);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));

		btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(this);
		btnSalir.setIconTextGap(10);
		btnSalir.setBackground(new Color(255, 255, 255));
		btnSalir.setBorderPainted(false);
		btnSalir.setForeground(Color.BLUE);
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSalir.setHorizontalAlignment(SwingConstants.LEFT);
		btnSalir.setIcon(new ImageIcon(frmMatricula.class.getResource("/img/salir.png")));
		btnSalir.setBounds(760, 324, 190, 40);
		panel.add(btnSalir);

		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setEnabled(false);
		btnEliminar.addActionListener(this);
		btnEliminar.setIconTextGap(10);
		btnEliminar.setHorizontalAlignment(SwingConstants.LEFT);
		btnEliminar.setBounds(524, 324, 190, 40);
		btnEliminar.setForeground(new Color(0, 0, 255));
		btnEliminar.setBackground(new Color(255, 250, 250));
		btnEliminar.setBorderPainted(false);
		btnEliminar.setBorder(new LineBorder(new Color(0, 0, 0), 12, true));
		btnEliminar.setIcon(new ImageIcon(frmMatricula.class.getResource("/img/eliminar.png")));
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel.add(btnEliminar);

		btnModificar = new JButton("MODIFICAR");
		btnModificar.setIconTextGap(10);
		btnModificar.setBounds(268, 324, 190, 40);
		btnModificar.setBorderPainted(false);
		btnModificar.setForeground(new Color(0, 0, 255));
		btnModificar.setBackground(new Color(255, 250, 250));
		btnModificar.setHorizontalAlignment(SwingConstants.LEFT);
		btnModificar.setIcon(new ImageIcon(frmMatricula.class.getResource("/img/editar.png")));
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnModificar.isEnabled()) {
					btnMatricular.setEnabled(false);
					btnAceptar.setEnabled(false);
					btnCancelar.setEnabled(true);
					cbCodigoAlumno.setEnabled(false);
					btnGuardar.setEnabled(true);
					btnEliminar.setEnabled(true);
				}
				
				modificarMatricula();
			}
		});
		panel.add(btnModificar);

		btnMatricular = new JButton("MATRICULAR");
		btnMatricular.setIconTextGap(10);
		btnMatricular.setBounds(30, 324, 190, 40);
		btnMatricular.setBorderPainted(false);
		btnMatricular.setBackground(new Color(255, 250, 250));
		btnMatricular.setForeground(new Color(0, 0, 255));
		btnMatricular.setHorizontalAlignment(SwingConstants.LEFT);
		btnMatricular.setIcon(new ImageIcon(frmMatricula.class.getResource("/img/registroIcono.png")));
		btnMatricular.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnMatricular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (btnMatricular.isEnabled()) {
					btnModificar.setEnabled(false);
					btnAceptar.setEnabled(true);
					btnCancelar.setEnabled(true);
					cbCodigoAlumno.setEnabled(true);
					btnEliminar.setEnabled(false);
				}
			}
		});
		panel.add(btnMatricular);
		colocarCodigosCurso();

		cbCodigoAlumno = new JComboBox();
		cbCodigoAlumno.setModel(new DefaultComboBoxModel(new String[] { "202010000" }));
		cbCodigoAlumno.addActionListener(this);
		cbCodigoAlumno.setEnabled(false);
		cbCodigoAlumno.setFont(new Font("Tahoma", Font.BOLD, 15));
		cbCodigoAlumno.setBounds(229, 101, 183, 32);
		panel.add(cbCodigoAlumno);
		// getContentPane().add(cbCodigoAlumno);
		colocarCodigosAlumno();

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 519, 971, 312);
		panel.add(scrollPane);

		tblMatriculas = new JTable();
		tblMatriculas.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblMatriculas);

		ImageIcon imageIcon = new ImageIcon(FrmLogin.class.getResource("/img/fondo-azul-degradado.jpg"));

		// Obtiene la imagen redimensionada
		Image image = imageIcon.getImage().getScaledInstance(842, 719, Image.SCALE_SMOOTH);

		// Crea un nuevo ImageIcon con la imagen redimensionadad
		ImageIcon resizedIcon = new ImageIcon(image);

		model.addColumn("Nº Matricula");
		model.addColumn("Código Alumno");
		model.addColumn("Código Curso");
		model.addColumn("Fecha");
		model.addColumn("Hora");

		tblMatriculas.setModel(model);

		txtCodigoAlum = new JTextField();
		txtCodigoAlum.setEditable(false);
		txtCodigoAlum.addActionListener(this);
		txtCodigoAlum.setBounds(229, 159, 183, 29);
		panel.add(txtCodigoAlum);
		txtCodigoAlum.setColumns(10);

		txtCodCurso = new JTextField();
		txtCodCurso.setEditable(false);
		txtCodCurso.addActionListener(this);
		txtCodCurso.setBounds(229, 250, 171, 32);
		panel.add(txtCodCurso);
		txtCodCurso.setColumns(10);

		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(frmMatricula.class.getResource("/img/fondo-azul-degradado.jpg")));
		lblNewLabel_3.setBounds(0, 0, 993, 842);
		panel.add(lblNewLabel_3);
		
		listar(0);
		campoMatricula.setText(arMatricula.generarCodigo() + "");
	}

	void colocarCodigosAlumno() {
		ArregloAlumnos al = new ArregloAlumnos();
		Alumno alum;
		for (int i = 0; i < al.tamanio(); i++) {
			alum = al.obtener(i);
			if (arMatricula.procedeCodigoAlumno(alum.getCodAlumno()))
				cbCodigoAlumno.addItem("" + alum.getCodAlumno());
		}
	}

	void colocarCodigosCurso() {
		ArregloCurso c = new ArregloCurso();

		for (int i = 0; i < c.tamanio(); i++) {
			Curso curso = c.obtener(i);
			int codigoCurso = curso.getCodCurso();

			if (arMatricula.procedeCodigoCurso(codigoCurso)) {
				// cbCodigoCurso.addItem("" + codigoCurso);

			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSalir) {
			actionPerformedBtnSalir(e);
		}
		if (e.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(e);
		}
		if (e.getSource() == btnGuardar) {
			actionPerformedBtnGuardar(e);
		}

		if (e.getSource() == btnBuscar) {
			actionPerformedBtnNewButton(e);
		}
		if (e.getSource() == txtCodCurso) {
			actionPerformedTxtCodCurso(e);
		}
		if (e.getSource() == txtCodigoAlum) {
			actionPerformedTxtCodigoAlum(e);
		}
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}

		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == cbCodigoAlumno) {
			actionPerformedCbCodigoAlumno(e);
		}
		if (e.getSource() == txtCodigoAlumno) {
			actionPerformedTxtCodigoAlumno(e);
		}
	}

	protected void actionPerformedTxtCodigoAlumno(ActionEvent e) {

	}

	protected void actionPerformedCbCodigoAlumno(ActionEvent e) {

		String codigoSeleccionado = cbCodigoAlumno.getSelectedItem().toString();
		String nombreCompleto = ArregloAlumnos.getNombres(codigoSeleccionado) + " "
				+ ArregloAlumnos.getApellidos(codigoSeleccionado);
		txtCodigoAlumno.setText("" + nombreCompleto);
		txtCodigoAlum.setText("" + cbCodigoAlumno.getSelectedItem());
	}

	protected void actionPerformedBtnEliminar(ActionEvent e) {
		eliminarMatricula();
		
		limpiar();
		btnEliminar.setEnabled(false);

	}

	protected void actionPerformedBtnAceptar(ActionEvent e) {
		procedeMatricula();
		
		limpiar();

	}
///////////////////////////////// BOTON MATRICULAR//////////////////////////////////////
	private void procedeMatricula() {
	    if (btnMatricular.isEnabled()) {
	        if (cbCodigoAlumno.getSelectedIndex() <= 0) {
	            JOptionPane.showMessageDialog(frmMatricula.this, "Ingrese el código Alumno o codigo curso.",
	                    "Error de selección", JOptionPane.ERROR_MESSAGE);
	        } else {
	            int codAlumno = leerCodigoAlumno();
	            int codCurso = leerCodigoCurso();

	            Alumno a = arAl.buscar(codAlumno);

	            if (a.getEstado() == 1) {
	                JOptionPane.showMessageDialog(frmMatricula.this, "El alumno ya está matriculado",
	                        "Error de matriculación", JOptionPane.ERROR_MESSAGE);
	                return;
	            }

	            Matricula matriculaExistente = arMatricula.buscarPorAlumnoYCurso(codAlumno, codCurso);

	            if (matriculaExistente != null) {
	                JOptionPane.showMessageDialog(frmMatricula.this, "El alumno ya está matriculado en este curso.",
	                        "Error de matriculación", JOptionPane.ERROR_MESSAGE);
	                return;
	            }

	            int numMatricula = arMatricula.generarCodigo();

	            Matricula matriculaNuevo = new Matricula(numMatricula, codAlumno, codCurso, Fecha.fechaActual(),
	                    Fecha.horaActual());
	            arMatricula.adicionar(matriculaNuevo);

	            // Actualizar el estado del Alumno cambiar registrado a matriculado
	            a.setEstado(1);
	            arAl.guardarAlumno();

	            arMatricula.guardarMatricula();
	            campoMatricula.setText(arMatricula.generarCodigo() + "");
	            listar(0);

	            JOptionPane.showMessageDialog(null, "Alumno con codigo " + codAlumno + " Matriculado correctamente en el curso " + codCurso 
	            		);
	        }
	    }
	    btnAceptar.setEnabled(false);
	    btnCancelar.setEnabled(false);
	    cbCodigoAlumno.setEnabled(false);
	    btnMatricular.setEnabled(true);
	    btnModificar.setEnabled(true);
	}

	private int leerCodigoCurso() {
		int edad = -1;
		edad = Integer.parseInt(txtCodCurso.getText());
		return edad;
	}

	private int leerCodigoAlumno() {
		// TODO Auto-generated method stub
		return Integer.parseInt(txtCodigoAlum.getText().trim());
	}

	private int leerNumMatricula() {
		return Integer.parseInt(campoMatricula.getText().trim());
	}

	private void listar(int posFila) {
		model.setRowCount(0);

		for (int i = 0; i < arMatricula.tamanio(); i++) {
			Matricula matricular = arMatricula.obtener(i);
			Object[] fila = { matricular.getNumMatricula(), matricular.getCodAlumno(), matricular.getCodCurso(),
					Fecha.enTextoFecha(matricular.getFecha()), matricular.getHora() };
			model.addRow(fila);
		}
		tblMatriculas.getSelectionModel().setSelectionInterval(posFila, posFila);
	}

	protected void actionPerformedTxtCodigoAlum(ActionEvent e) {
	}

	protected void actionPerformedTxtCodCurso(ActionEvent e) {
	}

	protected void actionPerformedBtnNewButton(ActionEvent e) {
		DlgBuscarCurso02 venAl = new DlgBuscarCurso02();
		venAl.setVisible(true);
		venAl.setLocationRelativeTo(this);
	}

	private void limpiar() {
		cbCodigoAlumno.setSelectedIndex(0);
		txtCodigoAlum.setText("");
		txtCodigoAlumno.setText("");
		txtCodCurso.setText("");
		txtCodigoCurso.setText("");
		textField.setText("");
	}

	private void modificarMatricula() {
		if (arMatricula.tamanio() == 0) {
			limpiar();
		} else {
			int selectedRow = tblMatriculas.getSelectedRow();
			if (selectedRow >= 0 && selectedRow < arMatricula.tamanio()) {
				Matricula claseM = arMatricula.obtener(selectedRow);
				//Alumno al = arAl.obtener(selectedRow);
				//Curso cur = arCurso.obtener(selectedRow);
				campoMatricula.setText("" + claseM.getNumMatricula());
				//txtCodigoCurso.setText("" + cur.getAsignatura());
				txtCodigoAlum.setText("" + claseM.getCodAlumno());
				//txtCodigoAlumno.setText("" + al.getNombres());
				txtCodCurso.setText("" + claseM.getCodCurso());
			}
		}
	}

	private void guardarDatos() {
		int numMatricula = leerNumMatricula();
		int codigoAlumno = leerCodigoAlumno();
		int codigoCurso = leerCodigoCurso();

		if (codigoAlumno == -1 || codigoCurso == -1) {
			return;
		} else {
			Matricula claA = arMatricula.buscar(numMatricula);
			if (claA != null) {
				// Actualiza los valores de la instancia claA con los nuevos valores
				claA.setCodAlumno(codigoAlumno);
				claA.setCodCurso(codigoCurso);

				// Guarda los cambios en la estructura de datos y en almacenamiento persistente
				arMatricula.guardarMatricula();

				listar(0);
				JOptionPane.showMessageDialog(this, "Matricula" + numMatricula + " modificado exitosamente.", "Éxito",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				// Manejo para cuando no se encuentra la matrícula
			}
		}
	}

	protected void actionPerformedBtnGuardar(ActionEvent e) {
		guardarDatos();
		limpiar();
	}

private void eliminarMatricula() {
    int numMatricula;
    //int codAlumno = leerCodigoAlumno();
    // Entrada de datos
    numMatricula = leerNumMatricula();
    
    if (numMatricula== -1) {
        return; // Si el código es inválido, termina la función
    }

    // Validar si el código existe en el arreglo
    Matricula bot = arMatricula.buscar(numMatricula);
    if (bot != null) {
        // Ventana de confirmación
        int opcion = JOptionPane.showConfirmDialog(this, "¿Seguro de eliminar?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            arMatricula.eliminar(bot);
            listar(0);
            JOptionPane.showMessageDialog(this, "Matricula " + numMatricula + " eliminado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
         
			
			// Actualizar el estado del Alumno cambiar registrado a matriculado
            int codAlumno = leerCodigoAlumno();
    		Alumno a = arAl.buscar(codAlumno);
    		a.setEstado(0);
    		arAl.guardarAlumno();
			
            // Guardar los cambios en el archivo matriculados.txt
            arMatricula.guardarMatricula();
        }
    } else {
        JOptionPane.showMessageDialog(this, "El código no existe en la lista.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}


	private void consultar(int tipoConsulta, String dato) {

		model.setRowCount(0);
		
		for (int i = 0; i < arMatricula.tamanio(); i++) {
			claseM = arMatricula.obtener(i);

			if (tipoConsulta == 1) {
				if (String.valueOf(claseM.getCodAlumno()).startsWith(dato)) {
					Object fila[] = { claseM.getNumMatricula(), claseM.getCodAlumno(),claseM.getCodCurso(),Fecha.enTextoFecha(claseM.getFecha()), claseM.getHora() };
					model.addRow(fila);
				}

			}
			else {
			
				if ( String.valueOf(claseM.getNumMatricula()).startsWith(dato)) {
					Object fila[] = { claseM.getNumMatricula(),claseM.getCodAlumno(), claseM.getCodCurso(), Fecha.enTextoFecha(claseM.getFecha()), claseM.getHora()};
					model.addRow(fila);
				}
			}
		}

	}
	protected void actionPerformedBtnConsultar(ActionEvent e) {
		//
				int tipoConsulta = 0;
				String datoBuscar;

				// validar la selecci�n del tipo de consulta
				if (rdCodigo.isSelected() == true) {
					tipoConsulta = 1;
				}
				if (rdMatricula.isSelected() == true) {
					tipoConsulta = 2;
				}
				
				//Obtener el dato a buscar
				datoBuscar = getDatoBuscar();
				
				//Invocar el m�todo
				consultar(tipoConsulta, datoBuscar);
				
				textField.setText("");
				textField.requestFocus();
	}
	private void salir() {
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Realmente desea salir de la ventana?", "Confirmar Salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (respuesta == JOptionPane.YES_OPTION) {
            // Si el usuario selecciona "Sí", cerramos la ventana
            setVisible(false);
            
        } else {
        	//dispose();// Si el usuario selecciona "No", simplemente cerramos el cuadro de diálogo y la ventana seguirá abierta
        }	
	}	
	private String getDatoBuscar() {
		// TODO Auto-generated method stub
		return textField.getText();
	}
	protected void actionPerformedBtnSalir(ActionEvent e) {
		salir();
	}
}
