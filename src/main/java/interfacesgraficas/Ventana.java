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
	private JPanel pantallaActual;//ES EL USUARIO QUE INICIA SESIÓN EN LA PANTALLALOGIN, HASTA ENTONCES, VALE NULL.
	protected Jugador j;
	protected Clip clip;
	
	public Ventana() {
		
		this.setSize(1024,768);
		this.setLocationRelativeTo(null);
		
		//Pantalla completa las dos lineas siguentes
		//this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//this.setUndecorated(true);
		
		this.setTitle("RespectYourElders");
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
		this.setContentPane(this.pantallaActual);
		this.setVisible(true);
			}
	public void irAPantallaR(Ventana v) throws IOException {
		this.pantallaActual.setVisible(false);
		this.pantallaActual=null;			
		this.pantallaActual=new PantallaRegistro(this);
		this.setContentPane(this.pantallaActual);
		this.setVisible(true);
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
	
	public void irAPantallaO(Ventana v,Jugador j) throws IOException, LineUnavailableException {

		this.pantallaActual.setVisible(false);
		this.pantallaActual=null;			
		this.pantallaActual=new PantallaSeleccionObjeto(this, j);
		this.pantallaActual.setVisible(true);
		this.setContentPane(pantallaActual);
			
			}
	public void irAPantallaNO(Ventana v,Jugador j) throws IOException, LineUnavailableException {

		this.pantallaActual.setVisible(false);
		this.pantallaActual=null;			
		this.pantallaActual=new PantallaNuevoOpenente(this, j);
		this.pantallaActual.setVisible(true);
		this.setContentPane(pantallaActual);
			
			}
	public void irAPantallaV(Ventana v) throws IOException {
		this.pantallaActual.setVisible(false);
		this.pantallaActual=null;			
		this.pantallaActual=new PantallaVictoria(this);
		this.setContentPane(this.pantallaActual);
		this.setVisible(true);
			}
	
	public void irAPantallaD(Ventana v) throws IOException {
		this.pantallaActual.setVisible(false);
		this.pantallaActual=null;			
		this.pantallaActual=new PantallaDerrota(this);
		this.setContentPane(this.pantallaActual);
		this.setVisible(true);
			}
	
}
