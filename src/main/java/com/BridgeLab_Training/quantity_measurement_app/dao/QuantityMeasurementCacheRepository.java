package com.BridgeLab_Training.quantity_measurement_app.dao;

import java.util.ArrayList;
import java.util.List;

import  com.BridgeLab_Training.quantity_measurement_app.model.QuantityMeasurementEntity;

public class QuantityMeasurementCacheRepository
        implements IQuantityMeasurementRepository {

    private List<QuantityMeasurementEntity> cache = new ArrayList<>();

    public void save(QuantityMeasurementEntity entity) {
        cache.add(entity);
    }

    public List<QuantityMeasurementEntity> getAll() {
        return cache;
    }
}