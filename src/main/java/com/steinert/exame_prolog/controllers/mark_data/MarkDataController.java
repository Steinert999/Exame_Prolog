package com.steinert.exame_prolog.controllers.mark_data;

import java.time.LocalDateTime;
import java.time.LocalTime;
import com.steinert.exame_prolog.dto.MarkData;
import com.steinert.exame_prolog.dto.RequestMarkData;
import com.steinert.exame_prolog.models.Collaborator;
import com.steinert.exame_prolog.services.collaborator.CollaboratorService;
import com.steinert.exame_prolog.services.mark_data.MarkDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("marks")
public class MarkDataController {

    @Autowired
    private MarkDataService markDataService;

    @Autowired
    private CollaboratorService collaboratorService;

    @GetMapping()
    @ResponseBody
    public MarkData getMarkDataByCpf(@Validated @RequestBody RequestMarkData requestMarkData) {
        Collaborator collaborator =
                this.collaboratorService.findById(requestMarkData.getCpf()).orElseThrow();
        LocalDateTime time = LocalDateTime.of(requestMarkData.getDate(), LocalTime.MIN);
        return this.markDataService.getDataPerCollaboratorAndDay(collaborator, time);
    }
}
