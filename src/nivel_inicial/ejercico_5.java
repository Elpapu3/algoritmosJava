package nivel_inicial;

import java.util.Scanner;

public class ejercico_5 {

	public static void main(String[] args) {

		java.util.Scanner guardado = new Scanner(System.in);
		
		System.out.println("Ingrese un numero");
		int numero_1 = guardado.nextInt();
		
		System.out.println("Ingrese otro numero");
		int numero_2 = guardado.nextInt();
		
		System.out.println("Ingrese otro numero");
		int numero_3 = guardado.nextInt();
		
		
		
        System.out.println("La suma es: " + sumar(numero_1, numero_2, numero_3));
        System.out.println("El promedio es: " + promedio(numero_1, numero_2, numero_3));
        System.out.println("La multiplicacion es: " + multiplicacion(numero_1, numero_2, numero_3));
        System.out.println("El numero mayor es: " + mayor(numero_1, numero_2, numero_3));
        System.out.println("el numero menor es: " + menor(numero_1, numero_2, numero_3));


	}
	public static int sumar(int numero_1, int numero_2, int numero_3) {
		return numero_1 + numero_2 + numero_3;
	}
	public static double promedio(int numero_1, int numero_2, int numero_3) {
		return (double) (numero_1 + numero_2 + numero_3) / 3;
	}
	public static int multiplicacion(int numero_1, int numero_2, int numero_3) {
		return  numero_1 * numero_2 * numero_3;
	}
	public static int mayor(int numero_1, int numero_2, int numero_3) {
		int mayor = numero_1;
		if(numero_2 > mayor) numero_2 = mayor;
		if(numero_3 > mayor) numero_3 = mayor; 
		return mayor; 
	}
	public static int menor(int numero_1, int numero_2, int numero_3) {
		int menor = numero_1;
		if(numero_2 < menor) numero_2 = menor;
		if(numero_3 < menor) numero_3 = menor;
		return menor;
	}

}
