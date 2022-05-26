package clases;

import java.util.ArrayList;

public class Jugador extends Personaje{

	private ArrayList<Objeto>objetos;
	private ArrayList<Consumible>inventario;
	private byte pisoActual;
	private byte posX;
	private byte posY;
	
	public ArrayList<Objeto> getObjetos() {
		return objetos;
	}
	public void setObjetos(ArrayList<Objeto> objetos) {
		this.objetos = objetos;
	}
	public ArrayList<Consumible> getInventario() {
		return inventario;
	}
	public void setInventario(ArrayList<Consumible> inventario) {
		this.inventario = inventario;
	}
	public byte getPisoActual() {
		return pisoActual;
	}
	public void setPisoActual(byte pisoActual) {
		this.pisoActual = pisoActual;
	}
	public byte getPosX() {
		return posX;
	}
	public void setPosX(byte posX) {
		this.posX = posX;
	}
	public byte getPosY() {
		return posY;
	}
	public void setPosY(byte posY) {
		this.posY = posY;
	}
	public Jugador(String nombre, short pVida, short pAtaque, short pDefensa, ArrayList<Ataque> ataques,
			byte pVelocidad, ArrayList<Objeto> objetos, ArrayList<Consumible> inventario, byte pisoActual, byte posX,
			byte posY) {
		super(nombre, pVida, pAtaque, pDefensa, ataques, pVelocidad);
		this.objetos = new ArrayList<Objeto>();
		this.inventario = new ArrayList<Consumible>();
		this.pisoActual = pisoActual;
		this.posX = posX;
		this.posY = posY;
	}
	
	
	
	
	
}
