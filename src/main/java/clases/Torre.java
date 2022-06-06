package clases;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Torre {

	private ArrayList<Piso> torre;

	public Torre() {
		super();
		this.torre = new ArrayList<Piso>();
		for (byte k = 0; k < 20; k++) {
			this.torre.add(new Piso());
			LugarPiso[][] p1 = new LugarPiso[5][5];
			for (byte i = 0; i < p1.length; i++) {
				for (byte j = 0; j < p1[i].length; j++) {
					p1[i][j] = new LugarPiso();
				}
			}
		}
		//Crea los enemigos y todo lo que pueda ir en los lugaresPiso y aleatoriamente insertalos en el piso que quieras
		Enemigo e1p1=new Enemigo(); //Crealo con todos los datos
		
	}
	
	private void colocaEnemigoEnPiso(byte nPiso,Enemigo e) {
		Random r=new Random();
		byte posFila=(byte)r.nextInt(this.torre.get(nPiso).getLp().length);
		byte posColumna=(byte)r.nextInt(this.torre.get(nPiso).getLp()[posFila].length);
		while(this.torre.get(nPiso).getLp()[posFila][posColumna].getE()!=null) {
			 posFila=(byte)r.nextInt(this.torre.get(nPiso).getLp().length);
			 posColumna=(byte)r.nextInt(this.torre.get(nPiso).getLp()[posFila].length);
		}
		this.torre.get(nPiso).getLp()[posFila][posColumna].setE(e);
	}
	
}
