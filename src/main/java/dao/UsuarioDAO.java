package dao;

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
public class UsuarioDAO {

	public static Connection Conex = null; // genero un atributo de tipo connection, que llamo conex porque me apetece y de instancia nul.
	private static UsuarioDAO instance = null;
	
	public UsuarioDAO() throws Exception  {
		this.Conex = ConectionDB.getConexion();
	}

	public static UsuarioDAO getInstance() throws Exception{
		if(instance == null) {
			instance = new UsuarioDAO();
		}
		return instance;
	}
	public void Insertar(UsuarioModel x) throws SQLException {
		
		String sql = "INSERT INTO usuario (nombre, correo, contrasena, confirmar_contrasena, foto) VALUES (?,?,?,?,?)";
		PreparedStatement ps = Conex.prepareStatement(sql);
		ps.setString(1, x.getNombre());
		ps.setString(2, x.getCorreo());
		ps.setString(3, x.getContrasena());
		ps.setString(4, x.getConfirmar_contrasena());
		ps.setString(5, x.getFoto());
		
		int filas = ps.executeUpdate();
		ps.close();
	
		
	}
	public ArrayList<UsuarioModel> Listar() throws SQLException{
		
		PreparedStatement ps = Conex.prepareStatement("SELECT * FROM usuario");//se podria poner el nimbre de los campos
		ResultSet rs = ps.executeQuery();
		
		ArrayList<UsuarioModel> result = null;
		
		while(rs.next()){
			if(result==null) {
				result = new ArrayList<>();
			}
			result.add(new UsuarioModel( rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
		}
		
		return result;
		
	

	
}
	public String dameJson() throws SQLException {
		
		String json = "";
		Gson gson = new Gson();
		
		json = gson.toJson(this.Listar());
		
		return json;
	}

	public boolean comprobarCuenta(UsuarioModel usuarioLogin) throws SQLException {
		
		// TODO Auto-generated method stub
		PreparedStatement ps = Conex.prepareStatement("SELECT * FROM usuario WHERE correo = ? AND contrasena = ?");//se podria poner el nimbre de los campos
		ps.setString(1, usuarioLogin.getCorreo());
		ps.setString(2, usuarioLogin.getContrasena());
		ResultSet rs = ps.executeQuery();
		
		
	
		int totalFilas = 0;
		
		while(rs.next()){
			totalFilas ++;
		}
		
		System.out.println(totalFilas);
		if (totalFilas>0) {
			return true;
		}else {
			return false;
		}
	}
		
	}
