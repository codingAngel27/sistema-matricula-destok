package login;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import menu.frmMenu;

import java.awt.SystemColor;
import javax.swing.SwingConstants;

public class FrmLogin extends JFrame {
	private JTextField campoUsuario;
	private JPasswordField campoContraseña;
	private JLabel etiquetaUsuario;
	private JLabel lblNewLabel;
	private JButton btnLogin;
	private JLabel lblImagen1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLogin frame = new FrmLogin();
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
	public FrmLogin() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		getContentPane().setBackground(new Color(0, 0, 255));
		setBounds(100, 100, 831, 661);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
        panel.setForeground(new Color(64, 224, 208));
        panel.setLayout(null);
        getContentPane().add(panel);
        
        ImageIcon imageIcon = new ImageIcon(FrmLogin.class.getResource("/img/fondoMatricula-01.jpg"));
        ImageIcon imagenIcono = new ImageIcon(FrmLogin.class.getResource("/img/usuario.png"));

        // Obtiene la imagen redimensionada
        Image image = imageIcon.getImage().getScaledInstance(800, 600, Image.SCALE_SMOOTH);
        Image imagen = imagenIcono.getImage().getScaledInstance(150,150, Image.SCALE_SMOOTH);

        // Crea un nuevo ImageIcon con la imagen redimensionada
        ImageIcon resizedIcon = new ImageIcon(image);
        ImageIcon resizedIcon1 = new ImageIcon(imagen);
                
                btnLogin = new JButton("INGRESAR");
                btnLogin.setForeground(Color.WHITE);
                btnLogin.setBackground(Color.BLUE);
                btnLogin.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                		char[] contraseña = campoContraseña.getPassword();
                	    String claveFinal = new String(contraseña);

                	    if (campoUsuario.getText().isEmpty() || claveFinal.isEmpty()) {
                	        JOptionPane.showMessageDialog(null, "Debes llenar ambos campos de usuario y contraseña",
                	                "Campos vacíos", JOptionPane.WARNING_MESSAGE);
                	    } else {
                	        if (campoUsuario.getText().equals("albertcep") && claveFinal.equals("1234")) {
                	            dispose();
                	            JOptionPane.showMessageDialog(null, "Bienvenido al sistema", "Ingresaste", JOptionPane.INFORMATION_MESSAGE);
                	            frmMenu a = new frmMenu();
                	            a.setVisible(true);

                				
                	        } else {
                	            JOptionPane.showMessageDialog(null, "Escriba correctamente el usuario o contraseña", "Error",
                	                    JOptionPane.ERROR_MESSAGE);
                	            campoUsuario.setText("");
                	            campoContraseña.setText("");
                	            campoUsuario.requestFocus();
                	        }
                	    }
                	}
                });
                
                lblImagen1 = new JLabel("");
                lblImagen1.setIcon(new ImageIcon(FrmLogin.class.getResource("/img/usuario.png")));
                lblImagen1.setBounds(550, 46, 150, 150);
                panel.add(lblImagen1);
                lblImagen1.setIcon(resizedIcon1);
                lblImagen1.setPreferredSize(new Dimension(150, 150));
                btnLogin.setFont(new Font("Tahoma", Font.BOLD, 18));
                btnLogin.setBounds(550, 414, 145, 31);
                panel.add(btnLogin);
                
                etiquetaUsuario = new JLabel("USUARIO:");
                etiquetaUsuario.setFont(new Font("Tahoma", Font.BOLD, 18));
                etiquetaUsuario.setBounds(467, 261, 144, 36);
                panel.add(etiquetaUsuario);
                
                lblNewLabel = new JLabel("CONTRASEÑA:");
                lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
                lblNewLabel.setBounds(467, 344, 170, 27);
                panel.add(lblNewLabel);
                
                campoUsuario = new JTextField();
                campoUsuario.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
                campoUsuario.setBackground(SystemColor.menu);
                campoUsuario.setBounds(621, 261, 170, 31);
                panel.add(campoUsuario);
                campoUsuario.setColumns(10);
                
                campoContraseña = new JPasswordField();
                campoContraseña.setSelectionColor(SystemColor.infoText);
                campoContraseña.setDisabledTextColor(SystemColor.activeCaption);
                campoContraseña.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
                campoContraseña.setBackground(SystemColor.menu);
                campoContraseña.setBounds(623, 334, 170, 31);
                panel.add(campoContraseña);
                
                JLabel lblNewLabel_1 = new JLabel("C.E.P. ALBERT EINSTEIN");
                lblNewLabel_1.setFont(new Font("Roboto Bk", Font.BOLD, 30));
                lblNewLabel_1.setBounds(51, 174, 375, 43);
                panel.add(lblNewLabel_1);
                
                JButton btnNewButton = new JButton("CAMBIAR");
                btnNewButton.setForeground(Color.WHITE);
                btnNewButton.setBackground(Color.BLUE);
                btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
                btnNewButton.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                		loginCambio lc = new loginCambio();
                		lc.setVisible(true);
                		lc.setLocationRelativeTo(null);
                	}
                });
                btnNewButton.setBounds(550, 462, 150, 31);
                panel.add(btnNewButton);
                                        
                                        JButton btnNewButton_1 = new JButton("SALIR");
                                        btnNewButton_1.addActionListener(new ActionListener() {
                                        	public void actionPerformed(ActionEvent e) {
                                        		 int respuesta = JOptionPane.showConfirmDialog(null, "¿Realmente desea salir del sistema?", "Confirmar Salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                                 		        if (respuesta == JOptionPane.YES_OPTION) {
                                 		            // Si el usuario selecciona "Sí", cerramos la ventana y salimos del sistema
                                 		        	System.exit(0);
                                        	}
                                        }
                                        });
                                        btnNewButton_1.setForeground(Color.WHITE);
                                        btnNewButton_1.setBackground(Color.BLUE);
                                        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
                                        btnNewButton_1.setBounds(550, 512, 150, 31);
                                        panel.add(btnNewButton_1);
                                        
                                                // Crea el JLabel y establece el ImageIcon redimensionado
                                                JLabel lblImagen = new JLabel(new ImageIcon(FrmLogin.class.getResource("/img/fondoMatricula-01.jpg")));
                                                lblImagen.setBounds(10, 11, 800, 600);
                                                lblImagen.setIcon(resizedIcon);
                                                
                                                                panel.add(lblImagen);
                                                                lblImagen.setPreferredSize(new Dimension(800, 600));
        
	}
}
