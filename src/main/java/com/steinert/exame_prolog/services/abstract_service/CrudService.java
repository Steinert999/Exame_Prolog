package com.steinert.exame_prolog.services.abstract_service;

import java.util.Optional;

public interface CrudService<E, I> {

    Optional<E> findById(I id);

}
