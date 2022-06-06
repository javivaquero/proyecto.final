package interfacesgraficas;
import clases.Ataque;
import clases.Combate;
import clases.Consumible;
import clases.Jugador;
import clases.Objeto;
import enums.Clase;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.GridBagLayout;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JLabel;
import java.awt.Font;

public class PantallaSeleccionClase extends JPanel{

	private Ventana ventana;
	private Jugador j;
	public PantallaSeleccionClase(Ventana ventana, String user) throws IOException{
		super();
		this.ventana = ventana;
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{47, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 58, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		//IMAGENES
		BufferedImage mageP = ImageIO.read(new File("./imagenes/mageS.png"));
		BufferedImage tankP= ImageIO.read(new File("./imagenes/tankS.png"));
		BufferedImage assasinP= ImageIO.read(new File("./imagenes/assasinS.png"));
		BufferedImage bowP= ImageIO.read(new File("./imagenes/bowS.png"));
		//BOTONES
		JButton botonMago = new JButton("Mago");
		botonMago.setFont(new Font("Verdana", Font.PLAIN, 11));
		botonMago.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			ArrayList<Ataque>a=new ArrayList<Ataque>();
			ArrayList<Objeto>o=new ArrayList<Objeto>();
			ArrayList<Consumible>cs=new ArrayList<Consumible>();
			j=new Jugador(user,(short)60,(short)5,(short)1,a,(byte)40,o,cs,(byte)1,(byte)1,(byte)1,Clase.MAGO);
			try {
				ventana.irAPantallaC(ventana, j);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		});
		
		JLabel mageS = new JLabel(new ImageIcon(mageP));
		GridBagConstraints gbc_mageS = new GridBagConstraints();
		gbc_mageS.insets = new Insets(0, 0, 5, 5);
		gbc_mageS.gridx = 2;
		gbc_mageS.gridy = 3;
		add(mageS, gbc_mageS);
		
		JLabel tankS= new JLabel(new ImageIcon(tankP));
		GridBagConstraints gbc_tankS = new GridBagConstraints();
		gbc_tankS.insets = new Insets(0, 0, 5, 5);
		gbc_tankS.gridx = 5;
		gbc_tankS.gridy = 3;
		add(tankS, gbc_tankS);
		
		JLabel bowS = new JLabel(new ImageIcon(bowP));
		GridBagConstraints gbc_bowS = new GridBagConstraints();
		gbc_bowS.insets = new Insets(0, 0, 5, 5);
		gbc_bowS.gridx = 8;
		gbc_bowS.gridy = 3;
		add(bowS, gbc_bowS);
		
		JLabel assasinS = new JLabel(new ImageIcon(assasinP));
		GridBagConstraints gbc_assasinS = new GridBagConstraints();
		gbc_assasinS.insets = new Insets(0, 0, 5, 5);
		gbc_assasinS.gridx = 11;
		gbc_assasinS.gridy = 3;
		add(assasinS, gbc_assasinS);
		GridBagConstraints gbc_botonMago = new GridBagConstraints();
		gbc_botonMago.insets = new Insets(0, 0, 0, 5);
		gbc_botonMago.gridx = 2;
		gbc_botonMago.gridy = 7;
		add(botonMago, gbc_botonMago);
		
		JButton botonTanque = new JButton("Tanque");
		botonTanque.setFont(new Font("Verdana", Font.PLAIN, 11));
		botonTanque.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ArrayList<Ataque>a=new ArrayList<Ataque>();
				ArrayList<Objeto>o=new ArrayList<Objeto>();
				ArrayList<Consumible>cs=new ArrayList<Consumible>();
				j=new Jugador(user,(short)100,(short)2,(short)3,a,(byte)30,o,cs,(byte)1,(byte)1,(byte)1,Clase.TANQUE);
				
			}
		});
		GridBagConstraints gbc_botonTanque = new GridBagConstraints();
		gbc_botonTanque.insets = new Insets(0, 0, 0, 5);
		gbc_botonTanque.gridx = 5;
		gbc_botonTanque.gridy = 7;
		add(botonTanque, gbc_botonTanque);
		
		JButton botonArquero = new JButton("Arquero");
		botonArquero.setFont(new Font("Verdana", Font.PLAIN, 11));
		botonArquero.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ArrayList<Ataque>a=new ArrayList<Ataque>();
				ArrayList<Objeto>o=new ArrayList<Objeto>();
				ArrayList<Consumible>cs=new ArrayList<Consumible>();				
				j=new Jugador(user,(short)65,(short)4,(short)2,a,(byte)60,o,cs,(byte)1,(byte)1,(byte)1,Clase.ARQUERO);
			}
		});
		GridBagConstraints gbc_botonArquero = new GridBagConstraints();
		gbc_botonArquero.insets = new Insets(0, 0, 0, 5);
		gbc_botonArquero.gridx = 8;
		gbc_botonArquero.gridy = 7;
		add(botonArquero, gbc_botonArquero);
		
		JButton botonAsesino = new JButton("Asesino");
		botonAsesino.setFont(new Font("Verdana", Font.PLAIN, 11));
		botonAsesino.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {				
				ArrayList<Ataque>a=new ArrayList<Ataque>();
				ArrayList<Objeto>o=new ArrayList<Objeto>();
				ArrayList<Consumible>cs=new ArrayList<Consumible>();				
				j=new Jugador(user,(short)40,(short)7,(short)1,a,(byte)80,o,cs,(byte)1,(byte)1,(byte)1,Clase.ASESINO);
			}
		});
		GridBagConstraints gbc_botonAsesino = new GridBagConstraints();
		gbc_botonAsesino.insets = new Insets(0, 0, 0, 5);
		gbc_botonAsesino.gridx = 11;
		gbc_botonAsesino.gridy = 7;
		add(botonAsesino, gbc_botonAsesino);
		
		
	}
	
	
}
