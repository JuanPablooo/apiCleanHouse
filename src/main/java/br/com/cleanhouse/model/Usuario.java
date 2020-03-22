package br.com.cleanhouse.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "tbl_usuario")
public class Usuario extends AtributosGenericos {

    @NotNull
    @Email
    private String email;

    private String senha;
}
