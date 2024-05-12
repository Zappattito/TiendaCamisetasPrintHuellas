package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;

import model.CamisetaModel;

public class CamisetaDAO {
	//Creo la conexion de esta clase con la base de datos
	public static Connection Conex = null;
	private static CamisetaDAO instance = null;
	
	public CamisetaDAO() throws Exception {
		this.Conex = ConectionDB.getConexion();
	}
	public static CamisetaDAO getInstance() throws Exception {
		if(instance==null) {
			instance = new CamisetaDAO();
		}
		return instance;
	}
	//creo el metodo Insert para incluirle los atributos al objeto camiseta
	public void Insert(CamisetaModel x) throws SQLException {
		
		String sql ="INSERT INTO camiseta (modelo, talla, cantidad, color, foto) VALUES (?,?,?,?,?)";
		PreparedStatement ps = Conex.prepareStatement(sql);
		ps.setString(1, x.getModelo());
		ps.setString(2, x.getTalla());
		ps.setString(3, x.getColor());
		ps.setString(4, x.getFoto());
		ps.setInt(5, x.getCantidad());
		
		
		int filas = ps.executeUpdate();
		ps.close();
		
	}
	public ArrayList<CamisetaModel> Listar() throws SQLException{
		
		PreparedStatement ps = Conex.prepareStatement("SELECT * FROM camiseta");
		ResultSet rs = ps.executeQuery();
		
		ArrayList<CamisetaModel> result = null;
		
		while(rs.next()){
			if(result==null) {
				result = new ArrayList<>();
			}
			result.add(new CamisetaModel( rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6)));
		}
		return result;
	}
	public String dameJason() throws SQLException {
		String json = "";
		Gson gson =new Gson();
		
		json = gson.toJson(this.Listar());
		
		return json;
	}
}
