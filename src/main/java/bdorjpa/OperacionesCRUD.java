package bdorjpa;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;

public class OperacionesCRUD {

    // Método para crear un nuevo cliente
    public void crearCliente(Scanner entrada) {
        // Solicitar los datos del cliente al usuario
        System.out.print("Nombre: ");
        String nombre = entrada.nextLine();
        System.out.print("Apellido 1: ");
        String apellido1 = entrada.nextLine();
        System.out.print("Apellido 2: ");
        String apellido2 = entrada.nextLine();
        System.out.print("Comercial principal: ");
        String comercial = entrada.nextLine();
        System.out.print("ID Empresa: ");
        String idEmpresa = entrada.nextLine();

        // Crear un nuevo objeto Cliente con los datos obtenidos
        Cliente cliente = new Cliente(nombre, apellido1, apellido2, comercial, idEmpresa);

        // Obtener una instancia del EntityManager para interactuar con la base de datos
        EntityManager em = ConexionBD.getEntityManager();
        
        // Iniciar la transacción
        em.getTransaction().begin();

        // Persistir (guardar) el cliente en la base de datos
        em.persist(cliente);

        // Confirmar la transacción para hacer efectivos los cambios
        em.getTransaction().commit();
        
        // Cerrar el EntityManager
        em.close();

        // Confirmar al usuario que el cliente ha sido creado
        System.out.println("Cliente creado: " + cliente);
    }

    // Método para listar todos los clientes de la base de datos
    public void listarClientes() {
        // Obtener una instancia del EntityManager
        EntityManager em = ConexionBD.getEntityManager();
        
        // Crear una consulta para obtener todos los clientes de la base de datos
        List<Cliente> clientes = em.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
        
        // Imprimir cada cliente obtenido de la base de datos
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }

        // Cerrar el EntityManager
        em.close();
    }

    // Método para añadir una visita a un cliente específico
    public void añadirVisita(Scanner entrada) {
        // Solicitar el ID del cliente al usuario
        System.out.print("ID del cliente: ");
        Long id = entrada.nextLong();
        entrada.nextLine(); // Consumir el salto de línea que queda al leer el ID

        // Solicitar la fecha de la visita
        System.out.print("Fecha de visita (DD-MM-AAAA): ");
        String fecha = entrada.nextLine();

        // Obtener una instancia del EntityManager
        EntityManager em = ConexionBD.getEntityManager();
        
        // Iniciar la transacción
        em.getTransaction().begin();

        // Buscar al cliente con el ID proporcionado
        Cliente cliente = em.find(Cliente.class, id);
        if (cliente != null) {
            // Si el cliente existe, añadir la visita
            cliente.añadirVisita(fecha);
            
            // Confirmar la transacción
            em.getTransaction().commit();
            System.out.println("Visita añadida: " + cliente);
        } else {
            // Si el cliente no existe, mostrar mensaje de error
            System.out.println("Cliente no encontrado.");
            em.getTransaction().rollback(); // Deshacer la transacción en caso de error
        }

        // Cerrar el EntityManager
        em.close();
    }
    
    // Método para actualizar los datos de un cliente existente
    public void actualizarCliente(Scanner entrada) {
        // Solicitar el ID del cliente a actualizar
        System.out.print("ID del cliente a actualizar: ");
        Long id = entrada.nextLong();
        entrada.nextLine(); // Consumir el salto de línea

        // Obtener una instancia del EntityManager
        EntityManager em = ConexionBD.getEntityManager();
        
        // Iniciar la transacción
        em.getTransaction().begin();

        // Buscar al cliente con el ID proporcionado
        Cliente cliente = em.find(Cliente.class, id);
        if (cliente != null) {
            // Si el cliente existe, mostrar los datos actuales y permitir la actualización
            System.out.println("Cliente encontrado: " + cliente);
            System.out.print("Nuevo nombre (actual: " + cliente.getNombre() + "): ");
            cliente.setNombre(entrada.nextLine());
            System.out.print("Nuevo apellido1 (actual: " + cliente.getApellido1() + "): ");
            cliente.setApellido1(entrada.nextLine());
            System.out.print("Nuevo apellido2 (actual: " + cliente.getApellido2() + "): ");
            cliente.setApellido2(entrada.nextLine());
            System.out.print("Nuevo comercial principal (actual: " + cliente.getComercialPrincipal() + "): ");
            cliente.setComercialPrincipal(entrada.nextLine());
            System.out.print("Nuevo ID de empresa (actual: " + cliente.getIdEmpresa() + "): ");
            cliente.setIdEmpresa(entrada.nextLine());

            // Confirmar la transacción
            em.getTransaction().commit();
            System.out.println("Cliente actualizado con éxito.");
        } else {
            // Si el cliente no existe, mostrar mensaje de error
            System.out.println("Cliente no encontrado.");
            em.getTransaction().rollback(); // Deshacer la transacción en caso de error
        }

        // Cerrar el EntityManager
        em.close();
    }
    
    // Método para eliminar un cliente de la base de datos
    public void eliminarCliente(Scanner entrada) {
        // Solicitar el ID del cliente a eliminar
        System.out.print("ID del cliente a eliminar: ");
        Long id = entrada.nextLong();
        entrada.nextLine(); // Consumir el salto de línea

        // Obtener una instancia del EntityManager
        EntityManager em = ConexionBD.getEntityManager();
        
        // Iniciar la transacción
        em.getTransaction().begin();

        // Buscar al cliente con el ID proporcionado
        Cliente cliente = em.find(Cliente.class, id);
        if (cliente != null) {
            // Si el cliente existe, eliminarlo
            em.remove(cliente);
            em.getTransaction().commit();
            System.out.println("Cliente eliminado con éxito.");
        } else {
            // Si el cliente no existe, mostrar mensaje de error
            System.out.println("Cliente no encontrado.");
            em.getTransaction().rollback(); // Deshacer la transacción en caso de error
        }

        // Cerrar el EntityManager
        em.close();
    }
}   

