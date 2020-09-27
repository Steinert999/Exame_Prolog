package com.steinert.exame_prolog.services.mark_data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import com.steinert.exame_prolog.dto.MarkData;
import com.steinert.exame_prolog.dto.MarkInterval;
import com.steinert.exame_prolog.models.Collaborator;
import com.steinert.exame_prolog.models.Mark;
import com.steinert.exame_prolog.models.MarkType;
import com.steinert.exame_prolog.repositories.MarkBondRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarkDataServiceImpl implements MarkDataService {


    @Autowired
    MarkBondRepository markBondRepository;

    @Override
    public MarkData getDataPerCollaboratorAndDay(Collaborator collaborator, LocalDateTime day) {
        var bonds =
                this.markBondRepository.findBondByCollaborator(collaborator, day, day.plusDays(1));

        List<MarkInterval> intervals = bonds.stream().map(bond -> {
            var beginMark = bond.getBeginMark();
            var endMark = bond.getEndMark();
            return MarkInterval.builder().begin(beginMark.getDateTimeMark())
                    .end(endMark.getDateTimeMark())
                    .intervalType(verifyMarkIntervalType(beginMark, endMark).getName()).build();
        }).collect(Collectors.toList());

        return MarkData.builder().day(day.toLocalDate()).intervals(intervals).build();

    }

    private MarkType verifyMarkIntervalType(Mark beginMark, Mark endMark) {
        var beginMarkType = beginMark.getMarkType();
        var endMarkType = endMark.getMarkType();
        if (beginMarkType.equals(endMarkType)) {
            return beginMarkType;
        }
        throw new RuntimeException("Different Mark Types in same interval");
    }

}
