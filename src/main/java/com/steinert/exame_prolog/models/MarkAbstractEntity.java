package com.steinert.exame_prolog.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@AllArgsConstructor
@NoArgsConstructor
public abstract class MarkAbstractEntity {

    @Id
    @Column(name = "codigo", nullable = false)
    private Long code;

}
