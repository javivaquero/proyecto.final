package interfacesgraficas;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import clases.Enemigo;
import clases.Jugador;



public class Ventana extends JFrame {
	private JPanel pantallaActual;
	protected String usuarioLogado;//ES EL USUARIO QUE INICIA SESI�N EN LA PANTALLALOGIN, HASTA ENTONCES, VALE NULL.
	protected Jugador j;
protected Clip clip;
	
	
	public Ventana() {
		
		this.setSize(1024,768);
		this.setLocationRelativeTo(null);
		
		//Pantalla completa las dos lineas siguentes
		//this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//this.setUndecorated(true);
		
		this.setTitle("EL JUEGO");
		this.setIconImage(new ImageIcon("./iconos/icon.png").getImage());
		//this.setAlwaysOnTop(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pantallaActual=new PantallaLogin(this);
		this.setContentPane(this.pantallaActual);
		this.setVisible(true);
	}
	
	public void irAPantalla(Ventana v) throws IOException {
		this.pantallaActual.setVisible(false);
		this.pantallaActual=null;			
		this.pantallaActual=new PantallaLogin(this);

			}
	public void irAPantalla(Ventana v, String nombre) throws IOException {
		this.pantallaActual.setVisible(false);
		this.pantallaActual=null;					
		this.pantallaActual=new PantallaSeleccionClase(this,nombre);				
		this.pantallaActual.setVisible(true);
		this.setContentPane(pantallaActual);
	}
	
	public void irAPantallaC(Ventana v,Jugador j,String m,Enemigo en) throws IOException, LineUnavailableException {

		this.pantallaActual.setVisible(false);
		this.pantallaActual=null;			
		this.pantallaActual=new PantallaCombate(this, j,m,en);
		this.pantallaActual.setVisible(true);
		this.setContentPane(pantallaActual);
			
			}
	
	public void irAPantallaAE(Ventana v,Jugador j,String m,Enemigo en,ImageIcon sprite) throws IOException, LineUnavailableException {
		this.pantallaActual.setVisible(false);
		this.pantallaActual=null;			
		this.pantallaActual=new PantallaAtaqueEnemigo(this, j,m,en,sprite);
		this.pantallaActual.setVisible(true);
		this.setContentPane(pantallaActual);
			
			}
	
}
