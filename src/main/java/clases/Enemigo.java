package clases;

import java.util.ArrayList;
import java.util.Random;

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
		Enemigo selim=new Enemigo("Selim", (short)1500, (short)50, (short)50, this.getAtaques(),(byte) 70, Tipo.FISICO);
		en.add(selim);
		Enemigo barroman=new Enemigo("Barroman", (short)2000, (short)120, (short)100, this.getAtaques(),(byte) 30, Tipo.VIENTO);
		en.add(barroman);
		int enR=r.nextInt(en.size());
		return en.get(enR);
	}
}
