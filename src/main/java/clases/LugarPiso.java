package clases;

public class LugarPiso {

	private Objeto obj;
	private Enemigo e;
	private Consumible cs;
	public Objeto getObj() {
		return obj;
	}
	public void setObj(Objeto obj) {
		this.obj = obj;
	}
	public Enemigo getE() {
		return e;
	}
	public void setE(Enemigo e) {
		this.e = e;
	}
	public Consumible getCs() {
		return cs;
	}
	public void setCs(Consumible cs) {
		this.cs = cs;
	}
	public LugarPiso(Objeto obj, Enemigo e, Consumible cs) {
		super();
		this.obj = obj;
		this.e = e;
		this.cs = cs;
	}
	
	
	
}
