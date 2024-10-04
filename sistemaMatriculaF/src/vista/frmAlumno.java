package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import alertas.Alertas;
import controlador.ArregloAlumnos;
import entidad.Alumno;
import vista.DlgBuscarAlumno.BuscarListener;

import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;

public class frmAlumno extends JFrame implements ActionListener, BuscarListener, MouseListener, KeyListener {

	private JPanel contentPane;
	private JTextField textCelular;
	private JTextField textEdad;
	private JTextField textApellido;
	private JTextField textNombre;
	private JTextField textDni;
	private JTextField textCodigo;
	private JTable tblAlumnos;
	private JComboBox comboBoxEstado;
	private JScrollPane scrollPane;
	private DefaultTableModel modelo;
	private JButton btnBuscar;
	private JButton btnNuevo;
	private JButton btnEliminar;
	private JButton btnEditar;
	private JButton btnGuardar;

	private DlgBuscarAlumno dbus = new DlgBuscarAlumno();
//////instancias
	ArregloAlumnos arregloA = new ArregloAlumnos();
	Alumno claseA = new Alumno();
	Alertas aler = new Alertas();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmAlumno frame = new frmAlumno();
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
	public frmAlumno() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1007, 876);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		dbus.setBuscarListener(this);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("DNI :");
		lblNewLabel.setForeground(new Color(187, 227, 49));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel.setBounds(473, 106, 95, 39);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("APELLIDOS :");
		lblNewLabel_2.setForeground(new Color(187, 227, 49));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_2.setBounds(20, 170, 146, 31);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("EDAD  :");
		lblNewLabel_3.setForeground(new Color(187, 227, 49));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_3.setBounds(20, 226, 103, 39);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("CELULAR :");
		lblNewLabel_4.setForeground(new Color(187, 227, 49));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_4.setBounds(473, 165, 135, 36);
		contentPane.add(lblNewLabel_4);

		textCelular = new JTextField();
		textCelular.setBounds(639, 170, 200, 25);
		contentPane.add(textCelular);
		textCelular.setColumns(10);

		textEdad = new JTextField();
		textEdad.setBounds(175, 230, 130, 25);
		contentPane.add(textEdad);
		textEdad.setColumns(10);

		textApellido = new JTextField();
		textApellido.setBounds(176, 170, 200, 25);
		contentPane.add(textApellido);
		textApellido.setColumns(10);

		textNombre = new JTextField();
		textNombre.setBounds(176, 117, 200, 25);
		contentPane.add(textNombre);
		textNombre.setColumns(10);

		textDni = new JTextField();
		textDni.setEditable(false);
		textDni.setBounds(639, 119, 200, 25);
		contentPane.add(textDni);
		textDni.setColumns(10);

		btnNuevo = new JButton("NUEVO");
		btnNuevo.setIcon(new ImageIcon(frmAlumno.class.getResource("/img/registroIcono.png")));
		btnNuevo.setBackground(new Color(255, 255, 255));
		btnNuevo.addActionListener(this);

		btnNuevo.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNuevo.setBounds(20, 295, 160, 40);
		contentPane.add(btnNuevo);

		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(this);
		btnEliminar.setBackground(new Color(255, 255, 255));
		btnEliminar.setIcon(new ImageIcon(frmAlumno.class.getResource("/img/eliminar.png")));
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEliminar.setBounds(619, 295, 160, 40);
		contentPane.add(btnEliminar);

		btnEditar = new JButton("EDITAR");
		btnEditar.addActionListener(this);
		btnEditar.setBackground(new Color(255, 255, 255));
		btnEditar.setForeground(Color.BLACK);
		btnEditar.setIcon(new ImageIcon(frmAlumno.class.getResource("/img/editar.png")));
		btnEditar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEditar.setBounds(219, 295, 160, 40);
		contentPane.add(btnEditar);

		btnGuardar = new JButton("GUARDAR");
		btnGuardar.addActionListener(this);
		btnGuardar.setBackground(new Color(255, 255, 255));
		btnGuardar.setIcon(new ImageIcon(frmAlumno.class.getResource("/img/guardarIc.png")));
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGuardar.setBounds(815, 295, 160, 40);
		contentPane.add(btnGuardar);

		textCodigo = new JTextField();
		textCodigo.setEditable(false);
		textCodigo.setBounds(829, 36, 150, 25);
		contentPane.add(textCodigo);
		textCodigo.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("CÓDIGO");
		lblNewLabel_6.setForeground(new Color(187, 227, 49));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_6.setBounds(867, 11, 91, 28);
		contentPane.add(lblNewLabel_6);

		btnBuscar = new JButton("CONSULTAR");
		btnBuscar.setBackground(new Color(255, 255, 255));
		btnBuscar.setIcon(new ImageIcon(frmAlumno.class.getResource("/img/consultaIcono.png")));
		btnBuscar.addActionListener(this);
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBuscar.setBounds(421, 295, 160, 40);
		contentPane.add(btnBuscar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 353, 971, 473);
		contentPane.add(scrollPane);

		tblAlumnos = new JTable();
		tblAlumnos.addKeyListener(this);
		tblAlumnos.addMouseListener(this);
		tblAlumnos.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblAlumnos);

		modelo = new DefaultTableModel();
		modelo.addColumn("Código");
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellido");
		modelo.addColumn("DNI");
		modelo.addColumn("Edad");
		modelo.addColumn("Celular");
		modelo.addColumn("Estado");
		tblAlumnos.setModel(modelo);

		JLabel lblNewLabel_1 = new JLabel("NOMBRES :");
		lblNewLabel_1.setForeground(new Color(187, 227, 49));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_1.setBounds(20, 107, 146, 43);
		contentPane.add(lblNewLabel_1);

		comboBoxEstado = new JComboBox();
		comboBoxEstado.setModel(new DefaultComboBoxModel(new String[] { "Registrado", "Matriculado", "Retirado" }));
		comboBoxEstado.setBounds(639, 230, 195, 25);
		contentPane.add(comboBoxEstado);

		JLabel lblNewLabel_5 = new JLabel("ESTADO :");
		lblNewLabel_5.setForeground(new Color(187, 227, 49));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_5.setBounds(473, 226, 95, 29);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_8 = new JLabel("MANTENIMIENTO ALUMNO");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 32));
		lblNewLabel_8.setForeground(new Color(255, 255, 255));
		lblNewLabel_8.setBounds(0, 31, 991, 42);
		contentPane.add(lblNewLabel_8);

		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setIcon(new ImageIcon(frmAlumno.class.getResource("/img/fondo-azul-degradado.jpg")));
		lblNewLabel_7.setBounds(0, 0, 993, 842);
		contentPane.add(lblNewLabel_7);

		listar(0);
		verDatos(0);
	}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	protected void actionPerformedBtnBuscar(ActionEvent event) {
		dbus.setVisible(true);
	}

	@Override
	public void buscarAlumno(String dato, int tipoConsulta) {
		modelo.setRowCount(0);
		for (int i = 0; i < arregloA.tamanio(); i++) {
			claseA = arregloA.obtener(i);
			if (tipoConsulta == 1) {
				if (String.valueOf(claseA.getCodAlumno()).startsWith(dato)) {
					Object fila[] = { claseA.getCodAlumno(), claseA.getNombres(), claseA.getApellidos(),
							claseA.getDni(), claseA.getEdad(), claseA.getCelular(), claseA.getNombreEstado() };
					modelo.addRow(fila);
				}
			} else {
				if (claseA.getDni().startsWith(dato)) {
					Object fila[] = { claseA.getCodAlumno(), claseA.getNombres(), claseA.getApellidos(),
							claseA.getDni(), claseA.getEdad(), claseA.getCelular(), claseA.getNombreEstado() };
					modelo.addRow(fila);
				}
			}
		}
		if (modelo.getRowCount() == 0) {
/////
			Alertas.AlertaError("No se encontro Alumno");
		} else {
			habilitarEntradas(false);
		}
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	protected void actionPerformedBtnEditar(ActionEvent event) {
		if (arregloA.tamanio() > 0) {
			if (btnEditar.getForeground() == Color.BLACK) {
				btnEditar.setForeground(Color.BLUE);
				btnBuscar.setForeground(Color.BLACK);
				btnEliminar.setForeground(Color.BLACK);
				btnGuardar.setForeground(Color.BLACK);
				btnNuevo.setForeground(Color.BLACK);
				editarFilar();

				habilitarEntradas(true);
				textNombre.requestFocus();
			} else {

				editarFilar();

			}
			btnEditar.setForeground(Color.BLACK);
		}
	}

/////para que mande los datos a los campos 
	private void editarFilar() {
		if (arregloA.tamanio() == 0) {
			limpiar();
		} else {
			claseA = arregloA.obtener(tblAlumnos.getSelectedRow());
			textCodigo.setText("" + claseA.getCodAlumno());
			textNombre.setText("" + claseA.getNombres());
			textApellido.setText("" + claseA.getApellidos());
			textDni.setText("" + claseA.getDni());
			textEdad.setText("" + claseA.getEdad());
			textCelular.setText("" + claseA.getCelular());
			comboBoxEstado.setSelectedIndex(claseA.getEstado());
			textCodigo.setEditable(false);
			comboBoxEstado.setEnabled(true);

		}

	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	protected void actionPerformedBtnGuardar(ActionEvent event) {
		guardarDatos();
		habilitarEntradas(false);
		if (textDni.isEditable()) {
			limpiar();
			habilitarEntradas(false);
		}
	}

	private void listar(int posFila) {
		modelo.setRowCount(0);

		for (int i = 0; i < arregloA.tamanio(); i++) {
			Alumno claseA = arregloA.obtener(i);
			Object[] fila = { claseA.getCodAlumno(), claseA.getNombres(), claseA.getApellidos(), claseA.getDni(),
					claseA.getEdad(), claseA.getCelular(), claseA.getNombreEstado() };
			modelo.addRow(fila);
		}
		tblAlumnos.getSelectionModel().setSelectionInterval(posFila, posFila);
	}

	private void guardarDatos() {

		String nombre = leerNombre();
		String apellido = leerApellido();
		String dni = leerDni();
		int codigo = leerCodigo();
		int edad = leerEdad();
		int estado = leerEstado();
		int celular = leerCelular();

		if (nombre == null || apellido == null || dni == null || edad == -1 || celular == -1) {
			return;
		} else {
			Alumno claA = arregloA.buscarDni(dni);
			if (claA == null) {
				Alumno aluNuevo = new Alumno(codigo, nombre, apellido, dni, edad, celular, estado);
				arregloA.adicionar(aluNuevo);
				arregloA.guardarAlumno();
				JOptionPane.showMessageDialog(null, "Se Registro un Nuevo Alumno con código " + codigo);
				listar(0);

			} else if (!textDni.isEditable()) {
				claA.setApellidos(apellido);
				claA.setCelular(celular);
				claA.setNombres(nombre);
				claA.setEdad(edad);
				claA.setEstado(estado);
				arregloA.guardarAlumno();
				JOptionPane.showMessageDialog(null, "Se Guardaron cambios ");
				listar(0);
			} else {
				Alertas.AlertaError("DNI ya se encuentra registrado");
				textDni.requestFocus();
			}
		}
	}

///////////////// nuevo//////////////////////////////////////////////////////////////////////////////////////////

	protected void actionPerformedBtnNuevo(ActionEvent event) {

		alumnoNuevo();
		limpiar();

	}

	private void alumnoNuevo() {
		textCodigo.setText(arregloA.codigoCorrelativo() + "");
		textNombre.setText("");
		textApellido.setText("");
		textDni.setText("");
		textEdad.setText("");
		textCelular.setText("");
		textDni.setEditable(true);
		textNombre.setEditable(true);
		textApellido.setEditable(true);
		textEdad.setEditable(true);
		textCelular.setEditable(true);
		comboBoxEstado.setEnabled(true);

	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	protected void actionPerformedBtnEliminar(ActionEvent event) {
		eliminarAlumno();
		limpiar();

	}

	private void eliminarAlumno() {
	    int codigo = leerCodigo();
	    int estado = leerEstado();
	    String nomb = leerNombre();

	    Alumno alum = arregloA.buscar(codigo);
	    
	    if (estado == 0) {
	        int opcion = JOptionPane.showConfirmDialog(this, "Desea eliminar registro", "del Sistema",
	                JOptionPane.YES_NO_OPTION);
	        if (opcion == 0) {
	            arregloA.eliminar(alum);
	            JOptionPane.showMessageDialog(null, "Se Eliminó el Alumno " + nomb + " con código " + codigo);
	            arregloA.guardarAlumno();
	            listar(0);
	        }
	    } else if (estado == 2) {
	        JOptionPane.showMessageDialog(this, "La eliminación es física, se realizará previa coordinación.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
	    } else if (estado == 1) {
	        Alertas.AlertaError("No se puede eliminar porque el estudiante está matriculado");
	    }
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////

	void limpiar() {
		textCodigo.setText("" + arregloA.codigoCorrelativo());
		textNombre.setText("");
		textApellido.setText("");
		textCelular.setText("");
		textDni.setText("");
		textEdad.setText("");
		comboBoxEstado.setSelectedIndex(0);
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(event);
		}
		if (event.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(event);
		}
		if (event.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(event);
		}
		if (event.getSource() == btnEditar) {
			actionPerformedBtnEditar(event);
		}
		if (event.getSource() == btnGuardar) {
			actionPerformedBtnGuardar(event);
		}
	}

	private String leerDni() {
		String dni = null;
		if (textDni.getText().trim().matches("\\d{8}") == false) {
			Alertas.AlertaError("Error! Ingrese DNI valido");
			textDni.setText("");
			textDni.requestFocus();
		} else {
			dni = textDni.getText();
		}
		return dni;

	}

	private String leerNombre() {
		String nombre = null;
		if (textNombre.getText().trim().length() == 0) {
			Alertas.AlertaError("Ingresar el Nombre del Alumno");
			textNombre.requestFocus();
			nombre = null;
		} else {
			nombre = textNombre.getText();
		}

		return nombre;
	}

	private String leerApellido() {
		String apellido = null;
		if (textApellido.getText().trim().length() == 0) {
			Alertas.AlertaError("Ingresar el Nombre del Alumno");
			textApellido.setText("");
			textApellido.requestFocus();

			apellido = null;

		} else {
			apellido = textApellido.getText();
		}

		return apellido;

	}

	private int leerCodigo() {
		return Integer.parseInt(textCodigo.getText().trim());
	}

	private int leerEdad() {
		int edad = -1;
		edad = Integer.parseInt(textEdad.getText());
		return edad;
	}

	private int leerCelular() {
		int celular = -1;
		if (textCelular.getText().matches("\\d{9}") == false) {
			Alertas.AlertaError("Error! Ingrese número un número de 9 dígitos");

			textCelular.requestFocus();

		} else {
			celular = Integer.parseInt(textCelular.getText());
		}
		return celular;
	}

	private int leerEstado() {
		return comboBoxEstado.getSelectedIndex();
	}

	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s, "Informaci n", 0);
	}

	void error(String s, JTextField txt) {
		mensaje(s);
		txt.setText("");
		txt.requestFocus();
	}

	void habilitarEntradas(boolean editable) {
		textNombre.setEditable(editable);
		textApellido.setEditable(editable);
		textCelular.setEditable(editable);
		textEdad.setEditable(editable);
		comboBoxEstado.setEnabled(editable);
		textDni.setEditable(false);

	}

	private void verDatos(int posFila) {
		if (posFila != -1) {
			String codigo, nombre, apellido, dni, celular, edad, estado;

			codigo = tblAlumnos.getValueAt(posFila, 0).toString();
			nombre = tblAlumnos.getValueAt(posFila, 1).toString();
			apellido = tblAlumnos.getValueAt(posFila, 2).toString();
			dni = tblAlumnos.getValueAt(posFila, 3).toString();
			edad = tblAlumnos.getValueAt(posFila, 4).toString();
			celular = tblAlumnos.getValueAt(posFila, 5).toString();
			estado = tblAlumnos.getValueAt(posFila, 6).toString();

			textCodigo.setText(codigo);
			textNombre.setText(nombre);
			textApellido.setText(apellido);
			textDni.setText(dni);
			textEdad.setText(edad);
			textCelular.setText(celular);
			comboBoxEstado.setSelectedItem(estado);
			comboBoxEstado.setEnabled(false);

		}
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
		if (e.getSource() == tblAlumnos) {
			mouseReleasedTblAlumnos(e);
		}
	}

	protected void mouseReleasedTblAlumnos(MouseEvent e) {
		int posFila;
		posFila = tblAlumnos.getSelectedRow();
		verDatos(posFila);
	}

	public void keyPressed(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
		if (e.getSource() == tblAlumnos) {
			keyReleasedTblAlumnos(e);
		}
	}

	public void keyTyped(KeyEvent e) {
	}

	protected void keyReleasedTblAlumnos(KeyEvent e) {
		int posFila;
		posFila = tblAlumnos.getSelectedRow();
		verDatos(posFila);
	}
}
