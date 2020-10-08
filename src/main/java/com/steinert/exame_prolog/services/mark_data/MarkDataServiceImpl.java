package com.steinert.exame_prolog.services.mark_data;

import java.time.LocalDateTime;
import java.util.List;
import com.steinert.exame_prolog.dto.MarkData;
import com.steinert.exame_prolog.dto.MarkInterval;
import com.steinert.exame_prolog.models.Collaborator;
import com.steinert.exame_prolog.repositories.MarkBondRepository;
import com.steinert.exame_prolog.services.interval.IntervalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarkDataServiceImpl implements MarkDataService {


    @Autowired
    MarkBondRepository markBondRepository;

    @Autowired
    IntervalService intervalService;

    @Override
    public MarkData getDataPerCollaboratorAndDay(Collaborator collaborator, LocalDateTime day) {
        var bonds =
                this.markBondRepository.findBondByCollaborator(collaborator, day, day.plusDays(1));

        List<MarkInterval> intervals = this.intervalService.createIntervals(bonds);

        return MarkData.builder().day(day.toLocalDate()).intervals(intervals).build();

    }
}
