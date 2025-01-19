package bdorjpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Genera un ID automáticamente
    private Long id;

    private String nombre;
    private String apellido1;
    private String apellido2;
    private String comercialPrincipal;
    private String idEmpresa;

    @ElementCollection // Indica que este campo es una colección simple
    private List<String> fechasVisitas = new ArrayList<>();
    
    // Getters y setters
    public void añadirVisita(String fecha) {
        this.fechasVisitas.add(fecha);
    }

    // Getters, setters, constructor y toString()
    public Cliente() {}

    public Cliente(String nombre, String apellido1, String apellido2, String comercialPrincipal, String idEmpresa) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.comercialPrincipal = comercialPrincipal;
        this.idEmpresa = idEmpresa;
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getComercialPrincipal() {
		return comercialPrincipal;
	}

	public void setComercialPrincipal(String comercialPrincipal) {
		this.comercialPrincipal = comercialPrincipal;
	}

	public String getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(String idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public List<String> getFechasVisitas() {
		return fechasVisitas;
	}

	public void setFechasVisitas(List<String> fechasVisitas) {
		this.fechasVisitas = fechasVisitas;
	}

	@Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido1='" + apellido1 + '\'' +
                ", apellido2='" + apellido2 + '\'' +
                ", comercialPrincipal='" + comercialPrincipal + '\'' +
                ", idEmpresa='" + idEmpresa + '\'' +
                ", fechasVisitas=" + fechasVisitas +
                '}';
    }
}
