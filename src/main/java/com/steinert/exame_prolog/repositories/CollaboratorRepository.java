package com.steinert.exame_prolog.repositories;

import com.steinert.exame_prolog.models.Collaborator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollaboratorRepository extends JpaRepository<Collaborator, String> {

}
