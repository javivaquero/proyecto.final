package componentesvisuales;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
/**
 * Estilo por defecto de un tipo de botón de las interfaces.
 * @author Javi
 *
 */
public class BotonI extends JButton {
	
	public BotonI(String s) {
		super(s);
		estilosPorDefecto();
	}
	
	private void estilosPorDefecto() {
		this.setOpaque(false);
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);
		this.setFont(new Font("StatusPlz", Font.PLAIN, 10));
		this.setForeground(Color.WHITE);
	}
}
