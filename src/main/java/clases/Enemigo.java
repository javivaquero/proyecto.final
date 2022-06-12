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

/**
 * Clase Enemigo: Objeto que peleará contra el jugador en cada combate.
 * @author Javi
 *
 */

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
	/**
	 * 
	 * @param nombre: Nombre del enemigo
	 * @param pVida: Puntos de vida del enemigo, cuando este valor llega a 0. el enemigo muere.
	 * @param pAtaque: Puntos de ataque del enemigo potencia base de los ataques de un enemigo.
	 * @param pDefensa: Puntos de defensa de un enemigo.
	 * @param ataques: Lista de ataques de un enemigo.
	 * @param pVelocidad: Velocidad base de un enemigo.
	 * @param tipo: Tipo de un enemigo, dependiendo del mismo, podría recibir más daño del jugador.
	 * @param saga: Nombre del juego o la saga en la que aparece el enemigo.
	 * @param fLanzamiento: Fecha de lanzamiento de la saga.
	 */
	public Enemigo(String nombre, short pVida, short pAtaque, short pDefensa, ArrayList<Ataque> ataques,
			byte pVelocidad, Tipo tipo,String saga, String fLanzamiento) {
		super(nombre, pVida, pAtaque, pDefensa, ataques, pVelocidad);
		this.tipo = tipo;
		this.saga=saga;
		this.fLanzamiento=fLanzamiento;
	}
	
	public Enemigo() {
		
	}
	/**
	 * 
	 * @param j jugador recibido por argumentos
	 * @param a ataque recibido por argumentos
	 * 
	 * Hace el cálculo del daño que recibirá el jugador del enemigo en ese turno.
	 */
	public void atacarJugador(Jugador j,Ataque a) {
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
	
	/**
	 * 
	 * @param e: Valor recibido por argumentos que se refiere al piso actual del jugador.
	 * @return: Dependiendo del valor de e, devolverá al combate un enemigo.
	 * @throws IOException
	 */
	public Enemigo listaEnemigos(byte e) throws IOException {
		Random r=new Random();
		ArrayList<Enemigo>en=new ArrayList<Enemigo>();
		
		//0
		
		Enemigo e1=new Enemigo("Starman", (short)100, (short)2, (short)2, this.getAtaques(),(byte) 55, Tipo.FISICO,"Mother 2/EarthBound","1994");
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
		
		//4
		
		Enemigo e5=new Enemigo("Nemesis", (short)300, (short)6, (short)2, this.getAtaques(),(byte) 90, Tipo.FISICO,"Resident Evil 3","1999");
		
		ArrayList<Ataque>ataquese5=new ArrayList<Ataque>();
		ataquese5.add(this.listaAtaques().get(11));
		ataquese5.add(this.listaAtaques().get(12));
		e5.setAtaques(ataquese5);
		en.add(e5);
		
		//5
		
		Enemigo e6=new Enemigo("Slime", (short)200, (short)5, (short)2, this.getAtaques(),(byte) 90, Tipo.HIELO,"Dragon Quest 3","1986");
		
		ArrayList<Ataque>ataquese6=new ArrayList<Ataque>();
		ataquese6.add(this.listaAtaques().get(13));
		ataquese6.add(this.listaAtaques().get(14));
		e6.setAtaques(ataquese6);
		en.add(e6);
		//6
		
		Enemigo e7=new Enemigo("Mother Brain", (short)400, (short)7, (short)2, this.getAtaques(),(byte) 90, Tipo.ELECTRICO,"Metroid","1986");
		
		ArrayList<Ataque>ataquese7=new ArrayList<Ataque>();
		ataquese7.add(this.listaAtaques().get(15));
		ataquese7.add(this.listaAtaques().get(16));
		e7.setAtaques(ataquese7);
		en.add(e7);
		//7
		
		Enemigo e8=new Enemigo("Ganon", (short)450, (short)8, (short)2, this.getAtaques(),(byte) 90, Tipo.FUEGO,"The Legend of Zelda","1991");
		
		ArrayList<Ataque>ataquese8=new ArrayList<Ataque>();
		ataquese8.add(this.listaAtaques().get(17));
		ataquese8.add(this.listaAtaques().get(18));
		e8.setAtaques(ataquese8);
		en.add(e8);
		//8

		Enemigo e9=new Enemigo("Chocobo", (short)400, (short)5, (short)2, this.getAtaques(),(byte) 90, Tipo.ELECTRICO,"Final Fantasy 3","1987");
		
		ArrayList<Ataque>ataquese9=new ArrayList<Ataque>();
		ataquese9.add(this.listaAtaques().get(19));
		ataquese9.add(this.listaAtaques().get(20));
		e9.setAtaques(ataquese9);
		en.add(e9);
		
		//9
		
		Enemigo e10=new Enemigo("Bowser", (short)620, (short)6, (short)1, this.getAtaques(),(byte) 90, Tipo.FISICO,"Super Mario Bros.","1985");
		ArrayList<Ataque>ataquese10=new ArrayList<Ataque>();
		ataquese10.add(this.listaAtaques().get(21));
		ataquese10.add(this.listaAtaques().get(22));
		e10.setAtaques(ataquese10);
		en.add(e10);
		
		//10
		
		Enemigo e11=new Enemigo("Barroman", (short)70, (short)1, (short)1, this.getAtaques(),(byte) 90, Tipo.FISICO,"LOL","Es coña esta te la regalo");
		
		ArrayList<Ataque>ataquese11=new ArrayList<Ataque>();
		ataquese11.add(this.listaAtaques().get(5));

		e11.setAtaques(ataquese11);
		en.add(e11);
		//11
		
		Enemigo e12=new Enemigo("Tu", (short)1, (short)1, (short)1, this.getAtaques(),(byte) 90, Tipo.HIELO,"No ha sido tan dificil","eh?");
		
		ArrayList<Ataque>ataquese12=new ArrayList<Ataque>();
		ataquese12.add(this.listaAtaques().get(5));
		e12.setAtaques(ataquese12);
		en.add(e12);
		
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
	/**
	 * 
	 * @return: Devuelve una lista con todos los ataques de todos los enemigos del juego. Se incluyen en listaEnemigos.
	 */
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
		//11 n
		Ataque a12=new Ataque("Hostion",(short)45,(byte)90,Tipo.FISICO,(byte)0);
		listaAtaques.add(a12);
		//12 n
		Ataque a13=new Ataque("Lanzacohetes",(short)38,(byte)70,Tipo.FISICO,(byte)0);
		listaAtaques.add(a13);
		//13 sl
		Ataque a14=new Ataque("Golpe",(short)25,(byte)100,Tipo.FISICO,(byte)0);
		listaAtaques.add(a14);
		//14 sl
		Ataque a15=new Ataque("Salpicon",(short)22,(byte)80,Tipo.HIELO,(byte)0);
		listaAtaques.add(a15);
		//15 mb
		Ataque a16=new Ataque("Rayo laser",(short)30,(byte)80,Tipo.ELECTRICO,(byte)0);
		listaAtaques.add(a16);
		//16 mb
		Ataque a17=new Ataque("Manotazo",(short)28,(byte)100,Tipo.FISICO,(byte)0);
		listaAtaques.add(a17);
		//17 gn
		Ataque a18=new Ataque("Espadazo",(short)38,(byte)100,Tipo.FISICO,(byte)0);
		listaAtaques.add(a18);
		//18 gn
		Ataque a19=new Ataque("Arañazo",(short)30,(byte)100,Tipo.FISICO,(byte)0);
		listaAtaques.add(a19);
		//19 ch
		Ataque a20=new Ataque("Picotazo",(short)27,(byte)100,Tipo.FISICO,(byte)0);
		listaAtaques.add(a20);
		//20 ch
		Ataque a21=new Ataque("Vendaval",(short)25,(byte)100,Tipo.HIELO,(byte)0);
		listaAtaques.add(a21);
		//21 b
		Ataque a22=new Ataque("Lanzallamas",(short)40,(byte)100,Tipo.FUEGO,(byte)0);
		listaAtaques.add(a22);
		//22 b
		Ataque a23=new Ataque("Bola pinchos",(short)30,(byte)100,Tipo.FISICO,(byte)0);
		listaAtaques.add(a23);
		return listaAtaques;
	}
}
