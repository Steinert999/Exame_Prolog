package com.steinert.exame_prolog.models;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity()
@Table(name = "marcacao")
@Getter
@NoArgsConstructor
public class Mark extends MarkAbstractEntity {

        @ManyToOne
        @JoinColumn(name = "cod_tipo_marcacao",
                        foreignKey = @ForeignKey(name = "fk_marcacao_marcacao_tipo",
                                        value = ConstraintMode.CONSTRAINT),
                        referencedColumnName = "codigo", nullable = false)
        private MarkType markType;

        @ManyToOne
        @JoinColumn(name = "cpf_colaborador",
                        foreignKey = @ForeignKey(name = "fk_intervalo_colaborador",
                                        value = ConstraintMode.CONSTRAINT),
                        referencedColumnName = "cpf", nullable = false)
        private Collaborator collaborator;

        @Column(name = "data_hora_marcacao", nullable = false)
        private LocalDateTime dateTimeMark;

        @Enumerated(EnumType.STRING)
        @Column(name = "tipo_marcacao")
        private MarkEnumType markEnumType;


        @Builder
        public Mark(Long code, MarkType markType, Collaborator collaborator,
                        LocalDateTime dateTimeMark, MarkEnumType markEnumType) {
                super(code);
                this.markType = markType;
                this.collaborator = collaborator;
                this.dateTimeMark = dateTimeMark;
                this.markEnumType = markEnumType;
        }


        private enum MarkEnumType {
                MARCACAO_FIM, MARCACAO_INICIO;
        }

}
