package clases;

public class ConsumibleSaltarPiso extends Consumible {

	private byte cSP;

	public byte getcSP() {
		return cSP;
	}

	public void setcSP(byte cSP) {
		this.cSP = 1;
	}

	public ConsumibleSaltarPiso(String nombre, byte cSP) {
		super(nombre);
		this.cSP = cSP;
	}

	
	
}
