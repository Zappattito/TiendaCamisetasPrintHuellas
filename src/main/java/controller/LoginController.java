package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.UsuarioModel;

import java.io.IOException;

import dao.UsuarioDAO;



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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				
		String correo = request.getParameter("correo");
		String contrasena = request.getParameter("contrasena");
		
		System.out.println(correo);
		System.out.println(contrasena);
		
		try {
			UsuarioModel usuarioLogin = new UsuarioModel();
			usuarioLogin.setCorreo(correo);
			usuarioLogin.setContrasena(contrasena);
			
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			boolean existeUsuario = usuarioDAO.comprobarCuenta(usuarioLogin);
			System.out.println(existeUsuario);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
