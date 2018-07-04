package modelos;

public class Libro extends Documento {
	private int isbn;
	private String genero;
	
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	@Override
	public String toString() {
		return super.toString() + ", es un libro de genero: " + genero + ", con su isbn: " + isbn;
	}
	
	
	
	public Libro(String autor, String titulo, int aniopublicacion, String genero, int isbn){
		super(autor, titulo, aniopublicacion);
		this.isbn = isbn;
		this.genero = genero;
	}
	

	
	
}
