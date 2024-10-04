package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.ArregloCurso;
import entidad.Curso;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class DlgBuscarCurso02 extends JDialog implements ItemListener, ActionListener {
	
	private JComboBox cbCiclo;
	private JLabel lblNewLabel_1;
	private JTable tblAlumnos;
	private JScrollPane scrollPane;
	private JButton btnEnviarDatos;
	
	DefaultTableModel model = new DefaultTableModel();
	
	ArregloCurso arCurso = new ArregloCurso();
	private final JLabel lblNewLabel_2 = new JLabel("");
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgBuscarCurso dialog = new DlgBuscarCurso();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgBuscarCurso02() {
		setTitle("BUCAR CURSOS");
		setBounds(100, 100, 642, 435);
		getContentPane().setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("BUSCAR CURSO");
			lblNewLabel.setOpaque(true);
			lblNewLabel.setBackground(new Color(255, 255, 0));
			lblNewLabel.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 19));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(0, 11, 626, 42);
			getContentPane().add(lblNewLabel);
		}
		
		cbCiclo = new JComboBox();
		cbCiclo.addItemListener(this);
		cbCiclo.setFont(new Font("Tahoma", Font.BOLD, 11));
		cbCiclo.setModel(new DefaultComboBoxModel(new String[] {"Seleccione Ciclo", "Primero", "Segundo", "Tercero", "Cuarto", "Quinto", "Sexto"}));
		cbCiclo.setBounds(170, 67, 184, 22);
		getContentPane().add(cbCiclo);
		
		lblNewLabel_1 = new JLabel("Ciclo");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(20, 64, 115, 23);
		getContentPane().add(lblNewLabel_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 119, 606, 266);
		getContentPane().add(scrollPane);
		
		tblAlumnos = new JTable();
		tblAlumnos.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblAlumnos);
		
		btnEnviarDatos = new JButton("Enviar Datos");
		btnEnviarDatos.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEnviarDatos.setIcon(new ImageIcon(DlgBuscarCurso02.class.getResource("/img/ACTUALIZAR.png")));
		btnEnviarDatos.addActionListener(this);
		btnEnviarDatos.setBounds(396, 64, 189, 30);
		getContentPane().add(btnEnviarDatos);
		
		model.addColumn("Codigo");
		model.addColumn("Asignatura");
		model.addColumn("Ciclo");
		model.addColumn("Creditos");
		model.addColumn("Horas");
		
		tblAlumnos.setModel(model);
		lblNewLabel_2.setIcon(new ImageIcon(DlgBuscarCurso02.class.getResource("/img/fondo-azul-degradado.jpg")));
		lblNewLabel_2.setBounds(0, 0, 626, 396);
		getContentPane().add(lblNewLabel_2);
	}
	
	private void consultar(int ciclo) {
		
		model.setRowCount(0);
		
		for (int i = 0; i< arCurso.tamanio(); i++) {
			Curso c = arCurso.obtener(i);
			if(c.getCiclo() ==ciclo -0) {
				Object fila [] = { c.getCodCurso(),
						c.getAsignatura(),
						c.getCiclo(),
						c.getCreditos(),
						c.getHoras()
						
				};
				model.addRow(fila);
			}
			
		}
	}
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cbCiclo) {
			itemStateChangedCbCiclo(e);
		}
	}
	protected void itemStateChangedCbCiclo(ItemEvent e) {
		consultar(cbCiclo.getSelectedIndex());
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEnviarDatos) {
			actionPerformedBtnEnviarDatos(e);
		}
	}
	protected void actionPerformedBtnEnviarDatos(ActionEvent e) {
		int fila;
		String codCurso,asign,ciclo,creditos,horasCurso;
		
		fila = tblAlumnos.getSelectedRow();
		
	codCurso = tblAlumnos.getValueAt(fila, 0).toString();
	asign = tblAlumnos.getValueAt(fila, 1).toString();
	ciclo  = tblAlumnos.getValueAt(fila, 2).toString();
	creditos = tblAlumnos.getValueAt(fila, 3).toString();
	horasCurso = tblAlumnos.getValueAt(fila, 4).toString();
		
		// enviar datos
	frmMatricula.txtCodCurso.setText(codCurso);
	frmMatricula.txtCodigoCurso.setText(asign);
	
	this.dispose();
	}
}
