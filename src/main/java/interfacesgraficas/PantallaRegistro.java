package interfacesgraficas;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import clases.Jugador;
import componentesvisuales.BotonI;
import excepciones.ContraseñaIncorrectaException;
import excepciones.NombreInvalidoException;
import excepciones.UsuarioNoExisteException;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

public class PantallaRegistro extends JPanel {
	private JTextField campoUsuario;
	private JPasswordField campoPass;
	private Ventana ventana;
	public PantallaRegistro(Ventana v) {
		setBackground(Color.BLACK);
		this.ventana=v;
		setLayout(null);
		
		JButton botonLogin = new BotonI("Registrarse");
		botonLogin.setBorder(new LineBorder(Color.WHITE));
		botonLogin.setBorderPainted(true);
		botonLogin.setFont(new Font("StatusPlz", Font.PLAIN, 18));
		botonLogin.setBackground(Color.WHITE);
		botonLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				byte tope=0;
				String nombre=campoUsuario.getText();				
				String pass=new String(campoPass.getPassword());
				try {
					ventana.j = new Jugador(nombre,pass);					
					JOptionPane.showMessageDialog(ventana, "Bienvenido "+ventana.j.getNombre(), "Registro realizado con éxito.",JOptionPane.INFORMATION_MESSAGE);
					ventana.irAPantalla(ventana, nombre,tope);
				} catch (NombreInvalidoException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(ventana, "El usuario introducido es demasiado largo", "ERROR",JOptionPane.ERROR_MESSAGE);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 							
			}
		});
		botonLogin.setToolTipText("Pincha aqu\u00ED para iniciar sesi\u00F3n");
		botonLogin.setBounds(666, 303, 186, 74);
		this.add(botonLogin);
		
		JLabel etiquetaTitulo = new JLabel("Registrarse");
		etiquetaTitulo.setForeground(Color.WHITE);
		etiquetaTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaTitulo.setFont(new Font("StatusPlz", Font.PLAIN, 27));
		etiquetaTitulo.setBounds(552, 44, 409, 44);
		add(etiquetaTitulo);
		
		JLabel user = new JLabel("Username");
		user.setHorizontalAlignment(SwingConstants.LEFT);
		user.setForeground(Color.WHITE);
		user.setFont(new Font("StatusPlz", Font.PLAIN, 27));
		user.setBounds(552, 138, 158, 53);
		add(user);
		
		campoUsuario = new JTextField();
		campoUsuario.setBounds(768, 138, 165, 42);
		add(campoUsuario);
		campoUsuario.setColumns(10);
		
		JLabel pass = new JLabel("Pass");
		pass.setHorizontalAlignment(SwingConstants.LEFT);
		pass.setForeground(Color.WHITE);
		pass.setFont(new Font("StatusPlz", Font.PLAIN, 27));
		pass.setBounds(552, 239, 118, 53);
		add(pass);
		
		campoPass = new JPasswordField();
		campoPass.setBounds(768, 250, 165, 42);
		add(campoPass);
		
		JButton botonVolver = new BotonI("Volver a Login");
		botonVolver.setBorder(new LineBorder(Color.WHITE));
		botonVolver.setFont(new Font("StatusPlz", Font.PLAIN, 18));
		botonVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					v.irAPantalla(v);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		botonVolver.setBounds(552, 390, 139, 53);
		add(botonVolver);
		
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
