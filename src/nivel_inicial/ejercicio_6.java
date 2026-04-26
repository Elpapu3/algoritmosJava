package nivel_inicial;

import java.util.Scanner;

public class ejercicio_6 {

	public static void main(String[] args) {

		java.util.Scanner guardado = new Scanner(System.in);
		
		System.out.println("Ingrese un numero: ");
		int numero_1 = guardado.nextInt();
		
		System.out.println("Ingrese un numero: ");
		int numero_2 = guardado.nextInt();
		
		System.out.println("Ingrese un numero: ");
		int numero_3 = guardado.nextInt();
		
		System.out.println("Ingrese un numero: ");
		int numero_4 = guardado.nextInt();
		
		System.out.println("Ingrese un numero: ");
		int numero_5 = guardado.nextInt();
		
        System.out.println("el numero mayor es: " + mayor(numero_1, numero_2, numero_3, numero_4, numero_5));
        System.out.println("el numero menor es: " + menor(numero_1, numero_2, numero_3, numero_4, numero_5));

		
	}
	public static int mayor(int numero_1, int numero_2, int numero_3, int numero_4, int numero_5) {
		int mayor = numero_1;
		if(numero_2 > mayor) mayor = numero_2 ;
		if(numero_3 > mayor) mayor = numero_3; 
		if(numero_4 > mayor) mayor = numero_4; 
		if(numero_5 > mayor) mayor = numero_5; 
		return mayor; 
	}
	public static int menor(int numero_1, int numero_2, int numero_3, int numero_4, int numero_5) {
		int menor = numero_1;
		if(numero_2 < menor) menor = numero_2;
		if(numero_3 < menor) menor = numero_3; 
		if(numero_4 < menor) menor = numero_4; 
		if(numero_5 < menor) menor = numero_5; 
		return menor; 
	}

}
