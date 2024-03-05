package usuario.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "TB_USUARIO_PROJECT") 
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    private String nombre;
    private String apellidos;
    private String dni;
    private String sexo;
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    private String email;
    private String telefono;
    private String nameUsuario;
    private String contrasena;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "TB_USUARIO_ROLES",
        joinColumns = @JoinColumn(name = "id_usuario"),
        inverseJoinColumns = @JoinColumn(name = "id_rol"))
    private Set<RolUsuario> roles = new HashSet<>();

	public Usuario() {
		super();
	}
	
	

	public Usuario(String nombre, String apellidos, String dni, String sexo, Date fechaNacimiento, String email,
			String telefono, String nameUsuario, String contrasena, Set<RolUsuario> roles) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.sexo = sexo;
		this.fechaNacimiento = fechaNacimiento;
		this.email = email;
		this.telefono = telefono;
		this.nameUsuario = nameUsuario;
		this.contrasena = contrasena;
		this.roles = roles;
	}



	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getNameUsuario() {
		return nameUsuario;
	}

	public void setNameUsuario(String nameUsuario) {
		this.nameUsuario = nameUsuario;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Set<RolUsuario> getRoles() {
		return roles;
	}

	public void setRoles(Set<RolUsuario> roles) {
		this.roles = roles;
	}



	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", sexo=" + sexo
				+ ", fechaNacimiento=" + fechaNacimiento + ", email=" + email + ", telefono=" + telefono
				+ ", nameUsuario=" + nameUsuario + ", contrasena=" + contrasena + ", roles=" + roles + "]";
	}
    
    
    
    
}

