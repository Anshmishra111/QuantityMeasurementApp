package com.BridgeLab_Training.quantity_measurement_app.model;

import java.io.Serializable;

public class QuantityMeasurementEntity implements Serializable {

    public double thisValue;
    public String thisUnit;
    public double resultValue;
    public String resultUnit;
    public String operation;

    public QuantityMeasurementEntity(double thisValue, String thisUnit,
                                     double resultValue, String resultUnit,
                                     String operation) {

        this.thisValue = thisValue;
        this.thisUnit = thisUnit;
        this.resultValue = resultValue;
        this.resultUnit = resultUnit;
        this.operation = operation;
    }
}