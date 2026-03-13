package com.BridgeLab_Training.quantity_measurement_app.model;

import com.BridgeLab_Training.quantity_measurement_app.enums.WeightUnit;

public class Weight {

    private final double value;
    private final WeightUnit unit;

    public Weight(double value, WeightUnit unit) {

        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");

        if (Double.isNaN(value) || Double.isInfinite(value))
            throw new IllegalArgumentException("Invalid value");

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public WeightUnit getUnit() {
        return unit;
    }

    // convert to base unit (kilogram)
    private double convertToBaseUnit() {
        return unit.convertToBaseUnit(value);
    }

    // convert to target unit
    public Weight convertTo(WeightUnit targetUnit) {

        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        double base = convertToBaseUnit();
        double converted = targetUnit.convertFromBaseUnit(base);

        return new Weight(converted, targetUnit);
    }

    // add two weights (result in first unit)
    public Weight add(Weight thatWeight) {

        double sumBase = this.convertToBaseUnit() + thatWeight.convertToBaseUnit();
        double result = this.unit.convertFromBaseUnit(sumBase);

        return new Weight(result, this.unit);
    }

    // add with target unit
    public Weight add(Weight thatWeight, WeightUnit targetUnit) {

        double sumBase = this.convertToBaseUnit() + thatWeight.convertToBaseUnit();
        double result = targetUnit.convertFromBaseUnit(sumBase);

        return new Weight(result, targetUnit);
    }

    private boolean compare(Weight thatWeight) {
        return Double.compare(this.convertToBaseUnit(),
                thatWeight.convertToBaseUnit()) == 0;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (obj == null) return false;

        if (getClass() != obj.getClass()) return false;

        Weight that = (Weight) obj;

        return this.compare(that);
    }

    @Override
    public int hashCode() {
        return Double.valueOf(convertToBaseUnit()).hashCode();
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }
}