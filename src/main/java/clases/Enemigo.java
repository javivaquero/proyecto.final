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
	private ImageIcon eSprite;
	
	
	


	public ImageIcon geteSprite() {
		return eSprite;
	}

	public void seteSprite(ImageIcon eSprite) {
		this.eSprite = eSprite;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Enemigo(String nombre, short pVida, short pAtaque, short pDefensa, ArrayList<Ataque> ataques,
			byte pVelocidad, Tipo tipo, ImageIcon eSprite) {
		super(nombre, pVida, pAtaque, pDefensa, ataques, pVelocidad);
		this.tipo = tipo;
	}
	
	public Enemigo() {
		
	}
	

	
	
	private void atacarJugador(Jugador j) {
		//los e son this
		Random r=new Random();
		Ataque atEn=this.getAtaques().get(r.nextInt(this.getAtaques().size()));
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

	public Enemigo listaEnemigos() throws IOException {
		Random r=new Random();
		BufferedImage e1Sprite = ImageIO.read(new File("./imagenes/e1.png"));
		ArrayList<Enemigo>en=new ArrayList<Enemigo>();
		
		//0
		
		Enemigo e1=new Enemigo("e1", (short)20, (short)1, (short)2, this.getAtaques(),(byte) 55, Tipo.FISICO, eSprite=new ImageIcon(e1Sprite));
		ArrayList<Ataque>ataquese1=new ArrayList<Ataque>();
		ataquese1.add(this.listaAtaques().get(0));
		ataquese1.add(this.listaAtaques().get(1));
		e1.setAtaques(ataquese1);
		en.add(e1);
		
		//1
		
		Enemigo e2=new Enemigo("e2", (short)25, (short)2, (short)2, this.getAtaques(),(byte) 40, Tipo.HIELO,eSprite=new ImageIcon(e1Sprite));
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
