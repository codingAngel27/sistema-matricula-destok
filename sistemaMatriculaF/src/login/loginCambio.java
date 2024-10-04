package login;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.ImageIcon;

public class loginCambio extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton botonGuardar;
	private JButton btnNewButton_1;
	private JPasswordField campoNuevaContraseña;
	private JPasswordField campoRepetirContraseña;
	private JLabel lblNewLabel_2;
	private JTextField campoUsuario;
	private JLabel lblNewLabel_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginCambio frame = new loginCambio();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public loginCambio() {
		setTitle("CAMBIO DE CONTRASEÑA");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 459, 334);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("La nueva contraseña debe contener al menos un signo");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(20, 56, 364, 23);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel = new JLabel("NUEVA CONTRASEÑA:");
		lblNewLabel.setForeground(new Color(255, 255, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(20, 108, 185, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("REPETIR CONTRASEÑA:");
		lblNewLabel_1.setForeground(new Color(255, 255, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(20, 168, 185, 16);
		contentPane.add(lblNewLabel_1);
		
		botonGuardar = new JButton("GUARDAR");
		botonGuardar.setFont(new Font("Tahoma", Font.BOLD, 12));
		botonGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Creamos las variables tipo String
				String nuevaContraseña = new String(campoNuevaContraseña.getPassword());
				String repetirContraseña = new String(campoRepetirContraseña.getPassword());
				//METODO MODIFICADOO
				 if (campoNuevaContraseña.getPassword().length == 0
				            || campoRepetirContraseña.getPassword().length == 0
				            || campoUsuario.getText().isEmpty()) {
				        JOptionPane.showMessageDialog(null,
				                "Por favor, rellene los campos", "Campos vacíos",
				                JOptionPane.WARNING_MESSAGE);
				        campoUsuario.setText("");
				        campoNuevaContraseña.setText("");
				    	campoRepetirContraseña.setText("");
				        campoUsuario.requestFocus();
				    } else if (nuevaContraseña.length() < 6) {
				        JOptionPane.showMessageDialog(null, "La nueva contraseña debe tener como mínimo 6 caracteres");
				        campoUsuario.setText("");
				        campoNuevaContraseña.setText("");
				    	campoRepetirContraseña.setText("");
				        campoUsuario.requestFocus();
				    } else if (!nuevaContraseña.equals(repetirContraseña)) {
				        JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden, por favor inténtelo de nuevo");
				        campoUsuario.setText("");
				        campoNuevaContraseña.setText("");
				    	campoRepetirContraseña.setText("");
				        campoUsuario.requestFocus();
				    } else {
				        // Realizar acciones si todas las validaciones son exitosas
				        // ...
				        JOptionPane.showMessageDialog(null, "Contraseña cambiada correctamente");
				        return; // Salir del método actionPerformed
				    }
				////////////////////////////Primer metodo realizado
				/*//// Crear si la contraseña tiene menos de 6 letras nos salga un mensaje
				 if (campoNuevaContraseña.getPassword().length == 0
	                        && campoRepetirContraseña.getPassword().length == 0
	                        && textField.getText().isEmpty()) {
	                    JOptionPane.showMessageDialog(null,
	                            "Por favor, rellene los campos", "Campos vacíos",
	                            JOptionPane.WARNING_MESSAGE);
	                } else {
	                    // Aquí puedes realizar otras acciones con los campos no vacíos
	                  
	                	// ...
	                }
				 
				if (nuevaContraseña.length() < 6) {
					 JOptionPane.showMessageDialog(null, "La nueva contraseña debe tener como minimo 6 caracteres");
				} 
				else {
					
				}
					// si la contraseña no tiene un singo nos sale un mensaje
				/*if (nuevaContraseña.matches(".*[!@#$%^&*()_+-=\\[\\]{};':\"\\\\|,.<>\\/?].*")) {
					 JOptionPane.showMessageDialog(null, "La nueva contraseña debe contener al menos un signo");
				}
				else
					if (repetirContraseña.matches(".*[!@#$%^&*()_+-=\\[\\]{};':\"\\\\|,.<>\\/?].*")) {
						 JOptionPane.showMessageDialog(null, "La nueva contraseña debe contener al menos un signo");
					}
					else*/
				// Mensaje si las dos contraseñas coonciden sale correcto	
				/*if (nuevaContraseña.equals(repetirContraseña)) {
				    // Cambiar contraseña aquí
				    // ...
				    JOptionPane.showMessageDialog(null, "Contraseña cambiada correctamente");
				}
				// pero si las contraseñas no coonciden saldra intentar denuevo
				else {
				    JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden, por favor inténtelo de nuevo");
				}
				//dispose();*/
			}
		});
		botonGuardar.setBounds(39, 224, 113, 23);
		contentPane.add(botonGuardar);
		
		btnNewButton_1 = new JButton("CANCELAR");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(264, 224, 127, 23);
		contentPane.add(btnNewButton_1);
		
		campoNuevaContraseña = new JPasswordField();
		campoNuevaContraseña.setBounds(264, 107, 127, 20);
		contentPane.add(campoNuevaContraseña);
		
		campoRepetirContraseña = new JPasswordField();
		campoRepetirContraseña.setBounds(264, 158, 127, 23);
		contentPane.add(campoRepetirContraseña);
		
		lblNewLabel_2 = new JLabel("NUEVO USUARIO:");
		lblNewLabel_2.setForeground(new Color(255, 255, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(20, 31, 164, 19);
		contentPane.add(lblNewLabel_2);
		
		campoUsuario = new JTextField();
		campoUsuario.setBounds(264, 30, 127, 20);
		contentPane.add(campoUsuario);
		campoUsuario.setColumns(10);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(loginCambio.class.getResource("/img/fondo-azul-degradado.jpg")));
		lblNewLabel_4.setBackground(new Color(0, 0, 255));
		lblNewLabel_4.setBounds(0, 0, 443, 333);
		contentPane.add(lblNewLabel_4);
	}
}
