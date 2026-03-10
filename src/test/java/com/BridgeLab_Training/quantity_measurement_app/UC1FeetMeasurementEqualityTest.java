package com.BridgeLab_Training.quantity_measurement_app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC1FeetMeasurementEqualityTest {

    @Test
    public void lengthFeetEqualsInches() {

        Quantity<LengthUnit> feet =
                new Quantity<>(1, LengthUnit.FEET);

        Quantity<LengthUnit> inches =
                new Quantity<>(12, LengthUnit.INCHES);

        assertTrue(feet.equals(inches));
    }

    @Test
    public void lengthYardsEqualsFeet() {

        Quantity<LengthUnit> yard =
                new Quantity<>(1, LengthUnit.YARDS);

        Quantity<LengthUnit> feet =
                new Quantity<>(3, LengthUnit.FEET);

        assertTrue(yard.equals(feet));
    }

    @Test
    public void weightKilogramEqualsGrams() {

        Quantity<WeightUnit> kg =
                new Quantity<>(1, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> grams =
                new Quantity<>(1000, WeightUnit.GRAM);

        assertTrue(kg.equals(grams));
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
}