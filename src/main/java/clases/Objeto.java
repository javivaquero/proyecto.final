package clases;

/**
 * Clase que almacena los valores de los objetos que almacenará el jugador a lo largo de la partida. A diferencia de los consumibles, estos no desaparecen en ningún momento.
 * @author Javi
 *
 */

public class Objeto extends ElementoConNombre{
	
	private short pVAumentados;
	private short pAAumentados;
	private short pDAumentados;
	public short getpVAumentados() {
		return pVAumentados;
	}
	public void setpVAumentados(short pVAumentados) {
		this.pVAumentados = pVAumentados;
	}
	public short getpAAumentados() {
		return pAAumentados;
	}
	public void setpAAumentados(short pAAumentados) {
		this.pAAumentados = pAAumentados;
	}
	public short getpDAumentados() {
		return pDAumentados;
	}
	public void setpDAumentados(short pDAumentados) {
		this.pDAumentados = pDAumentados;
	}
	/**
	 * 
	 * @param nombre:nombre del objeto
	 * @param pVAumentados:Puntos de vida aumentados al jugador al obtener este objeto.
	 * @param pAAumentados:Puntos de ataque aumentados al jugador al obtener este objeto.
	 * @param pDAumentados:Puntos de defensa aumentados al jugador al obtener este objeto.
	 * ahora que me doy cuenta se podría haber hecho esta clase con polimorfismo igual que los consumibles.
	 */
	public Objeto(String nombre, short pVAumentados, short pAAumentados, short pDAumentados) {
		super(nombre);
		this.pVAumentados = pVAumentados;
		this.pAAumentados = pAAumentados;
		this.pDAumentados = pDAumentados;
	}
	public Objeto() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return nombre;
	}
	
	
	

}
