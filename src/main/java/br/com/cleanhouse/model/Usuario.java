package br.com.cleanhouse.model;

import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
//import org.springframework.

@Entity
@Data
@Table(name = "tbl_usuarios")
public class Usuario extends AtributosGenericos{
    @NotEmpty
    @NotNull
    @Email(message = "email invalido")
//    @Column(unique = true)
    private String email;

    @NotNull
    @Size(min=8, max=20, message="A senha deve conter no mínimo 8 caracteres e no máximo 20!")
    private String senha;

    private String tipo;

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


	
	
}
