package com.BridgeLab_Training.quantity_measurement_app;

import java.util.Objects;

public class Quantity<U extends IMeasurable> {

    private final double value;
    private final U unit;

    public Quantity(double value, U unit) {

        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public U getUnit() {
        return unit;
    }

    //  EQUALITY 
    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (!(obj instanceof Quantity<?> other))
            return false;

        if (!this.unit.getClass().equals(other.unit.getClass()))
            return false;

        double thisBase = unit.convertToBaseUnit(value);
        double otherBase = other.unit.convertToBaseUnit(other.value);

        return Math.abs(thisBase - otherBase) < 0.0001;
    }

    //  CONVERSION 
    public Quantity<U> convertTo(U targetUnit) {

        if (!unit.getClass().equals(targetUnit.getClass())) {
            throw new IllegalArgumentException("Incompatible unit types");
        }

        double baseValue = unit.convertToBaseUnit(value);
        double converted = targetUnit.convertFromBaseUnit(baseValue);

        return new Quantity<>(converted, targetUnit);
    }

    //  ADD 
    public Quantity<U> add(Quantity<U> other) {

        unit.validateOperationSupport("addition");

        double base1 = unit.convertToBaseUnit(value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        double result = base1 + base2;

        double converted = unit.convertFromBaseUnit(result);

        return new Quantity<>(converted, unit);
    }

    //  SUBTRACT 
    public Quantity<U> subtract(Quantity<U> other) {

        unit.validateOperationSupport("subtraction");

        double base1 = unit.convertToBaseUnit(value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        double result = base1 - base2;

        double converted = unit.convertFromBaseUnit(result);

        return new Quantity<>(converted, unit);
    }

    //  DIVIDE 
    public double divide(Quantity<U> other) {

        unit.validateOperationSupport("division");

        double base1 = unit.convertToBaseUnit(value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        if (base2 == 0)
            throw new ArithmeticException("Division by zero");

        return base1 / base2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(unit.convertToBaseUnit(value));
    }

    @Override
    public String toString() {
        return "Quantity{" + value + " " + unit + "}";
    }
}