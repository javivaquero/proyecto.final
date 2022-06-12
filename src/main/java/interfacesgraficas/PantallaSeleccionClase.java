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
import componentesvisuales.BotonI;
import enums.Clase;
import enums.Tipo;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class PantallaSeleccionClase extends JPanel{
	/**
	 * Pantalla que sirve para seleccionar la clase del jugador. Segun el seleccionado, sus estadisticas variaran.
	 */
	private Ventana ventana;
	private Jugador j;
	/**
	 * 
	 * @param ventana
	 * @param user: Nombre del jugador insertado previamente en la base de datos.
	 * @throws IOException
	 */
	public PantallaSeleccionClase(Ventana ventana, String user) throws IOException{
		super();
		setBackground(Color.BLACK);
		this.ventana = ventana;
		//IMAGENES
		BufferedImage mageP = ImageIO.read(new File("./imagenes/mageS.png"));
		BufferedImage tankP= ImageIO.read(new File("./imagenes/tankS.png"));
		BufferedImage assasinP= ImageIO.read(new File("./imagenes/assasinS.png"));
		BufferedImage bowP= ImageIO.read(new File("./imagenes/bowS.png"));
		setLayout(null);
		
		
		
		JButton botonArquero = new BotonI("Arquero");
		botonArquero.setBorder(new LineBorder(Color.WHITE));
		botonArquero.setBorderPainted(true);
		botonArquero.setBounds(518, 399, 185, 104);
		botonArquero.setFont(new Font("StatusPlz", Font.PLAIN, 22));
		botonArquero.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ArrayList<Ataque>a=new ArrayList<Ataque>();
				ArrayList<Objeto>o=new ArrayList<Objeto>();
				ArrayList<Consumible>cs=new ArrayList<Consumible>();				
				j=new Jugador(user,(short)140,(short)14,(short)1,a,(byte)60,o,cs,(byte)1,Clase.ARQUERO,Tipo.FUEGO,(int)100,ventana.j.getTope());
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
		JButton botonMago = new BotonI("Mago");
		botonMago.setBorder(new LineBorder(Color.WHITE));
		botonMago.setBorderPainted(true);
		botonMago.setBounds(103, 399, 190, 104);
		botonMago.setFont(new Font("StatusPlz", Font.PLAIN, 22));
		botonMago.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			ArrayList<Ataque>a=new ArrayList<Ataque>();
			ArrayList<Objeto>o=new ArrayList<Objeto>();
			ArrayList<Consumible>cs=new ArrayList<Consumible>();
			j=new Jugador(user,(short)160,(short)10,(short)1,a,(byte)40,o,cs,(byte)1,Clase.MAGO,Tipo.ELECTRICO,(int)100,ventana.j.getTope());
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
		
		JButton botonTanque = new BotonI("Tanque");
		botonTanque.setBorderPainted(true);
		botonTanque.setBorder(new LineBorder(Color.WHITE));
		botonTanque.setBounds(316, 399, 185, 104);
		botonTanque.setFont(new Font("StatusPlz", Font.PLAIN, 22));
		botonTanque.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ArrayList<Ataque>a=new ArrayList<Ataque>();
				ArrayList<Objeto>o=new ArrayList<Objeto>();
				ArrayList<Consumible>cs=new ArrayList<Consumible>();
				j=new Jugador(user,(short)220,(short)10,(short)2,a,(byte)30,o,cs,(byte)1,Clase.TANQUE,Tipo.FISICO,(int)100,ventana.j.getTope());
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
		
		JButton botonAsesino = new BotonI("Asesino");
		botonAsesino.setBorder(new LineBorder(Color.WHITE));
		botonAsesino.setBorderPainted(true);
		botonAsesino.setBounds(723, 399, 185, 104);
		botonAsesino.setFont(new Font("StatusPlz", Font.PLAIN, 22));
		botonAsesino.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {				
				ArrayList<Ataque>a=new ArrayList<Ataque>();
				ArrayList<Objeto>o=new ArrayList<Objeto>();
				ArrayList<Consumible>cs=new ArrayList<Consumible>();				
				j=new Jugador(user,(short)110,(short)19,(short)1,a,(byte)80,o,cs,(byte)1,Clase.ASESINO,Tipo.HIELO,(int)100,ventana.j.getTope());
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
		
		JLabel imgMago = new JLabel(new ImageIcon("./imagenes/mageS.png"));
		imgMago.setBounds(125, 264, 150, 124);
		add(imgMago);
		
		JLabel imgTanque = new JLabel(new ImageIcon("./imagenes/tankS.png"));
		imgTanque.setBounds(333, 264, 150, 124);
		add(imgTanque);
		
		JLabel imgArquero = new JLabel(new ImageIcon("./imagenes/bowS.png"));
		imgArquero.setBounds(534, 264, 150, 124);
		add(imgArquero);
		
		JLabel imgAsesino = new JLabel(new ImageIcon("./imagenes/assasinS.png"));
		imgAsesino.setBounds(741, 264, 150, 124);
		add(imgAsesino);
		
		
	}
}
