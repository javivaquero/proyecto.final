package interfacesgraficas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import clases.Ataque;
import clases.Jugador;
import clases.Objeto;
import componentesvisuales.BotonI;
import componentesvisuales.JLComb;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaSeleccionObjeto extends JPanel	{
	public PantallaSeleccionObjeto(Ventana v, Jugador j) throws IOException {
		
		try {
			AudioInputStream audio = AudioSystem.getAudioInputStream(new File("./ost/victory.wav"));
			v.clip=AudioSystem.getClip();				
			v.clip.open(audio);
			v.clip.start();	
			v.clip.loop(Clip.LOOP_CONTINUOUSLY);
		} catch (UnsupportedAudioFileException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (LineUnavailableException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}				
		setForeground(Color.BLACK);
		BufferedImage vFImg = ImageIO.read(new File("imagenes/vFondo.png"));
		setBackground(Color.BLACK);
		Random r= new Random();
		setLayout(null);
		JPanel panelAccion = new JPanel();
		panelAccion.setBorder(new LineBorder(Color.WHITE));
		panelAccion.setBackground(Color.BLACK);
		panelAccion.setBounds(10, 544, 1004, 153);
		add(panelAccion);
		panelAccion.setLayout(null);
		
		JButton botonMasVida = new BotonI(j.getAtaques().get(0).toString());
		botonMasVida.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ArrayList<Objeto>arrObjetos=j.getObjetos();
				arrObjetos.add(j.listaObjetosCurativos(j));
				
				j.setObjetos(arrObjetos);
				j.setpVida((short) (j.getpVida()+arrObjetos.get(arrObjetos.size()-1).getpVAumentados()));
				j.setpDefensa((short) (j.getpDefensa()+arrObjetos.get(arrObjetos.size()-1).getpDAumentados()));
				j.setpAtaque((short) (j.getpAtaque()+arrObjetos.get(arrObjetos.size()-1).getpAAumentados()));
				v.clip.close();
				try {
					v.irAPantallaNO(v, j);
				} catch (IOException | LineUnavailableException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				
			}
		});
		botonMasVida.setText("HP++");
		botonMasVida.setFont(new Font("StatusPlz", Font.PLAIN, 32));
		botonMasVida.setBounds(0, 0, 334, 153);
		panelAccion.add(botonMasVida);
		
		BotonI BotonMasDefensa = new BotonI((String) null);
		BotonMasDefensa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ArrayList<Objeto>arrObjetos=j.getObjetos();
				arrObjetos.add(j.listaObjetosDefensivos(j));
				
				j.setObjetos(arrObjetos);
				j.setpVida((short) (j.getpVida()+arrObjetos.get(arrObjetos.size()-1).getpVAumentados()));
				j.setpDefensa((short) (j.getpDefensa()+arrObjetos.get(arrObjetos.size()-1).getpDAumentados()));
				j.setpAtaque((short) (j.getpAtaque()+arrObjetos.get(arrObjetos.size()-1).getpAAumentados()));
				v.clip.close();
				try {
					v.irAPantallaNO(v, j);
				} catch (IOException | LineUnavailableException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		});
		BotonMasDefensa.setText("DEF++");
		BotonMasDefensa.setFont(new Font("StatusPlz", Font.PLAIN, 32));
		BotonMasDefensa.setBounds(344, 0, 334, 153);
		panelAccion.add(BotonMasDefensa);
		
		BotonI botonMasFuerza = new BotonI((String) null);
		botonMasFuerza.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ArrayList<Objeto>arrObjetos=j.getObjetos();
				arrObjetos.add(j.listaObjetosOfensivos(j));
				
				j.setObjetos(arrObjetos);
				j.setpVida((short) (j.getpVida()+arrObjetos.get(arrObjetos.size()-1).getpVAumentados()));
				j.setpDefensa((short) (j.getpDefensa()+arrObjetos.get(arrObjetos.size()-1).getpDAumentados()));
				j.setpAtaque((short) (j.getpAtaque()+arrObjetos.get(arrObjetos.size()-1).getpAAumentados()));
				v.clip.close();
				try {
					v.irAPantallaNO(v, j);
				} catch (IOException | LineUnavailableException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		});
		botonMasFuerza.setText("ATK++");
		botonMasFuerza.setFont(new Font("StatusPlz", Font.PLAIN, 32));
		botonMasFuerza.setBounds(688, 0, 316, 153);
		panelAccion.add(botonMasFuerza);
		JPanel panelM = new JPanel();
		panelM.setLayout(null);
		panelM.setBorder(new LineBorder(Color.WHITE));
		panelM.setBackground(Color.BLACK);
		panelM.setBounds(284, 11, 714, 67);
		add(panelM);
		JLabel texto = new JLabel();
		if(j.getPiso()%2==0) {
			texto.setText("Selecciona tu Nuevo Objeto, has recibido un consumible aleatorio.");
		}else {
			texto.setText("Selecciona tu Nuevo Objeto.");
		}
		
		texto.setForeground(Color.WHITE);
		texto.setHorizontalAlignment(SwingConstants.CENTER);
		texto.setFont(new Font("StatusPlz", Font.PLAIN, 26));
		texto.setBounds(0, 0, 714, 67);
		panelM.add(texto);
		
		
		
		


	}
}
