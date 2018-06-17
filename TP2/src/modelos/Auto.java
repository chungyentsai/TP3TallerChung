package modelos;


public class Auto extends Vehiculo{
	private String airbags;
	
	@Override
	 public String toString(){
	        return super.toString()+" y "+airbags;
	    }	
	 public Auto (String vin, Motor motor, String contenido){
		 super(vin, motor);
	     this.setContenido(contenido);
	 }
	
	public String getContenido() {
		return airbags;
	}
	public void setContenido(String contenido) {
		this.airbags = contenido;
	}
	
	

}
