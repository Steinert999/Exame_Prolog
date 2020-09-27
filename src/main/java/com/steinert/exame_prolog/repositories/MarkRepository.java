package com.steinert.exame_prolog.repositories;

import java.util.List;
import com.steinert.exame_prolog.models.Collaborator;
import com.steinert.exame_prolog.models.Mark;
import org.springframework.data.repository.query.Param;

public interface MarkRepository extends MarkAbstractRepository<Mark> {

    List<Mark> findAllByCollaborator(@Param("pCollaborator") Collaborator collaborator);
}
