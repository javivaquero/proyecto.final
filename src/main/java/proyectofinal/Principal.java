package proyectofinal;

import java.util.ArrayList;
import enums.Tipo;
import clases.Ataque;
import clases.Combate;
import clases.Consumible;
import clases.Enemigo;
import clases.Jugador;
import clases.Objeto;

public class Principal {

	public static void main(String[] args) throws InterruptedException {
		ArrayList<Objeto>inv=new ArrayList<Objeto>();
		ArrayList<Consumible>cons=new ArrayList<Consumible>();
		ArrayList<Ataque>atq=new ArrayList<Ataque>();
		Jugador p=new Jugador("EL BARCO",(short)10000,(short)50,(short)50,atq,(byte)100,inv,cons,(byte)0,(byte)5,(byte)3);
		Combate c=new Combate(p);
	}

}
