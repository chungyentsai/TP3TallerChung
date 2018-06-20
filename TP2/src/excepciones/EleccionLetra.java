package excepciones;

public class EleccionLetra {
	
	String letraIngresada;
	public EleccionLetra(){
		
	}
	
	public EleccionLetra(String letraIngresada) throws EleccionLetraException{
		if(letraIngresada.equalsIgnoreCase("Y") || letraIngresada.equalsIgnoreCase("N")){
			this.letraIngresada = letraIngresada;
		}	else{
			throw new EleccionLetraException("Error de eleccion");
		}
	}
	

	
	
	
}
