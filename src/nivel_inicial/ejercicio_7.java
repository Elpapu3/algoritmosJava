package nivel_inicial;

import java.util.Scanner;

public class ejercicio_7 {

	public static void main(String[] args) {
		
		java.util.Scanner a= new Scanner(System.in);
		
		System.out.println("Ingrese un numero: ");
		int nro = a.nextInt();
		
		if(nro % 2 == 0) {
			System.out.println("Es par");
		}
		else {
			System.out.println("Es impar");

		}

	}

}
