package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import model.CamisetaModel;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import dao.CamisetaDAO;

/**
 * Servlet implementation class GestionCamiseta
 */
@MultipartConfig
@WebServlet("/GestionCamisetaController")
public class GestionCamisetaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// aqui va la ruta a los archivos
	private String pathFiles = "C:\\Users\\zappa\\Documents\\FP_DAM\\TiendaCamisetas\\src\\main\\webapp\\fotos";
	private File uploads = new File(pathFiles);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GestionCamisetaController() {
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
		PrintWriter out = response.getWriter();

		CamisetaDAO camiseta;
		try {
			camiseta = new CamisetaDAO();
			out.print(camiseta.dameJson());
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

		String modelo = request.getParameter("modelo");
		String talla = request.getParameter("talla");
		int cantidad = Integer.parseInt(request.getParameter("cantidad"));
		String color = request.getParameter("color");
		Part part = request.getPart("foto");
		Path path = Paths.get(part.getSubmittedFileName());
		String fileName = path.getFileName().toString();
		InputStream input = part.getInputStream();
		File file = new File(uploads, fileName);
		String estado = request.getParameter("estado");

		try {
			Files.copy(input, file.toPath());

		} catch (Exception e) {
			System.out.println("error en la copia del archivo");
			PrintWriter error = response.getWriter();
			error.print("<h4> Se ha producido un error contacte con el administrador</h4>") ;
		}

		CamisetaModel c = new CamisetaModel(modelo, talla, cantidad, color, fileName, estado);
		System.out.println(c.toString());

		try {
			c.Insert();
		} catch (Exception e) {
			e.printStackTrace();
		}

		response.sendRedirect("indexAdmin.html");

	}

}
