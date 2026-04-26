package nivel_inicial;

import java.util.Scanner;

public class ejercico10practicapreuba {

	public static void main(String[] args) {
		/*Crear un programa que permita reservar asientos de una sala de cine (8 filas x 20
columnas). La posición de cada asiento se definirá con una letra (A-H) para la fila y
un número (1-20) para la columna. El programa deberá visualizar que sitios están
disponibles para que el cliente pueda decidir donde sentarse. Antes de hacer la
reserva, el programa deberá comprobar que el asiento está libre, en caso
contrario devolverá un mensaje de error.*/
		Scanner s = new Scanner(System.in);
		String[][] sillasCine= new String[8][20];
		int cantidadSillas = 0;
		
		int ops=0;
			
		do {
			ops = menu(s);
			cantidadSillas =  accion(s, ops, cantidadSillas, sillasCine);
		} while (ops!=3);
		
		
	}
	private static int menu (Scanner s) {
		int ops;
		System.out.println("Ingresar reserva: ");
		System.out.println("Visualizar asientos: ");
		ops = LeerEntero(s);
		
		return ops;
		
	}
	private static int accion(Scanner s, int ops, int cantidadSillas, String[][] sillasCine) {
		switch (ops) {
		case 1:
			
			break;

		}
		
		
		return cantidadSillas;
		
	}
	
	private static int LeerEntero(Scanner s) {
		int num;
		while (true) {
			try {
				num = s.nextInt();
			} catch (Exception e) {
				System.out.println("Ingrese un caracter valido: ");
				s.nextLine();
			}
		}
		
	}

}
