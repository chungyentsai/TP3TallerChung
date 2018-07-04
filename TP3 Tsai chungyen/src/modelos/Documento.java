package modelos;

public abstract class Documento implements Comparable{
	private String autor;
	private String titulo;
	private Integer aniopublicacion;
	
	public void setAniopublicacion(Integer aniopublicacion) {
		this.aniopublicacion = aniopublicacion;
	}
	public Integer getAniopublicacion() {
		return aniopublicacion;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public Documento(String titulo, String autor, Integer aniopublicacion){
		this.titulo = titulo;
		this.autor = autor;
		this.aniopublicacion = aniopublicacion;
	}
	
	public String toString(){
		return "El documento: " + titulo + ", escrito por: " + autor + ", en el anio: " + aniopublicacion;
	}

	
	public int compareTo (Object d){
		if (d instanceof Documento){
			System.out.println("Comprobando igualdad, se encontro");
			return this.getAniopublicacion().compareTo(((Documento)d).getAniopublicacion());
		}else{
			System.out.println("Cantidad de igualdad encontrada: 0");
			return 0;
		}
	}
	
}
