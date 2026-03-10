package com.BridgeLab_Training.quantity_measurement_app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC1FeetMeasurementEqualityTest {

    //  LENGTH TESTS 

    @Test
    void lengthFeetEqualsInches() {

        Quantity<LengthUnit> feet =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> inches =
                new Quantity<>(12.0, LengthUnit.INCHES);

        assertTrue(feet.equals(inches));
    }

    @Test
    void convertLengthFeetToInches() {

        Quantity<LengthUnit> feet =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> result =
                feet.convertTo(LengthUnit.INCHES);

        assertEquals(12.0, result.getValue(), 0.01);
    }



    //  WEIGHT TESTS 
    @Test
    void weightKilogramEqualsGram() {

        Quantity<WeightUnit> kg =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> gram =
                new Quantity<>(1000.0, WeightUnit.GRAM);

        assertTrue(kg.equals(gram));
    }

    @Test
    void convertWeightKgToGram() {

        Quantity<WeightUnit> kg =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> result =
                kg.convertTo(WeightUnit.GRAM);

        assertEquals(1000.0, result.getValue(), 0.01);
    }



    //  VOLUME TESTS 

    @Test
    void volumeLitreEqualsMillilitre() {

        Quantity<VolumeUnit> litre =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> ml =
                new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        assertTrue(litre.equals(ml));
    }

    @Test
    void convertVolumeLitreToMillilitre() {

        Quantity<VolumeUnit> litre =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> result =
                litre.convertTo(VolumeUnit.MILLILITRE);

        assertEquals(1000.0, result.getValue(), 0.01);
    }



    //  TEMPERATURE TESTS 

    @Test
    void temperatureEqualityCelsiusToFahrenheit() {

        Quantity<TemperatureUnit> celsius =
                new Quantity<>(0.0, TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> fahrenheit =
                new Quantity<>(32.0, TemperatureUnit.FAHRENHEIT);

        assertTrue(celsius.equals(fahrenheit));
    }

    @Test
    void temperatureConversionCelsiusToFahrenheit() {

        Quantity<TemperatureUnit> celsius =
                new Quantity<>(100.0, TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> result =
                celsius.convertTo(TemperatureUnit.FAHRENHEIT);

        assertEquals(212.0, result.getValue(), 0.01);
    }

    @Test
    void temperatureUnsupportedAddition() {

        Quantity<TemperatureUnit> t1 =
                new Quantity<>(100.0, TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> t2 =
                new Quantity<>(50.0, TemperatureUnit.CELSIUS);

        assertThrows(UnsupportedOperationException.class,
                () -> t1.add(t2));
    }



    // CROSS CATEGORY TEST 

    @Test
    void preventCrossTypeComparison() {

        Quantity<LengthUnit> length =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<WeightUnit> weight =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        assertFalse(length.equals(weight));
    }
}