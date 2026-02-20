package com.BridgeLab_Training.quantity_measurement_app;

public class Length {

    private final double value;
    private final LengthUnit unit;

    // ✅ Base Unit = FEET
    public enum LengthUnit {

        FEET(1.0),
        INCHES(1.0 / 12.0),     // 12 inches = 1 foot
        YARDS(3.0),             // 1 yard = 3 feet
        CENTIMETERS(0.03280839895); // 1 cm = 0.0328084 feet

        private final double conversionFactor;

        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double getConversionFactor() {
            return conversionFactor;
        }
    }

    // ✅ Constructor
    public Length(double value, LengthUnit unit) {
        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");

        this.value = value;
        this.unit = unit;
    }

    // ✅ Convert to Base Unit (Feet)
    private double convertToFeet() {
        return this.value * this.unit.getConversionFactor();
    }

    // ✅ Compare method
    public boolean compare(Length that) {
    	double diff = Math.abs(this.convertToFeet() - that.convertToFeet());
        return diff < 0.0001; 
    }

    // ✅ equals override
    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        Length other = (Length) obj;
        return this.compare(other);
    }

    // ✅ hashCode (important with equals)
    @Override
    public int hashCode() {
        return Double.valueOf(convertToFeet()).hashCode();
    }
}