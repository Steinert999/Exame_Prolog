package com.steinert.exame_prolog.models;

import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "marcacao_vinculo_inicio_fim")
@Getter
@NoArgsConstructor
public class MarkBond extends MarkAbstractEntity {


        @OneToOne
        @JoinColumn(name = "cod_marcacao_inicio",
                        foreignKey = @ForeignKey(name = "fk_marcacao_vinculo_marcacao_inicio",
                                        value = ConstraintMode.CONSTRAINT),
                        referencedColumnName = "codigo", nullable = false)
        private Mark beginMark;

        @OneToOne
        @JoinColumn(name = "cod_marcacao_fim",
                        foreignKey = @ForeignKey(name = "fk_marcacao_vinculo_marcacao_fim",
                                        value = ConstraintMode.CONSTRAINT),
                        referencedColumnName = "codigo", nullable = false)
        private Mark endMark;

        @Builder
        public MarkBond(Long code, Mark beginMark, Mark endMark) {
                super(code);
                this.beginMark = beginMark;
                this.endMark = endMark;
        }
}
