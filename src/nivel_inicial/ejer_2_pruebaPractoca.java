package nivel_inicial;

import java.util.Scanner;

public class ejer_2_pruebaPractoca {

	public static void main(String[] args) {
		/* Se debe crear un programa para administrar el stock de productos de una tienda
		de comestibles la cual tiene la capacidad de administrar 50 variedades de los
		mismos. La información a ingresar por cada producto será: nombre, precio y
		cantidad.
		Se debe mostrar un menú con las siguientes opciones:
		a) Consultar productos en la tienda
		b) Dar de alta una variedad de producto
		c) Dar de baja una variedad de producto
		d) Modificar stock de un producto
		e) Modificar precio de un producto
		f) Vender producto
		g) Salir*/
        Scanner s = new Scanner(System.in);
		final int CANTIDAD_MAX = 50;
		String[][] datosProductos = new String[CANTIDAD_MAX][3];
		int cantidadProductos=0;
		char ops =0; 

		do {
			ops = menu(s);
			cantidadProductos = generarAccion(ops,s, CANTIDAD_MAX, datosProductos, cantidadProductos);
		} while (ops!= 'g'); 
		 
	}
	private static char menu(Scanner s) {
		char ops;
		System.out.println("a) Agregar producto");
		System.out.println("b) Consultar productos en la tienda");
		System.out.println("c) Dar de baja una variedad de producto");
		System.out.println("d) Modificar stock de un producto");
		System.out.println("e) Modificar precio de un producto");
		System.out.println("f) Vender producto");
		System.out.println("g) Salir");
		ops = leerLetra(s);

		return ops;
		
	}
	private static int generarAccion (char ops, Scanner s, int CANTIDAD_MAX, String[][] datosProductos, int cantidadProductos) {
		switch (ops) {
		case 'a':
			if(cantidadProductos >= CANTIDAD_MAX) {
				System.out.print("sE ESTAN INGRESANDO MUCHOS PRODUCTOS, NO SE PUEDE MAS DE 50");
			}else {
				cantidadProductos = agregarProducto(s, datosProductos, CANTIDAD_MAX, cantidadProductos);			}
			break;
		
		case 'b':
			int pos = buscarProducto(s, datosProductos, cantidadProductos);
			
			if(pos == -1) {
				System.out.println("No se encontro ningun producto con ese nombre");
			}else {
				System.out.println("Nombre: "+datosProductos[pos][0]);
				System.out.println("precio: "+datosProductos[pos][1]);
				System.out.println("cantida: "+datosProductos[pos][2]);

		
			}
			break;
		case 'c':
			cantidadProductos = eliminarProducto(s, datosProductos, cantidadProductos);
			break;
		case 'd':
			int posStock = modificarStock(s, datosProductos, cantidadProductos);
			if(posStock == -1) {
				System.out.println("No se encontro ningun producto con ese nombre");
			}else {
			      System.out.print("Ingrese la nueva cantidad del stock");
			      int cantidad = leerEntero(s);
			       datosProductos[posStock][2] = String.valueOf(cantidad);

			      System.out.println("nuevo stock: "+datosProductos[posStock][2]);
				
			}
			break;
		case 'e':
			int posPrecio = modificarStock(s, datosProductos, cantidadProductos);
			if(posPrecio == -1) {
				System.out.println("No se encontro ese producto");
			}else {
				 System.out.print("Ingrese el nuevo precio del producto: ");
			      int cantidad = leerEntero(s);
			       datosProductos[posPrecio][1] = String.valueOf(cantidad);

			      System.out.println("nuevo stock: "+datosProductos[posPrecio][1]);
				
			}
		break;
		
		case 'f':
			cantidadProductos = venderProducto(s, datosProductos, cantidadProductos);
			break;
			
		case 'g':
			System.out.print("saliste");
			break;
		}
		return cantidadProductos;
		
	}
	
	private static int agregarProducto(Scanner s, String[][] datosProductos, int CANTIDAD_MAX, int cantidadProductos) {

	    System.out.println("Ingrese la cantidad de productos que desea ingresar: ");
	    int cantidad = leerEntero(s);
	    s.nextLine(); // 👈 MUY IMPORTANTE

	    for (int i = 0; i < cantidad && cantidadProductos < CANTIDAD_MAX; i++) {

	        System.out.println("Producto " + (i + 1));

	        System.out.print("Nombre: ");
	        datosProductos[cantidadProductos][0] = s.nextLine(); // ahora sí funciona bien


	        System.out.print("Precio: ");
	        datosProductos[cantidadProductos][1] = String.valueOf(leerDouble(s));

	        System.out.print("Cantidad: ");
	        datosProductos[cantidadProductos][2] = String.valueOf(leerEntero(s));


	        cantidadProductos++;
	    }

	    return cantidadProductos;
	}
	private static int buscarProducto(Scanner s, String[][] datosProductos, int cantidadProductos) {
	    
	    System.out.print("Ingrese el nombre del producto a buscar: ");
	    String nombre = s.nextLine();

	    for (int i = 0; i < cantidadProductos; i++) {
	        if (datosProductos[i][0].equalsIgnoreCase(nombre)) { /// comparar nombre
	            return i; // 👈 devuelve la posición
	        }
	    }

	    return -1; // 👈 no encontrado
	}
	private static int eliminarProducto(Scanner s, String[][] datosProductos, int cantidadProductos) {
		System.out.print("Ingrese el nombre del producto que desea buscar: ");
		String nombre = s.nextLine();
		
		for(int i=0; i<cantidadProductos; i++) {
			if(datosProductos[i][0].equalsIgnoreCase(nombre)) {
				
				for (int j = 0; j < cantidadProductos - 1; j++) {
					for (int j2 = 0; j2 < 3; j2++) {
						datosProductos[j][j2] = datosProductos[j+1][j2];
					}
				}
				cantidadProductos--;
				System.out.println("Se elimino el producto");
				return cantidadProductos;

				
			}
		}
		
	    System.out.println("Producto no encontrado. intentelo otra vez");
		return cantidadProductos;
		
	}
	private static int modificarStock(Scanner s, String[][] datosProductos, int cantidadProductos ) {
		System.out.print("Ingrese el nombre del producto: ");
		String nombre = s.nextLine();
		
		for(int i=0; i<cantidadProductos; i++) {
			 if (datosProductos[i][0].equalsIgnoreCase(nombre)) { /// comparar nombre
		            return i; // 👈 devuelve la posición
	
		              
		      }
			
		}

		
		
		
		return -1;
		
		
	}
	
	private static int venderProducto(Scanner s, String[][] datosProductos, int cantidadProductos) {
		System.out.print("Ingrese el producto que desea vender: ");
		String nombre = s.nextLine();
		
		

		for(int i=0; i<cantidadProductos; i++) {
			if(datosProductos[i][0].equalsIgnoreCase(nombre)) {
	            int stockActual = Integer.parseInt(datosProductos[i][2]);
	            System.out.print("Ingrese la cantidad que desea vender: ");
	            int cantidad = leerEntero(s);
	         
	            if(cantidad <= stockActual) {
	            	int nuevoStock = stockActual - cantidad;
	                // 🔥 actualizás el stock
	                datosProductos[i][2] = String.valueOf(nuevoStock);
	            	System.out.println("El stock se actualizo, le venta se realizo");
	            }else {
	            System.out.println("No se puede vender esa cantidad, no hay stock suficiente");	
	            
	            }
			}
			return cantidadProductos;
		}
		
	    System.out.println("Producto no encontrado. intentelo otra vez");
		return cantidadProductos;		
		
	}
	private static char leerLetra(Scanner s) {
	    while (true) {
	        System.out.print("Ingrese una letra: ");
	        String input = s.nextLine();

	        if (input.length() == 1 && Character.isLetter(input.charAt(0))) {
	            return Character.toLowerCase(input.charAt(0));
	        } else {
	            System.out.println("Error: ingrese una sola letra válida.");
	        }
	    }
	}
	
	private static int leerEntero(Scanner s) {
	    int num;

	    while (true) {
	        try {
	            num = s.nextInt();
	            s.nextLine(); // 👈 LIMPIA ACÁ

	            return num;

	        } catch (Exception e) {
	            System.out.println("Error: debe ingresar un número válido.");
	            s.nextLine(); // limpiar buffer
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
	            System.out.println("Error: debe ingresar un número válido.");
	            s.nextLine(); // limpiar buffer
	        }
	    }
	}

}
