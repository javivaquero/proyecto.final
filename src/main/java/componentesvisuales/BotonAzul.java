package componentesvisuales;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BotonAzul extends BotonVerde {
	
	public BotonAzul(String s) {
		super(s);
		estilosPorDefecto();
		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				setForeground(new Color(100, 255, 255));
				setBackground(new Color(100, 0, 255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				estilosPorDefecto();
			}
		});
	}
	
	private void estilosPorDefecto() {
		this.setForeground(new Color(255, 255, 255));
		this.setBackground(new Color(50, 0, 255));
	}

}
