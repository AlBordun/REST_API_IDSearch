package ru.bordun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "ru.bordun")
public class CrossSubsetsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrossSubsetsApplication.class, args);
    }

}
