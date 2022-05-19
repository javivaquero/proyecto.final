package clases;

public class ConsumiblePotenciador extends Consumible {

	private short pAAumentados;
	private byte pVelAumentados;
	private short pDAumentados;
	public short getpAAumentados() {
		return pAAumentados;
	}
	public void setpAAumentados(short pAAumentados) {
		this.pAAumentados = pAAumentados;
	}
	public byte getpVelAumentados() {
		return pVelAumentados;
	}
	public void setpVelAumentados(byte pVelAumentados) {
		this.pVelAumentados = pVelAumentados;
	}
	public short getpDAumentados() {
		return pDAumentados;
	}
	public void setpDAumentados(short pDAumentados) {
		this.pDAumentados = pDAumentados;
	}
	public ConsumiblePotenciador(String nombre, short pAAumentados, byte pVelAumentados, short pDAumentados) {
		super(nombre);
		this.pAAumentados = pAAumentados;
		this.pVelAumentados = pVelAumentados;
		this.pDAumentados = pDAumentados;
	}
	
	
	
}
