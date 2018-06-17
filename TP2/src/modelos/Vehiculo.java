
package modelos;

public abstract class Vehiculo {
	private String vin;
	
	
	private Motor motor;
	
	public Motor getMotor() {
		return motor;
	}
	public void setMotor(Motor motor) {
		this.motor = motor;
	}
	public String getVin() {
		return vin; 
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	
	public Vehiculo(String vin, Motor motor ){
		this.vin = vin;	
		this.motor=motor;
	}
	
	
	@Override
	public String toString() {
		return "Vehiculo con vin: " + vin + " , " + motor;
	}
	
}