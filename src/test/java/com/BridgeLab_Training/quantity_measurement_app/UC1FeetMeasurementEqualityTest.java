package com.BridgeLab_Training.quantity_measurement_app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC1FeetMeasurementEqualityTest {

   
//       WEIGHT TESTS (UC9)
       

    @Test
    public void kilogramEquals1000Grams() {

        Weight kg = new Weight(1.0, WeightUnit.KILOGRAM);
        Weight g = new Weight(1000.0, WeightUnit.GRAM);

        assertTrue(kg.equals(g));
    }

    @Test
    public void poundEquals453Point592Grams() {

        Weight pound = new Weight(1.0, WeightUnit.POUND);
        Weight grams = new Weight(453.592, WeightUnit.GRAM);

        assertTrue(pound.equals(grams));
    }

    @Test
    public void kilogramNotEqualToPound() {

        Weight kg = new Weight(1.0, WeightUnit.KILOGRAM);
        Weight pound = new Weight(1.0, WeightUnit.POUND);

        assertFalse(kg.equals(pound));
    }

    @Test
    public void additionOfWeightsEqualsExpected() {

        Weight kg = new Weight(1.0, WeightUnit.KILOGRAM);
        Weight g = new Weight(1000.0, WeightUnit.GRAM);

        Weight result = kg.add(g);

        assertTrue(result.equals(new Weight(2.0, WeightUnit.KILOGRAM)));
    }

    
//       LENGTH TESTS (UC1–UC8)
       

    @Test
    public void testFeetEquality() {

        Length f1 = new Length(1.0, LengthUnit.FEET);
        Length f2 = new Length(1.0, LengthUnit.FEET);

        assertTrue(f1.equals(f2));
    }

    @Test
    public void testInchesEquality() {

        Length i1 = new Length(12.0, LengthUnit.INCHES);
        Length f = new Length(1.0, LengthUnit.FEET);

        assertTrue(i1.equals(f));
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
    public void testCrossUnitInequality() {

        Length feet = new Length(1.0, LengthUnit.FEET);
        Length inch = new Length(1.0, LengthUnit.INCHES);

        assertFalse(feet.equals(inch));
    }

    @Test
    public void yardEquals36Inches() {

        Length yard = new Length(1.0, LengthUnit.YARDS);
        Length inches = new Length(36.0, LengthUnit.INCHES);

        assertTrue(yard.equals(inches));
    }

    
    @Test
    public void thirtyPoint48CmEqualsOneFoot() {

        Length cm = new Length(30.48, LengthUnit.CENTIMETERS);
        Length foot = new Length(1.0, LengthUnit.FEET);

        assertTrue(cm.equals(foot));
    }

    @Test
    public void convertFeetToInches() {

        Length feet = new Length(1.0, LengthUnit.FEET);
        Length result = feet.convertTo(LengthUnit.INCHES);

        assertEquals(12.0, result.getValue());
    }

    @Test
    public void addFeetAndInches() {

        Length feet = new Length(1.0, LengthUnit.FEET);
        Length inches = new Length(12.0, LengthUnit.INCHES);

        Length result = feet.add(inches);

        assertTrue(result.equals(new Length(2.0, LengthUnit.FEET)));
    }

}