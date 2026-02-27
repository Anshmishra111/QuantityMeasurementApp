package com.BridgeLab_Training.quantity_measurement_app;

public class UC1FeetMeasurementEquality {

    // Equality demo
    public static boolean demonstrateLengthEquality(Length l1, Length l2) {
        boolean result = l1.equals(l2);
        System.out.println("Are lengths equal? " + result);
        return result;
    }

    // UC5 → Static conversion demo
    public static Length demonstrateLengthConversion(
            double value,
            Length.LengthUnit fromUnit,
            Length.LengthUnit toUnit) {

        double convertedValue = Length.convert(value, fromUnit, toUnit);

        Length result = new Length(convertedValue, toUnit);

        System.out.println("Converted: " + value + " " + fromUnit +
                " → " + result);

        return result;
    }

    // UC5 → Overloaded conversion
    public static Length demonstrateLengthConversion(
            Length length,
            Length.LengthUnit toUnit) {

        Length converted = length.convertTo(toUnit);

        System.out.println("Converted: " + length + " → " + converted);

        return converted;
    }

    public static void main(String[] args) {

        demonstrateLengthConversion(1.0,
                Length.LengthUnit.FEET,
                Length.LengthUnit.INCHES);

        demonstrateLengthConversion(3.0,
                Length.LengthUnit.YARDS,
                Length.LengthUnit.FEET);

        demonstrateLengthConversion(36.0,
                Length.LengthUnit.INCHES,
                Length.LengthUnit.YARDS);

        Length cm = new Length(30.48, Length.LengthUnit.CENTIMETERS);
        demonstrateLengthConversion(cm, Length.LengthUnit.FEET);
    }
}
