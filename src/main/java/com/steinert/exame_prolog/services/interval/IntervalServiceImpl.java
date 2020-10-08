package com.steinert.exame_prolog.services.interval;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;
import com.steinert.exame_prolog.dto.MarkInterval;
import com.steinert.exame_prolog.models.Mark;
import com.steinert.exame_prolog.models.MarkBond;
import com.steinert.exame_prolog.models.MarkType;
import com.steinert.exame_prolog.repositories.MarkTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IntervalServiceImpl implements IntervalService {

    @Autowired
    MarkTypeRepository markTypeRepository;

    @Override
    public MarkType verifyMarkIntervalType(Mark beginMark, Mark endMark) {
        var beginMarkType = beginMark.getMarkType();
        var endMarkType = endMark.getMarkType();
        if (beginMarkType.equals(endMarkType)) {
            return beginMarkType;
        }
        throw new RuntimeException("Different Mark Types in same interval");
    }

    @Override
    public List<MarkInterval> createIntervals(List<MarkBond> bonds) {
        return bonds.stream().map(this::createInterval).collect(Collectors.toList());
    }

    @Override
    public MarkInterval createInterval(MarkBond bond) {
        var beginMark = bond.getBeginMark();
        var endMark = bond.getEndMark();
        return MarkInterval.builder().begin(beginMark.getDateTimeMark())
                .end(endMark.getDateTimeMark())
                .intervalType(verifyMarkIntervalType(beginMark, endMark).getName()).build();
    }

    @Override
    public LocalTime getTotalTime(List<MarkInterval> intervals) {
        if (!intervals.isEmpty()) {
            var minutes =
                    intervals.stream().filter(interval -> !interval.getIntervalType().equals("29"))
                            .map(interval -> ChronoUnit.NANOS.between(interval.getBegin(),
                                    interval.getEnd()))
                            .reduce(Long::sum)
                            .orElseThrow(() -> new RuntimeException("Error in sum of hours!!"));

            return LocalTime.ofNanoOfDay(minutes);
        }
        return LocalTime.MIN;
    }
}
