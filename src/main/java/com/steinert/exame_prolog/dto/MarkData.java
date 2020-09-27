package com.steinert.exame_prolog.dto;

import java.time.LocalDate;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MarkData {

    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate day;

    List<MarkInterval> intervals;

}
