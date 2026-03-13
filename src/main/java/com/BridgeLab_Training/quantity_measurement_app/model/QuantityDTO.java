package com.BridgeLab_Training.quantity_measurement_app.model;

public class QuantityDTO {

    public double value;
    public String unit;
    public String type;

    public QuantityDTO(double value, String unit, String type) {
        this.value = value;
        this.unit = unit;
        this.type = type;
    }
}