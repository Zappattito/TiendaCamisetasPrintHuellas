package dao;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.internal.compiler.ast.ThrowStatement;

import com.google.gson.Gson;
import com.mysql.cj.protocol.Resultset;

import model.UsuarioModel;

/**
 * Este es nuestro DAO de usuario que nos permite ejecutar querys e interactuar
 * con la base de datos
 * 
 * @author: Victor Zapata P.
 * @version: 31/05/2024/Z v 1.0
 * 
 */

public class UsuarioDAO {
	// genero un atributo de tipo connection, que llamo Conex
	public static Connection Conex = null;
	// instancio UsuarioDao
	private static UsuarioDAO instance = null;

	// creo el objeto UsuarioDao y su coneccion
	public UsuarioDAO() throws Exception {
		this.Conex = ConectionDB.getConexion();
	}

	public static UsuarioDAO getInstance() throws Exception {
		if (instance == null) {
			instance = new UsuarioDAO();
		}
		return instance;
	}

	/**
	 * creo el metodo que va a insertar parametros en la base de datos en la tabla
	 * ususario
	 * 
	 * @param x el objeto creato con todos sus atributos
	 * @throws SQLException
	 */
	public void Insertar(UsuarioModel x) throws SQLException {

		String sql = "INSERT INTO usuario (nombre, correo, contrasena, foto, permiso) VALUES (?,?,?,?,?)";
		PreparedStatement ps = Conex.prepareStatement(sql);
		ps.setString(1, x.getNombre());
		ps.setString(2, x.getCorreo());
		ps.setString(3, x.getContrasena());
		ps.setString(4, x.getFoto());
		ps.setInt(5, x.getPermiso());

		int filas = ps.executeUpdate();
		ps.close();

	}

	/**
	 * metodo que sirve para obeter los datos completos a travez del id del usuario
	 * desde la base de datos para su posterior consulta o modificacion
	 * 
	 * @param idUsuario id del usuario
	 * @return los datos del usuario con un id especifico
	 * @throws SQLException atrapa las excepcions generadas en el camino a la base
	 *                      de datos
	 */
	public UsuarioModel obtenerPorId(int idUsuario) throws SQLException {
		// query para tarerme todos los atributos del objeto ususrio con un id
		// especifico
		String sql = "SELECT * FROM usuario WHERE idUsuario=?";
		PreparedStatement ps = Conex.prepareStatement(sql);
		ps.setInt(1, idUsuario);

		ResultSet rs = ps.executeQuery();

		rs.next();
		// creo el objeto u que se rellena con los parametros traidos desde la base de
		// datos
		UsuarioModel u = new UsuarioModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
				rs.getString(5), rs.getInt(6));

		return u;
	}

	/**
	 * metodo que sirve para borrar usuarios en la base de dato previa obtencion de
	 * su id
	 */
	public void borrarUsuario(int idUsuario) throws SQLException {
		// query DELETE para borrar un ususario prporcionandole un id
		String sql = "DELETE FROM usuario WHERE idUsuario = ?";
		PreparedStatement ps = Conex.prepareStatement(sql);

		ps.setInt(1, idUsuario);

		ps.executeUpdate();
		ps.close();
	}

	/**
	 * metodo para actualizar un usuario
	 * 
	 * @param u me devuelve el usuario modificado
	 * @throws SQLException atrapa las excepciones de camino a la base de datos
	 */
	public void actualizar(UsuarioModel u) throws SQLException {
		System.out.println(u);
		// utilizo la query UPDATE para editar los parametros de un usuario
		String sql = "UPDATE usuario SET nombre=?, correo=?, contrasena=?, foto=?, permiso=? WHERE idUsuario=?";
		// me conecto a la base de datos
		PreparedStatement ps = Conex.prepareStatement(sql);
		ps.setString(1, u.getNombre());
		ps.setString(2, u.getCorreo());
		ps.setString(3, u.getContrasena());
		ps.setString(4, u.getFoto());
		ps.setInt(5, u.getPermiso());
		ps.setInt(6, u.getIdUsuario());
		// ejecuto update
		ps.executeUpdate();
		// cierro la conexion
		ps.close();

	}

	/**
	 * ArrayList para guardar los usuarios que nos hemos triado de la base de datos
	 * para posteriormente Listar
	 * 
	 * @return usuarios guardados en la base de datos
	 * @throws SQLException atrapamos las excepciones en el camino a la base de
	 *                      datos
	 */
	public ArrayList<UsuarioModel> Listar() throws SQLException {
		// hacemos el prepare statement y un SELECT desde la tabla usuario,se podria
		// elegir el nombre de los campos
		PreparedStatement ps = Conex.prepareStatement("SELECT * FROM usuario");
		ResultSet rs = ps.executeQuery();

		ArrayList<UsuarioModel> result = null;

		while (rs.next()) {
			if (result == null) {
				result = new ArrayList<>();
			}
			result.add(new UsuarioModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5), rs.getInt(6)));
		}

		return result;

	}

	/**
	 * metodo para recibir los parametros correspondientes a los usuarios de la base
	 * de datos y posteriormente pintarlos en el front
	 * 
	 * @return el Json de los usuarios
	 * @throws SQLException atrapamos las excepciones de camino a la base de datos
	 */
	public String dameJson() throws SQLException {

		String json = "";
		Gson gson = new Gson();

		json = gson.toJson(this.Listar());

		return json;
	}

	/**
	 * metodo para comprobar las cuentas, donde nos tiene que coincidir el correo y
	 * la contraseña que proporcionó el usuario al momento de darse de alta
	 * 
	 * @param correo     correo del usuario
	 * @param contrasena contraseña encriptada del ususario
	 * @return los datos del ususario requeridos
	 * @throws SQLException excepciones SQL
	 */
	public UsuarioModel comprobarCuenta(String correo, String contrasena) throws SQLException {

		// TODO Auto-generated method stub
		// preparamos la conexion con base de datos y pedimos el correo y la contraseña
		PreparedStatement ps = Conex.prepareStatement("SELECT * FROM usuario WHERE correo = ? AND contrasena = ?");
		ps.setString(1, correo);
		ps.setString(2, contrasena);
		ResultSet rs = ps.executeQuery();

		UsuarioModel u = null;

		if (rs.next()) {

			return new UsuarioModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getInt(6));
		}
		return null;

	}

}
