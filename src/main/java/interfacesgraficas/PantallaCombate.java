package interfacesgraficas;

import javax.swing.JPanel;
import clases.Ataque;
import clases.Enemigo;
import clases.Jugador;
import componentesvisuales.BotonI;
import componentesvisuales.JLComb;


import java.awt.GridBagLayout;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.Icon;

public class PantallaCombate extends JPanel{
	private Enemigo ene;
	ImageIcon sprite;
	private String m;
	public PantallaCombate(Ventana v,Jugador j,String m,Enemigo en) throws IOException, LineUnavailableException {		
		if(en==null) {		
			en=new Enemigo();			
			switch(j.getPiso()) {
			
			//PISO 1
			
			case 1:
				en=en.listaEnemigos((byte) 0);
				try {										
					AudioInputStream audio=AudioSystem.getAudioInputStream(new File("./ost/1.wav"));		
					v.clip=AudioSystem.getClip();					
					v.clip.open(audio);
					v.clip.start();
					
				} catch (UnsupportedAudioFileException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();	
				}
			break;
			
			//PISO 2
			
			case 2:
				en=en.listaEnemigos((byte) 1);
				try {					
					AudioInputStream audio=AudioSystem.getAudioInputStream(new File("./ost/2.wav"));
					v.clip.close();
					v.clip=AudioSystem.getClip();				
					v.clip.open(audio);
					v.clip.start();		
				} catch (UnsupportedAudioFileException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();	
				}
				break;			
			}
			this.ene=en;
			
		}else {
			this.ene=en;
		}
		
		BufferedImage vFImg = ImageIO.read(new File("imagenes/vFondo.png"));
		setBackground(Color.BLACK);
		Random r= new Random();
		setLayout(null);
		switch(j.getPiso()) {
		//ENEMIGO 1
		case 1:
			sprite=new ImageIcon("./imagenes/e1.png");
			break;
		//ENEMIGO 2	
		case 2:
			sprite=new ImageIcon("./imagenes/e2.png");
			break;
		}
		JPanel panelAccion = new JPanel();
		panelAccion.setBorder(new LineBorder(Color.WHITE));
		panelAccion.setBackground(Color.BLACK);
		panelAccion.setBounds(29, 11, 213, 67);
		add(panelAccion);
		panelAccion.setLayout(null);
		
		JButton ataque0 = new BotonI(j.getAtaques().get(0).toString());
		ataque0.setBounds(17, 33, 87, 23);
		panelAccion.add(ataque0);
		
		JButton ataque1 = new BotonI(j.getAtaques().get(1).toString());
		ataque1.setBounds(17, 5, 87, 23);
		panelAccion.add(ataque1);
		ataque1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				byte na=1;
				Ataque a =new Ataque();
				a=j.getAtaques().get(1);
					try {
						j.atacarEnemigo(ene, a, na);
						if(ene.getpVida()>0) {
							v.irAPantallaAE(v, j, m, ene,sprite);
						}else {
							
							j.setPiso((byte) (j.getPiso()+1));					
							v.irAPantallaC(v, j, "", null);
						}
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (LineUnavailableException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		
		JButton ataque2 =new BotonI(j.getAtaques().get(2).toString());
		ataque2.setBounds(109, 5, 87, 23);
		panelAccion.add(ataque2);
		ataque2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				byte na=2;
				Ataque a =new Ataque();
				a=j.getAtaques().get(2);
					try {
						j.atacarEnemigo(ene, a, na);
						if(ene.getpVida()>0) {
							
							v.irAPantallaAE(v, j, m, ene,sprite);
						}else {
							
							j.setPiso((byte) (j.getPiso()+1));
							v.irAPantallaC(v, j, "", null);
							
						}
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (LineUnavailableException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		
		JButton ataque3 = new BotonI(j.getAtaques().get(3).toString());
		ataque3.setBounds(109, 33, 87, 23);
		panelAccion.add(ataque3);
		
		JPanel panelVida = new JPanel();
		panelVida.setBounds(400, 554, 199, 214);
		panelVida.setOpaque(false);
		add(panelVida);
		panelVida.setLayout(null);
		
		JLComb nombreJ = new JLComb(""+j.getNombre());
		nombreJ.setFont(new Font("StatusPlz", Font.PLAIN, 27));
		nombreJ.setHorizontalAlignment(SwingConstants.CENTER);
		nombreJ.setBounds(0, 24, 199, 49);
		panelVida.add(nombreJ);
		
		JLabel vJugador = new JLabel(""+j.getpVida());
		vJugador.setHorizontalAlignment(SwingConstants.CENTER);
		vJugador.setForeground(Color.BLACK);
		vJugador.setFont(new Font("StatusPlz", Font.PLAIN, 36));
		vJugador.setBounds(95, 89, 104, 34);
		panelVida.add(vJugador);
		
		JLabel zimgFVida = new JLabel(new ImageIcon(vFImg));
		zimgFVida.setBounds(0, 0, 199, 214);
		panelVida.add(zimgFVida);
		
		JLabel aSprite = new JLabel(sprite);
		aSprite.setBounds(168, 185, 639, 300);
		add(aSprite);
		
		JLabel imgFondo = new JLabel(new ImageIcon(this.getClass().getResource("f1.gif")));
		imgFondo.setBounds(-104, 141, 1260, 373);
		add(imgFondo);
		JLabel texto = new JLabel(m);
		JPanel panelM = new JPanel();
		panelM.setLayout(null);
		panelM.setBorder(new LineBorder(Color.WHITE));
		panelM.setBackground(Color.BLACK);
		panelM.setBounds(284, 11, 714, 67);
		add(panelM);
		texto.setForeground(Color.WHITE);
		texto.setHorizontalAlignment(SwingConstants.CENTER);
		texto.setFont(new Font("StatusPlz", Font.PLAIN, 17));
		texto.setBounds(0, 0, 714, 67);
		panelM.add(texto);
		
		
		ataque3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				byte na=3;
				Ataque a =new Ataque();
				a=j.getAtaques().get(3);
					try {
						j.atacarEnemigo(ene, a, na);
						if(ene.getpVida()>0) {
							v.irAPantallaAE(v, j, m, ene,sprite);
							
						}else {
							
							j.setPiso((byte) (j.getPiso()+1));
							v.irAPantallaC(v, j, "", null);
						}
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (LineUnavailableException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		ataque0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				byte na=0;
				Ataque a =new Ataque();
				a=j.getAtaques().get(0);
					try {
						j.atacarEnemigo(ene, a, na);
						if(ene.getpVida()>0) {
							v.irAPantallaAE(v, j, m, ene,sprite);
							
						}else {						
							
							j.setPiso((byte) (j.getPiso()+1));
							v.irAPantallaC(v, j, "", null);
						}
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (LineUnavailableException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
			}
		});
	}
}

