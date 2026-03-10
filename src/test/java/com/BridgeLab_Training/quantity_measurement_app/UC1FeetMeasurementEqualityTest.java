package com.BridgeLab_Training.quantity_measurement_app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC1FeetMeasurementEqualityTest {

    // ---------------- ADDITION ----------------

    @Test
    public void testAddition_LengthFeetAndInches() {

        Quantity<LengthUnit> q1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(12.0, LengthUnit.INCHES);

        Quantity<LengthUnit> result = q1.add(q2);

        assertEquals(2.0, result.getValue());
    }


    @Test
    public void testAddition_WeightKgAndGram() {

        Quantity<WeightUnit> q1 = new Quantity<>(10.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> q2 = new Quantity<>(5000.0, WeightUnit.GRAM);

        Quantity<WeightUnit> result = q1.add(q2);

        assertEquals(15.0, result.getValue());
    }


    @Test
    public void testAddition_VolumeLitreAndMillilitre() {

        Quantity<VolumeUnit> q1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> result = q1.add(q2);

        assertEquals(2.0, result.getValue());
    }


    // ---------------- SUBTRACTION ----------------

    @Test
    public void testSubtraction_LengthFeetMinusInches() {

        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(6.0, LengthUnit.INCHES);

        Quantity<LengthUnit> result = q1.subtract(q2);

        assertEquals(9.5, result.getValue());
    }


    @Test
    public void testSubtraction_WeightKgMinusGram() {

        Quantity<WeightUnit> q1 = new Quantity<>(10.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> q2 = new Quantity<>(2000.0, WeightUnit.GRAM);

        Quantity<WeightUnit> result = q1.subtract(q2);

        assertEquals(8.0, result.getValue());
    }


    // ---------------- DIVISION ----------------

    @Test
    public void testDivision_LengthFeetByFeet() {

        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(2.0, LengthUnit.FEET);

        double result = q1.divide(q2);

        assertEquals(5.0, result);
    }


    @Test
    public void testDivision_WeightKgByKg() {

        Quantity<WeightUnit> q1 = new Quantity<>(10.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> q2 = new Quantity<>(5.0, WeightUnit.KILOGRAM);

        double result = q1.divide(q2);

        assertEquals(2.0, result);
    }


    @Test
    public void testDivision_VolumeLitreByLitre() {

        Quantity<VolumeUnit> q1 = new Quantity<>(5.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(10.0, VolumeUnit.LITRE);

        double result = q1.divide(q2);

        assertEquals(0.5, result);
    }


    // ---------------- ERROR CASES ----------------

    @Test
    public void testDivision_ByZero() {

        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(0.0, LengthUnit.FEET);

        assertThrows(ArithmeticException.class, () -> {
            q1.divide(q2);
        });
    }


    @Test
    public void testAddition_Null() {

        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);

        assertThrows(IllegalArgumentException.class, () -> {
            q1.add(null);
        });
    }

}