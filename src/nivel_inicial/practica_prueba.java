package nivel_inicial;

import java.util.Scanner;

public class practica_prueba {

	public static void main(String[] args) {
		char[][] asientos;
		asientos = new char[10][6];

        Scanner a = new Scanner(System.in);
		int op;
		
		for (int i = 0; i < 10; i++) {		    
		    for (int j = 0; j < 6; j++) {
		    	asientos[i][j] = 'L';
		    }
		}
		do {
			System.out.println("1) Mostrar asientos");
			System.out.println("2) Reservar asiento");
			System.out.println("3) Cancelar reserva");
			System.out.println("4) salir");
			
            op = a.nextInt();

			
			switch (op) {
			case 1:
				System.out.println("  1 2 3 4 5 6");
				for (int i = 0; i < 10; i++) {
				    System.out.print((char)('A' + i) + " ");
				    
				    for (int j = 0; j < 6; j++) {
				        System.out.print(asientos[i][j] + " ");
				    }
				    
				    System.out.println();
				}
				
				break;
			case 2:
			    try {
			        System.out.println("Que asiento desea reservar: ");
			        String asiento = a.next();

			        char fl = asiento.toUpperCase().charAt(0);
			        int c = Character.getNumericValue(asiento.charAt(1)) - 1;
			        int f = fl - 'A';

			        if (f >= 0 && f < 10 && c >= 0 && c < 6) {

			            if (asientos[f][c] == 'L') {
			                asientos[f][c] = 'O';
			                System.out.println("Asiento reservado correctamente");
			            } else {
			                System.out.println("Ese asiento ya está ocupado");
			            }

			        } else {
			            System.out.println("Ese asiento no existe");
			        }

			    } catch (Exception e) {
			        System.out.println("Ingrese bien el asiento (ej: A1)");
			    }
			    break;
			
			case 3:
			try {
				System.out.println("Que asiento desea quitar de reserva: ");
				String AsientoNo = a.next();
		        char fl = AsientoNo.toUpperCase().charAt(0);
		        int c = Character.getNumericValue(AsientoNo.charAt(1)) - 1;
		        int f = fl - 'A';
				
		        if (f >= 0 && f < 10 && c >= 0 && c < 6) {

		            if (asientos[f][c] == 'O') {
		                asientos[f][c] = 'L';
		                System.out.println("Asiento Desreservado correctamente");
		            } else {
		                System.out.println("Ese asiento esta libre, ingre nuevamente el asiento");
		            }

		        }
			}catch (Exception e) {
		        System.out.println("Ingrese bien el asiento (ej: A1)");
			}
		        
				break;
			case 4:
				System.out.println("Saliste");
				break;
			}
		} while (op != 4);

	}
	

}

