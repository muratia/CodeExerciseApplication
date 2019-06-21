package com.nielsensport.CodeExcercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


/**
 * The Spring Framework Application loader
 */
@SpringBootApplication
@EnableWebMvc
@EnableAutoConfiguration
@EnableJpaRepositories
public class CodeExerciseApplication {


    public static void main(String[] args) {
        SpringApplication.run (CodeExerciseApplication.class, args);
    }

}
