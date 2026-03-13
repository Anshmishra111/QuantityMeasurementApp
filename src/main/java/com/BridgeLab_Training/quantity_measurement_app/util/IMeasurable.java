package com.BridgeLab_Training.quantity_measurement_app.util;

public interface IMeasurable {

    SupportsArithmetic supportsArithmetic = () -> true;

    String getUnitName();

    double getConversionFactor();

    double convertToBaseUnit(double value);

    double convertFromBaseUnit(double baseValue);

    default boolean supportsArithmetic() {
        return supportsArithmetic.isSupported();
    }

    default void validateOperationSupport(String operation) {
        // default: allow all operations
    }
}