package com.app.measurementservice.controller;

import com.app.measurementservice.dto.QuantityMeasurementDTO;
import com.app.measurementservice.dto.request.ArithmeticRequestDTO;
import com.app.measurementservice.dto.request.CompareRequestDTO;
import com.app.measurementservice.dto.request.ConvertRequestDTO;
import com.app.measurementservice.service.IQuantityMeasurementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * UC18 – Measurement REST Controller.
 * Handles mathematical operations on quantity measurements.
 * History endpoints are now also here for backward compatibility.
 * The history-service (port 8083) provides the same via /api/history/*.
 */
@RestController
@RequestMapping("/api/measurements")
@Tag(name = "Quantity Measurements", description = "REST API for quantity measurement operations")
public class QuantityMeasurementController {

    private static final Logger logger = LoggerFactory.getLogger(QuantityMeasurementController.class);

    private final IQuantityMeasurementService service;

    public QuantityMeasurementController(IQuantityMeasurementService service) {
        this.service = service;
    }

    // ── POST operations ──────────────────────────────────────────

    @PostMapping("/compare")
    @Operation(summary = "Compare two quantities")
    public ResponseEntity<QuantityMeasurementDTO> compare(@Valid @RequestBody CompareRequestDTO req) {
        logger.info("POST /compare");
        return ResponseEntity.ok(service.compare(req.getThisQuantity(), req.getThatQuantity()));
    }

    @PostMapping("/convert")
    @Operation(summary = "Convert a quantity to a different unit")
    public ResponseEntity<QuantityMeasurementDTO> convert(@Valid @RequestBody ConvertRequestDTO req) {
        logger.info("POST /convert");
        return ResponseEntity.ok(service.convert(req.getThisQuantity(), req.getTargetUnit()));
    }

    @PostMapping("/add")
    @Operation(summary = "Add two quantities")
    public ResponseEntity<QuantityMeasurementDTO> add(@Valid @RequestBody ArithmeticRequestDTO req) {
        logger.info("POST /add");
        QuantityMeasurementDTO result = req.getTargetUnit() != null
                ? service.add(req.getThisQuantity(), req.getThatQuantity(), req.getTargetUnit())
                : service.add(req.getThisQuantity(), req.getThatQuantity());
        return ResponseEntity.ok(result);
    }

    @PostMapping("/subtract")
    @Operation(summary = "Subtract two quantities")
    public ResponseEntity<QuantityMeasurementDTO> subtract(@Valid @RequestBody ArithmeticRequestDTO req) {
        logger.info("POST /subtract");
        QuantityMeasurementDTO result = req.getTargetUnit() != null
                ? service.subtract(req.getThisQuantity(), req.getThatQuantity(), req.getTargetUnit())
                : service.subtract(req.getThisQuantity(), req.getThatQuantity());
        return ResponseEntity.ok(result);
    }

    @PostMapping("/divide")
    @Operation(summary = "Divide two quantities")
    public ResponseEntity<QuantityMeasurementDTO> divide(@Valid @RequestBody ArithmeticRequestDTO req) {
        logger.info("POST /divide");
        return ResponseEntity.ok(service.divide(req.getThisQuantity(), req.getThatQuantity()));
    }

    // ── GET history (kept here for backward compat) ──────────────

    @GetMapping("/history")
    @Operation(summary = "Get all measurement history")
    public ResponseEntity<List<QuantityMeasurementDTO>> getHistory() {
        return ResponseEntity.ok(service.getAllMeasurements());
    }

    @GetMapping("/history/{operation}")
    @Operation(summary = "Get history by operation type")
    public ResponseEntity<List<QuantityMeasurementDTO>> getByOperation(
            @Parameter(description = "Operation type e.g. COMPARE, ADD")
            @PathVariable String operation) {
        return ResponseEntity.ok(service.getMeasurementsByOperation(operation.toUpperCase()));
    }

    @GetMapping("/history/type/{measurementType}")
    @Operation(summary = "Get history by measurement type")
    public ResponseEntity<List<QuantityMeasurementDTO>> getByType(
            @PathVariable String measurementType) {
        return ResponseEntity.ok(service.getMeasurementsByType(measurementType));
    }

    @GetMapping("/history/errored")
    @Operation(summary = "Get all error records")
    public ResponseEntity<List<QuantityMeasurementDTO>> getErrorHistory() {
        return ResponseEntity.ok(service.getErrorHistory());
    }

    @GetMapping("/count/{operation}")
    @Operation(summary = "Count successful operations by type")
    public ResponseEntity<Map<String, Object>> getOperationCount(
            @PathVariable String operation) {
        return ResponseEntity.ok(Map.of(
                "operation", operation.toUpperCase(),
                "count",     service.getOperationCount(operation)));
    }
}
