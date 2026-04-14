package com.app.historyservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * UC18 – History Service
 * Read-only reporting: history by operation, type, errors, count.
 * Runs on port 8083. Connects to shared H2 file DB (measurement-service's DB).
 */
@SpringBootApplication
public class HistoryServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(HistoryServiceApplication.class, args);
    }
}
