
package modelos;


public class Moto extends Vehiculo{
	private boolean encendidoElectronico;
	
	 public String toString(){
	        return super.toString()+" y "+encendidoElectronico;
	    }	

	
	public boolean isEncendidoElectronico() {
		return encendidoElectronico;
	}


	public void setEncendidoElectronico(boolean encendidoElectronico) {
		this.encendidoElectronico = encendidoElectronico;
	}


	public Moto(String vin, Motor motor, boolean encendidoElectronico) {
		super(vin, motor);
		this.encendidoElectronico = encendidoElectronico;
	}


	
	
}
