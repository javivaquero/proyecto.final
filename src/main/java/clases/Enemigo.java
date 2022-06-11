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
	private String saga;
	private String fLanzamiento;
	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Enemigo(String nombre, short pVida, short pAtaque, short pDefensa, ArrayList<Ataque> ataques,
			byte pVelocidad, Tipo tipo,String saga, String fLanzamiento) {
		super(nombre, pVida, pAtaque, pDefensa, ataques, pVelocidad);
		this.tipo = tipo;
		this.saga=saga;
		this.fLanzamiento=fLanzamiento;
	}
	
	public Enemigo() {
		
	}
	public void atacarJugador(Jugador j,Ataque a) {
		//los e son this
		Random r=new Random();
		Ataque atEn=a;
		byte acierto=(byte) r.nextInt(100);
		
		if(acierto<=atEn.getPrecision()) {
			short vJActual=j.getpVida();
			switch(j.getTipo()) {
			default:
				
				break;
			case FISICO:
				vJActual=(short) (j.getpVida()-(this.getpAtaque()+atEn.getPotencia())/j.getpDefensa());
				break;
			case FUEGO:
					if(j.getTipo()==Tipo.HIELO) {
						vJActual=(short) (j.getpVida()-(2)*(this.getpAtaque()+atEn.getPotencia())/j.getpDefensa());
					}else {
						vJActual=(short) (j.getpVida()-(this.getpAtaque()+atEn.getPotencia())/j.getpDefensa());
					}
				break;
			case ELECTRICO:
				if(j.getTipo()==Tipo.FUEGO) {
					vJActual=(short) (j.getpVida()-(2)*(this.getpAtaque()+atEn.getPotencia())/j.getpDefensa());
				}else {
					vJActual=(short) (j.getpVida()-(this.getpAtaque()+atEn.getPotencia())/j.getpDefensa());
				}
				break;
			case HIELO:
				if(j.getTipo()==Tipo.ELECTRICO) {
					vJActual=(short) (j.getpVida()-(2)*(this.getpAtaque()+atEn.getPotencia())/j.getpDefensa());
				}else {
					vJActual=(short) (j.getpVida()-(this.getpAtaque()+atEn.getPotencia())/j.getpDefensa());
				}
				break;
			}
			j.setpVida(vJActual);
		}
		
	}

	public Enemigo listaEnemigos(byte e) throws IOException {
		Random r=new Random();
		ArrayList<Enemigo>en=new ArrayList<Enemigo>();
		
		//0
		
		Enemigo e1=new Enemigo("Starman", (short)50, (short)1, (short)2, this.getAtaques(),(byte) 55, Tipo.FISICO,"Mother 2/EarthBound","1994");
		ArrayList<Ataque>ataquese1=new ArrayList<Ataque>();
		ataquese1.add(this.listaAtaques().get(0));
		ataquese1.add(this.listaAtaques().get(1));
		e1.setAtaques(ataquese1);
		en.add(e1);
		
		//1
		
		Enemigo e2=new Enemigo("Jack Frost", (short)150, (short)2, (short)2, this.getAtaques(),(byte) 40, Tipo.HIELO,"Shin Megami Tensei/Persona","1992");
		ArrayList<Ataque>ataquese2=new ArrayList<Ataque>();
		ataquese2.add(this.listaAtaques().get(2));
		ataquese2.add(this.listaAtaques().get(3));
		ataquese2.add(this.listaAtaques().get(4));
		ataquese2.add(this.listaAtaques().get(5));
		e2.setAtaques(ataquese2);
		en.add(e2);
		
		//2
		
		Enemigo e3=new Enemigo("Gyarados", (short)225, (short)3, (short)2, this.getAtaques(),(byte) 60, Tipo.HIELO,"Pokemon","1996");
		ArrayList<Ataque>ataquese3=new ArrayList<Ataque>();
		ataquese3.add(this.listaAtaques().get(6));
		ataquese3.add(this.listaAtaques().get(7));		
		ataquese3.add(this.listaAtaques().get(8));
		e3.setAtaques(ataquese3);
		en.add(e3);
		
		
		//3
		
		Enemigo e4=new Enemigo("Masked Man", (short)300, (short)5, (short)2, this.getAtaques(),(byte) 90, Tipo.HIELO,"Mother 3","2006");
		
		ArrayList<Ataque>ataquese4=new ArrayList<Ataque>();
		ataquese4.add(this.listaAtaques().get(9));
		ataquese4.add(this.listaAtaques().get(10));
		e4.setAtaques(ataquese4);
		en.add(e4);
		
		
		
		
		return en.get(e);
	}
	
	public String getSaga() {
		return saga;
	}

	public void setSaga(String saga) {
		this.saga = saga;
	}

	public String getfLanzamiento() {
		return fLanzamiento;
	}

	public void setfLanzamiento(String fLanzamiento) {
		this.fLanzamiento = fLanzamiento;
	}

	public ArrayList<Ataque> listaAtaques() {
		ArrayList<Ataque>listaAtaques=new ArrayList<Ataque>();
		//0
		Ataque a1=new Ataque("PK Freeze",(short)4,(byte)60,Tipo.HIELO,(byte)0);
		listaAtaques.add(a1);
		//1
		Ataque a2=new Ataque("PK Fire",(short)3,(byte)100,Tipo.FUEGO,(byte)0);
		listaAtaques.add(a2);
		//2
		Ataque a3=new Ataque("Bufudyne",(short)15,(byte)60,Tipo.HIELO,(byte)0);
		listaAtaques.add(a3);
		//3
		Ataque a4=new Ataque("Agidyne",(short)14,(byte)80,Tipo.FUEGO,(byte)0);
		listaAtaques.add(a4);
		//4
		Ataque a5=new Ataque("Ziodyne",(short)16,(byte)70,Tipo.ELECTRICO,(byte)0);
		listaAtaques.add(a5);
		//5
		Ataque a6=new Ataque("Carga",(short)10,(byte)100,Tipo.FISICO,(byte)0);
		listaAtaques.add(a5);
		//6
		Ataque a7=new Ataque("Surf",(short)20,(byte)85,Tipo.HIELO,(byte)0);
		listaAtaques.add(a7);
		//7
		Ataque a8=new Ataque("Hidrobomba",(short)30,(byte)50,Tipo.HIELO,(byte)0);
		listaAtaques.add(a8);
		//8
		Ataque a9=new Ataque("Rayo",(short)19,(byte)95,Tipo.ELECTRICO,(byte)0);
		listaAtaques.add(a9);
		//9
		Ataque a10=new Ataque("PK Thunder",(short)30,(byte)80,Tipo.ELECTRICO,(byte)0);
		listaAtaques.add(a10);
		//10
		Ataque a11=new Ataque("PK Flash",(short)35,(byte)60,Tipo.FISICO,(byte)0);
		listaAtaques.add(a11);
		
		
		return listaAtaques;
	}
}
