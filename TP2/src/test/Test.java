package test;

import estructuras.Nodo;
import estructuras.cola.Cola;
import estructuras.pila.Pila;
import modelos.Moto;
import modelos.Motor;
import modelos.SoporteMecanico;
import modelos.Auto;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;

import excepciones.EleccionNumero;
import excepciones.EleccionNumeroException;
import excepciones.EmptyQueueException;
import excepciones.ErrorSeleccionNum;
import excepciones.ErrorSeleccionNumException;
import excepciones.EsLetra;
import excepciones.EsLetraException;
import excepciones.EleccionLetra;
import excepciones.EleccionLetraException;
import excepciones.LinkedListEmptyException;


public class Test {

    public static void main(String[] args) throws LinkedListEmptyException{
        
		Scanner sc = new Scanner(System.in);
		Scanner scanner = new Scanner(System.in);
		int opcionIngresada=-1;
		int numero;
		int i;
		String letraIngresada = " ";
		char letra = ' ';
		int numeroSeleccionado;
		String vin;
		float motorLitros;
		int motorCilindradas;
		EleccionNumero ele;
        ErrorSeleccionNum esn;        
        EleccionLetra eleLetra;
        EsLetra esLetra;
        
        int []menu2= new int[6];       
        int []menuTaller= new int[3];
        int []menuMostrarCola = new int[2];
        int []menuReparacion = new int[2];
        
		Vector vectorAuto = new Vector(1,1);
		Vector vectorMoto = new Vector(1,1);
		Motor motor = new Motor();
		
		int rangoMax;
		int rangoMin;
		
		
		
		
		Nodo nodoReparacion = new Nodo();
		Nodo nodomoto = new Nodo();
		
		Cola colaReparacion = new Cola();

		Nodo nodoRepararDisco = new Nodo();
		Pila repararDisco = new Pila();
		
		Vector vectorRepararDisco = new Vector(1,1);
		vectorRepararDisco.addElement("Quitar bulones");
		vectorRepararDisco.addElement("Remover rueda");
		vectorRepararDisco.addElement("Quitar caliper de freno");
		vectorRepararDisco.addElement("Remover disco de freno");
		vectorRepararDisco.addElement("Reemplazar disco de freno");

		
		SoporteMecanico SoporterepararDisco = new SoporteMecanico();
		
	
		
		String accion= " ";
		
		System.out.println("Bienvenido");	
		do{
			System.out.println("1.Operar");
			System.out.println("2.Taller");
            System.out.println("0.Salir");

            try{
            	opcionIngresada = scanner.nextInt();
            	
            }catch (InputMismatchException e2){
            	System.out.println("Error: "+e2.getClass().getName());
            	opcionIngresada = 0;
            	scanner = new Scanner(System.in);
            }
            try{
            	ele = new EleccionNumero(opcionIngresada); 
            }catch (EleccionNumeroException e){
            	System.out.println("Error: "+e.getClass().getName());   
            } 
            
            switch (opcionIngresada) {
				case 1:
					do{	
						rangoMax=menu2.length;
			            rangoMin=0;
						System.out.println("\nHa seleccionado Operar");
						System.out.println("1.Registrar auto");
						System.out.println("2.Registrar moto");
						System.out.println("3.Borrar auto registrado");
						System.out.println("4.Borrar moto registrado");
						System.out.println("5.Listar auto");
						System.out.println("6.Listar moto");
						System.out.println("0.Volver");
						//opcionIngresada=sc.nextInt();   
			            //sc.nextLine();
						try{
					        opcionIngresada = scanner.nextInt();	
					    }catch (java.util.InputMismatchException e2){
					    	System.out.println("Error: "+e2.getClass().getName());
					        opcionIngresada = 0;
					        scanner = new Scanner(System.in);
					    }
					    try{
					    	esn = new ErrorSeleccionNum(opcionIngresada, rangoMax, rangoMin);
					    }catch (ErrorSeleccionNumException e){
							System.out.println("Error al elegir numero :"+e.getClass().getName());
					    }
						
			            
			            

			            
			            switch (opcionIngresada) {
						case 1:
							System.out.println("Ingrese el vin del auto");
							vin = sc.nextLine();
							System.out.println("Ingrese y/n de acuerdo si posee airbags el auto ");
							letraIngresada = sc.nextLine();
							boolean airbags=true;
							
							
							System.out.println("Ingrese los datos del motor");
							System.out.println("De cuantos capacidades en litros es?");
							motorLitros = (float)sc.nextFloat();
							motor.setMotorLitros(motorLitros);
							System.out.println("De cuantas cilindradas es?");
							motorCilindradas = sc.nextInt();
							sc.nextLine();
							motor.setMotorCilindradas(motorCilindradas);

							Auto nuevoAuto = new Auto(vin, motor, airbags);
							vectorAuto.addElement(nuevoAuto.toString());
							System.out.println("se ha agregado el automovil con el vin:"+vin+" con un "+motor+" y "+airbags+" contiene airbags");
							break;
						case 2:
							System.out.println("\nIngrese el vin de la moto");
							vin = sc.nextLine();
							System.out.println("Ingrese y/n de acuerdo si posee encendido electronico la moto ");
							
							boolean seIngresoLetra=false;
							
								
									if (!seIngresoLetra){
									try{
										letra = sc.next().charAt(0);
										esLetra = new EsLetra(letra);
										letraIngresada = String.valueOf(letra);
										eleLetra = new EleccionLetra(letraIngresada);
										seIngresoLetra=true;
									}catch (EsLetraException e1){
						            	System.out.println("Ingrese letras");
						            	//letraIngresada = sc.nextLine();
						            	//scanner = new Scanner(System.in);
						            }catch (EleccionLetraException e){
						            	System.out.println("Debe elegir entre y/n, de acuerdo si posee encendido electronico");
						            	System.out.println("Error: "+e.getClass().getName() +": debe ingresar y/n");   
						            	//letraIngresada = sc.nextLine();
						            	//scanner = new Scanner(System.in);
						            }catch (NullPointerException e2){
						            	System.out.println("Ingrese una letra y/n");
						            }
								}
									
							
								boolean encendidoElectronico = true;
								if (letraIngresada.equalsIgnoreCase("y")){
									encendidoElectronico=true;
								}if(letraIngresada.equalsIgnoreCase("n")){
									encendidoElectronico=false;
								}
								
							System.out.println("Ingrese los datos del motor");
							System.out.println("De cuantos capacidades en litros es?");
							motorLitros = (float)sc.nextFloat();
							motor.setMotorLitros(motorLitros);
							System.out.println("De cuantas cilindradas es?");
							motorCilindradas = sc.nextInt();
							sc.nextLine();
							motor.setMotorCilindradas(motorCilindradas);
							
							Moto nuevoMoto = new Moto(vin, motor, encendidoElectronico);
							vectorMoto.addElement(nuevoMoto.toString());;
							System.out.println("se ha agregado la motocicleta con el vin:"+vin+" con "+motor+" y "+encendidoElectronico+" tiene encendido electronico");
							break;
						case 3:
							rangoMax=(vectorAuto.size()-1);
							rangoMin=0;
							System.out.println("\nLista para borrar autos");
							System.out.println("Procedemos a mostrar la lista de registrados");
							if (vectorAuto.isEmpty()){
								System.out.println("Lista vacia");
							}else{
								for (i=0; i<vectorAuto.size() ; i++){
									System.out.println(i+": "+vectorAuto.elementAt(i).toString());
								}
							}
							System.out.println("Seleccione el numero del auto a eliminar");
							
							//numeroSeleccionado=sc.nextInt();	
							try{
						        numeroSeleccionado = scanner.nextInt();	
						    }catch (java.util.InputMismatchException e2){
						    	System.out.println("Error: "+e2.getClass().getName());
						        numeroSeleccionado = -1;
						        scanner = new Scanner(System.in);
						    }
							
							try{
								esn = new ErrorSeleccionNum(numeroSeleccionado, rangoMax, rangoMin);
							}catch (ErrorSeleccionNumException e){
								System.out.println("Error al elegir numero, auto no encontrado.");
							}
							
							for (i=0; i<vectorAuto.size(); i++)
						        if (i == numeroSeleccionado){
						        	System.out.println("se ha eliminado el auto: "+vectorAuto.elementAt(i).toString());
						        	vectorAuto.remove(i);
						        }
							break;
						case 4:
							rangoMax=(vectorMoto.size()-1);
							rangoMin=0;
							System.out.println("\nLista para borrar motos");
							System.out.println("Procedemos a mostrar la lista de registrados");
							if (vectorMoto.isEmpty()){
								System.out.println("Lista vacia");
							}else{
								for (i=0; i<vectorMoto.size()  ; i++){
									System.out.println(i+": "+vectorMoto.elementAt(i).toString());
								}
							}
							System.out.println("Seleccione el numero de la moto a eliminar");
							//numeroSeleccionado=sc.nextInt();
							try{
						        numeroSeleccionado = scanner.nextInt();	
						    }catch (java.util.InputMismatchException e2){
						    	System.out.println("Error: "+e2.getClass().getName());
						        numeroSeleccionado = -1;
						        scanner = new Scanner(System.in);
						    }
							try{
								esn = new ErrorSeleccionNum(numeroSeleccionado, rangoMax, rangoMin);
							}catch (ErrorSeleccionNumException e){
								System.out.println("Error al elegir numero");
							}
							
							for (i=0; i<vectorMoto.size(); i++)
						        if (i == numeroSeleccionado){
						        		System.out.println("se ha eliminado la moto: "+vectorMoto.elementAt(i).toString());
							        	vectorMoto.remove(i);
						        }
							break;
						case 5:
							System.out.println("\nLista de autos registrados");
							if (vectorAuto.isEmpty()){
								System.out.println("Lista vacia");
							}else{
								for (i=0; i<vectorAuto.size()  ; i++){
									System.out.println(i+": "+vectorAuto.elementAt(i).toString());
								}
							}
							
							break;
						case 6:
							System.out.println("\nLista de motos registrados");
							if (vectorMoto.isEmpty()){
								System.out.println("Lista vacia");
							}else{
								for (i=0; i<vectorMoto.size()  ; i++){
									System.out.println(i+": "+vectorMoto.elementAt(i).toString());
								}
							}
							break;
						case 0:
							System.out.println("Volviendo al menu principal");
						 default:
						}
					}while (opcionIngresada != 0);
					break;
					
				case 2:
					do{
						System.out.println("\nHa ingresado al taller");
						System.out.println("1.Ingresar nuevo auto a la cola de reparacion");
						System.out.println("2.Ver la cola de reparacion");
						System.out.println("3.Comenzar la reparacion");
						System.out.println("0.Volver");
						//opcionIngresada=sc.nextInt();
			            //sc.nextLine();
			            
			            numeroSeleccionado=opcionIngresada;
			            rangoMax=menuTaller.length;
			            rangoMin=0;
			            
			            try{
			            	opcionIngresada = scanner.nextInt();	
					    }catch (java.util.InputMismatchException e2){
					    	System.out.println("Error: "+e2.getClass().getName());
					    	opcionIngresada = -1;
					        scanner = new Scanner(System.in);
					    }
			            
			            try{
							esn = new ErrorSeleccionNum(numeroSeleccionado, rangoMax, rangoMin);
						}catch (ErrorSeleccionNumException e){
							System.out.println("Error al elegir numero :"+e.getClass().getName());
						}
			            
			            switch (opcionIngresada){
			            case 1:
			            	do{
			            		System.out.println("\n1.Ingresar auto a la cola");
				            	System.out.println("2.Ingresar moto a la cola");
				            	System.out.println("0.Volver");
				            	//opcionIngresada=sc.nextInt();
					            //sc.nextLine();
					            
					            try{
					            	opcionIngresada = scanner.nextInt();	
							    }catch (java.util.InputMismatchException e2){
							    	System.out.println("Error: "+e2.getClass().getName());
							    	opcionIngresada = -1;
							        scanner = new Scanner(System.in);
							    }
					            
					            try{
					            	ele = new EleccionNumero(opcionIngresada); 
					            }catch (EleccionNumeroException ex){
					            	//ex.printStackTrace();
					            	System.out.println("Error: "+ex.getClass().getName());   
					            }
					            
				            	switch (opcionIngresada){
				            	case 1:
				            		rangoMax=(vectorAuto.size()-1);
				            		rangoMin=0;
				            		
				            		System.out.println("Procedemos a mostrar la lista de registrados");
				            		if (vectorAuto.isEmpty()){
										System.out.println("Lista vacia");
										break;
									}else{
										for (i=0; i<vectorAuto.size()  ; i++){
											System.out.println(i+": "+vectorAuto.elementAt(i).toString());
										}
									}
									System.out.println("Seleccione el numero del auto para agregar a la cola");
									numeroSeleccionado=sc.nextInt();	
									sc.nextLine();
									try{
										esn = new ErrorSeleccionNum(numeroSeleccionado, rangoMax, rangoMin);
									}catch (ErrorSeleccionNumException e){
										System.out.println("Error al elegir numero");
									}
									
									for (i=0; i<vectorAuto.size(); i++){
								        if (i == numeroSeleccionado){
								        	nodoReparacion.setDato(vectorAuto.elementAt(i));
								        	colaReparacion.enqueue(nodoReparacion.getDato());
								        } 
								        vectorAuto.remove(numeroSeleccionado);
								        }
									break;
				            	case 2:
				            		rangoMax=(vectorMoto.size()-1);
				            		rangoMin=0;
				            		
				            		System.out.println("Procedemos a mostrar la lista de registrados");
				            		if (vectorMoto.isEmpty()){
										System.out.println("Lista vacia");
										break;
									}else{
										for (i=0; i<vectorMoto.size()  ; i++){
											System.out.println(i+": "+vectorMoto.elementAt(i).toString());
										}
									}
									System.out.println("Seleccione el numero de la moto para agregar a la cola");
									numeroSeleccionado=sc.nextInt();
									sc.nextLine();
									try{
										esn = new ErrorSeleccionNum(numeroSeleccionado, rangoMax, rangoMin);
									}catch (ErrorSeleccionNumException e){
										System.out.println("Error al elegir numero");
									}
									
									for (i=0; i<vectorMoto.size(); i++){
										if (i == numeroSeleccionado){
								        	nodoReparacion.setDato(vectorMoto.elementAt(i));
								        	colaReparacion.enqueue(nodoReparacion.getDato());
								        }
										vectorMoto.remove(numeroSeleccionado);
									}
									break;
				            	case 0: 
				            		System.out.println("Volviendo al taller");
				            		default:
								    	}
			            	}while (opcionIngresada != 0);
			            	break;
			            case 2:
			            	System.out.println("\nProcedemos a mostrar la cola completa");
			            	colaReparacion.print();
			            	System.out.println("\nSe mostrara el primer vehiculo en la cola y el siguiente");
			            	try {
								System.out.println(colaReparacion.first().toString());
							} catch (EmptyQueueException e) {
									e.printStackTrace();
							}
			            	break;

			            case 3:
			            	do{
			            		rangoMax=menuReparacion.length;
			            		rangoMin=0;
			            		System.out.println("Que hace falta reparar?");
			            		System.out.println("1.Reemplazar disco de freno delantero");
			            		System.out.println("0.Salir");
								//opcionIngresada=sc.nextInt();
					            //sc.nextLine();
					            
					            try{
					            	opcionIngresada = scanner.nextInt();	
							    }catch (java.util.InputMismatchException e2){
							    	System.out.println("Error: "+e2.getClass().getName());
							    	opcionIngresada = -1;
							        scanner = new Scanner(System.in);
							    }
					            
					            try{
									esn = new ErrorSeleccionNum(numeroSeleccionado, rangoMax, rangoMin);
								}catch (ErrorSeleccionNumException e){
									System.out.println("Error al elegir numero :"+e.getClass().getName());
								}
					            
					            
					            switch (opcionIngresada){
					            case 1:	
					            	
					            	for(i=0; i<vectorRepararDisco.size();i++){
					            		System.out.println("el proximo paso sera"+vectorRepararDisco.elementAt(i));
					            		System.out.println("Desea hacer algo antes?");
					            		
					            		nodoRepararDisco.setDato(vectorRepararDisco.elementAt(i));
						        		repararDisco.push(nodoRepararDisco.getDato());
					        		}
					            	repararDisco.arriba();
					        		vectorRepararDisco.addElement(SoporterepararDisco.toString());
					        		
					        		
					        		
					        		
					        		
					            	
					            	
					            	
					            	for (i=0; i<vectorRepararDisco.size(); i++){
					            		
					            		nodoRepararDisco.setDato(vectorRepararDisco.elementAt(i));
					            		
					            		repararDisco.push(nodoRepararDisco.getDato());
					            		
					            		repararDisco.cima();
					            		
					            		SoporteMecanico soporte = new SoporteMecanico();
					            		System.out.println("Hara algo extra despues de esta accion?");
					            		accion = sc.nextLine();
					            		soporte.setAccion(accion);
					            		vectorRepararDisco.setElementAt(accion, i+1);;
					            		
					            		
					            	}
					            	nodoReparacion.setDato(vectorAuto.elementAt(i));
						        	colaReparacion.enqueue(nodoReparacion.getDato());
					            	nodoRepararDisco.setDato("levantar la tapa");
					            	repararDisco.push(nodoRepararDisco.getDato());

						            break;	
					            case 0:
					            	System.out.println("Volviendo al Taller");
					            	break;
					            }
			            		break;
			            	}while (opcionIngresada != 0);
			            	break;
			            case 0:
			            	System.out.println("Se volvera al menu");
			            	break;
			            }
					}while(opcionIngresada != 0);
					break;
					
				case 3:
					System.out.println("\nHa seleccionado terminar");
					break;
				default:
					break;
			}    
            
		}while (opcionIngresada != 2);
	}
    }
    


