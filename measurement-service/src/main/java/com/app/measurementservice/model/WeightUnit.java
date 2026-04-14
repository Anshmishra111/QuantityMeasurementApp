package com.app.measurementservice.model;

public enum WeightUnit implements IMeasurable {
    MILLIGRAM(0.001),
    GRAM(1.0),
    KILOGRAM(1000.0),
    POUND(453.592),
    TONNE(1_000_000.0);

    private final double conversionValue;

    WeightUnit(double conversionValue) { this.conversionValue = conversionValue; }

    @Override public double getConversionValue()           { return conversionValue; }
    @Override public double convertToBaseUnit(double v)    { return v * conversionValue; }
    @Override public double convertFromBaseUnit(double b)  { return b / conversionValue; }
    @Override public String getUnitName()                  { return this.name(); }
    @Override public String getMeasurementType()           { return this.getClass().getSimpleName(); }

    @Override
    public IMeasurable getUnitInstance(String unitName) {
        for (WeightUnit u : WeightUnit.values())
            if (u.getUnitName().equalsIgnoreCase(unitName)) return u;
        throw new IllegalArgumentException("Invalid weight unit: " + unitName);
    }
}
