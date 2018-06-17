package modelos;

public class Motor {
	private float motorLitros;
	private int motorCilindradas;
	
	public float getMotorLitros() {
		return motorLitros;
	}
	public void setMotorLitros(float motorLitros) {
		this.motorLitros = motorLitros;
	}
	public int getMotorCilindradas() {
		return motorCilindradas;
	}
	public void setMotorCilindradas(int motorCilindradas) {
		this.motorCilindradas = motorCilindradas;
	}
	
	public Motor(){
		motorLitros=0.0f;
		motorCilindradas=0;
	}
	@Override
	public String toString(){
		return "motor de: " + motorLitros + " litros y " + motorCilindradas + " cilindradas" ;
	}
}
