package clases;

public class ConsumibleCurativo extends Consumible {

	private short pVRestaurados;

	public short getpVRestaurados() {
		return pVRestaurados;
	}

	public void setpVRestaurados(short pVRestaurados) {
		this.pVRestaurados = pVRestaurados;
	}

	
	/**
	 * 
	 * @param nombre: Nombre del consumible, extiende de ElementoConNombre.
	 * @param pVRestaurados
	 */
	public ConsumibleCurativo(String nombre, short pVRestaurados) {
		super(nombre);
		this.pVRestaurados = pVRestaurados;
	}
	
	
	
	
}
