package com.BridgeLab_Training.quantity_measurement_app.model;

import com.BridgeLab_Training.quantity_measurement_app.enums.LengthUnit;

public class Length {

    private double value;
    private LengthUnit unit;

    public Length(double value, LengthUnit unit) {

        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");

        if (!Double.isFinite(value))
            throw new IllegalArgumentException("Invalid value");

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public LengthUnit getUnit() {
        return unit;
    }

    // Convert this value to base unit (inches)
    private double convertToBaseUnit() {
        return unit.convertToBaseUnit(value);
    }

    // Convert base unit to target unit
    private double convertFromBaseToTargetUnit(double baseValue, LengthUnit targetUnit) {
        return targetUnit.convertFromBaseUnit(baseValue);
    }

    // Conversion method
    public Length convertTo(LengthUnit targetUnit) {

        double baseValue = convertToBaseUnit();

        double convertedValue =
                convertFromBaseToTargetUnit(baseValue, targetUnit);

        return new Length(convertedValue, targetUnit);
    }

    // UC6 Addition
    public Length add(Length thatLength) {

        if (thatLength == null)
            throw new IllegalArgumentException("Length cannot be null");

        return addAndConvert(thatLength, this.unit);
    }

    // UC7 Addition with target unit
    public Length add(Length thatLength, LengthUnit targetUnit) {

        if (thatLength == null)
            throw new IllegalArgumentException("Length cannot be null");

        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        return addAndConvert(thatLength, targetUnit);
    }

    private Length addAndConvert(Length thatLength, LengthUnit targetUnit) {

        double thisBase = this.convertToBaseUnit();
        double thatBase = thatLength.convertToBaseUnit();

        double sumBase = thisBase + thatBase;

        double result =
                convertFromBaseToTargetUnit(sumBase, targetUnit);

        return new Length(result, targetUnit);
    }
    
    private boolean compare(Length thatLength) {

        double thisBase = this.convertToBaseUnit();
        double thatBase = thatLength.convertToBaseUnit();

        double epsilon = 0.0001;

        return Math.abs(thisBase - thatBase) < epsilon;
    }

//    private boolean compare(Length thatLength) {
//
//        double diff =
//                Math.abs(this.convertToBaseUnit()
//                        - thatLength.convertToBaseUnit());
//
//        return diff < 0.0001;
    

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Length that = (Length) o;

        return compare(that);
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }
}