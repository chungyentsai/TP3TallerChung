
package modelos;


public class Moto extends Vehiculo{
	private String encendidoElectronico;
	
	 public String toString(){
	        return super.toString();
	    }	
	public String getContenido() {
		return encendidoElectronico;
	}
	public void setContenido(String contenido) {
		this.encendidoElectronico = contenido;
	}
	
	public Moto (String vin, Motor motor, String contenido){
		 super(vin, motor);
	     this.setContenido(contenido);
	 }
	
}
