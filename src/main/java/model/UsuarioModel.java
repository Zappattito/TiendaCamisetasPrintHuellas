package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.google.gson.Gson;

import dao.UsuarioDAO;

public class UsuarioModel {

	private int idUsuario;
	private String nombre;
	private String correo;
	private String contrasena;
	private String foto;
	private int permiso;

	/**
	 * Constructor que genera un objeto vacío de tipo usuario
	 */

	public UsuarioModel() {

	}
	/**
	 * Constructor para la creacion del objeto desde el formulario
	 * 
	 * @param idUsuario  Atributo int donde se inseratá un id único autogenerado por
	 *                   la base de datos para cada ususario
	 * @param nombre     Atributo solo texto donde se insertará el nombre del
	 *                   usuario en el objeto
	 * @param correo     Atributo de solo texto donde se insertará el correo en el
	 *                   objeto
	 * @param contrasena Atributo de solo texto donde se insertará la contraseña en
	 *                   le objeto
	 * @param foto       Atributo en forma de archivo de imagen qiue se insertará en
	 *                   el objeto usuario
	 * @param permiso    Atributo que otrogaremos a un Usuario que definirá si es un
	 *                   Usuiario corrienet o un administrador
	 */

	public UsuarioModel(int idUsuario, String nombre, String correo, String contrasena, String foto, int permiso) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.correo = correo;
		this.contrasena = contrasena;
		this.foto = foto;
		this.permiso = permiso;
	}

	/**
	 * Constructor para la creacion del objeto desde el formulario
	 * 
	 * @param nombre     Atributo de solo texto donde se inserta el nombre del
	 *                   usuario
	 * @param correo     Atributo de solo texto donde se inserta el correo del
	 *                   usuario
	 * @param contrasena Atributo donde se inserta la contraseña
	 */

	public UsuarioModel(String nombre, String correo, String contrasena, String confirmar_contrasena) {
		super();
		this.nombre = nombre;
		this.correo = correo;
		this.contrasena = contrasena;
	}

	/**
	 * Método de inclusion del nombre en el objeto
	 * 
	 * @return retorna el nombre de tipo String
	 */

	public String getNombre() {
		return nombre;
	}

	/**
	 * Método para modificar el nombre que previamente se ha insertado en el objeto
	 * 
	 * @param nombre parametro "nombre" a modificar
	 */

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Método de inclusion del correo en el objeto
	 * 
	 * @return retorna el correo de tipo String
	 */

	public String getCorreo() {
		return correo;
	}

	/**
	 * Método para modificar el correo que previamente se ha insertado en el objeto
	 * 
	 * @param correo parametro "correo" a modificar
	 */

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
	 * Método de inclusion de la contraseña en el objeto
	 * 
	 * @return retorna la contraseña de tipo String
	 */

	public String getContrasena() {
		return contrasena;
	}

	/**
	 * Método para modificar la contraseña, en este caso no lo usaremos pero lo
	 * dejamos para futuras implementaciones
	 * 
	 * @param contrasena parametro "contrasena" a modificar
	 */

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	/**
	 * Método de inclusion del idUsuario en el objeto, autogenerado por la Base de
	 * Datos
	 * 
	 * @return retorna el idUsuario de tipo int
	 */

	public int getIdUsuario() {
		return idUsuario;
	}

	/**
	 * Método para modificar el IDuSUARIO, en este caso no lo usaremos pero lo
	 * dejamos para futuras implementaciones
	 * 
	 * @param idUsuario parametro "idUsuario" a modificar
	 */

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
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

	/**
	 * Método Insertar donde creamos esa comunicacion con Dao
	 * 
	 * @throws Exception Atrapamos las posibles excepciones
	 */

	public void insertar() throws Exception {
		UsuarioDAO.getInstance().Insertar(this);

	}

	public void obtenerPorId(int idUsuario) throws Exception {

		UsuarioModel aux = UsuarioDAO.getInstance().obtenerPorId(idUsuario);

		this.setIdUsuario(aux.getIdUsuario());
		this.setNombre(aux.getNombre());
		this.setCorreo(aux.getCorreo());
		this.setContrasena(aux.getContrasena());
		this.setFoto(aux.getFoto());
		this.setPermiso(aux.getPermiso());

	}

	public void actualizar() throws SQLException, Exception {
		UsuarioDAO.getInstance().actualizar(this);
		System.out.println(this);
	}

	public String dameJson() {
		String json = "";
		Gson gson = new Gson();

		json = gson.toJson(this);
		return json;

	}

	public String actualizaJson() {

		String json = "";
		Gson gson = new Gson();

		json = gson.toJson(this);

		return json;
	}
	
	public void borrarUsu(int idUsuario) throws SQLException, Exception {
		UsuarioDAO.getInstance().borrarUsuario(idUsuario);
	}
}
