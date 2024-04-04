package modelo;

import java.sql.PreparedStatement;

public class Camiseta {
	
	private String nombre;
	private String talla;
	
	public Camiseta() {
		
	}
	
	public Camiseta(String nombre, String talla) {
		super();
		this.nombre = nombre;
		this.talla = talla;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTalla() {
		return talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}

	@Override
	public String toString() {
		return "Camiseta [nombre=" + nombre + ", talla=" + talla + "]";
	}

	
}
	