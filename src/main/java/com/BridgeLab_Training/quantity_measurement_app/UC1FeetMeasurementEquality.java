package com.BridgeLab_Training.quantity_measurement_app;

public class UC1FeetMeasurementEquality {

    public static <U extends IMeasurable> boolean demonstrateEquality(
            Quantity<U> q1, Quantity<U> q2) {

        return q1.equals(q2);
    }

    public static <U extends IMeasurable> Quantity<U> demonstrateConversion(
            Quantity<U> quantity, U targetUnit) {

        double value = quantity.convertTo(targetUnit);
        return new Quantity<>(value, targetUnit);
    }

    public static <U extends IMeasurable> Quantity<U> demonstrateAddition(
            Quantity<U> q1, Quantity<U> q2) {

        return q1.add(q2);
    }

    public static <U extends IMeasurable> Quantity<U> demonstrateAddition(
            Quantity<U> q1, Quantity<U> q2, U targetUnit) {

        return q1.add(q2, targetUnit);
    }

    //  SUBTRACTION (UC12) 

    public static <U extends IMeasurable> Quantity<U> demonstrateSubtraction(
            Quantity<U> q1, Quantity<U> q2) {

        return q1.subtract(q2);
    }

    public static <U extends IMeasurable> Quantity<U> demonstrateSubtraction(
            Quantity<U> q1, Quantity<U> q2, U targetUnit) {

        return q1.subtract(q2, targetUnit);
    }

    //  DIVISION (UC12)

    public static <U extends IMeasurable> double demonstrateDivision(
            Quantity<U> q1, Quantity<U> q2) {

        return q1.divide(q2);
    }

    //  MAIN 

    public static void main(String[] args) {

        Quantity<LengthUnit> feet = new Quantity<>(10, LengthUnit.FEET);
        Quantity<LengthUnit> inches = new Quantity<>(6, LengthUnit.INCHES);

        System.out.println("Addition: " + feet.add(inches));
        System.out.println("Subtraction: " + feet.subtract(inches));
        System.out.println("Division: " + feet.divide(inches));


        Quantity<WeightUnit> kg = new Quantity<>(10, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> gram = new Quantity<>(5000, WeightUnit.GRAM);

        System.out.println("Weight Subtraction: " + kg.subtract(gram));
        System.out.println("Weight Division: " + kg.divide(gram));


        Quantity<VolumeUnit> litre = new Quantity<>(5, VolumeUnit.LITRE);
        Quantity<VolumeUnit> ml = new Quantity<>(500, VolumeUnit.MILLILITRE);

        System.out.println("Volume Subtraction: " + litre.subtract(ml));
        System.out.println("Volume Division: " + litre.divide(ml));
    }
}