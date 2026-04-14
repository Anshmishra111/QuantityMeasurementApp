package com.app.measurementservice.service;

import com.app.measurementservice.dto.QuantityMeasurementDTO;
import com.app.measurementservice.entity.QuantityDTO;

import java.util.List;

/**
 * UC18 – Service interface (same contract as UC17/UC18 monolith).
 */
public interface IQuantityMeasurementService {

    QuantityMeasurementDTO compare(QuantityDTO thisQ, QuantityDTO thatQ);
    QuantityMeasurementDTO convert(QuantityDTO thisQ, String targetUnit);
    QuantityMeasurementDTO add(QuantityDTO thisQ, QuantityDTO thatQ);
    QuantityMeasurementDTO add(QuantityDTO thisQ, QuantityDTO thatQ, String targetUnit);
    QuantityMeasurementDTO subtract(QuantityDTO thisQ, QuantityDTO thatQ);
    QuantityMeasurementDTO subtract(QuantityDTO thisQ, QuantityDTO thatQ, String targetUnit);
    QuantityMeasurementDTO divide(QuantityDTO thisQ, QuantityDTO thatQ);

    List<QuantityMeasurementDTO> getAllMeasurements();
    List<QuantityMeasurementDTO> getMeasurementsByOperation(String operation);
    List<QuantityMeasurementDTO> getMeasurementsByType(String measurementType);
    List<QuantityMeasurementDTO> getErrorHistory();
    long getOperationCount(String operation);
}
