package clases;

import java.util.ArrayList;
import java.util.Random;

public class Combate {
	
	private Jugador j;
	private Enemigo e;
	
		
	
	public Combate(Jugador j) {
		super();
		this.j = j;
		e=new Enemigo();
		e=e.listaEnemigos();
		int tEn=0;
		int tJug=0;
		if(e.getpVelocidad()<j.getpVelocidad()) {
			atacarEnemigo(j,e);
			tEn++;
		}else {
			atacarJugador(j,e);
			tJug++;
		}
		while(e.getpVida()>0&&j.getpVida()>0) {
			
			if(tJug>tEn) {
			atacarEnemigo(j,e);
			tEn++;
			}
			atacarJugador(j,e);
			tJug++;
		}
		
	}

	private void atacarEnemigo(Jugador j, Enemigo e) {
			Random r=new Random();
			short vEActual=(short) (e.getpVida()-(j.getpAtaque()-e.getpDefensa()/2));
			e.setpVida(vEActual);
			System.out.println(j.getNombre()+" usó ");
			System.out.println("Vida de "+e.getNombre()+" : "+e.getpVida());
		}
		
		private void atacarJugador(Jugador j, Enemigo e) {
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
	
}
