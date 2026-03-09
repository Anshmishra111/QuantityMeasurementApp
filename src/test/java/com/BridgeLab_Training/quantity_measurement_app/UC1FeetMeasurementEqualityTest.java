package com.BridgeLab_Training.quantity_measurement_app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC1FeetMeasurementEqualityTest {

    // ---------- Equality Tests ----------

    @Test
    public void testFeetEquality() {
        Length f1 = new Length(1.0, LengthUnit.FEET);
        Length f2 = new Length(1.0, LengthUnit.FEET);

        assertTrue(f1.equals(f2));
    }

    @Test
    public void testInchesEquality() {
        Length i1 = new Length(12.0, LengthUnit.INCHES);
        Length i2 = new Length(12.0, LengthUnit.INCHES);

        assertTrue(i1.equals(i2));
    }

    @Test
    public void testFeetInchesComparison() {
        Length feet = new Length(1.0, LengthUnit.FEET);
        Length inches = new Length(12.0, LengthUnit.INCHES);

        assertTrue(feet.equals(inches));
    }

    @Test
    public void testFeetInequality() {
        Length f1 = new Length(1.0, LengthUnit.FEET);
        Length f2 = new Length(2.0, LengthUnit.FEET);

        assertFalse(f1.equals(f2));
    }

    @Test
    public void testInchesInequality() {
        Length i1 = new Length(10.0, LengthUnit.INCHES);
        Length i2 = new Length(12.0, LengthUnit.INCHES);

        assertFalse(i1.equals(i2));
    }

    @Test
    public void testCrossUnitInequality() {
        Length feet = new Length(1.0, LengthUnit.FEET);
        Length inches = new Length(10.0, LengthUnit.INCHES);

        assertFalse(feet.equals(inches));
    }

    // ---------- More Equality Cases ----------

    @Test
    public void testMultipleFeetComparison() {
        Length f1 = new Length(2.0, LengthUnit.FEET);
        Length f2 = new Length(24.0, LengthUnit.INCHES);

        assertTrue(f1.equals(f2));
    }

    @Test
    public void yardEquals36Inches() {
        Length yard = new Length(1.0, LengthUnit.YARDS);
        Length inches = new Length(36.0, LengthUnit.INCHES);

        assertTrue(yard.equals(inches));
    }

    @Test
    public void centimeterEquals39Point3701Inches() {
        Length cm = new Length(100.0, LengthUnit.CENTIMETERS);
        Length inches = new Length(39.3701, LengthUnit.INCHES);

        assertTrue(cm.equals(inches));
    }

    @Test
    public void threeFeetEqualsOneYard() {
        Length feet = new Length(3.0, LengthUnit.FEET);
        Length yard = new Length(1.0, LengthUnit.YARDS);

        assertTrue(feet.equals(yard));
    }

    @Test
    public void thirtyPoint48CmEqualsOneFoot() {
        Length cm = new Length(30.48, LengthUnit.CENTIMETERS);
        Length foot = new Length(1.0, LengthUnit.FEET);

        assertTrue(cm.equals(foot));
    }

    @Test
    public void yardNotEqualToInches() {
        Length yard = new Length(1.0, LengthUnit.YARDS);
        Length inches = new Length(35.0, LengthUnit.INCHES);

        assertFalse(yard.equals(inches));
    }

    // ---------- Object Behavior ----------

    @Test
    public void referenceEqualitySameObject() {
        Length length = new Length(5.0, LengthUnit.FEET);

        assertTrue(length.equals(length));
    }

    @Test
    public void equalsReturnsFalseForNull() {
        Length length = new Length(5.0, LengthUnit.FEET);

        assertFalse(length.equals(null));
    }

    @Test
    public void reflexiveSymmetricAndTransitiveProperty() {

        Length a = new Length(1.0, LengthUnit.FEET);
        Length b = new Length(12.0, LengthUnit.INCHES);
        Length c = new Length(30.48, LengthUnit.CENTIMETERS);

        assertTrue(a.equals(b));
        assertTrue(b.equals(c));
        assertTrue(a.equals(c));
    }
//    public void reflexiveSymmetricAndTransitiveProperty() {
//
//        Length a = new Length(1.0, LengthUnit.FEET);
//        Length b = new Length(12.0, LengthUnit.INCHES);
//        Length c = new Length(0.3333, LengthUnit.YARDS);
//
//        assertTrue(a.equals(b));
//        assertTrue(b.equals(c));
//        assertTrue(a.equals(c));
    

    @Test
    public void differentValuesSameUnitNotEqual() {
        Length a = new Length(1.0, LengthUnit.FEET);
        Length b = new Length(2.0, LengthUnit.FEET);

        assertFalse(a.equals(b));
    }

    // ---------- Conversion Tests ----------

    @Test
    public void convertFeetToInches() {

        Length result =
        		UC1FeetMeasurementEquality.demonstrateLengthConversion(
                        1.0,
                        LengthUnit.FEET,
                        LengthUnit.INCHES
                );

        assertEquals(12.0, result.getValue(), 0.001);
    }

    @Test
    public void convertYardsToInchesUsingOverloadedMethod() {

        Length yard = new Length(1.0, LengthUnit.YARDS);

        Length result =
        		UC1FeetMeasurementEquality.demonstrateLengthConversion(
                        yard,
                        LengthUnit.INCHES
                );

        assertEquals(36.0, result.getValue(), 0.001);
    }

    // ---------- Addition UC6 ----------

    @Test
    public void addFeetAndInches() {

        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);

        Length sumLength =
        		UC1FeetMeasurementEquality.demonstrateLengthAddition(
                        length1,
                        length2
                );

        Length expected = new Length(2.0, LengthUnit.FEET);

        assertTrue(
        		UC1FeetMeasurementEquality.demonstrateLengthEquality(
                        sumLength,
                        expected
                )
        );
    }

    // ---------- Addition UC7 ----------

    @Test
    public void addFeetAndInchesWithTargetUnitInches() {

        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);

        Length result =
        		UC1FeetMeasurementEquality.demonstrateLengthAddition(
                        length1,
                        length2,
                        LengthUnit.INCHES
                );

        assertEquals(24.0, result.getValue(), 0.001);
    }
}