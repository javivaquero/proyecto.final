package clases;

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
