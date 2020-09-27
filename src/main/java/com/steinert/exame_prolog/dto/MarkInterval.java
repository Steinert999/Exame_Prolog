package com.steinert.exame_prolog.dto;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MarkInterval {

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    LocalDateTime begin;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    LocalDateTime end;
    String intervalType;

}
