package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.Camiseta;

import java.io.IOException;
import java.util.List;

import DAO.DAO_Camiseta;

/**
 * Servlet implementation class GestionCamisetas
 */
public class GestionCamisetas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionCamisetas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DAO_Camiseta daoCamiseta = new DAO_Camiseta();
		List<Camiseta> listaCamisetas = daoCamiseta.Consultar_Camiseta();
		
		HttpSession misesion = request.getSession();
		misesion.setAttribute("listaCamisetas", listaCamisetas);
		response.sendRedirect("mostrarCamisetas.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nombre = request.getParameter("nombre");
		String talla = request.getParameter("talla");
	}

}
