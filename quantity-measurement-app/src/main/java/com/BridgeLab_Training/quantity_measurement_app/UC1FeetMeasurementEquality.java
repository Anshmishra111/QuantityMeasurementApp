package com.BridgeLab_Training.quantity_measurement_app;

public class UC1FeetMeasurementEquality {

	 // Generic equality demo
    public static boolean demonstrateLengthEquality(Length l1, Length l2) {
        return l1.equals(l2);
    }

    public static void demonstrateFeetEquality() {
        Length f1 = new Length(1.0, Length.LengthUnit.FEET);
        Length f2 = new Length(1.0, Length.LengthUnit.FEET);

        System.out.println("Feet equal? " + f1.equals(f2));
    }

    public static void demonstrateInchesEquality() {
        Length i1 = new Length(12.0, Length.LengthUnit.INCHES);
        Length i2 = new Length(12.0, Length.LengthUnit.INCHES);

        System.out.println("Inches equal? " + i1.equals(i2));
    }

    public static void demonstrateFeetInchesComparison() {
        Length f = new Length(1.0, Length.LengthUnit.FEET);
        Length i = new Length(12.0, Length.LengthUnit.INCHES);

        System.out.println("Feet vs Inches equal? " + f.equals(i));
    }

    public static void main(String[] args) {
        demonstrateFeetEquality();
        demonstrateInchesEquality();
        demonstrateFeetInchesComparison();
    }
}