package excepciones;

public class ErrorSeleccionNum {
	int numeroSeleccionado;
	int rangoMax;
	int rangoMin;
	
	public ErrorSeleccionNum(){
		
	}
	public ErrorSeleccionNum(int numeroSeleccionado, int rangoMax, int rangoMin) throws ErrorSeleccionNumException{
		if(numeroSeleccionado < rangoMin || numeroSeleccionado > rangoMax){
			throw new ErrorSeleccionNumException("Error de seleccion");
		}	else{
			this.numeroSeleccionado = numeroSeleccionado;
		}
	}
	
	
}
