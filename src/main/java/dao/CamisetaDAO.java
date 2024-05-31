package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;

import model.CamisetaModel;
import model.UsuarioModel;

/**
 * Este es nuestro DAO
 * de camisetas que nos permite ejecutar querys e interactuar con la base de datos
 * 
 * @author: Victor Zapata P.
 * @version: 31/05/2024/Z v 1.0
 * 
 */

public class CamisetaDAO {
	// Creo la conexion de esta clase con la base de datos
	public static Connection Conex = null;
	private static CamisetaDAO instance = null;

	/**
	 * metodo por el cual nos conectamos con la base de datos cuando lo requiramos
	 * 
	 * @throws Exception atrapa las excepciones generadas por el metodo CamisetaDao
	 */

	public CamisetaDAO() throws Exception {
		this.Conex = ConectionDB.getConexion();
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public static CamisetaDAO getInstance() throws Exception {
		if (instance == null) {
			instance = new CamisetaDAO();
		}
		return instance;
	}

	/**
	 * creo el metodo Insert para incluirle los atributos al objeto camiseta,que lo
	 * llamaré desde GestionCamisetaController
	 * 
	 * @param x creo el obeto x donde se inserta los parámetros de la camiseta
	 * @throws SQLException Atrapa las excepciones del metodo
	 */
	public void Insert(CamisetaModel x) throws SQLException {

		String sql = "INSERT INTO camiseta (modelo, talla, cantidad, color, foto, estado) VALUES (?,?,?,?,?,?)";
		PreparedStatement ps = Conex.prepareStatement(sql);
		ps.setString(1, x.getModelo());
		ps.setString(2, x.getTalla());
		ps.setInt(3, x.getCantidad());
		ps.setString(4, x.getColor());
		ps.setString(5, x.getFoto());
		ps.setString(6, x.getEstado());

		int filas = ps.executeUpdate();
		ps.close();

	}

	/**
	 * creo el metodo con sus querys para poder extraer los parametros desde la base
	 * de datos, mediante el id
	 * 
	 * @param idCamiseta ide de la camiseta
	 * @return me devuelve el objeto camiseta
	 * @throws SQLException atrapa las excepciones del camino a la base de datos
	 */
	public CamisetaModel obtenerPorId(int idCamiseta) throws SQLException {

		String sql = "SELECT * FROM camiseta WHERE idCamiseta=?";
		PreparedStatement ps = Conex.prepareStatement(sql);
		ps.setInt(1, idCamiseta);

		ResultSet rs = ps.executeQuery();

		rs.next();

		CamisetaModel c = new CamisetaModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),
				rs.getString(5), rs.getString(6), rs.getString(7));

		return c;
	}

	/**
	 * creo el metodo que borra la una camiseta tomando como referencia su id
	 * 
	 * @param idCamiseta id de la camiseta a eliminar/borrar
	 * @throws SQLException atrapa las excepciones en el camino a la base de datos
	 */
	public void borrarCamiseta(int idCamiseta) throws SQLException {
		// aquí es donde creo un DELETE en la base de datos de el ID seleccionado y todos sus parametros
		String sql = "DELETE FROM camiseta WHERE idCamiseta = ?";
		PreparedStatement ps = Conex.prepareStatement(sql);

		ps.setInt(1, idCamiseta);

		ps.executeUpdate();
		ps.close();
	}

	/**
	 * creo el metodo actualizar concetandolo a la base de datos y usando un query
	 * UPDATE de los parámetros a modificar de la base de datos Tienda camiseta
	 * 
	 * @param c me devuelve el objeto camiseta actualizado
	 * @throws SQLException atrapa las excepciones generadas en el camino a la base
	 *                      de datos
	 */
	public void actualizar(CamisetaModel c) throws SQLException {
		//controlo que el objeto c me haya llegado y lo imprimo
		System.out.println(c);
		//me conecto a la base de datos y hago un UPDATE de los parametro selecionados
		String sql = "UPDATE camiseta SET modelo=?, talla=?, cantidad=?, color=?, foto=?, estado=? WHERE idCamiseta=?";
		PreparedStatement ps = Conex.prepareStatement(sql);
		ps.setString(1, c.getModelo());
		ps.setString(2, c.getTalla());
		ps.setInt(3, c.getCantidad());
		ps.setString(4, c.getColor());
		ps.setString(5, c.getFoto());
		ps.setString(6, c.getEstado());
		ps.setInt(7, c.getIdCamiseta());

		ps.executeUpdate();
		ps.close();

	}

	/**
	 * creo una arraylist donde se van a guardar las camisetas que tengo en la base
	 * de datos y luego mostraré en el front
	 * 
	 * @return me devuelve los parametros recopilados de la base de datos de todas
	 *         las camisetas insertadas
	 * @throws SQLException atraspa las excepciones de camino al a base de datos
	 */

	public ArrayList<CamisetaModel> Listar() throws SQLException {

		PreparedStatement ps = Conex.prepareStatement("SELECT * FROM camiseta");// se podria poner el nombre de los campos
																				
		ResultSet rs = ps.executeQuery();

		ArrayList<CamisetaModel> result = null;
		//reviso si está vaciçia mi array y la relleno co  los datos
		while (rs.next()) {
			if (result == null) {
				result = new ArrayList<>();
			}
			result.add(new CamisetaModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
					rs.getString(6), rs.getString(7)));
		}

		return result;

	}

	/**
	 * metodo para recibir los parametros correspondientes a las camisetas
	 * insertadas en la base de datos
	 * 
	 * @return el Json de las camisetas que tenemos en la base de datos
	 * @throws SQLException atrapa las excepciones de SQL
	 */
	public String dameJson() throws SQLException {

		String json = "";
		Gson gson = new Gson();

		json = gson.toJson(this.Listar());

		return json;
	}

}
