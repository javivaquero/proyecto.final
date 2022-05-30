package interfacesgraficas;

import java.util.HashMap;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import clases.Jugador;


public class Ventana extends JFrame {
	private JPanel pantallaActual;
	protected Jugador usuarioLogado;//ES EL USUARIO QUE INICIA SESIÓN EN LA PANTALLALOGIN, HASTA ENTONCES, VALE NULL.
	
	
	public Ventana() {
		
		this.setSize(500,400);
		this.setLocationRelativeTo(null);
		
		//Pantalla completa las dos lineas siguentes
		//this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//this.setUndecorated(true);
		
		this.setTitle("Ejemplo interfaces Tema 11");
		this.setIconImage(new ImageIcon("./iconos/iconoPrincipal.png").getImage());
		//this.setAlwaysOnTop(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pantallaActual=new PantallaLogin(this);
		this.setContentPane(this.pantallaActual);
		this.setVisible(true);
	}
	
	public void irAPantalla(String nombrePantalla) {
		this.pantallaActual.setVisible(false);
		this.pantallaActual=null;
			switch(nombrePantalla) {
			case "login":
				this.pantallaActual=new PantallaLogin(this);
				break;
			case "seleccionClase":
				this.pantallaActual=new PantallaSeleccionClase(this);
				break;
			}
			
		this.pantallaActual.setVisible(true);
		this.setContentPane(pantallaActual);
	}
	
}
