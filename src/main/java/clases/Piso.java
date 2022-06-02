package clases;

public class Piso {

	public LugarPiso[][]lp;

	public LugarPiso[][] getLp() {
		return lp;
	}

	public void setLp(LugarPiso[][] lp) {
		this.lp = lp;
	}

	public Piso(LugarPiso[][] lp) {
		super();
		this.lp=lp;
		lp = new LugarPiso[5][5];
	}
	
	
	
}
