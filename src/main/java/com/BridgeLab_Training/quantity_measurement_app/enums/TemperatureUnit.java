package com.BridgeLab_Training.quantity_measurement_app.enums;

import com.BridgeLab_Training.quantity_measurement_app.util.IMeasurable;
import com.BridgeLab_Training.quantity_measurement_app.util.SupportsArithmetic;

public enum TemperatureUnit implements IMeasurable {

    CELSIUS,
    FAHRENHEIT;

    SupportsArithmetic supportsArithmetic = () -> false;

    public String getUnitName() {
        return name();
    }

    public double getConversionFactor() {
        return 1.0;
    }

    public double convertToBaseUnit(double value) {

        if (this == FAHRENHEIT)
            return (value - 32) * 5 / 9;

        return value;
    }

    public double convertFromBaseUnit(double baseValue) {

        if (this == FAHRENHEIT)
            return (baseValue * 9 / 5) + 32;

        return baseValue;
    }

    @Override
    public void validateOperationSupport(String operation) {
        if (!supportsArithmetic.isSupported())
            throw new UnsupportedOperationException(
                    "Temperature does not support " + operation);
    }
}