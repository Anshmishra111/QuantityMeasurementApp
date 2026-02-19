package com.BridgeLab_Training.quantity_measurement_app;

public class Length {

    private final double value;
    private final LengthUnit unit;

    // ✅ Enum for Units (Base Unit = FEET)
    public enum LengthUnit {
        FEET(1.0),
        INCHES(1.0 / 12.0);   // 12 inches = 1 foot

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

    // ✅ Compare Method
    public boolean compare(Length that) {
        return Double.compare(this.convertToFeet(), that.convertToFeet()) == 0;
    }

    // ✅ equals() Override
    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        Length other = (Length) obj;
        return this.compare(other);
    }

    // ✅ hashCode() (Important with equals)
    @Override
    public int hashCode() {
        return Double.valueOf(convertToFeet()).hashCode();
    }
}