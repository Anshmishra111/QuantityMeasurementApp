package com.BridgeLab_Training.quantity_measurement_app;

public class UC1FeetMeasurementEquality{

    public static <U extends IMeasurable> boolean demonstrateEquality(
            Quantity<U> q1, Quantity<U> q2) {

        return q1.equals(q2);
    }

    public static <U extends IMeasurable> Quantity<U> demonstrateConversion(
            Quantity<U> quantity, U targetUnit) {

        double converted = quantity.convertTo(targetUnit);
        return new Quantity<>(converted, targetUnit);
    }

    public static <U extends IMeasurable> Quantity<U> demonstrateAddition(
            Quantity<U> q1, Quantity<U> q2) {

        return q1.add(q2);
    }

    public static <U extends IMeasurable> Quantity<U> demonstrateAddition(
            Quantity<U> q1, Quantity<U> q2, U targetUnit) {

        return q1.add(q2, targetUnit);
    }

    public static void main(String[] args) {

        Quantity<LengthUnit> feet = new Quantity<>(1, LengthUnit.FEET);
        Quantity<LengthUnit> inches = new Quantity<>(12, LengthUnit.INCHES);

        System.out.println("Are equal: " + demonstrateEquality(feet, inches));

        System.out.println("Converted: " +
                demonstrateConversion(feet, LengthUnit.INCHES));

        System.out.println("Addition: " +
                demonstrateAddition(feet, inches, LengthUnit.FEET));


        Quantity<WeightUnit> kg = new Quantity<>(1, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> grams = new Quantity<>(1000, WeightUnit.GRAM);

        System.out.println("Weights equal: " +
                demonstrateEquality(kg, grams));
    }
}