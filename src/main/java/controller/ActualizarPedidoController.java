package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.CamisetaModel;
import model.UsuarioModel;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class ActualizarPedidoController
 */
public class ActualizarPedidoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizarPedidoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String id1 = request.getParameter("id");
		System.out.println(id1);

		CamisetaModel c = new CamisetaModel();

		try {
			int id = Integer.parseInt(id1);
			System.out.println(id);
			c.obtenerPorId(id);
			out.print(c.actualizaJson());
			System.out.println("ESTOY EN EL DO GET");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("ESTOY EN EL DO POST");

		String modelo = request.getParameter("modelo");
		String talla = request.getParameter("talla");
		int cantidad= Integer.parseInt(request.getParameter("cantidad"));
		String color = request.getParameter("color");
		String foto = request.getParameter("foto");
		String estado = request.getParameter("estado");

		// Verifica si el parámetro "idUsuario" no es nulo antes de convertirlo a un
		// entero
		String idCamisetaStr = request.getParameter("idCamiseta");
		if (idCamisetaStr != null && !idCamisetaStr.isEmpty()) {
			try {
				int id = Integer.parseInt(idCamisetaStr);
				

				CamisetaModel c = new CamisetaModel(modelo, talla, cantidad, color, foto, estado);
				c.setIdCamiseta(id);
				c.actualizar();
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

		
	}
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String modelo = request.getParameter("modelo");
		String talla = request.getParameter("talla");
		int cantidad  = Integer.parseInt(request.getParameter("cantidad"));
		String color = request.getParameter("color");
		String foto = request.getParameter("foto");
		String estado = request.getParameter("estado");
		int idCamiseta = Integer.parseInt(request.getParameter("idCamiseta"));

		CamisetaModel cEditar = new CamisetaModel(idCamiseta, modelo, talla, cantidad, color, foto, estado);
		System.out.println(cEditar);
		try {
			cEditar.actualizar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int idCamiseta = Integer.parseInt(request.getParameter("idCamiseta"));
		CamisetaModel CamisetaModel = new CamisetaModel();
		try {
			CamisetaModel.borrarCami(idCamiseta);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
