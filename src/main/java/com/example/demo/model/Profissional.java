package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "tbl_profissionais")
public class Profissional extends AtributosGenericos{


    private String nome;


    @Override
    public String toString() {
        return "Profissional{" +
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
