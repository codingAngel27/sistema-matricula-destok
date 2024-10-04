package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import vista.DlgBuscarCurso.BuscarListener;

public class DlgBuscarCurso extends JDialog  implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private JPanel panel;
	private JRadioButton rdbtnCodigo;
	private JRadioButton rdbtnAsignatura;
	private JTextField textDatosBusqueda;
	private JButton btnBusqueda;
	private final ButtonGroup buttonGroup = new ButtonGroup();

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
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		if(visible) {
			textDatosBusqueda.requestFocus();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgBuscarCurso() {
		setBounds(100, 100, 450, 268);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(198, 211, 242));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblNewLabel = new JLabel("Buscar Curso");
		lblNewLabel.setBackground(new Color(198, 211, 242));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(0, 21, 434, 31);
		contentPanel.add(lblNewLabel);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Buscar Curso", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(42, 63, 365, 78);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		rdbtnAsignatura = new JRadioButton("Asignatura");
		buttonGroup.add(rdbtnAsignatura);
		rdbtnAsignatura.setBounds(6, 31, 109, 23);
		panel.add(rdbtnAsignatura);
		
		rdbtnCodigo = new JRadioButton("Código");
		buttonGroup.add(rdbtnCodigo);
		rdbtnCodigo.setBounds(135, 31, 76, 23);
		panel.add(rdbtnCodigo);
		
		textDatosBusqueda = new JTextField();
		textDatosBusqueda.setBounds(41, 147, 365, 23);
		contentPanel.add(textDatosBusqueda);
		textDatosBusqueda.setColumns(10);
		
		btnBusqueda = new JButton("Buscar");
		btnBusqueda.addActionListener(this);
		btnBusqueda.setBounds(176, 189, 89, 23);
		contentPanel.add(btnBusqueda);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBusqueda) {
			actionPerformedBtnBusqueda(e);
		}
	}
	protected void actionPerformedBtnBusqueda(ActionEvent e) {
		String dato = textDatosBusqueda.getText();
		int tipoConsulta = 0;
		if(rdbtnAsignatura.isSelected()) {
			tipoConsulta=1;
			buscarlistener.buscarCurso(dato, tipoConsulta);
			
		}else {
			tipoConsulta=2;
			buscarlistener.buscarCurso(dato, tipoConsulta);
		}

		setVisible(false);
		limpiar();
		
	}
	private BuscarListener buscarlistener;
	
	public void setBuscarListener(BuscarListener buscarListener) {
		this.buscarlistener = buscarListener;
	}

	interface BuscarListener {
		void buscarCurso(String dato, int tipoConsulta);

	}
	void limpiar() {
		textDatosBusqueda.setText("");
	}
	
}
