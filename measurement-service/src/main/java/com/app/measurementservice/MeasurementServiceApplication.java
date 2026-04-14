package com.app.measurementservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * UC18 – Measurement Service
 * Core business logic: compare, convert, add, subtract, divide.
 * Runs on port 8082. Uses auto-server H2 file DB shared with history-service.
 */
@SpringBootApplication
public class MeasurementServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(MeasurementServiceApplication.class, args);
    }
}
