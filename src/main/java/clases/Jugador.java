package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import excepciones.NombreInvalidoException;
import interfacesgraficas.Ventana;
import utils.ConexionBD;

public class Jugador extends Personaje{

	private ArrayList<Objeto>objetos;
	private ArrayList<Consumible>inventario;
	private byte pisoActual;
	private byte posX;
	private byte posY;
	
	public ArrayList<Objeto> getObjetos() {
		return objetos;
	}
	public void setObjetos(ArrayList<Objeto> objetos) {
		this.objetos = objetos;
	}
	public ArrayList<Consumible> getInventario() {
		return inventario;
	}
	public void setInventario(ArrayList<Consumible> inventario) {
		this.inventario = inventario;
	}
	public byte getPisoActual() {
		return pisoActual;
	}
	public void setPisoActual(byte pisoActual) {
		this.pisoActual = pisoActual;
	}
	public byte getPosX() {
		return posX;
	}
	public void setPosX(byte posX) {
		this.posX = posX;
	}
	public byte getPosY() {
		return posY;
	}
	public void setPosY(byte posY) {
		this.posY = posY;
	}
	public Jugador(String nombre, short pVida, short pAtaque, short pDefensa, ArrayList<Ataque> ataques,
			byte pVelocidad, ArrayList<Objeto> objetos, ArrayList<Consumible> inventario, byte pisoActual, byte posX,
			byte posY) {
		super(nombre, pVida, pAtaque, pDefensa, ataques, pVelocidad);
		this.objetos = new ArrayList<Objeto>();
		this.inventario = new ArrayList<Consumible>();
		this.pisoActual = pisoActual;
		this.posX = posX;
		this.posY = posY;
	}
	
	
	protected Jugador() {
		
	}
	
	
	public Jugador(String nombre) throws NombreInvalidoException {
		if(nombre.length()>11) {
			throw new NombreInvalidoException("El nombre introducido es demasiado largo");
		}
		Statement smt=ConexionBD.conectar();
		try {
			ResultSet cursor=smt.executeQuery("select * from usuario where usuario='"+
					nombre+"'");
			if(cursor.next()) {
				if(cursor.getString("usuario").equals(nombre)) {
					ConexionBD.desconectar();
					Ventana ventana = new Ventana();
					ventana.irAPantalla("seleccionClase");
					this.setNombre(nombre);					
				}else {
					if(smt.executeUpdate("insert into usuario values('"+nombre+"')")>0) {
						ConexionBD.desconectar();
						Ventana ventana = new Ventana();
						ventana.irAPantalla("seleccionClase");
					}else {
						throw new SQLException("No se ha podido insertar");
					}
				
				}
			}	else {
				if(smt.executeUpdate("insert into usuario values('"+nombre+"')")>0) {
					ConexionBD.desconectar();
					Ventana ventana = new Ventana();
					ventana.irAPantalla("seleccionClase");
				}else {
					throw new SQLException("No se ha podido insertar");
				}
			
			}
		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();

		}

}
	
	
}
