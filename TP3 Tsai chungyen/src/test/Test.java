package test;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Scanner;
import java.util.Vector;

import estructuras.ListaSimple;
import estructuras.ListaSimpleInterface;
import modelos.Investigacion;
import modelos.Libro;

public class Test {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int opcionIngresada;
		int i;
		String autor;
		String titulo;
		int aniopublicacion;
		int isbn;
		String genero;
		String campo;
		
		ListaSimple listaInvestigacion = new ListaSimple();
		ListaSimple listaLibro = new ListaSimple();
		
		Vector vectorLibro = new Vector(1,1);
		Libro l1 = new Libro("harry poter", "inglesa", 2998, "fantasia", 1234567890);
		Libro l2 = new Libro("senior", "anonimo", 1880, "guerra", 1234567899);
		vectorLibro.addElement(l1);
		vectorLibro.addElement(l2);
		listaLibro.insertarOrdenado(l1);
		listaLibro.insertarOrdenado(l2);
		listaLibro.listar();
		
		Vector vectorInvestigacion = new Vector(1,1);
		Investigacion i1 = new Investigacion("segunda guerra mundial", "chun", 2944, "documental");
		Investigacion i2 = new Investigacion("area 51", "tsai", 1969, "ovni");
		vectorInvestigacion.addElement(i1);
		vectorInvestigacion.addElement(i2);
		listaInvestigacion.insertar(i1);
		listaInvestigacion.insertar(i2);
				
		do{
			System.out.println("Bienvenido a la biblioteca");
			System.out.println("1.Insertar un nuevo documento");
			System.out.println("2.Ver la lista de documentos");
			opcionIngresada = sc.nextInt();
			sc.nextLine();
			switch (opcionIngresada) {
			case 1:
				do{
					System.out.println("1.Insertar un nuevo libro");
					System.out.println("2.Insertar un nuevo documento");
					System.out.println("3.Volver al menu anterior");
					opcionIngresada = sc.nextInt();
					sc.nextLine();
					switch (opcionIngresada) {
					case 1:
						System.out.println("Ingrese el titulo del libro");
						titulo = sc.nextLine();
						System.out.println("Ingrese el autor del libro");
						autor = sc.nextLine();
						System.out.println("Ingrese el anio de publicacion");
						aniopublicacion = sc.nextInt();
						sc.nextLine();
						System.out.println("Ingrese el genero del libro");
						genero = sc.nextLine();
						System.out.println("Ingrese el codigo isbn");
						isbn = sc.nextInt();
						sc.nextLine();
						Libro libro = new Libro(titulo, autor, aniopublicacion, genero, isbn);
						vectorLibro.addElement(libro);
						listaLibro.insertarOrdenado(libro);
						
						
						
						
						break;
					case 2:
						System.out.println("Ingrese el titulo de la investigacion");
						titulo = sc.nextLine();
						System.out.println("Ingrese el autor de la investigacion");
						autor = sc.nextLine();
						System.out.println("Ingrese el anio de publicacion");
						aniopublicacion = sc.nextInt();
						System.out.println("Ingrese el campo de la investigacion");
						campo = sc.nextLine();
						
						Investigacion investigacion = new Investigacion(titulo, autor, aniopublicacion, campo);
						vectorInvestigacion.addElement(investigacion);
						listaInvestigacion.insertarOrdenado(investigacion);
						System.out.println("se ha insertado: "+ investigacion.toString());
						break;
					default:
						break;
					}
					
				}while(opcionIngresada != 3);
				break;
				/////////////////////////
			case 2:
				do{
					System.out.println();
					System.out.println("Se mostrara la lista de libros");
					listaLibro.listar();
					System.out.println("\nCual se desea borrar?");
					System.out.println("Indique el anio");
					i=sc.nextInt();
					listaLibro.BuscarC(i);
				}while (opcionIngresada !=5)
				
				
				//for (i=0; i<vectorLibro.size() ; i++){
				//	System.out.println(i+": "+vectorLibro.elementAt(i).toString());
				//}
				//System.out.println("Seleccione el anio a eliminar");
				

				//String ref = sc.nextLine();
				//listaLibro.eliminarI(i);
				
				//listaLibro.eliminarRefer(ref);
				break;
			default:
				break;
			}
			//termina sw menu
			
		}while (opcionIngresada != 0);
		

	}

}
