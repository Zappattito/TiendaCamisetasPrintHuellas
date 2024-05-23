package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;

import model.CamisetaModel;
import model.UsuarioModel;

public class CamisetaDAO {
	// Creo la conexion de esta clase con la base de datos
	public static Connection Conex = null;
	private static CamisetaDAO instance = null;

public CamisetaDAO() throws Exception {
		this.Conex = ConectionDB.getConexion();
	}

public static CamisetaDAO getInstance() throws Exception {
		if (instance == null) {
			instance = new CamisetaDAO();
		}
		return instance;
	}

	// creo el metodo Insert para incluirle los atributos al objeto camiseta
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
	
public void borrarCamiseta(int idCamiseta) throws SQLException {
		
		String sql = "DELETE FROM camiseta WHERE idCamiseta = ?";
        PreparedStatement ps = Conex.prepareStatement(sql);

        ps.setInt(1, idCamiseta);

        ps.executeUpdate();
        ps.close();
	}

public void actualizar(CamisetaModel c) throws SQLException {
	System.out.println(c);
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

public ArrayList<CamisetaModel> Listar() throws SQLException {

	PreparedStatement ps = Conex.prepareStatement("SELECT * FROM camiseta");// se podria poner el nombre de los
																			// campos
	ResultSet rs = ps.executeQuery();

	ArrayList<CamisetaModel> result = null;

	while (rs.next()) {
		if (result == null) {
			result = new ArrayList<>();
		}
		result.add(new CamisetaModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),
				rs.getString(5), rs.getString(6), rs.getString(7)));
	}

	return result;

}

public String dameJson() throws SQLException {

	String json = "";
	Gson gson = new Gson();

	json = gson.toJson(this.Listar());

	return json;
}


}
