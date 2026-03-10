package com.BridgeLab_Training.quantity_measurement_app;
public interface IMeasurable {

    // Default lambda: all units support arithmetic
    SupportsArithmetic supportsArithmetic = () -> true;

    // Mandatory methods
    String getUnitName();

    double getConversionFactor();

    double convertToBaseUnit(double value);

    double convertFromBaseUnit(double baseValue);

    // Optional support method
    default boolean supportsArithmetic() {
        return supportsArithmetic.isSupported();
    }

    // Optional validation method
    default void validateOperationSupport(String operation) {
        // Default: allow operation
    }
}