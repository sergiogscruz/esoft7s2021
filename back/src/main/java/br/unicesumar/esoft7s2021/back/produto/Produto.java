package br.unicesumar.esoft7s2021.back.produto;

import br.unicesumar.esoft7s2021.back.cor.Cor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Produto {
    @Getter
    @Id
    @EqualsAndHashCode.Include
    private String id;
    
    @Getter
    @Setter
    private String descricao;
    
    @Getter
    @Setter
    private LocalDate lancadoEm;
    
    @Getter
    @Setter
    @Column(scale = 2)
    private BigDecimal precoUnitario;

    @Getter
    @Setter
    @ManyToOne
    private Cor corPadrao;

    public Produto() {
        this.id = UUID.randomUUID().toString();
    }

    public Produto(String descricao) {
        this();
        this.descricao = descricao;
    } 

}