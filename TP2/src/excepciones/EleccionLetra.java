package excepciones;

public class EleccionLetra {
	
	int opcionIngresada;
	
	public EleccionLetra(){
		
	}
	
	public EleccionLetra(int opcionIngresada) throws EleccionLetraException{
		if(opcionIngresada < 0 || opcionIngresada > 2){
			throw new EleccionLetraException("Error");
		}	else{
			this.opcionIngresada = opcionIngresada;
		}
	}
	

	
	
	
}
