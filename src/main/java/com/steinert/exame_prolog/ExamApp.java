package com.steinert.exame_prolog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = "com.steinert.exame_prolog.models")
@ComponentScan({"com.steinert.exame_prolog.*"})
@EnableJpaRepositories(basePackages = {"com.steinert.exame_prolog.repositories"})
@SpringBootApplication
public class ExamApp extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ExamApp.class);
    }

    public static void main(final String[] args) {
        SpringApplication.run(ExamApp.class, args);

    }
}
