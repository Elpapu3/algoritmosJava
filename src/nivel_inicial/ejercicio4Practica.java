package nivel_inicial;

import java.sql.SQLSyntaxErrorException;
import java.util.Scanner;

public class ejercicio4Practica {

	public static void main(String[] args) {
/*Escribir un programa que permita guardar las cuentas de un banco con sus
respectivos saldos. Para ello se guardará la información en una matriz, que
corresponderá a números de cuenta y saldos de cuenta.
El programa deberá mantener las cuentas ordenadas, de menor a mayor, por
número de cuenta para facilitar la búsqueda en una cuenta.
El programa mostrará un menú con las siguientes opciones:
1- Dar de alta una nueva cuenta (comprobando que no esté lleno y colocando la
cuenta en la posición correspondiente)
2- Eliminar una cuenta (comprobando que no este vacío y reposicionando las
cuentas)
3- Mostrar una cuenta (mostrará el número de cuenta y el saldo
correspondiente)
4- Mostrar información (Número de cuentas dadas de alta y dinero total de
todas ellas)
5- Calcular el saldo medio, máximo y mínimo de las cuentas.
6- Mostrar todas las cuentas (1 línea por cuenta con su número y su saldo)
7- Salir*/
		
		
		Scanner s = new Scanner(System.in);
		final int CANTIDAD_MAX = 100;
		double[][] datosCuenta = new double[CANTIDAD_MAX][2];
		int cantidadCuenta = 0; 
		int ops=0;
		
		do {
			ops = menu(s);
			cantidadCuenta = accionMenu(s, ops, cantidadCuenta, datosCuenta, CANTIDAD_MAX);
		} while (ops != 7);
	}
	
	private static int menu(Scanner s) {
		int ops;
		System.out.println("1)Dar de alta una nueva cuenta (comprobando que no esté lleno y colocando la cuenta en la posición correspondiente)");
		System.out.println("2Eliminar una cuenta (comprobando que no este vacío y reposicionando las cuentas) ");
		System.out.println("3)Mostrar una cuenta (mostrará el número de cuenta y el saldo correspondiente)");
		System.out.println("4)Mostrar información (Número de cuentas dadas de alta y dinero total de todas ellas)");
		System.out.println("5)Calcular el saldo medio, máximo y mínimo de las cuentas.");
		System.out.println("6)Mostrar todas las cuentas (1 línea por cuenta con su número y su saldo)");
		System.out.println("7)salir");
		ops = leerEntero(s);
		
		return ops;
		
		
	}
	private static int accionMenu(Scanner s, int ops, int cantidadCuenta, double[][] datosCuenta, int CANTIDAD_MAX) {
		switch (ops) {
		case 1:
			if(cantidadCuenta > CANTIDAD_MAX) {
				System.out.println("No se puede inngresar tla numero de cuentas, excede el limite");
			}else {
				cantidadCuenta = ingresarDatos(s, cantidadCuenta, datosCuenta, CANTIDAD_MAX);
			}
			break;
		case 2:
			cantidadCuenta = eliminarCuenta(s, cantidadCuenta, datosCuenta);
			break;

		case 3:
			mostrarCuenta(s, cantidadCuenta, datosCuenta);
			break;
		case 4:
		informacionCuentas(s, cantidadCuenta, datosCuenta);
			break;
		case 5:
			calcularSalto(s, cantidadCuenta, datosCuenta);
			break;
		case 6:
			mostrarTodaslasCuentas(cantidadCuenta, datosCuenta);
			break;
		}
		
		return cantidadCuenta;
		
	}
	private static int ingresarDatos(Scanner s, int cantidadCuenta, double[][] datosCuenta, int CANTIDAD_MAX) {
		System.out.print("ingrese la cantidad de cuentas que quiere dar de alta:  ");
		int cantidad = leerEntero(s);
		s.nextLine();
		
		for (int i = 0; i <  cantidad && cantidadCuenta < CANTIDAD_MAX ; i++) {

			
			System.out.println("Numero de cuenta: ");	        
	        int numCuenta = leerEntero(s);
			if (existeCuenta(numCuenta, cantidadCuenta, datosCuenta)) {
                System.out.println("La cuenta ya existe. Intente otra.");
                i--; // repetir intento
                continue;
            }
	        
	        System.out.println("Saldo de la cuenta: ");
	        double saldo = leerDouble(s);
	        
	        datosCuenta[cantidadCuenta][0] = numCuenta;
	        datosCuenta[cantidadCuenta][1] = saldo;
	        cantidadCuenta++;
		}
		
		return cantidadCuenta;
		
		
	}
	private static boolean existeCuenta(int numeroCuenta, int cantidadCuenta, double[][] datosCuenta) {

	    for (int i = 0; i < cantidadCuenta; i++) {
	        if ((int) datosCuenta[i][0] == numeroCuenta) {
	            return true; // ya existe
	        }
	    }

	    return false; // no existe
	}
	private static int mostrarCuenta(Scanner s, int cantidadCuenta, double[][] datosCuenta) {
		System.out.print("Ingrese la cuenda bancaria");
		int numCuenta = leerEntero(s);
		
		int pos = buscarCuenta(numCuenta, cantidadCuenta, datosCuenta);
		if(pos == -1) {
			System.out.println("no se encontro el numero de cuenta");
			return cantidadCuenta;
		}else {
			System.out.println("DATOS DE LA CUENTA");
			System.out.println("Numero de cuenta: "+(int)datosCuenta[pos][0]);
			System.out.println("Saldo: "+datosCuenta[pos][1]);

		}
		return cantidadCuenta;
		
	}
	
	private static int calcularSalto(Scanner s, int cantidadCuenta, double[][] datosCuentas) {
		double medio=0;
		double resultado1=0;
		double max=0;
		double min=1000000;
		for (int i = 0; i < cantidadCuenta; i++) {
			resultado1 += datosCuentas[i][1];
			if(datosCuentas[i][1] > max) {
				max=datosCuentas[i][1];
			}
			if(datosCuentas[i][1]<min) {
				min = datosCuentas[i][1];
			}
		}
		
		medio = resultado1/cantidadCuenta;
		System.out.println("El medio entre los saldos es de: "+medio);
		System.out.println("El maximo entre los saldos es de: "+(int)max);
		System.out.println("El minimo entre los saldos es de: "+(int)min);

		return cantidadCuenta;
		
	}
	private static int informacionCuentas(Scanner s, int cantidadCuenta, double[][] datosCuenta) {
		double resultado2=0;
		for (int i = 0; i < cantidadCuenta; i++) {
				resultado2 += datosCuenta[i][1];
			
			
		}	
		System.out.println("El todal de las cuentas dasdas de alta es: " +cantidadCuenta);
		System.out.println("El total del slado de las cuentas son: "+resultado2);

			
		return cantidadCuenta;
		
		
	}
	
	private static int eliminarCuenta(Scanner s, int cantidadCuenta, double[][] datosCuenta) {



	    System.out.print("Ingrese numero de cuenta a eliminar: ");
	    int numCuenta = leerEntero(s);

	    int pos = buscarCuenta(numCuenta, cantidadCuenta, datosCuenta);

	    if (pos == -1) {
	        System.out.println("La cuenta no existe");
	        return cantidadCuenta;
	    }
	    if(datosCuenta[pos][1] > 0){
	        System.out.println("La cuenta tiene saldo, EL SALDO ES DE: " +datosCuenta[pos][1]);
	     datosCuenta[pos][1] =0;
	    }

	    // 🔥 CORRIMIENTO HACIA ARRIBA
	    for (int i = pos; i < cantidadCuenta - 1; i++) {
	        for (int j = 0; j < 2; j++) {
	            datosCuenta[i][j] = datosCuenta[i + 1][j];
	        }
	    }

	    cantidadCuenta--;

	    System.out.println("Cuenta eliminada");

	    return cantidadCuenta;
	}
	private static int mostrarTodaslasCuentas(int cantidadCuenta, double[][] datosCuenta) {
		System.out.println("Los datos de las cuentas: ");
		for (int i = 0; i < cantidadCuenta; i++) {
			System.out.println("Cuenta numero "+(int)datosCuenta[i][0]+ " su salario es: " +datosCuenta[i][1]);
		}
		
		
		return cantidadCuenta;
		
	}
	private static int buscarCuenta(int numCuenta, int cantidadCuenta, double[][] datosCuenta) {

	    for (int i = 0; i < cantidadCuenta; i++) {
	        if ((int)datosCuenta[i][0] == numCuenta) {
	            return i; // posición encontrada
	        }
	    }

	    return -1; // no existe
	}

		

	private static int leerEntero(Scanner s) {
		int num;
		while (true) {
			try {
				num = s.nextInt();
				
				return num;
			} catch (Exception e) {
				System.out.println("no ingreso un nuemro, ingrese un numero");
				s.nextLine();
			}
		}
	}
	private static double leerDouble(Scanner s) {
		double num;
		while (true) {
			try {
				num = s.nextDouble();
				
				return num;
			} catch (Exception e) {
				System.out.println("no ingreso un nuemro, ingrese un numero");
				s.nextLine();
			}
		}
	}

}
