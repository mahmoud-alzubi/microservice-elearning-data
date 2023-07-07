package com.mtech.elearning;

import com.mtech.elearning.entity.*;
import com.mtech.elearning.repository.InstructorDetailRepositoryImpl;
import com.mtech.elearning.service.InstructorDetailServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ElearningApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElearningApplication.class, args);
    }


}
