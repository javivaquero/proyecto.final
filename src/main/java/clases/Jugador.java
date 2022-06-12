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
import excepciones.ContraseñaIncorrectaException;
import excepciones.NombreInvalidoException;
import excepciones.UsuarioNoExisteException;
import interfacesgraficas.Ventana;

import utils.ConexionBD;

public class Jugador extends Personaje{

	private ArrayList<Objeto>objetos;
	private ArrayList<Consumible>inventario;
	private byte piso;
	private Clase clase;
	private Tipo tipo;
	private int pp;
	private byte tope;
	private String pass;
	
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public byte getTope() {
		return tope;
	}
	public void setTope(byte tope) {
		this.tope = tope;
	}
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

	
	public Jugador(String nombre, short pVida, short pAtaque, short pDefensa, ArrayList<Ataque> ataques,
			byte pVelocidad, ArrayList<Objeto> objetos, ArrayList<Consumible> inventario,byte piso,
			Clase clase,Tipo tipo,int pp,byte tope) {
		super(nombre, pVida, pAtaque, pDefensa, ataques, pVelocidad);
		ArrayList<Ataque> movimientos=new ArrayList<Ataque>();
		switch(clase) {
		case MAGO:
			//0	
			Ataque golpe=new Ataque("Golpe",(short)4,(byte)100,Tipo.FISICO,(byte) 0);
			movimientos.add(golpe);
			//1
			Ataque quemar=new Ataque("Quemar",(short)7,(byte)75,Tipo.FUEGO,(byte)5);
			movimientos.add(quemar);
			//2
			Ataque congelar=new Ataque("Congelar",(short)6,(byte)80,Tipo.HIELO,(byte)4);
			movimientos.add(congelar);
			//3
			Ataque rayo=new Ataque("Rayo",(short)5,(byte)95,Tipo.ELECTRICO,(byte)3);
			movimientos.add(rayo);
			this.setAtaques(movimientos);
			break;
		case TANQUE:
			Ataque a1=new Ataque("Golpe",(short)4,(byte)100,Tipo.FISICO,(byte)0);
			movimientos.add(a1);
			//1
			Ataque a2=new Ataque("Quemar",(short)7,(byte)75,Tipo.FUEGO,(byte)5);
			movimientos.add(a2);
			//2
			Ataque a3=new Ataque("Congelar",(short)6,(byte)80,Tipo.HIELO,(byte)4);
			movimientos.add(a3);
			//3
			Ataque a4=new Ataque("Rayo",(short)5,(byte)95,Tipo.ELECTRICO,(byte)3);
			movimientos.add(a4);
			this.setAtaques(movimientos);
			break;
		case ARQUERO:
			Ataque aa1=new Ataque("Golpe",(short)4,(byte)100,Tipo.FISICO,(byte)0);
			movimientos.add(aa1);
			//1
			Ataque aa2=new Ataque("Quemar",(short)7,(byte)75,Tipo.FUEGO,(byte)5);
			movimientos.add(aa2);
			//2
			Ataque aa3=new Ataque("Congelar",(short)6,(byte)80,Tipo.HIELO,(byte)4);
			movimientos.add(aa3);
			//3
			Ataque aa4=new Ataque("Rayo",(short)5,(byte)95,Tipo.ELECTRICO,(byte)3);
			movimientos.add(aa4);
			this.setAtaques(movimientos);
			break;
		case ASESINO:
			Ataque aaa1=new Ataque("Golpe",(short)4,(byte)100,Tipo.FISICO,(byte)0);
			movimientos.add(aaa1);
			//1
			Ataque aaa2=new Ataque("Quemar",(short)7,(byte)75,Tipo.FUEGO,(byte)5);
			movimientos.add(aaa2);
			//2
			Ataque aaa3=new Ataque("Congelar",(short)6,(byte)80,Tipo.HIELO,(byte)4);
			movimientos.add(aaa3);
			//3
			Ataque aaa4=new Ataque("Rayo",(short)5,(byte)95,Tipo.ELECTRICO,(byte)3);
			movimientos.add(aaa4);
			this.setAtaques(movimientos);
			break;	
			
		default:
			break;
		
		}
		this.objetos = new ArrayList<Objeto>();
		this.inventario = new ArrayList<Consumible>();
		this.setPiso(piso);
		this.tipo=tipo;
		this.clase=clase;
		this.pp=pp;
		this.tope=tope;
	}
	
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	public Jugador() {
		
	}
	
	//INICIAR SESIÓN
	
	public Jugador(String nombre,String pass,byte tope) throws NombreInvalidoException, UsuarioNoExisteException, SQLException, ContraseñaIncorrectaException {		 
		Statement smt=ConexionBD.conectar();
		ResultSet cursor=smt.executeQuery("select * from usuario where usuario='"+
		nombre+"'");
		if(cursor.next()) {
			this.pass=cursor.getString("pass");
			if(!this.pass.equals(pass)) {
				ConexionBD.desconectar();
				throw new ContraseñaIncorrectaException("La contraseña no es correcta");
			}		
			this.nombre=cursor.getString("usuario");			
			this.tope=cursor.getByte("tope");
		}else {
			ConexionBD.desconectar();
			throw new UsuarioNoExisteException("No existe ese usuario en la BD");
		}
		ConexionBD.desconectar();
	}
	
	//REGISTRARSE
	
	public Jugador(String nombre,String pass) throws NombreInvalidoException, SQLException {
		if(nombre.length()>11) {
			throw new NombreInvalidoException("El nombre no es válido");
		}
		Statement smt=ConexionBD.conectar();
		if(smt.executeUpdate("insert into usuario values('"
		+nombre+"','"+pass+"','"+0+"')")>0) {
			//Solo si todo ha ido bien insertando, se modifican las variables internas
			this.nombre = nombre;
			this.pass = pass;
			this.tope = 0;
		}else {
			//Si no se ha podido insertar, lanzo un error: Algo ha ido mal.
			ConexionBD.desconectar();
			throw new SQLException("No se ha podido insertar");
		}
		ConexionBD.desconectar();
	}
	
	public void atacarEnemigo(Enemigo e,Ataque a,byte at) throws FileNotFoundException {
		Random r=new Random();
		Ataque atJ;
		if(this.getPp()==0) {
			atJ=this.getAtaques().get(0);
		}else {
			atJ=this.getAtaques().get(at);
		}
		
		byte acierto=(byte) r.nextInt(100);
		if(acierto<atJ.getPrecision()) {
		short vEActual=e.getpVida();
		int pp=this.getPp();
		switch(atJ.getTipo()) {
		default:
			
			break;
		case FISICO:
				vEActual=(short) (e.getpVida()-(this.getpAtaque()+atJ.getPotencia())/this.getpDefensa());
			break;
		case FUEGO:
				if(e.getTipo()==Tipo.HIELO) {
					vEActual=(short) (e.getpVida()-(2)*(this.getpAtaque()+atJ.getPotencia())/this.getpDefensa());
				}else {
					vEActual=(short) (e.getpVida()-(this.getpAtaque()+atJ.getPotencia())/this.getpDefensa());
				}
			break;
		case ELECTRICO:
			if(e.getTipo()==Tipo.FUEGO) {
				vEActual=(short) (e.getpVida()-(2)*(this.getpAtaque()+atJ.getPotencia())/this.getpDefensa());
			}else {
				vEActual=(short) (e.getpVida()-(this.getpAtaque()+atJ.getPotencia())/this.getpDefensa());
			}
			break;
		case HIELO:
			if(e.getTipo()==Tipo.ELECTRICO) {
				vEActual=(short) (e.getpVida()-(2)*(this.getpAtaque()+atJ.getPotencia())/this.getpDefensa());
			}else {
				vEActual=(short) (e.getpVida()-(this.getpAtaque()+atJ.getPotencia())/this.getpDefensa());
			}
			break;
		}
		e.setpVida(vEActual);
		pp-=atJ.getCostePP();
		if(this.getPp()<=0) {
			this.setPp((int) 0);
		}else {
			this.setPp(pp);
		}
		
		}
	}
	public int getPp() {
		return pp;
	}
	public void setPp(int pp) {
		this.pp = pp;
	}
	public byte getPiso() {
		return piso;
	}
	public void setPiso(byte piso) {
		this.piso = piso;
	}
	
	public Objeto listaObjetosCurativos(Jugador j) {
		
		Random r=new Random();
		Objeto o=new Objeto();
		ArrayList<Objeto>listaObjetos=new ArrayList<Objeto>();
		
		//0
		Objeto o1=new Objeto("Zumo de Naranja",(short)200,(short)0,(short)0);
		listaObjetos.add(o1);
		//1
		Objeto o2=new Objeto("Red Bull",(short)500,(short)0,(short)0);
		listaObjetos.add(o2);
		//2
		Objeto o3=new Objeto("Nuka Cola",(short)600,(short)0,(short)0);
		listaObjetos.add(o3);
		//3
		Objeto o4=new Objeto("Santo Grial",(short)800,(short)0,(short)0);
		listaObjetos.add(o4);
		if(j.getPiso()<5) {
			o=listaObjetos.get(r.nextInt(1));
		}
		if(j.getPiso()>5&&j.getPiso()>10) {
			o=listaObjetos.get(2);
		}
		if(j.getPiso()>10) {
			o=listaObjetos.get(3);
		}
		return o;
	}
	
public Objeto listaObjetosDefensivos(Jugador j) {
		
		Random r=new Random();
		Objeto o=new Objeto();
		ArrayList<Objeto>listaObjetos=new ArrayList<Objeto>();
		
		//0
		Objeto o1=new Objeto("Cota de malla",(short)0,(short)0,(short)1);
		listaObjetos.add(o1);
		//1
		Objeto o2=new Objeto("Pechera de hierro",(short)0,(short)0,(short)1);
		listaObjetos.add(o2);
		//2
		Objeto o3=new Objeto("Camiseta de obsidiana",(short)0,(short)0,(short)2);
		listaObjetos.add(o3);
		//3
		Objeto o4=new Objeto("Indestructible",(short)0,(short)0,(short)3);
		listaObjetos.add(o4);
		if(j.getPiso()<5) {
			o=listaObjetos.get(r.nextInt(1));
		}
		if(j.getPiso()>5&&j.getPiso()>10) {
			o=listaObjetos.get(2);
		}
		if(j.getPiso()>10) {
			o=listaObjetos.get(3);
		}
		return o;
	}

public Objeto listaObjetosOfensivos(Jugador j) {
	
	Random r=new Random();
	Objeto o=new Objeto();
	ArrayList<Objeto>listaObjetos=new ArrayList<Objeto>();
	
	//0
	Objeto o1=new Objeto("Espada de Juguete",(short)0,(short)15,(short)0);
	listaObjetos.add(o1);
	//1
	Objeto o2=new Objeto("Espada de Fuego",(short)0,(short)30,(short)0);
	listaObjetos.add(o2);
	//2
	Objeto o3=new Objeto("Master Sword",(short)0,(short)60,(short)0);
	listaObjetos.add(o3);
	//3
	Objeto o4=new Objeto("Evoker",(short)0,(short)120,(short)0);
	listaObjetos.add(o4);
	if(j.getPiso()<4) {
		o=listaObjetos.get(0);
	}
	if(j.getPiso()>8&&j.getPiso()>10) {
		o=listaObjetos.get(2);
	}
	if(j.getPiso()>10) {
		o=listaObjetos.get(3);
	}
	return o;
}
	public Clase getClase() {
		return clase;
	}
	public void setClase(Clase clase) {
		this.clase = clase;
	}
	
public Consumible listaConsumibles(Jugador j) {
		Random r=new Random();
		Consumible c=null;
		boolean cr=r.nextBoolean();
		if(j.getPiso()<4) {
			if(cr==true) {
				c=new ConsumibleCurativo("Lata cerveza hacendado",(short)100);
			}else {
				c=new ConsumibleMasPP("Vino Don Simon",(int)50);
			}
			
		}
		if(j.getPiso()<8&&j.getPiso()>4) {
			if(cr==true){
				c=new ConsumibleCurativo("Porro",(short)300);
			}else {
				c=new ConsumibleMasPP("Humunculo",(int)100);
			}
			
		}
		
		return c;
	}
	
}
