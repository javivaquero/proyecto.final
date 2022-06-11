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

public class PantallaSeleccionClase extends JPanel{

	private Ventana ventana;
	private Jugador j;
	public PantallaSeleccionClase(Ventana ventana, String user) throws IOException{
		super();
		this.ventana = ventana;
		//IMAGENES
		BufferedImage mageP = ImageIO.read(new File("./imagenes/mageS.png"));
		BufferedImage tankP= ImageIO.read(new File("./imagenes/tankS.png"));
		BufferedImage assasinP= ImageIO.read(new File("./imagenes/assasinS.png"));
		BufferedImage bowP= ImageIO.read(new File("./imagenes/bowS.png"));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{226, 1, 1, 1, 1, 63, 75, 79, 77, 0};
		gridBagLayout.rowHeights = new int[]{23, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel mageS = new JLabel(new ImageIcon(mageP));
		GridBagConstraints gbc_mageS = new GridBagConstraints();
		gbc_mageS.anchor = GridBagConstraints.WEST;
		gbc_mageS.insets = new Insets(0, 0, 0, 5);
		gbc_mageS.gridx = 1;
		gbc_mageS.gridy = 0;
		add(mageS, gbc_mageS);
		
		JLabel tankS= new JLabel(new ImageIcon(tankP));
		GridBagConstraints gbc_tankS = new GridBagConstraints();
		gbc_tankS.anchor = GridBagConstraints.WEST;
		gbc_tankS.insets = new Insets(0, 0, 0, 5);
		gbc_tankS.gridx = 2;
		gbc_tankS.gridy = 0;
		add(tankS, gbc_tankS);
		
		JLabel bowS = new JLabel(new ImageIcon(bowP));
		GridBagConstraints gbc_bowS = new GridBagConstraints();
		gbc_bowS.anchor = GridBagConstraints.WEST;
		gbc_bowS.insets = new Insets(0, 0, 0, 5);
		gbc_bowS.gridx = 3;
		gbc_bowS.gridy = 0;
		add(bowS, gbc_bowS);
		
		JLabel assasinS = new JLabel(new ImageIcon(assasinP));
		GridBagConstraints gbc_assasinS = new GridBagConstraints();
		gbc_assasinS.anchor = GridBagConstraints.WEST;
		gbc_assasinS.insets = new Insets(0, 0, 0, 5);
		gbc_assasinS.gridx = 4;
		gbc_assasinS.gridy = 0;
		add(assasinS, gbc_assasinS);
		
		JButton botonArquero = new JButton("Arquero");
		botonArquero.setFont(new Font("Verdana", Font.PLAIN, 11));
		botonArquero.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ArrayList<Ataque>a=new ArrayList<Ataque>();
				ArrayList<Objeto>o=new ArrayList<Objeto>();
				ArrayList<Consumible>cs=new ArrayList<Consumible>();				
				j=new Jugador(user,(short)65,(short)4,(short)2,a,(byte)60,o,cs,(byte)1,Clase.ARQUERO,Tipo.FUEGO,(byte)100);
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
			j=new Jugador(user,(short)160,(short)5,(short)1,a,(byte)40,o,cs,(byte)1,Clase.MAGO,Tipo.ELECTRICO,(byte)100);
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
		GridBagConstraints gbc_botonMago = new GridBagConstraints();
		gbc_botonMago.anchor = GridBagConstraints.NORTHWEST;
		gbc_botonMago.insets = new Insets(0, 0, 0, 5);
		gbc_botonMago.gridx = 5;
		gbc_botonMago.gridy = 0;
		add(botonMago, gbc_botonMago);
		
		JButton botonTanque = new JButton("Tanque");
		botonTanque.setFont(new Font("Verdana", Font.PLAIN, 11));
		botonTanque.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ArrayList<Ataque>a=new ArrayList<Ataque>();
				ArrayList<Objeto>o=new ArrayList<Objeto>();
				ArrayList<Consumible>cs=new ArrayList<Consumible>();
				j=new Jugador(user,(short)100,(short)2,(short)3,a,(byte)30,o,cs,(byte)1,Clase.TANQUE,Tipo.FISICO,(byte)100);
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
		GridBagConstraints gbc_botonTanque = new GridBagConstraints();
		gbc_botonTanque.anchor = GridBagConstraints.NORTHWEST;
		gbc_botonTanque.insets = new Insets(0, 0, 0, 5);
		gbc_botonTanque.gridx = 6;
		gbc_botonTanque.gridy = 0;
		add(botonTanque, gbc_botonTanque);
		GridBagConstraints gbc_botonArquero = new GridBagConstraints();
		gbc_botonArquero.anchor = GridBagConstraints.NORTHWEST;
		gbc_botonArquero.insets = new Insets(0, 0, 0, 5);
		gbc_botonArquero.gridx = 7;
		gbc_botonArquero.gridy = 0;
		add(botonArquero, gbc_botonArquero);
		
		JButton botonAsesino = new JButton("Asesino");
		botonAsesino.setFont(new Font("Verdana", Font.PLAIN, 11));
		botonAsesino.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {				
				ArrayList<Ataque>a=new ArrayList<Ataque>();
				ArrayList<Objeto>o=new ArrayList<Objeto>();
				ArrayList<Consumible>cs=new ArrayList<Consumible>();				
				j=new Jugador(user,(short)40,(short)7,(short)1,a,(byte)80,o,cs,(byte)1,Clase.ASESINO,Tipo.HIELO,(byte)100);
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
		GridBagConstraints gbc_botonAsesino = new GridBagConstraints();
		gbc_botonAsesino.anchor = GridBagConstraints.NORTHWEST;
		gbc_botonAsesino.gridx = 8;
		gbc_botonAsesino.gridy = 0;
		add(botonAsesino, gbc_botonAsesino);
		
		
	}
	
	
}
