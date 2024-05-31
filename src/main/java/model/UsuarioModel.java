package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.google.gson.Gson;

import dao.UsuarioDAO;

/**
 * Esta clase nos permite crear el objeto Usuario con todos sus atributos
 * 
 * @author: Victor Zapata P.
 * @version: 31/05/2024/Z v 1.0
 * 
 */
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
	 * Método para modificar el IdUsuario, en este caso no lo usaremos pero lo
	 * dejamos para futuras implementaciones
	 * 
	 * @param idUsuario parametro "idUsuario" a modificar
	 */

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	/**
	 * Constructor sin el idUsuario que nos permite modificar todo sus atributos sin
	 * tocar el id
	 * 
	 * @param nombre     Atributo de solo texto donde se inserta el nombre del
	 *                   usuario
	 * @param correo     Atributo de solo texto donde se inserta el correo del
	 *                   usuario
	 * @param contrasena Atributo donde se inserta la contraseña
	 * @param foto       Atributo correspondiente a la ruta de la foto insertada en
	 *                   el objeto Usuario
	 * @param permiso    Atributo de tipo INT que permite conceder un permiso a un
	 *                   usuario ADMIN=1 Usuario=9
	 */

	public UsuarioModel(String nombre, String correo, String contrasena, String foto, int permiso) {
		super();
		this.nombre = nombre;
		this.correo = correo;
		this.contrasena = contrasena;
		this.foto = foto;
		this.permiso = permiso;
	}

	/**
	 * metodo para obtener el permiso
	 * 
	 * @return un int con el permiso del usuario
	 */
	public int getPermiso() {
		return permiso;
	}

	/**
	 * metodo para modificar un permiso
	 * 
	 * @param permiso parametro a modificar
	 */
	public void setPermiso(int permiso) {
		this.permiso = permiso;
	}

	/**
	 * constructor sin los atributos id y permiso que no se podrán modificar por el
	 * usuario
	 * 
	 * @param nombre               nos proporciona el nombre del ususario
	 * @param correo               nos proporciona el correo del ususario
	 * @param contrasena           nos proporciona la contraseña encriptada del
	 *                             ususario
	 * @param confirmar_contrasena no usamos el confirmar contrasena en situaciones
	 *                             posteriores, se usó solo de prueba
	 * @param foto                 nos da la ruta de la forto del usuario
	 */

	public UsuarioModel(String nombre, String correo, String contrasena, String confirmar_contrasena, String foto) {
		super();
		this.nombre = nombre;
		this.correo = correo;
		this.contrasena = contrasena;
		this.foto = foto;
	}

	/**
	 * Nos sirve para obtener la ruta de la foto
	 * 
	 * @return un Sring con la ruta de la foto
	 */

	public String getFoto() {
		return foto;
	}

	/**
	 * nos sirve para modificar la ruta de la foto o imagen del ususario
	 * 
	 * @param foto nos da la ruta de la foto/imagen del ususario
	 */
	public void setFoto(String foto) {
		this.foto = foto;
	}

	/**
	 * metodo tio String que recoge todos los parametros de un objeto en este caso
	 * del Ussuario
	 */
	@Override
	public String toString() {
		return "UsuarioModel [idUsuario=" + idUsuario + ", nombre=" + nombre + ", correo=" + correo + ", contrasena="
				+ contrasena + ", foto=" + foto + ", permiso=" + permiso + "]";
	}

	/**
	 * Método Insertar donde creamos esa comunicacion con Dao y la posterior
	 * insercion de los atributos en la base de datos
	 * 
	 * @throws Exception Atrapamos las posibles excepciones
	 */

	public void insertar() throws Exception {
		UsuarioDAO.getInstance().Insertar(this);

	}

	/**
	 * metodo para extraer de la base de datos toda los parámetros a traves del id
	 * 
	 * @param idUsuario nos da el id del ususario del que queremos obtener sus
	 *                  parámetros desde la base de datos
	 * @throws Exception atrapamos la execpcionnes del metodo ObtenerPorId
	 */
	public void obtenerPorId(int idUsuario) throws Exception {

		UsuarioModel aux = UsuarioDAO.getInstance().obtenerPorId(idUsuario);

		this.setIdUsuario(aux.getIdUsuario());
		this.setNombre(aux.getNombre());
		this.setCorreo(aux.getCorreo());
		this.setContrasena(aux.getContrasena());
		this.setFoto(aux.getFoto());
		this.setPermiso(aux.getPermiso());

	}

	/**
	 * Metodo que sirve para actualizar un objeto que previamente se ha recogido a
	 * traves de su id
	 * 
	 * @throws SQLException atrapa excepciones de la base de datos
	 * @throws Exception    atrapa las excepciones del metodo actualizar
	 */

	public void actualizar() throws SQLException, Exception {
		UsuarioDAO.getInstance().actualizar(this);
		System.out.println(this);
	}

	/**
	 * Metodo para recoger la información de la base de datos
	 * 
	 * @return el Json que pintaremos en el front
	 */
	public String dameJson() {
		String json = "";
		Gson gson = new Gson();

		json = gson.toJson(this);
		return json;

	}

	/**
	 * Metodo que sirve para recoger los datos actualizados del Usuario en la base
	 * da datos y mostrarlo en el front
	 * 
	 * @return el Json que queremos pintar en el fron del usuario modificado
	 */
	public String actualizaJson() {

		String json = "";
		Gson gson = new Gson();

		json = gson.toJson(this);

		return json;
	}

	/**
	 * Metodo que sirve para borrar/eliminar un objeto Usuario de la base de datos
	 * 
	 * @param idUsuario proporciona el id del usuario a borrar
	 * @throws SQLException atrapa las excepcionnes de la base de datos
	 * @throws Exception    atrapa las excepciones generadas por el metodo borrarUsu
	 */
	public void borrarUsu(int idUsuario) throws SQLException, Exception {
		UsuarioDAO.getInstance().borrarUsuario(idUsuario);
	}
}
