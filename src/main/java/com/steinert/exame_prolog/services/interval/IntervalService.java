package com.steinert.exame_prolog.services.interval;

import java.time.LocalTime;
import java.util.List;
import com.steinert.exame_prolog.dto.MarkInterval;
import com.steinert.exame_prolog.models.Mark;
import com.steinert.exame_prolog.models.MarkBond;
import com.steinert.exame_prolog.models.MarkType;

public interface IntervalService {

    MarkType verifyMarkIntervalType(Mark beginMark, Mark endMark);

    List<MarkInterval> createIntervals(List<MarkBond> bonds);

    MarkInterval createInterval(MarkBond bond);

    LocalTime getTotalTime(List<MarkInterval> intervals);

}
