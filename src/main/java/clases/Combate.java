package clases;

import java.util.ArrayList;
import java.util.Random;

import enums.Tipo;

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
		do {
			if(tJug>tEn) {
			atacarEnemigo(j,e);
			tEn++;
			}
			atacarJugador(j,e);
			tJug++;
		}while(e.getpVida()>0&&j.getpVida()>0);
		this.j.setpVida(j.getpVida());
		
	}

	private void atacarEnemigo(Jugador j, Enemigo e) {
			Random r=new Random();
			Ataque atJ=j.getAtaques().get(r.nextInt(j.getAtaques().size()));
			byte acierto=(byte) r.nextInt(100);
			if(acierto<atJ.getPrecision()) {
			short vEActual=0;
			switch(atJ.getTipo()) {
			default:
				break;
			case FISICO:
					vEActual=(short) (e.getpVida()-(j.getpAtaque()+atJ.getPotencia())/j.getpDefensa());
				break;
			case FUEGO:
					if(e.getTipo()==Tipo.HIELO) {
						vEActual=(short) (e.getpVida()-(2)*(j.getpAtaque()+atJ.getPotencia())/j.getpDefensa());
					}
				break;
			case ELECTRICO:
				if(e.getTipo()==Tipo.FUEGO) {
					vEActual=(short) (e.getpVida()-(2)*(j.getpAtaque()+atJ.getPotencia())/j.getpDefensa());
				}
				break;
			case HIELO:
				if(e.getTipo()==Tipo.ELECTRICO) {
					vEActual=(short) (e.getpVida()-(2)*(j.getpAtaque()+atJ.getPotencia())/j.getpDefensa());
				}
				break;
			}
			e.setpVida(vEActual);
			System.out.println(j.getNombre()+" usó "+atJ.getNombre());
			System.out.println("Vida de "+e.getNombre()+" : "+e.getpVida());
			}else {
				System.out.println("El ataque de "+j.getNombre()+" falló!");
			}
		}
		
		public Jugador getJ() {
		return j;
	}

		public void setJ(Jugador j) {
		this.j = j;
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
