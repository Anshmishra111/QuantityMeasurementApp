package com.BridgeLab_Training.quantity_measurement_app.enums;

import com.BridgeLab_Training.quantity_measurement_app.util.IMeasurable;

public enum LengthUnit implements IMeasurable {

    FEET(1.0),
    INCHES(1.0 / 12.0),
    YARD(3.0),
    CENTIMETER(0.0328084);

    private final double factor;

    LengthUnit(double factor) {
        this.factor = factor;
    }

    public String getUnitName() {
        return name();
    }

    public double getConversionFactor() {
        return factor;
    }

    public double convertToBaseUnit(double value) {
        return value * factor;
    }

    public double convertFromBaseUnit(double baseValue) {
        return baseValue / factor;
    }
}