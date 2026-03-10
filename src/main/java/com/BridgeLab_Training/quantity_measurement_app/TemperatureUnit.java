package com.BridgeLab_Training.quantity_measurement_app;

import java.util.function.Function;

public enum TemperatureUnit implements IMeasurable {

    CELSIUS(false),
    FAHRENHEIT(true);

    private final Function<Double, Double> conversionValue;

    // Temperature should NOT support arithmetic
    SupportsArithmetic supportsArithmetic = () -> false;

    TemperatureUnit(boolean isFahrenheit) {

        if (isFahrenheit) {
            conversionValue = (fahrenheit) -> (fahrenheit - 32) * 5 / 9;
        } else {
            conversionValue = (celsius) -> celsius;
        }
    }

    @Override
    public String getUnitName() {
        return this.name();
    }

    @Override
    public double getConversionFactor() {
        return 1.0;
    }

    @Override
    public double convertToBaseUnit(double value) {
        return conversionValue.apply(value);
    }

    @Override
    public double convertFromBaseUnit(double baseValue) {
        if (this == FAHRENHEIT) {
            return (baseValue * 9 / 5) + 32;
        }
        return baseValue;
    }

    @Override
    public boolean supportsArithmetic() {
        return supportsArithmetic.isSupported();
    }

    @Override
    public void validateOperationSupport(String operation) {

        if (!supportsArithmetic.isSupported()) {
            throw new UnsupportedOperationException(
                    this.name() + " does not support " + operation + " operations.");
        }
    }

    @Override
    public String toString() {
        return getUnitName();
    }
}