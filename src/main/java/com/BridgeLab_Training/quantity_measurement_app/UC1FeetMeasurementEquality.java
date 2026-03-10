package com.BridgeLab_Training.quantity_measurement_app;

public class UC1FeetMeasurementEquality {

    public static void main(String[] args) {

        System.out.println("===== Quantity Measurement Application =====");

        //  LENGTH DEMO 
        System.out.println("\n--- Length Operations ---");

        Quantity<LengthUnit> length1 =
                new Quantity<>(10.0, LengthUnit.FEET);

        Quantity<LengthUnit> length2 =
                new Quantity<>(120.0, LengthUnit.INCHES);

        System.out.println("10 feet == 120 inches: " + length1.equals(length2));

        Quantity<LengthUnit> convertedLength =
                length1.convertTo(LengthUnit.INCHES);

        System.out.println("10 feet in inches: " + convertedLength);

        Quantity<LengthUnit> lengthAdd =
                length1.add(new Quantity<>(12.0, LengthUnit.INCHES));

        System.out.println("10 feet + 12 inches: " + lengthAdd);



        //  WEIGHT DEMO 
        System.out.println("\n--- Weight Operations ---");

        Quantity<WeightUnit> weight1 =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> weight2 =
                new Quantity<>(1000.0, WeightUnit.GRAM);

        System.out.println("1 kg == 1000 g: " + weight1.equals(weight2));

        Quantity<WeightUnit> convertedWeight =
                weight1.convertTo(WeightUnit.GRAM);

        System.out.println("1 kg in grams: " + convertedWeight);

        Quantity<WeightUnit> weightAdd =
                weight1.add(new Quantity<>(500.0, WeightUnit.GRAM));

        System.out.println("1 kg + 500 g: " + weightAdd);



        //  VOLUME DEMO 
        System.out.println("\n--- Volume Operations ---");

        Quantity<VolumeUnit> volume1 =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> volume2 =
                new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        System.out.println("1 L == 1000 mL: " + volume1.equals(volume2));

        Quantity<VolumeUnit> convertedVolume =
                volume1.convertTo(VolumeUnit.MILLILITRE);

        System.out.println("1 L in mL: " + convertedVolume);

        Quantity<VolumeUnit> volumeAdd =
                volume1.add(new Quantity<>(500.0, VolumeUnit.MILLILITRE));

        System.out.println("1 L + 500 mL: " + volumeAdd);



        // ---------------- TEMPERATURE DEMO ----------------
        System.out.println("\n--- Temperature Operations ---");

        Quantity<TemperatureUnit> temp1 =
                new Quantity<>(0.0, TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> temp2 =
                new Quantity<>(32.0, TemperatureUnit.FAHRENHEIT);

        System.out.println("0°C == 32°F: " + temp1.equals(temp2));

        Quantity<TemperatureUnit> boiling =
                new Quantity<>(100.0, TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> fahrenheit =
                boiling.convertTo(TemperatureUnit.FAHRENHEIT);

        System.out.println("100°C = " + fahrenheit.getValue() + "°F");


        // Unsupported Arithmetic Example
        try {
            temp1.add(new Quantity<>(10.0, TemperatureUnit.CELSIUS));
        } catch (UnsupportedOperationException e) {
            System.out.println("Temperature arithmetic not supported: "
                    + e.getMessage());
        }

        System.out.println("\n===== Application Completed =====");
    }
}