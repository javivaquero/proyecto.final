package interfacesgraficas;

import javax.swing.JPanel;
import clases.Ataque;
import clases.Consumible;
import clases.ConsumibleCurativo;
import clases.ConsumibleMasPP;
import clases.Enemigo;
import clases.Jugador;
import clases.Objeto;
import componentesvisuales.BotonI;
import componentesvisuales.JLComb;


import java.awt.GridBagLayout;
import java.awt.GridLayout;

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
import java.util.ArrayList;
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
import javax.swing.JList;

public class PantallaCombate extends JPanel{
	private Enemigo ene;
	protected ImageIcon sprite;
	private String men;

	public PantallaCombate(Ventana v,Jugador j,String m,Enemigo en) throws IOException, LineUnavailableException {		
		this.men=m;
		
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
					v.clip.loop(Clip.LOOP_CONTINUOUSLY);
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
					v.clip=AudioSystem.getClip();				
					v.clip.open(audio);
					v.clip.start();	
					v.clip.loop(Clip.LOOP_CONTINUOUSLY);
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
		panelAccion.setBounds(60, 481, 275, 258);
		add(panelAccion);
		panelAccion.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton ataque0 = new BotonI(j.getAtaques().get(0).toString());
		ataque0.setBorder(new LineBorder(Color.WHITE));
		ataque0.setFont(new Font("StatusPlz", Font.PLAIN, 16));
		ataque0.setBounds(17, 33, 87, 23);
		panelAccion.add(ataque0);
		
		JButton ataque1 = new BotonI(j.getAtaques().get(1).toString());
		ataque1.setBorderPainted(true);
		ataque1.setBorder(new LineBorder(Color.WHITE));
		ataque1.setFont(new Font("StatusPlz", Font.PLAIN, 16));
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
							men=j.getNombre()+" uso: "+a.getNombre()+".";
							v.irAPantallaAE(v, j, men, ene,sprite);
						}else {
							v.clip.close();
							j.setPiso((byte) (j.getPiso()+1));					
							v.irAPantallaO(v,j);
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
		ataque2.setBorderPainted(true);
		ataque2.setBorder(new LineBorder(Color.WHITE));
		ataque2.setFont(new Font("StatusPlz", Font.PLAIN, 16));
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
							men=j.getNombre()+" uso: "+a.getNombre()+".";
							v.irAPantallaAE(v, j, men, ene,sprite);
						}else {
							v.clip.close();
							j.setPiso((byte) (j.getPiso()+1));
							v.irAPantallaO(v,j);
							
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
		ataque3.setBorder(new LineBorder(Color.WHITE));
		ataque3.setBorderPainted(true);
		ataque3.setFont(new Font("StatusPlz", Font.PLAIN, 16));
		ataque3.setBounds(109, 33, 87, 23);
		panelAccion.add(ataque3);
		
		JButton cCurativo = new BotonI("Pocion vida");
		cCurativo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ArrayList<Consumible>c=j.getInventario();
				boolean encontrado=false;
				for (byte i=0;i<c.size();i++) {
					if(c.get(i).getNombre().equals("Lata cerveza hacendado")||c.get(i).getNombre().equals("Porro")) {
						ConsumibleCurativo cc=(ConsumibleCurativo) c.get(i);
						j.setpVida((short) (j.getpVida()+cc.getpVRestaurados()));
						c.remove(i);
						encontrado=true;
						break;
					}
					
				}
				if(encontrado==true) {
				try {
					v.irAPantallaAE(v, j, men, ene, sprite);
				} catch (IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}else {
					try {
						v.irAPantallaC(v, j, men, ene);
					} catch (IOException | LineUnavailableException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		cCurativo.setFont(new Font("StatusPlz", Font.PLAIN, 14));
		cCurativo.setBorderPainted(true);
		cCurativo.setBorder(new LineBorder(new Color(255, 255, 255)));
		panelAccion.add(cCurativo);
		
		
		
		JButton cMasPP = new BotonI("Mas PP");
		cMasPP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ArrayList<Consumible>c=j.getInventario();
				boolean encontrado=false;
				for (byte i=0;i<c.size();i++) {
					if(c.get(i).getNombre().equals("Vino Don Simon")||c.get(i).getNombre().equals("Humunculo")) {
						ConsumibleMasPP cc=(ConsumibleMasPP) c.get(i);
						j.setPp((byte) ((short) (j.getpVida()+cc.getPpAumentados())));
						c.remove(i);
						encontrado=true;
						break;
					}
					
				}
				if(encontrado==true) {
				try {
					v.irAPantallaAE(v, j, men, ene, sprite);
				} catch (IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}else {
					try {
						v.irAPantallaC(v, j, men, ene);
					} catch (IOException | LineUnavailableException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		cMasPP.setFont(new Font("StatusPlz", Font.PLAIN, 14));
		cMasPP.setBorderPainted(true);
		cMasPP.setBorder(new LineBorder(Color.WHITE));
		panelAccion.add(cMasPP);
		
		JLabel seleccionaA = new JLabel("Selecciona");
		seleccionaA.setHorizontalAlignment(SwingConstants.CENTER);
		seleccionaA.setForeground(Color.WHITE);
		seleccionaA.setBackground(Color.BLACK);
		seleccionaA.setFont(new Font("StatusPlz", Font.PLAIN, 18));
		panelAccion.add(seleccionaA);
		
		JLabel accion = new JLabel("Accion");
		accion.setBackground(Color.BLACK);
		accion.setHorizontalAlignment(SwingConstants.CENTER);
		accion.setForeground(Color.WHITE);
		accion.setFont(new Font("StatusPlz", Font.PLAIN, 21));
		panelAccion.add(accion);
		
		JPanel panelVida = new JPanel();
		panelVida.setBounds(392, 525, 199, 214);
		panelVida.setOpaque(false);
		add(panelVida);
		panelVida.setLayout(null);
		
		JLComb nombreJ = new JLComb(""+j.getNombre());
		nombreJ.setFont(new Font("StatusPlz", Font.PLAIN, 27));
		nombreJ.setHorizontalAlignment(SwingConstants.CENTER);
		nombreJ.setBounds(0, 24, 199, 49);
		panelVida.add(nombreJ);
		
		JLabel vJugador = new JLabel(""+j.getpVida()+"");
		vJugador.setHorizontalAlignment(SwingConstants.CENTER);
		vJugador.setForeground(Color.BLACK);
		vJugador.setFont(new Font("Verdana", Font.PLAIN, 36));
		vJugador.setBounds(75, 84, 114, 34);
		panelVida.add(vJugador);
		
		JLabel pp_Juagador = new JLabel(""+j.getPp()+"");
		pp_Juagador.setHorizontalAlignment(SwingConstants.CENTER);
		pp_Juagador.setForeground(Color.BLACK);
		pp_Juagador.setFont(new Font("Verdana", Font.PLAIN, 36));
		pp_Juagador.setBounds(75, 139, 124, 34);
		panelVida.add(pp_Juagador);
		
		JLabel zimgFVida = new JLabel(new ImageIcon("./imagenes/vFondo.png"));
		zimgFVida.setBounds(0, 0, 199, 214);
		panelVida.add(zimgFVida);
		
		JLabel aSprite = new JLabel(sprite);
		aSprite.setBounds(168, 185, 639, 300);
		add(aSprite);
		JLabel texto = new JLabel(m);
		JPanel panelM = new JPanel();
		panelM.setLayout(null);
		panelM.setBorder(new LineBorder(Color.WHITE));
		panelM.setBackground(Color.BLACK);
		panelM.setBounds(60, 11, 903, 67);
		add(panelM);
		texto.setForeground(Color.WHITE);
		texto.setHorizontalAlignment(SwingConstants.CENTER);
		texto.setFont(new Font("StatusPlz", Font.PLAIN, 17));
		texto.setBounds(0, 0, 903, 67);
		panelM.add(texto);
		
		JPanel panelInfo = new JPanel();
		panelInfo.setBounds(60, 201, 331, 269);
		add(panelInfo);
		panelInfo.setLayout(null);
		panelInfo.setBorder(new LineBorder(Color.WHITE));
		panelInfo.setBackground(Color.BLACK);
		panelInfo.setVisible(true);
		
		JLabel saga  = new JLabel("Saga:  "+en.getSaga());
		saga.setHorizontalAlignment(SwingConstants.LEFT);
		saga.setForeground(Color.WHITE);
		saga.setFont(new Font("StatusPlz", Font.PLAIN, 18));
		saga.setBounds(1, 91, 330, 75);
		panelInfo.add(saga);
		
		JLabel fLanzamiento = new JLabel("Fecha de lanzamiento:  "+en.getfLanzamiento());
		fLanzamiento.setHorizontalAlignment(SwingConstants.LEFT);
		fLanzamiento.setForeground(Color.WHITE);
		fLanzamiento.setFont(new Font("StatusPlz", Font.PLAIN, 21));
		fLanzamiento.setBounds(1, 180, 330, 75);
		panelInfo.add(fLanzamiento);
		
		JLabel nombreEnemigo = new JLabel(en.getNombre());
		nombreEnemigo.setHorizontalAlignment(SwingConstants.CENTER);
		nombreEnemigo.setForeground(Color.WHITE);
		nombreEnemigo.setFont(new Font("StatusPlz", Font.PLAIN, 21));
		nombreEnemigo.setBorder(new LineBorder(Color.WHITE));
		nombreEnemigo.setBounds(0, 0, 331, 75);
		panelInfo.add(nombreEnemigo);
		
		JList listaConsumibles = new JList(j.getInventario().toArray());
		listaConsumibles.setFont(new Font("StatusPlz", Font.PLAIN, 14));
		listaConsumibles.setBorder(new LineBorder(Color.WHITE));
		listaConsumibles.setForeground(Color.WHITE);
		listaConsumibles.setBackground(Color.BLACK);
		listaConsumibles.setBounds(661, 481, 132, 258);
		add(listaConsumibles);
		
		JLabel Objetos = new JLabel("Objetos");
		Objetos.setBackground(Color.BLACK);
		Objetos.setHorizontalAlignment(SwingConstants.CENTER);
		Objetos.setForeground(Color.WHITE);
		Objetos.setFont(new Font("StatusPlz", Font.PLAIN, 11));
		Objetos.setBorder(new LineBorder(Color.WHITE));
		Objetos.setBounds(792, 440, 132, 45);
		Objetos.setOpaque(true);
		add(Objetos);
		
		JLabel Consumibles = new JLabel("Consumibles");
		Consumibles.setBackground(Color.BLACK);
		Consumibles.setHorizontalAlignment(SwingConstants.CENTER);
		Consumibles.setForeground(Color.WHITE);
		Consumibles.setFont(new Font("StatusPlz", Font.PLAIN, 11));
		Consumibles.setBorder(new LineBorder(Color.WHITE));
		Consumibles.setBounds(661, 440, 132, 45);
		Consumibles.setOpaque(true);
		add(Consumibles);
		JList listaObjetos =  new JList(j.getObjetos().toArray());
		listaObjetos.setFont(new Font("StatusPlz", Font.PLAIN, 11));
		listaObjetos.setForeground(Color.WHITE);
		listaObjetos.setBackground(Color.BLACK);
		listaObjetos.setBorder(new LineBorder(Color.WHITE));
		listaObjetos.setBounds(792, 481, 132, 258);
		add(listaObjetos);
		
		JLabel imgFondo = new JLabel((new ImageIcon(this.getClass().getResource("f1.gif"))));
		imgFondo.setBounds(0, 0, 1023, 768);
		add(imgFondo);
		
		
		ataque3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				byte na=3;
				Ataque a =new Ataque();
				a=j.getAtaques().get(3);
					try {
						j.atacarEnemigo(ene, a, na);
						if(ene.getpVida()>0) {
							men=j.getNombre()+" uso: "+a.getNombre()+".";
							v.irAPantallaAE(v, j, men, ene,sprite);
							
						}else {
							v.clip.close();
							j.setPiso((byte) (j.getPiso()+1));
							v.irAPantallaO(v,j);
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
							men=j.getNombre()+" uso: "+a.getNombre()+".";
							v.irAPantallaAE(v, j, men, ene,sprite);
							
						}else {						
							v.clip.close();
							j.setPiso((byte) (j.getPiso()+1));
							v.irAPantallaO(v,j);
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

