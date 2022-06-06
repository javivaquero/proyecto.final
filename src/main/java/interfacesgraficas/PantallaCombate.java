package interfacesgraficas;

import javax.swing.JPanel;

import clases.Combate;
import clases.Enemigo;
import clases.Jugador;

import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.GridBagConstraints;
import java.awt.Insets;

public class PantallaCombate extends JDialog{
	public PantallaCombate(Ventana v,Enemigo e) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		this.setUndecorated(true);
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		Combate c=new Combate(j);
		Combate c2=new Combate(j);
		JButton ataque0 = new JButton("New button");
		GridBagConstraints gbc_ataque0 = new GridBagConstraints();
		gbc_ataque0.insets = new Insets(0, 0, 0, 5);
		gbc_ataque0.gridx = 1;
		gbc_ataque0.gridy = 8;
		add(ataque0, gbc_ataque0);
		
		JButton ataque1 = new JButton("New button");
		GridBagConstraints gbc_ataque1 = new GridBagConstraints();
		gbc_ataque1.insets = new Insets(0, 0, 0, 5);
		gbc_ataque1.gridx = 3;
		gbc_ataque1.gridy = 8;
		add(ataque1, gbc_ataque1);
		
		JButton ataque2 = new JButton("New button");
		GridBagConstraints gbc_ataque2 = new GridBagConstraints();
		gbc_ataque2.insets = new Insets(0, 0, 0, 5);
		gbc_ataque2.gridx = 5;
		gbc_ataque2.gridy = 8;
		add(ataque2, gbc_ataque2);
		
		JButton ataque3 = new JButton("New button");
		GridBagConstraints gbc_ataque3 = new GridBagConstraints();
		gbc_ataque3.gridx = 7;
		gbc_ataque3.gridy = 8;
		add(ataque3, gbc_ataque3);
	}

	
	
}
