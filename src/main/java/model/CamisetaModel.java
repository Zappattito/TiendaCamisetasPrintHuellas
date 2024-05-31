package model;

import java.sql.SQLException;

import com.google.gson.Gson;

import dao.CamisetaDAO;

/**
 * Esta clase nos permite crear el objeto camiseta con todos sus atributos
 * 
 * @author: Victor Zapata P.
 * @version: 31/05/2024/Z v 1.0
 * 
 */
public class CamisetaModel {
	private int idCamiseta;
	private String modelo;
	private String talla;
	private int cantidad;
	private String color;
	private String foto;
	private String estado;

//Constructor vacío de CamisetaModel
	public CamisetaModel() {

	}

	/**
	 * Constructor donde se insertan los tributos del objeto CamisetaModel
	 * 
	 * @param idCamiseta de tipo integer autogenerado por la base de datos para cada
	 *                   objeto camiseta creado
	 * @param modelo     de tipo String recibe el modelo de la camiseta niño,
	 *                   hombre, mujer
	 * @param talla      String que recibe la talla de la camiseta S,M,L,XL,XXL
	 * @param cantidad   tipo integer que recibe la cantidad de camisetas del mismo
	 *                   tipo que se quieren elaborar
	 * @param color      String que define el color de la camiseta
	 * @param foto       String que recibe la ruta de la imagen del diseño que se
	 *                   quiere insertar en la camiseta
	 * @param estado     String que define el estado de la camiseta
	 */

	public CamisetaModel(int idCamiseta, String modelo, String talla, int cantidad, String color, String foto,
			String estado) {
		super();
		this.idCamiseta = idCamiseta;
		this.modelo = modelo;
		this.talla = talla;
		this.cantidad = cantidad;
		this.color = color;
		this.foto = foto;
		this.estado = estado;
	}

	/**
	 * Constructor que no recibe id, este nos permiste posteriormente modificar
	 * todos los campos excepto su id que <br>
	 * funciona en la base de datos como su primarykey, permite que el usuario
	 * modifique su pedido pero no su id
	 * 
	 * @param modelo   de tipo String recibe el modelo de la camiseta niño, hombre,
	 *                 mujer
	 * @param talla    String que recibe la talla de la camiseta S,M,L,XL,XXL
	 * @param cantidad tipo integer que recibe la cantidad de camisetas del mismo
	 *                 tipo que se quieren elaborar
	 * @param color    que define el color de la camiseta
	 * @param foto     que recibe la ruta de la imagen del diseño que se quiere
	 *                 insertar en la camiseta
	 * @param estado   String que define el estado de la camiseta
	 */

	public CamisetaModel(String modelo, String talla, int cantidad, String color, String foto, String estado) {
		super();
		this.modelo = modelo;
		this.talla = talla;
		this.cantidad = cantidad;
		this.color = color;
		this.foto = foto;
		this.estado = estado;
	}

//permite obtener el id de la camiseta

	public int getIdCamiseta() {
		return idCamiseta;
	}

//permite modificar el id de la camiseta

	public void setIdCamiseta(int idCamiseta) {
		this.idCamiseta = idCamiseta;
	}

//permite obtener el modelo de una camiseta

	public String getModelo() {
		return modelo;
	}

//permite modificar el modelo de una camiseta

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

//permite obtener la talla de una camiseta

	public String getTalla() {
		return talla;
	}

//permite modificar la talla de una camiseta

	public void setTalla(String talla) {
		this.talla = talla;
	}

//permite obtener el color de la camiseta

	public String getColor() {
		return color;
	}

//permite modificar el color de una camiseta

	public void setColor(String color) {
		this.color = color;
	}

//permite obtener la imagen que se va a insertar en la camiseta

	public String getFoto() {
		return foto;
	}

//permite modificar la imagen que se inserta en la camiseta

	public void setFoto(String foto) {
		this.foto = foto;
	}

//permite obtener la cantidad de camisetas a elaborar del mismo tipo

	public int getCantidad() {
		return cantidad;
	}

//permite modificar la cantidad de camisetas a elaborar

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

// permite obtener el estado de la elaboración de la camiseta

	public String getEstado() {
		return estado;
	}

// permite modificar por parte del administrador el estado de la camiseta

	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * metodo to string que devuelve todos los atributos del objeto CamisetaModel
	 * 
	 */

	@Override
	public String toString() {
		return "CamisetaModel [idCamiseta=" + idCamiseta + ", modelo=" + modelo + ", talla=" + talla + ", cantidad="
				+ cantidad + ", color=" + color + ", foto=" + foto + ", estado=" + estado + "]";
	}

	/**
	 * Metodo que inserta los parametros obtenidos por los Usuarios en la base de
	 * datos
	 * 
	 * @throws Exception recoge las excepciones que se puedan producir en el método
	 *                   Insert
	 */

	public void Insert() throws Exception {
		CamisetaDAO.getInstance().Insert(this);
	}

	/**
	 * metodo para extraer de la base de datos toda los parámetros a traves del id
	 * 
	 * @param idCamiseta identificador de un objeto camiseta que quiero obtener
	 * @throws Exception recoge las excepciones del método obtenerPorId
	 */
	public void obtenerPorId(int idCamiseta) throws Exception {

		CamisetaModel aux = CamisetaDAO.getInstance().obtenerPorId(idCamiseta);

		this.setIdCamiseta(aux.getIdCamiseta());
		this.setModelo(aux.getModelo());
		this.setTalla(aux.getTalla());
		this.setCantidad(aux.getCantidad());
		this.setColor(aux.getColor());
		this.setFoto(aux.getFoto());
		this.setEstado(aux.getEstado());

	}

	/**
	 * Metodo que sirve para actualizar un objeto que previamente se ha recogido a
	 * traves de su id
	 * 
	 * @throws SQLException recoge excepciones del método actualizar con respecto a
	 *                      la base de datos
	 * @throws Exception    recoge excepciones del método actualizar
	 */

	public void actualizar() throws SQLException, Exception {
		CamisetaDAO.getInstance().actualizar(this);
		System.out.println(this);
	}

	/**
	 * Metodo para recoger la información de la base de datos
	 * 
	 * @return devuelve un Json que pintaremos en el front
	 */
	public String dameJson() {
		String json = "";
		Gson gson = new Gson();

		json = gson.toJson(this);
		return json;

	}

	/**
	 * Metodo que sirve para recoger los datos actualizados en la base da datos y
	 * mostrarlo en el front
	 * 
	 * @return un Json que mostraremos en el front
	 */

	public String actualizaJson() {

		String json = "";
		Gson gson = new Gson();

		json = gson.toJson(this);

		return json;
	}

	/**
	 * Metodo que sirve para borrar/eliminar un objeto camiseta de la base de datos
	 * 
	 * @param idCamiseta nos proporciona el id de la camiseta a eliminar/borrar
	 * @throws SQLException recoge las excepciones en el camino a la base de datos
	 * @throws Exception    recoge las excepciones del método borrar
	 */

	public void borrarCami(int idCamiseta) throws SQLException, Exception {
		CamisetaDAO.getInstance().borrarCamiseta(idCamiseta);
	}

}
