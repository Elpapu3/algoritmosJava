package nivel_inicial;

import java.util.Iterator;
import java.util.Scanner;

public class preuva_praxticas {

	public static void main(String[] args) {

		final int cantidad_max = 100;
		int cantidadAcciones =0;
		int op=0;
		Libro[] libros = new Libro[cantidad_max];
		String[][] Datos = new String[cantidad_max][5];
        Scanner s = new Scanner(System.in);
 
        
        do {
			op = menu(s);
			cantidadAcciones = accion(s, op, Datos, cantidadAcciones, cantidad_max); // pats al macenar lo de accion en cantidaacciones
		} while (op != 7);
	}		
  
	private static int menu(Scanner s) {
		int op; 
		System.out.println("1)Agregar libro");
		System.out.println("2)Eliminar libro (buscar por ID)");
		System.out.println("3)Prestar libro");
		System.out.println("4)Devolver libro");
		System.out.println("5)Consultar libro por ID");
		System.out.println("6)Mostrar todos los libros");
		System.out.println("7)Salir");

		op = leerEntero(s);
		return op;
		
	}
	private static int accion(Scanner s, int op, String[][] Datos, int cantidadAcciones, final int cantidad_max) {
		switch (op) {
		case 1:
			if(cantidadAcciones >= cantidad_max) {
				System.out.print("LA CANTIDA EXXEDE LE TOTAL DEL ARRARY");
			}else {
				cantidadAcciones = agregarLibros(s, Datos, cantidad_max, cantidadAcciones);
			}
			break;
		case 2:
			cantidadAcciones = Eliminarlibro(s, Datos, cantidad_max, cantidadAcciones);
			break;
		
		case 3:
			cantidadAcciones = prestarLibro(s, Datos, cantidadAcciones);
			break;
			
		case 4:
			cantidadAcciones = indevolverLibro(s, Datos, cantidadAcciones);
			break;
		case 5:
			mostrarLibros(s, cantidadAcciones, Datos);
			break;
			
		case 6:
			mostrarLibrostodos(s, Datos, cantidadAcciones);
			break;
			
		case 7:
			System.out.print("SALIR");
			break;
		}

		return cantidadAcciones;

	}
	
	private static int agregarLibros(Scanner s, String[][] Datos, final int cantidad_max, int cantidadAcciones) {
		System.out.print("cUANTOS LIBROS DESEA INGRESAR: ");
		int nuevos = leerEntero(s); // remplazar para que primero me leea el entero		
		for(int i=0; i < nuevos; i++) {
			System.out.print("Ingrese el id:");
			String id = s.next();
			int pos= cantidadAcciones;

			boolean encontrar=false;
			for(int j=0; j<cantidadAcciones; j++) {
				if(Datos[j][0].equals(id)) {
					encontrar=true;
					
					break;
				}

			}
			if(encontrar) {
				System.out.println("Esa id yya esta registrada, ingrese nuevamente otra id");
			      i--; // repetir este libro
			        continue;
			}
			
			Datos[pos][0] = id; //esto porque le guarddo el id en la posicion
	        s.nextLine(); // 🔥 limpiar buffer

										
			System.out.print("Ingrese le titulo del libro: ");
			  Datos[pos][1] = s.nextLine();
			System.out.print("Ingrese el autor: ");
			  Datos[pos][2] = s.nextLine();
			System.out.print("Ingrese la cantidad de copias: ");
			  Datos[pos][3] = s.next();
			System.out.print("Ingrese la cantidad de copias disponivbles: ");
			  Datos[pos][4] = s.next();
			  cantidadAcciones++;
			
		}
		
	    return cantidadAcciones; //esto para que nos retorne tambien fuera del programa

		
		
	}
	
	private static int Eliminarlibro(Scanner a, String[][] Datos, final int cantidad_max, int cantidadAcciones) {
		System.out.print("INgre el id del libro que dese eliminar: ");
		int idEliminar = leerEntero(a);
		a.nextLine(); // Limpiamos el buffer del scanner
		int pos=-1;
		for(int i =0; i<cantidadAcciones; i++){
			if(Datos[i][0].equals(String.valueOf(idEliminar))) {
				pos =i;
				break;
			}
			
		}
		if(pos == -1) {
			System.out.println("Ingrese el id nuevamente, porque no se encontro ningun livro con ese id");
		}
		else {
		    // mover todos una posición hacia arriba
		    for(int i = pos; i < cantidadAcciones - 1; i++) { // -porque elimina una fila
		        for(int j = 0; j < 5; j++) {
		            Datos[i][j] = Datos[i + 1][j]; //copia el debajoo arriba
		        }
		    }

		    cantidadAcciones--; // solo hay dos libros, el ultimo no cienta
		    System.out.println("EL LIBRO SE LEIMINO");
		    }
		return cantidadAcciones;
		
	}
	private static int prestarLibro(Scanner a, String[][] Datos, int cantidadAcciones) {
		
		System.out.print("INgre el id del libro que desee prestarse : ");
		int idprestar = leerEntero(a);
		int pos=-1;
		
		for(int i=0; i<cantidadAcciones; i++) {
			if(Datos[i][0].equals(String.valueOf(idprestar))) {
				
				pos =i;
				break;
			}
		}
		if(pos == -1) {
			System.out.println("Ingrese el id nuevamente, porque no se encontro ningun livro con ese id");
		}else{
			int cantidadLibros= Integer.parseInt(Datos[pos][3]); 
			
			if(cantidadLibros > 0) {
				cantidadLibros--;
				
				Datos[pos][3] = String.valueOf(cantidadLibros); // convertit el int a estring 
	            
	            System.out.println("Préstamo realizado. Quedan " + cantidadLibros + " copias de: " + Datos[pos][1]);
	        } else {
	        	System.out.println("No se pueden prestar libros, hay 0 disponible");
			}
		}
		return cantidadAcciones;
		
	}
	private static int indevolverLibro(Scanner a, String[][] Datos, int cantidadAcciones) {
		
		
		System.out.print("INgre el id del libro que desee devolver : ");
		int idprestar = leerEntero(a);
		int pos=-1;
		
		for(int i=0; i<cantidadAcciones; i++) {
			if(Datos[i][0].equals(String.valueOf(idprestar))) {
				
				pos =i;
				break;
			}
		}
		if(pos == -1) {
			System.out.println("Ingrese el id nuevamente, porque no se encontro ningun libro con ese id");
		}else{
			int cantidadLibros= Integer.parseInt(Datos[pos][4]); 
			
			if(cantidadLibros > 0) {
				cantidadLibros--;
				
				Datos[pos][4] = String.valueOf(cantidadLibros); // convertit el int a estring 
	            
	            System.out.println("Se devolvio el libro de: " + Datos[pos][1]);
	        } else {
	        	System.out.println("No se pueden prestar libros, hay 0 disponible");
			}
		}
		return cantidadAcciones;		
		
	}
	private static int mostrarLibros(Scanner a, int cantidadAcciones, String[][] Datos) {
		System.out.print("Ingre el id del libro que desee consultar: ");
		int idconsultar = leerEntero(a);
		int pos =-1;
		for (int i = 0; i < Datos.length; i++) {
			if(Datos[i][0].equals(String.valueOf(idconsultar))) {
				pos =i;
				break;
			}
		}
		if(pos == -1) {
			System.out.println("El id ingresado no es valido");
		}
		else {
		 System.out.println("LOS DAOTS DE LOS LIBROS SON: ");
		 for (int i = 0; i < cantidadAcciones; i++) {
			 for (int j = 0; j < cantidadAcciones; j++) {
				 System.out.println("id del libro: " + Datos[pos][0]);
				 System.out.println("titulo del libro: " +Datos[pos][1]);
				 System.out.println("autor del libro: " + Datos[pos][2]);
				 System.out.println("copias del libro: " +Datos[pos][3]);
				 System.out.println("cipias disponible: " +Datos[pos][4]);

			}
			
		}	
		 
		}
		
		return cantidadAcciones;
		
	}
	
	private static int mostrarLibrostodos(Scanner a, String[][] Datos, int cantidadAcciones) {
		 System.out.println("LOS DAOTS DE LOS LIBROS SON: ");
		 int idconsultar = leerEntero(a);
		 for (int i = 0; i < cantidadAcciones; i++) {
			 for (int j = 0; j < cantidadAcciones; j++) {
				 System.out.println("id del libro: " + Datos[i][0]);
				 System.out.println("titulo del libro: " +Datos[i][1]);
				 System.out.println("autor del libro: " + Datos[i][2]);
				 System.out.println("copias del libro: " +Datos[i][3]);
				 System.out.println("cipias disponible: " +Datos[i][4]);
				 
				 break;

			}
			
		}	
		
		
		return cantidadAcciones;
		
		
	}
	private static int leerEntero(Scanner s) {
	    while (!s.hasNextInt()) {
	        System.out.println("ERROR: Ingrese un número válido");
	        s.next(); // descarta lo incorrecto
	    }
	    return s.nextInt();
	}
	
}
