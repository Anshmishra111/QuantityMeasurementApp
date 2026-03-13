package com.BridgeLab_Training.quantity_measurement_app.service;

import com.BridgeLab_Training.quantity_measurement_app.dao.IQuantityMeasurementRepository;
import com.BridgeLab_Training.quantity_measurement_app.model.*;
import com.BridgeLab_Training.quantity_measurement_app.util.QuantityMeasurementException;

public class QuantityMeasurementServiceImpl
        implements IQuantityMeasurementService {

    private IQuantityMeasurementRepository repo;

    public QuantityMeasurementServiceImpl(IQuantityMeasurementRepository repo) {
        this.repo = repo;
    }

    public QuantityDTO convert(QuantityDTO dto, String targetUnit) {

        if (dto.unit.equals("FEET") && targetUnit.equals("INCHES")) {

            double result = dto.value * 12;

            repo.save(new QuantityMeasurementEntity(
                    dto.value, dto.unit,
                    result, targetUnit,
                    "CONVERT"));

            return new QuantityDTO(result, targetUnit, dto.type);
        }

        throw new QuantityMeasurementException("Conversion not supported");
    }

    public QuantityDTO add(QuantityDTO q1, QuantityDTO q2) {

        double result = q1.value + q2.value;

        repo.save(new QuantityMeasurementEntity(
                q1.value, q1.unit,
                result, q1.unit,
                "ADD"));

        return new QuantityDTO(result, q1.unit, q1.type);
    }
}