package excepciones;

public class EsLetra {
	char letra;
	
	public EsLetra(){
		
	}
	
	public EsLetra(char letra) throws EsLetraException{
		if(!Character.isLetter(letra)){
			throw new EsLetraException("Ingrese letras");
		}	else{
			this.letra=letra;
		}
	}
}
