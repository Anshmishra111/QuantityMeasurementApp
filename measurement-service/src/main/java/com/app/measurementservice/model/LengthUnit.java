package com.app.measurementservice.model;

public enum LengthUnit implements IMeasurable {
    FEET(12.0),
    INCHES(1.0),
    YARDS(36.0),
    CENTIMETERS(0.393701);

    private final double conversionFactor;

    LengthUnit(double conversionFactor) { this.conversionFactor = conversionFactor; }

    @Override public double getConversionValue()           { return conversionFactor; }
    @Override public double convertToBaseUnit(double v)    { return v * conversionFactor; }
    @Override public double convertFromBaseUnit(double b)  { return b / conversionFactor; }
    @Override public String getUnitName()                  { return this.name(); }
    @Override public String getMeasurementType()           { return this.getClass().getSimpleName(); }

    @Override
    public IMeasurable getUnitInstance(String unitName) {
        for (LengthUnit u : LengthUnit.values())
            if (u.getUnitName().equalsIgnoreCase(unitName)) return u;
        throw new IllegalArgumentException("Invalid length unit: " + unitName);
    }
}
