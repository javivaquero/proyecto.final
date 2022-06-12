package interfacesgraficas;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import clases.Personaje;
import componentesvisuales.BotonI;
import clases.Jugador;
import excepciones.ContraseñaIncorrectaException;
import excepciones.NombreInvalidoException;
import excepciones.UsuarioNoExisteException;
import utils.ConexionBD;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.CardLayout;
import javax.swing.Icon;
import javax.swing.border.LineBorder;

/**
 * Pantalla que te permite iniciar sesión con un usuario previamente registrado.
 * @author Javi
 *
 */

public class PantallaLogin extends JPanel{
	private Ventana ventana;
	private JTextField campoUsuario;
	private JPasswordField campoPass;
	
	public PantallaLogin(Ventana v) {
		setBackground(Color.BLACK);
		this.ventana=v;
		setLayout(null);
		
		JButton botonLogin = new BotonI("Login");
		botonLogin.setBorder(new LineBorder(Color.WHITE));
		botonLogin.setBorderPainted(true);
		botonLogin.setFont(new Font("StatusPlz", Font.PLAIN, 18));
		botonLogin.setBackground(Color.WHITE);
		botonLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nombre=campoUsuario.getText();				
				String pass=new String(campoPass.getPassword());
				try {
					ventana.j = new Jugador(nombre,pass);
					JOptionPane.showMessageDialog(ventana, "Bienvenido de nuevo "+ventana.j.getNombre(), "Se ha iniciado sesión con éxito",JOptionPane.INFORMATION_MESSAGE);
					ventana.irAPantalla(ventana, nombre);
				} catch (NombreInvalidoException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(ventana, "El usuario introducido es demasiado largo", "ERROR",JOptionPane.ERROR_MESSAGE);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UsuarioNoExisteException e1) {
					JOptionPane.showMessageDialog(ventana, "El usuario introducido no existe", "ERROR",JOptionPane.ERROR_MESSAGE);
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ContraseñaIncorrectaException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(ventana, "La contraseña introducida es incorrecta", "ERROR",JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}							
			}
		});
		botonLogin.setToolTipText("Pincha aqu\u00ED para iniciar sesi\u00F3n");
		botonLogin.setBounds(552, 329, 186, 74);
		this.add(botonLogin);
		
		JLabel etiquetaTitulo = new JLabel("Login");
		etiquetaTitulo.setForeground(Color.WHITE);
		etiquetaTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaTitulo.setFont(new Font("StatusPlz", Font.PLAIN, 27));
		etiquetaTitulo.setBounds(552, 44, 409, 44);
		add(etiquetaTitulo);
		
		JLabel user = new JLabel("Username");
		user.setHorizontalAlignment(SwingConstants.CENTER);
		user.setForeground(Color.WHITE);
		user.setFont(new Font("StatusPlz", Font.PLAIN, 27));
		user.setBounds(552, 138, 158, 53);
		add(user);
		
		campoUsuario = new JTextField();
		campoUsuario.setBounds(768, 138, 165, 42);
		add(campoUsuario);
		campoUsuario.setColumns(10);
		
		JLabel pass = new JLabel("Pass");
		pass.setHorizontalAlignment(SwingConstants.CENTER);
		pass.setForeground(Color.WHITE);
		pass.setFont(new Font("StatusPlz", Font.PLAIN, 27));
		pass.setBounds(552, 250, 118, 53);
		add(pass);
		
		campoPass = new JPasswordField();
		campoPass.setBounds(768, 250, 165, 42);
		add(campoPass);
		
		JButton botonRegsitrarse = new BotonI("Registrarse");
		botonRegsitrarse.setBorderPainted(true);
		botonRegsitrarse.setBorder(new LineBorder(Color.WHITE));
		botonRegsitrarse.setFont(new Font("StatusPlz", Font.PLAIN, 18));
		botonRegsitrarse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					v.irAPantallaR(v);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		botonRegsitrarse.setBounds(775, 329, 186, 75);
		add(botonRegsitrarse);
		
		JPanel panelFondoLogin = new JPanel();
		panelFondoLogin.setBackground(Color.BLACK);
		panelFondoLogin.setBounds(10, 0, 522, 443);
		add(panelFondoLogin);
		panelFondoLogin.setLayout(new CardLayout(0, 0));
		
		JLabel imagenFondoLogin = new JLabel(new ImageIcon("./imagenes/login1.png"));
		panelFondoLogin.add(imagenFondoLogin, "name_397641930501500");
		
		JPanel panelFondoLogin_1 = new JPanel();
		panelFondoLogin_1.setBackground(Color.BLACK);
		panelFondoLogin_1.setBounds(10, 454, 951, 295);
		add(panelFondoLogin_1);
		panelFondoLogin_1.setLayout(new CardLayout(0, 0));
		
		JLabel imagenFondoLogin_1 = new JLabel(new ImageIcon("./imagenes/login2.png"));
		panelFondoLogin_1.add(imagenFondoLogin_1, "name_399513424992700");
	}
}
