package menu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import vista.FrmReportAlumn;
import vista.frmAcerca;
import vista.frmAlumno;
import vista.frmAlumnosCursos;
import vista.frmCurso;
import vista.frmMatricula;
import vista.frmRetiro;

//import vista.frmRetiro;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.SystemColor;

public class frmMenu extends JFrame implements ActionListener {
	private JMenuBar menuBar;
	private JMenu menuMantenimiento;
	private JMenuItem itemAlumno;
	private JMenuItem itemCurso;
	private JMenu menuRegistro;
	private JMenuItem itemMatricula;
	private JMenu menuConsulta;
	private JMenuItem itemAlumnoycursos;
	private JMenu menuReporte;
	private JMenuItem itemMatriculapendiente;
	private JMenu menuAyuda;
	private JMenuItem itemAcerca;
	private JMenuItem itemSalir;
	private JPanel menuPrincipal;
	private JMenuItem itemRetiro;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmMenu frame = new frmMenu();
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
	public frmMenu() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(frmMenu.class.getResource("/img/instituto.png")));
		setResizable(false);
		addWindowListener(new WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent e) {
		        int respuesta = JOptionPane.showConfirmDialog(null, "¿Realmente desea salir del sistema?", "Confirmar Salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		        if (respuesta == JOptionPane.YES_OPTION) {
		            // Si el usuario selecciona "Sí", cerramos la ventana y salimos del sistema
		            dispose();
		        } else {
		        	//System.exit(0);// Si el usuario selecciona "No", simplemente cerramos el cuadro de diálogo y la ventana seguirá abierta
		        }
		    }
		});
		setBackground(new Color(255, 255, 255));
		setForeground(new Color(255, 255, 128));
		setTitle("SISTEMA  DE MATRICULAS");
		setBounds(100, 100, 1243, 911);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		menuAyuda = new JMenu("AYUDA");
		menuAyuda.setIcon(new ImageIcon(frmMenu.class.getResource("/img/ayuda.png")));
		menuAyuda.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.add(menuAyuda);
		
		itemAcerca = new JMenuItem("ACERCA DE...");
		itemAcerca.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		itemAcerca.addActionListener(this);
		menuAyuda.add(itemAcerca);
		
		itemSalir = new JMenuItem("SALIR");
		itemSalir.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		menuAyuda.add(itemSalir);
		
		menuMantenimiento = new JMenu("MANTENIMIENTO");
		menuMantenimiento.setIcon(new ImageIcon(frmMenu.class.getResource("/img/mantenimiento.png")));
		menuMantenimiento.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.add(menuMantenimiento);
		
		itemAlumno = new JMenuItem("ALUMNO");
		itemAlumno.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		itemAlumno.addActionListener(this);
		menuMantenimiento.add(itemAlumno);
		
		itemCurso = new JMenuItem("CURSO");
		itemCurso.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		itemCurso.addActionListener(this);
		menuMantenimiento.add(itemCurso);

		menuRegistro = new JMenu("REGISTRO");
		menuRegistro.setIcon(new ImageIcon(frmMenu.class.getResource("/img/registro.png")));
		menuRegistro.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.add(menuRegistro);
		
		itemMatricula = new JMenuItem("MATRICULA");
		itemMatricula.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		itemMatricula.addActionListener(this);
		menuRegistro.add(itemMatricula);
		
		itemRetiro = new JMenuItem("RETIRO");
		itemRetiro.addActionListener(this);
		menuRegistro.add(itemRetiro);
		
		menuConsulta = new JMenu("CONSULTA");
		menuConsulta.setIcon(new ImageIcon(frmMenu.class.getResource("/img/consulta.png")));
		menuConsulta.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.add(menuConsulta);
		
		itemAlumnoycursos = new JMenuItem("CONSULTA GENERAL");
		itemAlumnoycursos.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		itemAlumnoycursos.addActionListener(this);
		menuConsulta.add(itemAlumnoycursos);
		
		menuReporte = new JMenu("REPORTE");
		menuReporte.setIcon(new ImageIcon(frmMenu.class.getResource("/img/reporte.png")));
		menuReporte.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.add(menuReporte);
		
		itemMatriculapendiente = new JMenuItem("REPORTE GENERAL");
		itemMatriculapendiente.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		itemMatriculapendiente.addActionListener(this);
		menuReporte.add(itemMatriculapendiente);
		
		menuPrincipal = new JPanel();
		menuPrincipal.setBackground(new Color(201, 240, 108));
		getContentPane().add(menuPrincipal, BorderLayout.CENTER);
		menuPrincipal.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(frmMenu.class.getResource("/img/logoMejorado_Mesa de trabajo 1.png")));
		lblNewLabel_2.setBackground(Color.RED);
		lblNewLabel_2.setBounds(303, 109, 576, 529);
		menuPrincipal.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(frmMenu.class.getResource("/img/fondo-azul.png")));
		lblNewLabel.setBounds(-63, 0, 1290, 844);
		menuPrincipal.add(lblNewLabel);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == itemRetiro) {
			actionPerformedItemRetiro(e);
		}
		
		if (e.getSource() == itemAcerca) {
			actionPerformedItemAcerca(e);
		}
		if (e.getSource() == itemMatriculapendiente) {
			actionPerformedItemMatriculapendiente(e);
		}
		if (e.getSource() == itemAlumnoycursos) {
			actionPerformedItemAlumnoycursos(e);
		}
		
		if (e.getSource() == itemMatricula) {
			actionPerformedItemMatricula(e);
		}
		if (e.getSource() == itemCurso) {
			actionPerformedItemCurso(e);
		}
		if (e.getSource() == itemAlumno) {
			actionPerformedItemAlumno(e);
		}
	}
	protected void actionPerformedItemAlumno(ActionEvent e) {
		frmAlumno a = new frmAlumno();
		//menuPrincipal.add(a);
		a.setVisible(true);
		a.setLocationRelativeTo(this);
	}
	protected void actionPerformedItemCurso(ActionEvent e) {
		frmCurso b = new frmCurso();
		//menuPrincipal.add(b);
		b.setVisible(true);
		b.setLocationRelativeTo(this);
	}
	protected void actionPerformedItemMatricula(ActionEvent e) {
		frmMatricula c = new frmMatricula();
		//menuPrincipal.add(c);
		c.setVisible(true);
		c.setLocationRelativeTo(this);
	}
	
	protected void actionPerformedItemAlumnoycursos(ActionEvent e) {
		frmAlumnosCursos f = new frmAlumnosCursos();
		//menuPrincipal.add(f);
		f.setVisible(true);
		f.setLocationRelativeTo(this);
	}
	protected void actionPerformedItemMatriculapendiente(ActionEvent e) {
		FrmReportAlumn h = new FrmReportAlumn();
		//menuPrincipal.add(h);
		h.setVisible(true);
		h.setLocationRelativeTo(this);
	}
	protected void actionPerformedItemAcerca(ActionEvent e) {
		frmAcerca x = new frmAcerca();
		//menuPrincipal.add(x);
		x.setVisible(true);
		x.setLocationRelativeTo(this);
	}
	
	protected void actionPerformedItemRetiro(ActionEvent e) {
		frmRetiro r = new frmRetiro();
		r.setVisible(true);
		r.setLocationRelativeTo(this);
	}
}
