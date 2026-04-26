package nivel_inicial;

import java.util.Scanner;

public class ejercicio_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.Scanner guardado = new Scanner(System.in); 
		System.out.println("Ingrese un numero: ");
		int numero_1 = guardado.nextInt();

		System.out.println("Ingrese el siguente numero: ");
		int numero_2 = guardado.nextInt();
	
		
        System.out.println("La suma es: " + sumar(numero_1, numero_2));
        System.out.println("La multiplicacion es: " + multiplicar(numero_1, numero_2));
        System.out.println("La resta es. " + resta(numero_1, numero_2));
        System.out.println("La division es: " + division(numero_1, numero_2));
        System.out.println("El resto de los numeros es: " + resto(numero_1, numero_2));

	}

	public static int sumar(int numero_1, int numero_2) {
		return numero_1 + numero_2;
	}
	public static int multiplicar(int numero_1, int numero_2) {
		return numero_1 * numero_2;
	}
	public static int resta(int numero_1, int numero_2) {
		return numero_1 - numero_2;
	}
	public static double division(int numero_1, int numero_2) {
		return (double )numero_1 / numero_2;
	}
	public static double resto(int numero_1, int numero_2) {
		return (double)numero_1 % numero_2;
	}
}
