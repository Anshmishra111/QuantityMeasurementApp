package com.BridgeLab_Training.quantity_measurement_app.presentation;

import com.BridgeLab_Training.quantity_measurement_app.dao.*;
import com.BridgeLab_Training.quantity_measurement_app.model.QuantityDTO;
import com.BridgeLab_Training.quantity_measurement_app.service.*;

public class UC1FeetMeasurementEquality {

    public static void main(String[] args) {

        IQuantityMeasurementRepository repo =
                new QuantityMeasurementCacheRepository();

        IQuantityMeasurementService service =
                new QuantityMeasurementServiceImpl(repo);

        QuantityMeasurementController controller =
                new QuantityMeasurementController(service);

        QuantityDTO q1 = new QuantityDTO(2, "FEET", "Length");
        QuantityDTO q2 = new QuantityDTO(24, "INCHES", "Length");

        controller.add(q1, q2);

        controller.convert(q1, "INCHES");
    }
}