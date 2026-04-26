package nivel_inicial;

import java.util.Scanner;

public class modelo_prueba {
	public static void main(String[] args) {
		int casilleros[][] = new int[5][8];		
		Scanner a = new Scanner (System.in);
		int op;
		for (int i = 0; i< 5; i++) {		    
		    for (int j = 0; j < 8 ; j++) {
		    	casilleros[i][j] = 0;

		    }
		}
		
		
		do {
			System.out.println("1) Ver estado de lockers");
			System.out.println("2) Alquilar locker");
			System.out.println("3) Liberar locker");
			System.out.println("4) Estadísticas rápidas");
			System.out.println("5) sALIR");
			op = a.nextInt();
			switch (op) {
			case 1:
				inicializarGimnasio(a, casilleros);
				mostrarMapa(casilleros);

				break;
			
			case 2:
				procesarSeleccion(a, casilleros);
				break;
		
			case 3: 
				eliminar(casilleros, a);
				break;
			}
		} while (op !=5);
		
	}
	
	public static void inicializarGimnasio(Scanner a, int casilleros[][]) {
		System.out.println("  1 2 3 4 5 6 7 8");
		
		
			for(int i = 0; i < 5; i++ ) {
				System.out.print((char) ('A'+ i) + " ");
				
				for(int j =0;j < 8; j++) {
					System.out.print(casilleros[i][j] + " ");
					
				}

		        System.out.println();
			}
		
	}
	
	public static void mostrarMapa(int casilleros[][]) {	
		System.out.println("  1 2 3 4 5 6 7 8");

		for(int i = 0; i < 5; i++ ) {	
			System.out.print((char) ('A'+ i) + " ");

			for(int j =0;j < 8; j++) {
				 if( casilleros[i][j] == 0) {
					 System.out.print("L ");
				 }else {
					 System.out.print("X ");

				 }
			}

	        System.out.println();
		}
		
		
	}
	
	public static void procesarSeleccion(Scanner a, int casilleros[][]) {
		
		System.out.println("Que casillero desea reservar: ");
		String buscar = a.next().toUpperCase();
		char filaChar = buscar.charAt(0); // 'A'
		int columna = Integer.parseInt(buscar.substring(1)); // 1
		
		int fila = filaChar - 'A';   // 'A' → 0
		int col = columna - 1;       // 1 → 0
		
		
		if(fila >= 0 && fila <5 && col >=0 && col < 8 ) {
			if(casilleros[fila][col] == 0) {
				casilleros[fila][col] = 1;
				System.out.println("Se reservo ");
			}else {
				System.out.println("El casillero ya esta reservado");
			}
		}else {
			System.out.println("El loquer no existe");
		}

	}
	
	public static void eliminar(int casilleros[][], Scanner a) {
		System.out.println("Que casillero desea desreservar: ");
		String buscar = a.next().toUpperCase();
		char filaChar = buscar.charAt(0); // 'A'
		int columna = Integer.parseInt(buscar.substring(1)); // 1
		
		int fila = filaChar - 'A';   // 'A' → 0
		int col = columna - 1;       // 1 → 0
		
		
		if(fila >= 0 && fila <5 && col >=0 && col < 8 ) {
			if(casilleros[fila][col] == 1) {
				casilleros[fila][col] = 0;
				System.out.println("Se desreservo ");
			}else {
				System.out.println("El casillero ya estaba");
			}
		}else {
			System.out.println("El loquer no existe");
		}

	}
	
}
