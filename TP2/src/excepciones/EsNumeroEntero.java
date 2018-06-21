package excepciones;

public class EsNumeroEntero {
	
	int i;
	
	public EsNumeroEntero(){
		
	}
	
	public EsNumeroEntero(int i)throws EsNumeroException{
	        if ((i%1) == 0) { 
	            this.i = i;
	        } else { 
	        	throw new EsNumeroException("El numero no es entero");
	        } 
	    } 
	}
