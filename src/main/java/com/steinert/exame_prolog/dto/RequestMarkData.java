package com.steinert.exame_prolog.dto;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestMarkData {

    String cpf;


    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate date;

    @Builder
    public RequestMarkData(String cpf, LocalDate date) {
        this.cpf = cpf;
        this.date = date;
    }
}
