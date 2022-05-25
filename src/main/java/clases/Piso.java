package clases;

public class Piso {

	private LugarPiso[][]lp;

	public LugarPiso[][] getLp() {
		return lp;
	}

	public void setLp(LugarPiso[][] lp) {
		this.lp = lp;
	}

	public Piso(LugarPiso[][] lp) {
		super();
		this.lp = new LugarPiso[5][5];
		
	}
	
	
	
}
