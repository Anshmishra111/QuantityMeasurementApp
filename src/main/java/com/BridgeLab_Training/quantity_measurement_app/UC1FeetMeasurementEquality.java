package com.BridgeLab_Training.quantity_measurement_app;

public class UC1FeetMeasurementEquality {

    public static <U extends IMeasurable> boolean demonstrateEquality(
            Quantity<U> q1, Quantity<U> q2) {
        return q1.equals(q2);
    }

    public static <U extends IMeasurable> Quantity<U> demonstrateConversion(
            Quantity<U> quantity, U targetUnit) {

        double convertedValue = quantity.convertTo(targetUnit);
        return new Quantity<>(convertedValue, targetUnit);
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

        // LENGTH
        Quantity<LengthUnit> feet = new Quantity<>(1, LengthUnit.FEET);
        Quantity<LengthUnit> inches = new Quantity<>(12, LengthUnit.INCHES);

        System.out.println("Length equality: " +
                demonstrateEquality(feet, inches));

        System.out.println("Feet to Inches: " +
                demonstrateConversion(feet, LengthUnit.INCHES));

        System.out.println("Feet + Inches: " +
                demonstrateAddition(feet, inches, LengthUnit.FEET));


        // WEIGHT
        Quantity<WeightUnit> kg = new Quantity<>(1, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> grams = new Quantity<>(1000, WeightUnit.GRAM);

        System.out.println("Weight equality: " +
                demonstrateEquality(kg, grams));

        System.out.println("Kg to Gram: " +
                demonstrateConversion(kg, WeightUnit.GRAM));


        // VOLUME (UC11)
        Quantity<VolumeUnit> litre =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> ml =
                new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> gallon =
                new Quantity<>(1.0, VolumeUnit.GALLON);

        System.out.println("Volume equality (1L == 1000mL): " +
                demonstrateEquality(litre, ml));

        System.out.println("1 Litre to mL: " +
                demonstrateConversion(litre, VolumeUnit.MILLILITRE));

        System.out.println("1 Gallon to Litre: " +
                demonstrateConversion(gallon, VolumeUnit.LITRE));

        System.out.println("1L + 1000mL: " +
                demonstrateAddition(litre, ml, VolumeUnit.LITRE));
    }
}