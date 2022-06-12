package clases;

public class ConsumibleCurativo extends Consumible {
/**
 * Clase consumible curativo: Polimorfismo, tipo de consumible que restaura vida del jugador.
 */
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
	 * @param pVRestaurados: puntos de vida restaurados al jugador.
	 */
	
	public ConsumibleCurativo(String nombre, short pVRestaurados) {
		super(nombre);
		this.pVRestaurados = pVRestaurados;
	}
	
	
	
	
}
