package clases;

public class ElementoConNombre {
	/**
	 * Clase ElementoConNombre, determina el nombre de todo elemento con nombre del programa.
	 */
	
	protected String nombre;
	
	public String getNombre() {
		return nombre;
	}
	/**
	 * 
	 * @param nombre: Determina el nombre del valor que le llegue.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ElementoConNombre(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	public ElementoConNombre() {
		
	}
	
	
}
