package com.BridgeLab_Training.quantity_measurement_app;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.BridgeLab_Training.quantity_measurement_app.dao.*;
import com.BridgeLab_Training.quantity_measurement_app.model.*;
import com.BridgeLab_Training.quantity_measurement_app.service.*;
import com.BridgeLab_Training.quantity_measurement_app.enums.*;
import com.BridgeLab_Training.quantity_measurement_app.util.*;

public class UC1FeetMeasurementEqualityTest {

    private IQuantityMeasurementService service;

    @BeforeEach
    void setUp() {

        IQuantityMeasurementRepository repo =
                new QuantityMeasurementCacheRepository();

        service = new QuantityMeasurementServiceImpl(repo);
    }

    //  LENGTH TESTS 

    @Test
    void testLengthEqualityFeetAndInches() {

        Quantity<LengthUnit> feet =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> inches =
                new Quantity<>(12.0, LengthUnit.INCHES);

        assertTrue(feet.equals(inches));
    }

    @Test
    void testLengthConversionFeetToInches() {

        Quantity<LengthUnit> feet =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> result =
                feet.convertTo(LengthUnit.INCHES);

        assertEquals(12.0, result.getValue(), 0.01);
    }

    @Test
    void testLengthAdditionFeetAndInches() {

        Quantity<LengthUnit> feet =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> inches =
                new Quantity<>(12.0, LengthUnit.INCHES);

        Quantity<LengthUnit> result =
                feet.add(inches);

        assertEquals(2.0, result.getValue(), 0.01);
    }

    //  WEIGHT TESTS 

    @Test
    void testWeightEqualityKgAndGram() {

        Quantity<WeightUnit> kg =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> gram =
                new Quantity<>(1000.0, WeightUnit.GRAM);

        assertTrue(kg.equals(gram));
    }

    @Test
    void testWeightConversionKgToGram() {

        Quantity<WeightUnit> kg =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> result =
                kg.convertTo(WeightUnit.GRAM);

        assertEquals(1000.0, result.getValue(), 0.01);
    }

    //  VOLUME TESTS 

    @Test
    void testVolumeEqualityLitreAndMillilitre() {

        Quantity<VolumeUnit> litre =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> ml =
                new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        assertTrue(litre.equals(ml));
    }

    @Test
    void testVolumeConversionLitreToMillilitre() {

        Quantity<VolumeUnit> litre =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> result =
                litre.convertTo(VolumeUnit.MILLILITRE);

        assertEquals(1000.0, result.getValue(), 0.01);
    }

    //  TEMPERATURE TESTS 

    @Test
    void testTemperatureEqualityCelsiusAndFahrenheit() {

        Quantity<TemperatureUnit> celsius =
                new Quantity<>(0.0, TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> fahrenheit =
                new Quantity<>(32.0, TemperatureUnit.FAHRENHEIT);

        assertTrue(celsius.equals(fahrenheit));
    }

    @Test
    void testTemperatureConversionCelsiusToFahrenheit() {

        Quantity<TemperatureUnit> celsius =
                new Quantity<>(100.0, TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> result =
                celsius.convertTo(TemperatureUnit.FAHRENHEIT);

        assertEquals(212.0, result.getValue(), 0.01);
    }

    @Test
    void testTemperatureUnsupportedAddition() {

        Quantity<TemperatureUnit> t1 =
                new Quantity<>(100.0, TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> t2 =
                new Quantity<>(50.0, TemperatureUnit.CELSIUS);

        assertThrows(UnsupportedOperationException.class,
                () -> t1.add(t2));
    }

    // - GENERIC TESTS

    @Test
    void testNullUnitConstructor() {

        assertThrows(IllegalArgumentException.class,
                () -> new Quantity<>(10, null));
    }

    @Test
    void testSameObjectEquality() {

        Quantity<LengthUnit> feet =
                new Quantity<>(5.0, LengthUnit.FEET);

        assertTrue(feet.equals(feet));
    }

    @Test
    void testCrossCategoryComparison() {

        Quantity<LengthUnit> length =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<WeightUnit> weight =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        assertFalse(length.equals(weight));
    }

}