package com.BridgeLab_Training.quantity_measurement_app.dao;

import java.util.List;
import com.BridgeLab_Training.quantity_measurement_app.model.QuantityMeasurementEntity;

public interface IQuantityMeasurementRepository {

    void save(QuantityMeasurementEntity entity);

    List<QuantityMeasurementEntity> getAll();
}