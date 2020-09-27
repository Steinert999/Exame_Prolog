package com.steinert.exame_prolog.repositories;

import java.time.LocalDateTime;
import java.util.List;
import com.steinert.exame_prolog.models.Collaborator;
import com.steinert.exame_prolog.models.MarkBond;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MarkBondRepository extends MarkAbstractRepository<MarkBond> {


        @Query("select mb from MarkBond mb" + " join fetch mb.beginMark beginMark"
                        + " join fetch mb.endMark endMark"
                        + " where beginMark.collaborator = :pCollaborator"
                        + " and endMark.collaborator = :pCollaborator"
                        + " and beginMark.dateTimeMark between :pBeginDate and :pEndDate"
                        + " and endMark.dateTimeMark between :pBeginDate and :pEndDate")
        List<MarkBond> findBondByCollaborator(@Param("pCollaborator") Collaborator collaborator,
                        @Param("pBeginDate") LocalDateTime begin,
                        @Param("pEndDate") LocalDateTime end);
}
