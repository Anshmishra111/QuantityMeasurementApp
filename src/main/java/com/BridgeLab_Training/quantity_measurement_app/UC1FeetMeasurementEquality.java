package com.BridgeLab_Training.quantity_measurement_app;

public class UC1FeetMeasurementEquality {

    public static void main(String[] args) {

        System.out.println("===== Quantity Measurement Application (UC13) =====");

        // ---------------- LENGTH DEMO ----------------
        System.out.println("\n--- Length Operations ---");

        Quantity<LengthUnit> length1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> length2 = new Quantity<>(12.0, LengthUnit.INCHES);

        // Equality
        System.out.println("Equality (10 feet == 120 inches): "
                + length1.equals(new Quantity<>(120.0, LengthUnit.INCHES)));

        // Conversion
        Quantity<LengthUnit> lengthConverted = length1.convertTo(LengthUnit.INCHES);
        System.out.println("10 feet in inches: " + lengthConverted);

        // Addition
        Quantity<LengthUnit> lengthAdd = length1.add(length2);
        System.out.println("Addition (10 ft + 12 in): " + lengthAdd);

        // Subtraction
        Quantity<LengthUnit> lengthSub = length1.subtract(length2);
        System.out.println("Subtraction (10 ft - 12 in): " + lengthSub);

        // Division
        double lengthDiv = length1.divide(new Quantity<>(2.0, LengthUnit.FEET));
        System.out.println("Division (10 ft / 2 ft): " + lengthDiv);



        // ---------------- WEIGHT DEMO ----------------
        System.out.println("\n--- Weight Operations ---");

        Quantity<WeightUnit> weight1 = new Quantity<>(10.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> weight2 = new Quantity<>(5000.0, WeightUnit.GRAM);

        // Equality
        System.out.println("Equality (1 kg == 1000 g): "
                + new Quantity<>(1.0, WeightUnit.KILOGRAM)
                .equals(new Quantity<>(1000.0, WeightUnit.GRAM)));

        // Conversion
        Quantity<WeightUnit> weightConverted = weight1.convertTo(WeightUnit.GRAM);
        System.out.println("10 kg in grams: " + weightConverted);

        // Addition
        Quantity<WeightUnit> weightAdd = weight1.add(weight2);
        System.out.println("Addition (10 kg + 5000 g): " + weightAdd);

        // Subtraction
        Quantity<WeightUnit> weightSub = weight1.subtract(weight2);
        System.out.println("Subtraction (10 kg - 5000 g): " + weightSub);

        // Division
        double weightDiv = weight1.divide(new Quantity<>(5.0, WeightUnit.KILOGRAM));
        System.out.println("Division (10 kg / 5 kg): " + weightDiv);



        // ---------------- VOLUME DEMO ----------------
        System.out.println("\n--- Volume Operations ---");

        Quantity<VolumeUnit> volume1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> volume2 = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        // Equality
        System.out.println("Equality (1 L == 1000 mL): "
                + volume1.equals(volume2));

        // Conversion
        Quantity<VolumeUnit> volumeConverted = volume1.convertTo(VolumeUnit.MILLILITRE);
        System.out.println("1 L in mL: " + volumeConverted);

        // Addition
        Quantity<VolumeUnit> volumeAdd = volume1.add(volume2);
        System.out.println("Addition (1 L + 1000 mL): " + volumeAdd);

        // Subtraction
        Quantity<VolumeUnit> volumeSub = volume1.subtract(volume2);
        System.out.println("Subtraction (1 L - 1000 mL): " + volumeSub);

        // Division
        double volumeDiv = volume1.divide(new Quantity<>(0.5, VolumeUnit.LITRE));
        System.out.println("Division (1 L / 0.5 L): " + volumeDiv);

        System.out.println("\n===== Application Completed Successfully =====");
    }
}