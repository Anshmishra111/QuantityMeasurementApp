package com.BridgeLab_Training.quantity_measurement_app.service;

import com.BridgeLab_Training.quantity_measurement_app.model.QuantityDTO;

public interface IQuantityMeasurementService {

    QuantityDTO convert(QuantityDTO dto, String targetUnit);

    QuantityDTO add(QuantityDTO q1, QuantityDTO q2);
}