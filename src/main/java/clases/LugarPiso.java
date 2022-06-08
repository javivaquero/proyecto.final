package clases;

import java.io.IOException;

public class LugarPiso{

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
	public LugarPiso(Objeto obj, Enemigo e, Consumible cs) throws IOException {
	
		this.obj = obj;
		this.e = e.listaEnemigos();
		this.cs = cs;
	}
	public LugarPiso() {}

	
	
	
}
