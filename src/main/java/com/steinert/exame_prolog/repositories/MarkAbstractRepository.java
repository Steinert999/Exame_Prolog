package com.steinert.exame_prolog.repositories;

import com.steinert.exame_prolog.models.MarkAbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MarkAbstractRepository<R extends MarkAbstractEntity>
                extends JpaRepository<R, Long> {

}
