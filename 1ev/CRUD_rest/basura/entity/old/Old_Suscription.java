package z_com.jacaranda.entity.old;

import com.jacaranda.entity.SuscriptionEnum;

public class Old_Suscription {

	private int idSuscription;
	private static int idSiguiente = 0;
	private SuscriptionEnum tipo;  

	
	
	public Old_Suscription() {
		super();
	}
	public Old_Suscription(SuscriptionEnum tipo) {
		super();
		this.idSuscription = idSiguiente++;
		this.tipo = tipo;
	}
	
	
	
	public int getIdSuscription() {
		return idSuscription;
	}
	public void setIdSuscription(int idSuscription) {
		this.idSuscription = idSuscription;
	}
	public static int getIdSiguiente() {
		return idSiguiente;
	}
	public static void setIdSiguiente(int idSiguiente) {
		Old_Suscription.idSiguiente = idSiguiente;
	}
	public SuscriptionEnum getTipo() {
		return tipo;
	}
	public void setTipo(SuscriptionEnum tipo) {
		this.tipo = tipo;
	}
	

	
}
