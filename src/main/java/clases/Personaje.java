package clases;

import java.util.ArrayList;

import enums.Tipo;
/**
 * Clase con variables comunes entre Jugador y Enemigo
 * @author Javi
 *
 */
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
	/**
	 * 
	 * @param nombre:Nombre del jugador/enemigo
	 * @param pVida: Puntos de vida del jugador/enemigo, cuando llegan a 0, mueren.
	 * @param pAtaque Puntos de ataque del jugador/enemigo.
	 * @param pDefensa Puntos de defensa del jugador/enemigo.
	 * @param ataques: Lista de ataques del jugador/enemigo.
	 * @param pVelocidad: Puntos de velocidadd el jugador/enemigo
	 */
	public Personaje(String nombre, short pVida, short pAtaque, short pDefensa, ArrayList<Ataque> ataques,
			byte pVelocidad) {
		super(nombre);
		this.pVida = pVida;
		this.pAtaque = pAtaque;
		this.pDefensa = pDefensa;
		this.ataques = new ArrayList<Ataque>();
		this.pVelocidad = pVelocidad;
	}
	
	
	
	
	
}
