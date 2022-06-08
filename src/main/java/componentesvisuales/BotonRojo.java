package componentesvisuales;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.border.MatteBorder;

public class BotonRojo extends JButton {

	public BotonRojo(String s) {
		super(s);
		estilosPorDefecto();
	}
	
	private void estilosPorDefecto() {
		this.setOpaque(false);
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);
		this.setFont(new Font("StatusPlz", Font.BOLD, 10));
	
	}
	
}
