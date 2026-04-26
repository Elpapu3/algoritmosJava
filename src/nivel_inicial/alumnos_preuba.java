package nivel_inicial;

import java.util.Scanner;

public class alumnos_preuba {

	public static void main(String[] args) {
	 final int cantidad_maxima = 100;
	int op = 0;
	int cantidadAlumnos=0;
	Datos[] Datos = new Datos[cantidad_maxima];
	String[][] alumnos = new String[cantidad_maxima][5];
    Scanner s = new Scanner(System.in);

	do {
		
	} while (op!=7);
	
	
}
	private static int menu(Scanner a) {
		int op = 0;
		System.out.println("1)Agregar alumno");
		System.out.println("2)Eliminar alumno");
		System.out.println("3)Consultar alumno por ID");
		System.out.println("4)Calcular promedio de un alumno");
		System.out.println("5)Mostrar todos los alumnos");
		System.out.println("6)Mostrar alumnos aprobados (promedio ≥ 6");
		System.out.println("7) salir");

		
		return op;
		
	}
	private static int leerEntero(Scanner s) {
	    int numero = 0;
	    boolean valido = false;

	    while (!valido) {
	        try {
	            numero = s.nextInt();
	            valido = true; // si entra acá, es correcto
	        } catch (Exception e) {
	            System.out.println("ERROR: Ingrese un número válido");
	            s.next(); // descarta lo incorrecto
	        }
	    }

	    return numero;
	}
}


