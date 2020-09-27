package com.steinert.exame_prolog.services.mark_data;

import java.time.LocalDateTime;
import com.steinert.exame_prolog.dto.MarkData;
import com.steinert.exame_prolog.models.Collaborator;

public interface MarkDataService {

    MarkData getDataPerCollaboratorAndDay(Collaborator collaborator, LocalDateTime day);

}
