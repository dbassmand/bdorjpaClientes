package bdorjpa;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner entrada = new Scanner(System.in);
        OperacionesCRUD crud = new OperacionesCRUD();

        int opcion;
        
        System.out.println("\n***********Bienvenido!!*************");
    	System.out.println("*---------BBDDOO - CRUD------------*");
        do {
        	System.out.println("\n************************************");
        	System.out.println("*                                  *");
            System.out.println("*        1. Crear cliente          *");
            System.out.println("*        2. Ver clientes           *");
            System.out.println("*        3. Añadir visita          *");
            System.out.println("*        4. Actualizar cliente     *");
            System.out.println("*        5. Eliminar cliente       *");
            System.out.println("*        6. Salir                  *");
            System.out.println("*                                  *");
            System.out.println("************************************");
            System.out.print("Elige una opción: ");
            opcion = entrada.nextInt();
            entrada.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    crud.crearCliente(entrada);
                    break;
                case 2:
                    crud.listarClientes();
                    break;
                case 3:
                    crud.añadirVisita(entrada);
                    break;                
                case 4:
                    crud.actualizarCliente(entrada);
                    break;
                case 5:
                    crud.eliminarCliente(entrada);
                    break;
                case 6:
                    System.out.println("¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 6);

        entrada.close();
        ConexionBD.cerrarConexion();
    }
}

