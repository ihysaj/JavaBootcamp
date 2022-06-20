package com.teamsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApplication{

    public static void main(String[] args) {
        System.out.println("Hello world!");
        SpringApplication.run(MainApplication.class, args);
    }

}