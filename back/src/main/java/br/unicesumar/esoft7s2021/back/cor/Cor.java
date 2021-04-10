package br.unicesumar.esoft7s2021.back.cor;

import java.util.UUID;

import lombok.Data;

@Data
public class Cor {
    private String id;
    private String sigla;
    private String nome;
    private String apelido;

    public Cor() {
        this.id = UUID.randomUUID().toString();
    }

    public Cor(String nome, String sigla) {
        this();
        this.nome = nome;
        this.sigla = sigla;
    }

    public String getId() {
        return this.id;
    }

    public String getSigla() {
        return this.sigla;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    } 
}

