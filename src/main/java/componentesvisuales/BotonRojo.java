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
		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				setForeground(new Color(200, 150, 150));
				setBackground(new Color(255, 102, 255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				estilosPorDefecto();
			}
		});
	}
	
	private void estilosPorDefecto() {
		this.setForeground(new Color(102, 0, 153));
		this.setFocusable(false);
		this.setBorder(
				new MatteBorder(3,3,3,3,new Color(200,0,0)));
		this.setFont(new Font("MV Boli", Font.BOLD, 20));
		this.setBackground(new Color(255, 102, 255));
	}
	
}
