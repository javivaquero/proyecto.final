package componentesvisuales;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class JLComb extends JLabel{
	/**
	 * Estilo por defecto de un tipo de JLabel de las interfaces.
	 * @author Javi
	 *
	 */
	public JLComb(String s) {
		super(s);
		estilosPorDefecto();
	}
	
	private void estilosPorDefecto() {
	
		this.setFont(new Font("StatusPlz", Font.PLAIN, 10));
		this.setForeground(Color.WHITE);
	
	}
	
}
