package modelos;


public class Auto extends Vehiculo{
	private boolean airbags;
	
	public boolean isAirbags() {
		return airbags;
	}
	public void setAirbags(boolean airbags) {
		this.airbags = airbags;
	}
	@Override
	public String toString(){
	        return super.toString()+" y "+airbags;
	    }	

	public Auto(String vin, Motor motor, boolean airbags) {
		super(vin, motor);
		this.airbags = airbags;
	}

	

	
	

}
