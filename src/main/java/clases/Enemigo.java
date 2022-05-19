package clases;

import java.util.ArrayList;

import enums.Tipo;

public class Enemigo extends Personaje {

	private Tipo tipo;

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Enemigo(String nombre, short pVida, short pAtaque, short pDefensa, ArrayList<Ataque> ataques,
			byte pVelocidad, Tipo tipo) {
		super(nombre, pVida, pAtaque, pDefensa, ataques, pVelocidad);
		this.tipo = tipo;
	}
	
	
	
}
