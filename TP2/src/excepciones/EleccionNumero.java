package excepciones;


public class EleccionNumero {
	
	int opcionIngresada;
	
	public EleccionNumero(){
		
	}
	
	public EleccionNumero(int opcionIngresada) throws EleccionNumeroException{
		if(opcionIngresada < 0 || opcionIngresada > 2){
			throw new EleccionNumeroException("Error");
		}	else{
			this.opcionIngresada = opcionIngresada;
		}
	}
	
        
    }