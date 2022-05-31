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
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class PantallaSeleccionClase extends JPanel{

	private Ventana ventana;

	public PantallaSeleccionClase(Ventana ventana, String user) {
		super();
		this.ventana = ventana;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{47, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JButton botonMago = new JButton("Mago");
		botonMago.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			ArrayList<Ataque>a=new ArrayList<Ataque>();
			ArrayList<Objeto>o=new ArrayList<Objeto>();
			ArrayList<Consumible>cs=new ArrayList<Consumible>();
			Jugador j=new Jugador(user,(short)60,(short)5,(short)1,a,(byte)40,o,cs,(byte)1,(byte)1,(byte)1,Clase.MAGO);
			Combate c=new Combate(j);
			}
		});
		GridBagConstraints gbc_botonMago = new GridBagConstraints();
		gbc_botonMago.insets = new Insets(0, 0, 0, 5);
		gbc_botonMago.gridx = 2;
		gbc_botonMago.gridy = 7;
		add(botonMago, gbc_botonMago);
		
		JButton botonTanque = new JButton("Tanque");
		botonTanque.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ArrayList<Ataque>a=new ArrayList<Ataque>();
				ArrayList<Objeto>o=new ArrayList<Objeto>();
				ArrayList<Consumible>cs=new ArrayList<Consumible>();
				Jugador j=new Jugador(user,(short)100,(short)2,(short)3,a,(byte)30,o,cs,(byte)1,(byte)1,(byte)1,Clase.TANQUE);
			}
		});
		GridBagConstraints gbc_botonTanque = new GridBagConstraints();
		gbc_botonTanque.insets = new Insets(0, 0, 0, 5);
		gbc_botonTanque.gridx = 5;
		gbc_botonTanque.gridy = 7;
		add(botonTanque, gbc_botonTanque);
		
		JButton botonArquero = new JButton("Arquero");
		botonArquero.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ArrayList<Ataque>a=new ArrayList<Ataque>();
				ArrayList<Objeto>o=new ArrayList<Objeto>();
				ArrayList<Consumible>cs=new ArrayList<Consumible>();				
				Jugador j=new Jugador(user,(short)65,(short)4,(short)2,a,(byte)60,o,cs,(byte)1,(byte)1,(byte)1,Clase.ARQUERO);
			}
		});
		GridBagConstraints gbc_botonArquero = new GridBagConstraints();
		gbc_botonArquero.insets = new Insets(0, 0, 0, 5);
		gbc_botonArquero.gridx = 8;
		gbc_botonArquero.gridy = 7;
		add(botonArquero, gbc_botonArquero);
		
		JButton botonAsesino = new JButton("Asesino");
		botonAsesino.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {				
				ArrayList<Ataque>a=new ArrayList<Ataque>();
				ArrayList<Objeto>o=new ArrayList<Objeto>();
				ArrayList<Consumible>cs=new ArrayList<Consumible>();				
				Jugador j=new Jugador(user,(short)40,(short)7,(short)1,a,(byte)80,o,cs,(byte)1,(byte)1,(byte)1,Clase.ASESINO);
			}
		});
		GridBagConstraints gbc_botonAsesino = new GridBagConstraints();
		gbc_botonAsesino.insets = new Insets(0, 0, 0, 5);
		gbc_botonAsesino.gridx = 11;
		gbc_botonAsesino.gridy = 7;
		add(botonAsesino, gbc_botonAsesino);
	}
	
	
}
