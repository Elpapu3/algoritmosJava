package nivel_inicial;

import java.util.Scanner;

public class ejercico10practicapreuba {

	public static void main(String[] args) {
		/* EJERCICIO PARA PRACTICAR

Escribir un programa que permita administrar los socios de un club deportivo.

La información se guardará en una matriz de 2 columnas:
- Columna 0: Número de socio
- Columna 1: Cuota pagada

El programa deberá mantener los socios ordenados de menor a mayor
por número de socio para facilitar la búsqueda.

Capacidad máxima: 50 socios.

El programa mostrará un menú con las siguientes opciones:

1- Dar de alta un nuevo socio
   (comprobando que no esté lleno y ubicándolo en la posición correcta)

2- Eliminar un socio
   (comprobando que no esté vacío y reposicionando los datos)

3- Mostrar un socio
   (mostrar número de socio y cuota pagada)

4- Mostrar información general
   - Cantidad de socios cargados
   - Dinero total recaudado

5- Calcular cuota media, máxima y mínima

6- Mostrar todos los socios
   (una línea por socio)

7- Buscar si existe un número de socio

8- Salir

---------------------------------------------------
EXTRA (si querés hacerlo más difícil):
- No permitir números repetidos
- Permitir modificar la cuota de un socio
- Mostrar el socio que más paga
*/
		Scanner s = new Scanner(System.in);
		int MAX_SOCIOS=50;
		int[][] datosSocios= new int[MAX_SOCIOS][2];
		int cantidadSocios = 0;
		
		int ops=0;
			
		do {
			ops = menu(s);
			cantidadSocios =  accion(s, ops, cantidadSocios, datosSocios, MAX_SOCIOS);
		} while (ops!=8);
		
		
	}
	private static int menu (Scanner s) {
		int ops;
		System.out.println("1)Dar de alta un nuevo socio: ");
		System.out.println("2)Eliminar un socio: ");
		System.out.println("3)Mostrar un socio: ");
		System.out.println("4)Mostrar información general: ");
		System.out.println("5)Calcular cuota media, máxima y mínima: ");
		System.out.println("6)Mostrar todos los socios: ");
		System.out.println("7)Buscar si existe un número de socio: ");
		System.out.println("8)Salir: ");
		
		ops = LeerEntero(s);
		
		return ops;
		
	}
	private static int accion(Scanner s, int ops, int cantidadSocios, int[][] datosSocios, int MAX_SOCIOS) {
		switch (ops) {
		case 1:
			
			cantidadSocios = dardeAlta(s, datosSocios, cantidadSocios, MAX_SOCIOS);
			break;
		case 2:
				cantidadSocios = eliminarSocio(s, datosSocios, cantidadSocios);
				break;
		case 3:
				mostrarSocio(s, datosSocios, cantidadSocios);
			break;
		case 4:
			informacionGeneral(s, datosSocios, cantidadSocios);
			break;
		case 5:
			calcular(s, datosSocios, cantidadSocios);
			break;
		case 6:
			mostrarTodosSocios(s, datosSocios, cantidadSocios);
			break;
		}
		
		
		
		return cantidadSocios;
		
	}
	private static int dardeAlta(Scanner s, int[][] datosSocios, int cantidadSocios, int MAX_SOCIOS) {
		System.out.print("Ingrese la cantidad de socios que desea dar de alta: ");
		int cantidadSociosAlta = LeerEntero(s);
		s.nextLine();
		for (int i = 0; i < cantidadSociosAlta && cantidadSocios < MAX_SOCIOS; i++) {
			
			   if(cantidadSocios + cantidadSociosAlta > MAX_SOCIOS) {
			        System.out.println("Error: no se pueden ingresar tantos socios.");
			        System.out.println("Solo quedan " + (MAX_SOCIOS - cantidadSocios) + " lugares.");
			        return cantidadSocios;
			    }
			System.out.println("Ingre la cuenta del socio: ");
			int numSocio= LeerEntero(s);
			
			if(existeCuenta(numSocio, datosSocios, cantidadSociosAlta)==i) {
				System.out.println("ESTA CUENTA YA EXISTYE, vuelva a intentarlo");
				i--;
				continue;
			}
		System.out.println("Ingrese couta que pago");
		int coutoasPagadas = LeerEntero(s);
		
		datosSocios[cantidadSocios][0]=numSocio;
		datosSocios[cantidadSocios][1]=coutoasPagadas;
		cantidadSocios++;
		}
		
		
		return cantidadSocios;
		
		
	}
	private static int eliminarSocio(Scanner s, int[][] datosSocios, int cantidadSocios) {
		
		System.out.print("Ingrese el numero de cuenta que desea eliminar: ");
		int numSocio= LeerEntero(s);
		
		int pos=existeCuenta(numSocio, datosSocios, cantidadSocios);
		
		if(pos == -1) {
			System.out.println("No eciste tal ceunta ");
			return cantidadSocios;
		}
		
		for (int i = pos; i < cantidadSocios-1; i++) {
			for (int j = 0; j < 2; j++) {
				datosSocios[i][j] = datosSocios[i+1][j];
			
			}
			
		}
		 cantidadSocios--;
		 System.out.println("Cuenta eliminada");


		
		return cantidadSocios;
		
		
	}
	private static int mostrarSocio(Scanner s, int[][] datosSocios, int cantidadSocios) {
		System.out.print("Ingrese el xsocio delv cual desea ver infomacion: ");
		int numSocio= LeerEntero(s);
		
		int pos = existeCuenta(numSocio, datosSocios, cantidadSocios);
		if(pos == -1) {
			System.out.println("No se encontro la cuenta");
			return cantidadSocios;
		}
		System.out.println("la canrtidad de saldo es: "+datosSocios[pos][1]);
		
		return cantidadSocios;
	}
	private static int informacionGeneral(Scanner s, int[][] datosSocios, int cantidadSocios) {
		System.out.println("INFORMACION GENERAL");
		for (int i = 0; i < cantidadSocios; i++) {
				
				System.out.println("CUENTA:" +datosSocios[i][0]+ "lo que pago es: " +datosSocios[i][1]);

			
		}
		return cantidadSocios;
		
		
	}
	private static int calcular(Scanner s, int[][] datosSocios, int cantidadSociod) {
		//Calcular cuota media, máxima y mínima:
		int media = 0;
		int rst=0;
		int max=0;
		int min=10000;
		for (int i = 0; i < cantidadSociod; i++) {
			rst += datosSocios[1][0];
			
			if(datosSocios[i][1]>max) {
				max = datosSocios[i][1];
			}
			if(datosSocios[i][1] <min) {
				min = datosSocios[i][0];
			}
		}
		media = rst/cantidadSociod;
		System.out.println("La media es de: " +media);
		System.out.println("El maximo es: "+max);
		System.out.println("El minimo es: "+min);
		return cantidadSociod;
		
	}
	private static int mostrarTodosSocios(Scanner s, int[][] datosSocios, int cantidadSocios) {
		System.out.println("LOS SOCIOS SON: ");
		
		for (int i = 0; i < cantidadSocios; i++) {
			System.out.println("Los socios son: "+datosSocios[i][0]);
		}
		
		return cantidadSocios;
		
	}
	private static int existeCuenta(int numSocio, int[][] datosSocios, int cantidadSocios) {
		
		for (int i = 0; i < cantidadSocios; i++) {
			if(datosSocios[i][0] == numSocio) {
				return i; //existe
			}
		}
		return -1; // no existe
	}
	private static int LeerEntero(Scanner s) {
		int num;
		while (true) {
			try {
				num = s.nextInt();
				return num;
			} catch (Exception e) {
				System.out.println("Ingrese un caracter valido: ");
				s.nextLine();
			}
		}
		
	}

}
