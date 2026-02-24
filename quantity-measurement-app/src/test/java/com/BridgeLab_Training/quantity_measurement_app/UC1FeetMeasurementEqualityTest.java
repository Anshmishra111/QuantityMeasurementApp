package com.BridgeLab_Training.quantity_measurement_app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC1FeetMeasurementEqualityTest {

    @Test
    public void testConversion_FeetToInches() {
        double result = Length.convert(1.0,
                Length.LengthUnit.FEET,
                Length.LengthUnit.INCHES);

        assertEquals(12.0, result, 0.0001);
    }

    @Test
    public void testConversion_InchesToFeet() {
        double result = Length.convert(24.0,
                Length.LengthUnit.INCHES,
                Length.LengthUnit.FEET);

        assertEquals(2.0, result, 0.0001);
    }

    @Test
    public void testConversion_YardsToInches() {
        double result = Length.convert(1.0,
                Length.LengthUnit.YARDS,
                Length.LengthUnit.INCHES);

        assertEquals(36.0, result, 0.0001);
    }

    @Test
    public void testConversion_CmToInches() {
        double result = Length.convert(2.54,
                Length.LengthUnit.CENTIMETERS,
                Length.LengthUnit.INCHES);

        assertEquals(1.0, result, 0.0001);
    }

    @Test
    public void testConversion_ZeroValue() {
        double result = Length.convert(0.0,
                Length.LengthUnit.FEET,
                Length.LengthUnit.INCHES);

        assertEquals(0.0, result);
    }

    @Test
    public void testConversion_InvalidUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            Length.convert(1.0, null, Length.LengthUnit.FEET);
        });
    }

    @Test
    public void testConversion_NaN() {
        assertThrows(IllegalArgumentException.class, () -> {
            Length.convert(Double.NaN,
                    Length.LengthUnit.FEET,
                    Length.LengthUnit.INCHES);
        });
    }
}
