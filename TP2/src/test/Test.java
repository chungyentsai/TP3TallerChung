package test;

import estructuras.Nodo;
import estructuras.cola.Cola;
import estructuras.pila.Pila;
import modelos.Moto;
import modelos.Motor;
import modelos.Auto;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;

import excepciones.EleccionNumero;
import excepciones.EleccionNumeroException;
import excepciones.ErrorSeleccionNum;
import excepciones.ErrorSeleccionNumException;
import excepciones.EleccionLetra;
import excepciones.EleccionLetraException;
import excepciones.LinkedListEmptyException;


public class Test {

    public static void main(String[] args) {
        
		Scanner sc = new Scanner(System.in);
		int opcionIngresada;
		String opcionIngresadaS ="";
		int numero;
		int i;
		int numeroSeleccionado;
		float litros;
		float cilindrada;
		String vin;
		float motorLitros;
		int motorCilindradas;
		EleccionNumero ele;
        ErrorSeleccionNum esn;        
                
        int []menu2= new int[6];       
                
		Vector vectorAuto = new Vector();
		Vector vectorMoto = new Vector();
		Motor motor = new Motor();
		
		int rangoMax;
		int rangoMin;
		
		
		
		
		Nodo nodoReparacion = new Nodo();
		Nodo nodomoto = new Nodo();
		Cola colaReparacion = new Cola();
		Pila repararMotor = new Pila();
		Nodo nodoRepararMotor = new Nodo();
		Pila autoRepararMotor = new Pila();
		
		
		
		System.out.println("Bienvenido");	
		do{
			System.out.println("1.Operar");
			System.out.println("2.Taller");
            System.out.println("0.Salir");
            opcionIngresadaS=sc.nextLine();
            //opcionIngresada=sc.nextInt();
            //sc.nextLine();
            opcionIngresada = Integer.parseInt(opcionIngresadaS);   
            
            try{
            	//ele = new EleccionNumero(opcionIngresada);  
            	opcionIngresada = Integer.parseInt(opcionIngresadaS);
            }catch (NumberFormatException e){
            	System.out.println("Error: "+e.getClass().getName());
            }
            try{
            	ele = new EleccionNumero(opcionIngresada); 
            }catch (EleccionNumeroException ex){
            	//ex.printStackTrace();
            	System.out.println("Error: "+ex.getClass().getName());   
            }

            switch (opcionIngresada) {
				case 1:
					do{
						System.out.println("\nHa seleccionado Operar");
						System.out.println("1.Registrar auto");
						System.out.println("2.Registrar moto");
						System.out.println("3.Borrar auto registrado");
						System.out.println("4.Borrar moto registrado");
						System.out.println("5.Listar auto");
						System.out.println("6.Listar moto");
						System.out.println("0.Volver");
						opcionIngresada=sc.nextInt();   
			            sc.nextLine();
			            
			            numeroSeleccionado=opcionIngresada;
			            rangoMax=menu2.length;
			            rangoMin=0;
			            
			            try{
							esn = new ErrorSeleccionNum(numeroSeleccionado, rangoMax, rangoMin);
						}catch (ErrorSeleccionNumException e){
							System.out.println("Error al elegir numero :"+e.getClass().getName());
						}

			            
			            switch (opcionIngresada) {
						case 1:
							System.out.println("Ingrese el vin del auto");
							vin = sc.nextLine();
							System.out.println("Escriba Si/No de acuerdo si posee airbags el auto ");
							String airbags = sc.nextLine();
							System.out.println("Ingrese los datos del motor");
							System.out.println("De cuantos capacidades en litros es?");
							motorLitros = (float)sc.nextFloat();
							motor.setMotorLitros(motorLitros);
							System.out.println("De cuantas cilindradas es?");
							motorCilindradas = sc.nextInt();
							motor.setMotorCilindradas(motorCilindradas);

							Auto nuevoAuto = new Auto(vin, motor, airbags);
							vectorAuto.addElement(nuevoAuto.toString());
							System.out.println("se ha agregado el automovil con el vin:"+vin+" con un "+motor+" y "+airbags+" contiene airbags");
							break;
						case 2:
							System.out.println("Ingrese el vin de la moto");
							vin = sc.nextLine();
							System.out.println("Escriba Si/No de acuerdo si posee encendido electronico la moto ");
							String encendidoElectronico = sc.nextLine();
							System.out.println("Ingrese los datos del motor");
							System.out.println("De cuantos capacidades en litros es?");
							motorLitros = (float)sc.nextFloat();
							motor.setMotorLitros(motorLitros);
							System.out.println("De cuantas cilindradas es?");
							motorCilindradas = sc.nextInt();
							motor.setMotorCilindradas(motorCilindradas);
							
							Moto nuevoMoto = new Moto(vin, motor, encendidoElectronico);
							vectorMoto.addElement(nuevoMoto);;
							System.out.println("se ha agregado la motocicleta con el vin:"+vin+" con "+motor+" y "+encendidoElectronico+" tiene encendido electronico");
							break;
						case 3:
							rangoMax=vectorAuto.size();
							rangoMin=0;
							System.out.println("Lista para borrar autos");
							System.out.println("Procedemos a mostrar la lista de registrados");
							for (i=0; i<vectorAuto.size() ; i++){
								System.out.println(i+": "+vectorAuto.elementAt(i).toString());
							}
							System.out.println("Seleccione el numero del auto a eliminar");
							numeroSeleccionado=sc.nextInt();	
							
							try{
								esn = new ErrorSeleccionNum(numeroSeleccionado, rangoMax, rangoMin);
							}catch (ErrorSeleccionNumException e){
								System.out.println("Error al elegir numero");
							}
							
							for (i=0; i<vectorAuto.size(); i++)
						        if (i == numeroSeleccionado){
						        	System.out.println("se ha eliminado el auto: "+vectorAuto.elementAt(i).toString());
						        	vectorAuto.removeElement(i);
						        }
							break;
						case 4:
							rangoMax=vectorMoto.size();
							rangoMin=0;
							System.out.println("Lista para borrar motos");
							System.out.println("Procedemos a mostrar la lista de registrados");
							for (i=0; i<vectorMoto.size()  ; i++){
								System.out.println(i+": "+vectorMoto.elementAt(i).toString());
							}
							System.out.println("Seleccione el numero de la moto a eliminar");
							numeroSeleccionado=sc.nextInt();
							
							try{
								esn = new ErrorSeleccionNum(numeroSeleccionado, rangoMax, rangoMin);
							}catch (ErrorSeleccionNumException e){
								System.out.println("Error al elegir numero");
							}
							
							for (i=0; i<vectorMoto.size(); i++)
						        if (i == numeroSeleccionado){
						        		System.out.println("se ha eliminado la moto: "+vectorMoto.elementAt(i).toString());
							        	vectorMoto.removeElement(i);
						        }
							break;
						case 5:
							System.out.println("Lista de autos registrados");
							if (vectorAuto.isEmpty()){
								System.out.println("Lista vacia");
							}else{
								for (i=0; i<vectorAuto.size()  ; i++){
									System.out.println(i+": "+vectorAuto.elementAt(i).toString());
								}
							}
							
							break;
						case 6:
							System.out.println("Lista de motos registrados");
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
						System.out.println("Ha ingresado al taller");
						System.out.println("1.Ingresar nuevo auto a la cola de reparacion");
						System.out.println("2.Ver la cola de reparacion");
						System.out.println("3.Comenzar la reparacion");
						System.out.println("0.Volver");
						opcionIngresada=sc.nextInt();
			            sc.nextLine();
			            
			            switch (opcionIngresada){
			            case 1:
			            	do{
			            		System.out.println("1.Ingresar auto a la cola");
				            	System.out.println("2.Ingresar moto a la cola");
				            	System.out.println("0.Volver");
				            	opcionIngresada=sc.nextInt();
					            sc.nextLine();
				            	switch ( opcionIngresada){
				            	case 1:
				            		rangoMax=vectorAuto.size();
				            		rangoMin=0;
				            		System.out.println("Procedemos a mostrar la lista de registrados");
				            		if (vectorAuto.isEmpty()){
										System.out.println("Lista vacia");
									}else{
										for (i=0; (vectorAuto.elementAt(i)!=null) ; i++){
											System.out.println(i+": "+vectorAuto.elementAt(i).toString());
										}
									}
									System.out.println("Seleccione el numero del auto para agregar a la cola");
									numeroSeleccionado=sc.nextInt();	
									
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
								        }
									break;
				            	case 2:
				            		rangoMax=vectorAuto.size();
				            		rangoMin=0;
				            		System.out.println("Procedemos a mostrar la lista de registrados");
				            		if (vectorMoto.isEmpty()){
										System.out.println("Lista vacia");
									}else{
										for (i=0; (vectorMoto.elementAt(i)!=null) ; i++){
											System.out.println(i+": "+vectorMoto.elementAt(i).toString());
										}
									}
									System.out.println("Seleccione el numero de la moto para agregar a la cola");
									numeroSeleccionado=sc.nextInt();
									for (i=0; i<vectorMoto.size(); i++)
								        if (i == numeroSeleccionado){
								        	nodoReparacion.setDato(vectorMoto.elementAt(i));
								        	colaReparacion.enqueue(nodoReparacion.getDato());
								        }  
									break;
								        }
			            	}while (opcionIngresada != 0);
			            case 2:
			            	System.out.println("Procedemos a mostrar la cola");
			            	
			            	colaReparacion.print();
			            	
			            	break;
			            case 3:
			            	do{
			            		System.out.println("Que hace falta reparar?");
			            		System.out.println("1.Motor");
			            		System.out.println("2.Reemplazar disco de freno delantero");
			            		System.out.println("");
			            		System.out.println("");
			            		System.out.println("");
								opcionIngresada=sc.nextInt();
					            sc.nextLine();
					            switch (opcionIngresada){
					            case 1:
					            	System.out.println("Desea leer las instrucciones?");
					            	System.out.println("1.Si");
					            	System.out.println("2.No");
					            	opcionIngresada=sc.nextInt();
						            sc.nextLine();
						            
					            	if (opcionIngresada==1){
					            		autoRepararMotor.push("Sacar el motor");
					            		try {
											autoRepararMotor.pop();
										} catch (LinkedListEmptyException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
					            		System.out.println("Apriete enter para seguir");
					            		sc.nextLine();
					            		autoRepararMotor.push("Reparar motor");
					            		try {
											autoRepararMotor.pop();
										} catch (LinkedListEmptyException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
					            		System.out.println("Apriete enter para seguir");
					            		sc.nextLine();
					            		autoRepararMotor.push("Limpiar el motor");
					            		try {
											autoRepararMotor.pop();
										} catch (LinkedListEmptyException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
					            		System.out.println("Apriete enter para seguir");
					            		sc.nextLine();
					            		
					            	}else{
					            		
					            	}
					            	break;
					            case 2:
					            	
					            	break;
					            case 3:
	
					            	break;
					            case 4:
	
					            	break;
					            }
			            		
			            	}while (opcionIngresada != 0);
			            	
			            	
			            	break;
			            case 4:
			            	System.out.println("Procedemos a mostrar la cola");
			            	break;
			            case 5:
			            	System.out.println("Procedemos a mostrar la cola");
			            	break;
			            }
			            
						break;
					}while(opcionIngresada != 0);
					
					
				case 3:
					System.out.println("\nHa seleccionado terminar");
					break;
				default:
					break;
			}    
            
		}while (opcionIngresada != 2);
	}
    }
    


