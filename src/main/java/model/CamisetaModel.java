package model;

import java.sql.SQLException;

import dao.CamisetaDAO;

public class CamisetaModel {

	private int id;
	private String modelo;
	private String talla;
	private String color;
	private String foto;
	private int cantidad;
	private String estado;

	public CamisetaModel() {

	}

	public CamisetaModel(int id, String modelo, String talla, String color, String foto, int cantidad, String estado) {
		super();
		this.id = id;
		this.modelo = modelo;
		this.talla = talla;
		this.color = color;
		this.foto = foto;
		this.cantidad = cantidad;
		this.estado = estado;
	}

	public CamisetaModel(String modelo, String talla, String color, String foto, int cantidad) {
		super();
		this.modelo = modelo;
		this.talla = talla;
		this.color = color;
		this.foto = foto;
		this.cantidad = cantidad;

	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public CamisetaModel(int id, String modelo, String talla, String color, String foto) {
		super();
		this.id = id;
		this.modelo = modelo;
		this.talla = talla;
		this.color = color;
		this.foto = foto;
	}

	public CamisetaModel(String modelo, String talla, String color, String foto) {
		super();
		this.modelo = modelo;
		this.talla = talla;
		this.color = color;
		this.foto = foto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getTalla() {
		return talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	@Override
	public String toString() {
		return "Camiseta [id=" + id + ", modelo=" + modelo + ", talla=" + talla + ", color=" + color + ", foto=" + foto
				+ ", cantidad=" + cantidad + ", estado=" + estado + "]";
	}

	public void Insert() throws Exception {
		CamisetaDAO.getInstance().Insert(this);
	}

}
