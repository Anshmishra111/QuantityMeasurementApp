package com.BridgeLab_Training.quantity_measurement_app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC1FeetMeasurementEqualityTest {

    //  SUBTRACTION TESTS 

    @Test
    public void testSubtraction_SameUnit_FeetMinusFeet() {

        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(5.0, LengthUnit.FEET);

        Quantity<LengthUnit> result = q1.subtract(q2);

        assertEquals(5.0, result.getValue());
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    @Test
    public void testSubtraction_CrossUnit_FeetMinusInches() {

        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(6.0, LengthUnit.INCHES);

        Quantity<LengthUnit> result = q1.subtract(q2);

        assertEquals(9.5, result.getValue());
    }

    @Test
    public void testSubtraction_ExplicitTargetUnit_Inches() {

        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(6.0, LengthUnit.INCHES);

        Quantity<LengthUnit> result = q1.subtract(q2, LengthUnit.INCHES);

        assertEquals(114.0, result.getValue());
    }

    @Test
    public void testSubtraction_ResultingNegative() {

        Quantity<LengthUnit> q1 = new Quantity<>(5.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(10.0, LengthUnit.FEET);

        Quantity<LengthUnit> result = q1.subtract(q2);

        assertEquals(-5.0, result.getValue());
    }

    @Test
    public void testSubtraction_ResultingZero() {

        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(120.0, LengthUnit.INCHES);

        Quantity<LengthUnit> result = q1.subtract(q2);

        assertEquals(0.0, result.getValue());
    }

    //  DIVISION TESTS 

    @Test
    public void testDivision_SameUnit_FeetDividedByFeet() {

        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(2.0, LengthUnit.FEET);

        double result = q1.divide(q2);

        assertEquals(5.0, result);
    }

    @Test
    public void testDivision_CrossUnit_InchesDividedByFeet() {

        Quantity<LengthUnit> q1 = new Quantity<>(24.0, LengthUnit.INCHES);
        Quantity<LengthUnit> q2 = new Quantity<>(2.0, LengthUnit.FEET);

        double result = q1.divide(q2);

        assertEquals(1.0, result);
    }

    @Test
    public void testDivision_RatioGreaterThanOne() {

        Quantity<WeightUnit> q1 = new Quantity<>(10.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> q2 = new Quantity<>(5.0, WeightUnit.KILOGRAM);

        double result = q1.divide(q2);

        assertEquals(2.0, result);
    }

    @Test
    public void testDivision_RatioLessThanOne() {

        Quantity<VolumeUnit> q1 = new Quantity<>(5.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(10.0, VolumeUnit.LITRE);

        double result = q1.divide(q2);

        assertEquals(0.5, result);
    }

    @Test
    public void testDivision_DivisionByZero() {

        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(0.0, LengthUnit.FEET);

        assertThrows(ArithmeticException.class, () -> {
            q1.divide(q2);
        });
    }

    //  CROSS CATEGORY TEST 

    @Test
    public void testSubtraction_CrossCategory() {

        Quantity<LengthUnit> length = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<WeightUnit> weight = new Quantity<>(5.0, WeightUnit.KILOGRAM);

        assertThrows(IllegalArgumentException.class, () -> {
            length.subtract((Quantity) weight);
        });
    }

}