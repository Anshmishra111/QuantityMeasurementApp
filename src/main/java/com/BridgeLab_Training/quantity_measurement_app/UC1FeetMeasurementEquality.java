package com.BridgeLab_Training.quantity_measurement_app;

public class UC1FeetMeasurementEquality {

    public static boolean demonstrateLengthComparison(
            double value1, Length.LengthUnit unit1,
            double value2, Length.LengthUnit unit2) {

        Length l1 = new Length(value1, unit1);
        Length l2 = new Length(value2, unit2);

        boolean result = l1.equals(l2);

        System.out.println("Comparing: " + value1 + " " + unit1 +
                " and " + value2 + " " + unit2 +
                " → Equal? " + result);

        return result;
    }

    public static void main(String[] args) {

        // Feet ↔ Inches
        demonstrateLengthComparison(1.0, Length.LengthUnit.FEET,
                                    12.0, Length.LengthUnit.INCHES);

        // Yards ↔ Feet
        demonstrateLengthComparison(1.0, Length.LengthUnit.YARDS,
                                    3.0, Length.LengthUnit.FEET);

        // Yards ↔ Inches
        demonstrateLengthComparison(1.0, Length.LengthUnit.YARDS,
                                    36.0, Length.LengthUnit.INCHES);

        // Centimeters ↔ Inches
        demonstrateLengthComparison(1.0, Length.LengthUnit.CENTIMETERS,
                                    0.393701, Length.LengthUnit.INCHES);

        // Centimeters ↔ Feet
        demonstrateLengthComparison(30.48, Length.LengthUnit.CENTIMETERS,
                                    1.0, Length.LengthUnit.FEET);
    }
}