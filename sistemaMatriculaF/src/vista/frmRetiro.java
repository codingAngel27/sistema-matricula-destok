package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controlador.ArregloAlumnos;
import controlador.ArregloCurso;
import controlador.ArregloMatriculas;
import controlador.ArregloRetiro;
import entidad.Alumno;
import entidad.Matricula;
import entidad.Retiro;
import login.FrmLogin;
import javax.swing.DropMode;

public class frmRetiro extends JFrame implements ActionListener  {

	private JPanel contentPane;
	private JTextField campoCodRetiro;
	private JButton btnSalir;
	private JButton btnRetirar;
	private JButton btnLimiar;
	private JButton btnCancelar;
	private JTextField txtNomAlumno;
	private JTextField txtBuscar;
	private JButton btnConsultar;
	private JTextField txtDniAlumno;

	private JTable tblMatriculas;
	private JScrollPane scrollPane;
	
	ArregloRetiro arRetiro = new ArregloRetiro();
	ArregloMatriculas arMatricula = new ArregloMatriculas();
	
	ArregloCurso arCurso = new ArregloCurso();
	ArregloAlumnos arAl = new ArregloAlumnos();

	DefaultTableModel model = new DefaultTableModel();
	

	Date fecha = new Date();

	SimpleDateFormat sdfFecha = new SimpleDateFormat("dd/MM/yyyy");
	SimpleDateFormat sdfHora = new SimpleDateFormat("hh:mm:ss");
	
	private JTextField txtCodigoAlum = new JTextField();
	private JLabel lblfondoblue;
	private JLabel lblTitulo;
	private JTextField textCodAlumno;
	private JComboBox cbCodigoMatrcula;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmRetiro frame = new frmRetiro();
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
	public frmRetiro() {
		setTitle("RETIRO ALUMNO");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1009, 972);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.controlShadow);
		panel.setBounds(0, 0, 993, 842);
		contentPane.add(panel);
		panel.setLayout(null);

		cbCodigoMatrcula = new JComboBox();
		cbCodigoMatrcula.setEditable(true);
		cbCodigoMatrcula.setBounds(210, 236, 200, 32);
		cbCodigoMatrcula.addActionListener(this);
		cbCodigoMatrcula.setFont(new Font("Tahoma", Font.BOLD, 15));
		cbCodigoMatrcula.setModel(new DefaultComboBoxModel(new String[] {"0000"}));
		panel.add(cbCodigoMatrcula);
		
		textCodAlumno = new JTextField();
		textCodAlumno.setText("10001");
		textCodAlumno.setFont(new Font("Tahoma", Font.BOLD, 12));
		textCodAlumno.setEditable(false);
		textCodAlumno.setColumns(10);
		textCodAlumno.setBounds(210, 103, 200, 32);
		panel.add(textCodAlumno);
		
		lblTitulo = new JLabel("RETIRO ALUMNOS");
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 30));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(-39, 2, 953, 40);
		panel.add(lblTitulo);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "CONSULTAS", TitledBorder.LEFT, TitledBorder.BELOW_TOP, null, new Color(0, 0, 0)));
		panel_1.setBackground(new Color(255, 215, 0));
		panel_1.setBounds(0, 387, 993, 109);
		panel.add(panel_1);

		txtBuscar = new JTextField();
		txtBuscar.setBounds(411, 49, 249, 32);
		panel_1.add(txtBuscar);
		txtBuscar.setColumns(10);

		btnConsultar = new JButton("CONSULTAR");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultar();
			}
		});
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
		
		JLabel lblNewLabel_3 = new JLabel("CÓDIGO ALUMNO");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(227, 42, 174, 42);
		panel_1.add(lblNewLabel_3);

		txtDniAlumno = new JTextField();
		txtDniAlumno.addActionListener(this);
		txtDniAlumno.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtDniAlumno.setEditable(false);
		txtDniAlumno.setBounds(446, 146, 334, 32);
		panel.add(txtDniAlumno);
		txtDniAlumno.setColumns(10);

		txtNomAlumno = new JTextField();
		txtNomAlumno.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtNomAlumno.addActionListener(this);
		txtNomAlumno.setEditable(false);
		txtNomAlumno.setBounds(446, 103, 334, 32);
		panel.add(txtNomAlumno);
		txtNomAlumno.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("N° MATRICULA");
		lblNewLabel_2.setForeground(new Color(255, 255, 0));
		lblNewLabel_2.setBounds(30, 234, 206, 30);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(lblNewLabel_2);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("CODIGO ALUMNO");
		lblNewLabel_1.setForeground(Color.YELLOW);
		lblNewLabel_1.setBounds(30, 101, 170, 30);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));

		campoCodRetiro = new JTextField();
		campoCodRetiro.setFont(new Font("Tahoma", Font.BOLD, 12));
		campoCodRetiro.setEditable(false);
		campoCodRetiro.setBounds(783, 43, 200, 30);
		panel.add(campoCodRetiro);
		campoCodRetiro.setColumns(10);
		
		
		
		JLabel lblNewLabel = new JLabel("Nº. RETIRO");
		lblNewLabel.setForeground(Color.CYAN);
		lblNewLabel.setBounds(801, 11, 162, 30);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));

		btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salir();
			}
		});
		btnSalir.setIconTextGap(10);
		btnSalir.setBackground(new Color(255, 255, 255));
		btnSalir.setBorderPainted(false);
		btnSalir.setForeground(Color.BLUE);
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSalir.setHorizontalAlignment(SwingConstants.LEFT);
		btnSalir.setIcon(new ImageIcon(frmMatricula.class.getResource("/img/salir.png")));
		btnSalir.setBounds(760, 324, 190, 40);
		panel.add(btnSalir);

		btnLimiar = new JButton("LIMPIAR");
		btnLimiar.addActionListener(this);
		btnLimiar.setIconTextGap(10);
		btnLimiar.setHorizontalAlignment(SwingConstants.LEFT);
		btnLimiar.setBounds(524, 324, 190, 40);
		btnLimiar.setForeground(new Color(0, 0, 255));
		btnLimiar.setBackground(new Color(255, 250, 250));
		btnLimiar.setBorderPainted(false);
		btnLimiar.setBorder(new LineBorder(new Color(0, 0, 0), 12, true));
		btnLimiar.setIcon(new ImageIcon(frmMatricula.class.getResource("/img/eliminar.png")));
		btnLimiar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLimiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();				
			}
		});
		panel.add(btnLimiar);

		btnCancelar = new JButton("CANCELAR");
		btnCancelar.setIconTextGap(10);
		btnCancelar.setBounds(268, 324, 190, 40);
		btnCancelar.setBorderPainted(false);
		btnCancelar.setForeground(new Color(0, 0, 255));
		btnCancelar.setBackground(new Color(255, 250, 250));
		btnCancelar.setHorizontalAlignment(SwingConstants.LEFT);
		btnCancelar.setIcon(new ImageIcon(frmMatricula.class.getResource("/img/editar.png")));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			cancelar();				
			}
		});
		panel.add(btnCancelar);

		btnRetirar = new JButton("RETIRAR");
		btnRetirar.setIconTextGap(10);
		btnRetirar.setBounds(30, 324, 190, 40);
		btnRetirar.setBorderPainted(false);
		btnRetirar.setBackground(new Color(255, 250, 250));
		btnRetirar.setForeground(new Color(0, 0, 255));
		btnRetirar.setHorizontalAlignment(SwingConstants.LEFT);
		btnRetirar.setIcon(new ImageIcon(frmMatricula.class.getResource("/img/registroIcono.png")));
		btnRetirar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnRetirar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				retirar();
			}
				
		});
		panel.add(btnRetirar);

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

		model.addColumn("Nº Retiro");
		model.addColumn("N° Matricula");
		model.addColumn("Fecha");
		model.addColumn("Hora");
		
		tblMatriculas.setModel(model);
		
		lblfondoblue = new JLabel("");
		lblfondoblue.setIcon(new ImageIcon(frmMatricula.class.getResource("/img/fondo-azul-degradado.jpg")));
		lblfondoblue.setBounds(0, 0, 993, 842);
		panel.add(lblfondoblue);
		//guardarDatos();
		//listar(0);
		//campoCodRetiro.setText(arMatricula.generarCodigo() + "");
	}
	public void actionPerformed(ActionEvent e) {
		//eliminar();
	}
	//METODOS ADICIONALES
	
	private int leerNumMatricula() {
		return Integer.parseInt(campoCodRetiro.getText().trim());
	}
	
	//METODOS VOID
	//BOTON CONSULTAR
	private void consultar() {
		int codAlum=0;
		codAlum=Integer.parseInt(txtBuscar.getText());
		Alumno a = arAl.buscar(codAlum);
		ArrayList<Matricula> matriculasb =arMatricula.buscarMatriculaXAlumno(codAlum);
		textCodAlumno.setText(String.valueOf(codAlum));
		txtNomAlumno.setText(a.getNombres() + " " + a.getApellidos());
		txtDniAlumno.setText(a.getDni());
		//limpiar el comboBOx
		cbCodigoMatrcula.removeAllItems();
		//autogenerando codigo retiro 
		campoCodRetiro.setText(String.valueOf(arRetiro.generarCodigo()));
		if(matriculasb!= null) {
			for(int i =0; i<matriculasb.size();i++) {
				cbCodigoMatrcula.addItem(matriculasb.get(i).getNumMatricula());
			}
			//habilitamos el combobox de matricula
			cbCodigoMatrcula.setEnabled(true);
		}else {
			JOptionPane.showMessageDialog(frmRetiro.this, "Codigo de Alumno no encontrado como Matriculado.",
					"Error de selección", JOptionPane.ERROR_MESSAGE);
		}
		
		
	}
	//BOTON RETIRAR
	private void retirar() {
		int numRetiro, codAlum, codRetiro, codMatricula;
		String fecha, hora;
		//autogenerar codigo
		campoCodRetiro.setText(String.valueOf(arRetiro.generarCodigo()));
		numRetiro = getNumRetiro();
		fecha= getFecha();
		hora= getHora();
		codMatricula=(int)cbCodigoMatrcula.getSelectedItem();
		//instanciar el retiro
		Retiro m = new  Retiro(numRetiro,codMatricula,fecha,hora);
		//llamar a la variable local
		codAlum= getCodAlumno();
		//Desactive temporalmente una matrícula fijando el estado del alumno en 2 (retirado)
		arAl.buscar(codAlum).setEstado(2);//retirado = 2
		arAl.guardarAlumno();
		arRetiro.adicionar(m);
		codRetiro=arRetiro.generarCodigo();
		campoCodRetiro.setText(String.valueOf(codRetiro));
		listar();
		
	}
	//BOTON MODIFICAR
	void cancelar() {
		int numRetiro, codAlum, codRetiro, codMatricula;
		String fecha, hora;
		//bucar al alumno
		codAlum= getCodAlumno();
		//validar estado (2)
		if(arAl.buscar(codAlum).getEstado() == 2) {
			int respuesta = JOptionPane.showConfirmDialog(null, "¿Realmente desea cancelar el Retiro?", "Confirmar Salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	        if (respuesta == JOptionPane.YES_OPTION) {
	            // Si el usuario selecciona "Sí", cerramos la ventana
	        	arAl.buscar(codAlum).setEstado(1);//retiro Cancelado = 1
	        	arAl.guardarAlumno();//Guardar listado de alumnos en el txt
	        	limpiar();
	        } else {
	        	limpiar();// Si el usuario selecciona "No", llama al limpiar y la ventana seguirá abierta
	        }	
		}else {
			//mensaje de error cuando el estado de alumno no es 2
			JOptionPane.showMessageDialog(frmRetiro.this, "El estado del alumno no permite cancelar el retiro",
					"Error de selección", JOptionPane.ERROR_MESSAGE);
			}		
		}
	
	//BOTON ELIMINAR
	private void limpiar() {
		textCodAlumno.setText("");
		txtNomAlumno.setText("");
		txtDniAlumno.setText("");
		cbCodigoMatrcula.removeAllItems();
		cbCodigoMatrcula.addItem("0000..");
		campoCodRetiro.setText("");
		txtBuscar.setText("");
		//limpiar tabla
		model.setRowCount(0);	
	}
	
	//BOTON SALIR
	private void salir() {
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Realmente desea salir de la ventana?", "Confirmar Salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (respuesta == JOptionPane.YES_OPTION) {
            // Si el usuario selecciona "Sí", cerramos la ventana
            setVisible(false);
            
        } else {
        	System.exit(0);// Si el usuario selecciona "No", simplemente cerramos el cuadro de diálogo y la ventana seguirá abierta
        }	
	}	
	private void listar() {
		//1. limpiar la tabla
		model.setRowCount(0);
		//2.
    	for (int i = 0; i <arRetiro.tamanio(); i++) {
    		
    		Object fila [] = { arRetiro.obtener(i).getNumRetiro(),
    				arRetiro.obtener(i).getNumMatricula(),
    				arRetiro.obtener(i).getFecha(),
    				arRetiro.obtener(i).getHora(),    				
    		};
    		//3.add
    		model.addRow(fila);
    	}	
	}
	private String getHora() {
		// TODO Auto-generated method stub
		return sdfHora.format(fecha);
	}
	private String getFecha() {
		// TODO Auto-generated method stub
		return sdfFecha.format(fecha);
	}
	private int getCodCurso() {
		// TODO Auto-generated method stub
		return Integer.parseInt(txtDniAlumno.getText());
	}
	private int getCodAlumno() {
		// TODO Auto-generated method stub
		return Integer.parseInt(textCodAlumno.getText());
	}
	private int getNumRetiro() {
		// TODO Auto-generated method stub
		return Integer.parseInt(campoCodRetiro.getText());
	}
}