//GestionUsuarios es mi Servlet, donde voy a recibir datos de usuario y donde voy
//atratar mis datos recogiendolos o sacandolos por pantalla. Se encuentra siempre dentro
//del paquete llamado controlador

package controlador;
//aqui estoy importando las librerias de jakarta para el uso de mi servlet
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
//importo la clase Usuario del paquete modelo, la java util list y Array list
import modelo.Usuario;

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
//importo la clase DAO_Usuario del paquete DAO
import DAO.DAO_Usuario;

/**
 * Servlet implementation class GestionUsuarios
 */
@MultipartConfig
public class GestionUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//añadimos un atributo al servlet
	// aqui va la ruta de los archivos
	private String pathFiles = "C:\\Users\\zappa\\Documents\\FP_DAM\\TiendaCamisetas\\src\\main\\webapp\\fotos";
	private File uploads = new File(pathFiles);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionUsuarios() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    //METODO doGEt del servlet que sirve para obtener los datos introducidos
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//
		//DAO_Usuario daoUsuario = new DAO_Usuario();
		//Me creo una Arrais list para meter los usuarios
		//List<Usuario> listaUsuarios = daoUsuario.Consultar_Usuario();
		//esta parte es para forzar la introduccion de unos ususarios ficticios
//		listaUsuarios.add(new Usuario("Fatima2", "fatima@gmail.com", "12345", "12345"));
//		listaUsuarios.add(new Usuario("Cecilia", "cecilia@gmail.com", "12345", "12345"));
//		listaUsuarios.add(new Usuario("Norma", "norma@gmail.com", "12345", "12345"));

		//aquí envío los datos a mostrarUsuarios,jsp para que me aparezcan en pantalla
		//HttpSession misesion = request.getSession();
		//misesion.setAttribute("listaUsuarios", listaUsuarios);
		//response.sendRedirect("mostrarUsuarios.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//metodo doPost que sirve para recoger los datos 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String nombre = request.getParameter("nombre");
		String correo = request.getParameter("correo");
		String contrasena = request.getParameter("contrasena");
		String confirmar_contrasena = request.getParameter("confirmar_contrasena");
		
		
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
		
		
		
		
		Usuario u1= new Usuario(nombre, correo, contrasena, confirmar_contrasena, fileName);
		System.out.println(u1.toString());
		
		try {
			u1.Insertar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
