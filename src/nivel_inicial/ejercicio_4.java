package nivel_inicial;
import java.util.Scanner;


public class ejercicio_4 {

	public static void main(String[] args) {

	java.util.Scanner guardado = new Scanner(System.in);
	
	System.out.println("Inserte un numero: ");
	int numero_1 = guardado.nextInt();

	System.out.println("Inserte un segundo numero: ");
	int numero_2 = guardado.nextInt();
	
		if(numero_1 > numero_2) {
			System.out.println("El primer numero ingresado es mayor al segundo numero");
		}
		else if(numero_1 < numero_2) {
			System.out.println("El segundo numero es mayor que el primero ingresado");
		}
		else if(numero_1 == numero_2) {
			System.out.println("Los dos numeros son iguales");;
		}
	}

}
