package com.steinert.exame_prolog.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "marcacao_tipo")
@Getter
@NoArgsConstructor
public class MarkType extends MarkAbstractEntity {

    @Column(name = "nome", nullable = false)
    private String name;

    @Column(name = "tempo_recomendado_minutos")
    private Long recomendedTime;

    @Builder
    public MarkType(Long code, String name, Long recomendedTime) {
        super(code);
        this.name = name;
        this.recomendedTime = recomendedTime;
    }

}
