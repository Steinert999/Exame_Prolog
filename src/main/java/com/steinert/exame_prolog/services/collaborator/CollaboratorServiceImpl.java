package com.steinert.exame_prolog.services.collaborator;

import java.util.Optional;
import com.steinert.exame_prolog.models.Collaborator;
import com.steinert.exame_prolog.repositories.CollaboratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollaboratorServiceImpl implements CollaboratorService {

    @Autowired
    private CollaboratorRepository repository;

    @Override
    public Optional<Collaborator> findById(String id) {
        return this.repository.findById(id);
    }

}
