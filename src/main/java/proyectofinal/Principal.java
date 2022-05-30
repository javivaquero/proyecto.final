package proyectofinal;

import java.util.ArrayList;
import java.util.Scanner;
import enums.Tipo;
import interfacesgraficas.Ventana;
import clases.Ataque;
import clases.Combate;
import clases.Consumible;
import clases.Enemigo;
import clases.Jugador;
import clases.Objeto;

public class Principal {

	public static void main(String[] args)  {
		Scanner sc=new Scanner(System.in);
		ArrayList<Objeto>inv=new ArrayList<Objeto>();
		ArrayList<Consumible>cons=new ArrayList<Consumible>();
		ArrayList<Ataque>atq=new ArrayList<Ataque>();
		//Jugador p=new Jugador("Jugador",(short)100,(short)3,(short)3,atq,(byte)50,inv,cons,(byte)0,(byte)5,(byte)3);
		//Combate c=new Combate(p);
		Ventana v=new Ventana();
	}

}
