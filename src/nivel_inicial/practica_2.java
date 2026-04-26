package nivel_inicial;

import java.util.Scanner;

public class practica_2 {

	public static void main(String[] args) {
		int id[] = new int[100];
		String nombre[] = new String[100];
		double precioActual[] = new double[100];
		double preciodeCompra[] = new double[100];
		int cantidad[] = new int[100];
		
		Scanner a = new Scanner(System.in);
		int op; 
		
		int contador = 0;

		do {
			System.out.println("1)Agregar nueva criptomoneda");
			op = a.nextInt();
			
			switch (op) {
			case 1:
				contador = ingresarCripto(a, id, contador, nombre, precioActual, preciodeCompra, cantidad);
				break;
				
			case 2:
				 eliminarCripto(a, id, contador, nombre, precioActual, preciodeCompra, cantidad);
				break;
			}
			
		} while (op != 8);
		
		
		
	}
	
	public static int ingresarCripto(Scanner a, int id[], int contador, String nombre[],double precioActual[], double preciodeCompra[], int cantidad[]) {
		System.out.println("Ingrese el id de la nueva accion: ");
	    int nuevoId = a.nextInt();
	    boolean encontrar = false;
	    
	    for(int i = 0; i < contador; i++) {
	        if(id[i] == nuevoId) {
	            encontrar = true;
	            break;
	        }
	    }
	    
	    if(encontrar) {
	        System.out.println("El ID ya existe, intentalo nuevamente");
	        return contador;

	    } 
	    int pos = contador;

	    id[pos] = nuevoId;

	        
	        System.out.println("Ingrese su nombre: ");
	        a.nextLine(); // limpiar buffer

	        nombre[pos] = a.nextLine();
	        System.out.println("Ingrese su precio actual: ");
	        precioActual[pos] = a.nextDouble();
	        System.out.println("Ingrese u precio de compra:  ");
	        preciodeCompra[pos] = a.nextDouble();
	        System.out.println("Ingrese la cantidad d estas acciones: ");
	        cantidad[pos] = a.nextInt();
	        contador++;
	    
	    return contador;


	} 
	public static int eliminarCripto(Scanner a, int id[], int contador, 
			String nombre[], double precioActual[], double preciodeCompra[], int cantidad[]) {

			    System.out.println("Ingrese el id que desea eliminar: ");
			    int eliminarId = a.nextInt();

			    int pos = -1;

			    // Buscar posición
			    for (int i = 0; i < contador; i++) {
			        if (id[i] == eliminarId) {
			            pos = i;
			            break;
			        }
			    }

			    if (pos == -1) {
			        System.out.println("El ID ingresado no existe");
			        return contador;
			    }

			    // Correr los elementos hacia atrás
			    for (int i = pos; i < contador - 1; i++) {
			        id[i] = id[i + 1];
			        nombre[i] = nombre[i + 1];
			        precioActual[i] = precioActual[i + 1];
			        preciodeCompra[i] = preciodeCompra[i + 1];
			        cantidad[i] = cantidad[i + 1];
			    }

			    System.out.println("Cripto eliminada correctamente");

			    return contador - 1; // importante actualizar contador
			}

}
