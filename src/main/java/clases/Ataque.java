package clases;

import java.util.ArrayList;

import enums.Tipo;

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
