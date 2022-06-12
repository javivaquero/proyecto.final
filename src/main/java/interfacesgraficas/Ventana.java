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

/**
 * Clase que navega entre todas las ventanas posibles del programa, se podría haber hecho más corto con un switch, pero empecé así y era demasiado tarde como para cambiarlo.
 * @author Javi
 *
 */

public class Ventana extends JFrame {
	
	private JPanel pantallaActual;
	protected Jugador j;
	protected Clip clip;
	/**
	 * Se llama desde el main y es la principal determina el tamaño de la ventana, el título, el logo y te lleva a pantalla login entre otras
	 */
	public Ventana() {
		
		this.setSize(1024,768);
		this.setLocationRelativeTo(null);		
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
	/**
	 * te lleva a la pantalla de registro
	 * @param v
	 * @throws IOException
	 */
	public void irAPantallaR(Ventana v) throws IOException {
		this.pantallaActual.setVisible(false);
		this.pantallaActual=null;			
		this.pantallaActual=new PantallaRegistro(this);
		this.setContentPane(this.pantallaActual);
		this.setVisible(true);
			}
	/**
	 * te lleva a la pantalla de selección de clase
	 * @param v
	 * @param nombre
	 * @throws IOException
	 */
	public void irAPantalla(Ventana v, String nombre) throws IOException {
		this.pantallaActual.setVisible(false);
		this.pantallaActual=null;					
		this.pantallaActual=new PantallaSeleccionClase(this,nombre);				
		this.pantallaActual.setVisible(true);
		this.setContentPane(pantallaActual);
	}
	/**
	 * Te lleva a la pantalla de combate
	 * @param v
	 * @param j:Jugador recibido por argumentos
	 * @param m: Mensaje recibido por argumentos
	 * @param en: Enemigo recibido por argumentos
	 * @throws IOException
	 * @throws LineUnavailableException
	 */
	public void irAPantallaC(Ventana v,Jugador j,String m,Enemigo en) throws IOException, LineUnavailableException {

		this.pantallaActual.setVisible(false);
		this.pantallaActual=null;			
		this.pantallaActual=new PantallaCombate(this, j,m,en);
		this.pantallaActual.setVisible(true);
		this.setContentPane(pantallaActual);
			
			}
	/**
	 * Te lleva a un "clon" en diseño de la pantalla de combate, solo sirve para pasar el turno del enemigo al hacer click.
	 * @param v
	 * @param j
	 * @param m
	 * @param en
	 * @param sprite
	 * @throws IOException
	 * @throws LineUnavailableException
	 */
	public void irAPantallaAE(Ventana v,Jugador j,String m,Enemigo en,ImageIcon sprite) throws IOException, LineUnavailableException {
		this.pantallaActual.setVisible(false);
		this.pantallaActual=null;			
		this.pantallaActual=new PantallaAtaqueEnemigo(this, j,m,en,sprite);
		this.pantallaActual.setVisible(true);
		this.setContentPane(pantallaActual);
			
			}
	/**
	 * Te lleva a la pantalla de selección de objetos.
	 * @param v
	 * @param j:Jugador recibido por argumentos
	 * @throws IOException
	 * @throws LineUnavailableException
	 */
	public void irAPantallaO(Ventana v,Jugador j) throws IOException, LineUnavailableException {

		this.pantallaActual.setVisible(false);
		this.pantallaActual=null;			
		this.pantallaActual=new PantallaSeleccionObjeto(this, j);
		this.pantallaActual.setVisible(true);
		this.setContentPane(pantallaActual);
			
			}
	/**
	 * Te lleva a una pantalla con una animación en gif para pasar al siguiente combate
	 * @param v
	 * @param j
	 * @throws IOException
	 * @throws LineUnavailableException
	 */
	public void irAPantallaNO(Ventana v,Jugador j) throws IOException, LineUnavailableException {

		this.pantallaActual.setVisible(false);
		this.pantallaActual=null;			
		this.pantallaActual=new PantallaNuevoOpenente(this, j);
		this.pantallaActual.setVisible(true);
		this.setContentPane(pantallaActual);
			
			}
	/**
	 * Te lleva a una pantalla con un mensaje de victoria
	 * @param v
	 * @throws IOException
	 */
	public void irAPantallaV(Ventana v) throws IOException {
		this.pantallaActual.setVisible(false);
		this.pantallaActual=null;			
		this.pantallaActual=new PantallaVictoria(this);
		this.setContentPane(this.pantallaActual);
		this.setVisible(true);
			}
	/**
	 * Te lleva a una pantalla con un mensaje de derrota.
	 * @param v
	 * @throws IOException
	 */
	public void irAPantallaD(Ventana v) throws IOException {
		this.pantallaActual.setVisible(false);
		this.pantallaActual=null;			
		this.pantallaActual=new PantallaDerrota(this);
		this.setContentPane(this.pantallaActual);
		this.setVisible(true);
			}
	
}
