package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.UsuarioModel;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.UsuarioDAO;

/**
 * Servlet implementation class Listado
 */
@WebServlet("/ListadoController")
public class ListadoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListadoController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// ESTO SIRVE PARA COMPROBAR QUE ME LLEGAN LAS COSAS A CONSOLA
//		try {
//			ArrayList<Usuario> listaEnObjetos = DAO_Usuario.getInstance().Listar();
//			for(Usuario a: listaEnObjetos) {
//				
//				System.out.println(a.toString());
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		String respuestaJSON;
		try {
			respuestaJSON = UsuarioDAO.getInstance().dameJson();
			System.out.println(respuestaJSON);

			PrintWriter respuesta = response.getWriter();
			respuesta.print(respuestaJSON);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		doGet(request, response);
	}

}
