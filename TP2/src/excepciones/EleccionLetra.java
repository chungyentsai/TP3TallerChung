package excepciones;

public class EleccionLetra {
	
	String letraIngresada;
	public EleccionLetra(){
		
	}
	
	public EleccionLetra(String letraIngresada) throws EleccionLetraException{
		if(letraIngresada.equalsIgnoreCase("Y") || letraIngresada.equalsIgnoreCase("N")){
			throw new EleccionLetraException("Error de eleccion");
			
		}	else{
			this.letraIngresada = letraIngresada;
		}
	}
	

	
	
	
}
