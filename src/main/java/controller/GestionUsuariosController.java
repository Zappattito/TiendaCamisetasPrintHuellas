//GestionUsuarios es mi Servlet, donde voy a recibir datos de usuario y donde voy
//a tratar mis datos recogiendolos o sacandolos por pantalla. Se encuentra siempre dentro
//del paquete llamado controlador

package controller;
//aqui estoy importando las librerias de jakarta para el uso de mi servlet
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import model.UsuarioModel;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.UsuarioDAO;

/**
 * Servlet implementation class GestionUsuarios
 */
@MultipartConfig
@WebServlet("/GestionUsuariosController")
public class GestionUsuariosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//añadimos un atributo al servlet
	// aqui va la ruta de los archivos
	private String pathFiles = "C:\\Users\\zappa\\Documents\\FP_DAM\\TiendaCamisetas\\src\\main\\webapp\\fotos";
	private File uploads = new File(pathFiles);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionUsuariosController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    //METODO doGEt del servlet que sirve para obtener los datos introducidos
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String json = "";
		try {
			json = UsuarioDAO.getInstance().dameJson();
			System.out.println(json);
			out.print(json);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String nombre = request.getParameter("nombre");
		String correo = request.getParameter("correo");
		String contrasena = request.getParameter("contrasena");
		
		
		
		// aquí vamos a meter archivos estilo fotos
		
		/*
		 * ruta
		 * datos
		 * NombreArchivo         buffer		File <--- datos -> BD guardaremos el archivo
		 * 
		 * ORIGEN                ----->         DESTINO 
		 * 						 CAMINO
		 * 
		 */
		// Lectura de datos desde el cliente
		Part part = request.getPart("foto");//datos binarios de la foto
		// Nombre del artchivo en origen, mediante un objeto path para gestionar una ruta
		Path path = Paths.get(part.getSubmittedFileName());//me da el nombre del archivo original
		String fileName = path.getFileName().toString();//creo el string que va directo a la base de datos
		
		//tengo que crear el camino el BUFFER por donde voy a trasmitir los datos que he adquirido
		InputStream input = part.getInputStream();
		
		//despues de la ruta donde voy a hacer el copiado de la foto
		
		File file = new File(uploads,fileName);
		try {
			Files.copy(input, file.toPath());
		}catch (Exception e) {
			System.out.println("error en la copia del archivo");
			PrintWriter error = response.getWriter();
			error.print("<h4>Se ha producido un error contacte con el administrador</h4>");
		}
		
		int permiso = 9;
		
		
		
		UsuarioModel u1= new UsuarioModel(nombre, correo, contrasena, fileName, permiso);
		System.out.println(u1.toString());
		
		try {
			u1.insertar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("micuenta.html");
	}

}
