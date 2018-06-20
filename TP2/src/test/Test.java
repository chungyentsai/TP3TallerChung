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
import excepciones.EsNumeroDecimal;
import excepciones.EsNumeroEntero;
import excepciones.EsNumeroException;
import excepciones.EleccionLetra;
import excepciones.EleccionLetraException;
import excepciones.LinkedListEmptyException;


public class Test {

    public static void main(String[] args) throws LinkedListEmptyException{
        
		Scanner sc = new Scanner(System.in);
		Scanner scanner = new Scanner(System.in);
		int opcionIngresada=-1;
		int numero;
		int i=0;
		String letraIngresada = " ";
		boolean repetir = true;
		char letra = ' ';
		int numeroSeleccionado;
		String vin;
		float decimal = 0;
		float motorLitros;
		int motorCilindradas;
		int contador=0;
		
		EleccionNumero ele;
        ErrorSeleccionNum esn;        
        EleccionLetra eleLetra;
        EsLetra esLetra;
        EsNumeroEntero esNumEntero;
        EsNumeroDecimal esNumDecimal;
        
        
        int rangoMax;
		int rangoMin;
        
        int []menu2= new int[6];       
        int []menuTaller= new int[3];
        int []menuMostrarCola = new int[2];
        int []menuReparacion = new int[2];
        
		Vector vectorAuto = new Vector(1,1);
		Vector vectorMoto = new Vector(1,1);
		Motor motor = new Motor();
		
		
		
		Nodo nodoReparacion = new Nodo();
		Cola colaReparacion = new Cola();

		Nodo nodoRepararDisco = new Nodo();
		Pila repararDisco = new Pila();
		SoporteMecanico soporteRepararDisco = new SoporteMecanico();
		String accion= " ";
		
		Vector vectorRepararDisco = new Vector(1,1);
		vectorRepararDisco.addElement("Quitar bulones");
		vectorRepararDisco.addElement("Remover rueda");
		vectorRepararDisco.addElement("Quitar caliper de freno");
		vectorRepararDisco.addElement("Remover disco de freno");
		vectorRepararDisco.addElement("Reemplazar disco de freno");

		
		
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
							
							repetir = true;
							while(repetir){
							try{
								System.out.println("Ingrese y/n de acuerdo si posee airbags el auto");
								letraIngresada=sc.nextLine();
								eleLetra = new EleccionLetra(letraIngresada);
								repetir=false;
							}catch (EleccionLetraException e){
								System.out.println("Se ingreso mal");	
							}
							}
							
							boolean airbags = true;
							if (letraIngresada.equalsIgnoreCase("y")){
								airbags=true;
							}if(letraIngresada.equalsIgnoreCase("n")){
								airbags=false;
							}
							
							System.out.println("Ingrese los datos del motor");
							
							repetir = true;
							while(repetir){
							try{
								System.out.println("De cuantos capacidades en litros es?");
								decimal = (float)scanner.nextFloat();
								esNumDecimal = new EsNumeroDecimal(decimal);
								repetir = false;
				            }catch (EsNumeroException e){
				            	System.out.println("Error: "+e.getClass().getName());
				            }catch (InputMismatchException e2){
				            	System.out.println("Error: "+e2.getClass().getName());
				            	decimal = 0;
				            	scanner = new Scanner(System.in);
				            }
							}
							
							motorLitros=decimal;
							motor.setMotorLitros(motorLitros);
							
							repetir = true;
							while(repetir){
								try{
									System.out.println("De cuantas cilindradas es?");
									i = scanner.nextInt();
									esNumEntero = new EsNumeroEntero(i);
									repetir = false;
					            }catch (InputMismatchException e2){
					            	System.out.println("Error: "+e2.getClass().getName());
					            	i = 0;
					            	scanner = new Scanner(System.in);
					            }catch (EsNumeroException e){
					            	System.out.println("Error: "+e.getClass().getName());
					            }
								}
							
							motorCilindradas = i;
							motor.setMotorCilindradas(motorCilindradas);

							Auto nuevoAuto = new Auto(vin, motor, airbags);
							vectorAuto.addElement(nuevoAuto.toString());
							System.out.println("se ha agregado el automovil con el vin:"+vin+" con un "+motor+" y "+airbags+" contiene airbags");
							break;
						case 2:	
							System.out.println("\nIngrese el vin de la moto");
							vin = sc.nextLine();

							repetir = true;
							while(repetir){
							try{
								System.out.println("Ingrese y/n de acuerdo si posee encendido electronico la moto");
								letraIngresada=sc.nextLine();
								eleLetra = new EleccionLetra(letraIngresada);
								repetir=false;
							}catch (EleccionLetraException e){
								System.out.println("Se ingreso mal");	
							}
							}
							
							boolean encendidoElectronico = true;
							if (letraIngresada.equalsIgnoreCase("y")){
								encendidoElectronico=true;
							}if(letraIngresada.equalsIgnoreCase("n")){
								encendidoElectronico=false;
							}
								
							System.out.println("Ingrese los datos del motor");
							
							repetir = true;
							while(repetir){
							try{
								System.out.println("De cuantos capacidades en litros es?");
								decimal = (float)scanner.nextFloat();
								//sc.nextLine();
								esNumDecimal = new EsNumeroDecimal(decimal);
								repetir = false;
				            }catch (EsNumeroException e){
				            	System.out.println("Error: "+e.getClass().getName());
				            }catch (InputMismatchException e2){
				            	System.out.println("Error: "+e2.getClass().getName());
				            	decimal = 0;
				            	scanner = new Scanner(System.in);
				            }
							}
							
							motorLitros=decimal;
							motor.setMotorLitros(motorLitros);
							
							repetir = true;
							while(repetir){
								try{
									System.out.println("De cuantas cilindradas es?");
									i = scanner.nextInt();
									esNumEntero = new EsNumeroEntero(i);
									repetir = false;
					            }catch (InputMismatchException e2){
					            	System.out.println("Error: "+e2.getClass().getName());
					            	i = 0;
					            	scanner = new Scanner(System.in);
					            }catch (EsNumeroException e){
					            	System.out.println("Error: "+e.getClass().getName());
					            }
								}
							
							motorCilindradas = i;
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
								System.out.println("Error al elegir numero, auto no encontrado, se volvera al menu anterior");
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
								System.out.println("Error al elegir numero, moto no encontrado, se volvera al menu anterior");
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
									
									repetir = true;
									while(repetir){
										try{
											System.out.println("Seleccione el numero del auto para agregar a la cola");
											numeroSeleccionado = scanner.nextInt();	
									        esn = new ErrorSeleccionNum(numeroSeleccionado, rangoMax, rangoMin);
									        repetir=false;
									    }catch (java.util.InputMismatchException e2){
									    	System.out.println("Error: "+e2.getClass().getName());
									    	numeroSeleccionado = -1;
									        scanner = new Scanner(System.in);
									    }catch (ErrorSeleccionNumException e){
											System.out.println("Error al elegir numero");
										}
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
									
									repetir = true;
									while(repetir){
										try{
											System.out.println("Seleccione el numero de la moto para agregar a la cola");
											numeroSeleccionado = scanner.nextInt();	
									        esn = new ErrorSeleccionNum(numeroSeleccionado, rangoMax, rangoMin);
									        repetir=false;
									    }catch (java.util.InputMismatchException e2){
									    	System.out.println("Error: "+e2.getClass().getName());
									    	numeroSeleccionado = -1;
									        scanner = new Scanner(System.in);
									    }catch (ErrorSeleccionNumException e){
											System.out.println("Error al elegir numero");
										}
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
								System.out.println(colaReparacion.first());
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
					            		System.out.println("el proximo paso sera: "+vectorRepararDisco.elementAt(i));
					            		
					            		repetir = true;
										while(repetir){
										try{
											System.out.println("Desea hacer algo antes? y/n");
											letraIngresada=sc.nextLine();
											eleLetra = new EleccionLetra(letraIngresada);
											repetir=false;
										}catch (EleccionLetraException e){
											System.out.println("Se ingreso mal");	
										}
										}
										
										//boolean choose = true;
										if (letraIngresada.equalsIgnoreCase("y")){
											//choose=true;
											System.out.println("Escriba a continuacion lo que hara antes");
											accion = sc.nextLine();
											vectorRepararDisco.insertElementAt(accion, i);
											
											soporteRepararDisco.setAccion(accion);
											nodoRepararDisco.setDato(soporteRepararDisco.getAccion());
							        		repararDisco.push(nodoRepararDisco.getDato());
										}if(letraIngresada.equalsIgnoreCase("n")){
											//choose=false;
					            		nodoRepararDisco.setDato(vectorRepararDisco.elementAt(i));
						        		repararDisco.push(nodoRepararDisco.getDato());
						        		
					        		}
										
										System.out.println("Acaba de hacer: " +repararDisco.cima());
										
										contador++;
										System.out.println(contador);
					            	}	

					            	System.out.println("Se ha hecho: "+vectorRepararDisco.toString()+" para reparar los discos de freno");

					            	System.out.println("a continuacion tendra que armar todo de vuelta");
					            	
					            	
					            	for (i=0; i<vectorRepararDisco.size(); i++){
					            		System.out.println("Usted debe: "+repararDisco.pop());
					            		System.out.println("Presione enter para seguir");
					            		sc.nextLine();
					            	}

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
					
				case 0:
					System.out.println("\nHa seleccionado terminar");
					break;
				default:
					break;
			}    
            
		}while (opcionIngresada != 0);
	}
    }
    


