package interfacesgraficas;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import componentesvisuales.BotonI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class PantallaDerrota extends JPanel {
	
public PantallaDerrota(Ventana v) {
	setBackground(Color.BLACK);
	setLayout(null);
	
	JButton irALogin = new BotonI("Ir a Login");
	irALogin.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			try {
				v.irAPantalla(v);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	});
	irALogin.setText("Ir a Login");
	irALogin.setFont(new Font("StatusPlz", Font.PLAIN, 20));
	irALogin.setBounds(407, 492, 179, 115);
	add(irALogin);
	
	JLabel victoria = new JLabel("Derrota, pero puedes volver a intentarlo");
	victoria.setForeground(Color.WHITE);
	victoria.setFont(new Font("StatusPlz", Font.PLAIN, 30));
	victoria.setBounds(165, 257, 717, 154);
	add(victoria);
		
	}

}
