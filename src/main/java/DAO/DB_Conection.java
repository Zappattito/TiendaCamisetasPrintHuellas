package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//cuando tu creas un metodo estatico, el metodo no es capaz de ver sus propios atributos, asi que tenemos que crear un objeto de si mismo que
	// herede todos esos atributos y métodos, es como crear un yo que sea capáz de verte la espalda
	// este es un objeto que va a ser el único que interactúe con la base de datos, es decir el segurata de la discoteca llamada 
	// Base de datos
	//PATRON SINGELTON

public class DB_Conection {

	public static final String JDBC_URL = "jdbc:mysql://localhost:3306/tienda";
	public static Connection instance = null;
	
	// en esta zonba podemos poner los parámetro de conexion a traves de los props
	
	public static Connection getConexion() throws Exception {
		if (instance == null) {
			instance = DriverManager.getConnection(JDBC_URL, "root", "");// esto es un patron singelton
		}
		return instance;
	}
}
