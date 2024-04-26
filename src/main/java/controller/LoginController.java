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
			
			if (existeUsuario) {
				
				HttpSession sesion = request.getSession(); 
				System.out.println(sesion);
				
				if (sesion != null) {
					System.out.println("bien");
					sesion.setAttribute("correo", usuarioLogin.getCorreo() );
					RequestDispatcher rd = request.getRequestDispatcher("carrito.jsp");
					rd.forward(request, response);
				}else {
					System.out.println("mal");

				}
				 
				
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("micuenta.html");
				rd.forward(request, response);
			}
				
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
