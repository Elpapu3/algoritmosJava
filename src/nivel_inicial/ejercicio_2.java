package nivel_inicial;

import java.util.Scanner;

public class ejercicio_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.Scanner guardado = new Scanner(System.in); // basicamente crea un lector para el teclado 
		
		System.out.println("Ingrese tu nombre y apellido: ");
		String nombre = guardado.nextLine();
		
		System.out.println("tu nombre y apellido es: " + nombre);
	}

}
