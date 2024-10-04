package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JDesktopPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import alertas.Alertas;
import controlador.ArregloCurso;
import controlador.ArregloMatriculas;
import entidad.Curso;
import entidad.Matricula;
import vista.DlgBuscarCurso.BuscarListener;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;

public class frmCurso extends JFrame implements ActionListener, MouseListener, KeyListener, BuscarListener {

	private JPanel contentPane;
	private JTextField textCodigo;
	private JTextField textNcredito;
	private JTextField textHoras;
	private JTable tblCurso;
	private JButton btnGuardad;
	private JButton btnEditar;
	private JButton btnAgregar;
	private JButton btnEliminar;
	private JTextField texAsignatura;
	private JComboBox comboBoxCiclo;
	private JScrollPane scrollPane;
	private DefaultTableModel modelo;

	private DlgBuscarCurso dbus = new DlgBuscarCurso();
	
	
	ArregloMatriculas arMatricula = new ArregloMatriculas();

	ArregloCurso arregloC = new ArregloCurso();
	Curso cur = new Curso();
	private JButton btnBuscar;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmCurso frame = new frmCurso();
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
	public frmCurso() {
		setTitle("Formulario curso");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 858, 769);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		dbus.setBuscarListener(this);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
				btnBuscar = new JButton("CONSULTAR");
				btnBuscar.addActionListener(this);
				
				lblNewLabel_8 = new JLabel("CONSULTAR CURSOS REGISTRADOS");
				lblNewLabel_8.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 22));
				lblNewLabel_8.setBounds(124, 308, 354, 40);
				contentPane.add(lblNewLabel_8);
				btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 11));
				btnBuscar.setBackground(new Color(255, 255, 255));
				btnBuscar.setIcon(new ImageIcon(frmCurso.class.getResource("/img/consultaIcono.png")));
				btnBuscar.setBounds(513, 308, 177, 40);
				contentPane.add(btnBuscar);
		
		lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setOpaque(true);
		lblNewLabel_7.setBackground(new Color(255, 215, 0));
		lblNewLabel_7.setBounds(0, 292, 842, 66);
		contentPane.add(lblNewLabel_7);

		JLabel lblNewLabel = new JLabel("CÓDIGO");
		lblNewLabel.setForeground(new Color(187, 227, 49));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel.setBounds(51, 84, 122, 25);
		contentPane.add(lblNewLabel);

		textCodigo = new JTextField();
		textCodigo.setEditable(false);
		textCodigo.setBounds(205, 84, 200, 25);
		contentPane.add(textCodigo);
		textCodigo.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("ASIGNATURA");
		lblNewLabel_1.setForeground(new Color(187, 227, 49));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_1.setBounds(51, 131, 162, 20);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("CICLO");
		lblNewLabel_2.setForeground(new Color(187, 227, 49));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_2.setBounds(463, 129, 75, 25);
		contentPane.add(lblNewLabel_2);

		textNcredito = new JTextField();
		textNcredito.setBounds(207, 187, 170, 25);
		contentPane.add(textNcredito);
		textNcredito.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("N° CREDITO");
		lblNewLabel_3.setForeground(new Color(187, 227, 49));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_3.setBounds(51, 185, 145, 20);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("HORAS");
		lblNewLabel_4.setForeground(new Color(187, 227, 49));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_4.setBounds(463, 183, 102, 25);
		contentPane.add(lblNewLabel_4);

		textHoras = new JTextField();
		textHoras.setBounds(580, 187, 170, 25);
		contentPane.add(textHoras);
		textHoras.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("MANTENIMIENTO CURSOS");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 30));
		lblNewLabel_5.setBounds(0, 23, 842, 50);
		contentPane.add(lblNewLabel_5);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 367, 822, 352);
		contentPane.add(scrollPane);

		tblCurso = new JTable();
		tblCurso.addKeyListener(this);
		tblCurso.addMouseListener(this);
		tblCurso.setModel(new DefaultTableModel());
		scrollPane.setViewportView(tblCurso);

		modelo = new DefaultTableModel();
		modelo.addColumn("Código");
		modelo.addColumn("Asignatura");
		modelo.addColumn("Ciclo");
		modelo.addColumn("Créditos");
		modelo.addColumn("Horas");
		tblCurso.setModel(modelo);

		btnEditar = new JButton("EDITAR");
		btnEditar.addActionListener(this);
		btnEditar.setBackground(new Color(255, 255, 255));
		btnEditar.setIcon(new ImageIcon(frmCurso.class.getResource("/img/editar.png")));
		btnEditar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEditar.setBounds(433, 241, 160, 40);
		contentPane.add(btnEditar);

		btnGuardad = new JButton("GUARDAR");
		btnGuardad.addActionListener(this);
		btnGuardad.setBackground(new Color(255, 255, 255));
		btnGuardad.setIcon(new ImageIcon(frmCurso.class.getResource("/img/guardarIc.png")));
		btnGuardad.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGuardad.setBounds(232, 241, 160, 40);
		contentPane.add(btnGuardad);

		btnAgregar = new JButton("AGREGAR");
		btnAgregar.addActionListener(this);
		btnAgregar.setBackground(new Color(255, 255, 255));
		btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAgregar.setIcon(new ImageIcon(frmCurso.class.getResource("/img/File_Add.png")));
		btnAgregar.setBounds(38, 241, 160, 40);
		contentPane.add(btnAgregar);

		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(this);
		btnEliminar.setBackground(new Color(255, 255, 255));
		btnEliminar.setIcon(new ImageIcon(frmCurso.class.getResource("/img/eliminar.png")));
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEliminar.setBounds(639, 241, 160, 40);
		contentPane.add(btnEliminar);

		texAsignatura = new JTextField();
		texAsignatura.setBounds(205, 133, 200, 25);
		contentPane.add(texAsignatura);
		texAsignatura.setColumns(10);

		comboBoxCiclo = new JComboBox();
		comboBoxCiclo.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboBoxCiclo.setModel(new DefaultComboBoxModel(new String[] {"SELECCIONAR...", "Primero", "Segundo", "Tercero", "Cuarto", "Quinto", "Sexto"}));
		comboBoxCiclo.setBounds(575, 132, 200, 25);
		contentPane.add(comboBoxCiclo);

		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setBackground(new Color(255, 255, 255));
		lblNewLabel_6.setIcon(new ImageIcon(frmCurso.class.getResource("/img/fondo-azul-degradado.jpg")));
		lblNewLabel_6.setBounds(0, 0, 842, 730);
		contentPane.add(lblNewLabel_6);

		listar(0);
		verDatos(0);
	}


	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminbar(e);
		}
		if (e.getSource() == btnAgregar) {
			actionPerformedBtnAgregar(e);
		}
		if (e.getSource() == btnEditar) {
			actionPerformedBtnEditar(e);
		}
		if (e.getSource() == btnGuardad) {
			actionPerformedBtnGuardar(e);
		}
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	protected void actionPerformedBtnGuardar(ActionEvent e) {
		guardarDatos();
		habilitarEntradas(false);
		if(textCodigo.isEditable())
		limpiar();
		habilitarEntradas(false);
	}
	
	private void guardarDatos() {

		String asignatura = leerAsignatura();
		int codigo = leercodigo();
		int horas = leerHoras();
		int nCreditos = leerCreditos();
		int ciclo = leerCiclo();

		if (asignatura == null || horas == 0 || nCreditos == -1 || codigo == -1) {
			return;
		} else {
			Curso crS = arregloC.buscar(codigo);
			if (crS == null) {
				Curso curNuevo = new Curso(codigo, asignatura, ciclo, nCreditos, horas);
				arregloC.adicionar(curNuevo);
				arregloC.guardarCurso();
				JOptionPane.showMessageDialog(null, "Se Registro un Nuevo Curso con código " + codigo);
				listar(0);

			} else if (!textCodigo.isEditable()) {
				crS.setAsignatura(asignatura);
				crS.setCiclo(ciclo);
				crS.setCreditos(nCreditos);
				crS.setHoras(horas);
				arregloC.guardarCurso();
				JOptionPane.showMessageDialog(null, "Se Guardaron cambios ");
				listar(0);
			} else {
				Alertas.AlertaError("Código ya se encuentra registrado");
				texAsignatura.requestFocus();
			}
		}
	}

////////////////////////////////////////////////////////////////////////////////////////////////////
	protected void actionPerformedBtnEditar(ActionEvent e) {
		editarFilar();
		habilitarEntradas(true);
	}
	
	private void editarFilar() {
		if (arregloC.tamanio() == 0) {
			limpiar();
		} else {
			cur = arregloC.obtener(tblCurso.getSelectedRow());
			textCodigo.setText("" + cur.getCodCurso());
			texAsignatura.setText("" + cur.getAsignatura());
			textHoras.setText("" + cur.getHoras());
			textNcredito.setText("" + cur.getCreditos());
			comboBoxCiclo.setSelectedIndex(cur.getCiclo());
			textCodigo.setEditable(false);
			comboBoxCiclo.setEditable(true);

		}

	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////	

	protected void actionPerformedBtnAgregar(ActionEvent e) {
		cursoNuevo();
	}
	
	private void cursoNuevo() {
		textCodigo.setText("");
		texAsignatura.setText("");
		textHoras.setText("");
		textNcredito.setText("");
		textCodigo.setEditable(true);
		texAsignatura.setEditable(true);
		textHoras.setEditable(true);
		textNcredito.setEditable(true);
		comboBoxCiclo.setEnabled(true);
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	protected void actionPerformedBtnEliminbar(ActionEvent e) {
		eliminarCurso();
		limpiar();
	}
	
	private void eliminarCurso() {
		
		if (arMatricula.verificarCursoConAlumnos(leercodigo())) {
			Alertas.AlertaError("No se puede Eliminar cursos porque existen alumnos inscritos");
			
			
		} else {
			int opcion = JOptionPane.showConfirmDialog(this, "Desea eliminar el Curso", "del Sistema",
					JOptionPane.YES_NO_OPTION);
			if (opcion ==0) {
				Curso curso = arregloC.buscar(leercodigo());
				arregloC.eliminar(curso);
				arregloC.guardarCurso();
				listar(0);			
				}
			
		}
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	protected void actionPerformedBtnBuscar(ActionEvent e) {
	     dbus.setVisible(true);
		}

		@Override
		public void buscarCurso(String dato, int tipoConsulta) {
			modelo.setRowCount(0);
			for (int i = 0; i < arregloC.tamanio(); i++) {
				cur = arregloC.obtener(i);
				if (tipoConsulta == 2) {
					if (String.valueOf(cur.getCodCurso()).startsWith(dato)) {
						Object fila[] = { cur.getCodCurso(), cur.getAsignatura(), cur.getNombreCiclo(), cur.getCreditos(),
								cur.getHoras() };
						modelo.addRow(fila);
					}
				} else {
					if (cur.getAsignatura().startsWith(dato)) {
						Object fila[] = { cur.getCodCurso(), cur.getAsignatura(), cur.getNombreCiclo(), cur.getCreditos(),
								cur.getHoras() };
						modelo.addRow(fila);
					}
				}
			}
			if (modelo.getRowCount() == 0) {
				Alertas.AlertaError("No se encontro Alumno");
			} else {
				habilitarEntradas(false);
			}

		}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
	
	private void listar(int posFila) {
		modelo.setRowCount(0);
		arregloC.ordenar();
		for (int i = 0; i < arregloC.tamanio(); i++) {
			Curso c = arregloC.obtener(i);
			Object[] fila = { c.getCodCurso(), c.getAsignatura(), c.getNombreCiclo(), c.getCreditos(), c.getHoras() };
			modelo.addRow(fila);
		}
		tblCurso.getSelectionModel().setSelectionInterval(posFila, posFila);
	}

	

	private void verDatos(int posFila) {
		if (posFila != -1 && tblCurso.getRowCount() > posFila) {

			String asignatura, ciclo ;
			int codigo, horas, nCreditos;

			codigo = Integer.parseInt(tblCurso.getValueAt(posFila, 0).toString());
			asignatura = tblCurso.getValueAt(posFila, 1).toString();
			ciclo = tblCurso.getValueAt(posFila, 2).toString();
			nCreditos = Integer.parseInt(tblCurso.getValueAt(posFila, 3).toString());
			horas = Integer.parseInt(tblCurso.getValueAt(posFila, 4).toString());

			textCodigo.setText("" + codigo);
			texAsignatura.setText(asignatura);
			comboBoxCiclo.setSelectedItem(ciclo);
			textNcredito.setText("" + nCreditos);
			textHoras.setText("" + horas);
			comboBoxCiclo.setEnabled(false);
			
		}

	}

	void habilitarEntradas(boolean editable) {
		texAsignatura.setEditable(editable);
	    textCodigo.setEditable(false);
		textHoras.setEditable(editable);
		textNcredito.setEditable(editable);
		comboBoxCiclo.setEnabled(editable);

	}

	
	private void limpiar() {
		textCodigo.setText("");
		texAsignatura.setText("");
		textHoras.setText("");
		textNcredito.setText("");

		comboBoxCiclo.setSelectedIndex(0);
	}

	private int leercodigo() {
		String codigo = textCodigo.getText().trim();
		if (codigo.matches("\\d{4}") == false) {
			Alertas.AlertaError("Error ! Ingrese un Código valido");
			textCodigo.requestFocus();
			return -1;
		}
		return Integer.parseInt(codigo);
	}

	private String leerAsignatura() {
		return texAsignatura.getText().trim();
	}

	private int leerCiclo() {
		return comboBoxCiclo.getSelectedIndex();
	}

	private int leerCreditos() {
		return Integer.parseInt(textNcredito.getText());
	}

	private int leerHoras() {
		return Integer.parseInt(textHoras.getText());
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
		if (e.getSource() == tblCurso) {
			mouseReleasedTblCurso(e);
		}
	}

	protected void mouseReleasedTblCurso(MouseEvent e) {
		int posFila;
		posFila = tblCurso.getSelectedRow();
		verDatos(posFila);
	}

	public void keyPressed(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
		if (e.getSource() == tblCurso) {
			keyReleasedTblCurso(e);
		}
	}

	public void keyTyped(KeyEvent e) {
	}

	protected void keyReleasedTblCurso(KeyEvent e) {
		int posFila;
		posFila = tblCurso.getSelectedRow();
		verDatos(posFila);
	}

}
