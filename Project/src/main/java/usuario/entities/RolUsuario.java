package usuario.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import usuario.enums.UsuarioEnum;

@Entity
public class RolUsuario {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private UsuarioEnum rolEnum;


    public RolUsuario() {
    	
    }

    public RolUsuario(UsuarioEnum rolEnum) {
        this.rolEnum = rolEnum;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UsuarioEnum getRolEnum() {
		return rolEnum;
	}

	public void setRolEnum(UsuarioEnum rolEnum) {
		this.rolEnum = rolEnum;
	}

	@Override
	public String toString() {
		return "RolUsuario [id=" + id + ", rolEnum=" + rolEnum + "]";
	}
    
    
    
    
}
