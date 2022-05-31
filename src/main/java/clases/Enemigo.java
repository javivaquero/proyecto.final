package clases;

import java.util.ArrayList;
import java.util.Random;
import clases.Ataque;
import enums.Tipo;

public class Enemigo extends Personaje {

	private Tipo tipo;
	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Enemigo(String nombre, short pVida, short pAtaque, short pDefensa, ArrayList<Ataque> ataques,
			byte pVelocidad, Tipo tipo) {
		super(nombre, pVida, pAtaque, pDefensa, ataques, pVelocidad);
		this.tipo = tipo;
	}
	
	public Enemigo() {
		
	}

	public Enemigo listaEnemigos() {
		Random r=new Random();
		ArrayList<Enemigo>en=new ArrayList<Enemigo>();
		
		//0
		
		Enemigo selim=new Enemigo("Selim", (short)20, (short)1, (short)2, this.getAtaques(),(byte) 55, Tipo.FISICO);
		ArrayList<Ataque>ataquesSelim=new ArrayList<Ataque>();
		ataquesSelim.add(this.listaAtaques().get(0));
		ataquesSelim.add(this.listaAtaques().get(1));
		selim.setAtaques(ataquesSelim);
		en.add(selim);
		
		//1
		
		Enemigo barroman=new Enemigo("Barroman", (short)25, (short)2, (short)2, this.getAtaques(),(byte) 40, Tipo.HIELO);
		barroman.setAtaques(ataquesSelim);
		en.add(barroman);
		
		int enR=r.nextInt(en.size());
		return en.get(enR);
	}
}
