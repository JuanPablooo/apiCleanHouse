package com.example.demo.model;

import org.hibernate.annotations.common.reflection.XMethod;

import javax.persistence.*;

@Entity
@Table(name = "tbl_clientes")
public class Cliente extends AtributosGenericos{


    private String nome;

    @Override
    public String toString() {
        return "Cliente{" +
                ", nome='" + nome + '\'' +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
