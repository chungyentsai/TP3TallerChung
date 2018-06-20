package excepciones;

import org.xml.sax.helpers.ParserAdapter;

public class EsNumeroDecimal {
	
	float decimal;
	String deci;
	boolean paso;
	public EsNumeroDecimal(){
		
	}
	
	public void Pasar(){
		paso = true;
		deci = String.valueOf(decimal);
		decimal=Float.parseFloat(deci);
		paso = false;
	}
	
	public EsNumeroDecimal(float decimal) throws EsNumeroException{
		Pasar();
		if (paso=false){
			if (decimal - Math.floor(decimal) == 0) {
				throw new EsNumeroException("Es un numero entero");
		    } else {
		        this.decimal = decimal;
		    }
		}
			
	}
	
	
}
