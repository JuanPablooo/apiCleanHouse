package br.com.cleanhouse.model;

import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

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
<<<<<<< HEAD
public class Usuario{

=======
public class Usuario extends AtributosGenericos{
>>>>>>> juan
    @NotEmpty
    @NotNull
    @Email(message = "email invalido")
    private String email;

    @NotNull
    @Size(min=8, max=20, message="A senha deve conter no mínimo 8 caracteres e no máximo 20!")
    private String senha;

<<<<<<< HEAD
=======
    private String tipo;
>>>>>>> juan
}
