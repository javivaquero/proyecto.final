package clases;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

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
	
	//HACER QUE LO MANDE A m de PANTALLAATAQUEENEMIGO
	public void atacarJugador(Jugador j,Ataque a) {
		//los e son this
		Random r=new Random();
		Ataque atEn=a;
		byte acierto=(byte) r.nextInt(100);
		if(acierto<=atEn.getPrecision()) {
			short vJActual=(short) (j.getpVida()-(this.getpAtaque()+atEn.getPotencia())/j.getpDefensa());
			j.setpVida(vJActual);
			System.out.println(this.getNombre()+" usó "+atEn);
			System.out.println("Vida de "+j.getNombre()+" : "+j.getpVida());
		}else {
			System.out.println("El ataque de "+this.getNombre()+" falló!");
		}
	}

	public Enemigo listaEnemigos(byte e) throws IOException {
		Random r=new Random();
		ArrayList<Enemigo>en=new ArrayList<Enemigo>();
		
		//0
		
		Enemigo e1=new Enemigo("Starman", (short)20, (short)1, (short)2, this.getAtaques(),(byte) 55, Tipo.FISICO);
		ArrayList<Ataque>ataquese1=new ArrayList<Ataque>();
		ataquese1.add(this.listaAtaques().get(0));
		ataquese1.add(this.listaAtaques().get(1));
		e1.setAtaques(ataquese1);
		en.add(e1);
		
		//1
		
		Enemigo e2=new Enemigo("Jack Frost", (short)200, (short)2, (short)2, this.getAtaques(),(byte) 40, Tipo.HIELO);
		ArrayList<Ataque>ataquese2=new ArrayList<Ataque>();
		ataquese2.add(this.listaAtaques().get(2));
		ataquese2.add(this.listaAtaques().get(3));
		e2.setAtaques(ataquese2);
		en.add(e2);
		return en.get(e);
	}
	
	public ArrayList<Ataque> listaAtaques() {
		ArrayList<Ataque>listaAtaques=new ArrayList<Ataque>();
		//0
		Ataque a1=new Ataque("PK Freeze",(short)3,(byte)60,Tipo.HIELO);
		listaAtaques.add(a1);
		//1
		Ataque a2=new Ataque("PK Fire",(short)2,(byte)100,Tipo.FUEGO);
		listaAtaques.add(a2);
		//2
		Ataque a3=new Ataque("Bufudyne",(short)5,(byte)60,Tipo.HIELO);
		listaAtaques.add(a3);
		//3
		Ataque a4=new Ataque("Agidyne",(short)4,(byte)80,Tipo.FUEGO);
		listaAtaques.add(a4);
		return listaAtaques;
	}
}
