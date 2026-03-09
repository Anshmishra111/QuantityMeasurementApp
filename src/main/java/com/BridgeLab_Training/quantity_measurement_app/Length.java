package com.BridgeLab_Training.quantity_measurement_app;

public class Length {

    private double value;
    private LengthUnit unit;

    public enum LengthUnit {

        FEET(1.0),
        INCHES(1.0 / 12.0),
        YARDS(3.0),
        CENTIMETERS(0.0328084);

        private final double conversionFactor;

        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double getConversionFactor() {
            return conversionFactor;
        }
    }

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

    // Convert to base unit (feet)
    private double convertToBaseUnit() {
        return value * unit.getConversionFactor();
    }

    // Convert from base unit to target unit
    private double convertFromBase(double baseValue, LengthUnit targetUnit) {
        return baseValue / targetUnit.getConversionFactor();
    }

    // UC5 Conversion
    public Length convertTo(LengthUnit targetUnit) {

        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        double base = convertToBaseUnit();
        double result = convertFromBase(base, targetUnit);

        return new Length(result, targetUnit);
    }

    // UC6 Addition
    public Length add(Length thatLength) {

        if (thatLength == null)
            throw new IllegalArgumentException("Length cannot be null");

        double thisBase = this.convertToBaseUnit();
        double thatBase = thatLength.convertToBaseUnit();

        double sumBase = thisBase + thatBase;

        double result = convertFromBase(sumBase, this.unit);

        return new Length(result, this.unit);
    }

    // Compare helper
    private boolean compare(Length thatLength) {
        return Double.compare(
                this.convertToBaseUnit(),
                thatLength.convertToBaseUnit()) == 0;
    }

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
        return String.format("%.2f %s", value, unit);
    }
}