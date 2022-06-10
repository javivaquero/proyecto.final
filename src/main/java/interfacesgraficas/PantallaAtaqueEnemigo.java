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
		panelAccion.setBounds(29, 554, 275, 190);
		add(panelAccion);
		panelAccion.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton ataque1 = new BotonI(j.getAtaques().get(1).toString());
		ataque1.setFont(new Font("StatusPlz", Font.PLAIN, 16));
		panelAccion.add(ataque1);

		
		JButton ataque2 =new BotonI(j.getAtaques().get(2).toString());
		ataque2.setFont(new Font("StatusPlz", Font.PLAIN, 16));
		panelAccion.add(ataque2);
		
		JButton ataque0 = new BotonI(j.getAtaques().get(0).toString());
		ataque0.setFont(new Font("StatusPlz", Font.PLAIN, 16));
		panelAccion.add(ataque0);
		
		JButton ataque3 = new BotonI(j.getAtaques().get(3).toString());
		ataque3.setFont(new Font("StatusPlz", Font.PLAIN, 16));
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
		vJugador.setFont(new Font("Verdana", Font.PLAIN, 36));
		vJugador.setBounds(75, 84, 114, 34);
		panelVida.add(vJugador);
		
		JLabel zimgFVida = new JLabel(new ImageIcon(vFImg));
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
		panelM.setBounds(279, 11, 719, 67);
		add(panelM);
		texto.setForeground(Color.WHITE);
		texto.setHorizontalAlignment(SwingConstants.CENTER);
		texto.setFont(new Font("StatusPlz", Font.PLAIN, 17));
		texto.setBounds(0, 0, 719, 67);
		panelM.add(texto);	
		
		JLabel pasarTurno = new JLabel("Siguiente Turno");
		pasarTurno.setFont(new Font("StatusPlz", Font.PLAIN, 37));
		pasarTurno.setBorder(new LineBorder(Color.WHITE));
		pasarTurno.setHorizontalAlignment(SwingConstants.CENTER);
		pasarTurno.setForeground(Color.WHITE);
		pasarTurno.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
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
					System.exit(ABORT);
					
				}
			}
		});
		pasarTurno.setBounds(685, 554, 329, 190);
		add(pasarTurno);
		
		JPanel panelFondo = new JPanel();
		panelFondo.setBounds(0, 154, 1024, 357);
		add(panelFondo);
		
		JLabel imgFondo = new JLabel((Icon) null);
		panelFondo.add(imgFondo);
		
		
	
	
	}
}
