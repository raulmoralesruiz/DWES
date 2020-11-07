package z_com.jacaranda.entity.old;

import java.io.Serializable;

import com.jacaranda.entity.SuscriptionEnum;

@SuppressWarnings("serial")
public abstract class backup_Product implements Serializable {
	
	private int idProduct;
	private static int idSiguiente = 0;
	private SuscriptionEnum tipoSuscripcion;  

	public backup_Product() {
		super();
		this.idProduct = idSiguiente++;
	}
	public backup_Product(SuscriptionEnum tipoSuscripcion) {
		this();
		this.tipoSuscripcion = tipoSuscripcion;
	}
	
	
	
	public int getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	public static int getIdSiguiente() {
		return idSiguiente;
	}
	public static void setIdSiguiente(int idSiguiente) {
		backup_Product.idSiguiente = idSiguiente;
	}
	public SuscriptionEnum getTipoSuscripcion() {
		return tipoSuscripcion;
	}
	public void setTipoSuscripcion(SuscriptionEnum tipoSuscripcion) {
		this.tipoSuscripcion = tipoSuscripcion;
	}
	
	
	public abstract String getTitle();
	public abstract int getIdMovie();
	public abstract void setTitle(String newTitle);
	public abstract int getIdSerie();
	

	
	
}
