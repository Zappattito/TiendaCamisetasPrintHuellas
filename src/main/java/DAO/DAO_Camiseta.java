package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Camiseta;
import modelo.Usuario;

public class DAO_Camiseta {
	
	private Connection Conex = null;
	private static DAO_Camiseta instance = null;
	public DAO_Camiseta() {
		// TODO Auto-generated constructor stub
	}
		
	public void Insertar_Camiseta(Camiseta x) throws SQLException{
		String query = "INSERT INTO camiseta (nombre, talla) VALUES (?,?)";
		PreparedStatement ps = Conex.prepareStatement(query);
		ps.setString(2, x.getNombre());
		ps.setString(3, x.getTalla());
		int filas = ps.executeUpdate();
		ps.close();
	}
	public List<Camiseta> Consultar_Camiseta()  {
		List<Camiseta> listaCamisetas = new ArrayList<>();
		String query = "SELECT * FROM camiseta"; 
		System.out.println("emi");
		try {
			Conex = DB_Conection.getConexion();
			Statement stmt = Conex.createStatement();
	        ResultSet rs = stmt.executeQuery(query);
	        while(rs.next()){
	        	Camiseta camiseta = new Camiseta();
	        	camiseta.setNombre(rs.getString("nombre"));
	        	camiseta.setTalla(rs.getString("talla"));
	        	
	            //Display values
	          listaCamisetas.add(camiseta);
	  
	         }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			e.printStackTrace();
			
		}
		return listaCamisetas;
}
	}
