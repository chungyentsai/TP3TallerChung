package modelos;

public class Investigacion extends Documento{
	private String campo;

	public String getCampo() {
		return campo;
	}
	public void setCampo(String campo) {
		this.campo = campo;
	}

	public String toString(){
		return super.toString() + ", es una investigacion perteneciente al campo: " + campo;	
	}

	public Investigacion(String titulo, String autor, int aniopublicacion, String campo) {
		super(titulo, autor, aniopublicacion);
		this.campo = campo;
	}
}
