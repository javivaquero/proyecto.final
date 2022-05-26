package clases;

import java.util.ArrayList;

import enums.Tipo;

public class Personaje extends ElementoConNombre {

	private short pVida;
	private short pAtaque;
	private short pDefensa;
	private ArrayList<Ataque> ataques;
	private byte pVelocidad;
	
	public Personaje() {
		
	}
	
	public short getpVida() {
		return pVida;
	}
	public void setpVida(short pVida) {
		this.pVida = pVida;
	}
	public short getpAtaque() {
		return pAtaque;
	}
	public void setpAtaque(short pAtaque) {
		this.pAtaque = pAtaque;
	}
	public short getpDefensa() {
		return pDefensa;
	}
	public void setpDefensa(short pDefensa) {
		this.pDefensa = pDefensa;
	}
	public ArrayList<Ataque> getAtaques() {
		return ataques;
	}
	public void setAtaques(ArrayList<Ataque> ataques) {
		this.ataques = ataques;
	}
	public byte getpVelocidad() {
		return pVelocidad;
	}
	public void setpVelocidad(byte pVelocidad) {
		this.pVelocidad = pVelocidad;
	}
	public Personaje(String nombre, short pVida, short pAtaque, short pDefensa, ArrayList<Ataque> ataques,
			byte pVelocidad) {
		super(nombre);
		this.pVida = pVida;
		this.pAtaque = pAtaque;
		this.pDefensa = pDefensa;
		this.ataques = new ArrayList<Ataque>();
		this.pVelocidad = pVelocidad;
	}
	
	public ArrayList<Ataque> listaAtaques() {
		ArrayList<Ataque>listaAtaques=new ArrayList<Ataque>();
		//0
		Ataque insec=new Ataque("Insec",(short)3,(byte)60,Tipo.HIELO);
		listaAtaques.add(insec);
		//1
		Ataque soldaoBarroman=new Ataque("Ataques Tio arena",(short)2,(byte)100,Tipo.FISICO);
		listaAtaques.add(soldaoBarroman);
		return listaAtaques;
	}
	
	
	
}
