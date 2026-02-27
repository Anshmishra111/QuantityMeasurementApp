package com.BridgeLab_Training.quantity_measurement_app;

public class Length {

    private final double value;
    private final LengthUnit unit;

    // ✅ Base Unit = FEET
    public enum LengthUnit {

        FEET(1.0),
        INCHES(1.0 / 12.0),
        YARDS(3.0),
        CENTIMETERS(0.03280839895);

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

        if (!Double.isFinite(value))
            throw new IllegalArgumentException("Value must be finite");

        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public LengthUnit getUnit() {
        return unit;
    }

    // ✅ Convert to base unit (feet)
    private double convertToFeet() {
        return this.value * this.unit.getConversionFactor();
    }

    // ✅ UC5 → Instance conversion method
    public Length convertTo(LengthUnit targetUnit) {

        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        // Convert → Feet → Target
        double valueInFeet = convertToFeet();
        double convertedValue = valueInFeet / targetUnit.getConversionFactor();

        return new Length(convertedValue, targetUnit);
    }

    // ✅ UC5 → Static utility conversion
    public static double convert(double value,
                                 LengthUnit sourceUnit,
                                 LengthUnit targetUnit) {

        if (!Double.isFinite(value))
            throw new IllegalArgumentException("Value must be finite");

        if (sourceUnit == null || targetUnit == null)
            throw new IllegalArgumentException("Units cannot be null");

        double valueInFeet = value * sourceUnit.getConversionFactor();
        return valueInFeet / targetUnit.getConversionFactor();
    }

    // ✅ Compare
    public boolean compare(Length that) {
        return Double.compare(this.convertToFeet(), that.convertToFeet()) == 0;
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

    // ✅ hashCode
    @Override
    public int hashCode() {
        return Double.valueOf(convertToFeet()).hashCode();
    }

    // ✅ toString (nice for UC5)
    @Override
    public String toString() {
        return String.format("%.2f %s", value, unit);
    }
}
