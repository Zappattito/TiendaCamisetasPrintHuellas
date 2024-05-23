package model;

import java.sql.SQLException;

import dao.CamisetaDAO;

public class CamisetaModel {

	private int idCamiseta;
	private String modelo;
	private String talla;
	private int cantidad;
	private String color;
	private String foto;	
	private String estado;

	public CamisetaModel() {

	}





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








	public CamisetaModel(String modelo, String talla, int cantidad, String color, String foto, String estado) {
		super();
		this.modelo = modelo;
		this.talla = talla;
		this.cantidad = cantidad;
		this.color = color;
		this.foto = foto;
		this.estado = estado;
	}





	public int getIdCamiseta() {
		return idCamiseta;
	}




	public void setIdCamiseta(int idCamiseta) {
		this.idCamiseta = idCamiseta;
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








	@Override
	public String toString() {
		return "CamisetaModel [idCamiseta=" + idCamiseta + ", modelo=" + modelo + ", talla=" + talla + ", cantidad="
				+ cantidad + ", color=" + color + ", foto=" + foto + ", estado=" + estado + "]";
	}





	public void Insert() throws Exception {
		CamisetaDAO.getInstance().Insert(this);
	}

}
