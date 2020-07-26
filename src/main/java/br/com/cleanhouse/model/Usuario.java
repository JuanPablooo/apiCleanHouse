package br.com.cleanhouse.model;

import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
//import org.springframework.

@Entity
@Data
@Table(name = "tbl_usuarios")
public class Usuario extends AtributosGenericos{
    @NotEmpty
    @NotNull
    @Email(message = "email invalido")
    @Column(unique = true)
    private String email;

    @NotNull
    @Size(min=8, max=20, message="A senha deve conter no mínimo 8 caracteres e no máximo 20!")
    private String senha;

    private String tipo;

<<<<<<< HEAD
    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "id_usuario")
    private List<Upload> uploads;

=======
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getSenha() {
		return senha;
	}


	
	
>>>>>>> 717dd2e1a1854290badbe126bd259a1bfb988fa2
}
