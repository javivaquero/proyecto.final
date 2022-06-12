package clases;

public  class Consumible extends ElementoConNombre {

/**
 * Clase Consumible: "Objetos utilizables por el jugador en cualquier momento del combate, se pierden al usarlos.
 * @param nombre: Nombre del consumible, extiende de ElementoConNombre.
 */
	public Consumible(String nombre) {
		super(nombre);
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public String toString() {
		return nombre;
	}
	

}
