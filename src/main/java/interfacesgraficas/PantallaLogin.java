package interfacesgraficas;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import clases.Personaje;
import clases.Jugador;
import componentesvisuales.BotonAzul;
import componentesvisuales.BotonRojo;
import componentesvisuales.BotonVerde;
import excepciones.NombreInvalidoException;
import utils.ConexionBD;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PantallaLogin extends JPanel{
	private Ventana ventana;
	private JTextField campoUsuario;
	
	public PantallaLogin(Ventana v) {
		this.ventana=v;
		setLayout(null);
		
		JButton botonLogin = new BotonRojo("Login");
		botonLogin.setBackground(Color.WHITE);
		botonLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nombre=campoUsuario.getText();				
				try {
					Jugador jugador = new Jugador(nombre);
				} catch (NombreInvalidoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}							
			}
		});
		botonLogin.setToolTipText("Pincha aqu\u00ED para iniciar sesi\u00F3n");
		botonLogin.setBounds(136, 151, 160, 44);
		this.add(botonLogin);
		
		JLabel etiquetaTitulo = new JLabel("Insert your name");
		etiquetaTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaTitulo.setFont(new Font("Miriam Libre", Font.ITALIC, 27));
		etiquetaTitulo.setBounds(0, 11, 480, 44);
		add(etiquetaTitulo);
		
		JLabel Usuario = new JLabel("Username");
		Usuario.setFont(new Font("Arial", Font.PLAIN, 18));
		Usuario.setBounds(74, 66, 118, 53);
		add(Usuario);
		
		campoUsuario = new JTextField();
		campoUsuario.setBounds(204, 84, 165, 20);
		add(campoUsuario);
		campoUsuario.setColumns(10);
	}
}
