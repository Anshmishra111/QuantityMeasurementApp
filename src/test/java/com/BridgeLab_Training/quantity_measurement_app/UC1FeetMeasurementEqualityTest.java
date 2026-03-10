package com.BridgeLab_Training.quantity_measurement_app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC1FeetMeasurementEqualityTest {

    // LENGTH TESTS 

    @Test
    public void lengthFeetEqualsInches() {

        Quantity<LengthUnit> feet =
                new Quantity<>(1, LengthUnit.FEET);

        Quantity<LengthUnit> inches =
                new Quantity<>(12, LengthUnit.INCHES);

        assertTrue(feet.equals(inches));
    }

    @Test
    public void convertLengthFeetToInches() {

        Quantity<LengthUnit> feet =
                new Quantity<>(1, LengthUnit.FEET);

        double result = feet.convertTo(LengthUnit.INCHES);

        assertEquals(12, result);
    }

    @Test
    public void addLengthFeetAndInches() {

        Quantity<LengthUnit> feet =
                new Quantity<>(1, LengthUnit.FEET);

        Quantity<LengthUnit> inches =
                new Quantity<>(12, LengthUnit.INCHES);

        Quantity<LengthUnit> result =
                feet.add(inches, LengthUnit.FEET);

        assertEquals(2, result.getValue());
    }

    //  WEIGHT TESTS 

    @Test
    public void weightKilogramEqualsGrams() {

        Quantity<WeightUnit> kg =
                new Quantity<>(1, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> grams =
                new Quantity<>(1000, WeightUnit.GRAM);

        assertTrue(kg.equals(grams));
    }

    @Test
    public void convertWeightKilogramsToGrams() {

        Quantity<WeightUnit> kg =
                new Quantity<>(1, WeightUnit.KILOGRAM);

        double result = kg.convertTo(WeightUnit.GRAM);

        assertEquals(1000, result);
    }

    @Test
    public void addWeightKilogramsAndGrams() {

        Quantity<WeightUnit> kg =
                new Quantity<>(1, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> grams =
                new Quantity<>(1000, WeightUnit.GRAM);

        Quantity<WeightUnit> result =
                kg.add(grams, WeightUnit.KILOGRAM);

        assertEquals(2, result.getValue());
    }

    //  VOLUME TESTS (UC11) 

    @Test
    public void volumeLiterEqualsMilliliters() {

        Quantity<VolumeUnit> litre =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> ml =
                new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        assertTrue(litre.equals(ml));
    }

    @Test
    public void volumeLiterEqualsGallon() {

        Quantity<VolumeUnit> litre =
                new Quantity<>(3.78541, VolumeUnit.LITRE);

        Quantity<VolumeUnit> gallon =
                new Quantity<>(1.0, VolumeUnit.GALLON);

        assertTrue(litre.equals(gallon));
    }

    @Test
    public void convertLiterToMilliliter() {

        Quantity<VolumeUnit> litre =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        double result = litre.convertTo(VolumeUnit.MILLILITRE);

        assertEquals(1000.0, result);
    }

    @Test
    public void convertGallonToLiter() {

        Quantity<VolumeUnit> gallon =
                new Quantity<>(1.0, VolumeUnit.GALLON);

        double result = gallon.convertTo(VolumeUnit.LITRE);

        assertEquals(3.78541, result, 0.0001);
    }

    @Test
    public void addLiterAndMilliliter() {

        Quantity<VolumeUnit> litre =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> ml =
                new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> result =
                litre.add(ml, VolumeUnit.LITRE);

        assertEquals(2.0, result.getValue());
    }

    @Test
    public void addGallonAndLiter() {

        Quantity<VolumeUnit> gallon =
                new Quantity<>(1.0, VolumeUnit.GALLON);

        Quantity<VolumeUnit> litre =
                new Quantity<>(3.78541, VolumeUnit.LITRE);

        Quantity<VolumeUnit> result =
                gallon.add(litre, VolumeUnit.GALLON);

        assertEquals(2.0, result.getValue(), 0.001);
    }

    //  CROSS CATEGORY TEST 

    @Test
    public void volumeVsLengthShouldNotBeEqual() {

        Quantity<VolumeUnit> litre =
                new Quantity<>(1, VolumeUnit.LITRE);

        Quantity<LengthUnit> feet =
                new Quantity<>(1, LengthUnit.FEET);

        assertFalse(litre.equals(feet));
    }

}