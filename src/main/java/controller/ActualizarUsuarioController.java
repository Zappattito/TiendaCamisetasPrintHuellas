package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.UsuarioModel;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Servlet implementation class ActualizarUsuarioController
 */

public class ActualizarUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ActualizarUsuarioController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	private String getMD5(String input) {
		if(input == null) {
			return null;
		}
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(input.getBytes(StandardCharsets.UTF_8));
			BigInteger number = new BigInteger(1, messageDigest);
			String hashtext = number.toString(16);
			while (hashtext.length()<32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		}catch(NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		PrintWriter out = response.getWriter();
		String id1 = request.getParameter("id");
		System.out.println(id1);

		UsuarioModel u = new UsuarioModel();

		try {
			int id = Integer.parseInt(id1);
			System.out.println(id);
			u.obtenerPorId(id);
			out.print(u.actualizaJson());
			System.out.println("ESTOY EN EL DO GET");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("ESTOY EN EL DO POST");

		String nombre = request.getParameter("nombre");
		String correo = request.getParameter("correo");
		String contrasena = getMD5(request.getParameter("contrasena"));
		String foto = request.getParameter("foto");

		// Verifica si el parámetro "idUsuario" no es nulo antes de convertirlo a un
		// entero
		String idUsuarioStr = request.getParameter("idUsuario");
		if (idUsuarioStr != null && !idUsuarioStr.isEmpty()) {
			try {
				int id = Integer.parseInt(idUsuarioStr);
				int permiso = 9;

				UsuarioModel u = new UsuarioModel(nombre, correo, contrasena, foto, permiso);
				u.setIdUsuario(id);
				u.actualizar();
			} catch (NumberFormatException e) {
				e.printStackTrace();
				// Maneja la excepción de formato de número aquí
				// Puedes mostrar un mensaje de error o redirigir a una página de error
			} catch (Exception e) {
				e.printStackTrace();
				// Maneja otras excepciones aquí
			}
		} else {
			System.out.println("ERROR");
			// Maneja el caso donde "idUsuario" es nulo o vacío
			// Puedes mostrar un mensaje de error o redirigir a una página de error
		}

		/**
		 * String nombre = request.getParameter("nombre"); System.out.println(nombre);
		 * String correo = request.getParameter("correo"); String contrasena =
		 * request.getParameter("contrasena"); String foto =
		 * request.getParameter("foto"); int id =
		 * Integer.parseInt(request.getParameter("idUsuario")); System.out.println(id +
		 * "1");
		 * 
		 * int permiso = 9;
		 * 
		 * UsuarioModel u = new UsuarioModel (nombre,correo, contrasena, foto, permiso);
		 * 
		 * try {
		 * 
		 * u.setIdUsuario(id); u.actualizar(); } catch (Exception e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 **/

	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nombre = request.getParameter("nombre");
		String correo = request.getParameter("correo");
		String contrasena = getMD5(request.getParameter("contrasena"));
		String foto = request.getParameter("foto");
		int permiso = Integer.parseInt(request.getParameter("permiso"));
		int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));

		UsuarioModel uEditar = new UsuarioModel(idUsuario, nombre, correo, contrasena, foto, permiso);
		System.out.println(uEditar);
		try {
			uEditar.actualizar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
		UsuarioModel UsuarioModel = new UsuarioModel();
		try {
			UsuarioModel.borrarUsu(idUsuario);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
