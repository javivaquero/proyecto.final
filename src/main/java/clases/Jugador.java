package clases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

import enums.Clase;
import enums.Tipo;
import excepciones.NombreInvalidoException;
import interfacesgraficas.Ventana;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import utils.ConexionBD;

public class Jugador extends Personaje{

	private ArrayList<Objeto>objetos;
	private ArrayList<Consumible>inventario;
	private byte pisoActual;
	private byte posX;
	private byte posY;
	private Clase clase;
	
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
			byte posY, Clase clase) {
		super(nombre, pVida, pAtaque, pDefensa, ataques, pVelocidad);
		ArrayList<Ataque> movimientos=new ArrayList<Ataque>();
		switch(clase) {
		case MAGO:
			//0	
			Ataque golpe=new Ataque("Golpe",(short)4,(byte)100,Tipo.FISICO);
			movimientos.add(golpe);
			//1
			Ataque quemar=new Ataque("Quemar",(short)7,(byte)75,Tipo.FUEGO);
			movimientos.add(quemar);
			//2
			Ataque congelar=new Ataque("Congelar",(short)6,(byte)80,Tipo.HIELO);
			movimientos.add(congelar);
			//3
			Ataque rayo=new Ataque("Rayo",(short)5,(byte)95,Tipo.ELECTRICO);
			movimientos.add(rayo);
			this.setAtaques(movimientos);
			break;
		case TANQUE:
			break;
		case ARQUERO:
			break;
		case ASESINO:
			break;	
			
		default:
			break;
		
		}
		this.objetos = new ArrayList<Objeto>();
		this.inventario = new ArrayList<Consumible>();
		this.pisoActual = pisoActual;
		this.posX = posX;
		this.posY = posY;
		
	}
	
	public Jugador() {
		
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
					this.setNombre(nombre);
					
										
				}else {
					if(smt.executeUpdate("insert into usuario values('"+nombre+"')")>0) {
						ConexionBD.desconectar();
						this.setNombre(nombre);
						
					}else {
						throw new SQLException("No se ha podido insertar");
					}
				
				}
			}	else {
				if(smt.executeUpdate("insert into usuario values('"+nombre+"')")>0) {
					ConexionBD.desconectar();
					this.setNombre(nombre);
					
				}else {
					throw new SQLException("No se ha podido insertar");
				}
			
			}
		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();

	

}
	
	}	
	
	public void atacarEnemigo(Enemigo e,Ataque a,byte at) throws FileNotFoundException, JavaLayerException {
		Random r=new Random();
		//cambiar this por this
		
		Ataque atJ=this.getAtaques().get(at);
		byte acierto=(byte) r.nextInt(100);
		if(acierto<atJ.getPrecision()) {
		short vEActual=0;
		switch(atJ.getTipo()) {
		default:
			break;
		case FISICO:
				vEActual=(short) (e.getpVida()-(this.getpAtaque()+atJ.getPotencia())/this.getpDefensa());
			break;
		case FUEGO:
				if(e.getTipo()==Tipo.HIELO) {
					vEActual=(short) (e.getpVida()-(2)*(this.getpAtaque()+atJ.getPotencia())/this.getpDefensa());
				}
			break;
		case ELECTRICO:
			if(e.getTipo()==Tipo.FUEGO) {
				vEActual=(short) (e.getpVida()-(2)*(this.getpAtaque()+atJ.getPotencia())/this.getpDefensa());
			}
			break;
		case HIELO:
			if(e.getTipo()==Tipo.ELECTRICO) {
				vEActual=(short) (e.getpVida()-(2)*(this.getpAtaque()+atJ.getPotencia())/this.getpDefensa());
			}
			break;
		}
		e.setpVida(vEActual);
		System.out.println(this.getNombre()+" usó "+atJ.getNombre());
		System.out.println("Vida de "+e.getNombre()+" : "+e.getpVida());
		}else {
			System.out.println("El ataque de "+this.getNombre()+" falló!");
		}
	}
	
}
