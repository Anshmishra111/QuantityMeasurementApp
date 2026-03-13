package com.BridgeLab_Training.quantity_measurement_app.presentation;

import com.BridgeLab_Training.quantity_measurement_app.model.QuantityDTO;
import com.BridgeLab_Training.quantity_measurement_app.service.IQuantityMeasurementService;

public class QuantityMeasurementController {

    private IQuantityMeasurementService service;

    public QuantityMeasurementController(IQuantityMeasurementService service) {
        this.service = service;
    }

    public void convert(QuantityDTO dto, String target) {

        QuantityDTO result = service.convert(dto, target);

        System.out.println(dto.value + " " + dto.unit +
                " = " + result.value + " " + result.unit);
    }

    public void add(QuantityDTO q1, QuantityDTO q2) {

        QuantityDTO result = service.add(q1, q2);

        System.out.println(q1.value + " + " + q2.value + " = " + result.value);
    }
}