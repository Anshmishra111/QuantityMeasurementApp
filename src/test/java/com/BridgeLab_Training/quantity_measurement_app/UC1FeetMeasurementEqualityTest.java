package com.BridgeLab_Training.quantity_measurement_app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC1FeetMeasurementEqualityTest {

    @Test
    public void testFeetEquality() {

        Length f1 = new Length(1.0, Length.LengthUnit.FEET);
        Length f2 = new Length(1.0, Length.LengthUnit.FEET);

        assertTrue(f1.equals(f2));
    }

    @Test
    public void testInchesEquality() {

        Length i1 = new Length(12.0, Length.LengthUnit.INCHES);
        Length i2 = new Length(12.0, Length.LengthUnit.INCHES);

        assertTrue(i1.equals(i2));
    }

    @Test
    public void testFeetInchesComparison() {

        Length feet = new Length(1.0, Length.LengthUnit.FEET);
        Length inches = new Length(12.0, Length.LengthUnit.INCHES);

        assertTrue(feet.equals(inches));
    }

    @Test
    public void testFeetInequality() {

        Length f1 = new Length(1.0, Length.LengthUnit.FEET);
        Length f2 = new Length(2.0, Length.LengthUnit.FEET);

        assertFalse(f1.equals(f2));
    }

    @Test
    public void testInchesInequality() {

        Length i1 = new Length(10.0, Length.LengthUnit.INCHES);
        Length i2 = new Length(12.0, Length.LengthUnit.INCHES);

        assertFalse(i1.equals(i2));
    }

    @Test
    public void testCrossUnitInequality() {

        Length feet = new Length(1.0, Length.LengthUnit.FEET);
        Length inches = new Length(10.0, Length.LengthUnit.INCHES);

        assertFalse(feet.equals(inches));
    }

    @Test
    public void testConversion_FeetToInches() {

        Length result =
        		UC1FeetMeasurementEquality.demonstrateLengthConversion(
                        1.0,
                        Length.LengthUnit.FEET,
                        Length.LengthUnit.INCHES
                );

        assertEquals(12.0, result.getValue(), 0.001);
    }

    @Test
    public void testConversion_YardsToInches() {

        Length result =
        		UC1FeetMeasurementEquality.demonstrateLengthConversion(
                        1.0,
                        Length.LengthUnit.YARDS,
                        Length.LengthUnit.INCHES
                );

        assertEquals(36.0, result.getValue(), 0.001);
    }

    @Test
    public void testAddition_SameUnit_FeetPlusFeet() {

        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(2.0, Length.LengthUnit.FEET);

        Length result =
        		UC1FeetMeasurementEquality.demonstrateLengthAddition(l1, l2);

        Length expected =
                new Length(3.0, Length.LengthUnit.FEET);

        assertTrue(expected.equals(result));
    }

    @Test
    public void testAddition_CrossUnit_FeetPlusInches() {

        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(12.0, Length.LengthUnit.INCHES);

        Length result =
        		UC1FeetMeasurementEquality.demonstrateLengthAddition(l1, l2);

        Length expected =
                new Length(2.0, Length.LengthUnit.FEET);

        assertTrue(expected.equals(result));
    }

    @Test
    public void testAddition_WithZero() {

        Length l1 = new Length(5.0, Length.LengthUnit.FEET);
        Length l2 = new Length(0.0, Length.LengthUnit.INCHES);

        Length result =
        		UC1FeetMeasurementEquality.demonstrateLengthAddition(l1, l2);

        Length expected =
                new Length(5.0, Length.LengthUnit.FEET);

        assertTrue(expected.equals(result));
    }

    @Test
    public void testAddition_NegativeValues() {

        Length l1 = new Length(5.0, Length.LengthUnit.FEET);
        Length l2 = new Length(-2.0, Length.LengthUnit.FEET);

        Length result =
        		UC1FeetMeasurementEquality.demonstrateLengthAddition(l1, l2);

        Length expected =
                new Length(3.0, Length.LengthUnit.FEET);

        assertTrue(expected.equals(result));
    }
}