package model;

import java.sql.PreparedStatement;

import dao.UsuarioDAO;

public class UsuarioModel {
	
	private int idUsuario;
	private String nombre;
	private String correo;
	private String contrasena;
	private String foto;
	private int permiso;
	
	
	
	public UsuarioModel() {
		
	}



	public UsuarioModel(String nombre, String correo, String contrasena, String confirmar_contrasena) {
		super();
		this.nombre = nombre;
		this.correo = correo;
		this.contrasena = contrasena;
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
	


	public int getIdUsuario() {
		return idUsuario;
	}



	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}



	public UsuarioModel(int idUsuario, String nombre, String correo, String contrasena, String foto, int permiso) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.correo = correo;
		this.contrasena = contrasena;
		this.foto = foto;
		this.permiso = permiso;
	}



	public UsuarioModel(String nombre, String correo, String contrasena, String foto, int permiso) {
		super();
		this.nombre = nombre;
		this.correo = correo;
		this.contrasena = contrasena;
		this.foto = foto;
		this.permiso = permiso;
	}



	public int getPermiso() {
		return permiso;
	}



	public void setPermiso(int permiso) {
		this.permiso = permiso;
	}



	public UsuarioModel(String nombre, String correo, String contrasena, String confirmar_contrasena, String foto) {
		super();
		this.nombre = nombre;
		this.correo = correo;
		this.contrasena = contrasena;
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
		return "UsuarioModel [idUsuario=" + idUsuario + ", nombre=" + nombre + ", correo=" + correo + ", contrasena="
				+ contrasena + ", foto=" + foto + ", permiso=" + permiso + "]";
	}



	public void Insertar() throws Exception {
		UsuarioDAO.getInstance().Insertar(this);
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
	

