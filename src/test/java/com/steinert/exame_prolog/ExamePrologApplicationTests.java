package com.steinert.exame_prolog;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import com.steinert.exame_prolog.dto.MarkData;
import com.steinert.exame_prolog.models.Collaborator;
import com.steinert.exame_prolog.services.mark_data.MarkDataService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ExamePrologApplicationTests {

	@Autowired
	private MarkDataService service;

	@Test
	void contextLoads() {
		LocalDateTime date = LocalDateTime.of(LocalDate.of(2019, 03, 01), LocalTime.MIN);
		var joao = Collaborator.builder().cpf("00187832013").name("João da Silva").build();
		MarkData data = this.service.getDataPerCollaboratorAndDay(joao, date);
		assertNotNull(data);
	}

}
