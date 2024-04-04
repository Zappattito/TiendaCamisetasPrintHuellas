package modelo;

import java.sql.PreparedStatement;

import DAO.DAO_Usuario;

public class Usuario {

	private String nombre;
	private String correo;
	private String contrasena;
	private String confirmar_contrasena;
	private String foto;
	
	
	
	public Usuario() {
		
	}



	public Usuario(String nombre, String correo, String contrasena, String confirmar_contrasena) {
		super();
		this.nombre = nombre;
		this.correo = correo;
		this.contrasena = contrasena;
		this.confirmar_contrasena = confirmar_contrasena;
	}

	


	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getCorreo() {
		return correo;
	}



	public void setCorreo(String correo) {
		this.correo = correo;
	}



	public String getContrasena() {
		return contrasena;
	}



	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}



	public String getConfirmar_contrasena() {
		return confirmar_contrasena;
	}



	public void setConfirmar_contrasena(String confirmar_contrasena) {
		this.confirmar_contrasena = confirmar_contrasena;
	}



	public Usuario(String nombre, String correo, String contrasena, String confirmar_contrasena, String foto) {
		super();
		this.nombre = nombre;
		this.correo = correo;
		this.contrasena = contrasena;
		this.confirmar_contrasena = confirmar_contrasena;
		this.foto = foto;
	}



	public String getFoto() {
		return foto;
	}



	public void setFoto(String foto) {
		this.foto = foto;
	}



	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", correo=" + correo + ", contrasena=" + contrasena
				+ ", confirmar_contrasena=" + confirmar_contrasena + ", foto=" + foto + "]";
	}


	public void Insertar() throws Exception {
		DAO_Usuario.getInstance().Insertar(this);
//	DAO_Usuario dao = null;
//	try {
//		dao = new DAO_Usuario();
//	} catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	dao.Insertar(this);
	}
	
	
	}
	

