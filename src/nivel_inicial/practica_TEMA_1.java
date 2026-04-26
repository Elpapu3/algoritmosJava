package nivel_inicial;

import java.util.Scanner;

public class practica_TEMA_1 {

    public static void main(String[] args) {
        int op;
        Scanner a = new Scanner(System.in);

        // Array donde se guardan las acciones
        Accion[] acciones = new Accion[10];
        int pos = 0; // posición para guardar nuevas acciones

        do {
            System.out.println("1) Agregar una nueva acción");
            System.out.println("2) Eliminar una acción por ID");
            System.out.println("3) Actualizar valor actual de una acción (buscar por ID)");
            System.out.println("4) Consultar información de una acción por ID");
            System.out.println("7) Salir");

            op = a.nextInt();

            switch (op) {

                case 1:
                    // Verificamos que no se pase del límite del array
                    if (pos < acciones.length) {
                        acciones[pos] = ingresarAccion(a);
                        pos++;
                    } else {
                        System.out.println("No hay más espacio para guardar acciones");
                    }
                    break;

                case 2:
                    eliminarAccion(a, acciones);
                    break;
                case 3: 
                	actualizarPrecioAccion(a, acciones);
                	break;
                	
                case 4:
                	consultarAccion(a, acciones);
                	break;
                	
                case 5:
                	calcularGananciaPerdida(a, acciones);
                	
                	break;
                	
                case 7:
                	System.out.println("SALIO DEL MENU");
                	break;
            }

        } while (op != 7);

        a.close();
    }

    // Método para ingresar una nueva acción
    public static Accion ingresarAccion(Scanner a) {

        Accion acc = new Accion(); // creo la acción

        System.out.println("Ingrese el ID de la acción: ");
        acc.id = eror(a);

        // Limpiamos el buffer antes de leer String
        a.nextLine();

        System.out.println("Ingrese nombre de la empresa: ");
        acc.empresa = a.nextLine();

        System.out.println("Ingrese valor actual de la acción: ");
        acc.valor = a.nextInt();

        System.out.println("Ingrese precio con el que se compró la acción: ");
        acc.valorcompra = a.nextInt();

        System.out.println("Ingrese la cantidad de acciones compradas: ");
        acc.cantidad = a.nextInt();



        return acc; // devolvemos la acción creada
    }

    // Método para eliminar una acción por ID
    public static void eliminarAccion(Scanner a, Accion[] acciones) {

        System.out.println("Ingrese el ID a eliminar: ");
        int buscar = eror(a);
        boolean encontrado = false;

        for (int i = 0; i < acciones.length; i++) {

            // Verificamos que no sea null antes de acceder
            if (acciones[i] != null && acciones[i].id == buscar) {

                acciones[i] = null; // eliminamos la acción
                System.out.println("Se borró exitosamente");

                encontrado = true;
                break; // salimos del for
            }
        }

        // Si no se encontró ninguna coincidencia
        if (!encontrado) {
            System.out.println("No se encontró la acción");
        }
        
    }
    
    public static void  actualizarPrecioAccion(Scanner a, Accion[] acciones) {
    	System.out.println("INGRE EL ID DE LA ACCION A BUSCAR");
    	int buscar = eror(a);    	
    	boolean encontrar = false;
    	
    	for(int i=0; i < acciones.length; i++) {
    		if (acciones[i] != null && acciones[i].id == buscar) {
    			
    			System.out.println("Ingre el nuevo precio de la accion");
    			int actualizar = a.nextInt();
    			
    			
    			acciones[i].valor = actualizar;
    			
    			encontrar = true;
    			break;
    		}
    	}
        if (!encontrar) {
            System.out.println("No se encontró la acción");
        }
    }
    
    public static void consultarAccion(Scanner a, Accion[] acciones) {
    		System.out.println("Ingrese la id de la accion: ");
    		int buscar = eror(a);    		boolean encontrar=false;
    		for( int i = 0; i < acciones.length; i++) {
    			if(acciones[i] != null && acciones[i].id == buscar) {
    		        System.out.println("ID: " + acciones[i].id);
    		        System.out.println("Empresa: " + acciones[i].empresa);
    		        System.out.println("Valor actual: " + acciones[i].valor);
    		        System.out.println("Precio compra: " +acciones[i].valorcompra);
    		        System.out.println("Cantidad: " +acciones[i].cantidad);
    		        
    		        encontrar = true;
    		        break;
    				
    			}if(!encontrar) {
    		        System.out.println("No es encontro un chot, vuelva a intentar ");

    			}
    			
    		}
    	
    }
    
    public static void calcularGananciaPerdida(Scanner a, Accion[] acciones) {
    	System.out.println("Ingrese el id de la acciona para calcular: ");
    	int buscar = eror(a);    	
    	for( int i = 0; i < acciones.length; i++) {
    		
           
            
    		if(acciones[i] != null && acciones[i].id == buscar) {
    			 double diferencia = acciones[i].valor - acciones[i].valorcompra;
    	            double porcentaje = (diferencia / acciones[i].valorcompra) * 100;
    			 if (diferencia > 0) {
    	                System.out.println("Su ganancia es: " + diferencia);
    	                System.out.println("Su ganancia en % es: " + porcentaje + "%");
    	            } else if (diferencia < 0) {
    	                System.out.println("Su perdida es: " + diferencia);
    	                System.out.println("Su perdida en % es: " + porcentaje + "%");
    	            } else {
    	                System.out.println("No hubo ganancia ni perdida");
    	            }
    		}
    			
    			
    		
    	}
    	
    }
    public static int eror(Scanner a) {
    	
    	while(true) {
    		try {
    	         int num = a.nextInt();
    	            return num;
			} catch (Exception e) {
			}
    		
    		System.out.println("Vuelva a intentar, no ingrese letras");
    		a.next();
    	}
    }
    
}