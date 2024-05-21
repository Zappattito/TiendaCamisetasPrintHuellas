package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.UsuarioModel;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import dao.UsuarioDAO;
import model.UsuarioModel;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String correo = request.getParameter("correo");
		String contrasena = getMD5(request.getParameter("contrasena"));
		// String permiso = request.getParameter("permiso"); // esto hay que parsearlo

		System.out.println(correo);
		System.out.println(contrasena);

		try {
			UsuarioModel usuarioLogin = new UsuarioModel();
			usuarioLogin.setCorreo(correo);
			usuarioLogin.setContrasena(contrasena);

			UsuarioDAO usuarioDAO = new UsuarioDAO();
			boolean existeUsuario = usuarioDAO.comprobarCuenta(usuarioLogin);
			System.out.println(existeUsuario);

			if (existeUsuario) {
				// aqui vamos a traer el usuario de base de datos haciendo una select a traves
				// del correo
				// y para eso debemos crear un método en usuarioDAO como lo hemos hecho en el
				// comprobarCuenta
				// tambien hay que pasarle el usuartio loguin
				// este método debe de devolver un objeto MODEL

				HttpSession sesion = request.getSession();
				System.out.println(sesion);

				if (sesion != null) {
					System.out.println("bien");
					sesion.setAttribute("correo", usuarioLogin.getCorreo());
					RequestDispatcher rd = request.getRequestDispatcher("indexAdmin.html");
					rd.forward(request, response);

				} else {
					System.out.println("mal");

				}

			} else {
				RequestDispatcher rd = request.getRequestDispatcher("micuenta.html");
				rd.forward(request, response);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
