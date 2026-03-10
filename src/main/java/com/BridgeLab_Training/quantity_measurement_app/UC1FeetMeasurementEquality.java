package com.BridgeLab_Training.quantity_measurement_app;

public class UC1FeetMeasurementEquality {

    
//       WEIGHT METHODS (UC9)


    public static boolean demonstrateWeightEquality(Weight w1, Weight w2) {
        return w1.equals(w2);
    }

    public static boolean demonstrateWeightComparison(
            double value1, WeightUnit unit1,
            double value2, WeightUnit unit2) {

        Weight w1 = new Weight(value1, unit1);
        Weight w2 = new Weight(value2, unit2);

        return w1.equals(w2);
    }

    public static Weight demonstrateWeightConversion(
            double value,
            WeightUnit fromUnit,
            WeightUnit toUnit) {

        Weight weight = new Weight(value, fromUnit);
        return weight.convertTo(toUnit);
    }

    public static Weight demonstrateWeightConversion(
            Weight weight,
            WeightUnit toUnit) {

        return weight.convertTo(toUnit);
    }

    public static Weight demonstrateWeightAddition(
            Weight weight1,
            Weight weight2) {

        return weight1.add(weight2);
    }

    public static Weight demonstrateWeightAddition(
            Weight weight1,
            Weight weight2,
            WeightUnit targetUnit) {

        return weight1.add(weight2, targetUnit);
    }

    
//       LENGTH METHODS (UC1–UC8)
       

    public static boolean demonstrateLengthEquality(Length length1, Length length2) {
        return length1.equals(length2);
    }

    public static boolean demonstrateLengthComparison(
            double value1, LengthUnit unit1,
            double value2, LengthUnit unit2) {

        Length l1 = new Length(value1, unit1);
        Length l2 = new Length(value2, unit2);

        return l1.equals(l2);
    }

    public static Length demonstrateLengthConversion(
            double value,
            LengthUnit fromUnit,
            LengthUnit toUnit) {

        Length length = new Length(value, fromUnit);
        return length.convertTo(toUnit);
    }

    public static Length demonstrateLengthConversion(
            Length length,
            LengthUnit toUnit) {

        return length.convertTo(toUnit);
    }

    public static Length demonstrateLengthAddition(
            Length length1,
            Length length2) {

        return length1.add(length2);
    }

    public static Length demonstrateLengthAddition(
            Length length1,
            Length length2,
            LengthUnit targetUnit) {

        return length1.add(length2, targetUnit);
    }

    

    public static void main(String[] args) {

        System.out.println("===== LENGTH TEST =====");

        Length l1 = new Length(1, LengthUnit.FEET);
        Length l2 = new Length(12, LengthUnit.INCHES);

        System.out.println("Are equal: " + demonstrateLengthEquality(l1, l2));

        Length resultLength = demonstrateLengthAddition(l1, l2);
        System.out.println("Length addition: " + resultLength);


        System.out.println("\n===== WEIGHT TEST =====");

        Weight w1 = new Weight(1, WeightUnit.KILOGRAM);
        Weight w2 = new Weight(1000, WeightUnit.GRAM);

        System.out.println("Are equal: " + demonstrateWeightEquality(w1, w2));

        Weight resultWeight = demonstrateWeightAddition(w1, w2);
        System.out.println("Weight addition: " + resultWeight);
    }
}