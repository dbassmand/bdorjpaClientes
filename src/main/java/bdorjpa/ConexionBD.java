package bdorjpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConexionBD {
    // Nombre de la unidad de persistencia definida en persistence.xml
    private static final String UNIDAD_PERSISTENCIA = "clientePU";
    
    // Instancia estática de EntityManagerFactory, que se utiliza para crear EntityManagers
    private static EntityManagerFactory emf;

    // Bloque estático que se ejecuta cuando se carga la clase
    static {
        // Crear un EntityManagerFactory utilizando el nombre de la unidad de persistencia
        emf = Persistence.createEntityManagerFactory(UNIDAD_PERSISTENCIA);
    }

    // Método estático para obtener una nueva instancia de EntityManager
    public static EntityManager getEntityManager() {
        // EntityManager es responsable de gestionar la persistencia de las entidades
        return emf.createEntityManager();
    }

    // Método estático para cerrar la conexión con la base de datos
    public static void cerrarConexion() {
        // Verifica si el EntityManagerFactory está abierto antes de cerrarlo
        if (emf != null && emf.isOpen()) {
            emf.close(); // Cierra el EntityManagerFactory y libera los recursos
        }
    }
}
