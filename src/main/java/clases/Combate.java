package clases;

public class Combate {

	private Jugador j;
	private Enemigo e;
	
		
	
	public Combate(Jugador j, Enemigo e) {
		super();
		this.j = j;
		this.e = e;
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
			
			short vEActual=(short) (e.getpVida()-(j.getpAtaque()-e.getpDefensa()/2));
			e.setpVida(vEActual);
			System.out.println("La vida del enemigo es de: "+e.getpVida());
		}
		
		private void atacarJugador(Jugador j, Enemigo e) {
			short vJActual=(short) (j.getpVida()-e.getpAtaque()+j.getpDefensa());
			j.setpVida(vJActual);
			System.out.println("La vida del jugador es de: "+j.getpVida());
		}
	
}