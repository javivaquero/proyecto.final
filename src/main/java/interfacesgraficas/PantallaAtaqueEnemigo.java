package interfacesgraficas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import clases.Ataque;
import clases.Enemigo;
import clases.Jugador;
import componentesvisuales.BotonI;
import componentesvisuales.JLComb;
import java.awt.GridLayout;
import javax.swing.Icon;
import java.awt.event.MouseMotionAdapter;

public class PantallaAtaqueEnemigo extends JPanel {
	private String men;
	public PantallaAtaqueEnemigo(Ventana v, Jugador j, String m, Enemigo en,ImageIcon sprite) throws IOException, LineUnavailableException {


		BufferedImage vFImg = ImageIO.read(new File("imagenes/vFondo.png"));
		setBackground(Color.BLACK);
		Random r= new Random();
		setLayout(null);
		
		
		JPanel panelAccion = new JPanel();
		panelAccion.setBorder(new LineBorder(Color.WHITE));
		panelAccion.setBackground(Color.BLACK);
		panelAccion.setBounds(60, 549, 275, 190);
		add(panelAccion);
		panelAccion.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton ataque1 = new BotonI(j.getAtaques().get(1).toString());
		ataque1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				Random r=new Random();
				Ataque at=en.getAtaques().get(r.nextInt(en.getAtaques().size()));
				en.atacarJugador(j,at);
				men="El enemigo uso "+at.getNombre()+", puntos de vida de "+en.getNombre()+": "+en.getpVida();
				if(j.getpVida()>0) {
					try {
						v.irAPantallaC(v, j, men, en);
					} catch (IOException | LineUnavailableException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
									
				}
			}
		});
		ataque1.setFont(new Font("StatusPlz", Font.PLAIN, 16));
		panelAccion.add(ataque1);

		
		JButton ataque2 =new BotonI(j.getAtaques().get(2).toString());
		ataque2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Random r=new Random();
				Ataque at=en.getAtaques().get(r.nextInt(en.getAtaques().size()));
				en.atacarJugador(j,at);
				men="El enemigo uso "+at.getNombre()+", puntos de vida de "+en.getNombre()+": "+en.getpVida();
				if(j.getpVida()>0) {
					try {
						v.irAPantallaC(v, j, men, en);
					} catch (IOException | LineUnavailableException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
								
				}
			}
		});
		ataque2.setFont(new Font("StatusPlz", Font.PLAIN, 16));
		panelAccion.add(ataque2);
		
		JButton ataque0 = new BotonI(j.getAtaques().get(0).toString());
		ataque0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Random r=new Random();
				Ataque at=en.getAtaques().get(r.nextInt(en.getAtaques().size()));
				en.atacarJugador(j,at);
				men="El enemigo uso "+at.getNombre()+", puntos de vida de "+en.getNombre()+": "+en.getpVida();
				if(j.getpVida()>0) {
					try {
						v.irAPantallaC(v, j, men, en);
					} catch (IOException | LineUnavailableException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
									
				}
			}
		});
		ataque0.setFont(new Font("StatusPlz", Font.PLAIN, 16));
		panelAccion.add(ataque0);
		
		JButton ataque3 = new BotonI(j.getAtaques().get(3).toString());
		ataque3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Random r=new Random();
				Ataque at=en.getAtaques().get(r.nextInt(en.getAtaques().size()));
				en.atacarJugador(j,at);
				men="El enemigo uso "+at.getNombre()+", puntos de vida de "+en.getNombre()+": "+en.getpVida();
				if(j.getpVida()>0) {
					try {
						v.irAPantallaC(v, j, men, en);
					} catch (IOException | LineUnavailableException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
								
				}
			}
		});
		ataque3.setFont(new Font("StatusPlz", Font.PLAIN, 16));
		panelAccion.add(ataque3);
		
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
		
		JLabel vJugador = new JLabel(""+j.getpVida());
		vJugador.setHorizontalAlignment(SwingConstants.CENTER);
		vJugador.setForeground(Color.BLACK);
		vJugador.setFont(new Font("Verdana", Font.PLAIN, 36));
		vJugador.setBounds(75, 84, 114, 34);
		panelVida.add(vJugador);
		
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
		
	
		
		JLabel atextoContinuar = new JLabel("Click en cualquier parte para continuar");
		atextoContinuar.setFont(new Font("Verdana", Font.PLAIN, 14));
		atextoContinuar.setBounds(642, 618, 359, 93);
		add(atextoContinuar);
		
		JLabel pp_Juagador = new JLabel(""+j.getPp()+"");
		pp_Juagador.setHorizontalAlignment(SwingConstants.CENTER);
		pp_Juagador.setForeground(Color.BLACK);
		pp_Juagador.setFont(new Font("Verdana", Font.PLAIN, 36));
		pp_Juagador.setBounds(75, 139, 124, 34);
		panelVida.add(pp_Juagador);
		
		JLabel zimgFVida = new JLabel(new ImageIcon("./imagenes/vFondo.png"));
		zimgFVida.setBounds(0, 0, 199, 214);
		panelVida.add(zimgFVida);
		
		JPanel panelInfo = new JPanel();
		panelInfo.setBounds(60, 201, 331, 269);
		add(panelInfo);
		panelInfo.setLayout(null);
		panelInfo.setBorder(new LineBorder(Color.WHITE));
		panelInfo.setBackground(Color.BLACK);
		panelInfo.setVisible(true);
		JLabel saga = new JLabel("Saga:  "+en.getSaga());
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
		
		JLabel imgFondo= new JLabel((new ImageIcon(this.getClass().getResource("f1.gif"))));
		imgFondo.setBounds(0, 0, 1023, 768);
		add(imgFondo);	
	}
}
