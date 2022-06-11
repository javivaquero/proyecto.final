package interfacesgraficas;

import javax.swing.JPanel;

import clases.Jugador;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.Icon;

public class PantallaNuevoOpenente extends JPanel {
	public PantallaNuevoOpenente(Ventana v, Jugador j) {
		try {
			AudioInputStream audio = AudioSystem.getAudioInputStream(new File("./ost/nf.wav"));
			v.clip=AudioSystem.getClip();				
			v.clip.open(audio);
			v.clip.start();	
			
		} catch (UnsupportedAudioFileException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (LineUnavailableException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setBackground(Color.BLACK);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 1036, 778);
		add(panel);
		panel.setLayout(null);
		
		JLabel nc= new JLabel((new ImageIcon(this.getClass().getResource("nc.gif"))));
		nc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					v.irAPantallaC(v, j, "", null);
				} catch (IOException | LineUnavailableException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		});
		nc.setBounds(0, 0, 1036, 778);
		panel.add(nc);
		
		JLabel atextoContinuar = new JLabel("Click en cualquier parte para continuar");
		atextoContinuar.setForeground(Color.WHITE);
		atextoContinuar.setFont(new Font("Verdana", Font.PLAIN, 14));
		atextoContinuar.setBounds(667, 569, 359, 93);
		panel.add(atextoContinuar);
		
	}
}
