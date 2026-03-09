package com.BridgeLab_Training.quantity_measurement_app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC1FeetMeasurementEqualityTest {

    // ----------------------------
    // UC1 / UC2 Equality Tests
    // ----------------------------

    @Test
    public void testFeetEquality() {

        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(1.0, Length.LengthUnit.FEET);

        assertTrue(UC1FeetMeasurementEquality.demonstrateLengthEquality(l1, l2));
    }

    @Test
    public void testFeetInequality() {

        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(2.0, Length.LengthUnit.FEET);

        assertFalse(UC1FeetMeasurementEquality.demonstrateLengthEquality(l1, l2));
    }

    @Test
    public void testFeetAndInchesEquality() {

        assertTrue(
        		UC1FeetMeasurementEquality.demonstrateLengthComparison(
                        1.0, Length.LengthUnit.FEET,
                        12.0, Length.LengthUnit.INCHES
                )
        );
    }

    // ----------------------------
    // UC4 Additional Units
    // ----------------------------

    @Test
    public void testYardToFeetEquality() {

        assertTrue(
        		UC1FeetMeasurementEquality.demonstrateLengthComparison(
                        1.0, Length.LengthUnit.YARDS,
                        3.0, Length.LengthUnit.FEET
                )
        );
    }

    @Test
    public void testCmToInchesEquality() {
    	Length cm = new Length(2.54, Length.LengthUnit.CENTIMETERS);
        Length inch = new Length(1.0, Length.LengthUnit.INCHES);

        assertEquals(
                cm.convertTo(Length.LengthUnit.INCHES).getValue(),
                inch.getValue(),
                0.001
        
        );
    }

    // ----------------------------
    // UC5 Conversion Tests
    // ----------------------------

    @Test
    public void testConversion_FeetToInches() {

        Length result =
        		UC1FeetMeasurementEquality.demonstrateLengthConversion(
                        1.0,
                        Length.LengthUnit.FEET,
                        Length.LengthUnit.INCHES
                );

        Length expected =
                new Length(12.0, Length.LengthUnit.INCHES);

        assertTrue(UC1FeetMeasurementEquality.demonstrateLengthEquality(result, expected));
    }

    @Test
    public void testConversion_InchesToFeet() {

        Length result =
        		UC1FeetMeasurementEquality.demonstrateLengthConversion(
                        24.0,
                        Length.LengthUnit.INCHES,
                        Length.LengthUnit.FEET
                );

        Length expected =
                new Length(2.0, Length.LengthUnit.FEET);

        assertTrue(UC1FeetMeasurementEquality.demonstrateLengthEquality(result, expected));
    }

    @Test
    public void testConversion_YardsToInches() {

        Length result =
        		UC1FeetMeasurementEquality.demonstrateLengthConversion(
                        1.0,
                        Length.LengthUnit.YARDS,
                        Length.LengthUnit.INCHES
                );

        Length expected =
                new Length(36.0, Length.LengthUnit.INCHES);

        assertTrue(UC1FeetMeasurementEquality.demonstrateLengthEquality(result, expected));
    }

    @Test
    public void testConversion_CentimetersToInches() {

        Length result =
        		UC1FeetMeasurementEquality.demonstrateLengthConversion(
                        2.54,
                        Length.LengthUnit.CENTIMETERS,
                        Length.LengthUnit.INCHES
                );
        assertEquals(1.0, result.getValue(), 0.001);


//        Length expected =
//                new Length(1.0, Length.LengthUnit.INCHES);
//
//        assertTrue(UC1FeetMeasurementEquality.demonstrateLengthEquality(result, expected));
    }

    // ----------------------------
    // UC6 Addition Tests
    // ----------------------------

    @Test
    public void testAddition_SameUnit_FeetPlusFeet() {

        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(2.0, Length.LengthUnit.FEET);

        Length result =
        		UC1FeetMeasurementEquality.demonstrateLengthAddition(l1, l2);

        Length expected =
                new Length(3.0, Length.LengthUnit.FEET);

        assertTrue(UC1FeetMeasurementEquality.demonstrateLengthEquality(result, expected));
    }

    @Test
    public void testAddition_CrossUnit_FeetPlusInches() {

        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(12.0, Length.LengthUnit.INCHES);

        Length result =
        		UC1FeetMeasurementEquality.demonstrateLengthAddition(l1, l2);

        Length expected =
                new Length(2.0, Length.LengthUnit.FEET);

        assertTrue(UC1FeetMeasurementEquality.demonstrateLengthEquality(result, expected));
    }

    @Test
    public void testAddition_InchesPlusFeet() {

        Length l1 = new Length(12.0, Length.LengthUnit.INCHES);
        Length l2 = new Length(1.0, Length.LengthUnit.FEET);

        Length result =
        		UC1FeetMeasurementEquality.demonstrateLengthAddition(l1, l2);

        Length expected =
                new Length(24.0, Length.LengthUnit.INCHES);

        assertTrue(UC1FeetMeasurementEquality.demonstrateLengthEquality(result, expected));
    }

    @Test
    public void testAddition_WithZero() {

        Length l1 = new Length(5.0, Length.LengthUnit.FEET);
        Length l2 = new Length(0.0, Length.LengthUnit.INCHES);

        Length result =
        		UC1FeetMeasurementEquality.demonstrateLengthAddition(l1, l2);

        Length expected =
                new Length(5.0, Length.LengthUnit.FEET);

        assertTrue(UC1FeetMeasurementEquality.demonstrateLengthEquality(result, expected));
    }

    @Test
    public void testAddition_NegativeValues() {

        Length l1 = new Length(5.0, Length.LengthUnit.FEET);
        Length l2 = new Length(-2.0, Length.LengthUnit.FEET);

        Length result =
        		UC1FeetMeasurementEquality.demonstrateLengthAddition(l1, l2);

        Length expected =
                new Length(3.0, Length.LengthUnit.FEET);

        assertTrue(UC1FeetMeasurementEquality.demonstrateLengthEquality(result, expected));
    }
}