package nivel_inicial;

import java.util.Scanner;

public class ejercicio_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.Scanner a= new Scanner(System.in);
		
		System.out.println("dame un numero: ");
		int nro_1 = a.nextInt();
		
		
		System.out.println("dame un numero: ");
		int nro_2 = a.nextInt();
		
		multiplo(nro_1, nro_2);
		
	}
	public static void multiplo(int nro_1, int nro_2) {
		if(nro_1 % nro_2 == 0) {
			System.out.println("Es multiplo");
		}
		else {
			System.out.println("No multiplo");

		}
	}

}
