package usuario.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import usuario.enums.UsuarioEnum;

@Entity
@Table(name = "TB_ROLESUSUARIO") 
public class RolUsuario {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_RolUsuario")
	@SequenceGenerator(name = "id_RolUsuario", sequenceName = "ID_SEQ_ROL")
    private Long id;

    //@Enumerated(EnumType.STRING)
    @Column(length = 20)
    private String rolEnum;


    public RolUsuario() {
    	
    }

    public RolUsuario(String rolEnum) {
        this.rolEnum = rolEnum;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRolEnum() {
		return rolEnum;
	}

	public void setRolEnum(String rolEnum) {
		this.rolEnum = rolEnum;
	}

	@Override
	public String toString() {
		return "RolUsuario [id=" + id + ", rolEnum=" + rolEnum + "]";
	}
    
    
    
    
}
