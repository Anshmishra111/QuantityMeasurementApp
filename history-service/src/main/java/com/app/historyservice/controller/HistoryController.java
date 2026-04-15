package com.app.historyservice.controller;

import com.app.historyservice.dto.QuantityMeasurementDTO;
import com.app.historyservice.service.IHistoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * UC18 – History REST Controller.
 * All endpoints are READ-ONLY, served on port 8083.
 * Accessible via API Gateway at: http://localhost:8080/api/history/**
 */
@RestController
@RequestMapping("/api/history")
public class HistoryController {

    private static final Logger logger = LoggerFactory.getLogger(HistoryController.class);

    private final IHistoryService historyService;

    public HistoryController(IHistoryService historyService) {
        this.historyService = historyService;
    }

    @GetMapping
    public ResponseEntity<List<QuantityMeasurementDTO>> getAll() {
        logger.info("GET /api/history");
        return ResponseEntity.ok(historyService.getAll());
    }

    @GetMapping("/operation/{operation}")
    public ResponseEntity<List<QuantityMeasurementDTO>> getByOperation(@PathVariable String operation) {
        logger.info("GET /api/history/operation/{}", operation);
        return ResponseEntity.ok(historyService.getByOperation(operation));
    }

    @GetMapping("/type/{measurementType}")
    public ResponseEntity<List<QuantityMeasurementDTO>> getByType(@PathVariable String measurementType) {
        logger.info("GET /api/history/type/{}", measurementType);
        return ResponseEntity.ok(historyService.getByType(measurementType));
    }

    @GetMapping("/errored")
    public ResponseEntity<List<QuantityMeasurementDTO>> getErrorHistory() {
        logger.info("GET /api/history/errored");
        return ResponseEntity.ok(historyService.getErrorHistory());
    }

    @GetMapping("/count/{operation}")
    public ResponseEntity<Map<String, Object>> getCount(@PathVariable String operation) {
        logger.info("GET /api/history/count/{}", operation);
        return ResponseEntity.ok(historyService.getCount(operation));
    }
}
