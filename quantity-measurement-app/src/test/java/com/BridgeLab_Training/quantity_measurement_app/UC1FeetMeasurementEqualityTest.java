package com.BridgeLab_Training.quantity_measurement_app;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC1FeetMeasurementEqualityTest {

    // ✅ Yard equality

    @Test
    public void testEquality_YardToYard_SameValue() {
        Length y1 = new Length(1.0, Length.LengthUnit.YARDS);
        Length y2 = new Length(1.0, Length.LengthUnit.YARDS);

        assertTrue(y1.equals(y2));
    }

    @Test
    public void testEquality_YardToFeet() {
        Length yard = new Length(1.0, Length.LengthUnit.YARDS);
        Length feet = new Length(3.0, Length.LengthUnit.FEET);

        assertTrue(yard.equals(feet));
    }

    @Test
    public void testEquality_YardToInches() {
        Length yard = new Length(1.0, Length.LengthUnit.YARDS);
        Length inches = new Length(36.0, Length.LengthUnit.INCHES);

        assertTrue(yard.equals(inches));
    }

    // ✅ Centimeter equality

    @Test
    public void testEquality_CmToCm_SameValue() {
        Length cm1 = new Length(10.0, Length.LengthUnit.CENTIMETERS);
        Length cm2 = new Length(10.0, Length.LengthUnit.CENTIMETERS);

        assertTrue(cm1.equals(cm2));
    }

    @Test
    public void testEquality_CmToInches() {
        Length cm = new Length(1.0, Length.LengthUnit.CENTIMETERS);
        Length inches = new Length(0.393701, Length.LengthUnit.INCHES);

        assertTrue(cm.equals(inches));
    }

    @Test
    public void testEquality_CmToFeet() {
        Length cm = new Length(30.48, Length.LengthUnit.CENTIMETERS);
        Length feet = new Length(1.0, Length.LengthUnit.FEET);

        assertTrue(cm.equals(feet));
    }

    // ✅ Inequality

    @Test
    public void testEquality_YardToFeet_NotEqual() {
        Length yard = new Length(1.0, Length.LengthUnit.YARDS);
        Length feet = new Length(2.0, Length.LengthUnit.FEET);

        assertFalse(yard.equals(feet));
    }

    // ✅ Null safety

    @Test
    public void testEquality_NullComparison() {
        Length l = new Length(1.0, Length.LengthUnit.FEET);
        assertFalse(l.equals(null));
    }

    @Test
    public void testEquality_NullUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Length(1.0, null);
        });
    }
}