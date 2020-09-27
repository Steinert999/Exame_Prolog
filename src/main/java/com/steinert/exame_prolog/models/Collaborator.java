package com.steinert.exame_prolog.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.br.CPF;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "colaborador")
@NoArgsConstructor
public class Collaborator {

    @Id
    @Column(unique = true, updatable = false, nullable = false)
    @CPF(message = "CPF inválido")
    private String cpf;

    @Column(name = "nome", length = 255, nullable = false)
    private String name;

    @Builder
    public Collaborator(@CPF(message = "CPF inválido") String cpf, String name) {
        this.cpf = cpf;
        this.name = name;
    }


}
