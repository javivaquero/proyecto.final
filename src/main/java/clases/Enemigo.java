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
	

	
	private void atacarJugador(Jugador j) {
		//los e son this
		Random r=new Random();
		Ataque atEn=e.getAtaques().get(r.nextInt(e.getAtaques().size()));
		byte acierto=(byte) r.nextInt(100);
		if(acierto<=atEn.getPrecision()) {
			short vJActual=(short) (j.getpVida()-(e.getpAtaque()+atEn.getPotencia())/j.getpDefensa());
			j.setpVida(vJActual);
			System.out.println(e.getNombre()+" usó "+atEn);
			System.out.println("Vida de "+j.getNombre()+" : "+j.getpVida());
		}else {
			System.out.println("El ataque de "+e.getNombre()+" falló!");
		}
	}

	public Enemigo listaEnemigos() {
		Random r=new Random();
		ArrayList<Enemigo>en=new ArrayList<Enemigo>();
		
		//0
		
		Enemigo e1=new Enemigo("e1", (short)20, (short)1, (short)2, this.getAtaques(),(byte) 55, Tipo.FISICO);
		ArrayList<Ataque>ataquese1=new ArrayList<Ataque>();
		ataquese1.add(this.listaAtaques().get(0));
		ataquese1.add(this.listaAtaques().get(1));
		e1.setAtaques(ataquese1);
		en.add(e1);
		
		//1
		
		Enemigo e2=new Enemigo("e2", (short)25, (short)2, (short)2, this.getAtaques(),(byte) 40, Tipo.HIELO);
		e2.setAtaques(ataquese1);
		en.add(e2);
		
		int enR=r.nextInt(en.size());
		return en.get(enR);
	}
	
	public ArrayList<Ataque> listaAtaques() {
		ArrayList<Ataque>listaAtaques=new ArrayList<Ataque>();
		//0
		Ataque a1=new Ataque("a1",(short)3,(byte)60,Tipo.HIELO);
		listaAtaques.add(a1);
		//1
		Ataque a2=new Ataque("a2",(short)2,(byte)100,Tipo.FISICO);
		listaAtaques.add(a2);
		return listaAtaques;
	}
}
