package clases;

import java.util.ArrayList;

import enums.Tipo;
/**
 * 
 * @author Javi
 *Clase ataque, almacena los valores de los ataques que usarán posteriormenta tanto los Enemigos como el Jugador.
 *
 */
public class Ataque extends ElementoConNombre {
	
	 private short potencia;
	 private byte precision;
	 private int costePP;
	 private Tipo tipo;
	
	 public Ataque (){
		
	}
	 public short getPotencia() {
		return potencia;
	}
	public void setPotencia(short potencia) {
		this.potencia = potencia;
	}
	public byte getPrecision() {
		return precision;
	}
	public void setPrecision(byte precision) {
		this.precision = precision;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	/**
	 * 
	 * @param nombre: Nommbre del ataque, proviene de la clase ElementoConNombre.
	 * @param potencia: Daño que hace de base el ataque.
	 * @param precision: Porcentaje de acierto del ataque.
	 * @param tipo: Tipo del ataque recogido en la clase ENUM.
	 * @param costePP: Coste de magia restada al jugador, si el elemento tipo es FISICO, este será 0.
	 */
	public Ataque(String nombre, short potencia, byte precision, Tipo tipo, int costePP) {
		super(nombre);
		this.potencia = potencia;
		this.precision = precision;
		this.tipo = tipo;
		this.costePP=costePP;
	}
	public int getCostePP() {
		return costePP;
	}
	public void setCostePP(int costePP) {
		this.costePP = costePP;
	}
	@Override
	public String toString() {
	return this.getNombre();
	}
	
	
	 
}
