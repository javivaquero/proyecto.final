package clases;
/**
 *  * Clase consumible mas PP: Polimorfismo, tipo de consumible que restaura vida del jugador.
 * @author Javi
 *
 */
public class ConsumibleMasPP extends Consumible{
	private int ppAumentados;
	/**
	 * 
	 * @param nombre: Nombre del consumible que se creará
	 * @param ppAumentados: PP aumentados al jugador que se puede usar en cualquier momento del combate.
	 */
	public ConsumibleMasPP(String nombre, int ppAumentados) {
		super(nombre);
		// TODO Auto-generated constructor stub
	}
	public int getPpAumentados() {
		return ppAumentados;
	}
	public void setPpAumentados(int ppAumentados) {
		this.ppAumentados = ppAumentados;
	}

}
