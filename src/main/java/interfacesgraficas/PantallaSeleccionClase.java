package interfacesgraficas;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import clases.Ataque;
import clases.Consumible;
import clases.Jugador;
import clases.Objeto;
import enums.Clase;
import enums.Tipo;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import java.awt.BorderLayout;

public class PantallaSeleccionClase extends JPanel{

	private Ventana ventana;
	private Jugador j;
	public PantallaSeleccionClase(Ventana ventana, String user,byte tope) throws IOException{
		super();
		this.ventana = ventana;
		//IMAGENES
		BufferedImage mageP = ImageIO.read(new File("./imagenes/mageS.png"));
		BufferedImage tankP= ImageIO.read(new File("./imagenes/tankS.png"));
		BufferedImage assasinP= ImageIO.read(new File("./imagenes/assasinS.png"));
		BufferedImage bowP= ImageIO.read(new File("./imagenes/bowS.png"));
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel mageS = new JLabel(new ImageIcon(mageP));
		add(mageS);
		
		JLabel tankS= new JLabel(new ImageIcon(tankP));
		add(tankS);
		
		JLabel bowS = new JLabel(new ImageIcon(bowP));
		add(bowS);
		
		JLabel assasinS = new JLabel(new ImageIcon(assasinP));
		add(assasinS);
		
		JButton botonArquero = new JButton("Arquero");
		botonArquero.setFont(new Font("Verdana", Font.PLAIN, 11));
		botonArquero.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ArrayList<Ataque>a=new ArrayList<Ataque>();
				ArrayList<Objeto>o=new ArrayList<Objeto>();
				ArrayList<Consumible>cs=new ArrayList<Consumible>();				
				j=new Jugador(user,(short)65,(short)4,(short)2,a,(byte)60,o,cs,(byte)1,Clase.ARQUERO,Tipo.FUEGO,(int)100,tope);
				try {
					ventana.irAPantallaC(ventana, j,"",null);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		//BOTONES
		JButton botonMago = new JButton("Mago");
		botonMago.setFont(new Font("Verdana", Font.PLAIN, 11));
		botonMago.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			ArrayList<Ataque>a=new ArrayList<Ataque>();
			ArrayList<Objeto>o=new ArrayList<Objeto>();
			ArrayList<Consumible>cs=new ArrayList<Consumible>();
			j=new Jugador(user,(short)160,(short)5,(short)1,a,(byte)40,o,cs,(byte)1,Clase.MAGO,Tipo.ELECTRICO,(int)100,tope);
			try {
				ventana.irAPantallaC(ventana, j,"",null);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (LineUnavailableException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			}
		});
		add(botonMago);
		
		JButton botonTanque = new JButton("Tanque");
		botonTanque.setFont(new Font("Verdana", Font.PLAIN, 11));
		botonTanque.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ArrayList<Ataque>a=new ArrayList<Ataque>();
				ArrayList<Objeto>o=new ArrayList<Objeto>();
				ArrayList<Consumible>cs=new ArrayList<Consumible>();
				j=new Jugador(user,(short)100,(short)2,(short)3,a,(byte)30,o,cs,(byte)1,Clase.TANQUE,Tipo.FISICO,(int)100,tope);
				try {
					ventana.irAPantallaC(ventana, j,"",null);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		add(botonTanque);
		add(botonArquero);
		
		JButton botonAsesino = new JButton("Asesino");
		botonAsesino.setFont(new Font("Verdana", Font.PLAIN, 11));
		botonAsesino.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {				
				ArrayList<Ataque>a=new ArrayList<Ataque>();
				ArrayList<Objeto>o=new ArrayList<Objeto>();
				ArrayList<Consumible>cs=new ArrayList<Consumible>();				
				j=new Jugador(user,(short)40,(short)7,(short)1,a,(byte)80,o,cs,(byte)1,Clase.ASESINO,Tipo.HIELO,(int)100,tope);
				try {
					ventana.irAPantallaC(ventana, j,"",null);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		add(botonAsesino);
		
		
	}
	
	
}
